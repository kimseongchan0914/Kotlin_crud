package seongchan.kotlin_crud.post.service

import seongchan.kotlin_crud.post.entity.Post
import seongchan.kotlin_crud.post.exception.PostNotFoundException
import seongchan.kotlin_crud.post.presentation.data.request.CreatePostRequest
import seongchan.kotlin_crud.post.presentation.data.request.UpdatePostRequest
import seongchan.kotlin_crud.post.presentation.data.response.PostResponse
import seongchan.kotlin_crud.post.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository,
) {

    @Transactional
    fun create(request: CreatePostRequest): PostResponse {
        val post = Post().apply {
            title = request.title
            content = request.content
            author = request.author
        }
        val saved = postRepository.save(post)
        return PostResponse.from(saved)
    }

    fun findAll(): List<PostResponse> {
        return postRepository.findAll()
            .map { PostResponse.from(it) }
    }

    fun findById(id: Long): PostResponse {
        val post = postRepository.findByIdOrNull(id)
            ?: throw PostNotFoundException(id)
        return PostResponse.from(post)
    }

    @Transactional
    fun update(id: Long, request: UpdatePostRequest): PostResponse {
        val post = postRepository.findByIdOrNull(id)
            ?: throw PostNotFoundException(id)
        post.update(request.title, request.content)
        return PostResponse.from(post)
    }

    @Transactional
    fun delete(id: Long) {
        if (!postRepository.existsById(id)) {
            throw PostNotFoundException(id)
        }
        postRepository.deleteById(id)
    }
}