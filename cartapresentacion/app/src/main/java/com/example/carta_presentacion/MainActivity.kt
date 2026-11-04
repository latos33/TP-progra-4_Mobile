package com.example.carta_presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xF4F4F4) // Color verde claro característico de este codelab
            ) {
                BusinessCardScreen()
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Sección central: Logo, Nombre y Título
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter= painterResource(R.drawable._19253),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(120.dp),
                alpha = 1.0F
            )


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Nombre",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF222831)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Android Developer in Training",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF39558C)
            )
        }

        // Sección inferior: Datos de contacto con tus vectores locales
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ContactRow(iconRes = R.drawable.telefono, contactText = "+54 3431111111")
            ContactRow(iconRes = R.drawable.usuario, contactText = "@Usuario33")
            ContactRow(iconRes = R.drawable.correo, contactText = "esto_es_un_correo@email.com")
        }
    }
}

@Composable
fun ContactRow(iconRes: Int, contactText: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Usamos Image con painterResource para invocar los vectores que acabamos de crear
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = contactText,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xF4F4F4)
    ) {
        BusinessCardScreen()
    }
}