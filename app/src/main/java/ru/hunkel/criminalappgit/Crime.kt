package ru.hunkel.criminalappgit

import java.text.DateFormat
import java.util.*

class Crime {
    val mId = UUID.randomUUID()
    var mTitle = ""
    private val dateManager = DateFormat.getDateInstance()
    var mDate = dateManager.format(Date())
}