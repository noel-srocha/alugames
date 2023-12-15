package dev.noelsrocha.alugames.utils

import dev.noelsrocha.alugames.models.Gamer
import dev.noelsrocha.alugames.models.InfoGamerJson
import dev.noelsrocha.alugames.models.entities.GamerEntity

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(this.name, this.email, this.birthDate, this.user)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.name, this.email, this.birthDate, this.user, this.plan.toEntity(), this.id)
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(
        this.name,
        this.email,
        this.birthDate,
        this.user,
        this.id
    )
}