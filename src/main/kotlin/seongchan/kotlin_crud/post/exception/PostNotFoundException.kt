package seongchan.kotlin_crud.post.exception

class PostNotFoundException(id : Long) : RuntimeException("게시글을 찾을수 없습니다. id = $id")