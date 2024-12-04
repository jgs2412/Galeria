package com.example.galeriaimagenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.galeriaimagenes.ui.theme.GaleriaImagenesTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaleriaImagenesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    galeria(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class ImageItem(val id: Int, val imageRes: Int, val title: String)

@Composable
fun galeria(modifier: Modifier) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val images = listOf(
        ImageItem(1, android.R.drawable.ic_menu_camera, "Cámara"),
        ImageItem(2, android.R.drawable.ic_menu_gallery, "Galería"),
        ImageItem(3, android.R.drawable.ic_menu_mapmode, "Mapa"),
        ImageItem(4, android.R.drawable.ic_menu_call, "Llamada"),
        ImageItem(5, android.R.drawable.ic_menu_compass, "Brújula"),
        ImageItem(6, android.R.drawable.ic_menu_agenda, "Agenda"),
        ImageItem(7, android.R.drawable.ic_menu_camera, "report"),
        ImageItem(8, android.R.drawable.ic_menu_camera, "cuadrado"),
        ImageItem(9, android.R.drawable.ic_menu_camera, "Flechaca"),
        ImageItem(10, android.R.drawable.ic_menu_camera, "Flecha"),
        ImageItem(11, android.R.drawable.ic_menu_camera, "Menos"),
        ImageItem(12, android.R.drawable.ic_menu_camera, "Mas"),
        ImageItem(13, android.R.drawable.ic_menu_camera, "editar"),
        ImageItem(14, android.R.drawable.ic_menu_camera, "borrar"),
        ImageItem(15, android.R.drawable.ic_menu_camera, "Menu dia"),
        ImageItem(16, android.R.drawable.ic_menu_camera, "Llamada entrante"),
        ImageItem(17, android.R.drawable.ic_menu_camera, "Cuadrado especial"),
        ImageItem(18, android.R.drawable.ic_menu_camera, "Ocupado")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(images.chunked(2)) { rowImages ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowImages.forEach { imageItem ->
                    Column(
                        modifier = Modifier
                            .weight(1f),

                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = imageItem.imageRes),
                            contentDescription = imageItem.title,
                            modifier = Modifier
                                .size(120.dp)
                                .padding(8.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = imageItem.title,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}
