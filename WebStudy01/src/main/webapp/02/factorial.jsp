<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript" src ="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</head>
<body>
<form id="factorialForm">
	<input type="number" name ="operand"  value ="${number }"/>
</form>
<pre>
1. 반복문 : scriptlet
2. 재귀 호출 : declaration
3. 피연산자 선택 UI
4. Model1 -> Model2
5. 비동기.
<br>
2. 재귀 호출<br>
${number }! = ${result }
</pre>
<span id = "resultArea"></span>
<script>
	const PATTERN = "%O! = %R";
	$(":input[name]").on("change",function(){
		$(this).parents("form:first").submit();
	});
	$(document).on("submit", "#factorialForm",function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize(); // query string
		
		$.ajax({
			url: url,
			method : method,
			data: data,
			dataType: "json",
			success: function(resp){
			
				$("#resultArea").html(
						PATTERN.replace("%O",resp.operand)
								.replace("%R",resp.result)
						);
			},
			error: function(errorResp){
				console.log(errorResp.status);
			}
		});
		
		
		return false;
		
	})
</script>





</body>
</html>