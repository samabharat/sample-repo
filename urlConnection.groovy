import groovy.json.JsonSlurper
String url = "https://api.github.com/user"

def getData(String url,
                   String userName,
                   String password) {
    def authString = ("${userName}:${password}").getBytes().encodeBase64().toString()
    def connection = (url).toURL().openConnection()
    connection.addRequestProperty('Authorization', 'Basic ' + authString)
    connection.addRequestProperty('Content-Type', 'application/json')
    connection.setRequestMethod('GET')
    connection.setReadTimeout(30000)
    try {
        connection.connect()
        def line = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine()
        def jsonSlurper = new JsonSlurper()
        def response=jsonSlurper.parseText(line)
        return response

    } finally {
        connection.disconnect();
    }
}

def myData = getData(url,"username","password")
println(myData) 
// To access individual response object just use myData.login etc...
//println(myData.logi
