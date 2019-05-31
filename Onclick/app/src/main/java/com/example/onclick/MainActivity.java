package com.example.onclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;
    private TextView tvResultado;
    private Button btAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText)findViewById(R.id.etNum1);
        etNum2 = (EditText)findViewById(R.id.etNum2);
        tvResultado = (TextView)findViewById(R.id.tvResultado);
        btAceptar = (Button)findViewById(R.id.btAceptar);
        //Opcion 1
        btAceptar.setOnClickListener(myhandler1);
    }

    //Opcion 1

    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            sumar();
        }
    };

    public void sumar() {
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();
        int numero1 = Integer.parseInt(num1);
        int numero2 = Integer.parseInt(num2);
        int suma = numero1 + numero2;
        String resultado = String.valueOf(suma);
        tvResultado.setText(resultado);
    }


    //Opcion 2
    /*
    public void sumar(View v) {
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();
        int numero1 = Integer.parseInt(num1);
        int numero2 = Integer.parseInt(num2);
        int suma = numero1 + numero2;
        String resultado = String.valueOf(suma);
        tvResultado.setText(resultado);
    }
    */
}
