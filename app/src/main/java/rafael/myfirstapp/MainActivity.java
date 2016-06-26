package rafael.myfirstapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button);
        if (b != null){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder b1 = new AlertDialog.Builder(getParent());
                    b1.setTitle("Mesagem");
                    b1.setMessage("Olá, Mainha! Tudo bem? :)");
                    b1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            AlertDialog.Builder builder = new AlertDialog.Builder(getParent().getParent());
                            builder.setMessage("Que legal! Fico feliz em saber disso!");
                            builder.setPositiveButton("Concluído", null);
                            AlertDialog okDialog = builder.create();
                            okDialog.show();
                        }
                    });
                    AlertDialog dialog = b1.create();
                    dialog.show();
                }
            });
        } else {

            /*Snackbar.make(findViewById(android.R.id.content), "Had a snack at Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Undo", mOnClickListener)
                    .setActionTextColor(Color.RED)
                    .show();*/
        }
    }
}
