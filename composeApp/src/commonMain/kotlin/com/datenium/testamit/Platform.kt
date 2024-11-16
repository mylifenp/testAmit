package com.datenium.testamit

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform