@import exercise.util.NamedRoutes
@import exercise.dto.MainPage

@param MainPage page

@template.layout.page(content =@`
    @if(page != null)
        <h4>Добро пожаловать, "${page.getName().toString()}"! </h4>
        <a href="${NamedRoutes.logoutPath()}"> Выйти </a>
    @endif

    @if(page == null)
        <a href="${NamedRoutes.buildSessionPath()}"> Войти </a>
    @endif
`
)
