<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>

<body class="error-bg">
<!--content-->
<div class="container-fluid">
  <div class="row">
    <!--.col-sm-9-->
    <div class="main">
		<div class="page-header-error">
			<h2>Ooooops! Sorrrry!</h2>
			<div class="error">500
				<p>시스템에서 예외가 발생했습니다.</p>
				<p class="cause">예상하지 못한 예외가 발생하여, 시스템 사용이 원활하지 못합니다. <br>
				아래 버튼을 이용하여 홈 화면으로 이동할 수 있습니다.</p>
			</div>
  		</div>
    </div>
    <!--/.col-sm-9-->
  </div>
  <form role="form" class="form-horizontal" name = "formSch" method = "post">
		<input type="hidden" id="inputVo" name = "inputVo" value = '${inputVo}' >
  </form>
  <!--/row-->
</div>
<!-- /.container -->
<footer class="footer">
  <div class="right main">
    <div class="col-sm-2 floatR">
      <button type="button" class="btn btn-page  btn-block" id="goHome3">HOME</button>
    </div>
  </div>
</footer>
</body>
	
<!-- 	
<div class="panel" align="center">
	<article>
		<section>
			<section>
				<h1><span class="label label-essential">시스템에서 예외가 발생했습니다.</span></h1>
				<h4 class="panel-title">
				    예상하지 못한 예외가 발생하여, <br />
					시스템 사용이 원할하지 못합니다.<br />
					<br/>
					아래 버튼을 이용하여 HOME 화면으로 이동할 수 있습니다.<br />
				</h4>
			</section>
		</section>
	</article>
	<footer>
		<p>Copyright © 2017 kt All Rights Reserved.</p>
	</footer>
</div>

<footer class="footer">
</footer>
 -->

		
<script>
	$(function(){
		$('#goMainBtn').click(function(){
			location.replace('${ctx}');
			return false;
		});
		
		$('button').button();
		$('.dialog').dialog({
			autoOpen: true,
			resizable: false,
			width: 640,
			height: 'auto',
			modal: false,
			draggable: false,
			closeOnEscape: false
		});

		//windows resize fix
		$(window).bind('resize',function() {
			
			//dialog reposition
			if($('.dialog').hasClass('ui-dialog-content')){
				$('.dialog').dialog({ 
					position: { my:'center',at:'center',of:window }
				});
			}
			
		}).trigger('resize');
		
		//windows scroll fix
		$(window).bind('scroll',function() {

			//dialog reposition
			if($('.dialog').hasClass('ui-dialog-content')){
				$('.dialog').dialog({ 
					position: { my:'center',at:'center',of:window }
				});
			}
			
		}).trigger('scroll');
		
	});
</script>