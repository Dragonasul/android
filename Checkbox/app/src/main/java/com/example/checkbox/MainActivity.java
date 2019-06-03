package com.example.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private CheckBox cbSumar, cbRestar;
    private Button btAceptar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText)findViewById(R.id.etNum1);
        etNum2 = (EditText)findViewById(R.id.etNum2);
        cbSumar = (CheckBox)findViewById(R.id.cbSumar);
        cbRestar = (CheckBox)findViewById(R.id.cbRestar);
        btAceptar = (Button)findViewById(R.id.btAceptar);
        tvResultado = (TextView)findViewById(R.id.tvResultado);

        btAceptar.setOnClickListener(handler1);
    }

    View.OnClickListener handler1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            operacion();
        }
    };

    public void operacion(){
        //Obtenemos el texto introducido
        String num1 = etNum1.getText().toString();
        String num2 = etNum2.getText().toString();
        //Convertimos el texto a numero
        int numero1 = Integer.parseInt(num1);
        int numero2 = Integer.parseInt(num2);

        if(cbSumar.isChecked()==true && cbRestar.isChecked()==true){
            int suma = numero1+numero2;
            int resta = numero1-numero2;
            String resultado_suma = String.valueOf(suma);
            String resultado_resta = String.valueOf(resta);
            tvResultado.setText("Resultado suma: "+resultado_suma+" Resultado resta: "+resultado_resta);
        }else if(cbRestar.isChecked()==true){
            int resta = numero1-numero2;
            //Convertimos la variable resta a String para poder visualizar
            String resultado = String.valueOf(resta);
            tvResultado.setText(resultado);
        }else if(cbSumar.isChecked()==true){
            int suma = numero1+numero2;
            //Convertimos la variable suma a String para poder visualizar
            String resultado = String.valueOf(suma);
            tvResultado.setText(resultado);
        }else{
            tvResultado.setText("Tienes que elegir un checkbox");
        }

    }


}
