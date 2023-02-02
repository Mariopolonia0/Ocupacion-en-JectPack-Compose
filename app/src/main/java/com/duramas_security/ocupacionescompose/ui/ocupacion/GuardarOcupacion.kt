package com.duramas_security.ocupacionescompose.ui.ocupacion

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.duramas_security.ocupacionescompose.componen.BarraTitulo
import com.duramas_security.ocupacionescompose.ui.theme.Azul200
import com.duramas_security.ocupacionescompose.ui.theme.Shapes
import com.duramas_security.ocupacionescompose.ui.theme.White000
import androidx.compose.ui.Alignment
import com.duramas_security.ocupacionescompose.data.ImpresionBluetooth
import com.duramas_security.ocupacionescompose.models.Ocupacion
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun GuardarOcupacion(
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    val descripcion = remember { mutableStateOf("") }
    val salario = remember { mutableStateOf("") }
    val mContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BarraTitulo("Ocupación")
        OutlinedTextField(
            value = descripcion.value,
            onValueChange = { descripcion.value = it },
            label = { Text(text = "Ocupacion") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 8.dp)
        )
        OutlinedTextField(
            value = salario.value,
            onValueChange = { salario.value = it },
            label = {
                Text(text = "Salario")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Button(
                modifier = Modifier
                    .padding(10.dp),
                shape = Shapes.small,
                colors = ButtonDefaults.buttonColors(backgroundColor = Azul200),
                onClick = {
                    val guardado = guardarOcupacion(viewModel, descripcion.value, salario.value)

                    if (guardado) {
                        descripcion.value = ""
                        salario.value = ""
                        mToast(mContext, "Se guardo")
                    }
                },
            ) {
                Text(
                    fontSize = 16.sp,
                    text = "Guardar",
                    color = White000
                )
            }
            Button(
                modifier = Modifier
                    .padding(10.dp),
                shape = Shapes.small,
                colors = ButtonDefaults.buttonColors(backgroundColor = Azul200),
                onClick = {
                     imprimirOcupacion( descripcion.value, salario.value)
                },
            ) {
                Text(
                    fontSize = 16.sp,
                    text = "Imprimir",
                    color = White000
                )
            }
        }
    }
}

private fun mToast(context: Context, mensaje: String) {
    Toast.makeText(
        context,
        mensaje,
        Toast.LENGTH_LONG
    ).show()
}

fun imprimirOcupacion(
    descripcion: String,
    salario: String
) {
    val sdf = SimpleDateFormat("dd/M/yyyy")
    val currentDate = sdf.format(Date())

    val ocupacion = Ocupacion(0,
        descripcion,
        currentDate,
        salario.toDouble()
    )

    ImpresionBluetooth(ocupacion)
}

fun guardarOcupacion(
    viewModel: MainActivityViewModel,
    descripcion: String,
    salario: String
): Boolean {
    if (descripcion.length == 0 || salario.length == 0)
        return false

    viewModel.insertarOcupacion(
        descripcion,
        salario.toDouble()
    )

    return true
}


