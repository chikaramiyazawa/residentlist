<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${resident != null}">
                <h2><c:out value="${resident.room}" />の詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                        <th>部屋番号</th>
                        <td><c:out value="${resident.room}" /></td>
                        </tr>
                        <tr>
                            <th>入居日</th>
                            <td><fmt:formatDate value="${resident.date}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>入居者</th>
                            <td>
                                <c:out value="${resident.resident}" />
                            </td>
                            </tr>
                            <tr>
                                <th>勤務先</th>
                                <td>
                                    <c:out value="${resident.profession}"/>
                                </td>
                             </tr>
                                <th>情報</th>
                                <td>
                                    <c:out value="${resident.information}"/>
                                </td>
                             <tr>
                                <th>更新日時</th>
                                <td>
                                    <fmt:formatDate value="${resident.update_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </td>
                                </tr>
                             </tbody>
                             </table>


                             </c:when>
                             <c:otherwise>
                                <h2>お探しのデータは見つかりませんでした。</h2>
                             </c:otherwise>
                           </c:choose>
                                <p><a href="<c:url value="/resident/edit?id=${resident.id}" />">この日報を編集する</a></p>

                           <p><a href="<c:url value="/resident/index" />">一覧に戻る</a></p>
                       </c:param>
                       </c:import>
