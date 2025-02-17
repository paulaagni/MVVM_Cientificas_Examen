package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.iesjm.dam.mvvm_cientificas.data.Cientificas
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ListaCientificasScreen(navController: NavController, cientificas: List<Cientificas>) {
    // Scope para lanzar corrutinas en el Composable.
    val coroutineScope = rememberCoroutineScope()
    // Estado para controlar la visibilidad de la rueda de cargando.
    var isLoading by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            if (cientificas.isEmpty()) {
                Text(
                    text = "No hay científicas para mostrar",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                cientificas.forEach { cientifica ->
                    // Muestra la tarjeta para cada científica.
                    CientificaCard(cientifica = cientifica) {
                        // Al pulsar la tarjeta, se lanza una corrutina.
                        coroutineScope.launch {
                            // Muestra la rueda de cargando.
                            isLoading = true
                            // Simula una operación asíncrona (por ejemplo, una animación o petición)
                            delay(500L)
                            // Oculta la rueda de cargando.
                            isLoading = false
                            // Navega a la pantalla de detalles.
                            navController.navigate("detalle/${cientifica.nombre}")
                        }
                    }
                }
            }
        }

        // Si isLoading es true, se muestra un overlay con un CircularProgressIndicator.
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    // Fondo semitransparente para resaltar la rueda de cargando.
                    .background(Color.Black.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
