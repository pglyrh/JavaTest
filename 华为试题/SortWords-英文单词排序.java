package first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * ���ָ���������ļ��ж�ȡ�����е�Ӣ�ĵ��ʣ�ͳ��ÿ��Ӣ�ĵ��ʳ��ֵĴ�����������������д�뵽ָ��������ļ��С� 
 * ����֮�������м��ַ��Ż������Ͻ��зָ�ո�/,/./:/;/?/!/
 * ÿһ�б���һ�����ʺ͸õ��ʳ��ֵĴ�������ʽΪ������:����
 * */

public class SortWords {
    // ��ȡ��д���ļ�·��
	String inFilePath, outFilePath;
	// ������
	HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
	// ����Ϊlist��������
	List<Map.Entry<String, Integer>> infoIds;
	
	public SortWords() {
		// TODO Auto-generated constructor stub
	}
	
	public SortWords(String in, String out){
		this.inFilePath = in;
		this.outFilePath = out;
	}
	
    /**
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
     */
    public void readFileByLines() {
        File file = new File(inFilePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                // tempStringΪ��ǰ�е�string
            	// ����split��������ʽ����string����
                String temp[] = tempString.split("\\s+|\\,|\\.|\\:|\\;|\\?|\\!");
                //	���������ַ���������ÿ���ַ�����������ͳ��
                for (int i = 0; i < temp.length; i++) {
                	String string = temp[i];
                	if (!hashMap.containsKey(string)) {
                		hashMap.put(string, 1);						
					}else {
						int count = (int)hashMap.get(string)+1;
						hashMap.put(string, count);	
					}
				}
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    
    /**
     * �����д���ļ�
     */
    public void writeFile() {
        File file = new File(outFilePath);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));

            // ����List
            for (int i = 0; i < infoIds.size(); i++) {
            	// �����ƴ��Ŀ���ַ�����ʽ
            	Map.Entry<String, Integer> entry = 
            			(Map.Entry<String, Integer>) infoIds.get(i);
            	String key = (String)entry.getKey();
            	int val = (Integer)entry.getValue();
            	String wr = ""+key+":"+val+"\r\n";
            	writer.append(wr);       	
			}
            
//            // ����HashMap
//            Iterator iter = hashMap.entrySet().iterator();
//            while (iter.hasNext()) {
//            	Map.Entry entry = (Map.Entry) iter.next();
//            	String key = (String)entry.getKey();
//            	int val = (Integer)entry.getValue();
//            	String wr = ""+key+":"+val+"\r\n";
////            	System.out.print(wr);
//            	writer.append(wr);
//            }
            
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    // ����
    public void sort(){
    	infoIds = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
        // ���򣬽���
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {   
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {      
                return (o2.getValue() - o1.getValue()); 
            }
        }); 
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortWords sw = new SortWords("input.txt","output.txt");
		sw.readFileByLines();
		sw.sort();
		sw.writeFile();
	}

}
