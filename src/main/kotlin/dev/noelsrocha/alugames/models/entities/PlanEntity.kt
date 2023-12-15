package dev.noelsrocha.alugames.models.entities

import javax.persistence.*

@Entity
@Table(name = "plans")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PlanType", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    val type: String
)