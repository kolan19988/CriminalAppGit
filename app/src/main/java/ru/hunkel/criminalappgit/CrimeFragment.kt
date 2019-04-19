package ru.hunkel.criminalappgit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import java.util.*

class CrimeFragment : Fragment() {
    companion object{
        const val ARG_CRIME_ID = "crime_id"

        fun newInstance(crimeId: UUID):CrimeFragment{
            val args = Bundle()
            args.putSerializable(ARG_CRIME_ID,crimeId)

            val fragment = CrimeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    //TODO(ERROR)
    private var mCrime: Crime = Crime()
    //TODO(ERROR)
    private var mTitleField: EditText? = null
    //TODO(ERROR)
    private var mDateButton: Button? = null
    //TODO(ERROR)
    private var mSolvedCheckBox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val crimeId = arguments?.getSerializable(ARG_CRIME_ID) as UUID
        mCrime = CrimeLab.get(activity!!)!!.getCrimeById(crimeId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_crime,container,false)
        //init
        mTitleField = v.findViewById(R.id.crime_title)
        mDateButton = v.findViewById(R.id.crime_date)
        mSolvedCheckBox = v.findViewById(R.id.crime_solved)

        //set up
        mTitleField?.setText(mCrime.mTitle)
        mSolvedCheckBox?.isChecked = mCrime.mSolved
        mDateButton?.text = mCrime.mDate
        mDateButton?.isEnabled = false

        //listeners

        mSolvedCheckBox?.setOnCheckedChangeListener { _, isChecked ->
            mCrime.mSolved = isChecked
        }
        mTitleField?.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mTitleField?.setText(s)
            }
        })
        return v
    }
}