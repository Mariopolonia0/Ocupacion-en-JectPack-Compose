package com.duramas_security.ocupacionescompose.componen

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

//este test es a la barra de titulo
//el rule
class BarraTituloKtTest{
    //el createComposeRule permite establecer el contenido de Compose
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun BarraTituloAppBarTest(){
        composeTestRule.setContent {
            BarraTitulo(
                titulo = "ya si enel",
                _counter = 6
            )
        }
        //Thread.sleep(5000)
        composeTestRule.onNodeWithContentDescription("ya si enel").assertIsSelected()
    }


}