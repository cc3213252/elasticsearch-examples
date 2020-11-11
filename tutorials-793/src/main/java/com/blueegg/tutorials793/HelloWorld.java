package com.blueegg.tutorials793;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.RequestLine;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        RestClient restClient = RestClient.builder(
                new HttpHost("host1", 9200, "http"),
                new HttpHost("host2", 9200, "http")).build();
        Request request = new Request("GET", "/");
        Response response = restClient.performRequest(request);
        RequestLine requestLine = response.getRequestLine();
        HttpHost host = response.getHost();
        int statusCode = response.getStatusLine().getStatusCode();
        Header[] headers = response.getHeaders();
        String responseBody = EntityUtils.toString(response.getEntity());
        System.out.println(responseBody);
        restClient.close();
    }
}
