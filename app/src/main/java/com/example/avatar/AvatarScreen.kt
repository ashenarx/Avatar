package com.example.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AvatarScreen() {
    var showBrows by remember { mutableStateOf(true) }
    var showEyes by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.size(250.dp)) {
            Image(
                painter = painterResource(id = R.drawable.head),
                contentDescription = "Head"
            )
            if (showBrows) {
                Image(
                    painter = painterResource(id = R.drawable.brows),
                    contentDescription = "Brows"
                )
            }
            if (showEyes) {
                Image(
                    painter = painterResource(id = R.drawable.eyes),
                    contentDescription = "Eyes"
                )
            }
            if (showNose) {
                Image(
                    painter = painterResource(id = R.drawable.nose),
                    contentDescription = "Nose"
                )
            }
            if (showMouth) {
                Image(
                    painter = painterResource(id = R.drawable.mouth),
                    contentDescription = "Mouth"
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CheckboxWithLabel(
                checked = showBrows,
                onCheckedChange = { showBrows = it },
                label = "Brow"
            )
            CheckboxWithLabel(
                checked = showEyes,
                onCheckedChange = { showEyes = it },
                label = "Eye"
            )
            CheckboxWithLabel(
                checked = showNose,
                onCheckedChange = { showNose = it },
                label = "Nose"
            )
            CheckboxWithLabel(
                checked = showMouth,
                onCheckedChange = { showMouth = it },
                label = "Mouth"
            )
        }
    }
}

@Composable
fun CheckboxWithLabel(checked: Boolean, onCheckedChange: (Boolean) -> Unit, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(text = label)
    }
}