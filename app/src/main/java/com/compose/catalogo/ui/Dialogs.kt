package com.compose.catalogo.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.compose.catalogo.R

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cerrar")
                }
            },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirmar")
                }
            },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Hola soy una descripcion super way") }
        )
    }
}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo")
                Text(text = "Esto es un ejemplo")
                Text(text = "Esto es un ejemplo")
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem("email1@gmail.com", drawable = R.drawable.baseline_self_improvement_24)
                AccountItem("email2@gmail.com", drawable = R.drawable.baseline_self_improvement_24)
                AccountItem("Añadir nueva cuenta", drawable = R.drawable.baseline_add_box_24)
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
        )

        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(text: String) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(12.dp)
    )
}

@Composable
fun MyDialogConfirmation(show: Boolean, onDismiss: () -> Unit) {
    var name by rememberSaveable { mutableStateOf("Cris") }

    if (show) {
        Dialog(onDismissRequest = onDismiss) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Column(
                    Modifier
                        .background(Color.White)
                        .padding(24.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(50.dp))
                ) {
                    MyTitleDialog(text = "Phone ringtone")
                    Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                    RadioButtonList(name) { name = it }
                    Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                    ButtonRight(onDismiss)
                }
            }
        }
    }
}

@Composable
fun RadioButtonList(textName: String, onItemSelected: (String) -> Unit) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = textName == "Cris", onClick = { onItemSelected("Cris") })
            Text(text = "Cris")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = textName == "Yus", onClick = { onItemSelected("Yus") })
            Text(text = "Yus")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = textName == "Lia", onClick = { onItemSelected("Lia") })
            Text(text = "Lia")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = textName == "Nala", onClick = { onItemSelected("Nala") })
            Text(text = "Nala")
        }
    }
}

@Composable
fun ButtonRight(onDismiss: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.End,
    ) {
        TextButton(onClick = { onDismiss() }) {
            Text(text = "Cancel")
        }
        TextButton(onClick = { onDismiss() }) {
            Text(text = "Ok")
        }
    }
}
