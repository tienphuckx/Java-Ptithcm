package vandongvien;

public class Main {

	public static void main(String[] args) {
		
		// TAO MOI VO SI
//		Nguoi 
		Nguoi phuc = new VoSi("Nguyen TIen Phuc", "HCM", "SDT", "001", "60");
		System.out.println(phuc.toString());
		
		 phuc = new CungThu("Nguyen TIen Phuc", "HCM", "SDT", "001", "60");
		 System.out.println(phuc.toString());
		
	}

}
