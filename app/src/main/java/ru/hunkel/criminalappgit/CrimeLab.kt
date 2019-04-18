package ru.hunkel.criminalappgit

import android.content.Context
import java.util.*

class CrimeLab private constructor(context: Context){
    companion object{
        private var sCrimeLab: CrimeLab? = null

        fun get(context: Context): CrimeLab? {
            if(sCrimeLab == null){

                sCrimeLab = CrimeLab(context)

            }
            return sCrimeLab
        }
    }

    private fun testData(){
        for(i in 1..100){
            var c = Crime()
            c.mTitle = "Crime #$i"
            c.mSolved = (i%2==0)
            mCrimes.add(c)
        }
    }
    private var mCrimes: MutableList<Crime> = mutableListOf()

    fun getCrimes() : List<Crime>{
        testData()
        return mCrimes
    }
    fun getCrimeById(id: UUID):Crime{
        var crime = Crime()
        for (c in mCrimes){
            if(id == c.mId){
                crime = c
                break
            }
        }
        return crime
    }
}