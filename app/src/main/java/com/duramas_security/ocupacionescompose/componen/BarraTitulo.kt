package com.duramas_security.ocupacionescompose.componen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.duramas_security.ocupacionescompose.ui.theme.Azul200

@Composable
fun BarraTitulo(
    titulo: String,
    navController: NavHostController? = null,
) {
    TopAppBar(
        backgroundColor = Azul200,
        title = {
            Text(
                titulo, modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        actions = {
            if (navController != null) {
                IconButton(onClick = { navController.navigate("guardarOcupacion") }) {
                    Icon(
                        Icons.Outlined.Add,
                        contentDescription = "Agregar",
                        tint = Color.White,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
    )
}


