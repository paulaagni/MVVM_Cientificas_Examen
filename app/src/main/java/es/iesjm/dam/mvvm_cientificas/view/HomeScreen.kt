package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import es.iesjm.dam.mvvm_cientificas.R
import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme


@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Separación entre cards en vertical
        horizontalAlignment = Alignment.CenterHorizontally // Alineación horizontal en el centro
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)

        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp), // Separación entre cards en vertical
                horizontalAlignment = Alignment.CenterHorizontally // Separación entre elementos en vertical
            ){
                Text(
                    text= "Mujeres Stem",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                    )
                Image(
                    painter = painterResource(id = R.drawable.stem),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(shapes.medium),
                    alignment = Alignment.Center
                )
                Button(
                    modifier = Modifier.padding(top = 8.dp),
                    onClick = {
                        navController.navigate("lista")
                    },
                    enabled = true,
                    shape = shapes.medium,
                    content = { Text("Conócelas") }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    MVVM_CientificasTheme {
        HomeScreen(navController = NavController(LocalContext.current))
    }
}

