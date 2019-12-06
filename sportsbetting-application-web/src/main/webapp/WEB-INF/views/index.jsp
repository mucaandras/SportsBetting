<!doctype html>
<html lang="hu">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SportsBetting</title>



    <!-- Bootstrap core CSS -->
    <link href="bootstrap.min.css" rel="stylesheet">
    <script src="bootstrap.bundle.min.js"></script>

  </head>
  <body>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand" href="#">SportsBetting</a>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
              <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="events">Events</a>
              </li>
              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Language
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <a class="dropdown-item" href="${pageContext.request.contextPath}?lang=hu">Hungarian</a>
                      <a class="dropdown-item" href="${pageContext.request.contextPath}?lang=en">English</a>
                  </div>
              </li>
            </ul>
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
          </div>
        </nav>

        <div class="container">
            <!-- Content here -->

        <br>
        <br>
         
        <div class="input-group mb-3">
            <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">Name</span>
            </div>
            <input type="text" class="form-control" placeholder="Arnol Schwarzenegger" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <div class="input-group mb-3">
          <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">Date of Birth</span>
            </div>
            <input type="text" class="form-control" placeholder="1947-07-30" aria-label="Username" aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
          <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">Account number</span>
            </div>
            <input type="text" class="form-control" placeholder="12345678-12345678" aria-label="Username" aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
          <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">Currency</span>
            </div>
            <input type="text" class="form-control" placeholder="USD" aria-label="Username" aria-describedby="basic-addon1">
          </div>
          <div class="input-group mb-3">
          <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">Balance</span>
            </div>
            <input type="text" class="form-control" placeholder="9999999" aria-label="Username" aria-describedby="basic-addon1">
          </div>
  
        </div>

        <br>
        <br>

        <div class="container">

        <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Event title</th>
                <th scope="col">Event type</th>
                <th scope="col">Bet type</th>
                <th scope="col">Outcome value</th>
                <th scope="col">Outcome odd</th>
                <th scope="col">Wager amount</th>
                <th scope="col">Winner</th>
                <th scope="col">Processed</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
              </tr>
            </tbody>
          </table>
        </div>
  </body>
</html>

