
package com.example.piedrapapeltijera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiedraPapelTijeraApp {
                GameApp()
            }
        }
    }
}

@Composable
fun GameApp() {
    var started by remember { mutableStateOf(false) }

    if (!started) {
        StartScreen(onStart = { started = true })
    } else {
        GameScreen()
    }
}

@Composable
fun StartScreen(onStart: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onStart,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
        ) {
            Text("Iniciar Juego", fontSize = 20.sp, color = Color.White)
        }
    }
}

@Composable
fun GameScreen() {
    var userChoice by remember { mutableStateOf("") }
    var computerChoice by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    val options = listOf("Piedra", "Papel", "Tijera")

    fun play(choice: String) {
        userChoice = choice
        computerChoice = options.random()

        result = when {
            userChoice == computerChoice -> "Empate"
            userChoice == "Piedra" && computerChoice == "Tijera" -> "Ganaste"
            userChoice == "Papel" && computerChoice == "Piedra" -> "Ganaste"
            userChoice == "Tijera" && computerChoice == "Papel" -> "Ganaste"
            else -> "Perdiste"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Elegí tu jugada:", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            options.forEach { option ->
                Button(onClick = { play(option) }) {
                    Text(option)
                }
            }
        }

        if (userChoice.isNotEmpty()) {
            Text("Vos elegiste: $userChoice", fontSize = 18.sp)
            Text("La compu eligió: $computerChoice", fontSize = 18.sp)
            Text("Resultado: $result", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}
/*package com.example.piedrapapeltijera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piedrapapeltijera.ui.theme.PiedrapapeltijeraTheme


/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PiedrapapeltijeraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "usuario",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PiedraPapelTijeraApp()
        }
    }
}

/*@Composable
fun PiedraPapelTijeraUI() {
    var resultado by remember { mutableStateOf("¡Juguemos!") }//guuarda los estados
    var colorResultado by remember { mutableStateOf (Color. White ) }

    val opciones = listOf("Piedra", "Papel", "Tijera")

    fun jugar(eleccionUsuario: String) {
        val eleccionComputadora = opciones.random()
        var mensaje:String
        var color:Color
         when {
            eleccionUsuario == eleccionComputadora -> {
                mensaje = "Empate. Ambos eligieron $eleccionUsuario."
                color = Color.Magenta
            }
             eleccionUsuario == "Piedra" && eleccionComputadora == "Tijera" ||
                    eleccionUsuario == "Papel" && eleccionComputadora == "Piedra" ||
                    eleccionUsuario == "Tijera" && eleccionComputadora == "Papel" -> {
                mensaje = "Ganaste. $eleccionUsuario vence a $eleccionComputadora."
                 color = Color(0xFF2E7D32) // Verde
             }
            else -> {
                 mensaje = "Perdiste. $eleccionComputadora vence a $eleccionUsuario."
                color = Color.Red
            }
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
}*/

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier) {
        Text(
            text = "Bienvenido $name!",
            fontSize = 25.sp,
            modifier = modifier
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiedrapapeltijeraTheme {
        Greeting("Android")
    }
}
*/