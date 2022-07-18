package com.example.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.actividad2.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Usuario usuario = new Usuario();
        EditText txt_nombre = binding.txtNombre;
        EditText txt_contrasenia = binding.txtClave;
        EditText txt_repetirclave = binding.txtRepclave;
        Button btn_ingresar = binding.btnGuardar;
        TextView resultado = binding.txtValclave;
        resultado.setVisibility(View.INVISIBLE);




        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txt_nombre.getText().toString();
                String clave = txt_contrasenia.getText().toString();
                String repclave = txt_repetirclave.getText().toString();

                if (usuario.ValidarClave(clave,repclave,resultado)==true){


                        String nickname = binding.txtNombre.getText().toString();
                        String usuario = binding.txtNombre.getText().toString();
                        String contrasenia = binding.txtClave.getText().toString();
                        System.out.println(contrasenia);
                        abrirActivityDetalle(nickname,usuario,contrasenia);









                }else{
                    Context context = MainActivity.this;
                    CharSequence text = "La contraseña debe ser minimo 5 caracteres y las claves deben coincidir";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }





            }
        });
    }
    private void abrirActivityDetalle(String nic, String us, String cont){
        Intent intent = new Intent(this,ActivityInformacion.class);

        Usuario usuario1 = new Usuario(nic,us,cont);



        intent.putExtra(ActivityInformacion.USUARIO_KEY,usuario1);
        intent.putExtra("nickname",nic);
        intent.putExtra("contra",cont);

        System.out.println(cont);
        startActivity(intent);

    }
}