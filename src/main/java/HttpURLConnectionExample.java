import java.io.*;
import java.net.*;
import java.net.HttpURLConnection;

public class HttpURLConnectionExample {

    public void GetMethod() throws IOException {

        URL url = new URL("https://dummy.restapiexample.com/api/v1/employees");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int statusCode = connection.getResponseCode();
        System.out.println("Status code is "+statusCode);

        String message = connection.getResponseMessage();
        System.out.println("Message "+message);

        // below line is used to read the JSON body

        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String lines ;
        StringBuffer buffer = new StringBuffer();

        while ((lines=bufferedReader.readLine())!=null){
            buffer.append(lines);
        }
        System.out.println(buffer);

    }

    public void PostMethod() throws IOException {

        URL url = new URL("https://dummy.restapiexample.com/api/v1/create");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        /// in postman --> post request header section --> they is key, value --> so our send request context is --> content-type, application/json like (key, values pair)
        connection.setRequestProperty("Content-Type","application/json");
        // we want to send out the output to the url so we have to set as TRUE, by default it will in FALSE
        connection.setDoOutput(true);
        // escaping the string is " \"name\" "
        String json = "{\"name\":\"Balai\",\"salary\":\"55000\",\"age\":\"23\"}";

        byte[] inputjson = json.getBytes();
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(inputjson);
        System.out.println("Response code"+connection.getResponseCode());
        System.out.println("Message "+connection.getResponseMessage());
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String lines;
        StringBuffer buffer = new StringBuffer();

        while((lines = bufferedReader.readLine())!=null){
            buffer.append(lines);
        }
        System.out.println(buffer);
    }

    public void PutMethod() throws IOException {
        //{"status":"success","data":{"name":"Balai","salary":"55000","age":"23","id":896},"message":"Successfully! Record has been added."}

        URL url = new URL("https://dummy.restapiexample.com/api/v1/update/896");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        /// in postman --> post request header section --> they is key, value --> so our send request context is --> content-type, application/json like (key, values pair)
        connection.setRequestProperty("Content-Type","application/json");
        // we want to send out the output to the url so we have to set as TRUE, by default it will in FALSE
        connection.setDoOutput(true);
        // escaping the string is " \"name\" "
        String json = "{\"name\":\"Balai\",\"salary\":\"55000\",\"age\":\"24\"}";
        byte[] inputjson = json.getBytes();
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(inputjson);
        System.out.println("Response code"+connection.getResponseCode());
        System.out.println("Message "+connection.getResponseMessage());
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String lines;
        StringBuffer buffer = new StringBuffer();
        while((lines = bufferedReader.readLine())!=null){
            buffer.append(lines);
        }
        System.out.println(buffer);
    }

    public void DeleteMethod() throws IOException {
        URL url = new URL("https://dummy.restapiexample.com/api/v1/delete/896");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-Type","application/json");
        // we want to send out the output to the url so we have to set as TRUE, by default it will in FALSE
        connection.setDoOutput(true);
        System.out.println("Response code"+connection.getResponseCode());
        System.out.println("Message "+connection.getResponseMessage());
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String lines;
        StringBuffer buffer = new StringBuffer();
        while((lines = bufferedReader.readLine())!=null){
            buffer.append(lines);
        }
        System.out.println(buffer);
    }
    public static void main(String[] args) throws IOException {
        HttpURLConnectionExample connectionExample = new HttpURLConnectionExample();
        //connectionExample.GetMethod();
        //connectionExample.PostMethod();
        //connectionExample.PutMethod();
        connectionExample.DeleteMethod();
    }
}
