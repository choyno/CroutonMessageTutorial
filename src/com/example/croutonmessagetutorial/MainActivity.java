package com.example.croutonmessagetutorial;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int btnList[] = {R.id.btn_1, R.id.btn_2, R.id.btn_3  };
		for (int id : btnList) {
			View v = (View) findViewById(id);
			v.setOnClickListener(this);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_1:
			Toast.makeText(this, "sample1", Toast.LENGTH_SHORT).show();
			Crouton.showText(this, R.string.simple_text_message, Style.INFO);
			break;
		case R.id.btn_2:
		    Configuration croutonConfiguration = new Configuration.Builder().setDuration(2500).build();
			Style style = new Style.Builder()
					.setBackgroundColorValue(Color.RED)
					.setGravity(Gravity.CENTER_HORIZONTAL)
					.setConfiguration(croutonConfiguration)
					.setHeight(150)
					.setTextColorValue(Color.parseColor("#323a2c")).build();
			Crouton.showText(this, R.string.styled_text_message, style);
			Toast.makeText(this, "sample2", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn_3:
			View customView = getLayoutInflater().inflate(R.layout.custom_crouton_layout, null);
			Crouton.show(this, customView);
			Toast.makeText(this, "sample3", Toast.LENGTH_SHORT).show();
			break;
		}
		
	}

}
