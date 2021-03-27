<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-light border-right" id="sidebar-wrapper">
    <div class="sidebar-heading" style="font-family: 'Lobster', cursive;">
        <div class="h2 creativity-bg">
            Creativity
        </div>
    </div>
    <div class="list-group list-group-flush">
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <a href="../jsp/generateName.jsp" class="list-group-item list-group-item-action bg-light">Generate a name</a>
                <a href="../jsp/generateNameSettings.jsp" class="list-group-item list-group-item-action bg-light">Settings</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
            </c:when>
            <c:otherwise>
                <a href="../jsp/generateName.jsp" class="list-group-item list-group-item-action bg-light">Generate a name</a>
                <a href="../jsp/generateNameSettings.jsp" class="list-group-item list-group-item-action bg-light">Settings</a>
                <a href="../jsp/createSymbol.jsp" class="list-group-item list-group-item-action bg-light">Create a symbol</a>
                <a href="../jsp/languageEditorMain.jsp" class="list-group-item list-group-item-action bg-light">Language editor</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
