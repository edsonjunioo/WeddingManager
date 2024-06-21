package br.com.weddingmanager.model

import java.math.BigDecimal

data class Supplier(
    val name: String,
    val type: String,
    val amount: BigDecimal
)
