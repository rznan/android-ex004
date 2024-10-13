package br.com.renan.ex004;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 *@author: renan santos carvalho
 */
public class MainActivity extends AppCompatActivity {

    private EditText etGasosa;
    private EditText etPinga;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etGasosa = findViewById(R.id.etGasosa);
        etPinga = findViewById(R.id.etPinga);
        tvResult = findViewById(R.id.result);

        findViewById(R.id.buttonVerify).setOnClickListener(e -> doTheMath());
    }


    private void doTheMath() {
        double gasoline = Double.parseDouble(String.valueOf(etGasosa.getText()));
        double alcohol = Double.parseDouble(String.valueOf(etPinga.getText()));
        if((alcohol / gasoline) <= 0.7) {
            tvResult.setText(R.string.alcohol_label);
        } else {
            tvResult.setText(R.string.gasoline_label);
        }
    }
}