package com.example.conversor_temperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conversor_temperatura.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.botaoConverter.setOnClickListener {
            converter()
        }
    }

    fun converter(){
        val temperatura = binding.textTemperatura.text.toString().toDouble()

        if(binding.radioCelciusPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked){
            val resultado = (temperatura * 1.8) + 32
            binding.textResultado.setText("%.2f".format(resultado))
        }else if(binding.radioCelciusPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked) {
            val resultado = temperatura + 273
            binding.textResultado.setText("%.2f".format(resultado))
        }else if(binding.radioCelciusPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked){
            val resultado = temperatura
            binding.textResultado.setText("%.2f".format(resultado))
        }else if(binding.radioFahrenheitPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked){
            val resultado = (temperatura -32) / 1.8
            binding.textResultado.setText("%.2f".format(resultado))
        }else if(binding.radioFahrenheitPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked) {
            val resultado = (temperatura + 459.67) * 5 / 9
            binding.textResultado.setText("%.2f".format(resultado))
        }else if(binding.radioFahrenheitPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked){
            val resultado = temperatura
            binding.textResultado.setText("%.2f".format(resultado))
        }else if(binding.radioKelvinPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked){
            val resultado = temperatura - 273
            binding.textResultado.setText("%.2f".format(resultado))
        }else if(binding.radioKelvinPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked){
            val resultado = ((temperatura -273) *9/5) + 32
            binding.textResultado.setText("%.2f".format(resultado))
        }else if(binding.radioKelvinPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked){
            val resultado = temperatura
            binding.textResultado.setText("%.2f".format(resultado))
        }
    }
}

