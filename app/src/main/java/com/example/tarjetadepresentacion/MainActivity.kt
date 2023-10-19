package com.example.tarjetadepresentacion

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
                    ProductoFinal()
                }
            }
        }
    }
}

@Composable
fun PresentacionHorizontal(modifier: Modifier = Modifier) {
    val imagen = painterResource(R.drawable.android_logo)
    val fotoMia = painterResource(R.drawable.foto_de_mi)
    val iconoTelefono = painterResource(R.drawable.telefono)
    val iconoMail = painterResource(R.drawable.mail)
    val phone = "+34 634 50 62 29"
    val context = LocalContext.current
    Column(
        Modifier
            .background(color = Color.Gray)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
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
                        .align(alignment = Alignment.End)
                )
            }
            Image(
                painter = fotoMia,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.4f)

            )
        }
        Row (
            Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 40.dp)
        ){
            Image(
                painter = iconoTelefono,
                contentDescription = null,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
            )
            TextButton(
                onClick = {
                    val textPhone = "tel: $phone"
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse(textPhone)
                    startActivity(context, intent, null)
                },
                Modifier.align(alignment = Alignment.Bottom)
            ) {
                Text(
                    text = phone,
                    color = Color(0, 68, 129),
                    modifier = Modifier
                )
            }
            Image(
                painter = iconoMail,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 12.dp, start = 16.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
            Text(
                text = "rubenarranz04@gmail.com",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
            )

        }
    }
}

@Composable
fun PresentacionVertical(modifier: Modifier = Modifier) {
    val imagen = painterResource(R.drawable.android_logo)
    val iconoTelefono = painterResource(R.drawable.telefono)
    val iconoMail = painterResource(R.drawable.mail)
    val phone = "+34 634 50 62 29"
    val context = LocalContext.current
    Column(
        Modifier
            .background(color = Color.Gray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                Modifier
                    .align(alignment = Alignment.Start)
            ) {
                Image(
                    painter = iconoTelefono,
                    contentDescription = null,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                )
                TextButton(
                    onClick = {
                        val textPhone = "tel: $phone"
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse(textPhone)
                        startActivity(context, intent, null)
                    },
                    Modifier.align(alignment = Alignment.CenterVertically)
                ) {
                    Text(
                        text = phone,
                        color = Color(0, 68, 129),
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
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
                        .padding(end = 12.dp)
                )
                Text(
                    text = "rubenarranz04@gmail.com",
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }

}

@Composable
fun ProductoFinal() {
    val imagen = painterResource(R.drawable.android_logo)
    BoxWithConstraints(Modifier.fillMaxSize()) {
        if (maxWidth < 500.dp) {
            PresentacionVertical()
        } else {
            PresentacionHorizontal()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewVertical() {
    TarjetaDePresentacionTheme {
        PresentacionVertical()
    }
}
