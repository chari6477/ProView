#!/usr/bin/python

import tkinter as tk
import datetime
from tkinter.filedialog import *
from subprocess import *
from os import path
import configparser
import webbrowser
import math
from tkinter import messagebox

# Variables

configFileName = 'wizardConfig.ini'
categoriesList = []
testList = []
testCBs = []
testVars = []
selectCatVars = []
selectCatCBs = []
selectCatPrevStates = []
androidDevices = []

# Classes

class Category:

	def __init__(self, name, var, tests):
		self.name = name
		self.var = var
		self.tests = tests
		self.prevState = IntVar(False)

	def deselect(self):
		self.var.set(False)
		self.prevState.set(False)
		for test in range(0, len(self.tests)):
			self.tests[test].deselect()


	def select(self):
		self.var.set(True)
		self.prevState.set(True)
		for test in range(0, len(self.tests)):
			self.tests[test].select()

	def addTest(self, test):
		self.tests.append(test)


class Test:

	def __init__(self, name, var, methods):
		self.name = name
		self.var = var
		self.methods = methods
		self.prevState = IntVar(False)

	def deselect(self):
		self.var.set(False)
		self.prevState.set(False)
		for method in range(0, len(self.methods)):
			self.methods[method].deselect()

	def select(self):
		self.var.set(True)
		self.prevState.set(True)
		for method in range(0, len(self.methods)):
			self.methods[method].select()

	def addMethod(self, method):
		self.methods.append(method)

class Method:

	def __init__(self, name, var):
		self.name = name
		self.var = var
		self.prevState = IntVar(False)

	def deselect(self):
		self.var.set(False)
		self.prevState.set(False)

	def select(self):
		self.var.set(True)
		self.prevState.set(True)

class toggleFrame(tk.Frame):

    def __init__(self, parent, text='',**options):

        tk.Frame.__init__(self, parent, **options)
        self.show=tk.BooleanVar()
        self.show.set(False)
        self.titleFrame=tk.Frame(self)
        self.titleFrame.pack(fill=tk.X, expand=1)
        tk.Label(self.titleFrame, text=text).pack(side=tk.LEFT, fill=tk.X, expand=1)
        self.toggleButton=tk.Button(self.titleFrame, width=2, text='+', command=self.toggle)
        self.toggleButton.pack(side=tk.LEFT)
        self.subFrame=tk.Frame(self, relief=tk.SUNKEN,borderwidth=1)

    def toggle(self):

        if self.show:
            self.subFrame.pack(fill=tk.X, expand=1)
            self.toggleButton.configure(text='-')
        else:
            self.subFrame.forget()
            self.toggleButton.configure(text='+')

        self.show = not self.show

class testToggleFrame(tk.Frame):

    def __init__(self, parent, text='',**options):

        tk.Frame.__init__(self, parent, **options)
        self.show=tk.BooleanVar()
        self.show.set(False)
        self.titleFrame=tk.Frame(self)
        self.titleFrame.pack(fill=tk.X, expand=1)
        tk.Label(self.titleFrame, text=text).pack(side=tk.RIGHT, fill=tk.X, expand=1)
        self.toggleButton=tk.Label(self.titleFrame, text='▲')
        self.toggleButton.bind("<Button-1>", self.toggle)
        self.toggleButton.pack(side=tk.LEFT)
        self.cb=tk.Checkbutton(self.titleFrame, text='', command=self.toggleCheckVar)
        self.cb.pack(side=tk.LEFT)
        self.subFrame=tk.Frame(self, relief=tk.SUNKEN, borderwidth=1)

    def toggle(self, event):

        if self.show:
            self.subFrame.pack(fill=tk.X, expand=1)
            self.toggleButton.configure(text='▼')
        else:
            self.subFrame.forget()
            self.toggleButton.configure(text='▲')

        self.show = not self.show

    def setCheckVar(self, var):
    	self.checked = var
    	self.cb.configure(variable=var)

    def toggleCheckVar(self):
    	
    	children = self.subFrame.winfo_children()
    	if self.checked.get():
    		for i in range(0, len(children)):
    			children[i].select()
    	else:
    		for i in range(0, len(children)):
    			children[i].deselect()

    def select(self):

    	children = self.subFrame.winfo_children()
    	for i in range(0, len(children)):
    		children[i].select()

    def deselect(self):

    	children = self.subFrame.winfo_children()
    	for i in range(0, len(children)):
    		children[i].deselect()

