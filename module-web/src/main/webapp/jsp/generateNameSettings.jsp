<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Generate name: settings</title>
    <jsp:include page="imports.jsp"/>
    <script src="../static/js/name.generation.js" type="text/javascript"></script>
    <link href="../static/css/slider.css" rel="stylesheet"/>
</head>
<body>
<div class="d-flex" id="wrapper">
    <jsp:include page="sidebar.jsp"/>
    <div id="page-content-wrapper">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="Settings"/>
        </jsp:include>
        <form id="settingsForm" action="${pageContext.request.contextPath}/creativity" method="POST">
            <input type="hidden" name="command" value="name_generation_settings"/>
            <input id="restoreDefaultsValue" type="hidden" name="restoreDefaultsValue" value="false"/>
            <div class="container-fluid creativity-bg-3 text-white font-weight-bold">
                <div class="row d-flex justify-content-center">
                    <div id="settingsMsgSuccess" class="alert alert-success"></div>
                    <div id="settingsMsgFail" class="alert alert-danger"></div>
                </div>
                <div class="row">
                    <div class="col-4 border-right">
                        <div class="p-3 border-bottom">
                            <div class="p-2 d-flex align-items-center justify-content-center mb-3">
                                Setup letters priority in the generated name
                            </div>
                            <c:forEach var="letter" items="${sessionScope.letterList}">
                                <div class="d-flex justify-content-center mb-3">
                                    <div class="text-center">${fn:toUpperCase(letter.symbol)}</div>
                                    &nbsp;
                                    <input id="range-${letter.symbol}" name="range-${letter.symbol}" type="range"
                                           min="0"
                                           max="100" step="5" value="${letter.priority}"/>
                                    &nbsp;
                                    <div id="rangeValue-${letter.symbol}">${letter.priority}</div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="p-3 border-bottom">
                            <div class="p-2 d-flex justify-content-center mb-3">
                                Set up name length
                            </div>
                            <div class="form-group">
                                <input id="nameLength" type="number" name="nameLength" class="form-control" min="2"
                                       max="20" value="${sessionScope.nameLength}"/>
                            </div>
                        </div>
                        <div class="p-3 d-flex flex-column align-items-center justify-content-center border-bottom">
                            <div class="mb-3 p-2">
                                Generate last name
                            </div>
                            <div>
                                <label class="switch">
                                    <input name="generateLastName" type="checkbox" id="generateLastName"
                                           value="${sessionScope.generateLastName}"/>
                                    <span class="slider round"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="col-4 border-left">
                    </div>
                </div>
                <div class="row border-top">
                    <div class="col-4">
                    </div>
                    <div class="col-4 align-items-center text-center">
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
