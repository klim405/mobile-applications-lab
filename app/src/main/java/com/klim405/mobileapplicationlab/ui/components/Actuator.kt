package com.klim405.mobileapplicationlab.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.klim405.mobileapplicationlab.R
import com.klim405.mobileapplicationlab.data.ActuatorInfo
import com.klim405.mobileapplicationlab.data.ActuatorStatus
import com.klim405.mobileapplicationlab.data.ActuatorType
import com.klim405.mobileapplicationlab.ui.theme.ActiveActuatorColor
import com.klim405.mobileapplicationlab.ui.theme.ActiveActuatorTextColor
import com.klim405.mobileapplicationlab.ui.theme.DefaultActuatorColor
import com.klim405.mobileapplicationlab.ui.theme.InactiveActuatorColor
import com.klim405.mobileapplicationlab.ui.theme.InactiveActuatorTextColor
import com.klim405.mobileapplicationlab.ui.theme.MicroClimateActuatorColor


fun getActuatorPrimaryColor(actuatorInfo: ActuatorInfo): Color {
    return when (actuatorInfo.type) {
        ActuatorType.SWITCH -> DefaultActuatorColor
        ActuatorType.LIGHT_BULB -> DefaultActuatorColor
        ActuatorType.FAN -> MicroClimateActuatorColor
    }
}

fun getActuatorIconBgColor(actuatorInfo: ActuatorInfo): Color {
    return when (actuatorInfo.status) {
        ActuatorStatus.ONLINE_ACTIVE -> getActuatorPrimaryColor(actuatorInfo)
        ActuatorStatus.ONLINE_INACTIVE -> InactiveActuatorColor
        ActuatorStatus.OFFLINE -> InactiveActuatorColor
    }
}

fun getActuatorIconColor(actuatorInfo: ActuatorInfo): Color {
    return when (actuatorInfo.status) {
        ActuatorStatus.ONLINE_ACTIVE -> ActiveActuatorColor
        ActuatorStatus.ONLINE_INACTIVE -> getActuatorPrimaryColor(actuatorInfo)
        ActuatorStatus.OFFLINE -> ActiveActuatorColor
    }
}

fun getActuatorIconRes(actuatorInfo: ActuatorInfo): Int {
    return when(actuatorInfo.type) {
        ActuatorType.SWITCH -> R.drawable.ic_switch_off
        ActuatorType.LIGHT_BULB -> R.drawable.ic_lightbulb
        ActuatorType.FAN -> R.drawable.ic_fan
    }
}

@Composable
fun ActuatorIcon(actuatorInfo: ActuatorInfo) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(getActuatorIconBgColor(actuatorInfo))
            .padding(7.dp)
    ) {
        Image(
            painter = painterResource(getActuatorIconRes(actuatorInfo)),
            contentDescription = "", Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(getActuatorIconColor(actuatorInfo))
        )
    }
}

@Composable
fun Actuator(actuatorInfo: ActuatorInfo) {
    Row (
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (actuatorInfo.status == ActuatorStatus.ONLINE_ACTIVE) ActiveActuatorColor else InactiveActuatorColor)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        ActuatorIcon(actuatorInfo)
        Column (modifier = Modifier.padding(start = 10.dp)) {
            Text(
                text = actuatorInfo.name,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = if (actuatorInfo.status == ActuatorStatus.ONLINE_ACTIVE) ActiveActuatorTextColor else InactiveActuatorTextColor
            )
            Text(
                text = actuatorInfo.statusInfo,
                color = if (actuatorInfo.status == ActuatorStatus.ONLINE_ACTIVE) ActiveActuatorTextColor else InactiveActuatorTextColor
            )
        }
    }
}