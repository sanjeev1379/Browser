package com.example.beowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OurViewClient extends WebViewClient {
	
	public boolean ShouldOverrideUrlLoading(WebView v , String url){
		v.loadUrl(url);
		return true;
		
	}

}
