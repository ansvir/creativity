<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="imports.jsp"/>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="main-form">
            <div class="container-fluid" style="border: 2px solid black">
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
                        <form>
                            <p>
                                Setup letters priority in the generated word
                            </p>
                            <c:forEach begin="0" end="25" step="1" varStatus="i">
                                <p>
                                    ${sessionScope.alphabet[0]}<input type="range" min="0" max="100" step="10">
                                </p>
                            </c:forEach>
                            <button class="btn btn-primary" type="submit" name="submit" value="submit">
                                Submit
                            </button>
                        </form>
                    </div>
                    <div class="col-lg-3" style="border: 2px solid blue">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
