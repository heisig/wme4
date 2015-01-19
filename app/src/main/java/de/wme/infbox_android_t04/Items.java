package de.wme.infbox_android_t04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;


public class Items extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    public void buttonDetails(View v) {
        // wechsel zur Details Activity
        startActivity(new Intent(Items.this, Details.class));
    }

    // TODO:
    // Das müssen wir abholen und in die Liste reinpacken
    // http://wme.lehre.imld.de:8080/wme14-15/api/users/1/items

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
}
