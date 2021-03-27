<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create a symbol</title>
    <jsp:include page="../jsp/imports.jsp"/>
    <link href="../static/css/painter.css" rel="stylesheet"/>
</head>
<body>
<div class="d-flex" id="wrapper">
    <jsp:include page="../jsp/sidebar.jsp"/>
    <div id="page-content-wrapper">
        <jsp:include page="../jsp/navbar.jsp">
            <jsp:param name="pageName" value="Create a symbol"/>
        </jsp:include>
        <form action="creativity" method="POST">
            <input type="hidden" name="command" value="create_symbol_command"/>
            <div class="container h-100" style="border: 2px solid black">
                <div class="row" style="border:2px solid red">
                    <div class="col-8 border-right">
                        <div class="row" style="border:2px solid red">
                            <div class="col d-flex justify-content-center" style="border:2px solid blue">
                                Draw a symbol
                            </div>
                        </div>
                        <div class="row" style="border:2px solid red">
                            <div class="col d-flex align-items-center justify-content-center" style="border:2px solid blue">
                                <button id="drawASymbolButton" class="btn btn-primary btn-lg" type="button" data-toggle="modal" data-target="#symbolModal">Draw</button>
                            </div>
                            <div class="col d-flex align-items-center justify-content-center" style="border:2px solid blue">
                                <canvas id="symbolCanvas" width="200" height="200"></canvas>
                            </div>
                        </div>
                        <div class="row" style="border:2px solid red">
                            <div class="col d-flex justify-content-center" style="border:2px solid blue">
                                <div class="form-group d-flex flex-column justify-content-center">
                                    <label for="letterSelect">Choose a corresponding letter on the keyboard</label>
                                    <select class="form-control w-auto" id="letterSelect">
                                        <c:forEach var="letter" items="${sessionScope.letterList}">
                                            <option name="letter-${letter.symbol}">${fn:toUpperCase(letter.symbol)}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="border:2px solid red">
                            <div class="col d-flex justify-content-center" style="border:2px solid blue">
                                <div class="col"></div>
                                <div class="col d-flex flex-column justify-content-center">
                                    <label for="transcription" class="text-center">Enter transcription</label>
                                    <div class="input-group mb-2">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">[</span>
                                        </div>
                                        <input type="text" name="transcription" id="transcription" class="form-control input-group-sm" placeholder="Transcription here" aria-label="Transcription" aria-describedby="basic-addon1">
                                        <div class="input-group-append">
                                            <span class="input-group-text">]</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col"></div>
                            </div>
                        </div>
                        <div class="row mt-2 justify-content-around">
                            <div class="col d-flex justify-content-center">
                                <button class="btn btn-primary" type="submit">Save</button>
                            </div>
                            <div class="col d-flex justify-content-center">
                                <a href="#" class="btn btn-primary">Cancel</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-4 text-secondary">
                        <div class="row h3 d-flex justify-content-center border-bottom">
                            Hints
                        </div>
                        <div class="row d-flex justify-content-center">
                            Some hint
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="modal fade" id="symbolModal" tabindex="-1" role="dialog" aria-labelledby="modalCenterTitle" aria-hidden="true">
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
                    <span id="rangeValue">10</span><input type="range" value="10" min="1" max="50" id="drawingLineWidth">
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
                <button id="saveSymbolModal" type="button" class="btn btn-primary" data-dismiss="modal">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>