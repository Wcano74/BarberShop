package com.example.barbershop

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.Month
import java.util.*

class DatePickerDFragment (val listener: (day:Int, month:Int, year:Int)-> Unit): DialogFragment(),
    DatePickerDialog.OnDateSetListener {

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
 listener(dayOfMonth, month+1, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c: Calendar = Calendar.getInstance()
        val day:Int = c.get((Calendar.DAY_OF_MONTH))
        val month:Int = c.get((Calendar.MONTH))
        val year:Int = c.get((Calendar.YEAR))
        val picker = DatePickerDialog(activity as Context, this, year, month, day)
        picker.datePicker.minDate = c.timeInMillis
        return picker

    }

}