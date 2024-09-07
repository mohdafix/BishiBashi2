package com.example.bishibashi;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Launch WebViewActivity directly
        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        startActivity(intent);
        finish(); // Finish MainActivity if you don't need it after launch
    }
}
