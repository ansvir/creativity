<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Language editor</title>
    <jsp:include page="imports.jsp"/>
    <script>let languages = ${sessionScope.languagesJsonArray};</script>
    <script>let cultures = ${sessionScope.culturesJsonArray};</script>
</head>
<body>
<div class="d-flex" id="wrapper">
    <jsp:include page="sidebar.jsp"/>
    <div id="page-content-wrapper">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="Language editor"/>
        </jsp:include>
        <div class="container h-100" style="border: 2px solid black">
            <div class="row">
                <div class="col"></div>
                <div class="col">Your languages</div>
                <div class="col"></div>
            </div>
            <form action="creativity" method="POST">
                <input type="hidden" name="command" value="language_editor"/>
                <div class="row">
                    <div class="col-4">
                        <div class="form-group">
                            <label for="selectLanguage">Select language</label>
                            <select class="form-control" id="selectLanguage">
                                <option>None</option>
                                <c:if test="${not empty sessionScope.languages}">
                                    <c:forEach var="language" items="${sessionScope.languages}">
                                        <option name="language" id="language${language.id}"
                                                value="${language.id}">${language.name}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div id="cultureDetails">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-8">
                        <div class="row" id="languageDetails">
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="alphabetModal" tabindex="-1" role="dialog"
                     aria-labelledby="modalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="modalTitle">Alphabet</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body d-flex justify-content-center">
                                <div class="tableScrollingY500">
                                    <table id="alphabetTableModal" class="table table-bordered">
                                        <thead>
                                        <tr class="table-active">
                                            <th>
                                                Symbol
                                            </th>
                                            <th>
                                                Keyboard key
                                            </th>
                                            <th>
                                                Transcription
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:choose>
                                            <c:when test="${empty requestScope.alphabet}">
                                                <tr>
                                                    <td colspan="3" id="emptyTextAlphabetTableModal"
                                                        class="text-dark text-center">
                                                        You have no symbols yet
                                                    </td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach var="symbol" items="${requestScope.alphabet}">
                                                    <tr>
                                                        <td class="text-center"><img
                                                                src="${pageContext.request.contextPath}/symbol/figures/${symbol.id}"
                                                                alt="Symbol ${symbol.key}" width="35" height="35">
                                                        </td>
                                                        <td class="text-center">${symbol.key}</td>
                                                        <td class="text-center">[${symbol.transcription}]</td>
                                                    </tr>
                                                </c:forEach>
                                            </c:otherwise>
                                        </c:choose>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>