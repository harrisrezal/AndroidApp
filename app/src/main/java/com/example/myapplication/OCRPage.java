package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

public class OCRPage extends AppCompatActivity {

    private ImageView imageView;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_c_r_page);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("filename");
        imageView = (ImageView) findViewById(R.id.imageview);
        back = (Button) findViewById(R.id.button_back);


        try {
            Bitmap bitmap = BitmapFactory.decodeStream(this.openFileInput(name));//here context can be anything like getActivity() for fragment, this or MainActivity.this
            imageView.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            Log.d("Come on man", "Please work");
            e.printStackTrace();
        }



        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity1();

            }
        });

    }



    public void startActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}