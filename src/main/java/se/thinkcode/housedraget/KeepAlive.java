package se.thinkcode.housedraget;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class KeepAlive implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(KeepAlive.class);

    @Override
    public void run() {
        Date endDate = getEndDate();
        Date now = new Date();

        if (now.before(endDate)) {
            keepAlive();
        }
    }

    private Date getEndDate() {
        Calendar calendar = GregorianCalendar.getInstance();

        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 19);

        return calendar.getTime();
    }

    private void keepAlive() {
        LOGGER.info("Keep alive");
        URI uri = getUri();
        HttpGet httpget = new HttpGet(uri);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try (CloseableHttpResponse response = httpclient.execute(httpget)) {
            response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private URI getUri() {
        try {
            return new URIBuilder()
                    .setScheme("http")
                    .setHost("www.housedraget.se")
                    .setPath("/")
                    .build();
        } catch (URISyntaxException e) {
            LOGGER.warn(e.getMessage());
        }

        return null;
    }
}
