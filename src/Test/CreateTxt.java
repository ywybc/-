package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateTxt {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
     File file=new File("E:\\number.txt");
     if (file.exists()) {
		file.delete();
	} else {
        file.createNewFile();
	}
     BufferedWriter output=new BufferedWriter(new FileWriter(file));
     //����2000���У�ÿ��10������ȡֵ��10~99֮���txt�ļ�
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
      System.out.println("�ļ�������");
	}

}
