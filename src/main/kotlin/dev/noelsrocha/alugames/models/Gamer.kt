package dev.noelsrocha.alugames.models

import kotlin.random.Random

data class Gamer(var name: String, var email: String) : Recommendable {
    var birthDate: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internalID.isNullOrBlank()) {
                createInternalID()
            }
        }
    var id = 0
    private var internalID: String? = null
    var plan: Plan = LoosePlan("BRONZE")
    val searchedGames = mutableListOf<Game?>()
    private val rentedGames = mutableListOf<Rent>()
    private val ratingsList = mutableListOf<Int>()
    val recommendedGames = mutableListOf<Game>()

    override val average: Double
        get() = ratingsList.average()

    override fun recommend(rating: Int) {
        ratingsList.add(rating)
    }

    fun recommendGame(game: Game, nota: Int) {
        game.recommend(nota)
        recommendedGames.add(game)
    }

    constructor(name: String, email: String, birthDate: String, user: String, id: Int = 0) :
            this(name, email) {
        this.birthDate = birthDate
        this.user = user
        this.id = id
        createInternalID()
    }

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Name is empty!")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "Gamer:\n" +
                "Name: $name\n" +
                "Email: $email\n" +
                "Birth Date: $birthDate\n" +
                "User: $user\n" +
                "InternalID: $internalID\n" +
                "Reputation: $average\n" +
                "ID: $id"
    }

    private fun createInternalID() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        internalID = "$user#$tag"
    }

    private fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email is invalid!")
        }
    }

    fun rentGame(game: Game, period: Period): Rent {
        val rent = Rent(this, game, period)
        rentedGames.add(rent)

        return rent
    }

    fun gamesOfMonth(month: Int): List<Game> {
        return rentedGames
            .filter { rent -> rent.period.initialDate.monthValue == month }
            .map { rent -> rent.game }
    }

    companion object {
        fun createGamer(): Gamer {
            println("Welcome to AluGames! Let's being your registration. Type your name:")
            val name = readln()
            println("Type your email:")
            val email = readln()
            println("Would you like to complete your registration with your birth date and a user? 1 - Yes / 2 - No")
            val input = readln()

            if (input == "1") {
                println("Type your birth date (DD/MM/AAAA):")
                val birthDate = readln()
                println("Type your username:")
                val user = readln()

                return Gamer(name, email, birthDate, user)
            } else {
                return Gamer(name, email)
            }

        }
    }

}
