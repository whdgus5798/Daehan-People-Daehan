DROP TABLE route;


CREATE TABLE route(
    route_img VARCHAR2(100) NOT NULL,		--경로 이미지파일
    route_name VARCHAR2(100) PRIMARY KEY,	--이름
    route_hit NUMBER DEFAULT 0,             --조회수
    route_regdate DATE DEFAULT SYSDATE,		--작성일자 기본값 SYSDATE
    route_schedule VARCHAR2(20),            --일정
    route_theme VARCHAR2(20),               --테마
    route_hashtag VARCHAR2(20),             --태그
    route_content VARCHAR2(1000),			--경로 상세설명
    route_coordinate VARCHAR2(100) NOT NULL,--좌표
    route_addimage1 VARCHAR2(100),          --추가이미지1
    route_addaddress1 VARCHAR2(500),        --추가주소1
    route_addname1 VARCHAR2(100),           --추가이름1
    route_addimage2 VARCHAR2(100),          --추가이미지2
    route_addaddress2 VARCHAR2(500),        --추가주소2
    route_addname2 VARCHAR2(100),           --추가이름2
    route_addimage3 VARCHAR2(100),          --추가이미지3
    route_addaddress3 VARCHAR2(500),        --추가주소3
    route_addname3 VARCHAR2(100)            --추가이름3
    );


    
INSERT INTO route VALUES('sogcho1.png', '가슴 탁 트이는 속초여행', 0, SYSDATE, '1박 2일', '힐링코스', '#추천코스', '복잡하고 답답했던 마음도 깨끗하고 넓은 바다를 보면 해소되는것만 같다. 아름다운 바다 절경을 바라보며 시원한 바닷바람을 맞을 수 있는 그런 곳이 필요하다면? 일반인에게 출입통제 되었다가 65년만에 개방된 외옹치 바다향기로와 해상에 설치된 정자, 영금정이 있는 속초로 떠나보자.', '38.20468231886171,128.59003345591833', 'sogcho2.png', '강원도 속초시 동명항길 35','속초관광수산시장','sogcho3.png','강원도 속초시 동명항길 35','영금정','sogcho4.png','강원도 영월군 한반도면 한반도로 555','한반도지형');
INSERT INTO route VALUES('youngguang1.png', '영광의 유서 깊은 불교 역사와 아름다운 자연탐방', 0, SYSDATE, '1박 2일', '힐링코스', '#추천코스', '백제불교의 최초 도래지, 영광! 유서 깊은 불교문화의 역사를 체험할 수 있는 영광으로 떠나보자. 아름다운 자연을 즐길 수 있는 백수 해안도로와 숲쟁이 숲은 덤이다. 서해안의 아름다운 일몰이 잊지못할 추억을 선사할 것이다.', '35.19697212020854,126.56522837215834', 'youngguang2.png', '전라남도 영광군 불갑면 불갑사로 450','불갑사 관광지','youngguang3.png','전라남도 영광군 불갑면 강항로 101','내산서원','youngguang4.png','전라남도 영광군 백수읍 대신리','백수해안도로');
INSERT INTO route VALUES('PyeongChang1.png', '유유자적 평창 즐기기', 0, SYSDATE, '1박 2일', '힐링코스', '#추천코스', '때론 장소를 옮겨 조용하고 편안한 곳에서의 힐링이 필요하다. 평창으로 떠나보는건 어떨까? 국보들이 전시되어있는 성보박물관과 약 300평의 전시규모를 자랑하는 인형박물관에서 평소 접하지 못했던 전시품들을 관람해보자. 또 싱그러운 자연의 정취를 느낄 수 있는 발왕산관광케이블카와 차박과 은하수 등을 볼수 있어 인기인 산너미목장과 육백마지기에서 아름다운 경치로 힐링해보자.', '37.71923561406730,128.60279045762070', 'PyeongChang2.png', '강원도 평창군 대관령면 솔봉로 296','비엔나 인형박물관','PyeongChang3.png','강원도 평창군 대관령면 올림픽로 715','발왕산 관광케이블카','PyeongChang4.png','강원도 평창군 미탄면 산너미길 210','산너머목장');
INSERT INTO route VALUES('Tongyeong1.png', '지루할 틈이 없다! 통영의 아름다움과 즐거움을 모두 갖춘 여행', 0, SYSDATE, '1박 2일', '힐링코스', '#추천코스', '지루할 틈 없는 통영여행! 통영의 아름다움과 즐거움만 모아봤다. 알록달록 다양한 그림이 그려진 동피랑 벽화마을, 화려한 통영 밤바다, 최근 개장한 디피랑 야경을 보며 통영만의 특색있는 아름다움을 볼 수 있다. 즐길거리 많은 통영. 최대 높이 15m의 국내 최초, 최대 규모의 레포츠 놀이시설인 어드벤처타워와 아토피와 비염, 피부질환에 좋은 편백체험, 짜릿한 스피드를 즐길 수 있는 루지와 카트까지! 통영을 즐기러 떠나보자.', '34.82787433766268,128.42362188342977', 'Tongyeong2.png', '경상남도 통영시 동피랑1길 6-18','동피랑마을','Tongyeong3.png','경상남도 통영시 도남로 269-20','통영밤바다 야경투어','Tongyeong4.png','경상남도 통영시 동호동','디피랑(DPIRANG)');
INSERT INTO route VALUES('Hongsung1.png', '가을 홍성을 즐기는 방법', 0, SYSDATE, '1박 2일', '힐링코스', '#추천코스', '홍성의 가을을 즐기는 방법! 천년의 역사를 품고 있는 홍주성 천년여행길을 걸으며 빨갛게 노랗게 물든 낙엽을 보며 가을이 왔음을 한껏 느껴보자. 제철을 맞은 대하와 새조개를 맛볼 수 있는 남당항 주변에 위치한 앵무새와 교감을 나눠보고, 저녁 노을이 아름다운 어사리 노을공원에서 하루를 마무리 해보는건 어떨까. 곧 돌아올 김장철을 맞이해 광천토굴 새우젓도 구경해보자.', '36.60147444273379,126.6609069556934', 'Hongsung2.png', '충청남도 홍성군 홍북면 이응노로 61-7','고암이응노생가기념관','Hongsung3.png','충청남도 홍성군 서부면 서부로 295-90','아가새농장','Hongsung4.png','충청남도 홍성군 서부면','어사리 노을공원');



SELECT * FROM route;

commit;