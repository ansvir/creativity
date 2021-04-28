<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <button class="btn btn-primary" id="menu-toggle">Hide menu</button>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="mx-auto order-0">
            <div class="navbar-brand mx-auto">${param.pageName}</div>
        </div>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href="../jsp/signin.jsp">Sign in <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <form action="${pageContext.request.contextPath}/creativity" method="POST">
                    <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                        <li class="nav-item dropdown">
                            <a class="nav-link" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Hello, ${sessionScope.user.name}!
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="../jsp/home.jsp">Home</a>
                                <button type=submit name="command" value="logout" class="dropdown-item">Log out</button>
                            </div>
                        </li>
                    </ul>
                </form>
            </c:otherwise>
        </c:choose>

    </div>
</nav>
