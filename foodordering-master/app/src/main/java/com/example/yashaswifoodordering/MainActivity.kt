package com.example.yashaswifoodordering

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuListView: ListView = findViewById(R.id.menuListView)
        val items = arrayOf("Item 1", "Item 2", "Item 3") // Replace with your menu items
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        menuListView.adapter = adapter

        val orderButton: Button = findViewById(R.id.orderButton)
        orderButton.setOnClickListener {
            val intent = Intent(this, BillActivity::class.java)
            intent.putExtra("bill", calculateBill()) // Pass the bill value to the next activity
            startActivity(intent)
        }
    }

    private fun calculateBill(): Double {
        // Replace this with your bill calculation logic
        return 10.0
    }
}

class BillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        val billTextView: TextView = findViewById(R.id.billTextView)
        val bill = intent.getDoubleExtra("bill", 0.0) // Retrieve the bill value from intent
        billTextView.text = "Your bill is $bill"
    }
}
