package com.sattakhelo.mtk;

import static android.content.Context.MODE_PRIVATE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.util.Log;

public class all_transaction extends Fragment {


    private RecyclerView recyclerview;
    ViewDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_transaction, container, false);
        initViews(view);

        apicall();
        return view;
    }


    private void apicall() {

        progressDialog = new ViewDialog((AppCompatActivity) getActivity());
        progressDialog.showDialog();

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        final StringRequest postRequest = new StringRequest(Request.Method.POST, constant.prefix+"tab_transaction.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("resp",response);
                        progressDialog.hideDialog();
                        try {
                            JSONObject jsonObject1 = new JSONObject(response);

                            ArrayList<String> date = new ArrayList<>();
                            ArrayList<String> remark = new ArrayList<>();
                            ArrayList<String> amount = new ArrayList<>();
                            ArrayList<String> type = new ArrayList<>();
                            ArrayList<String> remark1 = new ArrayList<>();

                            JSONArray jsonArray = jsonObject1.getJSONArray("data");
                            for (int a= 0; jsonArray.length()>a;a++)
                            {

                                JSONObject jsonObject = jsonArray.getJSONObject(a);


                                date.add(jsonObject.getString("date"));
                                amount.add(jsonObject.getString("amount"));
                                remark.add(jsonObject.getString("remark"));
                                type.add(jsonObject.getString("type"));
                                remark1.add(jsonObject.getString("number"));

                            }

                            adaptertransaction rc = new adaptertransaction(getActivity(),date,remark,amount,type,remark1);
                            recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                            recyclerview.setAdapter(rc);

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
                        Toast.makeText(getActivity(), "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("mobile", getActivity().getSharedPreferences(constant.prefs,MODE_PRIVATE).getString("mobile",null));
                params.put("type", "all");


                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }

    private void initViews(View view) {
        recyclerview = view.findViewById(R.id.recyclerview);
    }
}