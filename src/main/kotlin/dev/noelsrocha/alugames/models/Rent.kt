package dev.noelsrocha.alugames.models

data class Rent(
    val gamer: Gamer,
    val game: Game,
    val period: Period
) {
    private val rentValue = gamer.plan.getValue(this)
    var id = 0

    override fun toString(): String {
        return "Game ${game.title} was rented by ${gamer.name} for R$$rentValue"
    }
}
