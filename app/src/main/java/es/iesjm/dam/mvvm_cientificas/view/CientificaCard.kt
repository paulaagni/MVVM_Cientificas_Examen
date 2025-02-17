package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.iesjm.dam.mvvm_cientificas.data.Cientificas

// Composable que representa una tarjeta para mostrar la información de una científica.
// Recibe un objeto Cientificas y una función onClick que se ejecuta al pulsar la tarjeta.
@Composable
fun CientificaCard(cientifica: Cientificas, onClick: () -> Unit) {
    // Se define una Card con un modificador que incluye padding y funcionalidad clickable.
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }, // Se ejecuta la función onClick cuando se pulsa la tarjeta.
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer // Color de fondo de la tarjeta.
        )
    ) {
        // Se utiliza una Column para organizar el contenido de la tarjeta verticalmente.
        Column(modifier = Modifier.padding(16.dp)) {
            // Muestra el nombre de la científica.
            Text(
                text = cientifica.nombre,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            // Espacio entre elementos.
            Spacer(modifier = Modifier.height(8.dp))
            // Muestra los logros de la científica, concatenados en una cadena de texto.
            Text(
                text = "Logros: ${cientifica.logros}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}
