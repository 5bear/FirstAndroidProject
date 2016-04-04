package HttpConnect;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhanShaoxiong on 2015/10/8.
 */
public class HttpConnect {
    /**
     * 发送GET请求
     *
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public  String sendGet(String url, Map<String, String> parameters) {
        String result = "";// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if (parameters.size() == 1) {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8"));
                }
                params = sb.toString();
            } else {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            String full_url = url + "?" + params;
            System.out.println(full_url);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                    .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : headers.keySet()) {
                System.out.println(key + "\t：\t" + headers.get(key));
            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                    .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    /**
     * 发送POST请求
     *
     * @param urlstr
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public  String sendPost(String urlstr, Map<String, String> parameters) throws IOException {
        String resultData = "";
        URL url = new URL(urlstr);
        StringBuffer sb = new StringBuffer();// 处理请求参数
//获得HttpConnection连接实例

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

/************************此段代码去掉然后将urlStr后面加上?username=..**参数的话就可以直接成为Get传值***************/

//因为这个是post请求,需要设置为true

        conn.setDoOutput(true);

        conn.setDoInput(true);

//设置以Post方式

        conn.setRequestMethod("POST");

//Post请求不能使用缓存

        conn.setUseCaches(false);

        conn.setInstanceFollowRedirects(true);

//配置本次连接的Content-type,配置为application/x-www.form-urlencoded

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        DataOutputStream out = new DataOutputStream(conn.getOutputStream());

//上传的参数

        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if (parameters.size() == 1) {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8"));
                }
                params = sb.toString();
            } else {
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),
                                    "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }

//写入流中

            out.writeBytes(params);

//刷新，关闭

            out.flush();

            out.close();

/*****************************************************************/

            BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine = null;

            while ((inputLine = buffer.readLine()) != null) {

                resultData += inputLine + " ";

            }
        } catch (Exception e) {

            return "失败";
        }
        return resultData;
    }
}
