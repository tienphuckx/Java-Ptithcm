package thuephong;

public class Phong {
	private String ma;
	private String loai;
	private int gia;
	
	
	
	@Override
	public String toString() {
		return " [Ma phong=" + ma + ", Loai phong=" + loai + ", Gia phong=" + gia + " /24h ]";
	}



	public Phong() {
		super();
	}



	public Phong(String ma, String loai, int gia) {
		super();
		this.ma = ma;
		this.loai = loai;
		this.gia = gia;
	}



	// phong don, phong doi, phong vip
	public String getMa() {
		return ma;
	}



	public void setMa(String ma) {
		this.ma = ma;
	}



	public String getLoai() {
		return loai;
	}



	public void setLoai(String loai) {
		this.loai = loai;
	}



	public int getGia() {
		return gia;
	}



	public void setGia(int gia) {
		this.gia = gia;
	}


	// PHUONG THUC TAO PHONG MOI
	protected void taoPhongMoi(String ma, String loai, int gia)
	{
		
		Phong phong = new Phong(ma, loai, gia);
		phong.toString();
	}
	
}
