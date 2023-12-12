package dev.noelsrocha.alugames.models

import com.google.gson.annotations.Expose

data class Game(
    @Expose val title: String,
    @Expose val thumb: String
) : Recommendable {
    var id = 0
    var description: String? = null
    var price = 0.0


    private val ratingsList = mutableListOf<Int>()
    override val average: Double
        get() = ratingsList.average()

    override fun recommend(rating: Int) {
        ratingsList.add(rating)
    }

    constructor(title: String, thumb: String, price: Double, description: String, id: Int = 0) :
            this(title, thumb) {
        this.price = price
        this.description = description
        this.id = id
    }

    override fun toString(): String {
        return "My Game: \n" +
                "Title: $title \n" +
                "Thumbnail: $thumb \n" +
                "Description: $description \n" +
                "Price: $price \n" +
                "Reputation: $average\n" +
                "ID: $id"
    }
}