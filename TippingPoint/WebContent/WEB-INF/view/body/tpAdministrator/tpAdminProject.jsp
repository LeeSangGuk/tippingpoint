<%@ page contentType="text/html;charset=UTF-8"%>


	<!-- 게시판 상세보기 -->


	 
		<P ><!-- align="center" -->
			<FONT size="5"><B>프로젝트 상세보기</B></FONT>
		</P>
	
			<div>
				프로젝트ID : ${requestScope.polist.tppId }
			</div>
			<br/>
			
			<div>
				제목 : ${requestScope.polist.tppTitle }
			</div>
			<br/>
			
			<div>
				작성자 : ${requestScope.polist.tppWriter }
			</div>
			<br/>
			
			<div>
				작성일자 : ${requestScope.polist.tppWriteDate}
			</div>
			<br/>
			
			<div>
				모인 금액 : ${requestScope.polist.tppTotalAmount }
			</div>
			<br/>
			
			<div>
				목표 금액 : ${requestScope.polist.tppTargetAmount }
			</div>
			<br/>
			
			<div>
				시작일 : ${requestScope.polist.tppFundingStartDate }
			</div>
			<br/>
			
			<div>
				마감일 : ${requestScope.polist.tppFundingLastDate}
			</div>
			<br/>
			
			<div>
				후원자수 : ${requestScope.polist.tppFunderNum}
			</div>
			<br/>
			
			<div>
				설명문 : ${requestScope.polist.tppProjectContent }
			</div>
			<br/>
			
			<div>
				프로젝트 대기상태 : ${requestScope.polist.tppState }
			</div>
			<br/>

   <form name = "confirm" action="/TippingPoint/tpAdminProjectStateConvert.tp" method="post">
      <input type = "hidden" name ="tppId" value = '${requestScope.polist.tppId }'>
      <input type = "hidden" name = "tppState" value = "O">
      <label>프로젝트 승인메세지 : <input type = "text" name = "tppAdminMessage" /></label>
      <input type="submit" value="요청승인">
   </form>
	

  <form name = "reject" action="/TippingPoint/tpAdminProjectStateConvert.tp" method="post">
       <input type = "hidden" name ="tppId" value = '${requestScope.polist.tppId }'>
      <input type = "hidden" name = "tppState" value = "X">
      <label>프로젝트 거부메세지 : <input type = "text" name = "tppAdminMessage" /></label>
      <input type="submit" value="요청거부">
   </form>


<br/>
<a href="/TippingPoint/tpAdminProjectBoard.tp">등록 신청한 목록 조회 페이지로 이동</a>
<br/>
<a href="/TippingPoint/adminCheckAndMain.tp">관리자 메인 페이지로 이동</a>

