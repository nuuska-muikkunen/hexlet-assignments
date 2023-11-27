@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(page = page, content = @`
    <h1>Пользователи</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>User id</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        </thead>
        @for(var user : page.getUsers())
            <tr>
                <td>
                    ${user.getId()}
                </td>
                <td>
                    ${user.getFirstName()} ${user.getLastName()}
                </td>
                <td>
                    ${user.getEmail()}
                </td>
            </tr>
        @endfor
    </table>
`
)
