CREATE TABLE members (
    user_id VARCHAR2(30) PRIMARY KEY,   --아이디
    user_pw VARCHAR2(30) NOT NULL,      --비밀번호
    user_name VARCHAR2(30)NOT NULL      --이름
    );
    
CREATE TABLE board (
    bd_id NUMBER PRIMARY KEY,           --게시판등록번호(시퀀스 자동등록)
    bd_writer VARCHAR2(30) NOT NULL,    --작성자(세션에 등록된 로그인된 사람을 불러와서 사용)
    bd_title VARCHAR2(100) NOT NULL,    --글제목
    bd_content VARCHAR2(300),           --글내용
    bd_date DATE DEFAULT SYSDATE,       --글 작성일자(디폴트: 오늘)
    bd_hit NUMBER DEFAULT 0             --글 조회수
    );
    
CREATE SEQUENCE board_sequence
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE
    NOCYCLE;
    
INSERT INTO members VALUES ('aaa111', 'abc123', '홍길동');
INSERT INTO members VALUES ('aaa222', 'abc123', '고길동');
INSERT INTO members VALUES ('aaa333', 'abc123', '박길동');
SELECT * FROM members;

INSERT INTO board VALUES (board_sequence.NEXTVAL, 'aaa111', '글제목', '글내용', SYSDATE, 0);
INSERT INTO board VALUES (board_sequence.NEXTVAL, 'aaa222', '글제목2', '글내용2', SYSDATE, 0);
INSERT INTO board VALUES (board_sequence.NEXTVAL, 'aaa333', '글제목3', '글내용3', SYSDATE, 0);
SELECT * FROM board;

COMMIT;