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
    private String mName = "小野";
    private StringBuilder mPriceMessage = new StringBuilder("NT$"+mPrice);
    private StringBuilder mQuantityMessage = new StringBuilder(mQuantity);
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        checkBox = (CheckBox)findViewById(R.id.toppings_checkbox);
    }

    private void displayTotalPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        String myString = NumberFormat.getCurrencyInstance().format(total);
        priceTextView.setText(myString);
        String message = myString + (mQuantity==0?"\nFree":"\nThank you!");
        priceTextView.setText(message);
    }




    public void clickToppings(View view) {
        if(checkBox.isChecked() == true){
            resetPriceMessageString();
            displayPriceMessage();
        }else{
            displayTotalPrice();
        }
    }

    private void resetPriceMessageString(){
        clearPriceMessageString();
        mPriceMessage.append("奶茶")
                .append("NT$ ").append(mPrice);
    }

    private void displayPriceMessage(){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(mPriceMessage);
    }

    private void displayQuantityMessage(){
        TextView quantityTextView =
                (TextView)findViewById(R.id.quavtity_text_view);
        int start = 0;
        int end = mQuantityMessage.length();
        mQuantityMessage.delete(start,end).append(mQuantity);
        quantityTextView.setText(mQuantityMessage);
    }


    public void increment(View view) {
        //+的變數
        if (mQuantity<100) {
        //100以內才會作用，不會超過100
            ++mQuantity;
            //數字遞增
            displayQuantityMessage();
            //顯示遞增遞減的數字，有垃圾車會處理
            resetTotolPrice();
            //點選+的按鈕清除下方顯示字串
        }
    }

    public void decrement(View view) {
        //-的變數
        if (mQuantity > 0) {
            //數字大於0才有作用，不會低於0
            --mQuantity;
            //數字遞減
            displayQuantityMessage();
            //顯示遞增遞減的數字，有垃圾車會處理
            resetTotolPrice();
            //點選-的按鈕清除下方顯示字串
        }
    }

    private void resetTotolPrice(){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText("");
    }
    public void submitOrder(View view) {
        clearPriceMessageString();//刪除mPriceMessage
        concatPriceMessageString();//字串組合 人名 + 漢堡 + 是否加奶茶 +Free 或 NT$xxx Thank you!
        displayPriceMessage();//displayPriceMessage()

    }

    private void clearPriceMessageString(){
        int start = 0;
        int end = mPriceMessage.length();
        mPriceMessage.delete(start, end);
    }

    private void concatPriceMessageString(){

        mPriceMessage.append("Name: ")
                .append(mName)
                .append("\n")
                .append("加奶茶?")
                .append(checkBox.isChecked())
                .append("\n");
        if(mQuantity == 0){
            mPriceMessage.append("Free");
        }else{
            mPriceMessage.append("Quantity:")
                    .append(mQuantity)
                    .append("\n")
                    .append("Total: ")
                    .append("NT$")
                    .append(mPrice * mQuantity)
                    .append("\n")
                    .append("Thank you!")
                    .append("\n");
        }
    }




}
