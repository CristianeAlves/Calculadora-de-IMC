package br.com.cotemig.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener{

            var peso = findViewById<EditText>(R.id.peso)
            var altura = findViewById<EditText>(R.id.altura)

            var p = peso.text.toString().toDouble()
            var a = altura.text.toString().toDouble()

            var imcCalculo: Double = (p/(a * a)) * 10000
            var imc = "%.1f".format(imcCalculo)
            var imcResult = findViewById<TextView>(R.id.imc)

            imcResult.text = imc.toString()

            var res:String
            if(imcCalculo >= 18.5 && imcCalculo <= 24.9){
                res = "Abaixo do peso"
            } else if(imcCalculo >= 25.0 && imcCalculo <= 29.9){
                res = "Sobrepeso"
            } else if(imcCalculo >= 30.0 && imcCalculo <= 34.9){
                res = "Obesidade Grau I"
            } else if(imcCalculo >= 35.0 && imcCalculo <= 39.9){
                res = "Obesidade Grau II"
            } else if(imcCalculo >= 40.0){
                res = "Obesidade Grau III"
            } else {
                res = "Valor inválido"
            }

            var resultado = findViewById<TextView>(R.id.resultado)
            resultado.text = res.toString()
        }
    }
}