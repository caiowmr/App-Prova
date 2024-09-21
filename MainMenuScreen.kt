package com.example.appprova

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainMenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFEFEFEF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bem vindo! \nSelecione uma opção:", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 16.dp))

        Button(onClick = { navController.navigate("cadastro_produto") }, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Text("Adicionar Produto")
        }

        Button(onClick = { navController.navigate("lista_produtos") }, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Text("Ver Produtos")
        }

        Button(onClick = { navController.navigate("estatisticas") }, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Text("Estatísticas")
        }
    }
}

