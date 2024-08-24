package App;

public class abc {
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 3;
		arr[6] = 7;
		arr[7] = 8;
		arr[8] = 7;
		arr[9] = 9;
		
//		for(int i=0; i<arr.length; i++)
//		{
//			System.out.print(arr[i]);
//		}
		
		int[] temp_arr = {0,0,0,0,0,0,0,0,0,0};
		
		for(int j=0; j<temp_arr.length; j++)
		{
			temp_arr[arr[j]]++;
		}
		int v = 0;
		for(int g=0; g<temp_arr.length; g++)
		{
			System.out.println(v + " --> Xuat hien : "+ temp_arr[g] + " Lan.");
			v++;
		}
	}
}
