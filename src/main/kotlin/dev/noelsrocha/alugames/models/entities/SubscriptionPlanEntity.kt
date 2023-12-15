package dev.noelsrocha.alugames.models.entities

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("Subscription")
class SubscriptionPlanEntity(
    id: Int = 0,
    type: String = "Subscription Plan",
    val monthlyPayment: Double = 0.0,
    val includedGames: Int = 0,
    val reputationDiscountPercentage: Double = 0.0
) : PlanEntity(id, type)