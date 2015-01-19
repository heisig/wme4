package de.wme.infbox_android_t04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.HapticFeedbackConstants;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    public void buttonLogin(View v) {
        // Haptic feedback
        v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        // wechsel zur Einzelansicht Activity
        startActivity(new Intent(Login.this, Items.class));
    }

    public void buttonRegister(View v) {
        // Haptic feedback
        v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        // wechsel zur Register Activity
        startActivity(new Intent(Login.this, Register.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case  R.id.action_about:
                startActivity(new Intent(Login.this, Info.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
