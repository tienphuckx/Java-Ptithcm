package vandongvien;

public abstract class Nguoi {
	private String ten;
	private String diaChi;
	private String sdt;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public Nguoi(String ten, String diaChi, String sdt) {
		super();
		this.ten = ten;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}
	@Override
	public String toString() {
		return "Nguoi [ten=" + ten + ", diaChi=" + diaChi + ", sdt=" + sdt + "]";
	}
	
	
}
