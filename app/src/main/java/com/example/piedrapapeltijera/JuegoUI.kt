package com.example.piedrapapeltijera


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PiedraPapelTijeraUI() {
    var resultado by remember { mutableStateOf("¡Juguemos!") }
    var colorResultado by remember { mutableStateOf(Color.Black) }
    val opciones = listOf("Piedra", "Papel", "Tijera")

    fun jugar(eleccionUsuario: String) {
        val eleccionComputadora = opciones.random()

        val (mensaje, color) = when {
            eleccionUsuario == eleccionComputadora ->
                "Empate. Ambos eligieron $eleccionUsuario." to Color.Gray
            eleccionUsuario == "Piedra" && eleccionComputadora == "Tijera" ||
                    eleccionUsuario == "Papel" && eleccionComputadora == "Piedra" ||
                    eleccionUsuario == "Tijera" && eleccionComputadora == "Papel" ->
                "Ganaste. $eleccionUsuario vence a $eleccionComputadora." to Color(0xFF2E7D32)
            else ->
                "Perdiste. $eleccionComputadora vence a $eleccionUsuario." to Color.Red
        }

        resultado = mensaje
        colorResultado = color
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = resultado,
            color = colorResultado,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(onClick = { jugar("Piedra") }) {
            Text("Piedra")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { jugar("Papel") }) {
            Text("Papel")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { jugar("Tijera") }) {
            Text("Tijera")
        }
    }
}