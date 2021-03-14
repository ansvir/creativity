<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="imports.jsp"/>
<body>
    <jsp:include page="navbar.jsp"/>
    <div class="main-form">
        <div class="container-fluid mt-2" style="border: 2px solid black">
            <div class="row h-100 align-items-center" style="border: 2px solid red">
                <div class="col-lg-2" style="border: 2px solid blue">
                    <div class="d-flex flex-column">
                        <a href="../jsp/generateName.jsp">
                            <div id="generateNameTab" class="bg-light p-2">
                                Generate a name
                            </div>
                        </a>
                        <a href="../jsp/generateNameSettings.jsp">
                            <div class="bg-light p-2">
                                Settings
                            </div>
                        </a>
                        <a href="#">
                            <div class="bg-light p-2">Something</div>
                        </a>
                        <a href="#">
                            <div class="bg-light p-2">Something</div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-7 card card-body bg-light" style="border: 2px solid blue">
                    <div class="container" style="border: 2px solid black">
                        <div class="row">&nbsp;</div>
                        <div class="row">&nbsp;</div>
                        <div class="row">&nbsp;</div>
                        <div class="row">&nbsp;</div>
                    </div>
                    <div class="container" style="border: 2px solid black">
                        <div class="row mb-2" style="border: 2px solid red">
                            <div class="col" style="border: 2px solid blue">
                            </div>
                            <div class="col-6" style="border: 2px solid blue">
                                <div id="output" class="output-style text-center">
                                    Click "Generate a Name"
                                </div>
                            </div>
                            <div class="col d-flex justify-content-start align-items-center" style="border: 2px solid blue">
                                <button id="copyButton" class="btn btn-primary" data-clipboard-target="#output" type="button">Copy</button>
                            </div>
                        </div>
                        <div class="row" style="border: 2px solid red">
                            <div class="col" style="border: 2px solid blue">
                            </div>
                            <div class="col text-center" style="border: 2px solid blue">
                                <button id="generateName" class="btn btn-primary" type="button">Generate a Name</button>
                            </div>
                            <div class="col" style="border: 2px solid blue" >
                                <div class="row" style="border: 2px solid red">
                                    <div class="col d-flex justify-content-end align-items-center h3" style="border: 2px solid blue">1</div>
                                    <div class="col" style="border: 2px solid blue">
                                        <label class="switch">
                                            <input type="checkbox">
                                            <span class="slider round"></span>
                                        </label>
                                    </div>
                                    <div class="col d-flex justify-content-start align-items-center h3" style="border: 2px solid blue">10</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container" style="border: 2px solid black">
                        <div class="row">&nbsp;</div>
                        <div class="row">&nbsp;</div>
                        <div class="row">&nbsp;</div>
                        <div class="row">&nbsp;</div>
                    </div>
                </div>
                <div class="col-lg-3 table-responsive" style="border: 2px solid blue">
                    <table id="namesTable" class="table table-bordered">
                        <thead>
                        <th class="table-active">Generated names</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <td>@twitter</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
