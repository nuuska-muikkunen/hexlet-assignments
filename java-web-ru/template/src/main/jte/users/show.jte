<!-- BEGIN -->
<!-- Изменения HTML в шаблоне не требуют перезапуска сервера -->
@import exercise.dto.users.UserPage
@param UserPage page

<html>
<head>
    <title>Хекслет</title>
</head>
<body>
<h1>${page.getHeader()}</h1>
@if(page.getUser() == null)
    <p>There is no users with this id</p>
@else
        <div>
            <h2><a href="/users/${page.getUser().getId()}">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</a></h2>
            <p>${page.getUser().getEmail()}</p>
        </div>
@endif
</body>
</html>
<!-- END -->
