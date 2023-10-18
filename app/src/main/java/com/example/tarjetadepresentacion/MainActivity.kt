package com.example.tarjetadepresentacion

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.tarjetadepresentacion.ui.theme.TarjetaDePresentacionTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaDePresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Caja()
                }
            }
        }
    }
}

@Composable
fun Contenido() {
    Column {

    }
}

@Composable
fun PresentacionHorizontal(modifier: Modifier = Modifier) {
    val imagen = painterResource(R.drawable.android_logo)
    val iconoTelefono = painterResource(R.drawable.telefono)
    val iconoMail = painterResource(R.drawable.mail)
    Row(
        Modifier
            .background(color = Color.Gray)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(0.15f)
                .background(Color(2, 57, 106))
                .border(BorderStroke(2.dp, Color.Black))
        )
        Column {
            Text(
                text = "Rubén Arranz",
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            Text(
                text = "Estudiante de DAM",
                color = Color.Green,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }

    }
}

@Composable
fun PresentacionVertical(modifier: Modifier = Modifier) {
    val imagen = painterResource(R.drawable.android_logo)
    val iconoTelefono = painterResource(R.drawable.telefono)
    val iconoMail = painterResource(R.drawable.mail)
    val uri = "+34 677 38 77 47"
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_DIAL)
    Column (
        Modifier
            .background(color = Color.Gray)
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = imagen,
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .background(Color(2, 57, 106))
                    .align(alignment = Alignment.CenterHorizontally)
                    .border(BorderStroke(2.dp, Color.Black))
            )
            Text(
                text = "Rubén Arranz",
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            )
            Text(
                text = "Estudiante de DAM",
                color = Color.Green,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            Row(
                Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = iconoTelefono,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                )
                TextButton(
                    onClick = {
                        intent.data = Uri.parse(uri)
                        startActivity(context, intent, null)
                    },
                    Modifier.align(alignment = Alignment.CenterVertically)
                ) {
                    Text(
                        text = uri,
                        color = Color(0, 68, 129),
                    )
                }
            }
            Row(
                Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = iconoMail,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 5.dp)
                )
                Text(
                    text = "rubenarranz04@gmail.com",
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
    }
/*
            val uri = "+34 677 38 77 47"
            val context = LocalContext.current
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(uri)
            startActivity(intent)
     */



@Composable
fun Caja() {
    val imagen = painterResource(R.drawable.android_logo)
    BoxWithConstraints(Modifier.fillMaxSize()) {
        if (maxWidth < 500.dp) {
            PresentacionVertical()
        } else {
            PresentacionHorizontal()
        }
    }
}


@Composable
fun Info() {

}

@Preview
@Composable
fun PreviewHorizontal() {
    TarjetaDePresentacionTheme {
        PresentacionHorizontal()
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewVertical() {
    TarjetaDePresentacionTheme {
        Caja()
    }
}
