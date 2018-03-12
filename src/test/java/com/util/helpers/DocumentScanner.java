package com.util.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Assert;

public class DocumentScanner extends BaseObject
{
	public DocumentScanner()
	{

	}

	public void checkForImage(String filePath) throws IOException, InterruptedException
	{
		threadWait(20);

		File myFile = new File(readProperty(filePath));
		PDDocument loadedPDF = PDDocument.load(myFile);

		PDPageTree pageList = loadedPDF.getDocumentCatalog().getPages();

		for(PDPage page : pageList)
		{
			// get a list of resources within the page
			PDResources resources = page.getResources();
			// get the names of those objects in the page

			Iterable<COSName> objectNames = resources.getXObjectNames();

			for(COSName object : objectNames)
			{
				PDXObject xobject = resources.getXObject(object);

				if(xobject instanceof PDImageXObject)
				{
					System.out.println("image found");
				}
				else
				{
					throw new IOException("no image was found in the document");
				}
			}
		}

		loadedPDF.close();
		myFile.delete();
	}

	public void scanDOCX(String text, String filePath) throws IOException, InterruptedException
	{
		// needed? (for download time) Don't know what to wait for
		threadWait(10);
		File myFile;
		if(properties.readProperty("platform").contains("firefox"))
		{
			String filePath1="C://Users//pc00541557//Downloads//file";
			myFile = new File(filePath1);
		}else
		{
			myFile = new File(properties.readProperty(filePath));
		}

		FileInputStream fiss = new FileInputStream(myFile);
		XWPFDocument doc = new XWPFDocument(fiss);
		XWPFWordExtractor xw = new XWPFWordExtractor(doc);
		String docxText = xw.getText();
		Assert.assertTrue(docxText.contains(text));
		xw.close();
		myFile.delete();
	}

	public void scanPDF(String filepath, String text) throws IOException, InterruptedException
	{
		//threadWait(10);
		File myFile;
		if(properties.readProperty("platform").contains("firefox"))
		{
			String filePath1="C://Users//pc00541557//Downloads//PDFTest.pdf";
			myFile = new File(filePath1);
		}else
		{
			myFile = new File(readProperty(filepath));
		}

		PDDocument test = PDDocument.load(myFile);

		PDFTextStripper textExtract = new PDFTextStripper();
		String pdfText = textExtract.getText(test);
		Assert.assertTrue(pdfText.contains(text));
		test.close();
		myFile.delete();
	}

	public void scanPPTX(String Text, String filePath) throws IOException, InterruptedException
	{
		// needed? (for download time) Don't know what to wait for
		threadWait(10);
		File myFile;
		if(properties.readProperty("platform").contains("firefox"))
		{
			String filePath1="C://Users//pc00541557//Downloads//file";
			myFile = new File(filePath1);
		}else
		{
			myFile = new File(properties.readProperty(filePath));
		}
		
		FileInputStream inputStream = new FileInputStream(myFile);
		XMLSlideShow pptshow = new XMLSlideShow(inputStream);
		XSLFPowerPointExtractor extract = new XSLFPowerPointExtractor(pptshow);
		String pptText = extract.getText();
		Assert.assertTrue(pptText.contains(Text));
		pptshow.close();
		extract.close();
		myFile.delete();
	}

	public void scanXLSX(String text, String filePath) throws IOException, InterruptedException
	{
		// needed? (for download time) Don't know what to wait for
		threadWait(10);
		File myFile;
		if(properties.readProperty("platform").contains("firefox"))
		{
			String filePath1="C://Users//pc00541557//Downloads//file";
			myFile = new File(filePath1);
		}else
		{
			myFile = new File(properties.readProperty(filePath));
		}
		FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFExcelExtractor xe = new XSSFExcelExtractor(wb);
		String xlsxText = xe.getText();
		Assert.assertTrue(xlsxText.contains(text));
		wb.close();
		xe.close();
		myFile.delete();
	}
}