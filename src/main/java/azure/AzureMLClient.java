package azure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class AzureMLClient {

    private String endPointURL; //Azure ML Endpoint
    private String key; //API KEY


    public AzureMLClient(String endPointURL,String key)
    {
      this.endPointURL= endPointURL;
      this.key= key;
    }
    
    public String requestResponse( String requestBody ) throws Exception
    {
      URL u = new URL(this.endPointURL);
      HttpURLConnection conn = (HttpURLConnection) u.openConnection();

      conn.setRequestProperty("Authorization","Bearer "+ this.key);
      conn.setRequestProperty("Content-Type","application/json");
      conn.setRequestMethod("POST");
      
      String body= new String(requestBody);
      
      conn.setDoOutput(true);
      OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

      wr.write(body);
      wr.close();

      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      
      String decodedString;
      String responseString="";    

      while ((decodedString = in.readLine()) != null) 
  	  {
          responseString += decodedString;
      }
  	  return responseString;
   }

	
}
