package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import es.iesjm.dam.mvvm_cientificas.data.Cientificas

// Composable que muestra los detalles de una científica en una tarjeta.
@Composable
fun DetalleCientificaScreen(cientifica: Cientificas) {
    // Card que contiene toda la información detallada.
    Card(
        modifier = Modifier.padding(16.dp), // Espacio exterior alrededor de la tarjeta.
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp), // Sombra de la tarjeta.
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer // Color de fondo de la tarjeta.
        )
    ) {
        // Column para organizar los elementos verticalmente dentro de la tarjeta.
        Column(modifier = Modifier.padding(24.dp)) { // Espacio interior de la tarjeta.
            // Título que muestra el nombre de la científica.
            Text(
                text = cientifica.nombre,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp)) // Espacio vertical entre elementos.
            // Divider para separar visualmente el título de los demás contenidos.
            Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp)) // Espacio vertical antes de la siguiente sección.

            // Sección que muestra el encabezado "Logros:".
            Text(
                text = "Logros:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(4.dp)) // Espacio pequeño entre el título y el contenido.
            // Muestra los logros de la científica.
            Text(
                text = cientifica.logros,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(16.dp)) // Espacio vertical entre secciones.

            // Sección que muestra el encabezado "Biografía ampliada:".
            Text(
                text = "Biografía ampliada:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(4.dp)) // Espacio pequeño entre el título y el contenido.
            // Muestra la biografía de la científica.
            Text(
                text = cientifica.biografia,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}
