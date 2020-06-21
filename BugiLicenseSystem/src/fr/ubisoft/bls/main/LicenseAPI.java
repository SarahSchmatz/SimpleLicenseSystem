package fr.ubisoft.bls.main;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DecompressingHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonParser;

public class LicenseAPI {
	
	public static LicenseState getState() {
		return LicenseState.valueOf(new JsonParser().parse(readWebsite("http://metaclient.net/api/v3/auth.php?authkey=ServerDB")).getAsJsonObject().get("state").getAsString());
	}
	
	public static enum LicenseState {
		VAILD, WRONG;
	}
	
	public static String readWebsite(String url) {
		try {
			HttpGet request = null;

	        try {

	            HttpClient client = HttpClientBuilder.create().build();
	            request = new HttpGet(url);

	            HttpResponse response = client.execute(request);
	            
	            HttpEntity entity = response.getEntity();
	            String content = EntityUtils.toString(entity);
	            return content;

	        } finally {

	            if (request != null) {

	                request.releaseConnection();
	            }
	        }
		} catch (Exception ex) {
			return "error";
		}
	}
	
}
