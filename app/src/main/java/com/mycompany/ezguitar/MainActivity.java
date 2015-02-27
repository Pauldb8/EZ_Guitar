package com.mycompany.ezguitar;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.ezguitar.MESSAGE"; //pour passer des
    //intent avec des extras

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*We define the possible values for our age picker */
        NumberPicker np = (NumberPicker) findViewById(R.id.age);
        np.setMaxValue(120);
        np.setMinValue(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText nom = (EditText) findViewById(R.id.name); /*get the input text */
        EditText prenom = (EditText) findViewById(R.id.surname);
        NumberPicker age = (NumberPicker) findViewById(R.id.age);
        String message = "Vous êtes" + nom.getText().toString() + " " + prenom.getText().toString()
                + " et vous avez " + age.getValue() + " ans. Copyrights applied."; //Assigning it to a variable
        intent.putExtra(EXTRA_MESSAGE, message);    //Passing to the intent
        startActivity(intent); //Starting the new activity wit the extras
    }
}
