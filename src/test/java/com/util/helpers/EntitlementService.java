package com.util.helpers;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class EntitlementService
{
	public PropertyReader properties = new PropertyReader();

	public EntitlementService()
	{

	}

	public String createEntitlementForNewAnonymousUser(String environment, String account, String resource,
			String expiration) throws ClientProtocolException, IOException, JSONException
	{
		environment.toLowerCase();
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(
				"https://proviewlibrary." + "qed" + ".api.thomsonreuters.com" + "/v1/entitlement/" + account);

		String requestBody = "{\"user\":\"Anonymous\"," + "\"resource\":\"" + resource + "\"," + "\"expiry\":\""
				+ expiration + "\"," + "\"user_tokens\":[]}";

		post.addHeader("Accept", "application/json");
		post.addHeader("Content-Type", "application/json");
		post.addHeader("x-library-test-bypass", "true");

		post.setEntity(new StringEntity(requestBody, "UTF-8"));
		CloseableHttpResponse createEntitlementResponse = client.execute(post);
		
		String responseBody = EntityUtils.toString(createEntitlementResponse.getEntity());
		client.close();
		System.out.println(responseBody);
		return new JSONObject(responseBody).getJSONObject("resource").getString("token");
	}

	public void removeEntitlement(String environment, String accountId, String tokenId) throws ClientProtocolException, IOException
	{
		System.out.println(tokenId);
		environment.toLowerCase();
		CloseableHttpClient client = HttpClients.createDefault();
		String endPoint = "/v1/entitlement/" + accountId + "/" + tokenId;
		System.out.println(endPoint);
		String url = "http://proviewlibrary." + "qed" + ".api.thomsonreuters.com" + endPoint;
		System.out.println(url);
		HttpDelete removeEntitlementRequest = new HttpDelete(url);
		removeEntitlementRequest.addHeader("Accept", "application/json");
		removeEntitlementRequest.addHeader("Content-Type", "application/json");
		removeEntitlementRequest.addHeader("x-library-test-bypass", "true");
		client.execute(removeEntitlementRequest);
		client.close();
	}
}