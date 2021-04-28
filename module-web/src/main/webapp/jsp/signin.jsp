<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creativity: Sign in</title>
    <jsp:include page="imports.jsp"/>
    <script src="../static/js/auth.js" type="text/javascript"></script>
    <link href="../static/css/signin.css" rel="stylesheet"/>
</head>
<body class="text-center">
    <div>
        <form action="${pageContext.request.contextPath}/creativity" method="post" class="form-signin">
            <input type="hidden" name="command" value="signin"/>
            <img class="img-fluid mb-3" src="../static/images/logo.png" alt="">
            <h1 class="h3 mb-4 font-weight-normal text-white" style="font-family: 'Lobster', cursive;">Creativity: generate name, choose it, love it</h1>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control shadow-none border-secondary" placeholder="Email address" required autofocus name="email">
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control mb-3 shadow-none border-secondary" placeholder="Password" required name="password">
            <button class="btn btn-lg btn-primary btn-block bg-white text-primary border-0 mb-2" type="submit">Sign in</button>
            <button class="btn btn-lg btn-primary btn-block border-white" type="submit">Register now</button>
            <div class="mb-3">
                <a class="btn btn-link text-white bg-transparent h5" href="../jsp/generateName.jsp">Skip sign in and start generate names!</a>
            </div>
            <c:if test="${not empty requestScope.passedAuth and not requestScope.passedAuth}">
                <div class="alert alert-danger bg-danger border-0 text-white">Sorry, credentials are wrong!</div>
            </c:if>
            <p class="text-white">&copy; 2021</p>
        </form>
    <div class="d-flex align-items-bottom justify-content-center text-white">
        Image by&nbsp;
        <a href="https://pixabay.com/users/davidrockdesign-2595351/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1430105">
            DavidRockDesign&nbsp;
        </a>
        from&nbsp;
        <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1430105">
         Pixabay
        </a>
    </div>
    </div>
</body>
</html>
