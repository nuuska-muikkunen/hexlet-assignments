@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(page = page,
    content = @`
        <h1>Пользователи</h1>
    `
)
