import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by phuongdv on 23/03/2017.
 */

public class LogMesgTest {
    String id = "bd2c77d8-0f97-11e7-96ff-0242ac110003";
    String mesg = "demo";
    String status = "running";
    String API_LOG = "http://192.168.23.175:9999/log/";
    String API_LOG_STATUS = "http://192.168.23.175:9999/";

    @Test
    public void testPrintLogMesgJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        LogMesg logMesg = new LogMesg(id, Level.INFO, mesg);
        //Object to JSON in String
        String jsonInString = mapper.writeValueAsString(logMesg);
        System.out.println(jsonInString);
    }

    @Test
    public void testLoggingStatus() throws Exception {
        final LogMonitor logging = LogMonitor.getInstance();
        logging.postStatus(id, status, API_LOG_STATUS);

    }

    @Test
    public void testLoggingLogMessage() throws Exception {
        final LogMonitor logging = LogMonitor.getInstance();
        LogMesg logMesg = new LogMesg(id, Level.ERROR, mesg);
        logging.postToMonitor(logMesg, API_LOG);

    }

}