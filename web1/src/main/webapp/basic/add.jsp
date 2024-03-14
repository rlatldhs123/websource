<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
</head>
<body>
    <div class="container">
      <form action="result1.jsp" method="post">
        <div class="mb-3">
          <input type="text" class="form-control" id="num1" placeholder="숫자1" name="num1" size="5"/>
          <input type="text" class="form-control" id="num2" placeholder="숫자2" name="num2" size="5"/>
        </div>
        <div>
          <button type="submit" class="btn btn-success">더하기</button>
        </div>
      </form>
    </div>
</body>
</html>