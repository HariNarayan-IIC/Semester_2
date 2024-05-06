package com.example.implicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sender);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onSendExplicitClick(View view) {
        Intent explicitIntent = new Intent(this, ReceiverActivity.class);
        EditText input = findViewById(R.id.input);
        String msg = input.getText().toString();
        if (msg.isEmpty()) {
            Toast.makeText(this, "Enter some message you idiot", Toast.LENGTH_SHORT).show();
        }
        else {
            explicitIntent.putExtra("message", msg);
            startActivity(explicitIntent);
        }
    }

    public void onSendImplicitClick(View view) {
        Intent implicitIntent = new Intent(Intent.ACTION_SEND);
        implicitIntent.setType("text/plain");
        EditText input = findViewById(R.id.input);
        String msg = input.getText().toString();
        if (msg.isEmpty()) {
            Toast.makeText(this, "Enter some message you idiot", Toast.LENGTH_SHORT).show();
        }
        else {
            implicitIntent.putExtra(Intent.EXTRA_TEXT, msg);
            startActivity(implicitIntent);
        }

    }
}