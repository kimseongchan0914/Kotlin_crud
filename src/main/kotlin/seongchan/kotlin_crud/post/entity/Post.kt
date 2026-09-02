package seongchan.kotlin_crud.post.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "post")
class Post {

    @Column(nullable = false)
    var title: String =""

    @Column(nullable = false)
    var author: String =""

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String =""

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long = 0

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}