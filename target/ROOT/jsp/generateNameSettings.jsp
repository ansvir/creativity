<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form id="settingsForm" action="${pageContext.request.contextPath}/project" method="POST">
            <input type="hidden" name="command" value="name_generation_settings"/>
            <input id="restoreDefaultsValue" type="hidden" name="restoreDefaultsValue" value="false"/>
            <div class="container h-100" style="border: 2px solid black">
                <div class="row">&nbsp;</div>
                <div class="row d-flex justify-content-center">
                    <div id="settingsMsgSuccess" class="alert alert-success"></div>
                    <div id="settingsMsgFail" class="alert alert-danger"></div>
                </div>
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
                            <input id="nameLength" type="number" name="nameLength" class="form-control" min="2"
                                   max="20"/>
                        </div>
                    </div>
                    <div class="col-4 border-left" style="border: 2px solid blue">

                    </div>
                </div>
                <div class="row border-top">
                    <div class="col-4" style="border: 2px solid blue">
                    </div>
                    <div class="col-4 align-items-center text-center" style="border: 2px solid blue">
                        <div class="mb-3 mt-3">
                            <button id="submitSettings" class="btn btn-primary" type="submit" name="submit">
                                Save
                            </button>
                        </div>
                        <div>
                            <button id="restoreDefaults" class="btn btn-primary" type="submit"
                                    name="restoreDefaults">
                                Restore defaults
                            </button>
                        </div>
                    </div>
                    <div class="col-4" style="border: 2px solid blue">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
