package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import es.iesjm.dam.mvvm_cientificas.data.Cientificas

@Composable
fun ListaCientificasScreen(navController: NavController, cientificas: List<Cientificas>) {
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
                CientificaCard(cientifica = cientifica) {
                    // Navegar a la pantalla de detalles con los datos de la científica
                    navController.navigate("detalle/${cientifica.nombre}")
                }
            }
        }
    }
}
