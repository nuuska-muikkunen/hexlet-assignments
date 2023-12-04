@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
content = @`
    <h1>POSTS</h1>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                @if(page.getPageNumber() <= 0)
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                @else
                    <a class="page-link" href="${NamedRoutes.pagesPath()}/${page.getPageNumber() - 5L}" tabindex="-1" aria-disabled="true">Previous</a>
                @endif
            </li>
            <li class="page-item">
                @if(page.getPageNumber() + 1L >= 26)
                    <a class="page-link" href="#">Next</a>
                @else
                    <a class="page-link" href="${NamedRoutes.pagesPath()}/${page.getPageNumber() + 5L}">Next</a>
                @endif
            </li>
        </ul>
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
        <a href="${NamedRoutes.postsPath()}">Back to posts list</a>
    </nav>
`)
