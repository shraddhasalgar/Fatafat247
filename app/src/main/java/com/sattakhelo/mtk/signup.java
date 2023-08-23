package com.sattakhelo.mtk;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    protected EditText mobile;
    protected EditText name;
    protected EditText email;
    protected EditText password,pinCode;
    protected latobold submit;
    protected EditText refcode;
    TextView back1;
    ViewDialog progressDialog;
    String url;
    private static final String ALLOWED_CHARACTERS ="0123456789qwertyuiopasdfghjklzxcvbnm";

    String hash = "";

    ActivityResultLauncher<Intent> mStartForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_signup);
        initView();
        url = constant.prefix + getString(R.string.register);
        hash = getRandomString(30);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.back1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), login.class);
                              in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                             in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                               startActivity(in);
                                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$");
                Pattern PHONE = Pattern.compile( "\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}");
                String phone1 = mobile.getText().toString();
//                String passr = password.getText().toString();
                String emailToText = email.getText().toString();
                Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", Pattern.CASE_INSENSITIVE);
//                Pattern PIN_NUMBER = Pattern.compile(" ^[0-9]*$");
//                String pno = pinCode.getText().toString();

//|| PHONE.matcher(phone1).matches()
//                ||  EMAIL_ADDRESS_REGEX.matcher(emailToText).matches()
//                || PASSWORD_PATTERN.matcher(passr).matches()
//                || PIN_NUMBER.matcher(pno).matches()

                if (mobile.getText().toString().isEmpty() || PHONE.matcher(phone1).matches()) {
                    mobile.setError("Enter valid mobile number");
                } else if (name.getText().toString().isEmpty()) {
                    name.setError("Enter name");
                } else if (email.getText().toString().isEmpty()||  EMAIL_ADDRESS_REGEX.matcher(emailToText).matches() ) {
                    email.setError("Enter valid emailid");
                } else if (password.getText().toString().isEmpty()  ) {
                    password.setError("Enter valid password");
                } else if (pinCode.getText().toString().isEmpty()) {
                    pinCode.setError("Enter valid 4 digit pin number");
                } else if (refcode.getText().toString().isEmpty()) {
                    refcode.setError("Enter valid referral code");
                } else {
                    apicall();
                }

            }
        });
    }

    private static String getRandomString(final int sizeOfRandomString)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(sizeOfRandomString);
        for(int i=0;i<sizeOfRandomString;++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }

    private void apicall() {

        progressDialog = new ViewDialog(signup.this);
        progressDialog.showDialog();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.hideDialog();
                        try {
                            Log.d("response","123"+response);
                            JSONObject jsonObject1 = new JSONObject(response);
                            if (jsonObject1.getString("success").equalsIgnoreCase("1")) {

                                SharedPreferences.Editor editor = getSharedPreferences(constant.prefs, MODE_PRIVATE).edit();
                                editor.putString("mobile", mobile.getText().toString()).apply();
                                editor.putString("login", "true").apply();
                                editor.putString("name", name.getText().toString()).apply();
                                editor.putString("email", email.getText().toString()).apply();
                                editor.putString("pin", pinCode.getText().toString()).apply();
                                editor.putString("referal", refcode.getText().toString()).apply();
                                editor.putString("session", hash).apply();
                                Toast.makeText(signup.this, "Account created successfully, Please login now", Toast.LENGTH_SHORT).show();
                                Intent in = new Intent(getApplicationContext(),login.class);
                                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(in);
                                finish();
//
//                                Intent in = new Intent(getApplicationContext(), login.class);
//                                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(in);
//                                finish();

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
                        Toast.makeText(signup.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("mobile", mobile.getText().toString());
                params.put("name", name.getText().toString());
                params.put("pass", password.getText().toString());
                params.put("pin", pinCode.getText().toString());
                params.put("refcode", refcode.getText().toString());
                params.put("session", hash);


                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }

    private void initView() {
        mobile = (EditText) findViewById(R.id.mobile);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        submit = (latobold) findViewById(R.id.submit);
        refcode = (EditText) findViewById(R.id.refcode);
        pinCode = (EditText) findViewById(R.id.pinCode);
        back1 = findViewById(R.id.back1);

        mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        if (intent == null) return;
                        if (intent.hasExtra("verification") && intent.getStringExtra("verification").equals("success")) {
                            apicall();
                        }
                    }
                });
    }
}
