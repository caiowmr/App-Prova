package com.example.appprova

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun EstatisticasScreen(navController: NavController) {
    val valorTotal = Estoque.calcularValorTotalEstoque()
    val quantidadeTotal = Estoque.getProdutos().sumOf { it.quantidadeEmEstoque.toInt() }

    Column {
        Text("Valor Total do Estoque: R$ $valorTotal")
        Text("Quantidade Total de Produtos: $quantidadeTotal")

        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar")
        }
    }
}
