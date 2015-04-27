package iteem.lupfenforandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button joinButton;
    Button hostAndPlayButton;
    Button hostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link the buttons to the corresponding actions
        joinButton = (Button) findViewById(R.id.join_button);
        // joinButton.setOnClickListener(this);
        hostAndPlayButton = (Button) findViewById(R.id.host_play_button);
        // hostAndPlayButton.setOnClickListener(this);
        hostButton = (Button) findViewById(R.id.host_button);
        // hostButton.setOnClickListener(this);
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

    // implementing an interface and adding a listener to the button
    @Override
    public void onClick(View v) {
        if(v==findViewById(R.id.join_button)) {
            System.out.println("Join");
        }
    }

    public void joinGame(View v) {
        System.out.println("Join");
        Intent intent = new Intent(this, EnterPlayerInformation.class);
        startActivity(intent);
    }

    public void hostAndJoinGame(View v) {
        System.out.println("Hosting and joining");
    }

    // direct linking from the xml - fast but not optimal for maintenance?
    public void hostGame(View v) {
        System.out.println("Hosting");
    }

}
