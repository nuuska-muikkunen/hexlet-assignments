@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
content = @`
    <h1>POSTS</h1>
    <a href="/posts?page=1">To paging</a>
    <table class="table table-striped">
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
`)