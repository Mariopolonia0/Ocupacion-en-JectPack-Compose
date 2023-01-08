package com.duramas_security.ocupacionescompose.ui.ocupacion

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.duramas_security.ocupacionescompose.componen.AlertDialogprobando
import com.duramas_security.ocupacionescompose.componen.BarraTitulo
import com.duramas_security.ocupacionescompose.componen.TiposDialog
import com.duramas_security.ocupacionescompose.models.Ocupacion
import com.duramas_security.ocupacionescompose.ui.theme.Azul200
import com.duramas_security.ocupacionescompose.ui.theme.Azul700
import com.duramas_security.ocupacionescompose.ui.theme.White000

@Composable
fun ListaOcupacion(
    navController: NavHostController,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val lista = viewModel.listaOcupacion.collectAsState(initial = emptyList())
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        BarraTitulo("Lista Ocupacion", navController)
        LazyColumn {
            items(lista.value) {
                RowOcupaciones(ocupacion = it, viewModel = viewModel)
            }
        }
    }
}

@Composable
private fun RowOcupaciones(ocupacion: Ocupacion, viewModel: MainActivityViewModel) {
    var show by rememberSaveable { mutableStateOf(false) }

    AlertDialogprobando(
        TiposDialog.Informacion,
        ocupacion,
        show = show,
        { show = false }
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { show = true }
            .background(
                color = Azul200, shape = RoundedCornerShape(10.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            fontSize = 14.sp,
            text = ocupacion.descripcion,
            color = White000
        )
        Text(
            fontSize = 14.sp,
            text = ocupacion.Salario.toString(),
            color = White000
        )
        IconButton(onClick = { viewModel.Delete(ocupacion) })
        {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "agregar",
                tint = Color.White
            )
        }
    }
}
