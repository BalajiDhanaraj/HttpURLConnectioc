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

    public static void main(String[] args) throws IOException {

        HttpURLConnectionExample connectionExample = new HttpURLConnectionExample();
        connectionExample.GetMethod();



    }
}
