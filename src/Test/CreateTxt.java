package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTxt {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
     File file=new File("E:\\number.txt");
     if (file.exists()) {
		file.delete();
	} else {
        file.createNewFile();
	}
     BufferedWriter output=new BufferedWriter(new FileWriter(file));
     //产生2000万行，每行10个数，取值在10~99之间的txt文件
      int count=1;
      while(count<=2000000){
    	  int[] ResolveNumber=new int[10];
    	  for (int i = 0; i < ResolveNumber.length; i++) {
			ResolveNumber[i]=(int)(Math.random()*90+10);
		}
    	  for (int i = 0; i < ResolveNumber.length-1; i++) {
			output.write(ResolveNumber[i]+" ");
		}
    	  output.write(ResolveNumber[ResolveNumber.length-1]+"\n");
    	  count++;
      }
      output.close();
      System.out.println("文件已生成");
	}

}
