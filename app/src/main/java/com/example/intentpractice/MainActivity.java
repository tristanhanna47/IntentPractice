package com.example.intentpractice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    public static final String NUMBER_KEY = "com.example.intentpractice.NUMBER_KEY";
    public static final String POTATO = "potato";
    EditText numberText;
    private int number;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(POTATO, MODE_PRIVATE);

        numberText = findViewById(R.id.numberText);
        number = sharedPreferences.getInt(NUMBER_KEY,0);
        showNumber();
    }

    public void multiply (View view)
    {
        number = Integer.valueOf(numberText.getText().toString());
        number *= number;
        showNumber();
    }

    private void showNumber()
    {
        numberText.setText("" + number);
    }

    public void gotosecond (View view)
    {
        Intent intent = new Intent (this, SecondActivity.class);
        intent.putExtra(NUMBER_KEY, number);
        startActivity(intent);
    }

    protected void onPause()
    {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(NUMBER_KEY, number);
        editor.commit();
    }
}
