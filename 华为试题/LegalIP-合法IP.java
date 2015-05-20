package first;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @param inputStr
 *            输入字符串
 * @param outputStr
 *            输出判断结果
 * 
 * @description： 输入的inputStr是合法的IP，返回YES，否则返回NO 示例 
 * 输入：10.138.15.1 返回：YES
 * 输入：0092.12.1.1 返回：NO
 */
public class LegalIP {

	public static void checkIP(String inputStr, StringBuffer outputStr) 
	{	
		if (inputStr != null && !inputStr.isEmpty()) {
//			// 定义正则表达式
			String ipReg="(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
					"(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
					"(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
					"(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
			Pattern pattern = Pattern.compile(ipReg);   
			Matcher matcher = pattern.matcher(inputStr);
			
			if (matcher.matches()) {
				// 匹配
				System.out.println("matcher: "+"yes");
			}else {
				System.out.println("matcher: "+"no");				
			}

			
			//先将inputStr以“.”划分
			String[] strings = inputStr.split("\\.");
			
			// 不是strings长度不为4则不合法
			if (strings.length != 4) {
				outputStr.append("NO");
				return ;
			}else {
				// 依次检查每个字符串的数值
				for (int i = 0; i < strings.length; i++) {
					String string = strings[i];
					
					// 每个字符串长度不能超过3，否则，不是合法IP
					if (string.length()>3) {
						outputStr.append("NO");
						return ;
					}
					
					try {						
						// 若字符串不能转成int则抛出异常，不合法IP
						int a = Integer.parseInt(string);
						// a的值不能大于255
						if (a>255) {
							outputStr.append("NO");
							return ;
						}
					} catch (NumberFormatException e) {
						outputStr.append("NO");
						return ;
					}
				}
				
				// 其他情况表明IP合法
				outputStr.append("Yes");
			}
			
		}else {
			outputStr.append("NO");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		checkIP("0092.12", buffer);
		System.out.println("res: "+buffer.toString());
		
		buffer = new StringBuffer();
		checkIP("0092.12.1.1", buffer);
		System.out.println("res: "+buffer.toString());
		
		buffer = new StringBuffer();
		checkIP("192.168.0.0", buffer);
		System.out.println("res: "+buffer.toString());
	}

}
