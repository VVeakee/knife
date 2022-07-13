package U2C;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

import burp.BurpExtender;
import burp.Getter;
import burp.IExtensionHelpers;

public class CharSetHelper {

	public static String getSystemCharSet() {
		return Charset.defaultCharset().toString();
	}

	/**
	 * 进行响应包的编码转换。
	 * @param response
	 * @return 转换后的格式的byte[]
	 */
	public static byte[] covertCharSet(byte[] response,String originalCharset,String newCharset) {
		if (originalCharset == null) {
			return response;
		}else {
			byte[] newResponse;
			try {
				newResponse = new String(response,originalCharset).getBytes(newCharset);
				return newResponse;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace(BurpExtender.getStderr());
				return response;
			}
		}
	}

	/**
	 * utf8 utf-8都是可以的。
	 * @param requestOrResponse
	 * @return
	 */
	public static String detectCharset(byte[] requestOrResponse){
		
		//3、http post的默认编码
		return "GBK";
	}
}

