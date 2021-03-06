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
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.zdjecie_btn).isEnabled= false;
        var zmienna= 1;
        val nast_btn = findViewById<ImageButton>(R.id.nastepny_btn);
        val pop_btn = findViewById<ImageButton>(R.id.poprzedni_btn);
        val zapisz = findViewById<Button>(R.id.zapisz_btn);
        val obrazek = findViewById<ImageView>(R.id.zdjecie_img);

        val check_schowaj = findViewById<CheckBox>(R.id.checkbox_schowaj);
        val editText = findViewById<EditText>(R.id.edit_scale);
        var zmienna_2=0;

        zapisz.setOnClickListener{
            zmienna= Integer.parseInt(editText.getText().toString());
            obrazek.layoutParams = LinearLayout.LayoutParams(zmienna,zmienna)
        }

        check_schowaj.setOnClickListener{
            if(check_schowaj.isChecked==true){
                obrazek.setVisibility(View.VISIBLE);
            }else{
                obrazek.setVisibility(View.INVISIBLE);
            }
        }

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
            }else if(zmienna>=4){
                obrazek.setImageResource(R.drawable.szprej);
                zmienna--;
            }

        }
        wyczysc_btn.setOnClickListener{
            obrazek.setImageResource(0);
        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) !=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 111)
        }
        else
            findViewById<ImageButton>(R.id.zdjecie_btn).isEnabled= true;

        findViewById<ImageButton>(R.id.zdjecie_btn).setOnClickListener{
            zmienna == 5;
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
            findViewById<ImageButton>(R.id.zdjecie_btn).isEnabled= true;
        }
    }

}