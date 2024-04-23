package com.compose.catalogo.ui

import androidx.compose.ui.text.font.FontFamily
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.compose.catalogo.ui.theme.CatalogoTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.compose.catalogo.R

class ComponentsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatalogoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    /*
                    CallBack
                    Column() {
                        var name by rememberSaveable { mutableStateOf("") }
                        MyTextField(name) { name = it }
                    }
                     */

                    // Make row's from List
                    // val myOptions = getOption(listOf("Lia", "Nala"))
                    // AddRowForListDefault(myOptions)

                    /*
                    var selected by rememberSaveable { mutableStateOf("Cris") }
                    ColumnDefaultRadioButtonList(selected) { selected = it }
                     */

                    ColumnDefault()
                }
            }
        }
    }

    @Composable
    fun getOption(titles: List<String>): List<CheckInfo> {
        return titles.map { title ->
            var status by rememberSaveable {
                mutableStateOf(false)
            }

            CheckInfo(
                title = title,
                selected = status,
                onCheckedChange = { status = it }
            )
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun MiTextOutLine() {
        var textField by rememberSaveable { mutableStateOf("") }
        OutlinedTextField(
            value = textField,
            onValueChange = {
                textField = if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
            },
            label = { Text(text = "Introduce tu nombre") },
            modifier = Modifier.padding(24.dp)
        )
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun MyTextFieldAdvance() {
        var textField by rememberSaveable { mutableStateOf("") }
        TextField(
            value = textField,
            onValueChange = {
                textField = if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
            },
            label = { Text(text = "Introduce tu nombre") })
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField(name: String, onValueChanged: (String) -> Unit) {
        TextField(value = name, onValueChange = { onValueChanged })
    }

    @Composable
    fun MyText() {
        Column(Modifier.fillMaxSize()) {
            Text(text = "Esto es un ejemplo")
            Text(text = "Esto es otro ejemplo", color = Color.Blue)
            Text(text = "Esto es otro ejemplo", fontWeight = FontWeight.ExtraBold)
            Text(text = "Esto es otro ejemplo", fontWeight = FontWeight.Light)
            Text(
                text = "Esto es otro ejemplo",
                style = TextStyle(fontFamily = FontFamily.Cursive)
            )
            Text(
                text = "Esto es otro ejemplo",
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
            Text(
                text = "Esto es otro ejemplo",
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
            Text(
                text = "Esto es otro ejemplo",
                style = TextStyle(
                    textDecoration = TextDecoration.combine(
                        listOf(
                            TextDecoration.LineThrough,
                            TextDecoration.Underline
                        )
                    )
                )
            )
            Text(
                text = "Esto es otro ejemplo",
                fontSize = 30.sp
            )
        }
    }

    @Composable
    fun MyButtomExample() {
        var enable by rememberSaveable { mutableStateOf(true) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Button(
                onClick = { enable = false }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Red
                ), border = BorderStroke(10.dp, Color.Yellow),
                enabled = enable
            ) {
                Text(text = "Hola")
            }
        }
    }

    @Composable
    fun MyImageAdvance() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "ejemplo",
                modifier = Modifier.clip(RoundedCornerShape(25f))

            )
        }
    }

    @Composable
    fun MyIcon() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.AccountBox,
                contentDescription = "ejemplo",
                tint = Color.Red
            )
        }
    }

    @Composable
    fun MyProgress() {
        var showLoading by rememberSaveable { mutableStateOf(false) }

        if (showLoading) {
            CircularProgressIndicator()
            LinearProgressIndicator()
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = " Cargar perfil")
        }
    }

    @Composable
    fun MyProgressAdvance() {
        var increaseProgress by rememberSaveable {
            mutableStateOf(0f)
        }

        CircularProgressIndicator(progress = increaseProgress)
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { increaseProgress += 0.1f }) {
                Text(text = "Imcrementar")
            }
            Button(onClick = { increaseProgress -= 0.1f }) {
                Text(text = "Reducir")
            }
        }
    }

    @Composable
    fun MySwitch() {
        var state by rememberSaveable { mutableStateOf(true) }
        Switch(checked = state, onCheckedChange = { state = !state }, enabled = true)
    }

    @Composable
    fun MyTryStatusCheckBox() {
        var state by rememberSaveable { mutableStateOf(ToggleableState.Off) }
        TriStateCheckbox(state = state, onClick = {
            state = when (state) {
                ToggleableState.On -> ToggleableState.Off
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        })
    }

    @Composable
    fun MyCheckBoxText(checkInfo: CheckInfo) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                modifier = Modifier.absoluteOffset((-12).dp, (-12).dp),
                checked = checkInfo.selected,
                onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = checkInfo.title)
        }
    }

    @Preview(showBackground = true, name = "Name preview")
    @Composable
    fun GreetingPreview() {
        CatalogoTheme {
            /*
            Column() {
                var name by rememberSaveable { mutableStateOf("") }
                MyTextField(name) { name = it }
            }
             */
        }
    }

    @Composable
    fun MyRadioButton() {
        Row(Modifier.fillMaxWidth()) {
            RadioButton(
                selected = false, onClick = { }, colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Red,
                    unselectedColor = Color.Blue,
                    disabledSelectedColor = Color.Green
                )
            )

            Text(text = "Hola")
        }
    }

    @Composable
    fun RadioButtonList(name: String, onItemSelected: (String) -> Unit) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Row {
                RadioButton(selected = name == "Cris", onClick = { onItemSelected("Cris") })
                Text(text = "Cris")
            }
            Row {
                RadioButton(selected = name == "Yus", onClick = { onItemSelected("Yus") })
                Text(text = "Yus")
            }
            Row {
                RadioButton(selected = name == "Lia", onClick = { onItemSelected("Lia") })
                Text(text = "Lia")
            }
            Row {
                RadioButton(selected = name == "Nala", onClick = { onItemSelected("Nala") })
                Text(text = "Nala")
            }
        }
    }

    @Composable
    fun ColumnDefaultRadioButtonList(name: String, onItemSelected: (String) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            RadioButtonList(name, onItemSelected)
        }
    }

    @Composable
    fun MyCard() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Hola")
                Text(text = "Hola")
                Text(text = "Hola")
            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun MyDropDownMenu() {

        var selectedText by remember {
            mutableStateOf("Selecciona un item")
        }

        var stateDropDownMenuExpanded by remember {
            mutableStateOf(false)
        }

        val desserts = listOf<String>("Item 1", "Item 2", "Item 3")

        Column(Modifier.padding(20.dp)) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                modifier = Modifier
                    .clickable { stateDropDownMenuExpanded = true }
                    .fillMaxWidth(),
                enabled = false,
                readOnly = true
            )

            DropdownMenu(expanded = stateDropDownMenuExpanded, onDismissRequest = {
                stateDropDownMenuExpanded = false
            }, modifier = Modifier.fillMaxWidth(0.5f)) {
                desserts.forEach { dessert ->
                    DropdownMenuItem(text = { Text(dessert) }, onClick = {
                        stateDropDownMenuExpanded = false
                        selectedText = dessert
                    })
                }
            }
        }
    }

    @Composable
    fun ColumnDefault() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var show by rememberSaveable {
                mutableStateOf(false)
            }
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                TextButton(onClick = { show = true }) {
                    Text(text = "Llamar al modal")
                }
            }

            // MyDialog(show, onDismiss = { show = false }, onConfirm = { show = false })
            // MySimpleCustomDialog(show, onDismiss = { show = false })
            // MyCustomDialog(show, onDismiss = { show = false })
            MyDialogConfirmation(show, onDismiss = { show = false })
        }
    }

    @Composable
    fun AddRowForListDefault(myOptions: List<CheckInfo>) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTryStatusCheckBox()
            myOptions.forEach {
                MyCheckBoxText(it)
            }
        }
    }
}
