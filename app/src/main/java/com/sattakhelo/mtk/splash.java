package com.sattakhelo.mtk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;


public class splash extends AppCompatActivity {

    String url;
    SharedPreferences preferences;
    String VersionCode = String.valueOf(1.4);
    TextView versioncode;
    String url1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        url = constant.prefix + getString(R.string.getconfig);
        url1 = "https://playboss777.com/admin/ax_validversion.php";
        versioncode = findViewById(R.id.versioncode);
        versioncode.setText(VersionCode);

        preferences = getSharedPreferences(constant.prefs,MODE_PRIVATE);

        versionchekinginitial();


    }

    public void versionchekinginitial() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        final StringRequest postRequest = new StringRequest(Request.Method.POST, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject1 = new JSONObject(response);
                            String responsevCode = jsonObject1.getString("version");
                            Log.d("Version",""+jsonObject1.getString("version"));
                            if(VersionCode.equals(responsevCode)) {
                                apicall();

                            }else{
                                versioncheking();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();

                        Toast.makeText(splash.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }



    private void versioncheking() {

        // Create the object of AlertDialog Builder class
        AlertDialog.Builder builder = new AlertDialog.Builder(splash.this);

        // Set the message show for the Alert time
        builder.setMessage("New version detected, update your app and continue playing..");

        // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
        builder.setPositiveButton("DOWNLOAD NEW VERSION", (DialogInterface.OnClickListener) (dialog, which) -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://playboss777.com/playboss777.apk")));

        });


        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }


    private void apicall() {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                     Log.d("adz","xyz"+response);
                        try {
                            JSONObject jsonObject1 = new JSONObject(response);
                            SharedPreferences.Editor editor = getSharedPreferences(constant.prefs, MODE_PRIVATE).edit();

                            JSONArray jsonArray = jsonObject1.getJSONArray("data");
                            for (int a= 0; jsonArray.length()>a;a++)
                            {
                                JSONObject jsonObject = jsonArray.getJSONObject(a);
                                editor.putString(jsonObject.getString("data_key"), jsonObject.getString("data")).apply();
                                Log.e(jsonObject.getString("data_key"),jsonObject.getString("data"));
                            }


                            if (preferences.getString("all",null) != null && preferences.getString("result",null) != null) {
                                if (getSharedPreferences(constant.prefs,MODE_PRIVATE).getString("mobile",null) != null)
                                {

                                    Intent in = new Intent(getApplicationContext(), PinActivity.class);
                                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(in);
                                    finish();
                                }
                                else {
                                    Intent in = new Intent(getApplicationContext(), login.class);
                                    in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(in);
                                    finish();
                                }
                            } else {

                                FirebaseMessaging.getInstance().subscribeToTopic("all")
                                        .addOnCompleteListener(task -> {
                                            preferences.edit().putString("all","1").apply();
                                            FirebaseMessaging.getInstance().subscribeToTopic("result")
                                                    .addOnCompleteListener(task2 -> {
                                                        preferences.edit().putString("result","1").apply();

                                                        Log.e("all",preferences.getString("all","0"));
                                                        Log.e("result",preferences.getString("result","0"));

                                                        if (getSharedPreferences(constant.prefs,MODE_PRIVATE).getString("mobile",null) != null)
                                                        {
                                                            Intent in = new Intent(getApplicationContext(), PinActivity.class);
                                                            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(in);
                                                            finish();
                                                        }
                                                        else {

                                                            Intent in = new Intent(getApplicationContext(), login.class);
                                                            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                            startActivity(in);
                                                            finish();
                                                        }

                                                    });
                                        });
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();

                        Toast.makeText(splash.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }



}
