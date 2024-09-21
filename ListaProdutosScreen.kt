package com.example.appprova

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ListaProdutosScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color(0xFFEFEFEF))) {

        Text("Lista de Produtos", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn {
            items(Estoque.getProdutos()) { produto ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.White)
                        .padding(16.dp)
                        .shadow(1.dp)
                ) {
                    Text(text = "${produto.nomeDoProduto} (${produto.quantidadeEmEstoque} unidades)", modifier = Modifier.weight(1f))
                    Button(onClick = {
                        navController.navigate("detalhes_produto/${produto.nomeDoProduto}")
                    }) {
                        Text("Detalhes")
                    }
                }
            }
        }
    }
}

