package com.example.appprova

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetalhesProdutoScreen(navController: NavController, produtoNome: String) {
    val produto = Estoque.getProdutos().find { it.nomeDoProduto == produtoNome }

    produto?.let {
        Column {
            Text("Nome: ${it.nomeDoProduto}")
            Text("Categoria: ${it.categoria}")
            Text("Preço: ${it.preco}")
            Text("Quantidade em Estoque: ${it.quantidadeEmEstoque}")

            Button(onClick = { navController.popBackStack() }) {
                Text("Voltar")
            }
        }
    }
}
