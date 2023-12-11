package dev.noelsrocha.alugames.models

class SubscriptionPlan(
    tipo: String,
    val monthlyPayment: Double,
    val includedGames: Int,
    val reputationDiscountPercentage: Double,
    id: Int = 0
) : Plan(tipo, id) {

    override fun getValue(rent: Rent): Double {
        val gamesInMonthTotal = rent.gamer.gamesOfMonth(rent.period.initialDate.monthValue).size + 1

        return if (gamesInMonthTotal <= includedGames) {
            0.0
        } else {
            var originalValue = super.getValue(rent)
            if (rent.gamer.average > 8) {
                originalValue -= originalValue * reputationDiscountPercentage
            }
            originalValue
        }
    }

    override fun toString(): String {
        return "Subscription Plan\n" +
                "Type: $type\n" +
                "ID: $id\n" +
                "Monthly Payment: $monthlyPayment\n" +
                "Included Games: $includedGames\n" +
                "Reputation Discount Percentage: $reputationDiscountPercentage\n"
    }
}
