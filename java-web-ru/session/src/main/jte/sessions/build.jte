@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage

@param LoginPage page

@template.layout.page(content =@`
    @if(page != null)
        <div>
            <h3>${page.getError()}</h3>
        </div>
    @endif
    <form action="${NamedRoutes.loginPath()}" method="post">
        <label>
            Nickname
            <input type="text" placeholder="Nickname" name="nickname" />
        </label>
        <label>
            Password
            <input type="password" placeholder="Password" name="password" />
        </label>
        <input type="submit" />
    </form>
`
)
