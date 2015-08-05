package com.neha.whatsapptrending;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;


public class MainActivity extends ActionBarActivity {

   // String url="http://google.com/";
    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i= (new Intent(this, Store.class));
        i.putExtra( "url", "http://whatsapptrending.com/");
        startActivity(i);
        finish();
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
        if (id == R.id.submit)
            {
                Intent i= (new Intent(this, Store.class));
                i.putExtra("url", "http://whatsapptrending.com/submit-images");
                startActivity(i);
            }
          else if (id == R.id.register){
                {  Intent i= (new Intent(this, Store.class));
                    i.putExtra("url", "http://whatsapptrending.com/wp-login.php?action=register");
                    startActivity(i);
                                   }
        }
else if(id==R.id.exit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
