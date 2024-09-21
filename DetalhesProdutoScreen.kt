package com.example.appprova

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetalhesProdutoScreen(navController: NavController, produtoNome: String) {
    val produto = Estoque.getProdutos().find { it.nomeDoProduto == produtoNome }

    produto?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color(0xFFEFEFEF))
        ) {
            Text("Detalhes do Produto", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(bottom = 16.dp))
            Text("Nome: ${it.nomeDoProduto}", style = MaterialTheme.typography.bodyLarge)
            Text("Categoria: ${it.categoria}", style = MaterialTheme.typography.bodyLarge)
            Text("Preço: R$ ${it.preco}", style = MaterialTheme.typography.bodyLarge)
            Text("Quantidade em Estoque: ${it.quantidadeEmEstoque}", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Voltar")
            }
        }
    }
}

