<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機-後臺</title>

	<script src="../js/jquery.min.js"></script>
	
	<script type="text/javascript">

		$(document).ready(startUp);
		function startUp(){
			$("#goodsID").change(goodsChange);
			$("#sendButton").click(btn_click);
		}
		
		function goodsChange(){
			let currentDrinkId = $("#goodsID").val();
			$.ajax({
				url : "ajax/modify_change?drinkId=" + currentDrinkId,
				type : "POST",
				dataType : "json",
				success : function(result){
					$("#goodsPrice").val(result.price);
					$("#quantity").text(result.quantity);
					$("input[name='status'][value='" + result.status +"']").prop("checked", true);
				},
				error : function(xhr, textStatus, thrownError){
					console.log(xhr.status);
					console.log(textStatus);
					console.log(thrownError);
				}
			});
		}

		function btn_click(){
			if(check_input()){
				modify_drinks();
			}
		}
		function check_input(){
			let myBoolean = true;

			if($("#goodsPrice").val() == ''){
				alert("請輸入更改的價格");
				myBoolean = false;
			}else if($("#goodsPrice").val() <= 0){
				alert("更改的價格需大於0");
				myBoolean = false;
			}

			if($("#modiQuantity").val() == ''){
				alert("請輸入補貨的數量");
				myBoolean = false;
			}else if($("#modiQuantity").val() < 0){
				alert("補貨的數量需大於等於0");
				myBoolean = false;
			}

			return myBoolean;
		}

		function modify_drinks(){
			$.ajax({
				url : "ajax/modify",
				type : "POST",
				data : $("#myForm").serialize(),
				contenType : "application/x-www-form-urlencoded",
				success : function(){
					$("#msg").text("商品修改成功!");
					goodsChange();
					$("#modiQuantity").val(0);
				},
				error : function(){
					$("#msg").text("商品修改失敗!");
				}
			});
		}

	</script>
</head>
<body>
	<h1>Vending Machine Backend Service</h1><br/>		
	<table border="1" style="border-collapse:collapse;margin-left:25px;">
		<tr>
			<td width="200" height="50" align="center">
				<a href="../nav?destination=goods_list">商品列表</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="../nav?destination=modify">商品維護作業</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="../nav?destination=create">商品新增上架</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="../nav?destination=order">銷售報表</a>
			</td>
			<td width="200" height="50" align="center">
				<a href="../nav?destination=frontend">前台販賣機</a>
			</td>
		</tr>
	</table>
	<br/><br/><HR>


	<h2>商品維護作業</h2><br/>
	<div style="margin-left:25px;">
		<div id="msg" style="color:blue;"></div>
		<form id="myForm">
			<p>
				飲料名稱：<select name="goodsID" id="goodsID">
			 
			 		<c:forEach var="drink" items="${allDrinksList }">
			 			<option value="${drink.id }">${drink.name }</option>
			 		</c:forEach>

				</select>
			</p>
			
			<p>
				更改價格：<input type="number" name="goodsPrice" value="${hasDrinks ? drink1Price : '' }" min="0" max="1000" id="goodsPrice" />
			</p>
			<p>
				商品庫存量：<span id="quantity">${hasDrinks ? drink1Quantity : '' }</span>
			</p>
			<p>
				補貨數量：<input type="number" name="goodsQuantity" value="0" min="0" max="1000" id="modiQuantity">
			</p>
			<p>
				商品狀態：<input type="radio" name="status" value="1" checked />上架
				<input type="radio" name="status" value="0" />下架
			</p>		
			<p>
				<input type="button" value="送出" id="sendButton" />
			</p>
		</form>
	</div>
</body>
</html>