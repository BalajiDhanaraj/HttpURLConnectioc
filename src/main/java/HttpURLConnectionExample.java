import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class HttpURLConnectionExample {

    public void GetMethod() throws IOException {

        URL uri = new URL("https://dummy.restapiexample.com/api/v1/employees");
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
        connection.setRequestMethod("Get");
        connection.connect();

        int statusCode = connection.getResponseCode();
        System.out.println("Status code is "+statusCode);

    }

}
