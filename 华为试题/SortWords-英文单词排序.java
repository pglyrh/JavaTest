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
 * 请从指定的输入文件中读取出所有的英文单词，统计每个英文单词出现的次数，结果经过排序后写入到指定的输出文件中。 
 * 单词之间以下列几种符号或符号组合进行分割：空格/,/./:/;/?/!/
 * 每一行保存一个单词和该单词出现的次数，格式为：单词:次数
 * */

public class SortWords {
    // 读取、写入文件路径
	String inFilePath, outFilePath;
	// 保存结果
	HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
	// 保存为list方便排序
	List<Map.Entry<String, Integer>> infoIds;
	
	public SortWords() {
		// TODO Auto-generated constructor stub
	}
	
	public SortWords(String in, String out){
		this.inFilePath = in;
		this.outFilePath = out;
	}
	
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public void readFileByLines() {
        File file = new File(inFilePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // tempString为当前行的string
            	// 利用split和正则表达式，将string隔开
                String temp[] = tempString.split("\\s+|\\,|\\.|\\:|\\;|\\?|\\!");
                //	遍历本行字符串数组中每个字符串，并进行统计
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
     * 将结果写入文件
     */
    public void writeFile() {
        File file = new File(outFilePath);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));

            // 遍历List
            for (int i = 0; i < infoIds.size(); i++) {
            	// 将结果拼成目标字符串格式
            	Map.Entry<String, Integer> entry = 
            			(Map.Entry<String, Integer>) infoIds.get(i);
            	String key = (String)entry.getKey();
            	int val = (Integer)entry.getValue();
            	String wr = ""+key+":"+val+"\r\n";
            	writer.append(wr);       	
			}
            
//            // 遍历HashMap
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

    // 排序
    public void sort(){
    	infoIds = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
        // 排序，降序
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
