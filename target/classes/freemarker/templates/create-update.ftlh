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
            <h2>
                <#if !isUpdate>Create</#if>
            <#if isUpdate>Update</#if>
        Car
        </h2>
<div>
    <form action="<#if isUpdate>/update/${car.id}</#if><#if !isUpdate>/create</#if>"
          method="post" name="car">
        <table class="table">
            <tbody>
            <thead>
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>
            </thead>
            <tbody>
            <#if isUpdate>
            <tr>
                <th>ID</th>
                <td>
                    <div name="id">${car.id}</div>
                </td>
            </tr>
            </#if>
            <tr>
                <th>Type</th>
                <td><input name="type" type="text"
                           value="<#if car.type??>${car.type}</#if>"/>
                                                    </td>
            </tr>
            <tr>
                <th>Model</th>
                <td><input name="model" type="text"
                           value="<#if car.model??>${car.model}</#if>"/></td>
            </tr>
            <tr>
                <th>Color</th>
                <td><input name="color" type="text"
                           value="<#if car.color??>${car.color}</#if>"/></td>
            </tr>
            </tbody>
        </table>
        <button class="btn btn-primary" type="submit">Save</button>
    </form>
</div>
</div>
</body>
</html>