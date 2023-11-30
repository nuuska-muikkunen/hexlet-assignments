@import exercise.dto.articles.NewArticlePage

@param NewArticlePage page

@template.layout.page(content = @`
    @if(page.getErrors() != null)
        <ul xmlns="http://www.w3.org/1999/html">
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <form action="/articles" method="post">
        <div class="mb-3">
            <label class="form-label">
                Title
                <input type="text" required class="form-control" name="title" value="${page.getTitle()}" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Content
                <input type="text" required class="form-control" name="content" value="${page.getContent()}" />
            </label>
        </div>
        <input type="submit" value="Create" />
    </form>
`)
