package model;

import java.io.Serializable;

public class KhachHang implements Serializable, Comparable<KhachHang>
{
	private int kh_ma;
	private String kh_ten;
	private String kh_sdt;
	public int getKh_ma() {
		return kh_ma;
	}
	public void setKh_ma(int kh_ma) {
		this.kh_ma = kh_ma;
	}
	public String getKh_ten() {
		return kh_ten;
	}
	public void setKh_ten(String kh_ten) {
		this.kh_ten = kh_ten;
	}
	public String getKh_sdt() {
		return kh_sdt;
	}
	public void setKh_sdt(String kh_sdt) {
		this.kh_sdt = kh_sdt;
	}
	public KhachHang(int kh_ma, String kh_ten, String kh_sdt) {
		super();
		this.kh_ma = kh_ma;
		this.kh_ten = kh_ten;
		this.kh_sdt = kh_sdt;
	}
	public KhachHang() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.kh_ma+" - "+this.kh_ten+" - "+ this.kh_sdt;
	}
	@Override
	public int compareTo(KhachHang o) {
		return this.kh_sdt.compareToIgnoreCase(o.kh_sdt);
	}
}
