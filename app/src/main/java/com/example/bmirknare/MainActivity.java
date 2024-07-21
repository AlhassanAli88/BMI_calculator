package com.example.bmirknare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText_vikt, editText_längd;
    Button kör_knappen;

    TextView textView_resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_vikt = findViewById(R.id.vikt_input);
        editText_längd = findViewById(R.id.längd_input);
        textView_resultat = findViewById(R.id.resultat_text);
        kör_knappen = findViewById(R.id.my_btn);
        kör_knappen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vikt, längd;
                double vikten, längden;
                vikt = editText_vikt.getText().toString();
                längd = editText_längd.getText().toString();
                vikten = Double.parseDouble(vikt);
                längden = Double.parseDouble(längd);

                double bmi_index;
                bmi_index = vikten / (längden * längden);
                double bmi_resultatet = avrunda(bmi_index,1);
                // these two lines of code should be inserted into the if statement.
                String bmi_string = Double.toString(bmi_resultatet);
                if (bmi_resultatet <= 0){

                    textView_resultat.setText("Du har anget ogiltiga värden försök igen");

                }

                else if (bmi_resultatet <18.5){
                    System.out.println("Du har undervikt");
                    textView_resultat.setText( "Ditt BMI index är " + bmi_string + ". Du har undervikt");

                }
                else if (18.5 <= bmi_resultatet && bmi_resultatet < 25){

                    textView_resultat.setText( "Ditt BMI index är " + bmi_string + ". Du har normal vikt");


                } else if (25 <= bmi_resultatet && bmi_resultatet < 30) {

                    textView_resultat.setText( "Ditt BMI index är " + bmi_string + ". Du har övervikt");



                } else if (30 <= bmi_resultatet && bmi_resultatet <40) {

                    textView_resultat.setText( "Ditt BMI index är " + bmi_string + ". Du har svår övervikt");


                } else if (40<= bmi_resultatet) {
                    textView_resultat.setText( "Ditt BMI index är " + bmi_string + ". Du har extremt svår övervikt");

                }


            }
        });


    }


    public double avrunda(double värdet, int antal_decimaler) {

        int faktor = (int) Math.pow(10, antal_decimaler);
        double tillfälligt_värde1 = faktor * värdet;
        double tillfälligt_värde2 = Math.round(tillfälligt_värde1);
        double slutligt_värde = tillfälligt_värde2 / faktor;
        return slutligt_värde;

    }
}