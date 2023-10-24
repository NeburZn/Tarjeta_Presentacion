package com.example.tarjetadepresentacion

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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

fun copyToClipboard(context: Context, text: String, textToast: String?) {
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Texto copiado", text)
    clipboard.setPrimaryClip(clip)


    textToast?.let {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun PresentacionHorizontal(modifier: Modifier = Modifier) {
    val imagen = painterResource(R.drawable.android_logo)
    val fotoMia = painterResource(R.drawable.foto_de_mi)
    val iconoTelefono = painterResource(R.drawable.telefono)
    val phone = stringResource(R.string.telefono)
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_EMAIL, arrayOf(stringResource(R.string.correo))) // recipients
        putExtra(Intent.EXTRA_SUBJECT, "Presentación")
        putExtra(Intent.EXTRA_TEXT, "¿No me das el 10?")
    }
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
                    text = stringResource(R.string.nombre),
                    fontSize = 50.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
                Text(
                    text = stringResource(R.string.estudio),
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
        Row(
            Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(bottom = 40.dp)
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
                    val intentTelefono = Intent(Intent.ACTION_DIAL)
                    intentTelefono.data = Uri.parse(textPhone)
                    startActivity(context, intentTelefono, null)
                },
                Modifier.align(alignment = Alignment.Bottom)
            ) {
                Text(
                    text = phone,
                    color = Color(0, 68, 129),
                    modifier = Modifier
                )
            }
            IconButton(
                onClick = { startActivity(context, intent, null) },
                Modifier.align(
                    alignment = Alignment.CenterVertically
                )
            ) {
                Icon(
                    Icons.Filled.Email,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
            TextButton(
                onClick = {
                    val textToCopy = "rubenarranz04@gmail.com"
                    copyToClipboard(context, textToCopy, "Texto copiado al portapapeles")
                },
            ) {
                Text(
                    text = stringResource(R.string.correo),
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                )
            }

        }
    }
}

@Composable
fun PresentacionVertical() {
    val imagen = painterResource(R.drawable.android_logo)
    val fotoMia = painterResource(R.drawable.foto_de_mi)
    var tamanio = remember{ mutableStateOf(100.dp) }
    var count = remember { mutableStateOf(0) }
    val iconoTelefono = painterResource(R.drawable.telefono)
    val phone = stringResource(R.string.telefono)
    var pinchar: Boolean = false
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_EMAIL, arrayOf("rubenarranz04@gmail.com")) // recipients
        putExtra(Intent.EXTRA_SUBJECT, "Presentación")
        putExtra(Intent.EXTRA_TEXT, "Me merezco un 10 profe")
    }
    Column(
        Modifier
            .background(color = Color.Gray)
            .padding(top = 90.dp, bottom = 80.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
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
                text = stringResource(R.string.nombre),
                fontSize = 50.sp,
                color = Color.White,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
            )
            Text(
                text = stringResource(R.string.estudio),
                color = Color.Green,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
        Box {
            Modifier.align(alignment = Alignment.Center)
            Image(
                painter = fotoMia,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        tamanio.value =
                            if (count.value % 2 == 0) {
                                300.dp
                            } else {
                                100.dp
                            }
                        count.value += 1
                    }
                    .size(tamanio.value)
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
                        .padding(start = 12.dp, end = 12.dp)
                )
                TextButton(
                    onClick = {
                        val textPhone = "tel: $phone"
                        val intentMarcar = Intent(Intent.ACTION_DIAL)
                        intentMarcar.data = Uri.parse(textPhone)
                        startActivity(context, intentMarcar, null)
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
                IconButton(
                    onClick = { startActivity(context, intent, null) },
                    Modifier.align(
                        alignment = Alignment.CenterVertically
                    )
                ) {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
                TextButton(
                    onClick = {
                        val textToCopy = "rubenarranz04@gmail.com"
                        copyToClipboard(context, textToCopy, "Texto copiado al portapapeles")
                    },
                ) {
                    Text(
                        text = stringResource(R.string.correo),
                        color = Color.White,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}


@Composable
fun MiFotoGrande(modifier: Modifier): Float {
    var tamanio: Float = 0.2f
    var grande: Boolean = false
    /*
    Button(
        onClick = {
        },
        modifier = Modifier.fillMaxSize(0.3f)
    ) {
        Image(
            painter = fotoMia,
            contentDescription = "mi foto",
            modifier = Modifier.fillMaxSize(2f)
        )
    }
    */
    return tamanio
}

@Composable
fun Prueba() {
    val phone = "983245897"
    val context = LocalContext.current
    TextButton(
        onClick = {
            val textPhone = "tel: $phone"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(textPhone)
            startActivity(context, intent, null)
        },
    ) {
        Text(
            text = phone,
        )
    }
}


@Composable
fun ProductoFinal() {
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
