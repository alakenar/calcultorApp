package com.ala.calcultorapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ala.calcultorapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
lateinit var btnClickValue: String
var resultText: Double = 0.0
var tempValue = ""
var isFirstSum = true
var isFirstSub = true
var isFirstMultiply = true
var isFirstDiv = true
var isFirstPercent = true
var newValue = ""
var subClick = false
var sumClick = false
var multiplyClick = false
var divClick = false
var percentClick = false
var commaClick=false
var isFirstMinus= true

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        onClickListener()
    }

    @SuppressLint("SetTextI18n")
    private fun onClickListener() {

        btnClickValue = binding.operation.text.toString()

        if (btnClickValue == "0") {
            btnClickValue = ""
        }

        binding.apply {
            btnZero.setOnClickListener {
                btnClickValue += "0"
                operation.setText(btnClickValue)
            }

            btnOne.setOnClickListener {
                btnClickValue += "1"
                operation.setText(btnClickValue)
            }

            btnTwo.setOnClickListener {
                btnClickValue += "2"
                operation.setText(btnClickValue)
            }

            btnThree.setOnClickListener {
                btnClickValue += "3"
                operation.setText(btnClickValue)
            }

            btnFour.setOnClickListener {
                btnClickValue += "4"
                operation.setText(btnClickValue)
            }

            btnFive.setOnClickListener {
                btnClickValue += "5"
                operation.setText(btnClickValue)
            }

            btnSix.setOnClickListener {
                btnClickValue += "6"
                operation.setText(btnClickValue)
            }

            btnSeven.setOnClickListener {
                btnClickValue += "7"
                operation.setText(btnClickValue)
            }

            btnEight.setOnClickListener {
                btnClickValue += "8"
                operation.setText(btnClickValue)
            }

            btnNine.setOnClickListener {
                btnClickValue += "9"
                operation.setText(btnClickValue)
            }

            btnComma.setOnClickListener {

                if(commaClick){

                    var btnClickValue: Double = 0.0


                }
                btnClickValue += "."
                operation.setText(btnClickValue)

                /* if (btnClickValue.isNotEmpty()) {

                     btnClickValue = if (btnClickValue.substring(0, 1) == btnClickValue) {
                         btnClickValue.replaceAfter(btnClickValue + "", ",")
                     } else {
                         "$btnClickValue"
                     }
                     operation.setText(btnClickValue)
                 } */
            }


            btnAc.setOnClickListener {
                btnClickValue = ""
                tempValue = ""
                newValue = " "
                operation.setText(btnClickValue)
                result.setText(btnClickValue)

                subClick = false
                sumClick = false
                multiplyClick = false
                divClick = false
                percentClick = false
                isFirstSub = true
                isFirstSum = true
                isFirstMultiply= true
                isFirstDiv=true
                isFirstPercent=true

            }

            btnC.setOnClickListener {
                val length = operation.text.length
                if (length > 0) {
                    operation.text.delete(length - 1, length)
                }
            }

            btnMinus.setOnClickListener {

                    /*if (isFirstMinus) {
                        btnClickValue += "-$btnClickValue"
                        operation.setText(btnClickValue)
                        isFirstMinus = false
                    } else {
                        btnClickValue += "$btnClickValue"
                        operation.setText(btnClickValue)
                    }*/


                if (btnClickValue.isNotEmpty()) {

                    btnClickValue = if (btnClickValue.substring(0, 1) == "-") {
                        btnClickValue.replaceFirst("-", "")
                    } else {
                        "-$btnClickValue"
                    }
                    operation.setText(btnClickValue)
                }
            }
            btnPercent.setOnClickListener {

                percentClick = true
                divClick = false
                multiplyClick = false
                subClick = false
                sumClick = false

                if (sumClick || subClick || multiplyClick || divClick) {

                    if (sumClick) {
                        newValue = btnClickValue.substringAfter("+")
                        resultText = (newValue.toDouble() + tempValue.toDouble())
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (subClick) {
                        btnClickValue = "0"
                        tempValue = btnClickValue
                        tempValue = result.text.toString()
                        newValue =
                            btnClickValue.substringAfter("-") // string degeri icindeki degerden sonra girilen degeri istedik.
                        resultText =
                            (tempValue.toDouble() - newValue.toDouble())  // result textine geçici olarak atadağımız değişken ile yeni değerin işlemini gerçekleştirdik.
                        operation.setText("$resultText-") // resultexte atadığımız değeri operation textine çağırdık.
                        btnClickValue = operation.text.toString() //
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (multiplyClick) {
                        btnClickValue= "1"
                        tempValue= result.text.toString()
                        newValue = btnClickValue.substringAfter("*")
                        resultText = (tempValue.toDouble() * newValue.toDouble())
                        operation.setText("$resultText*")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (divClick) {
                        newValue = btnClickValue.substringAfter("/")
                        resultText = (tempValue.toDouble() / newValue.toDouble())
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                } else {
                    if (isFirstPercent) {
                        tempValue = btnClickValue
                        btnClickValue += "%"
                        operation.setText(btnClickValue)
                        isFirstPercent = false
                    } else {

                        newValue = btnClickValue.substringAfter("%")
                        tempValue = "0"
                        resultText = ((tempValue.toDouble() * newValue.toDouble()) / 100)
                        operation.setText("$resultText%")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                }

            }

            btnDiv.setOnClickListener {

                divClick = true
                multiplyClick = false
                subClick = false
                sumClick = false
                percentClick = false

                if (sumClick || subClick || multiplyClick || percentClick) {

                    if (sumClick) {
                        newValue = btnClickValue.substringAfter("+")
                        resultText = (newValue.toDouble() + tempValue.toDouble())
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (subClick) {
                        btnClickValue = "0"
                        tempValue = btnClickValue
                        tempValue = result.text.toString()
                        newValue =
                            btnClickValue.substringAfter("-") // string değeri içindeki değerden sonra girilen değeri istedik.
                        resultText =
                            (tempValue.toDouble() - newValue.toDouble())  // result textine geçici olarak atadağımız değişken ile yeni değerin işlemini gerçekleştirdik.
                        operation.setText("$resultText-") // resultexte atadığımız değeri operation textine çağırdık.
                        btnClickValue = operation.text.toString() //
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (multiplyClick) {
                        btnClickValue= "1"
                        tempValue= result.text.toString()
                        newValue = btnClickValue.substringAfter("*")
                        resultText = (tempValue.toDouble() * newValue.toDouble())
                        operation.setText("$resultText*")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (percentClick) {
                        newValue = btnClickValue.substringAfter("%")
                        resultText = ((tempValue.toDouble() * newValue.toDouble()) / 100)
                        operation.setText("$resultText%")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                } else {
                    if (isFirstDiv) {
                        tempValue = btnClickValue
                        btnClickValue += "/"
                        operation.setText(btnClickValue)
                        isFirstDiv = false
                    } else {

                        newValue = btnClickValue.substringAfter("/")
                        tempValue = "0"
                        resultText = (tempValue.toDouble() / newValue.toDouble())
                        operation.setText("$resultText/")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                }

            }
            btnMultiply.setOnClickListener {

                multiplyClick = true
                subClick = false
                sumClick = false
                divClick = false
                percentClick = false

                if (sumClick || subClick || divClick || percentClick) {

                    if (sumClick) {
                        newValue = btnClickValue.substringAfter("+")
                        resultText = (newValue.toDouble() + tempValue.toDouble())
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (subClick) {
                        btnClickValue = "0"
                        tempValue = btnClickValue
                        tempValue = result.text.toString()
                        newValue =
                            btnClickValue.substringAfter("-") // string değeri içindeki değerden sonra girilen değeri istedik.
                        resultText =
                            (tempValue.toDouble() - newValue.toDouble())  // result textine geçici olarak atadağımız değişken ile yeni değerin işlemini gerçekleştirdik.
                        operation.setText("$resultText-") // resultexte atadığımız değeri operation textine çağırdık.
                        btnClickValue = operation.text.toString() //
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (divClick) {
                        newValue = btnClickValue.substringAfter("/")
                        resultText = (tempValue.toDouble() / newValue.toDouble())
                        operation.setText("$resultText/")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())

                    } else if (percentClick) {
                        newValue = btnClickValue.substringAfter("%")
                        resultText = ((tempValue.toDouble() * newValue.toDouble()) / 100)
                        operation.setText("$resultText%")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                } else {
                    if (isFirstMultiply) {
                        tempValue = btnClickValue
                        btnClickValue += "*"
                        operation.setText(btnClickValue)
                        isFirstMultiply = false
                    } else {
                        btnClickValue= "1"
                        tempValue= result.text.toString()
                        newValue = btnClickValue.substringAfter("*")
                        resultText = (tempValue.toDouble() * newValue.toDouble())
                        operation.setText("$resultText*")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                }


            }

            btnSub.setOnClickListener {

                subClick = true
                sumClick = false
                multiplyClick = false
                divClick = false
                percentClick = false

                if (sumClick || multiplyClick || divClick || percentClick) {

                    if (sumClick) {
                        newValue = btnClickValue.substringAfter("+")
                        resultText = (newValue.toDouble() + tempValue.toDouble())
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    } else if (multiplyClick) {
                        btnClickValue= "1"
                        tempValue= result.text.toString()
                        newValue = btnClickValue.substringAfter("*")
                        resultText = (tempValue.toDouble() * newValue.toDouble())
                        operation.setText("$resultText*")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    } else if (divClick) {
                        newValue = btnClickValue.substringAfter("/")
                        resultText = (tempValue.toDouble() / newValue.toDouble())
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    } else if (percentClick) {
                        newValue = btnClickValue.substringAfter("%")
                        resultText = ((tempValue.toDouble() * newValue.toDouble()) / 100)
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                } else {

                    if (isFirstSub) {
                        tempValue = btnClickValue // girilen değeri geçici bir değişkene atadık.
                        btnClickValue += "-" // yazılan her değerden sonrası için işlem işaretini ekledik.
                        operation.setText(btnClickValue) // operation textine girilen değeri çağırdık.
                        isFirstSub = false

                    } else {
                        btnClickValue = "0"
                        // tempValue = btnClickValue
                        tempValue = result.text.toString()
                        newValue = btnClickValue.substringAfter("-") // string değeri içindeki değerden sonra girilen değeri istedik.
                        resultText = (tempValue.toDouble() - newValue.toDouble())  // result textine geçici olarak atadağımız değişken ile yeni değerin işlemini gerçekleştirdik.
                        operation.setText("$resultText-") // resultexte atadığımız değeri operation textine çağırdık.
                        btnClickValue = operation.text.toString() //
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                }

            }

            btnSum.setOnClickListener {

                sumClick = true
                subClick = false
                multiplyClick = false
                divClick = false
                percentClick = false

                if (subClick || multiplyClick || divClick || percentClick) {

                    if (subClick) {
                        btnClickValue = "0"
                        tempValue = result.text.toString()
                        newValue =
                            btnClickValue.substringAfter("-") // string değeri içindeki değerden sonra girilen değeri istedik.
                        resultText =
                            (tempValue.toDouble() - newValue.toDouble())  // result textine geçici olarak atadağımız değişken ile yeni değerin işlemini gerçekleştirdik.
                        operation.setText("$resultText") // resultexte atadığımız değeri operation textine çağırdık.
                        btnClickValue = operation.text.toString() //
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    } else if (multiplyClick) {
                        btnClickValue= "1"
                        tempValue= result.text.toString()
                        newValue = btnClickValue.substringAfter("*")
                        resultText = (tempValue.toDouble() * newValue.toDouble())
                        operation.setText("$resultText*")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    } else if (divClick) {
                        newValue = btnClickValue.substringAfter("/")
                        resultText = (tempValue.toDouble() / newValue.toDouble())
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    } else if (percentClick) {
                        newValue = btnClickValue.substringAfter("%")
                        resultText = ((tempValue.toDouble() * newValue.toDouble()) / 100)
                        operation.setText("$resultText")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                } else {
                    if (isFirstSum) {
                        tempValue = btnClickValue
                        btnClickValue += "+"    // "$tempValue+" ikisi de aynı anlama gelir.
                        operation.setText(btnClickValue)
                        isFirstSum = false
                    } else {
                        newValue = btnClickValue.substringAfter("+")
                        tempValue = "0"
                        resultText = (newValue.toDouble() + tempValue.toDouble())
                        operation.setText("$resultText+")
                        btnClickValue = operation.text.toString()
                        tempValue = resultText.toString()
                        result.setText(resultText.toString())
                    }
                }

            }

            btnEqual.setOnClickListener {

                if (sumClick) {
                    newValue = btnClickValue.substringAfter("+")
                    resultText = (newValue.toDouble() + tempValue.toDouble())
                    operation.setText(resultText.toString())
                    result.setText(resultText.toString())
                    btnClickValue = resultText.toString()

                } else if (subClick) {
                    newValue = btnClickValue.substringAfter("-")
                    resultText = (tempValue.toDouble() - newValue.toDouble())
                    operation.setText(resultText.toString())
                    result.setText(resultText.toString())
                    btnClickValue = resultText.toString()

                } else if (multiplyClick) {
                    newValue = btnClickValue.substringAfter("*")
                    resultText = (tempValue.toDouble() * newValue.toDouble())
                    operation.setText(resultText.toString())
                    result.setText(resultText.toString())
                    btnClickValue = resultText.toString()


                } else if (divClick) {
                    newValue = btnClickValue.substringAfter("/")
                    resultText = (tempValue.toDouble() / newValue.toDouble())
                    operation.setText(resultText.toString())
                    result.setText(resultText.toString())
                    btnClickValue = resultText.toString()


                } else if (percentClick) {
                    newValue = btnClickValue.substringAfter("%")
                    resultText = ((tempValue.toDouble() * newValue.toDouble()) / 100)
                    operation.setText(resultText.toString())
                    result.setText((resultText.toString()))
                    btnClickValue = resultText.toString()

                }

            }
        }
    }
}




