package com.rafa.imc_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        heightEDT?.doAfterTextChanged { text ->
            indexTXT?.text = text
        }

        weightEDT?.doAfterTextChanged { text ->
            indexTXT?.text = text
        }
        calcBTN?.setOnClickListener {
            calcImc(heightEDT.text.toString(), weightEDT.text.toString())
        }
    }

    private fun calcImc(height:String, weight:String ) {
        val hgt = height.toFloatOrNull()
        val wgt = weight.toFloatOrNull()

        if (hgt != null && wgt != null) {
            val imc = wgt / (hgt * hgt)
            indexTXT.text = "IMC:  %.1f".format(imc)
        }
    }

}
