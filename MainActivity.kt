package com.example.appprova

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appprova.ui.theme.AppProvaTheme
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main_menu") {
                composable("main_menu") { MainMenuScreen(navController) }
                composable("cadastro_produto") { CadastroProdutoScreen(navController) }
                composable("lista_produtos") { ListaProdutosScreen(navController) }
                composable("detalhes_produto/{produtoNome}") { backStackEntry ->
                    DetalhesProdutoScreen(
                        navController,
                        backStackEntry.arguments?.getString("produtoNome") ?: ""
                    )
                }
                composable("estatisticas") { EstatisticasScreen(navController) }
            }
        }
    }
}







@Preview(showBackground = true)
@Composable
fun GreetingPreview() {



}