package com.sattakhelo.mtk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ResetPin extends AppCompatActivity {

    EditText resetpin18;
    protected latobold submit18;
    String hash = "";
    String url;
    SharedPreferences prefs;


    private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";

    private SharedPreferenceManager sharedPrefMgr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpin);

        prefs = getSharedPreferences(constant.prefs,MODE_PRIVATE);
        String Mob = prefs.getString("mobile",null);
        Log.d("sessionmob",""+Mob);


        url = constant.prefix + getString(R.string.reset_pin);



        resetpin18 = findViewById(R.id.resetpin18);



        submit18 = findViewById(R.id.submit18);
        submit18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Pattern PIN_NUMBER = Pattern.compile(" ^[0-9]*$");
//                String pno = resetpin18.getText().toString();


                if (resetpin18.getText().toString().isEmpty()) {
                    resetpin18.setError("Enter valid 4 digit pin number");
                }else{

                    apicall12();
                }
            }
        });
    }

    private static String getRandomString(final int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }


    private void apicall12() {


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject1 = new JSONObject(response);
                            Log.d("resp",""+response);
                            String code = jsonObject1.getString("success");
                            if (code.equals("1")) {
                                Log.d("Enter1","ENTER1");
                                Intent in = new Intent(getApplicationContext(), PinActivity.class);
                                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(in);
                                finish();

                            } else {
                                Toast.makeText(getApplicationContext(), jsonObject1.getString("msg"), Toast.LENGTH_SHORT).show();
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

                        Toast.makeText(ResetPin.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("pin", resetpin18.getText().toString());
                Log.d("sessionpin",""+resetpin18.getText().toString());
                params.put("mobile", prefs.getString("mobile",null));
                Log.d("sessionmob2",""+prefs.getString("mobile",null));
                params.put("session", hash);
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }




}
