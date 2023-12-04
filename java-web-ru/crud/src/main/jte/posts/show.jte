@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes

@param PostPage page

@template.layout.page(content = @`
    <h1>POST</h1>
    <table class="table table-striped">
        <tr>
            <td>
                ${page.getPost().getId()}
            </td>
            <td>
                ${page.getPost().getName()}
            </td>
            <td>
                ${page.getPost().getBody()}
            </td>
        </tr>
    </table>
    <a href="${NamedRoutes.postsPath()}">Back to posts list</a>
`)
