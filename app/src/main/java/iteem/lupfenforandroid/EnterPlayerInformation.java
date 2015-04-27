package iteem.lupfenforandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EnterPlayerInformation extends ActionBarActivity {
    public final static String PLAYER_NAME = "iteem.lupfenforandroid.PLAYER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_player_information);

        Intent intent = getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_player_information, menu);
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

    public void sendResult(View v) {
        Intent result = new Intent("iteem.lupfenforandroid.RESULT_PLAYER_NAME");
        EditText playerName = (EditText) findViewById(R.id.player_name);
        String message = playerName.getText().toString();
        result.putExtra(PLAYER_NAME, message);
        setResult(Activity.RESULT_OK, result);
        finish();
    }
}
