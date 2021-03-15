<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Generate name: settings</title>
    <jsp:include page="imports.jsp"/>
</head>
<body>
<div class="d-flex" id="wrapper">
    <jsp:include page="sidebar.jsp"/>
    <div id="page-content-wrapper">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="Settings"/>
        </jsp:include>
        <form action="${pageContext.request.contextPath}/project" method="POST">
            <input type="hidden" name="command" value="name_generation_settings"/>
            <input id="restoreDefaultsValue" type="hidden" name="restoreDefaultsValue" value="false"/>
            <div class="container h-100" style="border: 2px solid black">
                <div class="row">&nbsp;</div>
                <div class="row">&nbsp;</div>
                <div class="row">&nbsp;</div>
                <div class="row h-100" style="border: 2px solid red">
                    <div class="col-4 border-right" style="border: 2px solid blue">
                        <div class="d-flex align-items-center p-3">
                            Setup letters priority in the generated word
                        </div>
                        <c:forEach var="letter" items="${sessionScope.letterList}">
                            <div class="d-flex justify-content-center mb-3">
                                <div class="text-center bg-light border">${fn:toUpperCase(letter.symbol)}</div>
                                &nbsp;
                                <input id="range-${letter.symbol}" name="range-${letter.symbol}" type="range" min="0"
                                       max="100" step="10"/>
                                &nbsp;
                                <div id="rangeValue-${letter.symbol}"></div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="col-4" style="border: 2px solid blue">
                        <div class="p-3 d-flex justify-content-center">
                            Set up name length
                        </div>
                        <div class="form-group">
                            <input type="number" name="nameLength" class="form-control" min="2" max="20"/>
                        </div>
                        <%--                            <c:choose>--%>
                        <%--                                <c:when test="${not empty requestScope.settingsSaved and requestScope.settingsSaved}">--%>
                        <%--                                    <div class="alert alert-success">Settings were saved!</div>--%>
                        <%--                                </c:when>--%>
                        <%--                                <c:when test="${not empty requestScope.settingsSaved and not requestScope.settingsSaved}">--%>
                        <%--                                    <div class="alert alert-danger">Sorry, settings weren't saved</div>--%>
                        <%--                                </c:when>--%>
                        <%--                                <c:otherwise>--%>
                        <%--                                    <div class="alert alert-danger">Sorry, server error</div>--%>
                        <%--                                </c:otherwise>--%>
                        <%--                            </c:choose>--%>

                    </div>
                    <div class="col-4 border-left" style="border: 2px solid blue"></div>
                </div>
                <div class="row border-top">
                    <div class="col-4">
                    </div>
                    <div class="col-4 text-center">
                        <div class="mb-3">
                            <button id="submitSettings" class="btn btn-primary" type="submit" name="submit">
                                Submit
                            </button>
                        </div>
                        <div>
                            <button id="restoreDefaults" class="btn btn-primary" type="submit" name="restoreDefaults">
                                Restore defaults
                            </button>
                        </div>
                    </div>
                    <div class="col-4">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
