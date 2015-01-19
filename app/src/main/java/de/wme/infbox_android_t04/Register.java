package de.wme.infbox_android_t04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.TextUtils;
import android.view.HapticFeedbackConstants;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    public void buttonRegister(View v) {
        // Haptic feedback
        v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);

        // validate email
        EditText input = (EditText)findViewById(R.id.editText2);
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);

        if(isValidEmail(input.getText()) && checkBox.isChecked()) {
            startActivity(new Intent(this, Login.class));
            return;
        }
        else if (checkBox.isChecked()) {
            Toast toast = Toast.makeText(this, "Email ungültig!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        else {
            Toast toast = Toast.makeText(this, "Nutzungsbedingungen aktzeptieren!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                // Haptic feedback
                View view = findViewById(android.R.id.home);
                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
