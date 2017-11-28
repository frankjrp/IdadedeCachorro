package idadedecachorro.cursoandroid.com.idadedecachorro;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText digitaIdade;
    private Button calculaIdadeCachorro;
    private TextView verIdade;
    private AlertDialog aviso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        digitaIdade = findViewById(R.id.editText);
        calculaIdadeCachorro = findViewById(R.id.btn_descobrir);
        verIdade = findViewById(R.id.textView2);

        calculaIdadeCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperar o que foi digitado
                String textoDigitado = digitaIdade.getText().toString();

                if (textoDigitado.isEmpty()) {
                    verIdade.setText("");

                    Toast.makeText(MainActivity.this, "Digite a idade do cachorro.", Toast.LENGTH_LONG).show();
                } else {

                    int valorDigitado = Integer.parseInt(textoDigitado);
                    int resultadoFinal = valorDigitado * 7;

                    verIdade.setText(String.valueOf(resultadoFinal) + " anos humanos. ");
                }


            }
        });

        digitaIdade.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (digitaIdade.getText().toString().isEmpty()){
                    verIdade.setText("");
                }else{
                    calculaIdadeCachorro.callOnClick();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    //private AlertDialog aviso;

    private void avisoIdade() {
        //Cria o gerador do AlertDialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Aviso");
        //define a mensagem
        builder.setMessage("Digite a idade do cachorro.");
        //define um botão como positivo
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                digitaIdade.requestFocus();
            }
        });

        //cria o AlertDialog
        aviso = builder.create();
        //Exibe
        aviso.show();
    }


}
