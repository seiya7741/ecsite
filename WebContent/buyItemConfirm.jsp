<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>BuyItemConfirm画面</title>
</head>
<body>

<div id="header">
	</div>
	<div id ="main">
		<div id ="top">
			<p>BuyItemConfirm</p>
		</div>
		<div>

			<table>
				<tr>
					<td>
						<span>商品名</span>
					</td>
					<td>
						<s:property value="session.buyItem_name"/>
					</td>
				</tr>
				<tr>
					<td>
						<span>合計額</span>
					</td>
					<td>
						<s:property value="session.total_price"/>
							<span>円</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>購入個数</span>
					</td>
					<td>
						<s:property value="session.count"/>
							<span>個</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>支払い方法</span>
					</td>
					<td>
						<s:property value="session.pay"/>
					</td>
				</tr>

				<tr>
						<td><br></td>
				</tr>
				<tr>
					<td>
						<s:form action="HomeAction">
							<s:submit type="submit" value="戻る"/>
						</s:form>
					</td>

					<td>
						<s:form action="BuyItemConfirmAction">
							<s:submit type="submit" value="完了"/>
						</s:form>
					</td>


				</tr>
			</table>

	</div>
	<div>
		<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
		<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
	</div>
</div>
	<div id ="footer">
	</div>

</body>
</html>