package dev.noelsrocha.alugames.data

import dev.noelsrocha.alugames.models.Game
import dev.noelsrocha.alugames.models.entities.GameEntity
import dev.noelsrocha.alugames.utils.toEntity
import dev.noelsrocha.alugames.utils.toModel
import javax.persistence.EntityManager

class GamesDAO(private val manager: EntityManager) : BaseDAO<Game, GameEntity>(manager, GameEntity::class.java) {
    override fun toEntity(value: Game): GameEntity {
        return value.toEntity()
    }

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }
}