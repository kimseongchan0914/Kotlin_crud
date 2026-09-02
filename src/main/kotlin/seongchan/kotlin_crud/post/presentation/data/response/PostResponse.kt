package seongchan.kotlin_crud.post.presentation.data.response

data class PostResponse(
    val id : Long,
    val title : String,
    val content : String,
    val author : String,
)
