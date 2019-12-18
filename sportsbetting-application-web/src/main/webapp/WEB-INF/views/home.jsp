<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>

<head>
    <link href='<spring:url value="/resources/bootstrap.min.css"/>' rel="stylesheet" />

    <script src="<spring:url value=" /resources/jquery-3.4.1.min.js "/>"></script>
    <script src="<spring:url value=" /resources/bootstrap.min.js "/>"></script>
    <script src="<spring:url value=" /resources/bootstrap.bundle.min.js "/>"></script>
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
            <li class="nav-item active">
                <a class="nav-link" href="/">
                    <spring:message code="app.home" /> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/events">
                    <spring:message code="app.events" />
                </a>
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
            <spring:message code="app.details" />
        </div>
        <div class="card-body">
            <form action="/setPlayerData" method="post">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><spring:message code="player.displayname"/></span>
                    </div>
                    <input type="text" class="form-control" id="name" name="name" value="${player.name}">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><spring:message code="player.birth"/></span>
                    </div>
                    <input type="date" class="form-control" id="birth" name="birth" value="${player.birth.toLocalDate()}">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><spring:message code="player.accountnumber"/></span>
                    </div>
                    <input type="text" class="form-control" id="accnumber" name="accnumber" value="${player.accountNumber}">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><spring:message code="player.currency"/></span>
                    </div>
                    <select class="form-control" id="currency" name="currency">
                        <c:forEach var="currency" items="${currencies}">
                            <c:if test="${currency == player.currency}">
                                <option selected>${currency}</option>
                            </c:if>
                            <c:if test="${currency != player.currency}">
                                <option>${currency}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><spring:message code="player.balance"/></span>
                    </div>
                    <input type="text" class="form-control" id="balance" name="balance" value="${player.balance.intValue()}">
                </div>
                <input class="btn btn-primary " class="button" type="submit" value="<spring:message code="player.save"/>">
            </form>

        </div>
    </div>
</div>
<br/>
<br/>
<div class="container-fluid">
    <div class="card">
        <div class="card-header text-white" style="background-color: #037AFB;">
            <spring:message code="app.wagers" />
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th class="align-middle text-center" scope="col"></th>
                    <th class="align-middle text-center" scope="col">#</th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.event.title" /> </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.event.type" /> </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.bet.type" /> </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.outcome.displayvalue" /> </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.outcome.odd" /> </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.wager.amount" />
                    </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.winner" />
                    </th>
                    <th class="align-middle text-center" scope="col">
                        <spring:message code="app.processed" />
                    </th>
                </tr>
                </thead>
                <tbody>
                <div align="" <c:forEach var="wager" items="${wagers}">
                    <tr>
                        <td class="align-middle text-center">
                            <form action="/deleteWager" method="post">
                                <input type="hidden" value="${wager.id}" name="id" id="id">
                                <input class="btn btn-primary" class="button" type="submit" value="<spring:message code="app.remove"/>">
                            </form>
                        </td>
                        <td class="align-middle text-center">${wager.id}</td>

                        <td class="align-middle text-center">${wager.outcomeOdd.outcome.bet.sportEvent.title}</td>
                        <td class="align-middle text-center">Football match</td>
                        <td class="align-middle text-center">${wager.outcomeOdd.outcome.bet.description} </td>
                        <td class="align-middle text-center">${wager.outcomeOdd.outcome.description}</td>
                        <td class="align-middle text-center">${wager.outcomeOdd.value}</td>
                        <td class="align-middle text-center">${wager.amount}</td>
                        <td class="align-middle text-center">${wager.win}</td>
                        <td class="align-middle text-center">${wager.processed}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>