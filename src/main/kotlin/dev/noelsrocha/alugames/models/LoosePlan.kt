package dev.noelsrocha.alugames.models

class LoosePlan(type: String, id: Int = 0) : Plan(type, id) {
    override fun getValue(rent: Rent): Double {
        var originalValue = super.getValue(rent)
        if (rent.gamer.average > 8) {
            originalValue -= originalValue * 0.1
        }
        return originalValue
    }

    override fun toString(): String {
        return "Loose Plan\n" +
                "Type: $type\n" +
                "ID: $id\n"
    }
}
