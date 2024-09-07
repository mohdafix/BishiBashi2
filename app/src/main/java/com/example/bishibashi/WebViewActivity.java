package com.example.bishibashi;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private FrameLayout fullScreenContainer;
    private View customView;
    private WebChromeClient.CustomViewCallback customViewCallback;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webView);
        fullScreenContainer = findViewById(R.id.fullscreen_container);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // Additional actions after the page loads
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
                // If a view already exists, hide it first
                if (customView != null) {
                    onHideCustomView();
                }

                // Switch to fullscreen
                fullScreenContainer.setVisibility(View.VISIBLE);
                fullScreenContainer.addView(view);
                customView = view;
                customViewCallback = callback;
            }

            @Override
            public void onHideCustomView() {
                super.onHideCustomView();
                // Exit fullscreen
                if (customView != null) {
                    fullScreenContainer.removeView(customView);
                    customView = null;
                    fullScreenContainer.setVisibility(View.GONE);
                    customViewCallback.onCustomViewHidden();
                }
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://eskierahailey.github.io/bishibashi-entertainment/login.html");
        webView.clearCache(true);
        webView.clearHistory();
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        fullScreenContainer = findViewById(R.id.fullscreen_container);

    }
}
