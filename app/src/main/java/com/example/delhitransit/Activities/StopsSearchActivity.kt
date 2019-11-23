package com.example.delhitransit.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StopsSearchActivity : AppCompatActivity() {

    private val LOG_TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(android.R.id.content, StopsMapFragment(this))
        transaction.commit()

    }

}
