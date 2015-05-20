package first;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @param inputStr
 *            �����ַ���
 * @param outputStr
 *            ����жϽ��
 * 
 * @description�� �����inputStr�ǺϷ���IP������YES�����򷵻�NO ʾ�� 
 * ���룺10.138.15.1 ���أ�YES
 * ���룺0092.12.1.1 ���أ�NO
 */
public class LegalIP {

	public static void checkIP(String inputStr, StringBuffer outputStr) 
	{	
		if (inputStr != null && !inputStr.isEmpty()) {
//			// ����������ʽ
			String ipReg="(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
					"(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
					"(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
					"(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";
			Pattern pattern = Pattern.compile(ipReg);   
			Matcher matcher = pattern.matcher(inputStr);
			
			if (matcher.matches()) {
				// ƥ��
				System.out.println("matcher: "+"yes");
			}else {
				System.out.println("matcher: "+"no");				
			}

			
			//�Ƚ�inputStr�ԡ�.������
			String[] strings = inputStr.split("\\.");
			
			// ����strings���Ȳ�Ϊ4�򲻺Ϸ�
			if (strings.length != 4) {
				outputStr.append("NO");
				return ;
			}else {
				// ���μ��ÿ���ַ�������ֵ
				for (int i = 0; i < strings.length; i++) {
					String string = strings[i];
					
					// ÿ���ַ������Ȳ��ܳ���3�����򣬲��ǺϷ�IP
					if (string.length()>3) {
						outputStr.append("NO");
						return ;
					}
					
					try {						
						// ���ַ�������ת��int���׳��쳣�����Ϸ�IP
						int a = Integer.parseInt(string);
						// a��ֵ���ܴ���255
						if (a>255) {
							outputStr.append("NO");
							return ;
						}
					} catch (NumberFormatException e) {
						outputStr.append("NO");
						return ;
					}
				}
				
				// �����������IP�Ϸ�
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
