package seongchan.kotlin_crud.user.repository

import org.springframework.stereotype.Repository
import seongchan.kotlin_crud.user.entity.User

@Repository
class UserRepository {
    private val store = mutableMapOf<Long, User>()
    private var sequence = 0L
}