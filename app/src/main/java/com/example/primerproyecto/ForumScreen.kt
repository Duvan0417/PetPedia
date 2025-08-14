package com.example.primerproyecto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForoScreen(navController: NavHostController? = null) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.foro_titulo)) },
                navigationIcon = {
                    if (navController != null) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(R.string.volver),
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6C28D0),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color(0xFFF5F5F5))
                .fillMaxSize()
        ) {
            item { PostDestacado() }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.LightGray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = stringResource(R.string.comunidades),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp))
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(comunidadesEjemplo) { comunidad ->
                CardComunidad(
                    comunidad = comunidad,
                    onUnirseClick = { id -> /* Lógica para unirse */ }
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.LightGray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = stringResource(R.string.tendencias),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp))
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(tendenciasEjemplo) { tendencia ->
                CardTendencia(tendencia = tendencia)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.LightGray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = stringResource(R.string.usuarios_activos),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp))
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(usuariosEjemplo) { usuario ->
                CardUsuario(usuario = usuario)
            }
        }
    }
}

@Composable
fun PostDestacado(
    usuario: String = "María González",
    fecha: String = "05 May 2025 - 10:45 AM",
    titulo: String = "Mi perro no quiere comer: Consejos que funcionaron para mí",
    contenido: String = "Después de semanas de preocupación...",
    imagen: Int = R.drawable.post_image,
    likes: Int = 24,
    comentarios: Int = 1,
    vistas: Int = 142
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_maria),
                    contentDescription = stringResource(R.string.avatar_usuario, usuario),
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(usuario, fontWeight = FontWeight.Bold)
                    Text(fecha, fontSize = 12.sp, color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = contenido, modifier = Modifier.padding(top = 8.dp)))

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = imagen),
                contentDescription = stringResource(R.string.imagen_post),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = stringResource(R.string.likes),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("$likes")
                }
                Text("$comentarios ${stringResource(R.string.comentario)}")
                Text("$vistas ${stringResource(R.string.vistas)}")
            }
        }
    }
}

@Composable
fun CardComunidad(
    comunidad: Comunidad,
    onUnirseClick: (Int) -> Unit
) {
    var estaUnido by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { /* Navegar a comunidad */ },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = comunidad.imagen),
                    contentDescription = stringResource(R.string.imagen_comunidad, comunidad.nombre),
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(comunidad.nombre, fontWeight = FontWeight.Bold)
                    Text("${comunidad.porcentaje}% ${stringResource(R.string.miembros)}",
                        color = Color.Gray)
                }
            }

            Button(
                onClick = {
                    estaUnido = !estaUnido
                    onUnirseClick(comunidad.id)
                },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (estaUnido) Color.Gray else Color(0xFF6C28D0)
                )
            ) {
                Text(
                    if (estaUnido) stringResource(R.string.unido)
                    else stringResource(R.string.unirse),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CardTendencia(tendencia: Tendencia) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { /* Navegar a tendencia */ },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "#${tendencia.nombre}",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6C28D0)
            )
            Text("${tendencia.publicaciones} ${stringResource(R.string.publicaciones)}",
                color = Color.Gray)
        }
    }
}

@Composable
fun CardUsuario(usuario: Usuario) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { /* Ver perfil */ },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = usuario.avatar),
                contentDescription = stringResource(R.string.avatar_usuario, usuario.nombre),
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(usuario.nombre, fontWeight = FontWeight.Bold)
                Text(usuario.tipo, color = Color.Gray)
            }
        }
    }
}

// Modelos de datos (mejor en un archivo aparte DataModels.kt)
data class Comunidad(
    val id: Int,
    val nombre: String,
    val porcentaje: Double,
    val imagen: Int = R.drawable.ic_default_community
)

data class Tendencia(
    val id: Int,
    val nombre: String,
    val publicaciones: Int
)

data class Usuario(
    val id: Int,
    val nombre: String,
    val tipo: String,
    val avatar: Int
)

// Datos de ejemplo (mejor en un repositorio)
val comunidadesEjemplo = listOf(
    Comunidad(1, "Amantes de los Perros", 5.2, R.drawable.comunidad_perros),
    Comunidad(2, "Gatos y Felinos", 4.8, R.drawable.comunidad_gatos)
)

val tendenciasEjemplo = listOf(
    Tendencia(1, "AdopciónResponsable", 620),
    Tendencia(2, "AlimentaciónNatural", 388)
)

val usuariosEjemplo = listOf(
    Usuario(1, "Laura Torres", "Usuario", R.drawable.avatar_laura),
    Usuario(2, "Carlos Méndez", "Usuario", R.drawable.avatar_carlos),
    Usuario(3, "Dr. Pérez", "Veterinario", R.drawable.avatar_veterinario)
)