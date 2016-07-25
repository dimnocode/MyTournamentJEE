<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Welcome</a>

                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                    	<li><a href="/MyTournamentV2">Index</a></li>
                        <li><a href="#information">Information</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <c:if test="${empty sessionScope.loggedUser}">
                        	<li><a href="#login">Login</a></li>
                        	<li><a href="#register">Register</a></li>
                        </c:if>
                        
                        <c:if test="${!empty sessionScope.loggedUser}">
                        	<li>Hi, <c:out value="${sessionScope.loggedUser.pseudo}"></c:out></li>
                        	<li><a href="#login">Logout</a></li>
                        </c:if>
                        
                    </ul>
                </div>
            </div>
        </nav>
        <a name=""></a>
</header>