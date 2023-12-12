package com.almirlima.calculatorimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.almirlima.calculatorimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun imc(view: View){
        val altura = binding.editAltura.text.toString()
        val peso = binding.editPeso.text.toString()

        val validaCampos = validarCampos(altura,peso)
        if (validaCampos) calcularImc(altura, peso) else binding.textResposta.setText("Preencha os campos!")
    }

    fun validarCampos(altura:String, peso:String):Boolean {
        var camposValidados = true
        if (altura.isNullOrEmpty()){
            camposValidados = false
        }else if (peso.isNullOrEmpty()){
            camposValidados = false
        }
        return camposValidados
    }

    fun calcularImc(altura: String,peso: String){
        val valorAltura = altura.toDouble()
        val valorPeso = peso.toDouble()
        val resultadoImc = valorPeso / (valorAltura * valorAltura)
        binding.textResposta.text = when {
            resultadoImc < 18.5 -> "Você está abaixo do peso ideal. Consulte um profissional de saúde para orientações."
            resultadoImc < 24.9 -> "Seu peso está dentro da faixa considerada saudável. Parabéns!"
            resultadoImc < 29.9 -> "Você está com sobrepeso. Considere adotar hábitos saudáveis de alimentação e exercícios."
            resultadoImc < 34.9 -> "Você está na faixa de obesidade grau I. Procure a orientação de um profissional de saúde."
            resultadoImc < 39.9 -> "Você está na faixa de obesidade grau II. Consulte um médico para orientações."
            else -> "Você está na faixa de obesidade grau III. É crucial procurar ajuda médica imediatamente."
        }
}}