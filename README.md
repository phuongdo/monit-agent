Java logging library for for Go Monitor


### Getting started

Add your local Maven Repository.
```xml
<repositories>
    <repository>
        <id>adopt</id>
        <url>http://192.168.23.191:8081/nexus/content/repositories/12/</url>
    </repository>
    <repository>
        <id>mavencentral</id>
        <name>Maven Central</name>
        <url>https://repo1.maven.org/maven2/</url>
        <layout>default</layout>
    </repository>
</repositories>
```

Then, import httpclient library to your pom.xml file
```xml
<dependency>
    <groupId>org.vcc</groupId>
    <artifactId>monit-agent</artifactId>
    <version>17.03</version>
</dependency>
```
### Basic Example

```java
public class MainExample {

    public static void main(String[] args) throws Exception {


        final LogMonitor logging = LogMonitor.getInstance();
        String serviceId = "bd2c77d8-0f97-11e7-96ff-0242ac110003";
        // Send status to Monitor
        String status = "running";
        String API_LOG_STATUS = "http://192.168.23.175:9999/";
        logging.postStatus(serviceId, status, API_LOG_STATUS);
        // Send ERROR/INFO message for logging purpose
        String API_LOG = "http://192.168.23.175:9999/log/";
        String mesg = "demo";
        LogMesg logMesg = new LogMesg(serviceId, Level.ERROR, mesg);
        logging.postToMonitor(logMesg, API_LOG);
    }
}

```