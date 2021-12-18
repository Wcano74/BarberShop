package com.example.barbershop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.barbershop.databinding.ActivityCitaBinding
import com.example.barbershop.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip
import com.shashank.sony.fancytoastlib.FancyToast
import com.shashank.sony.fancytoastlib.FancyToast.SUCCESS
import nl.bryanderidder.themedtogglebuttongroup.ThemedButton
import java.security.acl.Group

class CitaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCitaBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = "Wilson Cano"


        binding.date.setOnClickListener { showDatePickerDialog() }
        binding.time.setOnClickListener { showTimePickerDialog() }


        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
         val chip =   binding.chipGroup.findViewById<Chip>(checkedId)


            if (chip.equals(binding.nomBarbero.findViewById(checkedId))){
                binding.nomBarbero.setText(nombre)
                FancyToast.makeText(this,"Ha seleccionado a $nombre",FancyToast.LENGTH_LONG,
                    SUCCESS,false).show()
            }else{
                binding.chipGroup.removeView(chip)
            }

        }

        time_grupo()



    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment {onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "timePicker")

    }

    private fun onTimeSelected(time:String){

        binding.time.setText("la Hora es: $time")

    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerDFragment {day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }


    fun onDateSelected(day:Int, month:Int, year:Int ){

        binding.date.setText("La fecha ingresada es: $day/$month/$year")

    }

    fun time_grupo (){

        
        binding.groupTime.setOnSelectListener {
            FancyToast.makeText(this, it.text,FancyToast.LENGTH_LONG,SUCCESS,false).show()
        }



    }


}