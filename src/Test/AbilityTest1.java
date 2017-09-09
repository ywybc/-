package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.NetworkChannel;
import java.text.DecimalFormat;
import java.util.HashMap;

public class AbilityTest1 extends Thread {
   	public static HashMap<Integer, Integer> hashmap=new HashMap<>();
   	String path;
	 public AbilityTest1(String path) {
		// TODO 自动生成的构造函数存根
		this.path=path;
		//this.hashmap=hashmap;
	}
	   @Override
		public void run() {
		   synchronized(hashmap){
			   try {
				BufferedReader bReader=new BufferedReader(new FileReader(new File(path)));
				while(bReader.ready()){
					String[] string=bReader.readLine().split(" ");
					for (int i = 0; i < string.length; i++) {
						int value=(hashmap.get(Integer.valueOf(string[i])));
						hashmap.put(Integer.valueOf(string[i]), ++value);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			   
		   }
			super.run();
		}
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		//大文件分割成四个小文件
		for(int i=10;i<100;i++){
			hashmap.put(i, 0);
		}
		File src=new File("E:\\number.txt");
		File dest=new File("E:\\dest");
		 if (dest.exists()) {
				dest.delete();
			} else {
		        dest.createNewFile();
			}
		 dest.mkdir();
		FileReader fReader=new FileReader(new File("E:\\number.txt"));
		BufferedReader bReader=new BufferedReader(fReader);
		int txtnumber=1;
		int index=1;
		FileWriter fWriter=new FileWriter(new File(dest, createIndex(index++)+".txt"));
		long begin=System.currentTimeMillis();
		while(bReader.ready()){
			if (txtnumber++%500000==0) {
				fWriter.close();
				fWriter=new FileWriter(new File(dest, createIndex(index++))+".txt");
			}
			String line=bReader.readLine();
			fWriter.write(line+"\r\n");
			if(txtnumber%500000==0){
				AbilityTest1 aTest1=new AbilityTest1("E:\\dest\\"+createIndex(index-1)+".txt");
				aTest1.start();
			}
		}
		
		int result=0;
		for(int i=10;i<100;i++){
			result+=hashmap.get(i)*i;
		}
		long end=System.currentTimeMillis();
		long use=end-begin;
		System.out.println("result:"+result);
		System.out.println("开始时间："+begin);
		System.out.println("结束时间："+end);
		System.out.println("使用时间："+use);
		fReader.close();
		bReader.close();
		fWriter.close();
	}

	private static String createIndex(int i) {
		// TODO 自动生成的方法存根
		DecimalFormat df = new DecimalFormat("00");
		return df.format(i);
	}

}
