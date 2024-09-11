package co.edu.unipiloto.laboratorio3;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "messageText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateMessageHistory();
    }

    public void onSendMessage(View view) {
        EditText editText = (EditText)findViewById(R.id.message);
        String messageText = editText.getText().toString();
        MessageStorage.messages.add("Ciudadano: " + messageText);
        Intent intent = new Intent(this, RecibirMensaje.class);
        startActivity(intent);
        updateMessageHistory();
    }

    private void updateMessageHistory() {
        TextView messageHistoryView = (TextView)findViewById(R.id.messageHistory);
        StringBuilder messagesText = new StringBuilder();
        for(String message : MessageStorage.messages) {
            messagesText.append(message).append("\n");
        }
        messageHistoryView.setText(messagesText.toString());
    }
}