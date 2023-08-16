package com.compose.catalogo.ui

import androidx.compose.ui.text.font.FontFamily
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.compose.catalogo.ui.theme.CatalogoTheme

class ComponentsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContent {
            CatalogoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyText()
                }
            }
        }
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

    @Preview(showBackground = true, name = "Name preview")
    @Composable
    fun GreetingPreview() {
        CatalogoTheme {
            MyText()
        }
    }
}
