package com.sattakhelo.mtk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Wallet extends AppCompatActivity {

    private ImageView back;
    private RelativeLayout toolbar;
    private LinearLayout deposit;
    private LinearLayout withdraw;
    private LinearLayout bidHistory;
    private LinearLayout winningHistory;
    private LinearLayout transactionHistory;
    private latobold amount;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        initViews();
        back.setOnClickListener(v -> onBackPressed());


        tabLayout.addTab(tabLayout.newTab().setText("ALL"));
        tabLayout.addTab(tabLayout.newTab().setText("IN"));
        tabLayout.addTab(tabLayout.newTab().setText("OUT"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final TransferTabAdapter adapter = new TransferTabAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        amount.setText(getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("wallet", "0") + "₹");

        deposit.setOnClickListener(v -> startActivity(new Intent(Wallet.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        withdraw.setOnClickListener(v -> startActivity(new Intent(Wallet.this, withdraw.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        bidHistory.setOnClickListener(v -> startActivity(new Intent(Wallet.this, played.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        winningHistory.setOnClickListener(v -> startActivity(new Intent(Wallet.this, ledger.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        transactionHistory.setOnClickListener(v -> startActivity(new Intent(Wallet.this, transactions.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
    }

    private void initViews() {
        back = findViewById(R.id.back);
        toolbar = findViewById(R.id.toolbar);
        deposit = findViewById(R.id.deposit);
        withdraw = findViewById(R.id.withdraw);
        bidHistory = findViewById(R.id.bid_history);
        winningHistory = findViewById(R.id.winning_history);
        transactionHistory = findViewById(R.id.transaction_history);
        amount = findViewById(R.id.amount);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }
}