<!DOCTYPE html>
<html lang="en">
    <head>
        <title>FirstPage</title>
        <style>.error { color: red; } .success { color:${param.color}; }</style>
    </head>
    <body>
        <form action="BookProcess" method="post">
            <h1>Book by SKU</h1>
            <p>
                <label for="sku">What's your book SKU?</label>
                <input id="sku" name="sku" value="${param.sku}">
                <input type="submit">
                <br>
            </p>
        </form>
        <form action="BookByAuthorProcess" method="post">
         	<h1>Book by Author</h1>
            <p>
            	<br>
                <label for="aut">What's your favorite Author?</label>
                <input id="aut" name="aut" value="${param.aut}">
                <input type="submit">
            </p>
        </form>
    </body>
</html>