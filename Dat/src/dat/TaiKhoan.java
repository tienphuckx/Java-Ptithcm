package dat;


import java.text.NumberFormat;
import java.util.Scanner;

public class TaiKhoan {
	
	private String soTK;
	private String tenTK;
	private double soDu;
	
	public static double latSuat = 0.3;
	
	
	public static double getLatSuat() {
		return latSuat;
	}
	public static void setLatSuat(double latSuat) {
		TaiKhoan.latSuat = latSuat;
	}

	Scanner sc = new Scanner(System.in);
	

	public TaiKhoan() {
		super();
	}


	public TaiKhoan(String soTK, String tenTK, double soDu) {
		super();
		this.soTK = soTK;
		this.tenTK = tenTK;
		this.soDu = soDu;
	}



	public String getSoTK() {
		return soTK;
	}



	public void setSoTK(String soTK) {
		this.soTK = soTK;
	}



	public String getTenTK() {
		return tenTK;
	}



	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}



	public double getSoDu() {
		return soDu;
	}



	public void setSoDu(double soDu) {
		this.soDu = soDu;
	}

	// NOP TIEN
    public void napTien(double soTien) 
    {
        
        if (soTien >= 0) 
        {
            this.soDu += soTien;
            System.out.println("Nạp tiền thành công");
        } else {
            System.out.println("Số tiền nạp không hợp lệ!");
        }
        
    }
	
	
	public void rutTien (double soTien)
	{
		
		double soDu = this.soDu;
		
		if(soTien > 0)
		{
			if(soTien < soDu) 
			{
				this.soDu -= soTien;
			}else {
				System.out.println("Tài khoản không đủ tiền để rút.");
			}
			
		}else {
			System.out.println("Số tiền rút không hợp lệ !");
		}
	}
	
	public  String ThongTinTK()
	{
		String info = "";
		info +=  "Account information :";
		info +=  "Tên : " + this.tenTK + "--" + "STK: " + this.soTK + "---" + "Số dư " + this.soDu;
		
		return info;
	}
	
	public void tinhLai()
	{
		double tienLai = this.soDu * this.latSuat;
		System.out.println("So tien lai phai dong la " + tienLai);
	}
	
	// MAIN
	public static void main(String[] args) 
	{
		TaiKhoan tk = new TaiKhoan("123456","Nguyen Van A" , 0);
		tk.napTien(5000000);
		tk.rutTien(3000000);
		tk.setLatSuat(0.03);
		tk.tinhLai();
	}

}