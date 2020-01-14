import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

String url = "http://here"

def getData(String url, String userName, String password) {
    
    def https = new RESTClient(url)
    https.auth.basic(userName, password)
    try {
        def resp = https.get(
            requestContentType: URLENC,
            headers: ['Content-Type': 'application/x-www-form-urlencoded']
        )
    
        def response = []
        resp.data.each{ it ->
            response.add(it)
          }
        return response
    } catch(HttpResponseException e) {
        r = e.response
        println("Status:  $r.status")
    } 
}

def myData = getData(url,"username","password")
println(myData) 

