package dev.noelsrocha.alugames.utils

import dev.noelsrocha.alugames.models.Game
import dev.noelsrocha.alugames.models.InfoGameJson
import dev.noelsrocha.alugames.models.entities.GameEntity

fun InfoGameJson.createGame(): Game {
    return Game(this.titulo, this.capa, this.preco, this.descricao)
}

fun Game.toEntity(): GameEntity {
    return GameEntity(this.title, this.thumb, this.price, this.description, this.id)
}

fun GameEntity.toModel(): Game {
    return Game(this.title, this.thumb, this.price, this.description, this.id)
}