package com.quizmagic.shopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class menu extends AppCompatActivity {

    private int mQuantity;
    private int mPrice = 5;
    private String Milktea = "奶茶";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void increment(View view) {
        displayQuantity();
        ++mQuantity;
        resetTotolPrice();

    }

    public void decrement(View view) {
        if (mQuantity > 0) {
            --mQuantity;
            displayQuantity();
            resetTotolPrice();
        }
    }

    private void resetTotolPrice(){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText("");
    }
    public void submitOrder(View view) {
        displayTotalPrice();
    }

    private void displayTotalPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        String myString = NumberFormat.getCurrencyInstance().format(total);
        priceTextView.setText(myString);
        String message = myString + (mQuantity==0?"\nFree":"\nThank you!");
        priceTextView.setText(message);
    }

    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quavtity_text_view);
        quantityTextView.setText(String.valueOf(mQuantity));
    }


    public void mk(View view) {
        final CheckBox mk = (CheckBox)findViewById(R.id.checkBox);
        if(mk.isChecked()){
            resetTotolPrice();
        }
    }
}
