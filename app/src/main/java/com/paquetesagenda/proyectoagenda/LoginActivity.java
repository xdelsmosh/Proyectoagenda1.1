package com.paquetesagenda.proyectoagenda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btn;
    Button btnregistro;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextTextusuario);
        edPassword = findViewById(R.id.editTextTextPassword);
        btn = findViewById(R.id.buttonlog);
        btnregistro = findViewById(R.id.buttonVistaRegistro);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(),"Proyectoagenda",null,1);
                if (usuario.length()==0 || password.length()==0){

                    Toast.makeText(getApplicationContext(),"Contraseña o usuario incorrecto",Toast.LENGTH_SHORT).show();
                }else {
                    if (db.login(usuario,password)==1){
                        Toast.makeText(getApplicationContext(),"Login exitoso",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("usuario",usuario);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(),"Contraseña o usuario incorrecto",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });



        Button Huella = findViewById(R.id.Huella);
        Huella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                        .setTitle("Verifique Porfavor ")
                        .setDescription("Es necesaria autentificacion")
                        .setNegativeButtonText("Cancelar")
                        .build();

                getPrompt().authenticate(promptInfo);
            }
        });

    }



    private BiometricPrompt getPrompt(){
        Executor executor = ContextCompat.getMainExecutor(this);
        BiometricPrompt.AuthenticationCallback callback = new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                notificarusuario(errString.toString());
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                notificarusuario("Login exitoso");
                Intent intent = new Intent(LoginActivity.this,  HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                notificarusuario("Autentificacion Fallo");
            }
        };
        BiometricPrompt biometricPrompt = new BiometricPrompt(this,executor,callback);
        return  biometricPrompt;
    }

    private void  notificarusuario(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}