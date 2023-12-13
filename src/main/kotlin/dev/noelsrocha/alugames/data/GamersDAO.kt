package dev.noelsrocha.alugames.data

import dev.noelsrocha.alugames.models.Gamer
import dev.noelsrocha.alugames.models.GamerEntity
import javax.persistence.EntityManager

class GamersDAO(val manager: EntityManager) : BaseDAO<Gamer>(manager) {
    override fun toEntity(value: Gamer): GamerEntity {
        return GamerEntity(value.name, value.email, value.birthDate, value.user, value.id)
    }


    override fun getList(): List<Gamer> {
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

    override fun insert(value: Gamer) {
        val entity = value.user?.let { user ->
            value.birthDate?.let { birthDate ->
                GamerEntity(
                    value.name,
                    value.email,
                    birthDate,
                    user,
                    value.id
                )
            }
        }
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}