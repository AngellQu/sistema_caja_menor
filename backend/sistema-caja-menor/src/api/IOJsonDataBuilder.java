package api;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class IOJsonDataBuilder {

	public static String getRequestToString(InputStream data, String pathInfo) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(data));
		StringBuilder stringData = new StringBuilder();
		String line;
		stringData.append(bf.readLine());
		stringData.append(UrlResourceNameFormatter.getFormattedPascalCaseResource(pathInfo, 1));
		while ((line = bf.readLine()) != null) {
			stringData.append(line);
		}
		return stringData.toString();
	}

	public static byte[] getResponseToStream(String result) throws IOException {
		ByteArrayOutputStream response = new ByteArrayOutputStream();
		response.write(result.getBytes());
		return response.toByteArray();
	}

	public static Map<String, String> urlToMapString(Map<String, String[]> parameters, String pathInfo) {
		Map<String, String> result = new HashMap<>();
		result.put("resource", UrlResourceNameFormatter.getFormattedPascalCaseResource(pathInfo, 0));
		for (Map.Entry<String, String[]> params : parameters.entrySet()) {
			String key = params.getKey();
			key = (params.getKey().contains("-")) ? UrlResourceNameFormatter.getCamelCaseFromParams(key) : key;
			String value = params.getValue()[0];
			result.put(key, value);
		}
		return result;
	}
}
