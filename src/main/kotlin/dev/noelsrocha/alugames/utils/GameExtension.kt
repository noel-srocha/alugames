package dev.noelsrocha.alugames.utils

import dev.noelsrocha.alugames.models.Game
import dev.noelsrocha.alugames.models.InfoGameJson

fun InfoGameJson.createGame(): Game {
    return Game(this.titulo, this.capa, this.preco, this.descricao)
}