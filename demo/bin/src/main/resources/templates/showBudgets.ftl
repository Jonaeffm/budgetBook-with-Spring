<!DOCTYPE html>
<html>
    <head>
        <title>Show budgets</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>

    <body>

        <h2>List of budgets</h2>

        <table>
            <tr>
                <th>Id</th>
                <th>Product</th>
                <th>Price</th>
            </tr>

            <#list countries as country>
                <tr>
                    <td>${budget.id}</td>
                    <td>${budget.product}</td>
                    <td>${budget.price}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>