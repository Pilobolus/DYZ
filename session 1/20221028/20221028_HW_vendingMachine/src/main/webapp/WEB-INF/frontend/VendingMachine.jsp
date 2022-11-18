<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Language" content="zh-tw">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>販賣機</title>
	<style type="text/css">
		.page {
			display:inline-block;
			padding-left: 10px;
		}
	</style>
	<script src="../js/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(startup);

		function startup(){
			
			if(${drinkPage.pageId > 1 }){
				let navPageLast = $("#navPage_last");
				navPageLast.click(change_cart);
				if(${isSearchPage}){
					navPageLast.attr("href", "search_drink?searchKeyword=${param.searchKeyword}&pageId=${drinkPage.pageId-1}");
				}
			}
			for(var i=1; i<=3 && (${drinkPage.basePageId }+i)<=${maxPageId }; i++){
				let navPageI = $("#navPage_" + (${drinkPage.basePageId }+i));
				navPageI.click(change_cart);
				if(${isSearchPage}){
					navPageI.attr("href", "search_drink?searchKeyword=${param.searchKeyword}&pageId=" + (${drinkPage.basePageId }+i));
				}
			}

			if(${drinkPage.pageId < maxPageId }){
				let navPageNext = $("#navPage_next");
				navPageNext.click(change_cart);
				if(${isSearchPage}){
					navPageNext.attr("href", "search_drink?searchKeyword=${param.searchKeyword}&pageId=${drinkPage.pageId+1}");
				}
			}

			if(${checkoutMsgNum>0 }){
				checkoutSheet();
			}
			
			$("#checkoutBtn").click(checkoutBtnClicked);
			$("#searchBtn").click(searchBtnClicked);
			$("#allDrinksBtn").click(allDrinksClicked);

		}

		
		function change_cart(){

			let myBoolean = true;
			let quantities = {};

			if(${drinkPage.pageDrinkCount>0 }){
				
				let drink1Ids = JSON.parse('${drinkPage.drink1IdListJson }').ids;
				let drink1Names = JSON.parse('${drinkPage.drink1NameListJson}').names;

				drink1Ids.forEach(function(value, index){
					let drinkId = parseInt(value);
					let buyQuantity = $("#buyQuantity_" + drinkId).val();

					if(buyQuantity == ''){
						alert("請輸入 \"" + drink1Names[index] + "\" 的數量");
						myBoolean = false;
					}else if(buyQuantity < 0){
						alert("\"" + drink1Names[index] + "\" 的數量不可為負");
						myBoolean = false;
					}
					
					quantities["buyQuantity_" + drinkId] = buyQuantity;
				});
				
				
				if(${drinkPage.pageDrinkCount>3 }){
					let drink2Ids = JSON.parse('${drinkPage.drink2IdListJson }').ids;
					let drink2Names = JSON.parse('${drinkPage.drink2NameListJson}').names;

					drink2Ids.forEach(function(value, index){
						let drinkId = parseInt(value);
						let buyQuantity = $("#buyQuantity_" + drinkId).val();

						if(buyQuantity == ''){
							alert("請輸入 \"" + drink2Names[index] + "\" 數量");
							myBoolean = false;
						}else if(buyQuantity < 0){
							alert("\"" + drink2Names[index] + "\" 數量不可為負");
							myBoolean = false;
						}
						
						quantities["buyQuantity_" + drinkId] = buyQuantity;
					});
				}

				if(!myBoolean){
					return false;
				}
				
				let dataStr = JSON.stringify(quantities);

				
				$.ajax({
					url : "cart",
					type : "POST",
					data : dataStr,
					contentType : "application/json",
					error : function(xhr, textStatus, thrownError){
						console.log(xhr.status);
						console.log(textStatus);
						console.log(thrownError);
					}
				});
				
			}
			return true;

		}

		function checkoutSheet(){
			let templateContent = document.getElementsByTagName("template")[0].content;
			let sheet = document.importNode(templateContent, true);
			let jsonMsg = JSON.parse('${checkoutMsg }');

			let myDiv = sheet.querySelector("div");
			let msgP = myDiv.querySelectorAll("p")[1];

			myDiv.removeChild(msgP);

			for(var i=0; i<${checkoutMsgNum }; i++){
				let temp = msgP.cloneNode(true);
				temp.textContent = jsonMsg["msg_" + i];
				myDiv.appendChild(temp);
			}

			$("#checkoutSheet").append(myDiv);
			
		}
		

		function allDrinksClicked(){
			
			change_cart();
			location.replace("vending_machine?pageId=1");
		}

		function searchBtnClicked(){
			if($("#searchKeyword").val() == ''){
				alert("請輸入關鍵字");
				return false;
			}
			return change_cart();
		}

		function checkoutBtnClicked(){
			change_cart();
			if($("#inputMoney").val() == ''){
				alert("請輸入給付金額");
				return false;
			}else if($("#inputMoney").val() < 0){
				alert("給付金額不可為負");
				return false;
			}
			return true;
		}

	</script>
