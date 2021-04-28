<html>
<head>
    <title>Generate name</title>
    <jsp:include page="imports.jsp"/>
    <script src="../static/js/name.generation.js" type="text/javascript"></script>
    <link href="../static/css/slider.css" rel="stylesheet"/>
    <link href="../static/css/output.css" rel="stylesheet"/>
</head>
<body>
<div class="d-flex" id="wrapper">
    <jsp:include page="sidebar.jsp"/>
    <div id="page-content-wrapper" class="creativity-bg-3">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="Generate a name"/>
        </jsp:include>
        <div class="container-fluid text-white font-weight-bold">
            <div class="row">
                <div class="col-lg-7 border border-white rounded">
                    <div class="row mb-2">
                        <div class="col">
                        </div>
                        <div class="col-6">
                            <div id="output" class="output-style text-center text-dark">
                                Click "Generate a Name"
                            </div>
                        </div>
                        <div class="col d-flex justify-content-start align-items-center">
                            <button id="copyButton" class="btn btn-primary" data-clipboard-target="#output"
                                    type="button">Copy
                            </button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                        </div>
                        <div class="col text-center">
                            <button id="generateName" class="btn btn-primary" type="button">Generate a Name</button>
                        </div>
                        <div class="col">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col"></div>
                        <div class="col"></div>
                        <div class="col">
                            <div class="row">
                                <div class="col d-flex justify-content-end align-items-center h3">1
                                </div>
                                <div class="col">
                                    <label class="switch">
                                        <input name="amountOfRecordsInOutputCheckbox" type="checkbox">
                                        <span class="slider round"></span>
                                    </label>
                                </div>
                                <div class="col d-flex justify-content-start align-items-center h3">
                                    10
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="row d-flex align-items-center justify-content-center">
                        <div class="tableScrollingY200">
                            <table id="namesTable" class="table table-light table-bordered">
                                <thead>
                                <tr class="table-active">
                                    <th>
                                        Generated names
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td id="emptyTextNameTable" class="text-dark text-center">empty</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col">
                        </div>
                        <div class="col d-flex align-items-center justify-content-center">
                            <button id="clearNamesTableData" class="btn btn-primary">Clear</button>
                        </div>
                        <div class="col">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>