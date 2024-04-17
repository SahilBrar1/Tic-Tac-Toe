package com.example.tic_tactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int flag = 0;
    private int count = 0;

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void check(View view) {
        Button btnCurrent = (Button) view;
        count++;
        if (btnCurrent.getText().toString().isEmpty()) {
            if (flag == 0) {
                btnCurrent.setText("x");
                flag = 1;
            } else {
                btnCurrent.setText("o");
                flag = 0;
            }

            String b1 = btn1.getText().toString();
            String b2 = btn2.getText().toString();
            String b3 = btn3.getText().toString();
            String b4 = btn4.getText().toString();
            String b5 = btn5.getText().toString();
            String b6 = btn6.getText().toString();
            String b7 = btn7.getText().toString();
            String b8 = btn8.getText().toString();
            String b9 = btn9.getText().toString();

            if (b1.equals(b2) && b2.equals(b3) && !b3.isEmpty() ||
                    b4.equals(b5) && b5.equals(b6) && !b6.isEmpty() ||
                    b7.equals(b8) && b8.equals(b9) && !b9.isEmpty() ||
                    b1.equals(b4) && b4.equals(b7) && !b7.isEmpty() ||
                    b2.equals(b5) && b5.equals(b8) && !b8.isEmpty() ||
                    b3.equals(b6) && b6.equals(b9) && !b9.isEmpty() ||
                    b1.equals(b5) && b5.equals(b9) && !b9.isEmpty() ||
                    b3.equals(b5) && b5.equals(b7) && !b7.isEmpty()) {
                showToast("Winner is: " + btnCurrent.getText());
                newGame();
            } else if (count == 9) {
                showToast("The Match is Draw");
                newGame();
            }
        }
    }

    private void newGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}