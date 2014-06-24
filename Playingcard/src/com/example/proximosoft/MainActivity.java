package com.example.proximosoft;

import com.example.proximosoft.card.Card;
import com.example.proximosoft.card.Deck;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	Deck myDeck;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Create the basic Deck
		myDeck = new Deck();

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		final TextView lastCard = (TextView) findViewById(R.id.card_drawn);
		Button drawCard = (Button) findViewById(R.id.draw_card);
		drawCard.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (myDeck.haveCardAvailable()) {
					Card myCard = myDeck.drawCard();
					lastCard.setText(myCard.toString());
				} else {
					lastCard.setText("No cards left");
				}
			}
		});
		Button shuffleDeck = (Button) findViewById(R.id.shuffle_deck);
		shuffleDeck.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				myDeck.shuffle();
				lastCard.setText(R.string.card_hint);
			}
		});
	}

}
