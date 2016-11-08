<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div>
    <h2>A global Community of friends and strangers spitting out their inner-most
        and personal thoughts on the web for everyone else to see.
    </h2>
    <h3>Look at what these people are spitting right now ...</h3>

    <ol class="spittle-list">
        <%--spittles来之model--%>
        <c:forEach var="spittle" items="${spittles}"><%--遍历Spittle列表--%>
            <s:url value="/spitters/${spitterName}" var="spitter_url"><%--构造相对于上下文的Spitter URL--%>
                <s:param name="spitterName" value="${spittle.spitter.username}"/>
            </s:url>

            <li>
                <span class="spittleListImage">
                    <img src="/resources/images/spitterImages/${spittle.spitter.id}.jpg"
                         width="48"
                         border="0"
                         align="middle"
                         onerror="this.src='<s:url value="/resources/images"/>/spitter_avatar.png';"/>
                </span>

                <span class="spittleListText">
                    <a href="${spitter_url}"><c:out value="${spittle.spitter.username}"/></a><%--展现Spitter属性--%>
                    - <c:out value="${spittle.text}"/> <br/>
                    <small> <fmt:formatDate value="${spittle.when}" pattern="hh:mm MMM d, yyyy"/></small>
                </span>
            </li>
        </c:forEach>
    </ol>
</div>

<br/>
<%--<a href="spitter/json/test">Give me a json (for test)</a>--%>

