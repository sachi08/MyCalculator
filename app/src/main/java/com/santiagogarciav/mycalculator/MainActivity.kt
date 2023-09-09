package com.santiagogarciav.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textResult:TextView

    fun updateText(textResult: TextView, num: String, button: Button) {
        button.setOnClickListener {
            // Aquí establece el valor que deseas en el TextView cuando se presione el botón
            val textCurrent = textResult.text.toString()
            val new = num // Reemplaza esto con el valor que deseas concatenar
            val textNew = "$textCurrent$new"

            // Establece el nuevo texto en el TextView
            textResult.text = textNew
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//        setContentView(view)
//        textResult=findViewById(R.id.result_text_view)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.result_text_view)

        val button_point = findViewById<Button>(R.id.point_button)
        updateText(textResult,".",button_point)
        val button_0 = findViewById<Button>(R.id.zero_button)
        updateText(textResult,"0",button_0)
        val button_1 = findViewById<Button>(R.id.one_button)
        updateText(textResult,"1",button_1)
        val button_2 = findViewById<Button>(R.id.two_button)
        updateText(textResult,"2",button_2)
        val button_3 = findViewById<Button>(R.id.three_button)
        updateText(textResult,"3",button_3)
        val button_4 = findViewById<Button>(R.id.four_button)
        updateText(textResult,"4",button_4)
        val button_5 = findViewById<Button>(R.id.five_button)
        updateText(textResult,"5",button_5)
        val button_6 = findViewById<Button>(R.id.six_button)
        updateText(textResult,"6",button_6)
        val button_7 = findViewById<Button>(R.id.seven_button)
        updateText(textResult,"7",button_7)
        val button_8 = findViewById<Button>(R.id.eigth_button)
        updateText(textResult,"8",button_8)
        val button_9 = findViewById<Button>(R.id.nine_button)
        updateText(textResult,"9",button_9)


        val sum = findViewById<Button>(R.id.sum_button)
        updateText(textResult,"+",sum)
        val subt = findViewById<Button>(R.id.subt_button)
        updateText(textResult,"-", subt)
        val mult = findViewById<Button>(R.id.mult_button)
        updateText(textResult,"*",mult)
        val div= findViewById<Button>(R.id.div_button)
        updateText(textResult,"/", div)

        val same = findViewById<Button>(R.id.same_button)
        same.setOnClickListener {
            val equation = textResult.text.toString()
            textResult.text = (calculateOperation(equation)).toString()
            }


    }
    fun calculateOperation(operacion: String): Double {
        // Divide la cadena en dos partes en función del operador (+, -, *, /)
        val partes = operacion.split("[+\\-*/]".toRegex())

        if (partes.size != 2) {
            // La cadena no contiene exactamente dos números y un operador
            return Double.NaN
        }

        val numero1 = partes[0].trim().toDoubleOrNull()
        val numero2 = partes[1].trim().toDoubleOrNull()

        if (numero1 == null || numero2 == null) {
            // No se pudieron convertir ambas partes en números válidos
            return Double.NaN
        }

        // Encuentra el operador en la cadena original
        val operador = operacion.find { it in "+-*/" } ?: return Double.NaN

        // Realiza la operación matemática
        return when (operador) {
            '+' -> numero1 + numero2
            '-' -> numero1 - numero2
            '*' -> numero1 * numero2
            '/' -> {
                if (numero2 != 0.0) {
                    numero1 / numero2
                } else {
                    Double.NaN // División por cero
                }
            }
            else -> Double.NaN
        }
    }
}