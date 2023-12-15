package dev.noelsrocha.alugames.utils

import dev.noelsrocha.alugames.models.LoosePlan
import dev.noelsrocha.alugames.models.Plan
import dev.noelsrocha.alugames.models.SubscriptionPlan
import dev.noelsrocha.alugames.models.entities.LoosePlanEntity
import dev.noelsrocha.alugames.models.entities.PlanEntity
import dev.noelsrocha.alugames.models.entities.SubscriptionPlanEntity

fun Plan.toEntity(): PlanEntity {
    return if (this is SubscriptionPlan) {
        SubscriptionPlanEntity(
            this.id,
            this.type,
            this.monthlyPayment,
            this.includedGames,
            this.reputationDiscountPercentage
        )
    } else {
        LoosePlanEntity(this.id, this.type)
    }
}

fun PlanEntity.toModel(): Plan {
    return if (this is SubscriptionPlanEntity) {
        SubscriptionPlan(
            this.type,
            this.monthlyPayment,
            this.includedGames,
            this.reputationDiscountPercentage,
            this.id
        )
    } else {
        LoosePlan(this.type, this.id)
    }
}