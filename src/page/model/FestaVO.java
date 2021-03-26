package page.model;

public class FestaVO {
	
	/*CREATE TABLE festival (
		    festa_img VARCHAR2(100) NOT NULL,           --이미지파일 이름.jpg
		    festa_name VARCHAR2(100) PRIMARY KEY,       --축제이름
		    festa_period VARCHAR2(30) NOT NULL,         --기간(yyyy.mm.dd~yyyy.mm.dd)
		    festa_content VARCHAR2(1000),               --축제 상세설명
		    festa_tel VARCHAR2(30),                     --기관 전화번호
		    festa_url VARCHAR2(50),                     --홈페이지 url
		    festa_address VARCHAR2(100) NOT NULL,       --상세주소
		    festa_location VARCHAR2(100) NOT NULL,      --행사장소
		    festa_host VARCHAR2(300),                   --주최
		    festa_charge VARCHAR2(50) DEFAULT('무료'),   --요금(입력하지 않을경우 DEFAULT 무료)
		    festa_coodinate VARCHAR2(100) NOT NULL      --좌표(위도,경도)
		    );*/
	private String festa_img;
	private String festa_name;
	private String festa_period;
	private String festa_content;
	private String festa_tel;
	private String festa_url;
	private String festa_address;
	private String festa_location;
	private String festa_host;
	private String festa_charge;
	private String festa_coodinate;
	
	public FestaVO() {}

	public FestaVO(String festa_img, String festa_name, String festa_period, String festa_content, String festa_tel,
			String festa_url, String festa_address, String festa_location, String festa_host, String festa_charge,
			String festa_coodinate) {
		super();
		this.festa_img = festa_img;
		this.festa_name = festa_name;
		this.festa_period = festa_period;
		this.festa_content = festa_content;
		this.festa_tel = festa_tel;
		this.festa_url = festa_url;
		this.festa_address = festa_address;
		this.festa_location = festa_location;
		this.festa_host = festa_host;
		this.festa_charge = festa_charge;
		this.festa_coodinate = festa_coodinate;
	}

	public String getFesta_img() {
		return festa_img;
	}

	public void setFesta_img(String festa_img) {
		this.festa_img = festa_img;
	}

	public String getFesta_name() {
		return festa_name;
	}

	public void setFesta_name(String festa_name) {
		this.festa_name = festa_name;
	}

	public String getFesta_period() {
		return festa_period;
	}

	public void setFesta_period(String festa_period) {
		this.festa_period = festa_period;
	}

	public String getFesta_content() {
		return festa_content;
	}

	public void setFesta_content(String festa_content) {
		this.festa_content = festa_content;
	}

	public String getFesta_tel() {
		return festa_tel;
	}

	public void setFesta_tel(String festa_tel) {
		this.festa_tel = festa_tel;
	}

	public String getFesta_url() {
		return festa_url;
	}

	public void setFesta_url(String festa_url) {
		this.festa_url = festa_url;
	}

	public String getFesta_address() {
		return festa_address;
	}

	public void setFesta_address(String festa_address) {
		this.festa_address = festa_address;
	}

	public String getFesta_location() {
		return festa_location;
	}

	public void setFesta_location(String festa_location) {
		this.festa_location = festa_location;
	}

	public String getFesta_host() {
		return festa_host;
	}

	public void setFesta_host(String festa_host) {
		this.festa_host = festa_host;
	}

	public String getFesta_charge() {
		return festa_charge;
	}

	public void setFesta_charge(String festa_charge) {
		this.festa_charge = festa_charge;
	}

	public String getFesta_coodinate() {
		return festa_coodinate;
	}

	public void setFesta_coodinate(String festa_coodinate) {
		this.festa_coodinate = festa_coodinate;
	}
	
	
	
}
