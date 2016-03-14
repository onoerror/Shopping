package com.quizmagic.shopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void increment(View view) {
        int quanitty = getQuanitty();

        display(++quanitty);
    }
    public void decrement(View view) {
        int quanitty = getQuanitty();
        if(quanitty>0) {
            display(--quanitty);
        }
    }

    private int getQuanitty() {
        TextView quantityTextView = (TextView)findViewById(R.id.quavtity_text_view);
        String quantityString = quantityTextView.getText().toString();
        return Integer.parseInt(quantityString);
    }

    public void submitOrder(View view) {
        display(1);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView)findViewById(R.id.quavtity_text_view);
        quantityTextView.setText(String.valueOf(number));

        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int price = 5;
        int total = price * number;
        String myString = NumberFormat.getCurrencyInstance().format(total);
        priceTextView.setText(myString);
    }


}
