<!doctype html>
<head>
    <title>Freemarker Example</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
    </script>
</head>
<body>
<div class="container">
            <h2>Car CRUD operation with Quarkus + Freemarker Template</h2>
     <a href="/create" class="btn btn-primary" role="button">Create New Car</a>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Type</th>
            <th scope="col">Model</th>
            <th scope="col">Color</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list cars as car>
        <tr>
            <th scope="row">${car.id}</th>
            <td>${car.type}</td>
            <td>${car.model}</td>
            <td>${car.color}</td>
            <td><a href="/update/${car.id}" class="btn btn-warning" role="button">
                     Update</a></td>
            <td><a href="/delete/${car.id}" class="btn btn-danger" role="button">
                     Delete</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>