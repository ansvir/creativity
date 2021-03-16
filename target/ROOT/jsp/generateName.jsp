<html>
<head>
    <title>Generate name</title>
    <jsp:include page="imports.jsp"/>
</head>
<body>
<div class="d-flex" id="wrapper">
    <jsp:include page="sidebar.jsp"/>
    <div id="page-content-wrapper">
        <jsp:include page="navbar.jsp">
            <jsp:param name="pageName" value="Generate a name"/>
        </jsp:include>
        <div class="container h-100" style="border: 2px solid black">
            <div class="row">&nbsp;</div>
            <div class="row">&nbsp;</div>
            <div class="row">&nbsp;</div>
            <div class="row" style="border: 2px solid red">
                <div class="col-lg-7 card card-body bg-light" style="border: 2px solid blue">
                    <div class="container" style="border: 2px solid black">
                        <div class="row mb-2" style="border: 2px solid red">
                            <div class="col" style="border: 2px solid blue">
                            </div>
                            <div class="col-6" style="border: 2px solid blue">
                                <div id="output" class="output-style text-center">
                                    Click "Generate a Name"
                                </div>
                            </div>
                            <div class="col d-flex justify-content-start align-items-center"
                                 style="border: 2px solid blue">
                                <button id="copyButton" class="btn btn-primary" data-clipboard-target="#output"
                                        type="button">Copy
                                </button>
                            </div>
                        </div>
                        <div class="row" style="border: 2px solid red">
                            <div class="col" style="border: 2px solid blue">
                            </div>
                            <div class="col text-center" style="border: 2px solid blue">
                                <button id="generateName" class="btn btn-primary" type="button">Generate a Name</button>
                            </div>
                            <div class="col" style="border: 2px solid blue">
                            </div>
                        </div>
                    </div>
                    <div class="container" style="border: 2px solid black">
                        <div class="row">
                            <div class="col"></div>
                            <div class="col"></div>
                            <div class="col">
                                <div class="row" style="border: 2px solid red">
                                    <div class="col d-flex justify-content-end align-items-center h3"
                                         style="border: 2px solid blue">1
                                    </div>
                                    <div class="col" style="border: 2px solid blue">
                                        <label class="switch">
                                            <input name="amountOfRecordsInOutputCheckbox" type="checkbox">
                                            <span class="slider round"></span>
                                        </label>
                                    </div>
                                    <div class="col d-flex justify-content-start align-items-center h3"
                                         style="border: 2px solid blue">10
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5" style="border: 2px solid blue">
                    <div class="row d-flex align-items-center justify-content-center">
                        <table id="namesTable" class="table table-bordered" style="border: 2px solid purple">
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