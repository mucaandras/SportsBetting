<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>

<head>
    <link href='<spring:url value="/resources/bootstrap.min.css"/>' rel="stylesheet" />

    <script src="	<spring:url value=" /resources/jquery-3.4.1.min.js "/>"></script>
    <script src="	<spring:url value=" /resources/bootstrap.min.js "/>"></script>
    <script src="	<spring:url value=" /resources/bootstrap.bundle.min.js "/>"></script>
    <title>
        <spring:message code="app.title" />
    </title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">
        <spring:message code="app.title" />
    </a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">
                    <spring:message code="app.home" /> </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/events">
                    <spring:message code="app.events" /><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <spring:message code="app.lang.title" />
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="?lang=hu">
                        <spring:message code="app.lang.hungarian" />
                    </a>
                    <a class="dropdown-item" href="?lang=en">
                        <spring:message code="app.lang.english" />
                    </a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/logout">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                <spring:message code="app.logout" />
            </button>
        </form>
    </div>
</nav>

<br/>
<br/>
<div class="container-fluid">
    <div class="card">
        <div class="card-header text-white" style="background-color: #037AFB;">
            <spring:message code="app.events" />
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th class="align-middle text-center" scope="col">#</th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.event.title" />
                    </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.bet.type" />
                    </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.outcome.displayvalue" />
                    </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.outcome.odd" />
                    </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.wager.amount" />
                    </th>
                    <th class="align-middle text-center" scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <div align="" <c:forEach var="sportevent" items="${sportevents}">
                    <c:forEach var="bet" items="${sportevent.bets}">
                        <c:forEach var="outcome" items="${bet.outcomes}">
                            <c:forEach var="outcomeodd" items="${outcome.outcomeOdds}">
                                <tr>
                                    <form:form method="post" action="/addWager">
                                        <td class="text-center align-middle">${outcomeodd.id} </td>
                                        <td class="text-center align-middle">${sportevent.title} </td>
                                        <td class="text-center align-middle">${bet.description}</td>
                                        <td class="text-center align-middle">${outcome.description}</td>
                                        <td class="text-center align-middle">${outcomeodd.value}</td>
                                        <td class="text-center align-middle">

                                            <input type="text" class="form-control" id="amount" name="amount">
                                        </td>

                                        <td class="text-center align-middle">
                                            <button type="submit" class="btn btn-outline-success my-2 my-sm-0">
                                                <spring:message code="app.addwager" />
                                            </button>
                                        </td>
                                        <input type="hidden" name="id" id="id" value=${outcomeodd.id}>
                                    </form:form>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

</body>

</html>