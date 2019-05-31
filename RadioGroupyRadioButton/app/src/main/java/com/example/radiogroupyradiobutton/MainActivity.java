package com.example.radiogroupyradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private Button btAceptar;
    private RadioButton rbMultiplicar, rbDividir;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText)findViewById(R.id.etNum1);
        etNum2 = (EditText)findViewById(R.id.etNum2);
        btAceptar = (Button)findViewById(R.id.btAceptar);
        rbMultiplicar = (RadioButton)findViewById(R.id.rbMultiplicar);
        rbDividir = (RadioButton)findViewById(R.id.rbDividir);
        tvResultado = (TextView)findViewById(R.id.tvResultado);

        btAceptar.setOnClickListener(myhandler1);
    }

    View.OnClickListener myhandler1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            operacion();
        }
    };

    public void operacion(){
        //Obtenemos el texto introducido
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();
        //Convertimos a numero
        int numero1 = Integer.parseInt(num1);
        int numero2 = Integer.parseInt(num2);
        //Controlamos cada caso (Multiplicar, dividir y cualquier otra cosa)
        if(rbMultiplicar.isChecked()){
            //Realizamos la operacion
            int multiplicacion = numero1*numero2;
            //Convertir un numero a Texto
             String multi_resultado = String.valueOf(multiplicacion);
            tvResultado.setText(multi_resultado);
        }else if(rbDividir.isChecked()){
            //Realizamos la operacion
            int division = numero1/numero2;
            //Convertir un numero a Texto
            String divi_resultado = String.valueOf(division);
            tvResultado.setText(divi_resultado);
        }else{
            tvResultado.setText("Desbes escoger una opción");
        }
    }
}
