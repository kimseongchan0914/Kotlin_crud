package seongchan.kotlin_crud.post.presentation.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import seongchan.kotlin_crud.post.presentation.data.request.CreatePostRequest
import seongchan.kotlin_crud.post.presentation.data.request.UpdatePostRequest
import seongchan.kotlin_crud.post.presentation.data.response.PostResponse
import seongchan.kotlin_crud.post.repository.PostRepository
import seongchan.kotlin_crud.post.service.PostService


@RestController
@RequestMapping("/posts")
class PostController (
    private val postRepository: PostRepository,
    private val postService: PostService,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreatePostRequest): PostResponse {
        return postService.create(request)
    }

    @GetMapping
    fun findAll(): List<PostResponse> {
        return postService.findAll()
    }

    @GetMapping("{id}")
    fun findById(@PathVariable id: Long): PostResponse {
        return postService.findById(id)

    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: UpdatePostRequest,
    ): PostResponse {
        return postService.update(id, request)
    }

    @DeleteMapping("{/id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        postService.delete(id)
    }

}