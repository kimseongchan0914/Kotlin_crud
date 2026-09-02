package seongchan.kotlin_crud.post.presentation.data.response

import seongchan.kotlin_crud.post.entity.Post

data class PostResponse(
    val id : Long,
    val title : String,
    val content : String,
    val author : String,
)  { companion object {
    fun from(post: Post) = PostResponse(
        id = post.id,
        title = post.title,
        content = post.content,
        author = post.author,
    )
}
}

