# Smart Order 포트폴리오, [[URL]](http://211.200.100.168:9100/)

프로젝트명 : Smart Order  

수행 : 배기훈

프로젝트 소개 :  
            메뉴의 변화가 자주 있을 수 있는 식당에서 메뉴판을 가져다 주지 않아도  
            고객이 메뉴를 간편하게 볼 수 있으며 주문할 수 있는 시스템을 만들고 싶었습니다. 
            고객은 QR코드로 접속을 하게되면 자동으로 로그인창으로 이동을 하고 기존에 로그인이 되어있었다면 주문페이지로 이동하게됩니다.  
            QR코드에는 고객이 방문한 식당이름과 테이블번호가 파라미터로 들어가있습니다.  
            ajax를 이용하여 페이지 이동없이 원하는 메뉴 섹터의 메뉴를 가져올 수 있고, 그것에 대해 ajax를 이용하여  
            모달창에 메뉴의 상세정보를 출력합니다.  
            원하는 메뉴를 카트에 담을 수 있습니다.    
            Kakao API 를 이용하여 위치정보를 받아올 수 있게 구현했습니다.  

![기훈이네김밥천국닉네임테이블1번](https://user-images.githubusercontent.com/63835963/96061362-fc5d7580-0ecd-11eb-9309-e8da519073f5.png)    


-회원  
회원가입, 회원정보수정, 회원삭제, 닉네임 중복검사, 로그인 구현  
-게시판  
게시글작성, 게시글전체조회, 게시글상세조회, 게시글상세조회시 조회수 증가, 게시글수정(본인글 선택시), 게시글삭제(본인글 선택시)   
-관리자    
메뉴추가, 메뉴수정, 메뉴삭제, 관리자 회원정보수정 및 회원 탈퇴, 모든 게시판 글의 권한을 부여하여 삭제 구현.  
-메뉴  
메뉴조회, 메뉴카트담기, 카트에 담은 리스트 가져오기.  

개발환경 :  Operating System: Windows 10, Mac OS X  
          Database: MySQL  
          Web Application Server: Apache Tomcat 9.0  
          Programming Language: JAVA 1.8  
          IDE: STS 3  
          Framework: Spring, MyBatis  
          SCM: Git Hub  
          Test: JUnit  
          Build Tool: Maven  
            
