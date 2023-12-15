package dev.noelsrocha.alugames.models.entities

import javax.persistence.*

@Entity
@Table(name = "games")
open class GameEntity(
    val title: String = "Game Title",
    val thumb: String = "Game thumbnail",
    val price: Double = 0.0,
    val description: String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {

}