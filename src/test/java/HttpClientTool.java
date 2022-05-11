import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
public class HttpClientTool {

    @Test
    public void doGet() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://dummy.restapiexample.com/api/v1/employees");
        HttpResponse response = httpClient.execute(httpGet);
        System.out.println("Request is "+ httpGet.getMethod());
        //System.out.println("Header is "+ httpGet.getFirstHeader("Employee"));
        System.out.println(response.getStatusLine());
        System.out.println(response.getStatusLine().getStatusCode());
        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);

    }
    @Test(priority = 1)
    public void doPost() throws IOException{

        CloseableHttpClient httpClient1 = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://dummy.restapiexample.com/create");
        HttpResponse response1= httpClient1.execute(httpPost);
        String create = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
        httpPost.setEntity(new StringEntity(create, ContentType.APPLICATION_JSON));
        System.out.println(response1);
        System.out.println(response1.getStatusLine());
        System.out.println(response1.getStatusLine().getStatusCode());

    }


    @Test(priority = 2)
    public void doPut() throws IOException{
        CloseableHttpClient httpClient2= HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("https://dummy.restapiexample.com/public/api/v1/update/21");
        String update= "{\"name\":\"test1\",\"salary\":\"1234\",\"age\":\"62\"}";
        httpPut.setEntity(new StringEntity(update,ContentType.APPLICATION_JSON));
        HttpResponse response2=httpClient2.execute(httpPut);
        System.out.println(response2);
        System.out.println(response2.getStatusLine().getStatusCode());

            }


        }










