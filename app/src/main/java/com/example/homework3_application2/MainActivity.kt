package com.example.homework3_application2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Declaring Exit's Elements
        val submitButton = findViewById<Button>(R.id.submit_button)
        val nameEditText = findViewById<EditText>(R.id.editTextTextPersonName)
        val ageEditText = findViewById<EditText>(R.id.age_editTextNumber)
        val genderRadioGroup = findViewById<RadioGroup>(R.id.gender_radioGroup)
        val maleRadioButton = findViewById<RadioButton>(R.id.male_radioButton)
        val femaleRadioButton = findViewById<RadioButton>(R.id.female_radioButton)
        val satisfiedSeekBar = findViewById<SeekBar>(R.id.satisfied_seekBar)
        val graduateSwitch = findViewById<SwitchCompat>(R.id.graduate_switch)
        val countriesSpinner = findViewById<Spinner>(R.id.countries_spinner)
        // Store Values
        val nameValue = nameEditText.text
        val ageValue = ageEditText.text
        var graduateValue: String
        var genderValue: String
        var countryValue: String
        var satisfiedSeekBarValue: Int
        graduateValue = "Default"
        genderValue = "Default"
        countryValue = "Default"
        satisfiedSeekBarValue = satisfiedSeekBar.progress
        //Country List Spinner
        countriesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getItemAtPosition(position) == "Choose country") {
                    //Do noting
                } else {
                    countryValue = parent?.getItemAtPosition(position).toString()
                    Toast.makeText(
                        this@MainActivity,
                        "You Selected $countryValue",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        // Graduate Switch Button
        graduateSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                buttonView.setBackgroundColor(Color.GREEN)
                graduateValue = "Graduate"
                buttonView.text = getString(R.string.graduate_text)
                graduateValue = buttonView.text.toString()
                Toast.makeText(
                    this@MainActivity,
                    "The Answer is $graduateValue",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                buttonView.setBackgroundColor(Color.RED)
                buttonView.text = getString(R.string.undergraduate_text)
                graduateValue = buttonView.text.toString()
                Toast.makeText(
                    this@MainActivity,
                    "The Answer is $graduateValue",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        // seekBar value
        satisfiedSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                satisfiedSeekBarValue = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
/*
                TODO("Not yet implemented")
*/
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(
                    this@MainActivity,
                    "SeekBar Value :${satisfiedSeekBarValue}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        // Radio Group
        genderRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == maleRadioButton.id) {
                genderValue = maleRadioButton.text.toString()
                Toast.makeText(
                    this@MainActivity,
                    "Gender Value :${genderValue}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                genderValue = femaleRadioButton.text.toString()
                Toast.makeText(
                    this@MainActivity,
                    "Gender Value :${genderValue}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Submit Button
        submitButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                this@MainActivity,
                "Name : $nameValue \n Age :$ageValue \n Gender :$genderValue \n Country :$countryValue \n Graduation Status :$graduateValue \n Android Course satisfaction :$satisfiedSeekBarValue",
                Toast.LENGTH_LONG
            ).show()
        })
    }
}