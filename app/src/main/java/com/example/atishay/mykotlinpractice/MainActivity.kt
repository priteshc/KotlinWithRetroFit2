package com.example.atishay.mykotlinpractice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*  kot.text = "pritesh"

          kot.setOnClickListener {

              Toast.makeText(this, kot.text.toString(), Toast.LENGTH_LONG).show()

          }
  */

        username.setText("Hidden view")

        // textView.visibility = View.INVISIBLE

        login.setOnClickListener() {

            if (!username.text.toString().isEmpty() && !password.text.toString().isEmpty()) {

                Toast.makeText(this, username.text.toString() + " " + password.text.toString(), Toast.LENGTH_LONG).show()

                startActivity(Intent(this,SecondActivity::class.java))

            } else {

                Toast.makeText(this, "fill all field", Toast.LENGTH_LONG).show()

            }

        }


        val items = listOf("apple", "banana", "kiwifruit")
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }


        val list = listOf("a", "b", "c")

        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range too")
        }




        items.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println(it) }


    }

   // fun String(x: String )



}
