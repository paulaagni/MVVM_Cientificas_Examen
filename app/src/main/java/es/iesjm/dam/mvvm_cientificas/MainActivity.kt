package es.iesjm.dam.mvvm_cientificas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import es.iesjm.dam.mvvm_cientificas.navigation.AppNavigation
import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme

// MainActivity es el punto de entrada de la aplicación.
// Extiende ComponentActivity para utilizar Jetpack Compose.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura el contenido de la actividad utilizando Jetpack Compose.
        setContent {
            // Aplica el tema personalizado de la aplicación.
            MVVM_CientificasTheme {
                // Crea el NavController, que se encarga de la navegación entre pantallas.
                val navController = rememberNavController()
                // Configura la navegación de la aplicación, pasando el NavController.
                AppNavigation(navController = navController)
            }
        }
    }
}
