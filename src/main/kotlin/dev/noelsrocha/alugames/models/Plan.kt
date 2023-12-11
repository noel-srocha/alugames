package dev.noelsrocha.alugames.models

sealed class Plan(val type: String, var id: Int = 0) {

    open fun getValue(rent: Rent): Double {
        return rent.game.price * rent.period.days
    }
}