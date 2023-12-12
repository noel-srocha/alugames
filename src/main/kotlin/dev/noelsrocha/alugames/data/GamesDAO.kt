package dev.noelsrocha.alugames.data

import dev.noelsrocha.alugames.models.Game
import dev.noelsrocha.alugames.models.GameEntity
import javax.persistence.EntityManager

class GamesDAO(val manager: EntityManager) {
    fun getGames(): List<Game> {
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

    fun insertGame(game: Game) {
        val entity = GameEntity(game.title, game.thumb, game.price, game.description)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}