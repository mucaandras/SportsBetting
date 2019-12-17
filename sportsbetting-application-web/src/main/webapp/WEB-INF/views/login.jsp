<html>

<head>
    <title>SportsBet - Login</title>
    <link href='<spring:url value="/resources/bootstrap.min.css"/>' rel="stylesheet" />
    <link href='<spring:url value="/resources/login.css"/>' rel="stylesheet" />
</head>

<body>

<div class="header">
    <h1>Welcome to SportsBet</h1>
    <p>Sports betting is the activity of predicting sports results and placing a wager on the outcome.</p>
</div>
<div class="w-75 p-3 mx-auto">
    <br>
    <h2>
        Login or Register to start!
    </h2>
    <br>
    <div class="w-25">
        <div class="container">
            <div class="card">
                <div class="card-header text-white" style="background-color: #037AFB;">
                    Login
                </div>
                <div class="card-body">
                    <form name="f" action="/login" method="post">
                        <div class="form-group">
                            <input type="text" id="username" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <input type="password" id="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>