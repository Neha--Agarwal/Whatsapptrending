package com.neha.whatsapptrending;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Store extends ActionBarActivity {
   // private WebView browser;
    ProgressDialog mProgress;
    WebView mWeb;
    String field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWeb = (WebView) findViewById(R.id.webview);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            field = extras.getString("url");}
        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        // the init state of progress dialog
        mProgress = ProgressDialog.show(this, "Loading...", "Please wait for a moment...");
        mProgress.setCancelable(true);

        // Add a WebViewClient, which actually handles loading data from web
        mWeb.setWebViewClient(new WebViewClient() {

            // Load the url
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            // When finish loading page
            public void onPageFinished(WebView view, String url) {
                if (mProgress.isShowing()) {
                    mProgress.dismiss();
                }
            }
        });

        // Set url for webview to load
        mWeb.loadUrl(field);
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
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch(keyCode)
            {
                case KeyEvent.KEYCODE_BACK:
                    if(mWeb.canGoBack()){
                        mWeb.goBack();
                    }else{
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}