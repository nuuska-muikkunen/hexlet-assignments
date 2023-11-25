@import gg.jte.Content

@param Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My page with layouts</title>
    <link href = "style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header">
    <h2><a href = "/">Main page</a> <a href = "/users">Users</a></h2>
</div>
${content}
<div class="footer">
    <h2><a href = "https://nuuska-muikkunen.github.io/">My page</a> <a href = "/users/1">User 1</a> <a href = "/users/5">User 5</a></h2>
</div>
</body>
</html>
