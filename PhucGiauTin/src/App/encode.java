package App;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class encode{
	
	public static void encript(String public_mess, String private_mess)
	{
		
		String public_str = public_mess;
		String private_str = private_mess;

		String mask = public_str;

		String private_binary = convert_to_binary(private_str); // --> 0101011001
		
		// --> the_man_of_mid[] = {1,3,5,7,8, ..} vitri random tren public
		Integer[] the_man_of_mid = get_rand_index(public_str.length(), private_str.length());
		
		// obj A
		int i_private_binary = 0;
		
		// obj B
		for(int i=0; i<the_man_of_mid.length; i++)
		{
			int i_public_str = the_man_of_mid[i] + i;

			if (private_binary.charAt(i_private_binary) == '1')
			{
				mask = do_insert(mask, '\u200d', i_public_str);	
			}else{
				mask = do_insert(mask, '\u200c', i_public_str);
			}
			++ i_private_binary;
		}

		try{
			FileOutputStream fos = new FileOutputStream("D:\\message.txt");
			
			BufferedWriter buferedWriter = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
			
			buferedWriter.write(mask);
			buferedWriter.close();

		} catch (Exception e){
			System.out.println(e.toString());
		}
	}

	public static String convert_to_binary(String str)
	{
		String[] chars = str.split("");
		List<String> list = new ArrayList<String>();
		for(String c:chars)
		{
			String binary = convert_char_to_binary(c);
			list.add(binary);
		}
		return String.join("", list);
	}

	public static String convert_char_to_binary(String ch)
	{
		StringBuilder stringBuilder = new StringBuilder();
		char[] chars = ch.toCharArray();
		for(char c:chars)
		{
			stringBuilder.append(String.format("%8s", Integer.toBinaryString(c)).replaceAll(" ", "0"));
		}
		return stringBuilder.toString();
	}

	private static String do_insert(String orig, char insert, int index)
	{
		String result = orig.substring(0, index) + insert + orig.substring(index);
		return result;
	}

	private static Integer[] get_rand_index(int orig_len, int pri_len)
	{
		List<Integer> list = new ArrayList<Integer>();
		
		int len_pri_bit = pri_len * 8;
		
		while(len_pri_bit > 0)
		{
			int rand_index = (int) Math.floor(Math.random() * orig_len); //[0-->1] * orig_len -->
			list.add(rand_index);
			-- len_pri_bit;
		}
		Collections.sort(list);
		Integer[] the_man = new Integer[list.size()];
		for(int i=0; i<list.size(); i++)
		{
			the_man[i] = list.get(i);
		}
		return the_man;
	}

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("INPUT PUBLIC MESSAGE : ");
		String pub_mess = scanner.nextLine();
		
		System.out.print("INPUT PRIVATE MESSAGE : ");
		String pri_mess = scanner.nextLine();
		
		encript(pub_mess, pri_mess);
		
		System.out.println("");
		System.out.println("Success !");
	}
}
