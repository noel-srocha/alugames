package dev.noelsrocha.alugames.services

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.noelsrocha.alugames.models.*
import dev.noelsrocha.alugames.utils.createGame
import dev.noelsrocha.alugames.utils.createGamer
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class APIConsumer {

    private fun consumeDate(endereco: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun searchGame(id: String): InfoGame {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consumeDate(address)

        val gson = Gson()
        val myInfoGame = gson.fromJson(json, InfoGame::class.java)

        return myInfoGame

    }

    fun searchGamers(): List<Gamer> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consumeDate(address)

        val gson = Gson()
        val myGamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val gamerList: List<InfoGamerJson> = gson.fromJson(json, myGamerType)

        val convertedGamerList = gamerList.map { infoGamerJson -> infoGamerJson.createGamer() }

        return convertedGamerList
    }

    fun searchGamesJson(): List<Game> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consumeDate(address)

        val gson = Gson()
        val myGameType = object : TypeToken<List<InfoGameJson>>() {}.type
        val gameList: List<InfoGameJson> = gson.fromJson(json, myGameType)

        val convertedGameList = gameList.map { infoGameJson -> infoGameJson.createGame() }

        return convertedGameList
    }

}