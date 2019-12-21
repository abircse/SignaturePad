package com.example.signatureimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.simplify.ink.InkView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final InkView ink = findViewById(R.id.ink);
        ink.setColor(getResources().getColor(android.R.color.black));
        ink.setMinStrokeWidth(1.5f);
        ink.setMaxStrokeWidth(6f);

        Button button = findViewById(R.id.clearsignature);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ink.clear();

            }
        });

        Button button1 = findViewById(R.id.savesignature);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ImageView imageView = findViewById(R.id.signatureview);

                Bitmap bitmap = ink.getBitmap();
                Drawable drawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                imageView.setImageDrawable(drawable);
            }
        });
    }
}
