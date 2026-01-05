package com.example.catalogofilme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform