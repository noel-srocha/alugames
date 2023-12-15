package dev.noelsrocha.alugames.models.entities

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("Loose")
class LoosePlanEntity(
    id: Int = 0,
    type: String = "Loose Plan",
) : PlanEntity(id, type)