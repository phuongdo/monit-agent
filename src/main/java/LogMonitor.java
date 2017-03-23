import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phuongdv on 23/03/2017.
 */
public final class LogMonitor {

    static ObjectMapper mapper = new ObjectMapper();

    private static class LogMonitorLoader {
        private static final LogMonitor INSTANCE = new LogMonitor();
    }

    private LogMonitor() {
        if (LogMonitorLoader.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static LogMonitor getInstance() {
        return LogMonitorLoader.INSTANCE;
    }


    public void postStatus(String serviceId, String status, String API_LOG) throws Exception {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(API_LOG);
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("service_id", serviceId));
        params.add(new BasicNameValuePair("log", status));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        //Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
//        HttpEntity entity = response.getEntity();

    }

    public void postToMonitor(LogMesg logMesg, String API_LOG) throws Exception {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(API_LOG);
        httppost.setHeader("Content-Type", "application/json");
        String json = mapper.writeValueAsString(logMesg);
        HttpEntity entity = new ByteArrayEntity(json.getBytes("UTF-8"));
        httppost.setEntity(entity);
        //Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
//        HttpEntity entityR = response.getEntity();
//        System.out.println(entityR.getContent());
    }
}
