package com.example.aplikacja_na_ocene

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.zdjecie_btn).isEnabled= false;
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
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 111)
        }
        else
            findViewById<Button>(R.id.zdjecie_btn).isEnabled= true;

        findViewById<Button>(R.id.zdjecie_btn).setOnClickListener{
            var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,101);
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==101){
            var mojObrazek: Bitmap?
            mojObrazek = data?.getParcelableExtra("data")
            findViewById<ImageView>(R.id.zdjecie_img).setImageBitmap(mojObrazek)
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==111 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            findViewById<Button>(R.id.zdjecie_btn).isEnabled= true;
        }
    }
}