package dev.noelsrocha.alugames.utils

import dev.noelsrocha.alugames.models.Rent
import dev.noelsrocha.alugames.models.entities.RentEntity

fun Rent.toEntity(): RentEntity {
    return RentEntity(this.gamer.toEntity(), this.game.toEntity(), this.period)
}

fun RentEntity.toModel(): Rent {
    return Rent(this.gamer.toModel(), this.game.toModel(), this.period)
}