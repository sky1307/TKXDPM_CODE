package utils;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * class dùng để gửi dữ liệu lên và nhận dữ liệu v�? từ server
 * @author Administrator
 *
 */
public class API {
	/**
	 * thuộc tính ngày tháng được format theo định dạng có sẵn
	 */
	public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	/**
	 * thuộc tính v�? các thông tin được log lại
	 */
	private static Logger LOGGER = Utils.getLogger(Utils.class.getName());

	//int var;
	



	/**
	 * lấy phản hồi từ server
	 * @param conn
	 * @return response từ server
	 * @throws IOException
	 */
	private static String readResponse(HttpURLConnection conn) throws IOException {
		BufferedReader in;
		String inputLine;
		if (conn.getResponseCode() / 100 == 2) {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);
		in.close();
		LOGGER.info("Respone Info: " + response.toString());
		return response.toString();
	}
	
	/**
	 * cài đặt kết nối với server
	 * @param url
	 * @param token
	 * @param method
	 * @return kết nối với server
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 */
	private static HttpURLConnection setUpConnection(String url
			//, String token
			, String method)
			throws MalformedURLException, IOException, ProtocolException {
		URL line_api_url = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) line_api_url.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod(method);
		conn.setRequestProperty("Content-Type", "application/json");
		//conn.setRequestProperty("Authorization", "Bearer " + token);
		return conn;
	}

	
	/**
	 * phương thức lấy dữ liệu từ server dưới dạng get
	 * @param url
	 * @param token
	 * @return response: phản hồi từ server (dạng String)
	 * @throws Exception
	 */
	public static String get(String url 
			//, String token
			) throws Exception {
		// cài đặt
		LOGGER.info("Request URL: " + url + "\n");
		HttpURLConnection conn = setUpConnection(url, "GET");
		
		//nhận dữ liệu gửi v�? từ server
		return readResponse(conn);
	}
	
	/**
	 * phương thức gửi dữ liệu lên server dưới dạng post
	 * @param url
	 * @param data
	 * @return response: phản hồi từ server (dạng String)
	 * @throws IOException
	 */
	public static String post(String url, String data
			//, String token
			) throws IOException {
		//cài đặt
		allowMethods("PATCH");
		//String payload = data;
		LOGGER.info("Request Info:\nRequest URL: " + url + "\n" + "Payload Data: " + data + "\n");
		HttpURLConnection conn = setUpConnection(url, "Patch");
		// gửi dữ liệu lên server
		Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		writer.write(data);
		writer.close();
		
		//đ�?c dữ liệu trả v�? từ server
		return readResponse(conn);
	}



	
	/**
	 * phương thức cho phép g�?i các hàm API khác
	 * @param methods
	 */
	private static void allowMethods(String... methods) {
		try {
			Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
			methodsField.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

			String[] oldMethods = (String[]) methodsField.get(null);
			Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
			methodsSet.addAll(Arrays.asList(methods));
			String[] newMethods = methodsSet.toArray(new String[0]);

			methodsField.set(null/* static field */, newMethods);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new IllegalStateException(e);
		}
	}

}

