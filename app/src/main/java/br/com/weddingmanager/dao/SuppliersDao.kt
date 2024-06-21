package br.com.weddingmanager.dao

import br.com.weddingmanager.model.Supplier

class SuppliersDao {

    fun add(supplier: Supplier){
        suppliers.add(supplier)
    }

    fun list() : List<Supplier> {
        return suppliers.toList()
    }

    companion object {
        private val suppliers = mutableListOf<Supplier>()
    }
}