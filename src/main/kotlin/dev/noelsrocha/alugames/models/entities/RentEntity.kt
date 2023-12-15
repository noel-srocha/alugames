package dev.noelsrocha.alugames.models.entities

import dev.noelsrocha.alugames.models.Period
import javax.persistence.*

@Entity
@Table(name = "rents")
class RentEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    val period: Period = Period()
) {
    var rentValue = 0.0

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}