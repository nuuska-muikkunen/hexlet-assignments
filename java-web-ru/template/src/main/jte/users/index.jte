<!-- BEGIN -->
<!-- Изменения HTML в шаблоне не требуют перезапуска сервера -->
@import exercise.dto.users.UsersPage
@param UsersPage page

<html>
<head>
    <title>Хекслет</title>
</head>
<body>
<h1>${page.getHeader()}</h1>
@if(page.getUsers().isEmpty())
    <p>There are no users in the list</p>
@else
    <table>
        <thead>
        <tr>
        <caption>TABLE OF USERS</caption>
            <th>|</th>
            <th>User id</th>
            <th>|</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>|</th>
            <th>email</th>
            <th>|</th>
        </tr>
        </thead>
    </table>
    @for(var user : page.getUsers())
        <div>
            <table>
                <tbody>
                <tr>
                    <td>|</td>
                    <td><a href="/users/${user.getId()}">${user.getId()}. </a></td>
                    <td>|</td>
                    <td>${user.getFirstName()} </td>
                    <td>${user.getLastName()}, </td>
                    <td>|</td>
                    <td>${user.getEmail()}</td>
                    <td>|</td>
                </tr>
                </tbody>
            </table>
        </div>
    @endfor
@endif
</body>
</html>
<!-- END -->
