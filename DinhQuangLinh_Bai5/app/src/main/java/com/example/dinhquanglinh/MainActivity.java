package com.example.dinhquanglinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

public class MainActivity extends AppCompatActivity {

    EditText et_Name, et_Email, et_Passsword, et_MobilePhone;
    Button check;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])" +
                "(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+" +
                "=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";

        awesomeValidation = new AwesomeValidation(BASIC);


        awesomeValidation.addValidation(MainActivity.this,
                R.id.et_Name, "[a-zA-Z\\s]+", R.string.err_name);
        awesomeValidation.addValidation(MainActivity.this,
                R.id.et_MobilePhone, RegexTemplate.TELEPHONE, R.string.err_tel);
        awesomeValidation.addValidation(MainActivity.this,
                R.id.et_Email, Patterns.EMAIL_ADDRESS, R.string.err_email);
        awesomeValidation.addValidation(MainActivity.this,
                R.id.et_Password, regexPassword, R.string.err_password);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!awesomeValidation.validate()){
                    String name = et_Name.getText().toString();
                    String email = et_Email.getText().toString();
                    String password = et_Passsword.getText().toString();
                    String numberPhone = et_MobilePhone.getText().toString();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "Everything is Fine", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void AnhXa(){
        et_Name = findViewById(R.id.et_Name);
        et_Email = findViewById(R.id.et_Email);
        et_Passsword = findViewById(R.id.et_Password);
        et_MobilePhone = findViewById(R.id.et_MobilePhone);

        check = findViewById(R.id.bt_Check);
    }

}