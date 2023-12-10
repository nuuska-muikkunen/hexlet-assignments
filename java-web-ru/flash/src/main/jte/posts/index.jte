@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
page = page,
content = @`
    <table>
        @for(var post : page.getPosts())
        <tr>
            <td>
                <a href="${NamedRoutes.postPath(post.getId())}">${post.getId()}</a>
            </td>
            <td>
                ${post.getName()}
            </td>
            <td>
                ${post.getBody()}
            </td>
        </tr>
        @endfor
    </table>
`
)