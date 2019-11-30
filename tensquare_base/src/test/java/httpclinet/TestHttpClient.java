package httpclinet;


import org.apache.commons.codec.Charsets;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/11/27 22:37
 */
public class TestHttpClient {

    public static void main(String[] args) {
        //创建httpclient实例
        HttpClient client = HttpClientBuilder.create().build();
//        // POST请求
//        HttpPost post = new HttpPost(url);
//        // GET请求，URL中带请求参数
//        HttpGet get = new HttpGet(url);

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("PostType","key"));
        list.add(new BasicNameValuePair("loginName","shjgxhxm"));
        list.add(new BasicNameValuePair("pwd","123456"));

        // GET请求方式
        // 由于GET请求的参数是拼装在URL后方，所以需要构建一个完整的URL，再创建HttpGet实例
        try {
            URIBuilder uriBuilder = new URIBuilder("https://www.safe110.net/API/Login.ashx");
            uriBuilder.setParameters(list);
            HttpGet get = new HttpGet(uriBuilder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // POST请求方式
        HttpPost post = new HttpPost("https://www.safe110.net/API/Login.ashx");
        post.setEntity(new UrlEncodedFormEntity(list, Charsets.UTF_8));

        List<NameValuePair> list2 = new ArrayList<>();
        list2.add(new BasicNameValuePair("PostType","key"));
        list2.add(new BasicNameValuePair("loginName","shjgxhxm"));
        list2.add(new BasicNameValuePair("pwd","123456"));

        try {
            String result = HttpClientUtils.getRequest("https://www.safe110.net/API/Login.ashx",list);
            System.out.println("result:" + result);

            String result2 = HttpClientUtils.postForm("https://www.safe110.net/API/Login.ashx",list);
            System.out.println("result2:" + result2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
