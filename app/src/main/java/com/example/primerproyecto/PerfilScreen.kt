package com.example.primerproyecto

// Ruta sugerida: app/src/main/java/com/example/primerproyecto/PerfilScreen.kt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PerfilScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto de perfil
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Foto de perfil",
                tint = Color.Gray,
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Nombre del Usuario",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "usuario@email.com",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Información adicional
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Teléfono: 300 123 4567", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Dirección: Calle 123 #45-67", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Miembro desde: Enero 2024", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón para editar perfil
        Button(
            onClick = { /* Acción para editar */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C63FF)),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Icon(Icons.Default.Edit, contentDescription = "Editar", tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Editar Perfil", color = Color.White)
        }
    }
}
