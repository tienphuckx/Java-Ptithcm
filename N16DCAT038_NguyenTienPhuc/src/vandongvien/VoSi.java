package vandongvien;

public class VoSi extends Nguoi {
	
	private String maVS;
	private String hangCan;
	public String getMaVS() {
		return maVS;
	}
	public void setMaVS(String maVS) {
		this.maVS = maVS;
	}
	public String getHangCan() {
		return hangCan;
	}
	public void setHangCan(String hangCan) {
		this.hangCan = hangCan;
	}
	public VoSi(String ten, String diaChi, String sdt, String maVS, String hangCan) {
		super(ten, diaChi, sdt);
		this.maVS = maVS;
		this.hangCan = hangCan;
	}
	public VoSi(String ten, String diaChi, String sdt) {
		super(ten, diaChi, sdt);
	}
	@Override
	public String toString() {
		
		return "VoSi [maVS=" + maVS + ", hangCan=" + hangCan + "]";
	}
	
	
}
