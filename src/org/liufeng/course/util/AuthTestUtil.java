package org.liufeng.course.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wish.www.pojo.Base;

public class AuthTestUtil {
	private static Logger log = LoggerFactory.getLogger(AuthTestUtil.class);
		
		public Boolean authTestBoolean(String apiKey){
			boolean result = false;
			String url = PropertiesUtil.getAuthTest().replace("an_example_api_key", apiKey);
			
			// 发起POST请求创建菜单
			JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", null);

			if (null != jsonObject) {
//				Base bean = (Base) jsonObject.toBean(jsonObject);
				int code = jsonObject.getInt("code");
				if (0 == code) {
					result = true;
					return result;
				} else {
					result = false;
					return result;
				}
			}else{
				System.out.println("error");
				result = false;
				return result;
			}
			
		}
		
		public JSONObject authTestJSONObject(String apiKey){
			
			String url = PropertiesUtil.getAuthTest().replace("an_example_api_key", apiKey);
			// 发起POST请求
			JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", null);

			if (null != jsonObject) {
				return jsonObject;
			}else{
				return null;
			}
			
		}
		
		public Base authTestBase(String apiKey){
			
			String url = PropertiesUtil.getAuthTest().replace("an_example_api_key", apiKey);
			// 发起POST请求
			JSONObject jsonObject = CommonUtil.httpsRequest(url, "POST", null);

			if (null != jsonObject) {
				Base base = new Base();
				base.setMessage(jsonObject.getString("message"));
				base.setCode(jsonObject.getInt("code"));
				JSONObject data = jsonObject.getJSONObject("data");
				if (null != data) {
					String success = data.getString("success");
					base.setSuccess(Boolean.valueOf(success));
				}
				return base;
			}else{
				return null;
			}
			
		}
		
}
