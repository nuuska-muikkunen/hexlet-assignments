@import exercise.util.NamedRoutes
@import exercise.dto.MainPage

@param MainPage page

@template.layout.page(content =@`
    @if(page == null)
        <a href="${NamedRoutes.buildSessionPath()}"> Войти</a>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @elseif(page.getName() != null)
            <h4>Добро пожаловать, "${page.getName().toString()}"!</h4>
            <div>Чтобы закончить сеанс, нажмите на кнопку "Выйти"</div>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        @else
            <h4> Добро пожаловать, гость</h4>
        <form action="${NamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="Войти">
        </form>
    @endif
`
)
