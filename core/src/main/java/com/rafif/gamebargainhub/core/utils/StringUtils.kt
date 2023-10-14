package com.rafif.gamebargainhub.core.utils

object StringUtils {
    // Create a map of storeId to storeName manually
    val storeMap = mapOf(
        1 to "Steam", 2 to "GamersGate", 3 to "GreenManGaming", 4 to "Amazon", 5 to "GameStop",
        6 to "Direct2Drive", 7 to "GOG", 8 to "Origin", 9 to "Get Games", 10 to "Shiny Loot",
        11 to "Humble Store", 12 to "Desura", 13 to "Uplay", 14 to "IndieGameStand", 15 to "Fanatical",
        16 to "Gamesrocket", 17 to "Games Republic", 18 to "SilaGames", 19 to "Playfield",
        20 to "ImperialGames", 21 to "WinGameStore", 22 to "FunStockDigital", 23 to "GameBillet",
        24 to "Voidu", 25 to "Epic Games Store", 26 to "Razer Game Store", 27 to "Gamesplanet",
        28 to "Gamesload", 29 to "2Game", 30 to "IndieGala", 31 to "Blizzard Shop",
        32 to "AllYouPlay", 33 to "DLGamer", 34 to "Noctre", 35 to "DreamGame",
    )

    // Define a function that takes a storeId and returns the storeName
    fun getStoreName(storeId: String): String {
        return storeMap.getOrDefault(storeId.toInt(), "Unknown")
    }
}