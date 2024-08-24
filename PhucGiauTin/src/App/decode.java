package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class decode {
	
	public static String get_cover_string(String path) 
	{
		String text = null;
		try {
			File fileDir = new File(path);
	 
			BufferedReader in = new BufferedReader(
			   new InputStreamReader(
	                      new FileInputStream(fileDir), "UTF8"));
	 
			String str;
	 
			while ((str = in.readLine()) != null) {
			    text = str;
			}
	                in.close();
		    }
		    catch (UnsupportedEncodingException e)
		    {
				System.out.println(e.getMessage());
		    }
		    catch (IOException e)
		    {
				System.out.println(e.getMessage());
		    }
		    catch (Exception e)
		    {
				System.out.println(e.getMessage());
		    }
		
		return text;
		
	}
	
	public static String get_cover_str(String link) throws FileNotFoundException
	{
		    String str_cover=null;
	        Path path = Paths.get(link);
	        // Java 8, default UTF-8
	        try (BufferedReader reader = Files.newBufferedReader(path)) 
	        {
	            String str;
	            while ((str = reader.readLine()) != null) 
	            {
	            	str_cover += str;
	            }
	        } catch (IOException e) 
	        {
//	            e.printStackTrace();
	        }
	        return str_cover.toString();
	 }
	
	public static String deCript (String str)
	{
		// mix string = n \u200d g \u200c
		String mix = str;
		
		// Something Will hold bytes in binary after parsing.
		List<String> list = new ArrayList<String>();
		
		String buff = "";
		
		for(int i=0; i<mix.length(); i++)
		{
			if(mix.charAt(i) == '\u200d')
			{
				buff += '1';
			}else if(mix.charAt(i) == '\u200c'){
				buff += '0';
			}
			
			if(buff.length() == 8) {
				list.add(buff);
				buff = "";
			}
			
		}
		// Then convert each to decimal. 010101010 --> 70
		List<Integer> integer_list = new ArrayList<Integer>();
		for(int j=0; j<list.size(); j++)
		{
			String binaryString = list.get(j);
			int decimal=Integer.parseInt(binaryString,2);  
			integer_list.add(decimal);
		}
		
		// Then convert decimal ASCII to char. 70 --> char
		List<String> character_list = new ArrayList<String>();
		for(int k=0; k<integer_list.size(); k++)
		{
			int a = integer_list.get(k);
			char b = (char)a;
			Character c = b;
			character_list.add(c.toString());
			 
		}
		// Return the private string
		
		return String.join("", character_list);
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("INPUT PATH  :");
		String path_of_cover = scanner.nextLine();
		
		String cover = get_cover_string(path_of_cover);
		
		String private_message = deCript(cover);
		
		System.out.print(" --> PRIVATE MESSAGE : ");
		System.out.println(private_message);
		
		
	}

}
