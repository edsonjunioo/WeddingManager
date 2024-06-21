package br.com.weddingmanager.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.weddingmanager.R
import br.com.weddingmanager.dao.SuppliersDao
import br.com.weddingmanager.model.Supplier
import java.math.BigDecimal

class FormSupplierActivity :
    AppCompatActivity(R.layout.activity_form_supplier) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val saveButton = findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            val fieldName = findViewById<EditText>(R.id.name)
            val name = fieldName.text.toString()
            val fieldType = findViewById<EditText>(R.id.type)
            val type = fieldType.text.toString()
            val fieldAmount = findViewById<EditText>(R.id.amount)
            val amountText = fieldAmount.text.toString()
            val amount = if(amountText.isBlank()){
                BigDecimal.ZERO
            } else {
                BigDecimal(amountText)
            }

            val newSupplier = Supplier(
                name = name,
                type = type,
                amount = amount
            )

            Log.i("FormSupplier", "onCreate: $newSupplier")
            val dao = SuppliersDao()
            dao.add(newSupplier)
            Log.i("FormSupplier", "onCreate: ${dao.list()}")
            finish()


        }

    }
}