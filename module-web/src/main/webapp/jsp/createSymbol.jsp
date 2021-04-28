<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create a symbol</title>
    <jsp:include page="../jsp/imports.jsp"/>
    <script src="../static/js/createSymbol.js" type="text/javascript"></script>
    <script src="../static/js/createSymbolLogic.js" type="text/javascript"></script>
    <link href="../static/css/painter.css" rel="stylesheet"/>
</head>
<body class="height-100">
<div class="d-flex" id="wrapper">
    <jsp:include page="../jsp/sidebar.jsp"/>
    <div id="page-content-wrapper" class="creativity-bg-3">
        <jsp:include page="../jsp/navbar.jsp">
            <jsp:param name="pageName" value="Create a symbol"/>
        </jsp:include>
        <form id="form" action="${pageContext.request.contextPath}/creativity" method="POST">
            <input id="cultureId" type="hidden" name="cultureId"/>
            <input id="imgUrl" type="hidden" name="imgUrl"/>
            <div class="container-fluid font-weight-bold">
                <div class="row d-flex justify-content-around mt-4">
                    <div class="col">
                        <div class="row h-100">
                            <div class="col-md-1"></div>
                            <div class="col-md-10 border bg-light border-dark rounded">
                                <div class="row">
                                    <div class="col-1"></div>
                                    <div class="col-10">
                                        <div class="form-group mt-2">
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
                                    </div>
                                    <div class="col-1"></div>
                                </div>
                                <div class="row">
                                    <div class="col-1"></div>
                                    <div class="col-10">
                                        <div id="culturesDetails"></div>
                                    </div>
                                    <div class="col-1"></div>
                                </div>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row h-100">
                            <div class="col-md-1">
                            </div>
                            <div id="symbolCreatingBlock" class="col-md-10 text-white border border-white rounded">
                                <div class="row">
                                    <div class="my-2 col d-flex justify-content-center">
                                        Draw
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col d-flex align-items-center justify-content-center">
                                        <button id="drawASymbolButton" class="btn btn-primary btn-lg" type="button"
                                                data-toggle="modal" data-target="#symbolModal">Draw
                                        </button>
                                    </div>
                                    <div class="col d-flex align-items-center justify-content-center">
                                        <div id="figureDiv" class="bg-white border border-dark"
                                             style="width: 200px; height: 200px">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col d-flex justify-content-center">
                                        <div class="form-group d-flex flex-column justify-content-center">
                                            <label for="letterSelect">Key</label>
                                            <select name="key" class="form-control w-auto" id="letterSelect">
                                                <c:forEach var="key" items="${sessionScope.keys}">
                                                    <option value="${key}">${fn:toUpperCase(key)}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col d-flex justify-content-center">
                                        <div class="col-2"></div>
                                        <div class="col-8 d-flex flex-column justify-content-center">
                                            <label for="transcription" class="text-center">
                                                Transcription</label>
                                            <div class="input-group mb-2">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">[</span>
                                                </div>
                                                <input type="text" name="transcription" id="transcription"
                                                       class="form-control input-group-sm"
                                                       placeholder="Transcription here"
                                                       aria-label="Transcription" aria-describedby="basic-addon1">
                                                <div class="input-group-append">
                                                    <span class="input-group-text">]</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-2"></div>
                                    </div>
                                </div>
                                <div class="row my-2 justify-content-around">
                                    <div class="col d-flex justify-content-center">
                                        <button class="btn btn-primary" type="submit" name="command"
                                                value="save_symbol_command">Save
                                        </button>
                                    </div>
                                    <div class="col d-flex justify-content-center">
                                        <a href="#" class="btn btn-primary">Cancel</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-1">
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row h-100">
                            <div class="col-md-1"></div>
                            <div class="col-md-10 bg-light border border-dark rounded text-secondary">
                                <div class="row mt-2 h3 d-flex justify-content-center border-bottom border-dark">
                                    Hints
                                </div>
                                <div class="row d-flex justify-content-center">
                                    <ul class="list-group" style="margin-bottom: 0">
                                        <li class="list-group-item">Draw
                                            <ul class="list-group">
                                                <li class="list-group-item">To draw a symbol click "Draw" button</li>
                                            </ul>
                                        </li>
                                        <li class="list-group-item">Key
                                            <ul class="list-group">
                                                <li class="list-group-item">Keyboard key. This key represents key that
                                                    will be linked to keyboard key and your symbol
                                                </li>
                                            </ul>
                                        </li>
                                        <li class="list-group-item">Transcription
                                            <ul class="list-group">
                                                <li class="list-group-item">Transcription is spelling of the symbol.
                                                    Transcriptions are written in square parenthesis <span
                                                            class="bg-dark text-white">[ ]</span></li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="modal fade" id="symbolModal" tabindex="-1" role="dialog" aria-labelledby="modalCenterTitle"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalTitle">Draw a symbol</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body d-flex justify-content-center">
                <div class="left-block">
                    <label for="drawingLineWidth">Line width:</label>
                    <span id="rangeValue">10</span><input type="range" value="10" min="1" max="50"
                                                          id="drawingLineWidth">
                    <br>
                    <div class="buttons">
                        <button id="drawingMode" class="btn btn-primary" type="button">Format</button>
                        <button id="deleteObject" class="btn btn-primary" type="button">Delete</button>
                        <button id="clear" class="btn btn-primary" type="button">Clear all</button>
                        <button id="save" class="btn btn-primary" type="button">Save</button>
                    </div>
                </div>
                <div class="right-block border">
                    <canvas id="paint-canvas" class="paint-canvas" width="640" height="500"></canvas>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button id="saveSymbolModal" type="button" class="btn btn-primary" data-dismiss="modal">Save changes
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>