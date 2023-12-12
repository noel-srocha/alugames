package dev.noelsrocha.alugames.data

import dev.noelsrocha.alugames.models.Gamer
import dev.noelsrocha.alugames.models.GamerEntity
import javax.persistence.EntityManager

class GamersDAO(val manager: EntityManager) {
    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)

        return query.resultList.map { entity ->
            entity.birthDate?.let { birthdate ->
                entity.user?.let { user ->
                    Gamer(
                        entity.name,
                        entity.email,
                        birthdate,
                        user,
                        entity.id
                    )
                }
            }!!
        }
    }

    fun insertGamer(gamer: Gamer) {
        val entity = gamer.user?.let { user ->
            gamer.birthDate?.let { birthDate ->
                GamerEntity(
                    gamer.name,
                    gamer.email,
                    birthDate,
                    user,
                    gamer.id
                )
            }
        }
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}