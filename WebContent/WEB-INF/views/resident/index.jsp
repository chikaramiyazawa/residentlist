<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>入居者一覧</h2>

          <p><a href="<c:url value='/resident/room/search'/>">部屋番号検索</a>

          <p><a href="<c:url value='/resident/search'/>">入居者検索</a>

          <p><a href="<c:url value='/resident/date/search'/>">日付検索</a>

        <table id="resident_list">
            <tbody>
                <tr>
                    <th class="resident_room">部屋番号</th>
                    <th class="resident_date">入居日</th>
                    <th class="resident_resident">入居者</th>
                    <th class="resident_profession">勤務先</th>
                    <th class="resident_action">操作</th>
               </tr>
               <c:forEach var="resident" items="${resident}" varStatus="status">
                <tr class="row${status.count % 2}">
                    <td class="resident_room"><c:out value="${resident.room}"/></td>
                    <td class="resident_date"><fmt:formatDate value='${resident.date}' pattern='yyyy-MM-dd' /></td>
                    <td class="resident_resident"><c:out value="${resident.resident}"/></td>
                     <td class="resident_profession"><c:out value="${resident.profession}"/></td>
                    <td class="resident_action"><a href="<c:url value='/resident/show?id=${resident.id}'/>">詳細を見る</a></td>
                    </tr>
               </c:forEach>
               </tbody>
               </table>

               <div id="pagination">
                (全 ${resident_count} 件) <br />
                <c:forEach var="i" begin="1" end="${((resident_count -1) /15) + 1}" step="1">
                    <c:choose>
                        <c:when test="${i == page}">
                            <c:out value="${i}" />&nbsp;
                        </c:when>
                        <c:otherwise>
                        <a href="<c:url value='/resident/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                 </c:choose>
                </c:forEach>
                </div>
                <p><a href="<c:url value='/resident/new' />">入居者登録</a></p>

                </c:param>
            </c:import>

