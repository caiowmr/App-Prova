package com.example.appprova


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CadastroProdutoScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var quantidade by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome do Produto") })
        TextField(value = categoria, onValueChange = { categoria = it }, label = { Text("Categoria") })
        TextField(value = preco, onValueChange = { preco = it }, label = { Text("Preço") })
        TextField(value = quantidade, onValueChange = { quantidade = it }, label = { Text("Quantidade em Estoque") })

        Button(onClick = {
            if (nome.isEmpty() || categoria.isEmpty() || preco.isEmpty() || quantidade.isEmpty()) {
                Toast.makeText(context, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show()
            } else if (quantidade.toInt() < 1 || preco.toDouble() < 0) {
                Toast.makeText(context, "Quantidade deve ser maior que 0 e preço não pode ser negativo", Toast.LENGTH_SHORT).show()
            } else {
                Estoque.adicionarProduto(Produto(nome, categoria, preco, quantidade))
                navController.navigate("lista_produtos")
            }
        }) {
            Text("Cadastrar")
        }
    }
}
