package seongchan.kotlin_crud.post.presentation.data.request

data class CreatePostRequest(
    val title : String,
    val content : String,
    val author : String,
)
