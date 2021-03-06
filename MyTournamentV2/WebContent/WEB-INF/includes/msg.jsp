<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${!empty requestScope.errMsg}">
	<div class="alert alert-danger" role="alert">
		<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>&nbsp;
		<a href="#" class="close"  data-dismiss="alert" aria-label="close">&times;</a>
		<c:out value="${requestScope.errMsg}"></c:out>
	</div>
</c:if>
<c:if test="${!empty requestScope.successMsg}">
	<div class="alert alert-success" role="alert">
		<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>&nbsp;
		<a href="#" class="close"  data-dismiss="alert" aria-label="close">&times;</a>
		<c:out value="${requestScope.successMsg}"></c:out>
	</div>
</c:if>