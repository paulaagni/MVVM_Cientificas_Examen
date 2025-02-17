package es.iesjm.dam.mvvm_cientificas.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import es.iesjm.dam.mvvm_cientificas.view.DetalleCientificaScreen
import es.iesjm.dam.mvvm_cientificas.view.ListaCientificasScreen
import es.iesjm.dam.mvvm_cientificas.viewmodel.CientificasViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    // Se obtiene el ViewModel utilizando el factory definido en CientificasViewModel.
    val viewModel: CientificasViewModel = viewModel(factory = CientificasViewModel.factory)

    // Se recolecta el Flow de científicas y se convierte en un State para poder observar cambios en la UI.
    // 'emptyList()' se usa como valor inicial hasta que se emitan datos.
    val cientificas by viewModel.getCientificas().collectAsState(emptyList())

    // Se define el NavHost que contiene las rutas (composables) de la aplicación.
    NavHost(navController = navController, startDestination = "lista") {
        // Ruta para la pantalla de lista de científicas.
        composable("lista") {
            ListaCientificasScreen(
                navController = navController,
                cientificas = cientificas
            )
        }
        // Ruta para la pantalla de detalle de una científica.
        // Se espera un parámetro "nombre" en la URL.
        composable("detalle/{nombre}") { backStackEntry ->
            // Se extrae el valor del parámetro "nombre" de los argumentos.
            val nombre = backStackEntry.arguments?.getString("nombre")
            // Se busca la científica en la lista cuyo nombre coincida con el parámetro.
            val cientifica = cientificas.find { it.nombre == nombre }
            // Si se encuentra la científica, se muestra la pantalla de detalle.
            cientifica?.let {
                DetalleCientificaScreen(cientifica = it)
            }
        }
    }
}
