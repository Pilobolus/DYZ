<%@ page import="bean.dao.OrderDAO"%>
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
			$("#searchButton").click(formBtnClicked);
			linkHref();
		}

		function formBtnClicked(){
			let myBoolean = true;
			if($("#queryStartDate").val() == ''){
				alert("請選擇起始日期");
				myBoolean = false;
			}
			if($("#queryEndDate").val() == ''){
				alert("請選擇結束日期");
				myBoolean = false;
			}
			else if(myBoolean && $("#queryStartDate").val() > $("#queryEndDate").val()){
				alert("起始日期必須早於結束日期");
				myBoolean = false;
			}
			
			return myBoolean;
		}

		function linkHref(){
			if(${isSearchPage==false}){
				return;
			}

			if(${orderPage.pageId>1 }){
				$("#navPage_last").attr("href", "searchOrder?queryStartDate=${param.queryStartDate}&queryEndDate=${param.queryEndDate}&pageId=${orderPage.pageId-1}");
			}

			for(var i=${orderPage.basePageId+1 }; i<=${((orderPage.basePageId+3)<maxPageId) ? (orderPage.basePageId+3) : maxPageId }; i++){
				$("#navPage_" + i).attr("href", "searchOrder?queryStartDate=${param.queryStartDate}&queryEndDate=${param.queryEndDate}&pageId=" + i);
			}

			if(${orderPage.pageId<maxPageId }){
				$("#navPage_next").attr("href", "searchOrder?queryStartDate=${param.queryStartDate}&queryEndDate=${param.queryEndDate}&pageId=${orderPage.pageId+1}");
			}
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
	
	
		
	<h2>銷售報表</h2><br/>
	<div style="margin-left:25px;">
		<table>
			<tr>
				<td>
					<form method="get" action="searchOrder">
						<input type="hidden" name="pageId" value="1" />
						起 &nbsp; <input type="date" name="queryStartDate" style="height:25px;width:180px;font-size:16px;text-align:center;" value="${param.queryStartDate }" id="queryStartDate" />
						&nbsp;
						迄 &nbsp; <input type="date" name="queryEndDate" style="height:25px;width:180px;font-size:16px;text-align:center;" value="${param.queryEndDate }" id="queryEndDate" />	
						<input type="submit" value="查詢" style="margin-left:25px; width:50px;height:32px" id="searchButton" />
					</form>
					<br/>
				</td>
			</tr>
			<tr>
				<td>
					<table border="1">
						<thead align="center">
							<tr height="50">
								<th width="100">顧客姓名</th>
								<th width="150">購買日期</th>
								<th width="200">飲料名稱</th>
								<th width="100">飲料價格</th>
								<th width="100">購買數量</th>
								<th width="100">購買金額</th>
							</tr>
						</thead>
						<tbody align="center">

							<c:forEach var="order" items="${orderPage.objectList }">
								<tr height="30">
									<td>${OrderDAO.INSTANCE.getCustomerNameFromOrder(order) }</td>
									<td>${order.date }</td>
									<td>${OrderDAO.INSTANCE.getDrinkNameFromOrder(order) }</td>
									<td>${order.goodsBuyPrice }</td>
									<td>${order.buyQuantity }</td>
									<td>${order.goodsBuyPrice * order.buyQuantity }</td>
								</tr>
							</c:forEach>

						</tbody>
					</table> 
					<br />
				</td>
			</tr>
			<tr>
				<td>
					<div style="font-size: 16">
						<c:if test="${orderPage.pageId>1 }">
							<a href="ordersList?pageId=${orderPage.pageId-1 }" id="navPage_last">上一頁</a>
						</c:if>

						<c:forEach var="i" begin="${orderPage.basePageId+1 }"
							end="${((orderPage.basePageId+3)<maxPageId) ? (orderPage.basePageId+3) : maxPageId }">
							<a href="ordersList?pageId=${i }" id="navPage_${i }">${i }</a>
						</c:forEach>

						<c:if test="${orderPage.pageId<maxPageId }">
							<a href="ordersList?pageId=${orderPage.pageId+1 }" id="navPage_next">下一頁</a>
						</c:if>
					</div>
				</td>
				<td align="right">
					<br/>
					<button type="submit" onclick="return location.replace('../nav?destination=order');">All Orders</button>
				</td>
			</tr>
		</table>
		
	
		
		
		
		
	</div>
</body>
</html>