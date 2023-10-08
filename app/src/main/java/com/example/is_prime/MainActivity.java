package com.example.is_prime;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkPrime(View view) {
        EditText numberEditText = findViewById(R.id.numberEditText);
        TextView resultTextView = findViewById(R.id.resultTextView);

        String input = numberEditText.getText().toString();

        try {
            int number = Integer.parseInt(input);
            boolean isPrime = isPrimeNumber(number);

            if (isPrime) {
                resultTextView.setText(number + "は素数です");
            } else {
                String divisors = findDivisors(number);
                resultTextView.setText(number + "は" + "\n" + divisors + "\n" + "を約数にもつ整数です。");
            }
        } catch (NumberFormatException e) {
            resultTextView.setText("それは整数ではありません");
        }
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private String findDivisors(int number) {
        StringBuilder divisors = new StringBuilder();
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                divisors.append(i).append(", ");
            }
        }
        String result = divisors.toString();
        // 余分なカンマと空白を削除する
        if (result.length() > 2) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }
}

