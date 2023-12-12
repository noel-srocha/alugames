package dev.noelsrocha.alugames.models

interface Recommendable {
    val average: Double

    fun recommend(rating: Int)
}