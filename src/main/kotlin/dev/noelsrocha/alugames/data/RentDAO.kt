package dev.noelsrocha.alugames.data

import dev.noelsrocha.alugames.models.Rent
import dev.noelsrocha.alugames.models.entities.RentEntity
import dev.noelsrocha.alugames.utils.toEntity
import dev.noelsrocha.alugames.utils.toModel
import javax.persistence.EntityManager

class RentDAO(manager: EntityManager) : BaseDAO<Rent, RentEntity>(manager, RentEntity::class.java) {
    override fun toEntity(value: Rent): RentEntity {
        return value.toEntity()
    }

    override fun toModel(entity: RentEntity): Rent {
        return entity.toModel()
    }
}