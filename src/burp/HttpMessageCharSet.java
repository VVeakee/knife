package burp;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

public class HttpMessageCharSet {
	private static String getSystemCharSet() {
		return Charset.defaultCharset().toString();
	}
	
	public static byte[] covertCharSetToByte(byte[] response) {
		String originalCharSet = getCharset(response);
		//BurpExtender.getStderr().println(url+"---"+originalCharSet);
		if (originalCharSet == null) {
			return response;
		}else {
			byte[] newResponse;
			try {
				newResponse = new String(response,originalCharSet).getBytes(getSystemCharSet());
				return newResponse;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace(BurpExtender.getStderr());
				return response;
			}
		}
	}
	
	public static String getCharset(byte[] requestOrResponse){

		String tmpcharSet = "GBK";//http post的默认编码

		return tmpcharSet;
	}
}

