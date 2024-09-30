<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 9/30/2024
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <c:if test="${empty rs }">
        <h1>Simple Calculator</h1>
        <form action="<%=request.getContextPath()%>/bai2" method="post" style="border: 1px solid black ; width: 500px ; height: 500px">
            <h3>Calculator</h3>
            <div class="form-group">
                <label for="firstOperand">firstOperand</label>
                <input type="number" class="form-control" name="firstOperand" id="firstOperand">
            </div>

            <div class="form-group">
                <label for="operator">operator</label>
                <select name="operator" id="operator">
                    <option value="addition">addition</option>
                    <option value="subtraction">subtraction</option>
                    <option value="multiplication">multiplication</option>
                    <option value="division">division</option>
                </select>
            </div>

            <div class="form-group">
                <label for="lastOperand">lastOperand</label>
                <input type="number" class="form-control" name="lastOperand" id="lastOperand">
            </div>
            <input type="submit" value="Calculator">
        </form>
    </c:if>

    <c:if test="${ not empty rs }">
        <h1>Result</h1>
        <h3>${firstNumber} + ${lastNumber} = ${rs}</h3>
    </c:if>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
