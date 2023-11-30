@import exercise.dto.articles.ArticlesPage

@param ArticlesPage page

@template.layout.page(
content = @`
    <h1><a href="/articles/new">Новая статья</a></h1>
    <table class="table table-striped">
        @for(var article : page.getArticles())
            <tr>
                <td>
                    <a href="/article/${article.getId()}">${article.getId()}</a>
                </td>
                <td>
                    ${article.getTitle()}
                </td>
                <td>
                    <p>${article.getContent()}</p>
                </td>
            </tr>
        @endfor
    </table>
`
)
