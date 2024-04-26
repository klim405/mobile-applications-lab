package com.klim405.mobileapplicationlab.data

data class ActuatorInfo(
    val id: Int,
    val name: String,
    val statusInfo: String,
    val status: ActuatorStatus,
    val type: ActuatorType
)
