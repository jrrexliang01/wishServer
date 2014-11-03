package org.liufeng.course.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ͨ�ù�����
 * 
 * @author liufeng
 * @date 2013-10-17
 */
public class CommonUtil {
	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);

	/**
	 * ����https����
	 * 
	 * @param requestUrl �����ַ
	 * @param requestMethod ����ʽ��GET��POST��
	 * @param outputStr �ύ������
	 * @return JSONObject(ͨ��JSONObject.get(key)�ķ�ʽ��ȡjson���������ֵ)
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		System.out.println("requestUrl================="+requestUrl);
		System.out.println("requestMethod================="+requestMethod);
		System.out.println("outputStr================="+outputStr);
		JSONObject jsonObject = null;
		try {
			// ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// ������SSLContext�����еõ�SSLSocketFactory����
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			
			conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// ��������ʽ��GET/POST��
			conn.setRequestMethod(requestMethod);
			
			// ��outputStr��Ϊnullʱ�������д����
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// ע������ʽ
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			System.out.println("code========["+conn.getResponseCode()+"]======ResponseMessage=====["+conn.getResponseMessage()+"]");
			System.out.println("code========["+conn.getErrorStream()+"]");
			if (conn.getResponseCode() == 200) {
				// ����������ȡ��������
				InputStream inputStream = conn.getInputStream();
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String str = null;
				StringBuffer buffer = new StringBuffer();
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				
				// �ͷ���Դ
				bufferedReader.close();
				inputStreamReader.close();
				inputStream.close();
				inputStream = null;
				conn.disconnect();
				jsonObject = JSONObject.fromObject(buffer.toString());
			}else{
				InputStream errorStream = conn.getErrorStream();
				InputStreamReader inputStreamReader = new InputStreamReader(errorStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String str = null;
				StringBuffer buffer = new StringBuffer();
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				
				// �ͷ���Դ
				bufferedReader.close();
				inputStreamReader.close();
				errorStream.close();
				errorStream = null;
				conn.disconnect();
				jsonObject = JSONObject.fromObject(buffer.toString());
				
				System.out.println("======================================================================================");
				System.out.println("Code========================["+jsonObject.getString("code")+"]");
				System.out.println("Message========================["+jsonObject.getString("message")+"]");
				System.out.println("Data========================["+jsonObject.getString("data")+"]");
				System.out.println("======================================================================================");
//				JDBCUtil jdbcUtil = new JDBCUtil();
//				jdbcUtil.insertWishError(jsonObject.getString("code"), jsonObject.getString("message"), jsonObject.getString("data"));
				return jsonObject;
			}
		} catch (ConnectException ce) {
			log.error("���ӳ�ʱ��{}", ce);
		} catch (Exception e) {
			log.error("https�����쳣��{}", e);
		}
		return jsonObject;
	}

}