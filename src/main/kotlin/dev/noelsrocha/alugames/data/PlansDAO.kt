package dev.noelsrocha.alugames.data

import dev.noelsrocha.alugames.models.Plan
import dev.noelsrocha.alugames.models.entities.PlanEntity
import dev.noelsrocha.alugames.utils.toEntity
import dev.noelsrocha.alugames.utils.toModel
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager) : BaseDAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }

    override fun toEntity(value: Plan): PlanEntity {
        return value.toEntity()
    }
}