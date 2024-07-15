package com.example.calculadoradegorjeta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoradegorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0

        binding.rbOption1.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                percentage = 10
            }
        }

        binding.rbOption2.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                percentage = 15
            }
        }

        binding.rbOption3.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                percentage = 20
            }

        }


        binding.btnClean.setOnClickListener {

            binding.tvResult.text = ""
            binding.tieTotal.setText("")
            binding.tieNumPeople.setText("")
            binding.rbOption1.isChecked = false
            binding.rbOption2.isChecked = false
            binding.rbOption3.isChecked = false
        }


        binding.btnDone.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val npeopleTemp = binding.tieNumPeople.text

            if (totalTableTemp?.isEmpty() == true ||
                npeopleTemp?.isEmpty() == true
            ) {
                Snackbar.make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = npeopleTemp.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                binding.tvResult.text = "Total wit tipos: $totalWithTips"
            }
        }
    }
}