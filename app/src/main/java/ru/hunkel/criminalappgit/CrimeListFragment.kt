package ru.hunkel.criminalappgit

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CrimeListFragment : Fragment() {
    private var mCrimeRecyclerView: RecyclerView? = null
    private var mAdapter: CrimeAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_crime_list,container,false)
        mCrimeRecyclerView = view.findViewById(R.id.crime_recycler_view)
        mCrimeRecyclerView?.layoutManager = LinearLayoutManager(activity)
        updateUI()
        return view
    }
    private fun updateUI(){
        //TODO(ERROR)
        val crimeLab = CrimeLab.get(activity!!)
        val crimes = crimeLab?.getCrimes()
        mAdapter = CrimeAdapter(crimes!!)
        mCrimeRecyclerView?.adapter = mAdapter
    }
    inner class CrimeHolder(inflater: LayoutInflater,parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_crime,parent,false)),
        View.OnClickListener{

        override fun onClick(v: View?) {
            val intent = CrimeActivity.newIntent(activity!!,mCrime.mId)
            startActivity(intent)
        }

        private var mTitleTextView: TextView? = null
        private var mDateTextView: TextView? = null
        private var mSolvedImageView: ImageView? = null

        private var mCrime = Crime()
        init {
            //TODO(ERROR)
            mTitleTextView = itemView.findViewById(R.id.crime_title)
            //TODO(ERROR)
            mDateTextView = itemView.findViewById(R.id.crime_date)
            //TODO(ERROR)
            mSolvedImageView = itemView.findViewById(R.id.crime_solved)

            itemView.setOnClickListener(this)
        }
        fun bind(crime: Crime){
            mCrime = crime
            mTitleTextView?.text = mCrime.mTitle
            mDateTextView?.text = mCrime.mDate
            mSolvedImageView?.visibility = if(crime.mSolved) View.VISIBLE else View.GONE
//            mSolvedImageView?.visibility = if(mCrime.mSolved) View.VISIBLE else false
        }

    }
    inner class CrimeAdapter(private var mCrimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>(){

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CrimeHolder {
            val inflater = LayoutInflater.from(activity)
            return CrimeHolder(inflater,p0)
        }

        override fun getItemCount(): Int {
            return mCrimes.size
        }

        override fun onBindViewHolder(p0: CrimeHolder, p1: Int) {
            var crime = mCrimes[p1]
            p0.bind(crime)
        }

    }
}