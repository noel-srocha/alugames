package dev.noelsrocha.alugames.main

import dev.noelsrocha.alugames.models.Game
import dev.noelsrocha.alugames.models.Gamer
import dev.noelsrocha.alugames.services.APIConsumer
import getAge


fun main() {
    val gamer = Gamer.createGamer()
    println("Registration completed. Gamer data:")
    println(gamer)
    println("Gamer\'s age: ${gamer.birthDate?.getAge()}")

    do {
        println("Type a game ID in order to search for it:")
        val search = readln()

        val apiConsumer = APIConsumer()
        val infoGame = apiConsumer.searchGame(search)


        var myGame: Game? = null

        val result = runCatching {
            myGame = Game(
                infoGame.info.title,
                infoGame.info.thumb
            )
        }

        result.onFailure {
            println("Game not found! Please try another ID.")
        }

        result.onSuccess {
            println("Would you like to add a custom description to your game? 1 - Yes / 2 - No")
            val input = readln()
            if (input == "1") {
                println("Type your custom description:")
                val customDescription = readln()
                myGame?.description = customDescription
            } else
                myGame?.description = myGame?.title

            gamer.searchedGames.add(myGame)
        }

        println("Would you like to search for another game? 1 - Yes / 2 - No")
        val answer = readln()

    } while (answer == "1")

    println("Searched Games:")
    println(gamer.searchedGames)

    println("\n Games sorted by title: ")
    gamer.searchedGames.sortBy {
        it?.title
    }

    gamer.searchedGames.forEach {
        println("Title: " + it?.title)
    }

    val filteredGames = gamer.searchedGames.filter {
        it?.title?.contains("batman", true) ?: false
    }
    println("\n Filtered Games: ")
    println(filteredGames)

    println("Would you like to remove a game from your list? 1 - Yes/ 2 - No")
    val input = readln()
    if (input == "1") {
        println(gamer.searchedGames)
        println("\nType the game\'s index in order to remove it: ")
        val index = readln().toInt()
        gamer.searchedGames.removeAt(index)
    }

    println("\n Updated List:")
    println(gamer.searchedGames)

    println("Search completed!")

}