package dev.noelsrocha.alugames.data

import dev.noelsrocha.alugames.models.Game
import dev.noelsrocha.alugames.models.GameEntity
import javax.persistence.EntityManager

class GamesDAO(val manager: EntityManager) : BaseDAO<Game>(manager) {
    override fun toEntity(value: Game): GameEntity {
        return GameEntity(value.title, value.thumb, value.price, value.description, value.id)
    }

    override fun getList(): List<Game> {
        val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)

        return query.resultList.map { entity ->
            entity.description?.let {
                Game(
                    entity.title,
                    entity.thumb,
                    entity.price,
                    it,
                    entity.id
                )
            }!!
        }
    }
}