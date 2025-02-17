package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Columna que organiza los elementos verticalmente.
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {
                // Si la lista de científicas está vacía, se muestra un mensaje.
                if (cientificas.isEmpty()) {
                    Text(
                        text = "No hay científicas para mostrar",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    // Se utiliza LazyColumn para mostrar la lista de científicas de forma perezosa.
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        items(cientificas) { cientifica ->
                            // Muestra la tarjeta para cada científica.
                            CientificaCard(cientifica = cientifica) {
                                coroutineScope.launch {
                                    // Muestra la rueda de cargando.
                                    isLoading = true
                                    // Simula una operación asíncrona.
                                    delay(700L)
                                    // Oculta la rueda de cargando.
                                    isLoading = false
                                    // Navega a la pantalla de detalles.
                                    navController.navigate("detalle/${cientifica.nombre}")
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }

            // Si isLoading es true, se muestra un overlay con un CircularProgressIndicator.
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }

