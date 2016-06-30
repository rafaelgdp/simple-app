package rafael.myfirstapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    String name = "pessoa";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toolbar actionBar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(actionBar);

        getActionBar().setIcon(R.mipmap.happy_yellow);
        getActionBar().setTitle("by Rafael ^_^");
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        */

        final EditText nameEditText = (EditText) findViewById(R.id.nameEditText);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = nameEditText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        };

        nameEditText.addTextChangedListener(textWatcher);

        Button showHRU = (Button) findViewById(R.id.greetingButton);
        if (showHRU != null){
            showHRU.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mainBuilder = new AlertDialog.Builder(MainActivity.this);
                    mainBuilder.setTitle("Mensagem");
                    String currentName = name.trim().length() < 3 ? "pessoa" : name.trim();
                    mainBuilder.setMessage("Olá, " + currentName + "! Tudo bem? :)")
                        .setPositiveButton("Sim! :)", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();

                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder
                                    .setMessage("Fico feliz em saber disso!")
                                    .setTitle("Que legal!")
                                    .setNegativeButton("Fechar", null);
                                AlertDialog okDialog = builder.create();
                                okDialog.show();
                            }
                        });
                    mainBuilder.setNegativeButton("Não. :(", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            final AlertDialog.Builder negativeBuilder = new AlertDialog.Builder(MainActivity.this);
                            negativeBuilder
                                    .setTitle("Que pena! :/")
                                    .setMessage("Espero que você melhore! :(")
                                    .setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });
                            AlertDialog negativeDialog = negativeBuilder.create();
                            negativeDialog.show();
                        }
                    });
                    AlertDialog mainDialog = mainBuilder.create();
                    mainDialog.show();
                }
            });
        }

        Button randomMessageButton = (Button) findViewById(R.id.randomMessageButton);
        final Messages randomMessage = new Messages();
        randomMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackBarMessage(randomMessage.getRandomMessage());
            }
        });

    }

    private void showSnackBarMessage(String message){
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
                .setActionTextColor(Color.RED)
                .show();
    }
}
