package com.sattakhelo.mtk;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

public class login extends AppCompatActivity {

    protected ImageView draw;
    protected EditText mobile;
    protected EditText password;
    protected latobold submit1;
    protected TextView create;
    protected TextView forgot;

    ViewDialog progressDialog;
    String url;
    private View colorLine;

    private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";

    String hash = "";
    ActivityResultLauncher<Intent> mStartForResult;

    String name = "", email = "";
    private eczarbold logo;
    private latobold whatsapp;
    private latobold otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_login);
        initViews();
        initView();
        url = constant.prefix + getString(R.string.login);
        hash = getRandomString(30);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, signup.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = constant.getWhatsapp(getApplicationContext());

                Uri uri = Uri.parse(url);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(sendIntent);
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = constant.getWhatsapp(getApplicationContext());

                Uri uri = Uri.parse(url);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(sendIntent);
            }
        });
        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, ForgotPassword.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$");
//                || PASSWORD_PATTERN.matcher(passr).matches()
//                String passr = password.getText().toString();
//                Pattern PHONE = Pattern.compile( "(0|91)?[6-9][0-9]{9}");
//                String phone1 = mobile.getText().toString();


//                || PHONE.matcher(phone1).matches()

                if (mobile.getText().toString().isEmpty()) {
                    mobile.setError("Enter valid mobile number");
                } else if (password.getText().toString().isEmpty()) {
                    password.setError("Enter valid password");
                } else {

                    SharedPreferences.Editor editor = getSharedPreferences(constant.prefs, MODE_PRIVATE).edit();
                    editor.putString("session", hash).apply();

                    apicall();
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

    private void apicall() {

        progressDialog = new ViewDialog(login.this);
        progressDialog.showDialog();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.hideDialog();
                        try {
                            JSONObject jsonObject1 = new JSONObject(response);
                            if (jsonObject1.getString("success").equalsIgnoreCase("1")) {


                                name = jsonObject1.getString("name");
                                email = jsonObject1.getString("email");

                                // mStartForResult.launch(new Intent(login.this, OTPVerification.class).putExtra("mobile", mobile.getText().toString()));
                                SharedPreferences.Editor editor = getSharedPreferences(constant.prefs, MODE_PRIVATE).edit();
                                editor.putString("mobile", mobile.getText().toString()).apply();
                                editor.putString("login", "true").apply();
                                editor.putString("name", name).apply();
                                editor.putString("email", email).apply();

                                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(in);
                                finish();

                            } else {
                                Toast.makeText(getApplicationContext(), jsonObject1.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.hideDialog();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                        progressDialog.hideDialog();
                        Toast.makeText(login.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("mobile", mobile.getText().toString());
                params.put("pass", password.getText().toString());
                params.put("session", hash);

                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }


    private void initView() {
        //  draw = (ImageView) findViewById(R.id.draw);
        mobile = (EditText) findViewById(R.id.mobile);
        password = (EditText) findViewById(R.id.password);
        submit1 = (latobold) findViewById(R.id.submit1);
        create = (TextView) findViewById(R.id.create);
        forgot = (TextView) findViewById(R.id.forgot);
        mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent == null) return;
                        if (intent.hasExtra("verification") && intent.getStringExtra("verification").equals("success")) {
                            SharedPreferences.Editor editor = getSharedPreferences(constant.prefs, MODE_PRIVATE).edit();
                            editor.putString("mobile", mobile.getText().toString()).apply();
                            editor.putString("login", "true").apply();
                            editor.putString("name", name).apply();
                            editor.putString("email", email).apply();

                            Intent in = new Intent(getApplicationContext(), MainActivity.class);
                            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(in);
                            finish();
                        }
                    }
                });
    }

    private void initViews() {
        logo = findViewById(R.id.logo);
        draw = findViewById(R.id.draw);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        submit1 = findViewById(R.id.submit1);
        create = findViewById(R.id.create);
        forgot = findViewById(R.id.forgot);
        whatsapp = findViewById(R.id.whatsapp);
        otp = findViewById(R.id.otp2);
    }
}
