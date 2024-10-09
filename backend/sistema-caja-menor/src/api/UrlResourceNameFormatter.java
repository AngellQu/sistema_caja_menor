package api;

class UrlResourceNameFormatter {
	
	public static String getFormattedPascalCaseResource(String pathInfo, int formatter) {
		String result = getPascalCaseFromPath(pathInfo);
		result = (result.contains("-")) ? getPascalCaseFromHyphenated(result) : result;
		result = (formatter == 1) ? formatAsJsonResource(result) : result;
		return result;
	}

	public static String getCamelCaseFromParams(String params) {
		String[] words = params.split("-");
		String result = words[0];
		for (int i = 1; i < words.length; i++) {
			result += convertToPascalCase(words[i]);
		}
		return result;
	}
	
	private static String getPascalCaseFromPath(String pathInfo) {
		String[] resource = pathInfo.split("/");
		String name = resource[1];
		return convertToPascalCase(name);
	}

	private static String convertToPascalCase(String word) {
		String firstChar = word.substring(0, 1).toUpperCase();
		return firstChar + word.substring(1);
	}

	private static String getPascalCaseFromHyphenated(String pathInfo) {
		String[] resource = pathInfo.split("-");
		String result = "";
		for (int i = 0; i < resource.length; i++) {
			result += convertToPascalCase(resource[i]);
		}
		return result;
	}

	private static String formatAsJsonResource(String name) {
		return "\"resource\": \"" + name + "\",";
	}
}
