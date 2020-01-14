import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

String url = "http://here"

def getData(String url,
                   String userName,
                   String password) {
    def authString = ("${userName}:${password}").getBytes().encodeBase64().toString()
    def connection = (url).toURL().openConnection()
    connection.addRequestProperty('Authorization', 'Basic ' + authString)
//    connection.addRequestProperty('Content-Type', 'application/json')
    connection.setRequestMethod('GET')
    connection.setReadTimeout(30000)
    try {
        connection.connect()
        def reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))
          String line = null;
          while ((line = reader.readLine()) != null) {
              System.out.println(line);
          }
          inputStream.close();
           
    } finally {
        connection.disconnect();
    }
}

def myData = getData(url,"username","password")
println(myData) 

