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

        usarBinding()

        binding.botaoConverter.setOnClickListener {
            converter()
        }
    }

    fun usarBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun converter() {
        val temperatura = binding.textTemperatura.text.toString().toDouble()
        val celsiusToFahrenheit = (temperatura * 1.8) + 32
        val celsiusToKelvin = temperatura + 273
        val celsiusToCelsius = temperatura
        val fahrenheitToCelsius = (temperatura - 32) / 1.8
        val fahrenheitToKelvin = (temperatura + 459.67) * 5 / 9
        val fahrenheitToFahrenheit = temperatura
        val kelvinToCelsius = temperatura - 273
        val kelvinToFahrenheit = ((temperatura - 273) * 9 / 5) + 32
        val kelvinToKelvin = temperatura

        when {
            binding.radioCelciusPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(celsiusToFahrenheit))
            binding.radioCelciusPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(celsiusToKelvin))
            binding.radioCelciusPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(celsiusToCelsius))
            binding.radioFahrenheitPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(fahrenheitToCelsius))
            binding.radioFahrenheitPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(fahrenheitToKelvin))
            binding.radioFahrenheitPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(fahrenheitToFahrenheit))
            binding.radioKelvinPrimeiro.isChecked && binding.radioCelciusSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(kelvinToCelsius))
            binding.radioKelvinPrimeiro.isChecked && binding.radioFahrenheitSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(kelvinToFahrenheit))
            binding.radioKelvinPrimeiro.isChecked && binding.radioKelvinSegundo.isChecked ->
                binding.textResultado.setText("%.2f".format(kelvinToKelvin))
        }
    }
}

