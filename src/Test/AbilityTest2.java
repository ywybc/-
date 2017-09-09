package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class AbilityTest2 {

	public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
		//String pathname="C:\\Users\\Administrator\\Desktop\\number.txt";
		String pathname="E:\\number.txt";
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathname))));
		String line=null;
		long count=0;
		int number=0;
		ArrayList<Long> list=new ArrayList<>();
		long beginTime=System.currentTimeMillis();
		while((line=reader.readLine())!=null){	
			 String[] strings=line.split(" ");
			if(number<10000){
		       // line=reader.readLine();
			for (String string : strings) {
				count+=Integer.valueOf(string);
			   }
			   number++;
			}
			else {
				list.add(count);
				count=0;
				//�ֶδ�����
				for (String string : strings) {
					count+=Integer.valueOf(string);
				   }
				number=number%10000;
			}	
			
		}
		list.add(count);
		reader.close();
		//���ﻹ�����
		String result="";
		for (int i = 0; i < list.size(); i++) {
			//����ط������üӺ�
			 result=add(result,String.valueOf(list.get(i)));
		}
		//�������õ�0
		int index=0;
		while(result.charAt(index)=='0'){
			index++;
		}
		result=result.substring(index, result.length()-1);
		long endTime=System.currentTimeMillis();
		long useTime=endTime-beginTime;
		System.out.println("��ʼʱ�䣺"+beginTime);
		System.out.println("����ʱ�䣺"+endTime);
		System.out.println("ʹ�õ�ʱ�䣺"+useTime);
		System.out.println("result="+result);
	}
	
	
//�����������������
	private static String add(String number1, String number2) {
		// TODO �Զ����ɵķ������
		String result="";
		String num1=new StringBuffer(number1).reverse().toString();
		String num2=new StringBuffer(number2).reverse().toString();
		int len1=num1.length();
		int len2=num2.length();
		int maxlen=len1>len2?len1:len2;
		//�洢���
		int[] nSum=new int[maxlen+1];
		//�Ƿ��н�λ
		boolean nOverFlow=false;
		if (len1>len2) {
			//����
			for (int i = len2; i < len1; i++) {
				num2+="0";
			}
			
		} else if (len1<len2) {
			//����
			for (int i = len1; i < len2; i++) {
				num1+="0";
			}
			
		}
		
		//�������
		for (int i = 0; i < maxlen; i++) {
			if (nOverFlow) {
				nSum[i]=Integer.parseInt(num1.charAt(i)+"")+Integer.parseInt(num2.charAt(i)+"")+1;
			} else {
                nSum[i]=Integer.parseInt(num1.charAt(i)+"")+Integer.parseInt(num2.charAt(i)+"");
			}
		
		//�ж��Ƿ��н�λ
		    if (nSum[i]>=10) {
			nSum[i]=nSum[i]-10;
			nOverFlow=true;
		    } else {
           nOverFlow=false;
		    }
		}
		
		//�������λ
		if (nOverFlow) {
			nSum[maxlen]=1;
		} else {
            nSum[maxlen]=0;
		}
		
		//ת��Ϊ�ַ������
		for (int i = 0; i < nSum.length; i++) {
			result+=String.valueOf(nSum[i]);
		}
		result=new StringBuffer(result).reverse().toString();
		return result;
	}

}
