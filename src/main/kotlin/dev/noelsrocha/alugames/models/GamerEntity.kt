package dev.noelsrocha.alugames.models

import javax.persistence.*

@Entity
@Table(name = "gamers")
open class GamerEntity(
    val name: String = "Name",
    val email: String = "Email",
    val birthDate: String? = null,
    val user: String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
)