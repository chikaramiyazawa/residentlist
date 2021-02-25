<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="../layout/app.jsp">
     <c:param name="content">
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            .<c:out value="${error}" /><br />
        </c:forEach>

     </div>
</c:if>

<h2>日付後日検索画面</h2>
 <form method="POST" action= "<c:url value='/resident/date/after/serach'/>">

 <label for="date">日付</label><br />
     <input type="date" name="date" value="<fmt:formatDate value='${resident.date}' pattern='yyyy-MM-dd' />"/>
     <br /><br />

     <input type="hidden" name="_token" value="${_token}"/>
     <button type="submit">投稿</button>
    </form>

     <p><a href="<c:url value='/resident/index' />">一覧に戻る</a></p>
     </c:param>
 </c:import>