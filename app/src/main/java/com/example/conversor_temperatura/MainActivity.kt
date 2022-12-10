package com.example.conversor_temperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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

        usarBinding()

        binding.botaoConverter.setOnClickListener {
            converter()
        }
    }
 
        fun usarBinding(){
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
        }

        fun converter(){
        val temperatura = binding.textTemperatura.text.toString().toDouble()
        val cF = (temperatura * 1.8) + 32
        val cK = temperatura + 273
        val cC = temperatura
        val fC = (temperatura -32) / 1.8
        val fK = (temperatura + 459.67) * 5 / 9
        val fF = temperatura
        val kC = temperatura - 273
        val kF = ((temperatura -273) *9/5) + 32
        val kK = temperatura

        when{
            binding.radioCelciusPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(cF))
            binding.radioCelciusPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(cK))
            binding.radioCelciusPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(cC))
            binding.radioFahrenheitPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(fC))
            binding.radioFahrenheitPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(fK))
            binding.radioFahrenheitPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(fF))
            binding.radioKelvinPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(kC))
            binding.radioKelvinPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(kF))
            binding.radioKelvinPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(kK))
        }
        }
}

