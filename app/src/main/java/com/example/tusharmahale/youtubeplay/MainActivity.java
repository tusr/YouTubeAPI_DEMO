package com.example.tusharmahale.youtubeplay;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView dial,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= (Button)findViewById(R.id.button);
        dial =(TextView)findViewById(R.id.textView3);
        email =(TextView)findViewById(R.id.textView2);
        b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent I = new Intent(MainActivity.this,YouTubeActivity.class);
            startActivity(I);
        }
    });
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialpad = new Intent(Intent.ACTION_DIAL);
                dialpad.setData(Uri.parse("tel:9872429858"));
            startActivity(dialpad);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "tmahale05@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Hello");
                intent.putExtra(Intent.EXTRA_TEXT, "Happy Start");
                startActivity(Intent.createChooser(intent, ""));
            }
        });
    }
}
