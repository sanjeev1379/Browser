package com.example.beowser;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;


public class Browser extends Activity implements OnClickListener {
  
	
	AutoCompleteTextView url;
	String[] search ={
			"google",
			"facebook",
			"youtube",
			"amozan",
			"flipcart",
			"linkedin",
			"gmail",
			"googletalk",
			"aku",
			"bcebhagalpur"	
	};
	WebView ourBrow;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);
        
        url = (AutoCompleteTextView) findViewById(R.id.editText_url);
        
        @SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, search);
        url.setThreshold(1);
        url.setAdapter(adapter);
        
        ourBrow = (WebView) findViewById(R.id.webView_url);
        ourBrow.getSettings().setJavaScriptEnabled(true);
        ourBrow.getSettings().setLoadWithOverviewMode(true);
        ourBrow.getSettings().setUseWideViewPort(true);
        ourBrow.setWebViewClient(new OurViewClient());
        
        try{
        	ourBrow.loadUrl("http://www.google.com");
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        Button go = (Button) findViewById(R.id.go);
        Button back = (Button) findViewById(R.id.back);
        Button forward = (Button) findViewById(R.id.forward);
       // Button refresh = (Button) findViewById(R.id.refresh);
        
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
       // refresh.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.go:
			String website = url.getText().toString();
			ourBrow.loadUrl("http://www."+website+".com");
			break;
			
		case R.id.back:
			if(ourBrow.canGoBack())
				ourBrow.goBack();
			break;
			
		case R.id.forward:
			if(ourBrow.canGoForward())
				ourBrow.goForward();
			break;
			
		/*case R.id.refresh:
			ourBrow.reload();
			break;*/
		}
		
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.browser, menu);
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


	
}
