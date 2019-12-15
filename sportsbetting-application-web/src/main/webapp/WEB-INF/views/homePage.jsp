<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href='<spring:url value="/resources/bootstrap.min.css"/>' rel="stylesheet" />

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">SportsBetting</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Events</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Language
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">English</a>
                    <a class="dropdown-item" href="#">Magyar</a>

                </div>
            </li>
        </ul>

            <form action="/logout">
                <button type="submit" class="btn btn-outline-success my-2 my-sm-0">Logout</button>
            </form>

    </div>
</nav>





        <br/>
        <br/>
        <div class="container-fluid">
            <div class="card">
                <div class="card-header text-white" style="background-color: #037AFB;">
                    Account details
                </div>
                <div class="card-body">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" >Name</span>
                        </div>
                        <input type="text" class="form-control" value="${player.name}">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Date of Birth</span>
                        </div>
                        <input type="text" class="form-control"  aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Account number</span>
                        </div>
                        <input type="text" class="form-control"  aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Currency</span>
                        </div>
                        <input type="text" class="form-control"  aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" >Balance</span>
                        </div>
                        <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1">
                    </div>




                </div>
            </div>
        </div>

</body>
</html>