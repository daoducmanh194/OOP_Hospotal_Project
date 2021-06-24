package model;

public class Ostetric {
	private String huyetApTTT;
	private String huyetApTTD;
	private int dienTim;
	private String sieuamOBung;
	private String sieuamTuyenGiap;
	private String pkid;
	
	public Ostetric(String huyetApTTT, String huyetApTTD, int dienTim, String sieuamOBung, String sieuamTuyenGiap,
			String pkid) {
		super();
		this.huyetApTTT = huyetApTTT;
		this.huyetApTTD = huyetApTTD;
		this.dienTim = dienTim;
		this.sieuamOBung = sieuamOBung;
		this.sieuamTuyenGiap = sieuamTuyenGiap;
		this.pkid = pkid;
	}

	public String getHuyetApTTT() {
		return huyetApTTT;
	}

	public void setHuyetApTTT(String huyetApTTT) {
		this.huyetApTTT = huyetApTTT;
	}

	public String getHuyetApTTD() {
		return huyetApTTD;
	}

	public void setHuyetApTTD(String huyetApTTD) {
		this.huyetApTTD = huyetApTTD;
	}

	public int getDienTim() {
		return dienTim;
	}

	public void setDienTim(int dienTim) {
		this.dienTim = dienTim;
	}

	public String getSieuamOBung() {
		return sieuamOBung;
	}

	public void setSieuamOBung(String sieuamOBung) {
		this.sieuamOBung = sieuamOBung;
	}

	public String getSieuamTuyenGiap() {
		return sieuamTuyenGiap;
	}

	public void setSieuamTuyenGiap(String sieuamTuyenGiap) {
		this.sieuamTuyenGiap = sieuamTuyenGiap;
	}

	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}
	
}
