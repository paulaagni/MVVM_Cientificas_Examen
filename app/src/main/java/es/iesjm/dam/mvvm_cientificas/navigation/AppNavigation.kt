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

    val viewModel: CientificasViewModel = viewModel(factory = CientificasViewModel.factory)
    val cientificas by viewModel.getCientificas().collectAsState(emptyList())

    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            ListaCientificasScreen(
                navController = navController,
                cientificas = cientificas
            )
        }
        composable("detalle/{nombre}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre")
            val cientifica = cientificas.find { it.nombre == nombre }
            cientifica?.let {
                DetalleCientificaScreen(cientifica = it)
            }
        }
    }
}