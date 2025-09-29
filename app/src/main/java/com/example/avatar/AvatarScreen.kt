package com.example.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.avatar.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvatarScreen() {
    var showBrows by remember { mutableStateOf(true) }
    var showEyes by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "AvatarApp",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.weight(0.5f))

                Box(modifier = Modifier.size(300.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.head),
                        contentDescription = "Head",
                        modifier = Modifier.fillMaxSize()
                    )
                    if (showBrows) {
                        Image(
                            painter = painterResource(id = R.drawable.brows),
                            contentDescription = "Brows",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(140.dp)
                                .offset(y = (-25).dp)
                        )
                    }
                    if (showEyes) {
                        Image(
                            painter = painterResource(id = R.drawable.eyes),
                            contentDescription = "Eyes",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(130.dp)
                                .offset(y = (0).dp)
                        )
                    }
                    if (showNose) {
                        Image(
                            painter = painterResource(id = R.drawable.nose),
                            contentDescription = "Nose",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(40.dp)
                                .offset(y = 25.dp)
                        )
                    }
                    if (showMouth) {
                        Image(
                            painter = painterResource(id = R.drawable.mouth),
                            contentDescription = "Mouth",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(60.dp)
                                .offset(y = 60.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp),
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

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun CheckboxWithLabel(checked: Boolean, onCheckedChange: (Boolean) -> Unit, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Orange,
                uncheckedColor = Orange,
                checkmarkColor = Color.White
            )
        )
        Text(text = label)
    }
}