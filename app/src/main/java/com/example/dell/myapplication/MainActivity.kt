package com.example.dell.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timer().schedule(3000){
            val listFragment = ArticleListFragment()
            val transaction = getSupportFragmentManager().beginTransaction()
            transaction.replace(R.id.fragment_container, listFragment)
            transaction.commit()
        }
    }
}