</head>

<body align="center">
	<table width="1000" align="center">
	
		<tr>
			<td colspan="2" align="right">
				<form action="search_drink" method="get">
					<input type="hidden" name="pageId" value="1" />
					<input type="text" name="searchKeyword" id="searchKeyword" />
					<input type="submit" value="商品查詢" id="searchBtn" />
				</form>
			</td>
		</tr>
		<tr>
			<td width="400" align="center">		
				<img border="0" src="../drinks_image/vending_machine.jpg" width="200" height="200" >			
				<h1>歡迎光臨，${customer_session.name }！</h1>		
				<a href="../nav?destination=goods_list" align="left" id="backEndBtn" >後臺頁面</a>&nbsp; &nbsp;
				<a href="../logout" align="left" onclick="return confirm('確定要登出嗎?')" id="logoutBtn">登出</a>
				<br/><br/>
				<font face="微軟正黑體" size="4" >
					<form method="get" action="checkout">
						<b>投入:</b>
						<input type="number" name="inputMoney" max="100000" min="0" value="0" id="inputMoney" />
						<b>元</b>		
						<input type="submit" value="結帳" id="checkoutBtn" onclick="return confirm('確定要結帳?')">
					</form>
					<br/><br/>
				</font>
				
				<div id="checkoutSheet"></div>

			</td>
			
			<td width="600">
				<table border="1" style="border-collapse: collapse" width="100%" height="100%">
					<tr>
						<c:forEach var="drink" items="${drinkPage.drink1List }">
							<td>							
								<font face="微軟正黑體" size="3" >${drink.name }</font>
								<br/>
								<font face="微軟正黑體" size="4" style="color: gray;">${drink.price } 元/罐</font>
								<br/>
								<img border="0" src="../drinks_image/${drink.image }" width="150" height="150" >						
								<br/>
								<font face="微軟正黑體" size="3">
									購買<input type="number" name="buyQuantity" min="0" max="${drink.quantity }" value="${shoppingCart_session.getDrinkNumber(drink) }" id="buyQuantity_${drink.id }" />罐	
									<br/>
									<p style="color: red;">(庫存 ${drink.quantity } 罐)</p>
								</font>			
							</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="drink" items="${drinkPage.drink2List }">
							<td>
								<font face="微軟正黑體" size="3" >${drink.name }</font>
								<br/>
								<font face="微軟正黑體" size="4" style="color: gray;">${drink.price } 元/罐</font>
								<br/>
								<img border="0" src="../drinks_image/${drink.image }" width="150" height="150" >						
								<br/>
								<font face="微軟正黑體" size="3">
										
									購買<input type="number" name="buyQuantity" min="0" max="${drink.quantity }" value="${shoppingCart_session.getDrinkNumber(drink) }" id="buyQuantity_${drink.id }" />罐	
									<br/>
									<p style="color: red;">(庫存 ${drink.quantity } 罐)</p>
								</font>			
							</td>
						</c:forEach>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<table>
					<tr>
						<td align="left" width="300">
							<button id="allDrinksBtn" type="button">All Drinks</button>
						</td>
						<td align="right" width="300" >
							<c:if test="${drinkPage.pageId>1 }">
								<h3 class="page"> <a href="vending_machine?pageId=${drinkPage.pageId-1 }" id="navPage_last"> 上一頁 </a> </h3>
							</c:if>
				
							<c:forEach var="i" begin="${drinkPage.basePageId+1 }" end="${((drinkPage.basePageId+3)<maxPageId) ? (drinkPage.basePageId+3) : maxPageId }">
								<h3 class="page"> <a href="vending_machine?pageId=${i }" id="navPage_${i }"> ${i } </a> </h3>
							</c:forEach>
						
							<c:if test="${drinkPage.pageId<maxPageId }">
								<h3 class="page"> <a href="vending_machine?pageId=${drinkPage.pageId+1 }" id="navPage_next"> 下一頁 </a> </h3>
							</c:if>
						</td>
					</tr>
				</table>
				
			</td>
		</tr>
	</table>


	<template>
		<div style="border-width:3px;border-style:dashed;border-color:#FFAC55;padding:5px;width:300px;">
			<p style="color: blue;">~~~~~~~ 消費明細 ~~~~~~~</p>
			<p style="margin: 10px;"></p>	
		</div>
	</template>

</body>

</html>