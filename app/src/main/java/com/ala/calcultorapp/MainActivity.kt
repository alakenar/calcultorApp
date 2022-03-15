package com.ala.calcultorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.ala.calcultorapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun btn_Click(view: View) {

        if (newOperator) {
            binding.dataView.setText("")
        }

        newOperator = false
        var btnSelect = view as Button
        var btnClickValue: String = binding.dataView.text.toString()
        when (btnSelect.id) {
            binding.button17.id -> {
                btnClickValue += "0"
            }
            binding.button5.id -> {
                btnClickValue += "1"
            }
            binding.button6.id -> {
                btnClickValue += "2"
            }
            binding.button7.id -> {
                btnClickValue += "3"
            }
            binding.button9.id -> {
                btnClickValue += "4"
            }
            binding.button10.id -> {
                btnClickValue += "5"
            }
            binding.button11.id -> {
                btnClickValue += "6"
            }
            binding.button13.id -> {
                btnClickValue += "7"
            }
            binding.button14.id -> {
                btnClickValue += "8"
            }
            binding.button15.id -> {
                btnClickValue += "9"
            }
            binding.button18.id -> {
                btnClickValue += ","
            }
            binding.button19.id -> {
                btnClickValue += "."
            }
            binding.button1.id -> {
                btnClickValue = "0"

            }
            binding.button2.id -> {
                btnClickValue = "-" + btnClickValue
            }
        }
        //plain texti gösteriyoruz
        binding.dataView.setText(btnClickValue)

    }

    var operator = "*"
    var oldCount = ""
    var newOperator = true


    fun btn_Operator(view: View) {
        var btn_Select = view as Button
        when (btn_Select.id) {

            binding.button4.id -> {
                operator = "/"
            }
            binding.button8.id -> {
                operator = "*"
            }
            binding.button12.id -> {
                operator = "-"
            }
            binding.button16.id -> {
                operator = "+"
            }
            binding.button20.id -> {
                operator = "="
            }
        }
        oldCount = binding.dataView.text.toString()
        newOperator = true

    }


    fun Equals (view: View) {
        var newCount = binding.dataView.text.toString()
        var result: Double? = null

        when (operator) {
            "/" -> {
                result = oldCount.toDouble() / newCount.toDouble()
            }
            "*" -> {
                result = oldCount.toDouble() * newCount.toDouble()
            }
            "-" -> {
                result = oldCount.toDouble() - newCount.toDouble()
            }
            "+" -> {
                result = oldCount.toDouble() + newCount.toDouble()
            }
        }
        binding.dataView.setText(result.toString())
        newOperator = true

    }

    fun Ac(view: View) {
        binding.dataView.setText("0")
        newOperator = true
    }

    fun Per(view: View) {
        //sayi veri tipini double yaptık , edit textin ilk stringe sonra double cevirdik ve 100 e bolduk
        var count: Double = binding.dataView.text.toString().toDouble() / 100
        binding.dataView.setText(count.toString())
        newOperator = true
    }

}