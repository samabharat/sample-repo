@Grab(group='org.codehaus.groovy.modules.http-builder',module='http-builder', version='0.7.1')
import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.URLENC
import groovyx.net.http.RESTClient
import groovyx.net.http.HttpResponseException
import static groovyx.net.http.ContentType.*
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

