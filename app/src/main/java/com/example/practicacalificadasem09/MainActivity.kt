package com.example.practicacalificadasem09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicacalificadasem09.ui.theme.PracticaCalificadaSem09Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticaCalificadaSem09Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Registro(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Registro(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }
    var contador by remember { mutableIntStateOf(0) }
    var ultimo by remember { mutableStateOf("Ninguno") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Control de Aforo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Personas dentro: $contador",
            fontSize = 18.sp,

        )

        Text(
            text = "Último registrado: $ultimo",
            fontSize = 18.sp,

        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                    ultimo = nombre
                    contador += 1
                    nombre = ""

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar e Ingresar", fontSize = 16.sp)
        }
        Row() {
            Button(
                onClick = {
                    contador = contador - 1
                },

            ) {
                Text("Salida (-1) ", fontSize = 16.sp)
            }
            Button(
                onClick = {
                    contador = 0
                    ultimo = "Ninguno"
                },

            ) {
                Text("Reiniciar", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroPreview() {
    PracticaCalificadaSem09Theme {
        Registro()
    }
}
