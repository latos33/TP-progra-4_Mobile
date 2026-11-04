package com.example.felibirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.felibirthday.ui.theme.FeliBirthdayTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FeliBirthdayTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                                    color = MaterialTheme.colorScheme.inversePrimary) {

                }
                GreetingImage(message = "Feli birthday Ivan", from = "De Bruno")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    FeliBirthdayTheme() {
        GreetingImage("Feli birthday Ivan", "De Bruno")

    }
}
@Composable
fun GreetingText(message: String,from: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier.padding(8.dp)) {


        Text(
            text = message,
            fontSize = 80.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            color = androidx.compose.ui.graphics.Color.Blue
        )
        Text(
            text = from,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
                .align(alignment = Alignment.End),
            color = androidx.compose.ui.graphics.Color.Blue
        )
    }
}
    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.images)
        Box(modifier) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize(),      // Obliga a la imagen a llenar
                alpha = 1.0F
            )
            GreetingText(message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
            )

        }
    }

