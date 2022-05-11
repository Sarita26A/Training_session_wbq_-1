import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class HttpClient {
    @Test(priority = 0)
    public void doGet() throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://reqres.in/api/users?page=2");
        System.out.println("request is "+ httpGet.getMethod());
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println(response);
        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusLine().getReasonPhrase());

    }
    @Test(priority = 1)
    public void doPost() throws IOException
    {

        CloseableHttpClient httpClient1 = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://reqres.in/api/users");
        //String json = "{\"name\":\"sarita\" \"job:\": \"Trainee\"}";
        String json = "{\n" +
                "            \"name\": \"Sarita\",\n" +
                "                \"job\": \"Trainee\"}";

        httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        System.out.println("The request type is "+httpPost.getMethod());
        HttpResponse response1 = httpClient1.execute(httpPost);
        System.out.println(response1);
        System.out.println(response1.getStatusLine());
        System.out.println(response1.getStatusLine().getReasonPhrase());

    }
    @Test(priority = 2)
    public void doPut() throws IOException {
        CloseableHttpClient httpClient2 = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("https://reqres.in/api/users/2");
        String updateWith= "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader" +
                "\"\n" +
                "}";
        httpPut.setEntity(new StringEntity(updateWith, ContentType.APPLICATION_JSON));
        HttpResponse putResponse = httpClient2.execute(httpPut);
        System.out.println("Request type is " + httpPut.getMethod());
        System.out.println(putResponse.getStatusLine());
        System.out.println(putResponse.getStatusLine().getReasonPhrase());
        System.out.println(putResponse.getStatusLine().getStatusCode());
    }

    @Test(priority = 3)
    public void doPatch() throws IOException{
        CloseableHttpClient httpClientPatch = HttpClients.createDefault();
        HttpPatch httpPatch = new HttpPatch("https://reqres.in/api/users/2");
        System.out.println("The request is: "+ httpPatch.getMethod());
        String partialUpdate = "{\n" +
                "    \"name\": \"Sarita\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        httpPatch.setEntity(new StringEntity(partialUpdate,ContentType.APPLICATION_JSON));
        HttpResponse responsePatch = httpClientPatch.execute(httpPatch);
        System.out.println(responsePatch.getStatusLine());
        System.out.println(responsePatch.getStatusLine().getReasonPhrase());
        System.out.println(responsePatch.getStatusLine().getStatusCode());
        //Assert.assertEquals(responsePatch.getStatusLine().getStatusCode(),206);
    }

}
