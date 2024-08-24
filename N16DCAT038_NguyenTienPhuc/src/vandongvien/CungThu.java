package vandongvien;

public class CungThu extends Nguoi {
	private String maCungThu;
	private String clb;
	
	public CungThu(String ten, String diaChi, String sdt) {
		super(ten, diaChi, sdt);
	}
	public CungThu(String ten, String diaChi, String sdt, String maCungThu, String clb) {
		super(ten, diaChi, sdt);
		this.maCungThu = maCungThu;
		this.clb = clb;
	}
	public String getMaCungThu() {
		return maCungThu;
	}
	public void setMaCungThu(String maCungThu) {
		this.maCungThu = maCungThu;
	}
	public String getClb() {
		return clb;
	}
	public void setClb(String clb) {
		this.clb = clb;
	}
	@Override
	public String toString() {
		return "CungThu [maCungThu=" + maCungThu + ", clb=" + clb + "]";
	}
	
	
}
