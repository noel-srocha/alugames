package dev.noelsrocha.alugames.data

import dev.noelsrocha.alugames.models.Gamer
import dev.noelsrocha.alugames.models.entities.GamerEntity
import dev.noelsrocha.alugames.utils.toEntity
import dev.noelsrocha.alugames.utils.toModel
import javax.persistence.EntityManager

class GamersDAO(private val manager: EntityManager) : BaseDAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(value: Gamer): GamerEntity {
        return value.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plan = entity.plan.toModel() }
    }
}