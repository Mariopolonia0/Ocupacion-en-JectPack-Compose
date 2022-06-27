package com.duramas_security.ocupacionescompose.componen

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test


class BarraTituloKtTest{
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
        Thread.sleep(5000)
    }
}