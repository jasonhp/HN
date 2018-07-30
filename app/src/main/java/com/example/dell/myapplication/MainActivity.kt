package com.example.dell.myapplication

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dell.myapplication.dummy.DummyContent
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity(), ArticleListFragment.OnListFragmentInteractionListener, ArticleReaderFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timer().schedule(3000){
            val listFragment = ArticleListFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, listFragment)
            transaction.commit()

//            listFragment.setOnListFragmentInteractionListener(object: ArticleListFragment.OnListFragmentInteractionListener {
//                override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
//                    val readerFragment = ArticleReaderFragment()
//                    val transaction = supportFragmentManager.beginTransaction()
//                    transaction.replace(R.id.fragment_container, readerFragment)
//                    transaction.commit()
//                }
//            })
        }
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        val readerFragment = ArticleReaderFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, readerFragment)
        transaction.commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        print(uri)
    }
}
