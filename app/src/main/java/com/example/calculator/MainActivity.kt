package com.example.calculator

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btnDiv: Button
    private lateinit var btnPlus: Button
    private lateinit var btnMulti: Button
    private lateinit var btnClear: Button
    private lateinit var btnEquals: Button
    private lateinit var btnDec: Button
    private lateinit var btnNeg: Button
    private lateinit var btnDel: Button
    private lateinit var btnMin: Button
    private lateinit var plusMinus: Button

    var output = 0f
    var op = ' '
    var num1 = ""
    var num2 = ""
    var result = "0"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnDiv = findViewById(R.id.btnDiv)
        btnPlus = findViewById(R.id.btnPlus)
        btnMulti = findViewById(R.id.btnMulti)
        btnClear = findViewById(R.id.btnClear)
        btnEquals = findViewById(R.id.btnEquals)
        btnDec = findViewById(R.id.btnDec)
        btnNeg = findViewById(R.id.btnNeg)
        btnDel = findViewById(R.id.btnDel)
        btnMin = findViewById(R.id.btnMin)




        btn0.setOnClickListener {
            setNum('0')
            tvResult.text = result
        }
        btn1.setOnClickListener {
            setNum('1')
            tvResult.text = result
        }
        btn2.setOnClickListener {
            setNum('2')
            tvResult.text = result
        }
        btn3.setOnClickListener {
            setNum('3')
            tvResult.text = result
        }
        btn4.setOnClickListener {
            setNum('4')
            tvResult.text = result
        }
        btn5.setOnClickListener {
            setNum('5')
            tvResult.text = result
        }
        btn6.setOnClickListener {
            setNum('6')
            tvResult.text = result
        }
        btn7.setOnClickListener {
            setNum('7')
            tvResult.text = result
        }
        btn8.setOnClickListener {
            setNum('8')
            tvResult.text = result
        }
        btn9.setOnClickListener {
            setNum('9')
            tvResult.text = result
        }
        btnPlus.setOnClickListener {
            ShowOp('+')
            tvResult.text = result
        }
        btnDiv.setOnClickListener {
            ShowOp('/')
            tvResult.text = result
        }
        btnMin.setOnClickListener {
            ShowOp('-')
            tvResult.text = result
        }
        btnMulti.setOnClickListener {
            ShowOp('*')
            tvResult.text = result
        }
        btnNeg.setOnClickListener {
            negtive()
            tvResult.text = result
        }
        btnEquals.setOnClickListener {
            calculate()
            tvResult.text = result
        }
        btnDec.setOnClickListener {
            if (op == ' ' && !num1.contains(".")) {
                setNum('.')
            }
            if (op != ' ' && !num2.contains(".")) {
                setNum('.')
            }
        }
        btnDel.setOnClickListener {
            delete()
            tvResult.text = result

        }
        btnClear.setOnClickListener {
            clearAll()
            tvResult.text = result


        }






    }


    fun negtive(){
        if (op == ' ') {
            num1 = if (num1.startsWith("-")) {
                num1.substring(1, num1.length)
            } else {
                "-$num1"
            }
            result = num1
        } else {
            num2 = if (num2.startsWith("-")) {
                num2.substring(1, num2.length)
            } else {
                "-$num2"
            }
            val text = num1 + op + num2
            result = text
        }
    }


    fun calculate() {
        when (op) {
            '+' -> output = num1.toFloat() + num2.toFloat()
            '-' -> output = num1.toFloat() - num2.toFloat()
            '*' -> output = num1.toFloat() * num2.toFloat()
            '/' ->
                if (num2.toFloat() != 0f) {
                   output = num1.toFloat() / num2.toFloat()
                } else {
                    clearAll()
                }
        }
        num1 = output.toString()
        num2 = ""
        result = output.toString()

    }
    fun clearAll() {
        output = 0f
        op = ' '
        num1 = ""
        num2 = ""
        result = "0"
    }

    private fun setNum(num: Char) {
        if (op == ' ') {
            num1 += num
            result = num1
        } else {
            num2 += num
            result = "$num1 $op  $num2"
        }

    }

    fun ShowOp(op1: Char) {
        op = op1
        val text = num1 + op
        result = text
    }


    fun delete() {
        if (op == ' ') { // if op emptey so ew will delete num1
            if (num1.isNotEmpty()) {
                num1 = num1.substring(0, num1.length - 1)
                if (num1.isEmpty()) {
                    result = "0"
                } else {
                    result = num1
                }
            }
        } else { // if we have op so we have num2
            if (num2.isNotEmpty()) {
                num2 = num2.substring(0, num2.length - 1)
                val text = num1 + op + num2
                result = text
            } else {
                op = ' '
                result = num1
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            tvResult.setPadding(0, 0, 24, 0)
            tvResult.textSize = 24f
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            tvResult.setPadding(0, 24, 24, 0)
            tvResult.textSize = 32f
        }
    }

}


