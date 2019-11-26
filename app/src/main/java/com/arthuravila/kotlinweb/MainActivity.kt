package com.arthuravila.kotlinweb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var arrayList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter.createFromResource(this,
                R.array.estados, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        arrayList = resources.getStringArray(R.array.links)
    }

    fun getValues(view: View) {
        Toast.makeText(this, "Aguarde...", Toast.LENGTH_LONG).show()
        val intent = Intent(this@MainActivity, WebViewActivity::class.java)
        intent.putExtra("url", arrayList[spinner.selectedItemPosition])
        startActivity(intent)
    }
}
