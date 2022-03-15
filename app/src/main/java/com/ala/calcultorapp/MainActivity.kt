package com.ala.calcultorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ala.calcultorapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        onClickListener()
    }

    private fun onClickListener() {

        var btnClickValue: String = binding.dataView.text.toString()

        if (btnClickValue == "0") {
            btnClickValue = ""
        }

        binding.apply {
            btnZero.setOnClickListener {
                btnClickValue += "0"
                dataView.setText(btnClickValue)
            }
            btnOne.setOnClickListener {
                btnClickValue += "1"
                dataView.setText(btnClickValue)
            }
            btnTwo.setOnClickListener {
                btnClickValue += "2"
                dataView.setText(btnClickValue)

            }
            btnThree.setOnClickListener {
                btnClickValue += "3"
                dataView.setText(btnClickValue)

            }
            btnFour.setOnClickListener {
                btnClickValue += "4"
                dataView.setText(btnClickValue)
            }

            btnFive.setOnClickListener {
                btnClickValue += "5"
                dataView.setText(btnClickValue)
            }

            btnSix.setOnClickListener {
                btnClickValue += "6"
                dataView.setText(btnClickValue)

            }

            btnSeven.setOnClickListener {
                btnClickValue += "7"
                dataView.setText(btnClickValue)

            }

            btnEight.setOnClickListener {
                btnClickValue += "8"
                dataView.setText(btnClickValue)

            }

            btnNine.setOnClickListener {
                btnClickValue += "9"
                dataView.setText(btnClickValue)

            }

            btnComma.setOnClickListener {
                btnClickValue += ","
                dataView.setText(btnClickValue)
            }

            btnDot.setOnClickListener {
                btnClickValue += "."
                dataView.setText(btnClickValue)
            }
            btnAc.setOnClickListener {
                btnClickValue = ""
                dataView.setText(btnClickValue)

            }
            btnMinus.setOnClickListener {

                if (btnClickValue.isNotEmpty()) {

                    btnClickValue = if (btnClickValue.substring(0,1) == "-") {
                        btnClickValue.replaceFirst("-", "")
                    } else {
                        "-$btnClickValue"
                    }
                    dataView.setText(btnClickValue)
                }
            }

            btnPercent.setOnClickListener {
                btnClickValue += ""
            }

            btnDiv.setOnClickListener {
                btnClickValue += ""
            }

            btnMultiply.setOnClickListener {
                btnClickValue += ""
            }

            btnSub.setOnClickListener {
                btnClickValue += ""
            }

            btnSum.setOnClickListener {
                btnClickValue += ""
            }

            btnEqual.setOnClickListener {
                btnClickValue += ""
            }

        }


    }
}



