package com.cdp.lanzardados

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.media.MediaPlayer

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnLanzar: Button = findViewById(R.id.btnLanzar)

        btnLanzar.setOnClickListener {
            tiempo()

            //tiene que durar el mismo tiempo que "gira el dado"
            //val mp = MediaPlayer.create(this, R.sound.sonido)
            //mp.start()
        }

        rollDice()

    }


    //asi se le dice lanzar dados en ingles
    private fun rollDice() {
        var numero: Int = lanzar(6)
        val txtResult: TextView = findViewById(R.id.txtResultado)
        txtResult.text = numero.toString()



        val drawableResource = when(numero) {
          1 -> R.drawable.dado1
          2 -> R.drawable.dado2
          3 -> R.drawable.dado3
          4 -> R.drawable.dado4
          5 -> R.drawable.dado5
          else -> R.drawable.dado6
        }

        val imgDado: ImageView = findViewById(R.id.imgDado)
        imgDado.setImageResource(drawableResource)

    }


    //esta funcion nos genera el N° aleatorio
    private fun lanzar(max: Int): Int {
        return (1..max).random()
    }


    //esta funcion es el tiempo que "gira el dado"
    private fun tiempo() {
        object: CountDownTimer(3000, 200) {

            //que va hacer en cada intervalo
            override fun onTick(p0: Long) {
                rollDice()
            }


            //que va hacer cuando termine
            override fun onFinish() {

            }

        }.start()
    }



}
