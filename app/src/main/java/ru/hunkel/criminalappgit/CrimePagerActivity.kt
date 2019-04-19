package ru.hunkel.criminalappgit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

class CrimePagerActivity : AppCompatActivity() {

    private var mViewPager: ViewPager? = null
    private var mCrimes: List<Crime> = emptyList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_pager)

        mViewPager = findViewById(R.id.crime_view_pager)
        val fm = supportFragmentManager
        mViewPager?.adapter = viewPagerAdaper(fm)

        }

    inner class viewPagerAdaper(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
        override fun getItem(p0: Int): Fragment {
            var crime = mCrimes[p0]
            return CrimeFragment.newInstance(crime.mId)
        }

        override fun getCount(): Int {
            return mCrimes.size
        }

    }
    }

