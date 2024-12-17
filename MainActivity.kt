package com.example.myapplication
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = SampleDatabaseHelper(this)

        // Insert sample data
        dbHelper.insertData("John Does")
        dbHelper.insertData("Jane Smith")

        // Retrieve data
        val data = dbHelper.getAllData()

        // Display data in the TextView
        val tvData: TextView = findViewById(R.id.tvData)
        tvData.text = data.joinToString(separator = "\n") // Display each name on a new line
    }
}
