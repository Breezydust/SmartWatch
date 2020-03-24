package com.example.balib.mybeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class trackSteps extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracksteps);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about:
                Intent intent1 = new Intent(this, About.class);
                this.startActivity(intent1);
                return true;
            case R.id.Setting:
                Intent intent2 = new Intent(this, settings.class);
                this.startActivity(intent2);
                return true;
            case R.id.SignOut:
                Intent intent3 = new Intent(this, MainActivity.class);
                this.startActivity(intent3);
                return true;
            case R.id.Quit:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(trackSteps.this, home.class);
        startActivity(intent);
    }
    public void setV(View v) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Step Goal set",
                Toast.LENGTH_SHORT);

        toast.show();
    }
}
