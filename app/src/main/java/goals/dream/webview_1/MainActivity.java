package goals.dream.webview_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.id.edit;
import static goals.dream.webview_1.R.id.text_url;
import static goals.dream.webview_1.R.id.text_username;


public class MainActivity extends AppCompatActivity {

    private WebView wv1;
    EditText my_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv1=(WebView)findViewById(R.id.my_webview);
        wv1.setWebViewClient(new MyBrowser());
        wv1.clearCache(true);
        ///!@#$%
        wv1.setWebChromeClient(new WebChromeClient());

//////////-----------------
        wv1.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                wv1.loadUrl(
                        "javascript:(function() { " +
                                //"document.getElementById(\"click_id\").value = \"It works\";" +
                               "var sss = document.querySelectorAll('input[value=\"Click\"]');" +
                               //"alert(sss[0].value);" +
                                "sss[0].click();" +
                                "sss[0].value = \"niceee\";" +
                                //"alert(ss);" +
                                "})()");


               // document.querySelectorAll("input[value=Click]");

               // "javascript:(function() { " +
               //         "var element = document.getElementById('hplogo');"
               //         + "element.parentNode.removeChild(element);" +
               //         "alert(0);" +
               //         "})()");

                //var eee = document.querySelectorAll("a[href='http://domain.com']");
               // "javascript:(function() { " +
             //           "var x = document.getElementsByTagName(\"LI\");" +
               //         "document.getElementById(\"demo\").innerHTML = x[2].innerHTML;" +
               //         "alert(x);"+
               //         "})()");

               // "javascript:(function() { " +
                        //"for (const a of document.querySelectorAll(\"a\")) {" +
                        //"if (a.textContent.includes(\"post\")){"+
                //        "alert(0);}" +
                //        "})()");




            }
        });

    /*
     * you could give it an id then click it
     * or you could create a link then click it self
     * does the browser actually know if you clicked a link ?
     * how do you click a submit button... maybe create a submit button give it an id then click it
     */

    /*
     * When you want that Keybord not shown untill user clicks on one of the EditText Field.
     */
        EditText userId;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
    //==========================
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


    }





    //button clicks------------------------------------------------------------------
    public void buttonOnClick(View view) {
        int the_id = view.getId();
        if (the_id == R.id.b1) {
            //Toast.makeText(this, "but_1", Toast.LENGTH_SHORT).show();

            //String url = text_url.getText().toString();
            // get EditText by id
            //(EditText) inputTxt = (EditText) findViewById(R.id.input);

// Store EditText in Variable
//browser.loadUrl("http://www.tutorialspoint.com");
            //String my_url = "https://www.google.com";
            my_edit_text = (EditText)findViewById(R.id.text_url);
            String my_url = my_edit_text.getText().toString();

            Toast.makeText(this, my_url, Toast.LENGTH_SHORT).show();

            wv1.getSettings().setLoadsImagesAutomatically(true);
            wv1.getSettings().setJavaScriptEnabled(true);
            wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            wv1.loadUrl(my_url);


        }
        if (the_id == R.id.b2) {
            my_edit_text = (EditText)findViewById(R.id.text_url);
            String fff = my_edit_text.getText().toString();
            Toast.makeText(this, "but_2 ="+fff, Toast.LENGTH_SHORT).show();

            wv1.getSettings().setLoadsImagesAutomatically(true);
            wv1.getSettings().setJavaScriptEnabled(true);
            wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

            //temporarily using username for test
            my_edit_text = (EditText)findViewById(R.id.text_username);
            String my_url = my_edit_text.getText().toString();
            wv1.loadUrl(my_url);

            //String fff = text_url_x.getText().toString();

        }
        //if (the_id == R.id.b3) {
        //    Toast.makeText(this, String.valueOf(the_id), Toast.LENGTH_SHORT).show();
        //}
    }




}
