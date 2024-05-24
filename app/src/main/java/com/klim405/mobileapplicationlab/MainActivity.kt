package com.klim405.mobileapplicationlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.klim405.mobileapplicationlab.data.ActuatorInfo
import com.klim405.mobileapplicationlab.data.ActuatorStatus
import com.klim405.mobileapplicationlab.data.ActuatorType
import com.klim405.mobileapplicationlab.ui.components.Actuator
import com.klim405.mobileapplicationlab.ui.components.RoomActuators
import com.klim405.mobileapplicationlab.ui.theme.MobileApplicationLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingPreview()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileApplicationLabTheme {
        RoomActuators(groupName = "bathroom", actuators = listOf(
            ActuatorInfo(1, "switch 2", "on", ActuatorStatus.ONLINE_ACTIVE, ActuatorType.FAN),
            ActuatorInfo(2, "switch 3", "off", ActuatorStatus.ONLINE_INACTIVE, ActuatorType.FAN),
            ActuatorInfo(3, "switch", "~", ActuatorStatus.OFFLINE, ActuatorType.FAN),
            ActuatorInfo(4, "bulb 2", "on", ActuatorStatus.ONLINE_ACTIVE, ActuatorType.LIGHT_BULB),
            ActuatorInfo(5, "bulb 3", "off", ActuatorStatus.ONLINE_INACTIVE, ActuatorType.LIGHT_BULB),
            ActuatorInfo(6, "bulb", "~", ActuatorStatus.OFFLINE, ActuatorType.LIGHT_BULB)))
    }
}