package com.example.appprova

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListaProdutosScreen(navController: NavController) {
    Column {
        LazyColumn {
            items(Estoque.getProdutos()) { produto ->
                Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(text = "${produto.nomeDoProduto} (${produto.quantidadeEmEstoque} unidades)")
                    Button(onClick = {
                        navController.navigate("detalhes_produto/${produto.nomeDoProduto}")
                    }) {
                        Text("Detalhes")
                    }
                }
            }
        }

        Button(onClick = { navController.navigate("estatisticas") }) {
            Text("Estatísticas")
        }
    }
}
