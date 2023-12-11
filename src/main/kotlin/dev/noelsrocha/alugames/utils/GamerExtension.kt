package dev.noelsrocha.alugames.utils

import dev.noelsrocha.alugames.models.Gamer
import dev.noelsrocha.alugames.models.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(this.name, this.email, this.birthDate, this.user)
}