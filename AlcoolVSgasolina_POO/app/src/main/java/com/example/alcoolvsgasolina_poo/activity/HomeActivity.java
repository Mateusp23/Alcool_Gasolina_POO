package com.example.alcoolvsgasolina_poo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.alcoolvsgasolina_poo.R;
import com.google.android.material.textfield.TextInputEditText;

public class HomeActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina   = findViewById(R.id.editPrecoGasolina);
        textResultado       = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        String traducaoCampos = getResources().getString(R.string.traducaoCampos);
        String traducaoAlcool = getResources().getString(R.string.traducaoAlcool);
        String traducaoGasosa = getResources().getString(R.string.traducaoGasosa);

        if( camposValidados) {
            Double valorAlcool = Double.parseDouble( precoAlcool );
            Double valorGasolina = Double.parseDouble( precoGasolina );

            Double resultado = valorAlcool / valorGasolina;

            if( resultado >= 0.7){
                textResultado.setText(traducaoGasosa);
            } else {
                textResultado.setText(traducaoAlcool);
            }
        } else {
            textResultado.setText(traducaoCampos);
        }
    }

    public Boolean validarCampos ( String pAlcool, String pGasolina) {

        Boolean inputConferido = true;

        if(pAlcool == null || pAlcool.equals("")){
            inputConferido = false;
        } else if ( pGasolina == null || pGasolina.equals("")){
            inputConferido = false;
        }

        return inputConferido;
    }
}
