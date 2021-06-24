package model;

public class AnGynlogy {
	private String nam_khoa;
	private String phu_khoa;
	private String pkid;
	
	public AnGynlogy(String nam_khoa, String phu_khoa, String pkid) {
		super();
		this.nam_khoa = nam_khoa;
		this.phu_khoa = phu_khoa;
		this.pkid = pkid;
	}

	public String getNam_khoa() {
		return nam_khoa;
	}

	public void setNam_khoa(String nam_khoa) {
		this.nam_khoa = nam_khoa;
	}

	public String getPhu_khoa() {
		return phu_khoa;
	}

	public void setPhu_khoa(String phu_khoa) {
		this.phu_khoa = phu_khoa;
	}

	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}
	
	

}
