package com.archico.tobadestination

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val Destination = intent.getParcelableExtra<Destination>(MainActivity.INTENT_PARCELABLE)

        val imgDestination = findViewById<ImageView>(R.id.img_item_image)
        val nameDestination = findViewById<TextView>(R.id.tv_item_name)
        val descDestination = findViewById<TextView>(R.id.tv_item_desc)

        imgDestination.setImageResource(Destination?.imgDestination!!)
        nameDestination.text = Destination.nameDestination
        descDestination.text = Destination.descDestination

        val btnShare = findViewById<Button>(R.id.action_share)

        btnShare.setOnClickListener {
            shareContent()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun shareContent() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        val nameDestination = findViewById<TextView>(R.id.tv_item_name).text.toString()
        val descDestination = findViewById<TextView>(R.id.tv_item_desc).text.toString()

        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, nameDestination)
        shareIntent.putExtra(Intent.EXTRA_TEXT, descDestination)
        startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
    }
}