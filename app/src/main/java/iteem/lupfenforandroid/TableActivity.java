package iteem.lupfenforandroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class TableActivity extends ActionBarActivity {
    Deck deck;
    Table table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Intent intent = getIntent();

        TextView activePlayerName = (TextView) findViewById(R.id.active_player_name);
        Player activePlayer = ActivePlayer.getInstance();
        activePlayerName.setText(activePlayer.getName());

        deck = Deck.createDeck();
        table = new Table(deck);
        table.addPlayer(activePlayer);
        table.addPlayer(new Player());
        table.addPlayer(new Player());
        table.startRound();
        table.preLupf();
        table.prePlay();
        table.playRound();
        table.finishRound();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_table, menu);
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

    public Card playCard(View v) {
        System.out.println(v.toString());
        return null;
    }
}
