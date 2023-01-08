package com.duramas_security.ocupacionescompose.data

import com.duramas_security.ocupacionescompose.models.Ocupacion

data class OcupacioneListState(
    val isLoading: Boolean = false,
    val ocupaciones: List<Ocupacion> = emptyList(),
    val error: String = ""
)