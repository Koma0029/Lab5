package com.example.lab_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Komal Preet
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /** This holds the text at the centre of the screen*/
    private TextView tv = null;

    /** This holds the password entered by the user*/
    private EditText et = null;

    /** This holds the button at the bottom of screen*/
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(clk ->{
            String password= et.getText().toString();
            boolean isValidPassword= checkPasswordComplexity( password );

            if (isValidPassword) {
                // Password meets the requirements
                tv.setText("Your password meets the requirements");
            } else {
                // Password does not meet the requirements
                tv.setText("You shall not pass!");
            }
        });
    }

    /**
     * Validates the password and displays appropriate messages.
     *
     * @param password The password to validate.
     * @return Returns true if the password meets all requirements, false otherwise.
     */
    private boolean checkPasswordComplexity(String password) {
        boolean foundUpperCase = false;
        boolean foundLowerCase = false;
        boolean foundNumber = false;
        boolean foundSpecial = false;

        // Iterate over each character in the password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        // Check each requirement and show a Toast message accordingly
        if (!foundUpperCase) {
            showToast("Your password does not have an upper case letter");
            return false;
        } else if (!foundSpecial) {
            showToast("Your password does not have a special symbol");
            return false;
        } else if (!foundLowerCase) {
            showToast("Your password does not have a lower case letter");
            return false;
        } else if (!foundNumber) {
            showToast("Your password does not have a digit");
            return false;
        }

        //  all requirements are met
        return true;
    }

    /**
     * Displays a toast message.
     *
     * @param message The message to display.
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Checks if a character is a special symbol (#$%^&*!@?).
     *
     * @param c The character to check.
     * @return true if the character is a special symbol, false otherwise.
     */
    private boolean isSpecialCharacter(char c) {
        switch(c){
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }
}