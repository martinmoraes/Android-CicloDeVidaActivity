package br.com.earcadia.ciclodevida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


/*
"http://www.ibm.com/developerworks/br/library/j-mobileforthemasses3/"

 */
public class MainActivity extends AppCompatActivity {
    String testeDeVida = "Valor original";
    int contator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log("onCreate");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        log("onSaveInstanceState - " + testeDeVida);
        outState.putString("VALOR", testeDeVida);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CheckBox estadoCheckBox = (CheckBox) findViewById(R.id.estadoCheckBox);
        if (estadoCheckBox.isChecked())
            testeDeVida = savedInstanceState.getString("VALOR");
        log("onRestoreInstanceState - " + testeDeVida);
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    public void abre(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void checaEstado(View view){
        CheckBox estadoCheckBox = (CheckBox) findViewById(R.id.estadoCheckBox);
        if(estadoCheckBox.isChecked()){
            TextView estadoTextView = (TextView) findViewById(R.id.estadoTextView);
            TextView principalTextView = (TextView) findViewById(R.id.principalTextView);
            testeDeVida = principalTextView.getText().toString();
            estadoTextView.setText(testeDeVida);
        }
    }

    public void log(String s){
        Log.d("MEUAPP", contator +":"+ s +" - "+ this.toString());
        contator++;
    }

}
