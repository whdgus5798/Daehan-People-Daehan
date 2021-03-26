package page.model;

public class PopularityVO {
	private String popular_img;
	private String popular_name;
	private String popular_location;
	private String popular_content;
	private String popular_subtitle;
	private String popular_tel;
	private String popular_url;
	private String popular_address;
	private String popular_charge;
	private String popular_coodinate;
	
	public PopularityVO() {}
	
	public PopularityVO(String popular_img, String popular_name, String popular_location, String popular_content,
			String popular_subtitle, String popular_tel, String popular_url, String popular_address,
			String popular_charge, String popular_coodinate) {
		super();
		this.popular_img = popular_img;
		this.popular_name = popular_name;
		this.popular_location = popular_location;
		this.popular_content = popular_content;
		this.popular_subtitle = popular_subtitle;
		this.popular_tel = popular_tel;
		this.popular_url = popular_url;
		this.popular_address = popular_address;
		this.popular_charge = popular_charge;
		this.popular_coodinate = popular_coodinate;
	}
	
	public String getPopular_img() {
		return popular_img;
	}
	public void setPopular_img(String popular_img) {
		this.popular_img = popular_img;
	}
	public String getPopular_name() {
		return popular_name;
	}
	public void setPopular_name(String popular_name) {
		this.popular_name = popular_name;
	}
	public String getPopular_location() {
		return popular_location;
	}
	public void setPopular_location(String popular_location) {
		this.popular_location = popular_location;
	}
	public String getPopular_content() {
		return popular_content;
	}
	public void setPopular_content(String popular_content) {
		this.popular_content = popular_content;
	}
	public String getPopular_subtitle() {
		return popular_subtitle;
	}
	public void setPopular_subtitle(String popular_subtitle) {
		this.popular_subtitle = popular_subtitle;
	}
	public String getPopular_tel() {
		return popular_tel;
	}
	public void setPopular_tel(String popular_tel) {
		this.popular_tel = popular_tel;
	}
	public String getPopular_url() {
		return popular_url;
	}
	public void setPopular_url(String popular_url) {
		this.popular_url = popular_url;
	}
	public String getPopular_address() {
		return popular_address;
	}
	public void setPopular_address(String popular_address) {
		this.popular_address = popular_address;
	}
	public String getPopular_charge() {
		return popular_charge;
	}
	public void setPopular_charge(String popular_charge) {
		this.popular_charge = popular_charge;
	}
	public String getPopular_coodinate() {
		return popular_coodinate;
	}
	public void setPopular_coodinate(String popular_coodinate) {
		this.popular_coodinate = popular_coodinate;
	}
	
	
}
