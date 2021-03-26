package page.model;

import java.sql.Date;

public class RouteVO {

    private String route_img;
    private String route_name;
    private int route_hit;
    private Date route_regdate;
    private String route_schedule;
    private String route_theme;
    private String route_hashtag;
    private String route_content;
    private String route_coordinate;
    private String route_addimage1;
    private String route_addaddress1;
    private String route_addname1;
    private String route_addimage2;
    private String route_addaddress2;
    private String route_addname2;
    private String route_addimage3;
    private String route_addaddress3;
    private String route_addname3;
    
    public RouteVO() {}

	public RouteVO(String route_img, String route_name, int route_hit, Date route_regdate, String route_schedule,
			String route_theme, String route_hashtag, String route_content, String route_coordinate,
			String route_addimage1, String route_addaddress1, String route_addname1, String route_addimage2,
			String route_addaddress2, String route_addname2, String route_addimage3, String route_addaddress3,
			String route_addname3) {
		super();
		this.route_img = route_img;
		this.route_name = route_name;
		this.route_hit = route_hit;
		this.route_regdate = route_regdate;
		this.route_schedule = route_schedule;
		this.route_theme = route_theme;
		this.route_hashtag = route_hashtag;
		this.route_content = route_content;
		this.route_coordinate = route_coordinate;
		this.route_addimage1 = route_addimage1;
		this.route_addaddress1 = route_addaddress1;
		this.route_addname1 = route_addname1;
		this.route_addimage2 = route_addimage2;
		this.route_addaddress2 = route_addaddress2;
		this.route_addname2 = route_addname2;
		this.route_addimage3 = route_addimage3;
		this.route_addaddress3 = route_addaddress3;
		this.route_addname3 = route_addname3;
	}

	public String getRoute_img() {
		return route_img;
	}

	public void setRoute_img(String route_img) {
		this.route_img = route_img;
	}

	public String getRoute_name() {
		return route_name;
	}

	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}

	public int getRoute_hit() {
		return route_hit;
	}

	public void setRoute_hit(int route_hit) {
		this.route_hit = route_hit;
	}

	public Date getRoute_regdate() {
		return route_regdate;
	}

	public void setRoute_regdate(Date route_regdate) {
		this.route_regdate = route_regdate;
	}

	public String getRoute_schedule() {
		return route_schedule;
	}

	public void setRoute_schedule(String route_schedule) {
		this.route_schedule = route_schedule;
	}

	public String getRoute_theme() {
		return route_theme;
	}

	public void setRoute_theme(String route_theme) {
		this.route_theme = route_theme;
	}

	public String getRoute_hashtag() {
		return route_hashtag;
	}

	public void setRoute_hashtag(String route_hashtag) {
		this.route_hashtag = route_hashtag;
	}

	public String getRoute_content() {
		return route_content;
	}

	public void setRoute_content(String route_content) {
		this.route_content = route_content;
	}

	public String getRoute_coordinate() {
		return route_coordinate;
	}

	public void setRoute_coordinate(String route_coordinate) {
		this.route_coordinate = route_coordinate;
	}

	public String getRoute_addimage1() {
		return route_addimage1;
	}

	public void setRoute_addimage1(String route_addimage1) {
		this.route_addimage1 = route_addimage1;
	}

	public String getRoute_addaddress1() {
		return route_addaddress1;
	}

	public void setRoute_addaddress1(String route_addaddress1) {
		this.route_addaddress1 = route_addaddress1;
	}

	public String getRoute_addname1() {
		return route_addname1;
	}

	public void setRoute_addname1(String route_addname1) {
		this.route_addname1 = route_addname1;
	}

	public String getRoute_addimage2() {
		return route_addimage2;
	}

	public void setRoute_addimage2(String route_addimage2) {
		this.route_addimage2 = route_addimage2;
	}

	public String getRoute_addaddress2() {
		return route_addaddress2;
	}

	public void setRoute_addaddress2(String route_addaddress2) {
		this.route_addaddress2 = route_addaddress2;
	}

	public String getRoute_addname2() {
		return route_addname2;
	}

	public void setRoute_addname2(String route_addname2) {
		this.route_addname2 = route_addname2;
	}

	public String getRoute_addimage3() {
		return route_addimage3;
	}

	public void setRoute_addimage3(String route_addimage3) {
		this.route_addimage3 = route_addimage3;
	}

	public String getRoute_addaddress3() {
		return route_addaddress3;
	}

	public void setRoute_addaddress3(String route_addaddress3) {
		this.route_addaddress3 = route_addaddress3;
	}

	public String getRoute_addname3() {
		return route_addname3;
	}

	public void setRoute_addname3(String route_addname3) {
		this.route_addname3 = route_addname3;
	}
    
    
	
}
