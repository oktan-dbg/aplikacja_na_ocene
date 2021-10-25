package com.example.aplikacja_na_ocene

import android.graphics.drawable.BitmapDrawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var zmienna= 1;
        val nast_btn = findViewById<ImageButton>(R.id.nastepny_btn);
        val pop_btn = findViewById<ImageButton>(R.id.poprzedni_btn);
        val obrazek = findViewById<ImageView>(R.id.zdjecie_img);

        nast_btn.setOnClickListener {
            if(zmienna==1){
                obrazek.setImageResource(R.drawable.zwykly_brek);
                zmienna++;
            }else if(zmienna==2){
                obrazek.setImageResource(R.drawable.brek);
                zmienna++;
            }else if(zmienna==3){
                obrazek.setImageResource(R.drawable.smutny_brek);
                zmienna++;
            }else if(zmienna==4){
                obrazek.setImageResource(R.drawable.szprej);
            }

        }
        pop_btn.setOnClickListener {
            if(zmienna==1){
                obrazek.setImageResource(R.drawable.zwykly_brek);
            }else if(zmienna==2){
                obrazek.setImageResource(R.drawable.brek);
                zmienna--;
            }else if(zmienna==3){
                obrazek.setImageResource(R.drawable.smutny_brek);
                zmienna--;
            }else if(zmienna==4){
                obrazek.setImageResource(R.drawable.szprej);
                zmienna--;
            }

        }

    }
}