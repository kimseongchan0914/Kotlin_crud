package seongchan.kotlin_crud.post.repository

import org.springframework.data.jpa.repository.JpaRepository
import seongchan.kotlin_crud.post.entity.Post

interface PostRepository : JpaRepository<Post, Long> {
}
