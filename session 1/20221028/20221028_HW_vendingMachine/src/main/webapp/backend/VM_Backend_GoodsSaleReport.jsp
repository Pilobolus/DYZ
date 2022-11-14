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
		<form method="get" action="searchOrder">
			起 &nbsp; <input type="date" name="queryStartDate" style="height:25px;width:180px;font-size:16px;text-align:center;" value="${startDate }" id="queryStartDate" />
			&nbsp;
			迄 &nbsp; <input type="date" name="queryEndDate" style="height:25px;width:180px;font-size:16px;text-align:center;" value="${endDate }" id="queryEndDate" />	
			<input type="submit" value="查詢" style="margin-left:25px; width:50px;height:32px" id="searchButton" />
		</form>
	
		<br/>
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
					
				<c:forEach var="order" items="${orderList }">
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
		<br/>
		
		<div style="font-size: 16">
			<c:if test="${pageId>1 }">
				<a href="go_order?pageId=${pageId-1 }">上一頁</a>
			</c:if>
		
			<c:forEach var="i" begin="${baseId+1 }" end="${((baseId+3)<maxPage) ? (baseId+3) : maxPage }">
				<a href="go_order?pageId=${i }">${i }</a>
			</c:forEach>
		
			<c:if test="${pageId<maxPage }">
				<a href="go_order?pageId=${pageId+1 }">下一頁</a>
			</c:if>
		</div>
	</div>
</body>
</html>