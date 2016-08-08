package com.example.panth.chitchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText messageInput;
    private Button sendButton;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = getIntent().getStringExtra("username");
        Toast.makeText(getApplicationContext(), username, Toast.LENGTH_LONG);

        messageInput = (EditText) findViewById(R.id.message_input);
        sendButton = (Button) findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postMessage();
            }
        });
    }

    private void postMessage() {
        String text = messageInput.getText().toString();

        if (text.equals("")) return;

        RequestParams params = new RequestParams();
        //Set up the JSON object
        params.put("text", text);
        params.put("name", username);
        params.put("time", new Date().getTime());

        // Create the HTTP client
        AsyncHttpClient client = new AsyncHttpClient();


    }
}
