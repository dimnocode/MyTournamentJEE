<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="includes/head.jsp"/>

<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<c:import url="includes/header.jsp"/>
	
	<div class="container">
		<div class="jumbotron">
		  <h1>My Tournament</h1>
		  <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
		  <p><a href="login" class="btn btn-primary btn-lg">Login</a></p>
		</div>
		
		<div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Create your tournaments!</h2>
            </div>
            <div class="col-md-6">
                <p>The Modern Business template by Start Bootstrap includes:</p>
                <ul>
                    <li><strong>Bootstrap v3.2.0</strong>
                    </li>
                    <li>jQuery v1.11.0</li>
                    <li>Font Awesome v4.1.0</li>
                    <li>Working PHP contact form with validation</li>
                    <li>Unstyled page elements for easy customization</li>
                    <li>17 HTML pages</li>
                </ul>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p>
            </div>
            <div class="col-md-6">
                <img class="img-responsive" src="http://placehold.it/700x450" alt="">
            </div>
        </div>
		<div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Participer seul ou en équipe !</h2>
            </div>
            <div class="col-md-6">
                <img class="img-responsive" src="http://placehold.it/700x450" alt="">
            </div>
            <div class="col-md-6">
                <p>The Modern Business template by Start Bootstrap includes:</p>
                <ul>
                    <li><strong>Bootstrap v3.2.0</strong>
                    </li>
                    <li>jQuery v1.11.0</li>
                    <li>Font Awesome v4.1.0</li>
                    <li>Working PHP contact form with validation</li>
                    <li>Unstyled page elements for easy customization</li>
                    <li>17 HTML pages</li>
                </ul>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p>
            </div>
            
        </div>
		
        
		
		<div class="row" style="margin-left: 10px;margin-right: 10px; padding-top: 50px;">
            <div class="col-md-4" style="padding-top: 50px;" >
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><a name="login"></a>Login</h4>
                    </div>
                    <div class="panel-body" style="height:200px;">
                        <p>blablabla</p><br/>
                        <a href="login" class="btn btn-primary">
                            Login
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-4" style="padding-top: 50px;" >
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><a name="register"></a>Register</h4>
                    </div>
                    <div class="panel-body" style="height:200px;">
                        <p>blablabla</p><br/>
                        <a href="register" class="btn btn-primary">
                            Register
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-4" style="padding-top: 50px;" >
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><a name="information"></a>Information</h4>
                    </div>
                    <div class="panel-body" style="height:200px;">
                        <p>blablabla</p><br/>
                        <a href="info" class="btn btn-primary">
                            Information
                        </a>
                    </div>
                </div>
            </div>
        </div>
        
	</div>
	
	<c:import url="includes/footer.jsp"/>
</body>
</html>