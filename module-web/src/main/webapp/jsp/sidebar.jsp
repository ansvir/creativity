<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bg-light border-right" id="sidebar-wrapper">
    <div class="sidebar-heading" style="font-family: 'Lobster', cursive;">
        <div class="h2 creativity-word-bg">
            Creativity
        </div>
    </div>
    <div class="list-group list-group-flush">
        <div class="btn-group dropright">
            <a id="nameGenerationTab" href="#" class="list-group-item list-group-item-action bg-light"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Name generation</a>
            <div id="nameGenerationDropDown" class="dropdown-menu"
                 style="padding-bottom: 0; padding-top: 0">
                <a href="../jsp/generateName.jsp" class="list-group-item list-group-item-action bg-light">Generate a
                    name</a>
                <a href="../jsp/generateNameSettings.jsp" class="list-group-item list-group-item-action bg-light">Settings</a>
            </div>
        </div>
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
            </c:when>
            <c:otherwise>
                <div class="btn-group dropright">
                    <a id="languageEditorTab" href="#" class="list-group-item list-group-item-action bg-light"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Language editor</a>
                    <div id="languageEditorDropDown" class="dropdown-menu"
                         style="padding-bottom: 0; padding-top: 0">
                        <a href="../jsp/languageEditorMain.jsp" class="list-group-item list-group-item-action bg-light">My
                            languages</a>
                        <a href="../jsp/createSymbol.jsp" class="list-group-item list-group-item-action bg-light">Create
                            a symbol</a>
                    </div>
                </div>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
                <a href="#" class="list-group-item list-group-item-action bg-light">To be introduced</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
