package com.example.catalogofilme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AndroidApp()



            /* PARA O PROJETO RODAR TEM QUE IR EM git log --oneline
                DEPOIS RODAR O COMANDO ABAIXO
                git reset --hard 07d2161
                E AI É SÓ RODAR O APP
             */

        }
    }
}