class VerticalScrolledFrame(Frame):

    def __init__(self, parent, *args, **kw):
        Frame.__init__(self, parent, *args, **kw)            

        # create a canvas object and a vertical scrollbar for scrolling it
        vscrollbar = Scrollbar(self, orient=VERTICAL)
        vscrollbar.pack(fill=Y, side=RIGHT, expand=FALSE)
        canvas = Canvas(self, bd=0, highlightthickness=0,
                        yscrollcommand=vscrollbar.set)
        canvas.pack(side=LEFT, fill=BOTH, expand=TRUE)
        vscrollbar.config(command=canvas.yview)

        # reset the view
        canvas.xview_moveto(0)
        canvas.yview_moveto(0)

        # create a frame inside the canvas which will be scrolled with it
        self.interior = interior = Frame(canvas)
        interior_id = canvas.create_window(0, 0, window=interior, anchor=NW)

        # track changes to the canvas and frame width and sync them,
        # also updating the scrollbar
        def _configure_interior(event):

            # update the scrollbars to match the size of the inner frame
            size = (interior.winfo_reqwidth(), interior.winfo_reqheight())
            canvas.config(scrollregion="0 0 %s %s" % size)
            if interior.winfo_reqwidth() != canvas.winfo_width():
                canvas.config(width=interior.winfo_reqwidth())

        interior.bind('<Configure>', _configure_interior)

        def _configure_canvas(event):

            if interior.winfo_reqwidth() != canvas.winfo_width():
                canvas.itemconfigure(interior_id, width=canvas.winfo_width())

        canvas.bind('<Configure>', _configure_canvas)

        return

#############################
########## Functions ########
#############################

# Helper functions for writing XML
# ilevel -> indentation level (for readability)

def xwrite(ilevel, xfile, message):

	line = ""

	for x in range(0, ilevel):
		line +="\t"
	line += message
	line += "\n"
	xfile.write(line)

def xcomment(ilevel, xfile, message):

	xwrite(ilevel, xfile, "<!-- " + message + " -->")

def xsingletag(ilevel, xfile, tagname, keys, values):

	line= "<" + tagname

	for k in range(0, len(keys)):
		line += " "
		line += keys[k]
		line += "=\""
		line += values[k]
		line += "\""

	line += "/>"

	xwrite(ilevel, xfile, line)

def xopeningtag(ilevel, xfile, tagname, keys, values):

	line= "<" + tagname

	for k in range(0, len(keys)):
		line += " "
		line += keys[k]
		line += "=\""
		line += values[k]
		line += "\""

	line += ">"

	xwrite(ilevel, xfile, line)

def xclosingtag(ilevel, xfile, tagname):

	line = "</" + tagname + ">"

	xwrite(ilevel, xfile, line)

# Functions to invoke on GUI events

def projectFolderDialog():

	newPath = askdirectory(initialdir=entry_projectFolder.get())
	if newPath != "":
		projectFolder.set(newPath)

def backupFolderDialog():

	newPath = askdirectory(initialdir=entry_backupFolder.get())
	if newPath != "":
		backupFolder.set(newPath)

def sikuliFolderDialog():

	newPath = askdirectory(initialdir=entry_sikuliFolder.get())
	if newPath != "":		
		sikuliFolder.set(newPath)

def junitFolderDialog():

	newPath = askdirectory(initialdir=entry_junitFolder.get())
	if newPath != "":
		junitFolder.set(newPath)

def eclipseFolderDialog():

	newPath = askdirectory(initialdir=entry_eclipseFolder.get())
	if newPath != "":
		eclipseFolder.set(newPath)

def selectAllCalled():

	for i in range(0, len(testList)):

		print(testList[i].var.get())
		print(":")
		print(testList[i].prevState.get())

		if ((testList[i].var.get()) and (not testList[i].prevState.get())):
			testList[i].select()


		else:
			if ((not testList[i].var.get()) and (testList[i].prevState.get())):
				testList[i].deselect()

def constructBuildfile():

	creatable = True

	if entry_filename.get() == '':
		creatable = False

	if entry_projectFolder.get() == '':
		creatable = False

	if entry_sikuliFolder.get() == '':
		creatable = False

	if entry_junitFolder.get() == '':
		creatable = False

	if entry_backupFolder.get() == '':
		creatable = False

	if entry_eclipseFolder.get() == '':
		creatable = False

	if not spinner_platform.curselection():
		creatable = False

	if not spinner_orientation.curselection():
		creatable = False

	if not spinner_titleLayout.curselection():
		creatable = False

	if spinner_platform.curselection():
		if spinner_platform.get(spinner_platform.curselection()) == 'ANDROID':
			if not spinner_device.curselection():
				creatable = False

	if not creatable:
		messagebox.showerror("Some fields not specified", "All options must have a value assigned to them")
		return

	buildfilePath = projectFolder.get() + "/buildfiles/" + filename.get()
	buildfile = open(buildfilePath, "w")

	# XML Header
	xwrite(0, buildfile, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
	# Project tag opening
	xopeningtag(0, buildfile, "project", ["name", "default", "basedir"], ["ProView", "exec", projectFolder.get()])

	# Write properties
	xcomment(1, buildfile, "Set properties for directories")
	xsingletag(1, buildfile, "property", ["name", "value"], ["src", "./src"])
	xsingletag(1, buildfile, "property", ["name", "value"], ["lib", "./libraries"])
	xsingletag(1, buildfile, "property", ["name", "value"], ["bin", "./bin"])
	xsingletag(1, buildfile, "property", ["name", "value"], ["imgs", "./imgs"])
	xsingletag(1, buildfile, "property", ["name", "value"], ["report", "./logs"])
	xcomment(1, buildfile, "Test-specific properties")
	xsingletag(1, buildfile, "property", ["name", "value"], ["orientation", spinner_orientation.get(spinner_orientation.curselection())])
	xsingletag(1, buildfile, "property", ["name", "value"], ["titleLayout", spinner_titleLayout.get(spinner_titleLayout.curselection())])
	xsingletag(1, buildfile, "property", ["name", "value"], ["platform", spinner_platform.get(spinner_platform.curselection())])
	xsingletag(1, buildfile, "property", ["name", "value"], ["logBackupDir", entry_backupFolder.get()])

	if spinner_platform.get(spinner_platform.curselection()) == 'ANDROID':
		xsingletag(1, buildfile, "property", ["name", "value"], ["androidDevice", spinner_device.get(spinner_device.curselection())])

	# Write to automation.properties
	xcomment(1, buildfile, "Write properties to automation.properties")
	xopeningtag(1, buildfile, "propertyfile", ["file"], [projectFolder.get() + "/resources/automation.properties"])
	xsingletag(2, buildfile, "entry", ["key", "value", "operation"], ["firstAppOrientation", "${orientation}", "="])
	xsingletag(2, buildfile, "entry", ["key", "value", "operation"], ["titleLayout", "${titleLayout}", "="])
	xsingletag(2, buildfile, "entry", ["key", "value", "operation"], ["firstApp", "${platform}", "="])

	if spinner_platform.get(spinner_platform.curselection()) == 'ANDROID':
		xsingletag(1, buildfile, "entry", ["key", "value", "operation"], ["androidDevice", "${androidDevice}", "="])


	xclosingtag(1, buildfile, "propertyfile")

	# Classpath for the project
	xcomment(1, buildfile, "The classpath for the project")
	xopeningtag(1, buildfile, "path", ["id"], ["classpath"])
	xsingletag(2, buildfile, "pathelement", ["location"], ["${bin}"])
	xopeningtag(2, buildfile, "fileset", ["dir"], ["${lib}"])
	xsingletag(3, buildfile, "include", ["name"], ["**/*.jar"])
	xclosingtag(2, buildfile, "fileset")
	xclosingtag(1, buildfile, "path")

	# init target
	xcomment(1, buildfile, "Any tasks that should strictly be done first")
	xopeningtag(1, buildfile, "target", ["name"], ["init"])
	xcomment(2, buildfile, "Determine if backups should be done")
	xopeningtag(2, buildfile, "condition", ["property"], ["backupLogsNeeded"])
	xsingletag(3, buildfile, "available", ["file"], ["${report}/timestamp"])
	xclosingtag(2, buildfile, "condition")
	xclosingtag(1, buildfile, "target")

	# backupLogs target

	if varBackupLogs.get():

		xcomment(1, buildfile, "Backup old logs if necessary")
		xopeningtag(1, buildfile, "target", ["name", "if", "depends"], ["backupLogs", "backupLogsNeeded", "init"])
		xcomment(2, buildfile, "Create folder based on timestamp")
		xopeningtag(2, buildfile, "first", ["id"], ["timestamp"])
		xsingletag(3, buildfile, "fileset", ["dir", "includes"], ["${report}/timestamp", "*.tstamp"])
		xclosingtag(2, buildfile, "first")
		xsingletag(2, buildfile, "basename", ["property", "file", "suffix"], ["logstamp", "${toString:timestamp}", ".tstamp"])
		xsingletag(2, buildfile, "mkdir", ["dir"], ["${logBackupDir}/${logstamp}"])
		xcomment(2, buildfile, "Copy logs to new folder")
		xopeningtag(2, buildfile, "copy", ["todir"], ["${logBackupDir}/${logstamp}"])
		xsingletag(3, buildfile, "fileset", ["dir"], ["${report}"])
		xclosingtag(2, buildfile, "copy")
		xclosingtag(1, buildfile, "target")

	# Clean and compile (if necessary)
	if varCompile.get():

		dependency = "backupLogs"
		if not varBackupLogs.get():
			dependency = "init"

		# clean target
		xcomment(1, buildfile, "Clean")
		xopeningtag(1, buildfile, "target", ["name", "depends"], ["clean", dependency])
		xsingletag(2, buildfile, "delete", ["dir"], ["${bin}"])	
		xsingletag(2, buildfile, "delete", ["dir"], ["${report}"])
		xsingletag(2, buildfile, "mkdir", ["dir"], ["${bin}"])
		xsingletag(2, buildfile, "mkdir", ["dir"], ["${report}"])
		xsingletag(2, buildfile, "mkdir", ["dir"], ["${report}/html"])
		xsingletag(2, buildfile, "mkdir", ["dir"], ["${report}/xml"])
		xsingletag(2, buildfile, "mkdir", ["dir"], ["${report}/screenshots"])
		xclosingtag(1, buildfile, "target")

		# Compile target
		xcomment(1, buildfile, "Compile .java files")
		xopeningtag(1, buildfile, "target", ["name", "depends"], ["compile", "clean"])
		xopeningtag(2, buildfile, "javac", ["source", "srcdir", "fork", "destdir", "includeantruntime"], ["1.7", "${src}", "no", "${bin}", "false"])
		xopeningtag(3, buildfile, "classpath", [], [])
		xsingletag(4, buildfile, "pathelement", ["path"], ["${src}"])
		xopeningtag(4, buildfile, "fileset", ["dir"], ["${lib}"])
		xsingletag(5, buildfile, "include", ["name"], ["**/*.jar"])
		xclosingtag(4, buildfile, "fileset")
		xopeningtag(4, buildfile, "fileset", ["dir"], [entry_junitFolder.get()])
		xsingletag(5, buildfile, "include", ["name"], ["*.jar"])
		xclosingtag(4, buildfile, "fileset")
		xopeningtag(4, buildfile, "fileset", ["dir"], [entry_eclipseFolder.get() + "/plugins"])
		xsingletag(5, buildfile, "include", ["name"], ["*.jar"])
		xclosingtag(4, buildfile, "fileset")
		xclosingtag(3, buildfile, "classpath")
		xclosingtag(2, buildfile, "javac")
		xclosingtag(1, buildfile, "target")

	# Run the tests
	dependency = "compile"
	if not varCompile.get():
		dependency = "backupLogs"
		if not varBackupLogs.get():			
			dependency = "init"

	xcomment(1, buildfile, "Run the tests")
	xopeningtag(1, buildfile, "target", ["name", "depends"], ["exec", dependency])
	xopeningtag(2, buildfile, "junit", ["printsummary", "fork", "dir", "haltonfailure", "showoutput"], ["yes", "yes", projectFolder.get(), "no", "yes"])
	xopeningtag(3, buildfile, "classpath", [], [])
	xsingletag(4, buildfile, "pathelement", ["location"], ["${bin}"])
	xopeningtag(4, buildfile, "fileset", ["dir"], ["${lib}"])
	xsingletag(5, buildfile, "include", ["name"], ["**/*.jar"])
	xsingletag(5, buildfile, "exclude", ["name"], ["**/sikuli*.jar"])
	xclosingtag(4, buildfile, "fileset")	
	xopeningtag(4, buildfile, "fileset", ["dir"], [entry_junitFolder.get()])
	xsingletag(5, buildfile, "include", ["name"], ["*.jar"])
	xclosingtag(4, buildfile, "fileset")
	xopeningtag(4, buildfile, "fileset", ["dir"], [entry_eclipseFolder.get() + "/plugins"])
	xsingletag(5, buildfile, "include", ["name"], ["*.jar"])
	xclosingtag(4, buildfile, "fileset")
	xopeningtag(4, buildfile, "fileset", ["dir"], [entry_sikuliFolder.get()])
	xsingletag(5, buildfile, "include", ["name"], ["*.jar"])
	xclosingtag(4, buildfile, "fileset")
	xclosingtag(3, buildfile, "classpath")

	# Insert all selected tests
	for i in range(0, len(testList)):
		catTests = testList[i].tests
		for j in range(0, len(catTests)):

			if catTests[j].var.get():

				testMethods = catTests[j].methods

				methodString = ""

				for k in range(0, len(testMethods)):
					if testMethods[k].var.get():
						methodString += testMethods[k].name + ","

				xopeningtag(3, buildfile, "test", ["name", "methods", "haltonfailure", "todir", "outfile"], ["com.testcases." + testList[i].name + "." + testList[i].tests[j].name, methodString, "no", "${report}/xml", testList[i].tests[j].name])
				xsingletag(4, buildfile, "formatter", ["type"], ["xml"])
				xclosingtag(3, buildfile, "test")

	xclosingtag(2, buildfile, "junit")

	xcomment(2, buildfile, "Compile the JUnit report")
	xopeningtag(2, buildfile, "junitreport", ["todir"], ["${report}/html"])		
	xopeningtag(3, buildfile, "fileset", ["dir"], ["${report}/xml"])
	xsingletag(4, buildfile, "include", ["name"], ["Core*.xml"])
	xclosingtag(3, buildfile, "fileset")
	xsingletag(3, buildfile, "report", ["format", "todir", "styledir"], ["frames", "${report}/html", "./buildfiles"])
	xclosingtag(2, buildfile, "junitreport")

	xcomment(2, buildfile, "Create a timestamp for logs")
	xopeningtag(2, buildfile, "tstamp", [], [])
	xsingletag(3, buildfile, "format", ["property", "pattern", "locale"], ["tstamp", "MM-dd-yyyy_hh.mm.ss_aa", "en,UK"])
	xclosingtag(2, buildfile, "tstamp")
	xsingletag(2, buildfile, "mkdir", ["dir"], ["${report}/timestamp"])
	xsingletag(2, buildfile, "touch", ["file"], ["${report}/timestamp/${tstamp}.tstamp"])

	xclosingtag(1, buildfile, "target")

	# Project tag close
	xclosingtag(0, buildfile, "project")

	buildfile.close()

	messagebox.showinfo("Buildfile created", "Buildfile created at \n" + buildfilePath)

def runTests():

	constructBuildfile()
	command = "cd " + projectFolder.get() + " && "
	command += "ant -buildfile " + projectFolder.get() + "/buildfiles/" + filename.get() + ""
	call(command, shell=True)

	url = entry_projectFolder.get() + "/logs/html/all-tests.html"
	webbrowser.open(url, new=2)

def createConfigFile():

	config = configparser.ConfigParser()
	config.add_section('Section')
	config.set('Section', 'projectRootFolder', 'C:/')
	config.set('Section', 'backupFolder', 'C:/')
	config.set('Section', 'sikuliFolder', 'C:/')
	config.set('Section', 'junitFolder', 'C:/')
	config.set('Section', 'eclipseFolder', 'C:/')
	
	with open(configFileName, 'w') as configFile:
		config.write(configFile)
		configFile.close()

def loadConfigFile():

	config = configparser.ConfigParser()
	config.read(configFileName)
	global property_projectRootFolder
	global property_backupFolder
	global property_sikuliFolder
	global property_junitFolder
	global property_eclipseFolder
	property_projectRootFolder = config.get('Section', 'projectRootFolder')	
	property_backupFolder = config.get('Section', 'backupFolder')
	property_sikuliFolder = config.get('Section', 'sikuliFolder')
	property_junitFolder = config.get('Section', 'junitFolder')
	property_eclipseFolder = config.get('Section', 'eclipseFolder')

def onClose():

	config = configparser.ConfigParser()
	config.add_section('Section')
	config.set('Section', 'projectRootFolder', entry_projectFolder.get())
	config.set('Section', 'backupFolder', entry_backupFolder.get())
	config.set('Section', 'sikuliFolder', entry_sikuliFolder.get())
	config.set('Section', 'junitFolder', entry_junitFolder.get())
	config.set('Section', 'eclipseFolder', entry_eclipseFolder.get())

	with open(configFileName, 'w') as configFile:
		config.write(configFile)
		configFile.close()

	root.quit()

def platformSelect(evt):

	if spinner_platform.get(spinner_platform.curselection()) == 'ANDROID':
		spinner_device.grid(row=30, column=2, padx=10, pady=(5,0), sticky='W')
	else:
		spinner_device.grid_remove()


# end of constructBuildfile()

def findAllTests():

	global categoriesList
	global testList
	global testVars
	global selectCatPrevStates

	categoriesList = os.listdir(entry_projectFolder.get() + "/src/com/testcases")

	for cat in categoriesList:

		nv = IntVar()
		nv.set(False)

		newTestList = []

		newCat = Category(cat, nv, newTestList)

		testList.append(newCat)

		for test in os.listdir(entry_projectFolder.get() + "/src/com/testcases/" + cat):

			if "_" in test:

				nv = IntVar()
				nv.set(False)

				newMethodList = []

				newTest = Test(os.path.splitext(test)[0], nv, newMethodList)

				newCat.addTest(newTest)

				# Read through file and parse out any method names
				testClass = open(entry_projectFolder.get() + "/src/com/testcases/" + cat + "/" + test, 'r')

				for line in testClass:
					if line.find("public void test") > -1:
						start = line.find("public void ") + len("public void ")
						end = line.find("(")

						nv = IntVar()
						nv.set(False)

						newMethod = Method(line[start:end], nv)

						newTest.addMethod(newMethod)

def getAllAndroidDevices():

	global androidDevices
	tempList = os.listdir(entry_projectFolder.get() + "/resources/avd")

	for e in tempList:
		if os.path.isdir(entry_projectFolder.get() + "/resources/avd/" + e):
			androidDevices.append(e)

################################
########## GUI Layout ##########
################################

root = Tk()
root.title("ProView Buildfile Creation Wizard")
root.protocol("WM_DELETE_WINDOW", onClose)

# Load, and possibly create, properties file
if not os.path.isfile(configFileName):
	createConfigFile()

loadConfigFile()

# Filename entry

filenameLabel = StringVar()
filenameLabel.set("Filename: ")
label_filename = Label(root, textvariable=filenameLabel)
label_filename.grid(row=10, column=0, padx=10, pady=(20,0), sticky='NE')

now = datetime.datetime.now()
filename = StringVar(None)
entry_filename = Entry(root, textvariable=filename, width=75)
entry_filename.grid(row=10, column=1, padx=10, pady=(20,0), sticky='W', columnspan=2)

defaultFilename = "build@"
defaultFilename += str(now.month) + "-" + str(now.day) + "-" + str(now.year) + "_"
defaultFilename += str(now.hour) + "." + str(now.minute) + "." + str(now.second) + ".xml"
entry_filename.insert(0, defaultFilename)

# project folder entry

projectFolderLabel = StringVar()
projectFolderLabel.set("Project root folder: ")
label_projectFolder = Label(root, textvariable=projectFolderLabel)
label_projectFolder.grid(row=18, column=0, padx=10, pady=(5,0), sticky='NE')

projectFolder = StringVar()
projectFolder.set(property_projectRootFolder)
entry_projectFolder = Entry(root, textvariable=projectFolder, width=75)
entry_projectFolder.grid(row=18, column=1, padx=10, pady=(5,0), sticky='W', columnspan=2)

selectProjectFolderButton = Button(root, text="Select folder", height=1, width=15, command=projectFolderDialog)
selectProjectFolderButton.grid(row=18, column=3, sticky = 'W', padx=(0,20), pady=(5,0))

# e.g. project folder label

egProjectFolderLabel = StringVar()
egProjectFolderLabel.set("e.g. C:/Users/.../ProView-Automated-Tests")
label_egProjectFolder = Label(root, textvariable=egProjectFolderLabel, fg='gray')
label_egProjectFolder.grid(row=19, column=1, padx=10, sticky='W')

# Backup folder entry

backupFolderLabel = StringVar()
backupFolderLabel.set("Log backup folder: ")
label_backupFolder = Label(root, textvariable=backupFolderLabel)
label_backupFolder.grid(row=20, column=0, padx=10, pady=(5,0), sticky='NE')

backupFolder = StringVar()
backupFolder.set(property_backupFolder)
entry_backupFolder = Entry(root, textvariable=backupFolder, width=75)
entry_backupFolder.grid(row=20, column=1, padx=10, pady=(5,0), sticky='W', columnspan=2)

selectBackupFolderButton = Button(root, text="Select folder", height=1, width=15, command=backupFolderDialog)
selectBackupFolderButton.grid(row=20, column=3, sticky = 'W', padx=(0,20), pady=(5,0))

# e.g. backup folder label

egBackupFolderLabel = StringVar()
egBackupFolderLabel.set("e.g. C:/.../ProView-testLogBackups")
label_egBackupFolder = Label(root, textvariable=egBackupFolderLabel, fg='gray')
label_egBackupFolder.grid(row=21, column=1, padx=10, sticky='W')

# Sikuli folder entry

sikuliFolderLabel = StringVar()
sikuliFolderLabel.set("Sikuli folder: ")
label_sikuliFolder = Label(root, textvariable=sikuliFolderLabel)
label_sikuliFolder.grid(row=22, column=0, padx=10, pady=(5,0), sticky='NE')

sikuliFolder = StringVar()
sikuliFolder.set(property_sikuliFolder)
entry_sikuliFolder = Entry(root, textvariable=sikuliFolder, width=75)
entry_sikuliFolder.grid(row=22, column=1, padx=10, pady=(5,0), sticky='W', columnspan=2)

selectSikuliFolderButton = Button(root, text="Select folder", height=1, width=15, command=sikuliFolderDialog)
selectSikuliFolderButton.grid(row=22, column=3, sticky = 'W', padx=(0,20), pady=(5,0))

# e.g. sikuli folder label

egSikuliFolderLabel = StringVar()
egSikuliFolderLabel.set("e.g. C:/Sikuli X")
label_egSikuliFolder = Label(root, textvariable=egSikuliFolderLabel, fg='gray')
label_egSikuliFolder.grid(row=23, column=1, padx=10, sticky='W')

# JUnit folder entry

junitFolderLabel = StringVar()
junitFolderLabel.set("JUnit folder: ")
label_junitFolder = Label(root, textvariable=junitFolderLabel)
label_junitFolder.grid(row=24, column=0, padx=10, pady=(5,0), sticky='NE')

junitFolder = StringVar()
junitFolder.set(property_junitFolder)
entry_junitFolder = Entry(root, textvariable=junitFolder, width=75)
entry_junitFolder.grid(row=24, column=1, padx=10, pady=(5,0), sticky='W', columnspan=2)

selectJUnitFolderButton = Button(root, text="Select folder", height=1, width=15, command=junitFolderDialog)
selectJUnitFolderButton.grid(row=24, column=3, sticky = 'W', padx=(0,20), pady=(5,0))

# e.g. junit folder label

egJUnitFolderLabel = StringVar()
egJUnitFolderLabel.set("e.g. C:/.../eclipse/plugins/org.junit_<versionInfo>")
label_egJUnitFolder = Label(root, textvariable=egJUnitFolderLabel, fg='gray')
label_egJUnitFolder.grid(row=25, column=1, padx=10, sticky='W')

# Eclipse folder entry

eclipseFolderLabel = StringVar()
eclipseFolderLabel.set("Eclipse folder: ")
label_eclipseFolder = Label(root, textvariable=eclipseFolderLabel)
label_eclipseFolder.grid(row=26, column=0, padx=10, pady=(5,0), sticky='NE')

eclipseFolder = StringVar()
eclipseFolder.set(property_eclipseFolder)
entry_eclipseFolder = Entry(root, textvariable=eclipseFolder, width=75)
entry_eclipseFolder.grid(row=26, column=1, padx=10, pady=(5,0), sticky='W', columnspan=2)

selectEclipseFolderButton = Button(root, text="Select folder", height=1, width=15, command=eclipseFolderDialog)
selectEclipseFolderButton.grid(row=26, column=3, sticky = 'W', padx=(0,20), pady=(5,0))

# e.g. Eclipse folder label

egEclipseFolderLabel = StringVar()
egEclipseFolderLabel.set("e.g. C:/.../eclipse")
label_egEclipseFolder = Label(root, textvariable=egEclipseFolderLabel, fg='gray')
label_egEclipseFolder.grid(row=27, column=1, padx=10, sticky='W')

# Platform spinner

platformLabel = StringVar()
platformLabel.set("Platform: ")
label_platform = Label(root, textvariable=platformLabel)
label_platform.grid(row=30, column=0, padx=10, pady=(5,0), sticky='NE')

spinner_platform = Listbox(root, height=8, exportselection=0)
spinner_platform.insert(1, "ANDROID");
spinner_platform.insert(2, "CHROME");
spinner_platform.insert(3, "FIREFOX");
spinner_platform.insert(4, "IEXPLORE");
spinner_platform.insert(5, "IPAD");
spinner_platform.insert(6, "MAC");
spinner_platform.insert(7, "SAFARI");
spinner_platform.insert(8, "WINDOWS");
spinner_platform.grid(row=30, column=1, padx=10, pady=(5,0), sticky='W')

# Android device spinner

spinner_device = Listbox(root, height=8, exportselection=0)

getAllAndroidDevices()

for i in range(0, len(androidDevices)):
	spinner_device.insert(i+1, androidDevices[i])

spinner_platform.bind('<<ListboxSelect>>', platformSelect)

# Orientation spinner

orientationLabel = StringVar()
orientationLabel.set("Orientation: ")
label_orientation = Label(root, textvariable=orientationLabel)
label_orientation.grid(row=40, column=0, padx=10, pady=(5,0), sticky='NE')

spinner_orientation = Listbox(root, height=2, exportselection=0)
spinner_orientation.insert(1, "portrait");
spinner_orientation.insert(2, "landscape");
spinner_orientation.grid(row=40, column=1, padx=10, pady=(5,0), sticky='W')

# Title layout spinner

titleLayoutLabel = StringVar()
titleLayoutLabel.set("Title layout: ")
label_titleLayout = Label(root, textvariable=titleLayoutLabel)
label_titleLayout.grid(row=50, column=0, padx=10, pady=5, sticky='NE')

spinner_titleLayout = Listbox(root, height=3, exportselection=0)
spinner_titleLayout.insert(1, "Pages_Mode");
spinner_titleLayout.insert(2, "Reflow_Mode");
spinner_titleLayout.insert(3, "Scroll_Mode");
spinner_titleLayout.grid(row=50, column=1, padx=10, pady=5, sticky='W')

# Test checkboxes

testSelectLabel = StringVar()
testSelectLabel.set("Select tests to run: ")
label_testSelect = Label(root, textvariable=testSelectLabel)
label_testSelect.grid(row=60, column=0, padx = (20,10), sticky='NE')

# The frame for all checkboxes

cbFrame = VerticalScrolledFrame(root, bd=1, relief=tk.SUNKEN)
cbFrame.grid(row=60, column=1, columnspan=2, rowspan=8, sticky='WE', padx=10)

# Create the test picker layout

findAllTests()

# Create the checkboxes to select all of each category

for i in range(0, len(testList)):

	newCB = Checkbutton(root, text="All " + testList[i].name.capitalize(), variable=testList[i].var, command=lambda:selectAllCalled())
	newCB.grid(row=61+i, column=0, sticky='W', padx=(20,0))

# Create the checkboxes for and dropdowns for each individual test/test category

for i in range(0, len(testList)):

 	catToggleFrame = toggleFrame(cbFrame.interior, text=testList[i].name.capitalize(), relief=tk.RAISED, borderwidth=1)
 	catToggleFrame.pack(fill=tk.X, expand=1)

 	tests = testList[i].tests

 	for j in range(0, len(tests)):

 		testCB = testToggleFrame(catToggleFrame.subFrame, text=tests[j].name)
 		testCB.setCheckVar(tests[j].var)
 		testCB.grid(row=math.floor(j/2), column=j%2, sticky='NW', padx=10)

 		methods = tests[j].methods

 		for k in range(0, len(methods)):
 			methodCB = Checkbutton(testCB.subFrame, text=methods[k].name, variable=methods[k].var)
 			methodCB.grid(row=k, column=0, sticky='W', padx=(25,0))

# Other options checkboxes

otherOptionsLabel = StringVar()
otherOptionsLabel.set("Other options: ")
label_otherOptions = Label(root, textvariable=otherOptionsLabel)
label_otherOptions.grid(row=180, column=0, pady=(0,20), sticky='NE')

varCompile = IntVar()
cbCompile = Checkbutton(root, text="Compile?", variable=varCompile)
cbCompile.select()
cbCompile.grid(row=180, column=1, sticky='W', padx=10, pady=(0,20))

varBackupLogs = IntVar()
cbBackupLogs = Checkbutton(root, text="Backup logs?", variable=varBackupLogs)
cbBackupLogs.select()
cbBackupLogs.grid(row=180, column=2, sticky='W', padx=10, pady=(0,20))

# Construct buildfile button
constructBuildfileButton = Button(root, text="Create build file", command=constructBuildfile)
constructBuildfileButton.grid(row=190, column=2, sticky = "E", padx=(0,20), pady=(0,20))

# # Run tests button
runTestsButton = Button(root, text="Run tests", command=runTests)
runTestsButton.grid(row=190, column=3, sticky='W', padx=(0,20), pady=(0,20))

#################################
##### Invoke the main loop ######
#################################

root.mainloop()