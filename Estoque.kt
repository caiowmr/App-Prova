package com.example.appprova


class Estoque {
    companion object {
        private val produtos = mutableListOf<Produto>()

        fun adicionarProduto(produto: Produto) {
            produtos.add(produto)
        }

        fun calcularValorTotalEstoque(): Double {
            return produtos.sumOf { it.preco.toDouble() * it.quantidadeEmEstoque.toInt() }
        }

        fun getProdutos(): List<Produto> {
            return produtos
        }
    }
}
