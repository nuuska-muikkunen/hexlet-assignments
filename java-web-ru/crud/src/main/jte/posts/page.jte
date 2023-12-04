@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
content = @`
    <h1>POSTS</h1>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item">
                @if(page.getPageNumber() <= 1)
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">No page this way</a>
                @else
                    <a class="page-link" href="/posts?page=${page.getPageNumber() - 1}" tabindex="-1" aria-disabled="true">Previous</a>
                @endif
            </li>
            <li class="page-item">
                @if(page.getPageNumber() >= 5)
                    <a class="page-link" href="#">No page this way</a>
                @else
                    <a class="page-link" href="/posts?page=${page.getPageNumber() + 1}" tabindex="1" aria-disabled="true">Next</a>
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
        <a href="${NamedRoutes.rootPath()}">Back to root list</a>
    </nav>
`)
