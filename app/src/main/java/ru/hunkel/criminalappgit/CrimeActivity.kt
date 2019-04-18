package ru.hunkel.criminalappgit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager

class CrimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        var fragment = fm.findFragmentById(R.id.fragment_container)

        if(fragment==null){
            fragment = CrimeFragment()
            fm.beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }

    }
}
