package board.model;

import java.sql.Date;

public class BoardVO {

	/*
	 	CREATE TABLE board (
		    bd_id NUMBER PRIMARY KEY,           --게시판등록번호(시퀀스 자동등록)
		    bd_writer VARCHAR2(30) NOT NULL,    --작성자(세션에 등록된 로그인된 사람을 불러와서 사용)
		    bd_title VARCHAR2(100) NOT NULL,    --글제목
		    bd_content VARCHAR2(300),           --글내용
		    bd_date DATE DEFAULT SYSDATE,       --글 작성일자(디폴트: 오늘)
		    bd_hit NUMBER DEFAULT 0             --글 조회수
		    );
	 */
	
	int bd_id;
	String bd_writer;
	String bd_title;
	String bd_content;
	Date bd_date;
	int bd_hit;
	
	public BoardVO() {}

	public BoardVO(int bd_id, String bd_writer, String bd_title, String bd_content, Date bd_date, int bd_hit) {
		super();
		this.bd_id = bd_id;
		this.bd_writer = bd_writer;
		this.bd_title = bd_title;
		this.bd_content = bd_content;
		this.bd_date = bd_date;
		this.bd_hit = bd_hit;
	}

	public int getBd_id() {
		return bd_id;
	}

	public void setBd_id(int bd_id) {
		this.bd_id = bd_id;
	}

	public String getBd_writer() {
		return bd_writer;
	}

	public void setBd_writer(String bd_writer) {
		this.bd_writer = bd_writer;
	}

	public String getBd_title() {
		return bd_title;
	}

	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}

	public String getBd_content() {
		return bd_content;
	}

	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}

	public Date getBd_date() {
		return bd_date;
	}

	public void setBd_date(Date bd_date) {
		this.bd_date = bd_date;
	}

	public int getBd_hit() {
		return bd_hit;
	}

	public void setBd_hit(int bd_hit) {
		this.bd_hit = bd_hit;
	}
	
	
	
}
