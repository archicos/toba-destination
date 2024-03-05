package com.archico.tobadestination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setTitle("About")

        setContentView(R.layout.activity_about)

        val name = "Archico Darius Simpar Sembiring"
        val email = "archicosemb@gmail.com"

        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvEmail = findViewById<TextView>(R.id.tv_email)

        tvName.text = name
        tvEmail.text = email
    }
}