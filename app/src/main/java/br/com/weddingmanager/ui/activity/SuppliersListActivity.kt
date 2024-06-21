package br.com.weddingmanager.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.weddingmanager.R
import br.com.weddingmanager.dao.SuppliersDao
import br.com.weddingmanager.ui.recyclerview.adapter.ListSuppliersAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SuppliersListActivity : AppCompatActivity(R.layout.activity_main) {

    private val dao = SuppliersDao()

    private val adapter = ListSuppliersAdapter(context = this, suppliers = dao.list())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerViewConfiguration()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.list())
        fabConfiguration()
    }

    private fun fabConfiguration() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormSupplierActivity::class.java)
            startActivity(intent)
        }
    }

    private fun recyclerViewConfiguration() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }


}