package model;

public class Surgical {
	private String kham_mat;
	private String kham_tai;
	private String kham_mui;
	private String kham_hong;
	private String kham_rang;
	private String pkid;
	
	public Surgical(String kham_mat, String kham_tai, String kham_mui, String kham_hong, String kham_rang,
			String pkid) {
		super();
		this.kham_mat = kham_mat;
		this.kham_tai = kham_tai;
		this.kham_mui = kham_mui;
		this.kham_hong = kham_hong;
		this.kham_rang = kham_rang;
		this.pkid = pkid;
	}

	public String getKham_mat() {
		return kham_mat;
	}

	public void setKham_mat(String kham_mat) {
		this.kham_mat = kham_mat;
	}

	public String getKham_tai() {
		return kham_tai;
	}

	public void setKham_tai(String kham_tai) {
		this.kham_tai = kham_tai;
	}

	public String getKham_mui() {
		return kham_mui;
	}

	public void setKham_mui(String kham_mui) {
		this.kham_mui = kham_mui;
	}

	public String getKham_hong() {
		return kham_hong;
	}

	public void setKham_hong(String kham_hong) {
		this.kham_hong = kham_hong;
	}

	public String getKham_rang() {
		return kham_rang;
	}

	public void setKham_rang(String kham_rang) {
		this.kham_rang = kham_rang;
	}

	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}
	
	

}
