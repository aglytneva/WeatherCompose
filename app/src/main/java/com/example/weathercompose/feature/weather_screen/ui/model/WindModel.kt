package com.example.weathercompose.feature.weather_screen.ui.model

data class WindModel(val windDeg: String, val windSpeed: String) {
//    fun toTextualDescription(windDeg: String): String {
//        if (windDeg.toFloat() > 337.5) return "Северный"
//        if (windDeg.toFloat() > 292.5) return "Северо-западный"
//        if (windDeg.toFloat() > 247.5) return "Западный"
//        if (windDeg.toFloat() > 202.5) return "Юго-западный"
//        if (windDeg.toFloat() > 157.5) return "Южный"
//        if (windDeg.toFloat() > 122.5) return "Юго-Восточный"
//        if (windDeg.toFloat() > 67.5) return "Восточный"
//        if (windDeg.toFloat() > 22.5)  return "Северо-восточный"
//        return ""
//    }

    fun toTextualDescription(windDeg: String): String {
        if (windDeg.toFloat() > 337.5) return "С"
        if (windDeg.toFloat() > 292.5) return "СЗ"
        if (windDeg.toFloat() > 247.5) return "З"
        if (windDeg.toFloat() > 202.5) return "ЮЗ"
        if (windDeg.toFloat() > 157.5) return "Ю"
        if (windDeg.toFloat() > 122.5) return "ЮВ"
        if (windDeg.toFloat() > 67.5) return "В"
        if (windDeg.toFloat() > 22.5)  return "СВ"
        return ""
    }
}
