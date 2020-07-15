<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <title>회원 가입폼 </title>
  </head>
  <body>
    <div>
      <div>
        <h1>회원가입</h1>
        <p>회원 정보를 입력하세요.</p>
      </div>
		<form method="post" action="/securityexam/members/join">
          <div>
            <label>이름</label>
            <input type="text" name="name">
          </div>
          <div>
            <label>이메일(ID)</label>
            <input type="email" name="email">
          </div>
          <div>
            <label>암호</label>
            <input type="password" name="password">
          </div>
          <div>
            <label></label>
            <input type="submit" value="회원가입">
          </div>
        </form>
        
    </div>
  </body>