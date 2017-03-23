/**
 * Created by phuongdv on 23/03/2017.
 */
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
