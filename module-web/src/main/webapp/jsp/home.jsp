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
            <jsp:param name="pageName" value="Home"/>
        </jsp:include>
        <div class="container h-100">
            <div class="row border-bottom pb-3">
                <div class="col-8 d-flex flex-column align-items-center justify-content-center">
                    <div class="h1" style="font-family: 'Lobster', cursive;">
                        Good&nbsp;<span id="partOfADay"></span>,&nbsp;<span class="text-primary">${sessionScope.user.name}</span>!
                    </div>
                    <div class="h1" style="font-family: 'Lobster', cursive">What to start from today?</div>
                </div>
                <div class="col-4 d-flex align-items-end">
                    <img src="../static/images/user.svg" class="img-fluid" style="width:200px; height:200px"/>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col h3 d-flex align-items-center justify-content-center">
                    Click "generate a name" or directly navigate to "settings"!
                </div>
            </div>
            <div class="row mt-5">
                <div class="col d-flex align-items-center">
                    <div class="col-2">
                    </div>
                    <div class="col-8 d-flex justify-content-end">
                        <a class="btn btn-primary btn-lg" href="../jsp/generateName.jsp">Generate a name</a>
                    </div>
                    <div class="col-2">
                    </div>
                </div>
                <div class="col">
                    <div class="col">
                    </div>
                    <div class="col d-flex justify-content-start">
                        <a class="btn btn-primary btn-lg" href="../jsp/generateNameSettings.jsp">Settings</a>
                    </div>
                    <div class="col">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
