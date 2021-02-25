<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            .<c:out value="${error}" /><br />
        </c:forEach>

     </div>
</c:if>
     <label for="date">日付</label><br />
     <input type="date" name="date" value="<fmt:formatDate value='${resident.date}' pattern='yyyy-MM-dd' />"/>
     <br /><br />

     <label for="room">部屋番号</label><br />
      <c:out value="${resident.room}" />
     <input type="hidden" name="room" value="${resident.room}" />
     <br /><br />

     <label for="resident">入居者</label>
     <input type="text" name="resident" value="${resident.resident}" />
     <br /><br />

     <label for="pro">勤務先</label>
     <input type="text" name="pro" value="${resident.profession}" />
     <br /><br />

     <label for="info">情報</label><br />
     <textarea name="info" rows="10" cols="50">${resident.information}</textarea>
     <br /><br />

     <input type="hidden" name="_token" value="${_token}"/>
     <button type="submit">投稿</button>