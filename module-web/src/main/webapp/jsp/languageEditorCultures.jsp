<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="culturesDetailsBlock">
    <div class="form-group">
        <label for="selectCulture">Culture</label>
        <select class="form-control" id="selectCulture">
            <option>None</option>
            <c:if test="${not empty sessionScope.cultures}">
                <c:forEach var="culture" items="${sessionScope.cultures}">
                    <option name="culture" id="culture${culture.id}"
                            value="${culture.id}">${culture.name}</option>
                </c:forEach>
            </c:if>
        </select>
    </div>
</div>