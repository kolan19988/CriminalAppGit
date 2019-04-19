package ru.hunkel.criminalappgit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import java.util.*

class CrimePagerActivity : AppCompatActivity() {


    companion object{
        const val  EXTRA_CRIME_ID = "crime_id"

        fun newIntent(packageContext: Context,crimeId: UUID): Intent {
            val intent = Intent(packageContext,CrimePagerActivity::class.java)
            intent.putExtra(EXTRA_CRIME_ID,crimeId)
            return intent
        }
    }
    private var mViewPager: ViewPager? = null
    private var mCrimes: List<Crime> = emptyList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime_pager)

        val crimeId = intent.getSerializableExtra(EXTRA_CRIME_ID) as UUID
        Toast.makeText(this,crimeId.toString(),Toast.LENGTH_SHORT).show()

        mViewPager = findViewById(R.id.crime_view_pager)
        //TODO(ERROR)
        mCrimes = CrimeLab.get(this)!!.getCrimes()
        val fm = supportFragmentManager
        mViewPager?.adapter = PagerAdapter(fm)

        for((pos, c) in mCrimes.withIndex()){
            if(c.mId == crimeId){
                mViewPager?.currentItem = pos
            }
        }



        }

    inner class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){
        override fun getItem(p0: Int): Fragment {
            var crime = mCrimes[p0]
            return CrimeFragment.newInstance(crime.mId)
        }

        override fun getCount(): Int {
            return mCrimes.size
        }


    }
    }

