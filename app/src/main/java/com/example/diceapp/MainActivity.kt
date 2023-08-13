package com.example.diceapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
   lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton:Button=findViewById(R.id.roll_button)
        rollButton.text="Let's Roll"

        rollButton.setOnClickListener{
//            Toast.makeText(this,"button clicked", Toast.LENGTH_SHORT).show() //app in aşağısında kısa süreli gözükecek bir mesaj ayarlıyoruz Toast ile, zaten bağlam sınıfı içerisinde bulunduğumuzdan context i this olarak verebiliriz
            rollDice()
        }
        diceImage=findViewById(R.id.dice_image)
    }

    private fun rollDice() {

//        val resultText: TextView= findViewById(R.id.result_text)
        val randomInt = Random().nextInt(6)+1 // 0 ile 5 arasında rastgele sayı döndüreceği için +1 ile 1-6 aralığı yapmış olduk
        val drawableResource= when(randomInt){
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
           else-> R.drawable.dice_6

        }
//        resultText.text = randomInt.toString()

//        val diceImage:ImageView= findViewById(R.id.dice_image)
// burada fonksiyon her çağırıldığında findbyid çalışıp çok fazla uygulamayı şişireceği için yukarıda lateinit olarak yani null dönmeyeceğine ve içini dolduracağımıza söz vererek değişkenimizi tanımladık ve finbyid yi oncreate de bir defalığına çağırdık tanımladığımız değişkeni de burada direkt olarak kullanabildik

        diceImage.setImageResource(drawableResource)
    }
}