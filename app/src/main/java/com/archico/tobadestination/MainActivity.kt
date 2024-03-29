package com.archico.tobadestination

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val destinationNames = resources.getStringArray(R.array.destination_names)
        val destinationDescriptions = resources.getStringArray(R.array.destination_descriptions)
        val destinationImages = resources.getStringArray(R.array.destination_images)

        val destinationList = mutableListOf<Destination>()
        supportActionBar?.setTitle("Toba Destination")

        for (i in destinationNames.indices) {
            destinationList.add(
                Destination(
                    resources.getIdentifier(destinationImages[i], "drawable", packageName),
                    destinationNames[i],
                    destinationDescriptions[i]
                )
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_destination)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = DestAdapter(this, destinationList){
            val intent = Intent (this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        val btnAbout = findViewById<ImageView>(R.id.iv_about)

        btnAbout.setOnClickListener {
            showPopupMenu(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu_main)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.iv_about -> {
                    Log.d("MainActivity", "About selected")
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
}