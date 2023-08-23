package com.sattakhelo.mtk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    ImageView prof11,with11,depo11,charts11,rate11,share11;

    DrawerLayout drawer2;
    protected ScrollView scrollView;
    protected TextView balance;
    protected CardView single;
    protected CardView jodi;
    protected CardView singlepatti;
    protected CardView doublepatti;
    protected CardView tripepatti;
    protected CardView halfsangam;
    protected CardView fullsangam;
    protected latonormal hometext;
    protected CardView crossing;
    protected CardView exit;
    protected CardView out;
    protected LinearLayout logout18;

    protected CardView refresh;

    protected CardView support;

    LinearLayout prof,depo,withdraw,gameRates,share,charts,referndearn;

    RelativeLayout telegram, live_chat;
    SwitchCompat resultNotification;
    RecyclerView recyclerview;
    SharedPreferences preferences;
    String url;
    String is_gateway = "0";
    ImageView deposit_money;
    // LinearLayout deposit_money, wallet_history, withdraw_money, game_charts;
    SwipeRefreshLayout swiperefresh;

    TextView top;
    ImageView loading_gif;
    private ImageView loadingGif;
    private LinearLayout walletView;
    private RelativeLayout toolbar;
    private CircleImageView appIcon;
    private ImageView timeInfo;
    private latobold whatsappNumber;
    private ImageView whatsappIcon;
    private ImageView back;
    private ImageView coin;
    private latobold homeTitle;
    private latonormal homeTag;
    private latobold depositButton;
    private latobold withdrawButton;

    SliderView sliderView;
    private SliderAdapter adapter;
    private latonormal name99;
    private latonormal mobile;
    private LinearLayout profile;
    private LinearLayout wallet;
    private LinearLayout gameHistory;
    private LinearLayout gameRate;
    private LinearLayout addPoints;
    private LinearLayout withdrawPoints;
    private LinearLayout bankDetails;
    private LinearLayout howToPlay;
    private LinearLayout contactUs;
    private LinearLayout shareNow, transfer_coins;
    private NavigationView navView;
    private ImageView whatsappIcon2;
    private ImageView whatsappIcon1;
    private ImageView playGame1;
    private RelativeLayout starlineView99;
    private ImageView depositMoney;
    private SliderView imageSlider;
    private LinearLayout transferCoins;
    private LinearLayout rateUs;
    private RelativeLayout liveChat;
    private LinearLayout chart3;
    private LinearLayout walletIcon;
    private LinearLayout addMoney;
    private LinearLayout rateIcon;
    private LinearLayout withdrawIcon;
    private RelativeLayout playStarline;
    private DrawerLayout drawer;
    private ImageView whatsappFigma;
    private ImageView callFigma;
    private RelativeLayout playDelhi;
    private ImageView someIcon;
    private RelativeLayout galiView;
    private LinearLayout gameViews;
    private ImageView someIcon2;
    private latobold whatsappNum;
    private ImageView someIcon3;
    private latobold telegramDetails;
    private RelativeLayout telegramBlock;
    private LinearLayout depositHeader;
    private LinearLayout withdrawHeader;
    private latobold whatsappFooterText;
    private LinearLayout whatsappBox;
    private LinearLayout callBox;
    private latobold callFooterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initViews();
        url = constant.prefix + getString(R.string.home);


        findViewById(R.id.call_figma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getSharedPreferences(constant.prefs, Context.MODE_PRIVATE).getString("whatsapp", null);
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
        callBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getSharedPreferences(constant.prefs, Context.MODE_PRIVATE).getString("whatsapp", null);
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        callFooterText.setText(getSharedPreferences(constant.prefs, Context.MODE_PRIVATE).getString("whatsapp", null));

        whatsappFooterText.setText(getSharedPreferences(constant.prefs, Context.MODE_PRIVATE).getString("whatsapp", ""));
        whatsappFooterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = constant.getWhatsapp(getApplicationContext());

                Log.d("whatsaap","images"+url);
                Uri uri = Uri.parse(url);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(sendIntent);
            }
        });

        findViewById(R.id.whatsapp_figma).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = constant.getWhatsapp(getApplicationContext());

                Uri uri = Uri.parse(url);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(sendIntent);
            }
        });
        playDelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DelhiJodiMarkets.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        chart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, chart_menu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        walletIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Wallet.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
//        depositHeader.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
//        });
        rateIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, rate.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
//        withdrawHeader.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, withdraw.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
//        });

        whatsappNum.setText(getSharedPreferences(constant.prefs, Context.MODE_PRIVATE).getString("whatsapp", ""));

        whatsappNum.setOnClickListener(v -> {
            String url = constant.getWhatsapp(getApplicationContext());

            Uri uri = Uri.parse(url);
            Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(sendIntent);
        });

        support.setOnClickListener(v -> {
            String url = constant.getWhatsapp(getApplicationContext());

            Uri uri = Uri.parse(url);
            Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(sendIntent);
        });

        playStarline.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, starline_timings.class).putExtra("market", "ShivShamboo Starline")
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));


        exit.setOnClickListener(v -> {
            Process.killProcess(Process.myPid());
            System.exit(1);
        });

        out.setOnClickListener(v -> {
            preferences.edit().clear().apply();
            Intent in = new Intent(getApplicationContext(), login.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(in);
            finish();
        });

        logout18.setOnClickListener(v -> {
            preferences.edit().clear().apply();
            Intent in = new Intent(getApplicationContext(), login.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(in);
            finish();
        });


        refresh.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();
            apicall();
        });

        apicall();

        if (preferences.getString("wallet", null) != null) {
            balance.setText(preferences.getString("wallet", null));
        } else {
            balance.setText("Loading");
        }

        if (preferences.getString("homeline", null) != null) {
            if (preferences.getString("homeline", "").equals("")) {
                hometext.setVisibility(View.GONE);
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    hometext.setText(Html.fromHtml(preferences.getString("homeline", ""), Html.FROM_HTML_MODE_COMPACT));
                } else {
                    hometext.setText(Html.fromHtml(preferences.getString("homeline", null)));
                }
            }
        } else {
            hometext.setText("Loading...");
        }


        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "single").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        jodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "jodi").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        crossing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "crossing").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        singlepatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "singlepatti").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        doublepatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "doublepatti").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        tripepatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "tripepatti").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });


        halfsangam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "halfsangam").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        fullsangam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "fullsangam").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        crossing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, bazar.class).putExtra("game", "crossing").setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

//        deposit_money.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (is_gateway.equals("1")) {
//                    startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                } else {
//                    openWhatsApp();
//                }
//            }
//        });
//
//        game_charts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, chart_menu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
//        });
//
//
//        withdraw_money.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, withdraw.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
//        });
//
//
//        wallet_history.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, played.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
//        });

        walletView.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Wallet.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

        prof.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, profile.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

        depo.setOnClickListener(v ->  startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

        withdraw.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, withdraw.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

        charts.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, chart_menu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

        gameRates.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, rate.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

        referndearn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, earn.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent sendIntent = new Intent();
                            sendIntent.setAction(Intent.ACTION_SEND);
                            sendIntent.putExtra(Intent.EXTRA_TEXT,
                                    "Download " + getString(R.string.app_name) + " and earn coins at home, Download link - " + constant.link);
                            sendIntent.setType("text/plain");
                            startActivity(sendIntent);
            }
        });


    }

    public void verifyMenu() {

        Typeface face = Typeface.createFromAsset(getAssets(), "Oxygen-Bold.ttf");


//        PrimaryDrawerItem home = new PrimaryDrawerItem().withName("Home").withIcon(R.drawable.house).withIdentifier(999).withTypeface(face);
//        PrimaryDrawerItem account = new PrimaryDrawerItem().withName("My Profile").withIcon(R.drawable.user_icon).withIdentifier(1).withTypeface(face);
//        PrimaryDrawerItem charts = new PrimaryDrawerItem().withName("Charts").withIdentifier(101).withIcon(R.drawable.chart_new).withTypeface(face);
//        PrimaryDrawerItem rate = new PrimaryDrawerItem().withName("Game Rate").withIdentifier(2).withIcon(R.drawable.rupee_icon).withTypeface(face);
//        PrimaryDrawerItem earn = new PrimaryDrawerItem().withName("Refer and Earn").withIcon(R.drawable.refer_icon).withIdentifier(21).withTypeface(face);
//        PrimaryDrawerItem notice = new PrimaryDrawerItem().withName("Notice").withIcon(R.drawable.notice_new).withIdentifier(3).withTypeface(face);
//        PrimaryDrawerItem deposit = new PrimaryDrawerItem().withName("Deposit").withIcon(R.drawable.deposit_home_icon).withIdentifier(4).withTypeface(face);
//        PrimaryDrawerItem withdraw = new PrimaryDrawerItem().withName("Withdrawal").withIcon(R.drawable.withdraw_home_icon).withIdentifier(41).withTypeface(face);
//        PrimaryDrawerItem bank = new PrimaryDrawerItem().withName("Bank Details").withIcon(R.drawable.withdraw_new).withIdentifier(411).withTypeface(face);
//        PrimaryDrawerItem ledger = new PrimaryDrawerItem().withName("Winning History").withIcon(R.drawable.game_ledger_new).withIdentifier(6).withTypeface(face);
//        PrimaryDrawerItem transaction = new PrimaryDrawerItem().withName("Transaction History").withIcon(R.drawable.calendar).withIdentifier(8).withTypeface(face);
//        PrimaryDrawerItem played = new PrimaryDrawerItem().withName("Played Match").withIcon(R.drawable.history_home_icon).withIdentifier(9).withTypeface(face);
//        PrimaryDrawerItem howto = new PrimaryDrawerItem().withName("How to Play").withIcon(R.drawable.call_icnon).withIdentifier(10).withTypeface(face);
//        PrimaryDrawerItem share = new PrimaryDrawerItem().withName("Share").withIcon(R.drawable.share_icon).withIdentifier(11).withTypeface(face);
//        PrimaryDrawerItem logout = new PrimaryDrawerItem().withName("Logout").withIcon(R.drawable.logout_icon).withIdentifier(7).withTypeface(face);


        PrimaryDrawerItem home = new PrimaryDrawerItem().withName("Home").withIcon(R.drawable.house).withIdentifier(999).withTypeface(face);
        PrimaryDrawerItem account = new PrimaryDrawerItem().withName("My Profile").withIcon(R.drawable.user_icon).withIdentifier(1).withTypeface(face);
        PrimaryDrawerItem charts = new PrimaryDrawerItem().withName("Charts").withIdentifier(101).withIcon(R.drawable.ic_baseline_bar_chart_24).withTypeface(face);
        PrimaryDrawerItem rate = new PrimaryDrawerItem().withName("Game Rate").withIdentifier(2).withIcon(R.drawable.rupee_icon).withTypeface(face);
        PrimaryDrawerItem earn = new PrimaryDrawerItem().withName("Refer and Earn").withIcon(R.drawable.refer_icon).withIdentifier(21).withTypeface(face);
        PrimaryDrawerItem notice = new PrimaryDrawerItem().withName("Notice").withIcon(R.drawable.notice_new).withIdentifier(3).withTypeface(face);
        PrimaryDrawerItem transfer = new PrimaryDrawerItem().withName("Transfer").withIcon(R.drawable.deposit_home_icon).withIdentifier(423).withTypeface(face);
        PrimaryDrawerItem deposit = new PrimaryDrawerItem().withName("Deposit").withIcon(R.drawable.deposit_home_icon).withIdentifier(4).withTypeface(face);
        PrimaryDrawerItem withdraw = new PrimaryDrawerItem().withName("Withdrawal").withIcon(R.drawable.withdraw_home_icon).withIdentifier(41).withTypeface(face);
        PrimaryDrawerItem bank = new PrimaryDrawerItem().withName("Bank Details").withIcon(R.drawable.withdraw_new).withIdentifier(411).withTypeface(face);
        PrimaryDrawerItem ledger = new PrimaryDrawerItem().withName("Winning History").withIcon(R.drawable.game_ledger_new).withIdentifier(6).withTypeface(face);
        PrimaryDrawerItem transaction = new PrimaryDrawerItem().withName("Transaction History").withIcon(R.drawable.calendar).withIdentifier(8).withTypeface(face);
        PrimaryDrawerItem played = new PrimaryDrawerItem().withName("Played Match").withIcon(R.drawable.history_home_icon).withIdentifier(9).withTypeface(face);
        PrimaryDrawerItem howto = new PrimaryDrawerItem().withName("How to Play").withIcon(R.drawable.call_icnon).withIdentifier(10).withTypeface(face);
        PrimaryDrawerItem share = new PrimaryDrawerItem().withName("Share").withIcon(R.drawable.share_icon).withIdentifier(11).withTypeface(face);
        PrimaryDrawerItem logout = new PrimaryDrawerItem().withName("Logout").withIcon(R.drawable.logout_icon).withIdentifier(7).withTypeface(face);


        final Drawer drawer = new DrawerBuilder()
                .withHeaderDivider(true)
                .withActivity(this)
                .withSliderBackgroundColor(getResources().getColor(R.color.md_white_1000))
                .withTranslucentStatusBar(true)
                .withHeader(R.layout.header)
                .withActionBarDrawerToggle(false)
                .addDrawerItems(
                        home, played, charts, ledger, account, earn, rate, notice, transfer, deposit, withdraw, bank, howto, transaction, share, logout
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if (drawerItem.equals(1)) {
                            startActivity(new Intent(MainActivity.this, profile.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(101)) {
                            startActivity(new Intent(MainActivity.this, chart_menu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(2)) {
                            startActivity(new Intent(MainActivity.this, rate.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(423)) {
                            if (preferences.getString("transfer_points_status", "0").equals("1")) {
                                startActivity(new Intent(MainActivity.this, TransferCoin.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                            } else {
                                new AlertDialog.Builder(MainActivity.this)
                                        .setTitle("Request feature")
                                        .setMessage("Please contact admin to enable this feature for your account")
                                        .setNegativeButton(android.R.string.no, null)
                                        .show();
                            }
                        }
                        if (drawerItem.equals(21)) {
                            startActivity(new Intent(MainActivity.this, earn.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(3)) {
                            startActivity(new Intent(MainActivity.this, notice.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(4)) {
                            if (is_gateway.equals("1")) {
                                startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                            } else {
                                openWhatsApp();
                            }
                        }
                        if (drawerItem.equals(41)) {
                            startActivity(new Intent(MainActivity.this, withdraw.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(411)) {
                            startActivity(new Intent(MainActivity.this, WithdrawDetails.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(10)) {
                            startActivity(new Intent(MainActivity.this, howot.class));
                        }
                        if (drawerItem.equals(11)) {

                            Intent sendIntent = new Intent();
                            sendIntent.setAction(Intent.ACTION_SEND);
                            sendIntent.putExtra(Intent.EXTRA_TEXT,
                                    "Download " + getString(R.string.app_name) + " and earn coins at home, Download link - " + constant.link);
                            sendIntent.setType("text/plain");
                            startActivity(sendIntent);
                        }
                        if (drawerItem.equals(7)) {
                            preferences.edit().clear().apply();
                            Intent in = new Intent(getApplicationContext(), login.class);
                            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(in);
                            finish();
                        }
                        if (drawerItem.equals(6)) {
                            startActivity(new Intent(MainActivity.this, ledger.class));
                        }
                        if (drawerItem.equals(8)) {
                            startActivity(new Intent(MainActivity.this, transactions.class));
                        }
                        if (drawerItem.equals(9)) {
                            startActivity(new Intent(MainActivity.this, played.class));
                        }

                        return false;
                    }
                })
                .build();

        TextView hi_msg = drawer.getHeader().findViewById(R.id.hi_msg);

        hi_msg.setText(getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("name", ""));

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen()) {
                    drawer.closeDrawer();
                } else {
                    drawer.openDrawer();
                }
            }
        });
    }

    public void unVerifyMenu() {

        Typeface face = Typeface.createFromAsset(getAssets(), "Oxygen-Bold.ttf");


        PrimaryDrawerItem home = new PrimaryDrawerItem().withName("Home").withIcon(R.drawable.house).withIdentifier(999).withTypeface(face);
        PrimaryDrawerItem account = new PrimaryDrawerItem().withName("My Profile").withIcon(R.drawable.user_icon).withIdentifier(1).withTypeface(face);
        PrimaryDrawerItem charts = new PrimaryDrawerItem().withName("Charts").withIdentifier(101).withIcon(R.drawable.calendar).withTypeface(face);
        PrimaryDrawerItem rate = new PrimaryDrawerItem().withName("Game Rate").withIdentifier(2).withIcon(R.drawable.rupee_icon).withTypeface(face);
        PrimaryDrawerItem earn = new PrimaryDrawerItem().withName("Refer and Earn").withIcon(R.drawable.refer_icon).withIdentifier(21).withTypeface(face);
        PrimaryDrawerItem notice = new PrimaryDrawerItem().withName("Notice").withIcon(R.drawable.notice_new).withIdentifier(3).withTypeface(face);
        PrimaryDrawerItem deposit = new PrimaryDrawerItem().withName("Deposit").withIcon(R.drawable.deposit_home_icon).withIdentifier(4).withTypeface(face);
        PrimaryDrawerItem withdraw = new PrimaryDrawerItem().withName("Withdrawal").withIcon(R.drawable.withdraw_home_icon).withIdentifier(41).withTypeface(face);
        PrimaryDrawerItem bank = new PrimaryDrawerItem().withName("Bank Details").withIcon(R.drawable.withdraw_new).withIdentifier(411).withTypeface(face);
        PrimaryDrawerItem ledger = new PrimaryDrawerItem().withName("Winning History").withIcon(R.drawable.game_ledger_new).withIdentifier(6).withTypeface(face);
        PrimaryDrawerItem transaction = new PrimaryDrawerItem().withName("Transaction History").withIcon(R.drawable.calendar).withIdentifier(8).withTypeface(face);
        PrimaryDrawerItem played = new PrimaryDrawerItem().withName("Played Match").withIcon(R.drawable.history_home_icon).withIdentifier(9).withTypeface(face);
        PrimaryDrawerItem howto = new PrimaryDrawerItem().withName("How to Play").withIcon(R.drawable.call_icnon).withIdentifier(10).withTypeface(face);
        PrimaryDrawerItem share = new PrimaryDrawerItem().withName("Share").withIcon(R.drawable.share_icon).withIdentifier(11).withTypeface(face);
        PrimaryDrawerItem logout = new PrimaryDrawerItem().withName("Logout").withIcon(R.drawable.logout_icon).withIdentifier(7).withTypeface(face);


        final Drawer drawer = new DrawerBuilder()
                .withHeaderDivider(true)
                .withActivity(this)
                .withSliderBackgroundColor(getResources().getColor(R.color.md_white_1000))
                .withTranslucentStatusBar(true)
                .withHeader(R.layout.header)
                .withActionBarDrawerToggle(false)
                .addDrawerItems(
                        home, charts, share, logout
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if (drawerItem.equals(1)) {
                            startActivity(new Intent(MainActivity.this, profile.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(101)) {
                            startActivity(new Intent(MainActivity.this, chart_menu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(2)) {
                            startActivity(new Intent(MainActivity.this, rate.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(21)) {
                            startActivity(new Intent(MainActivity.this, earn.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(3)) {
                            startActivity(new Intent(MainActivity.this, notice.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(4)) {
                            if (is_gateway.equals("1")) {
                                startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                            } else {
                                openWhatsApp();
                            }
                        }
                        if (drawerItem.equals(41)) {
                            startActivity(new Intent(MainActivity.this, withdraw.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(411)) {
                            startActivity(new Intent(MainActivity.this, WithdrawDetails.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        }
                        if (drawerItem.equals(10)) {
                            startActivity(new Intent(MainActivity.this, howot.class));
                        }
                        if (drawerItem.equals(11)) {

                            Intent sendIntent = new Intent();
                            sendIntent.setAction(Intent.ACTION_SEND);
                            sendIntent.putExtra(Intent.EXTRA_TEXT,
                                    "Download " + getString(R.string.app_name) + " and earn coins at home, Download link - " + constant.link);
                            sendIntent.setType("text/plain");
                            startActivity(sendIntent);
                        }
                        if (drawerItem.equals(7)) {
                            preferences.edit().clear().apply();
                            Intent in = new Intent(getApplicationContext(), login.class);
                            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(in);
                            finish();
                        }
                        if (drawerItem.equals(6)) {
                            startActivity(new Intent(MainActivity.this, ledger.class));
                        }
                        if (drawerItem.equals(8)) {
                            startActivity(new Intent(MainActivity.this, transactions.class));
                        }
                        if (drawerItem.equals(9)) {
                            startActivity(new Intent(MainActivity.this, played.class));
                        }

                        return false;
                    }
                })
                .build();


    }

    private void apicall() {


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("response", response);
                        try {

                            JSONObject jsonObject1 = new JSONObject(response);

                            SharedPreferences.Editor editor = preferences.edit();
                            if (jsonObject1.getString("active").equals("0")) {
                                Toast.makeText(MainActivity.this, "Your account temporarily disabled by admin", Toast.LENGTH_SHORT).show();

                                preferences.edit().clear().apply();
                                Intent in = new Intent(getApplicationContext(), login.class);
                                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(in);
                                finish();
                                return;
                            }

                            if (jsonObject1.getString("session").equals("0")) {
                                Toast.makeText(MainActivity.this, "Session expired ! Please login again", Toast.LENGTH_SHORT).show();

                                preferences.edit().clear().apply();
                                Intent in = new Intent(getApplicationContext(), login.class);
                                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(in);
                                finish();
                                return;
                            }

                            editor.putString("verify", jsonObject1.getString("verify")).apply();
                            balance.setText(jsonObject1.getString("wallet"));

                            if (jsonObject1.getString("homeline").equals("")) {
                                hometext.setVisibility(View.GONE);
                            } else {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    hometext.setText(Html.fromHtml(jsonObject1.getString("homeline"), Html.FROM_HTML_MODE_COMPACT));
                                } else {
                                    hometext.setText(Html.fromHtml(jsonObject1.getString("homeline")));
                                }
                            }

                            ArrayList<String> namex = new ArrayList<>();
                            ArrayList<String> result = new ArrayList<>();

                            ArrayList<String> is_open = new ArrayList<>();
                            ArrayList<String> open_time = new ArrayList<>();
                            ArrayList<String> close_time = new ArrayList<>();
                            ArrayList<String> open_av = new ArrayList<>();
//                            ArrayList<String> market_type = new ArrayList<>();

                            JSONArray jsonArray = jsonObject1.getJSONArray("result");
                            for (int a = 0; a < jsonArray.length(); a++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(a);

                                open_time.add(jsonObject.getString("open_time"));
                                Log.d("open_t",""+jsonObject.getString("open_time"));
                                close_time.add(jsonObject.getString("close_time"));
                                namex.add(jsonObject.getString("market"));
                                result.add(jsonObject.getString("result"));
//
                                is_open.add(jsonObject.getString("is_open"));
                                open_av.add(jsonObject.getString("is_close"));


                                Log.d("OTIME",""+jsonObject.getString("open_time"));
                                Log.d("CTIME",""+jsonObject.getString("close_time"));
                                Log.d("NAMEX",""+jsonObject.getString("market"));
                                Log.d("REEE",""+jsonObject.getString("result"));
                                Log.d("IZZOPEN",""+jsonObject.getString("is_open"));
                                Log.d("ISSCLOSE",""+jsonObject.getString("is_close"));



                                adapter_result rc = new adapter_result(MainActivity.this, namex, result, is_open, open_time, close_time, open_av);
                                recyclerview.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
                                recyclerview.setAdapter(rc);

                            }


                            if (jsonObject1.has("images")) {
                                adapter = new SliderAdapter(MainActivity.this);

                                JSONArray jsonArrayx = jsonObject1.getJSONArray("images");
                                for (int a = 0; a < jsonArrayx.length(); a++) {
                                    JSONObject jsonObject = jsonArrayx.getJSONObject(a);

                                    //   Log.e("admin-image",constant.project_root + "admin/" + jsonObject.getString("image"));

                                    SliderItem sliderItem1 = new SliderItem();
                                    sliderItem1.setImageUrl(constant.project_root + "admin/" + jsonObject.getString("image"));
                                    adapter.addItem(sliderItem1);

                                }

                                sliderView.setSliderAdapter(adapter);
                            } else {
                                sliderView.setVisibility(View.GONE);
                            }

                            editor.putString("wallet", jsonObject1.getString("wallet")).apply();
                            editor.putString("homeline", jsonObject1.getString("homeline")).apply();
                            editor.putString("code", jsonObject1.getString("code")).apply();
                            editor.putString("is_gateway", jsonObject1.getString("gateway")).apply();
                            editor.putString("whatsapp", jsonObject1.getString("whatsapp")).apply();
                            Log.d("wp",""+jsonObject1.getString("whatsapp"));

                            editor.putString("transfer_points_status", jsonObject1.getString("transfer_points_status")).apply();
                            editor.putString("paytm", jsonObject1.getString("paytm")).apply();
                            is_gateway = jsonObject1.getString("gateway");

                            name99.setText(jsonObject1.getString("name"));
                            mobile.setText(getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("mobile", ""));

                            if (jsonObject1.getString("verify").equals("1")) {
                                // verifyMenu();
                            } else {
                                //   unVerifyMenu();
                                findViewById(R.id.starline_view99).setVisibility(View.GONE);
                                walletView.setVisibility(View.GONE);

                                wallet.setVisibility(View.GONE);
                                gameHistory.setVisibility(View.GONE);
                                gameRate.setVisibility(View.GONE);
                                addPoints.setVisibility(View.GONE);
                                withdrawPoints.setVisibility(View.GONE);
                                bankDetails.setVisibility(View.GONE);
                                bankDetails.setVisibility(View.GONE);
                                walletView.setVisibility(View.GONE);
                                deposit_money.setVisibility(View.GONE);
                                transfer_coins.setVisibility(View.GONE);
                                chart3.setVisibility(View.GONE);
                                walletIcon.setVisibility(View.GONE);
                                addMoney.setVisibility(View.GONE);
                                rateIcon.setVisibility(View.GONE);
                                withdrawIcon.setVisibility(View.GONE);
                                playStarline.setVisibility(View.GONE);
                                playDelhi.setVisibility(View.GONE);
                                gameViews.setVisibility(View.GONE);
                            }

                            if (swiperefresh.isRefreshing()) {
                                swiperefresh.setRefreshing(false);
                            }


                            if (swiperefresh.getVisibility() == View.GONE) {
                                Glide.with(MainActivity.this).load(R.drawable.logo).into(loading_gif);
                                loading_gif.setVisibility(View.GONE);
                                swiperefresh.setVisibility(View.VISIBLE);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Something went wrong !", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();

                        Toast.makeText(MainActivity.this, "Check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("app", "kalyanpro");
                params.put("mobile", preferences.getString("mobile", null));
                params.put("session", getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("session", null));

                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);
    }

    @Override
    protected void onResume() {
        apicall();
        super.onResume();
    }

    private void openWhatsApp() {
        String url = constant.getWhatsapp(getApplicationContext());

        Uri uri = Uri.parse(url);
        Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(sendIntent);
    }


    private void initViews() {

        preferences = getSharedPreferences(constant.prefs, MODE_PRIVATE);
        balance = findViewById(R.id.balance);
        hometext = findViewById(R.id.hometext);
        single = findViewById(R.id.single);
        deposit_money = findViewById(R.id.deposit_money);
        imageSlider = findViewById(R.id.imageSlider);
        telegram = findViewById(R.id.telegram);
        top = findViewById(R.id.top);
        live_chat = findViewById(R.id.live_chat);
        jodi = findViewById(R.id.jodi);
        crossing = findViewById(R.id.crossing);
        singlepatti = findViewById(R.id.singlepatti);
        transfer_coins = findViewById(R.id.transfer_coins);
        doublepatti = findViewById(R.id.doublepatti);
        tripepatti = findViewById(R.id.tripepatti);
        halfsangam = findViewById(R.id.halfsangam);
        fullsangam = findViewById(R.id.fullsangam);
        exit = findViewById(R.id.exit);
        out = findViewById(R.id.out);
        logout18 = findViewById(R.id.logout18);
        refresh = findViewById(R.id.refresh);

        support = findViewById(R.id.support);
        scrollView = findViewById(R.id.scrollView);
        recyclerview = findViewById(R.id.recyclerview);
        drawer2 = findViewById(R.id.drawer);
        resultNotification = findViewById(R.id.resultNotification);
        name99 = findViewById(R.id.name99);
        mobile = findViewById(R.id.mobile);
        profile = findViewById(R.id.profile);
        wallet = findViewById(R.id.wallet);
        gameHistory = findViewById(R.id.game_history);
        gameRate = findViewById(R.id.game_rate);
        addPoints = findViewById(R.id.add_points);
        withdrawPoints = findViewById(R.id.withdraw_points);
        bankDetails = findViewById(R.id.bank_details);
        howToPlay = findViewById(R.id.how_to_play);
        contactUs = findViewById(R.id.contact_us);
        shareNow = findViewById(R.id.share_now);
        navView = findViewById(R.id.navView);
        whatsappIcon2 = findViewById(R.id.whatsapp_icon2);
        resultNotification = findViewById(R.id.resultNotification);
        whatsappIcon1 = findViewById(R.id.whatsapp_icon1);
        starlineView99 = findViewById(R.id.starline_view99);
        rateUs = findViewById(R.id.rate_us);
        chart3 = findViewById(R.id.chart3);
        walletIcon = findViewById(R.id.wallet_icon);
        addMoney = findViewById(R.id.add_money);
        rateIcon = findViewById(R.id.rate_icon);
        withdrawIcon = findViewById(R.id.withdraw_icon);
        playStarline = findViewById(R.id.play_starline);
        whatsappFigma = findViewById(R.id.whatsapp_figma);
        callFigma = findViewById(R.id.call_figma);
        playDelhi = findViewById(R.id.play_delhi);
        gameViews = findViewById(R.id.game_views);
        someIcon2 = findViewById(R.id.some_icon2);
        whatsappNum = findViewById(R.id.whatsapp_num);
        someIcon3 = findViewById(R.id.some_icon3);
        telegramDetails = findViewById(R.id.telegram_details);
        galiView = findViewById(R.id.gali_view);
        telegramBlock = findViewById(R.id.telegram_block);


        prof11 = findViewById(R.id.prof11);
        with11 = findViewById(R.id.with11);
        depo11 = findViewById(R.id.depo11);
        charts11 = findViewById(R.id.charts11);
        rate11 = findViewById(R.id.rate11);
        share11 = findViewById(R.id.share11);


        if (preferences.getString("result", null) != null) {
            resultNotification.setChecked(preferences.getString("result", null).equals("1"));
        } else {
            resultNotification.setChecked(false);
        }

        resultNotification.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                FirebaseMessaging.getInstance().subscribeToTopic("result")
                        .addOnCompleteListener(task2 -> {
                            preferences.edit().putString("result", "1").apply();
                        });
            } else {
                FirebaseMessaging.getInstance().unsubscribeFromTopic("result")
                        .addOnCompleteListener(task2 -> {
                            preferences.edit().putString("result", "0").apply();
                        });
            }
        });


        top.setText(getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("home_line", ""));
        top.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        top.setMarqueeRepeatLimit(-1);
        top.setSingleLine(true);
        top.setSelected(true);
//
//        game_charts = findViewById(R.id.open_chart);
//        deposit_money = findViewById(R.id.deposit_money);
//        withdraw_money = findViewById(R.id.withdraw_money);
//        wallet_history = findViewById(R.id.wallet_history);
        swiperefresh = findViewById(R.id.swiperefresh);
        loading_gif = findViewById(R.id.loading_gif);
        back = findViewById(R.id.back);
        coin = findViewById(R.id.coin);
        homeTitle = findViewById(R.id.home_title);
        homeTag = findViewById(R.id.home_tag);
        depositButton = findViewById(R.id.deposit_button);
        withdrawButton = findViewById(R.id.withdraw_button);

        sliderView = findViewById(R.id.imageSlider);
        swiperefresh.setVisibility(View.GONE);
        Glide.with(MainActivity.this).load(R.drawable.loading_animation).into(loading_gif);
        loading_gif.setVisibility(View.VISIBLE);

        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                apicall();
            }
        });

        hometext.setMovementMethod(LinkMovementMethod.getInstance());

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        prof = findViewById(R.id.prof);
        depo = findViewById(R.id.depo);
        withdraw = findViewById(R.id.withdraw);
        charts = findViewById(R.id.charts);
        gameRates = findViewById(R.id.gameRates);
        referndearn = findViewById(R.id.referndearn);
        share = findViewById(R.id.share);


        walletView = findViewById(R.id.wallet_view);
        toolbar = findViewById(R.id.toolbar);
        appIcon = findViewById(R.id.app_icon);
        timeInfo = findViewById(R.id.time_info);
        whatsappNumber = findViewById(R.id.whatsapp_number);
        whatsappIcon = findViewById(R.id.whatsapp_icon);

        whatsappNumber.setText("Contact us - " + preferences.getString("whatsapp", ""));
        homeTitle.setText(preferences.getString("home_title", ""));
        homeTag.setText(preferences.getString("home_tag", ""));

        if (preferences.getString("chat_support", "0").equals("1")) {
            live_chat.setVisibility(View.VISIBLE);

            live_chat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, AdminMessage.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });
        }

        whatsappIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp();
            }
        });

        findViewById(R.id.whatsapp_icon2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp();
            }
        });

        findViewById(R.id.whatsapp_icon1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp();
            }
        });

        whatsappNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsApp();
            }
        });


        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        findViewById(R.id.gali_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });


        deposit_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, withdraw.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });


        profile.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, profile.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        wallet.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Wallet.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        gameHistory.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, played.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        gameRate.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, rate.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        addPoints.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, deposit_money.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        withdrawPoints.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, withdraw.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        bankDetails.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, WithdrawDetails.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        howToPlay.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, howot.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        contactUs.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, howot.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
        transfer_coins.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TransferCoin.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

        findViewById(R.id.rate_us).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "market://details?id=";
                try {
                    // play market available
                    getPackageManager()
                            .getPackageInfo("com.android.vending", 0);
                    // not available
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    // should use browser
                    link = "https://play.google.com/store/apps/details?id=";
                }
                // starts external action
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(link + getPackageName())));
            }
        });

        shareNow.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Download " + getString(R.string.app_name) + " and earn coins at home, Download link - " + constant.link);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        });

        out.setOnClickListener(v -> {
            preferences.edit().clear().apply();
            Intent in = new Intent(getApplicationContext(), splash.class);
            in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(in);
            finish();
        });
        navView.bringToFront();

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer2.isDrawerOpen(GravityCompat.START)) {
                    drawer2.closeDrawers();
                } else {
                    drawer2.openDrawer(GravityCompat.START);
                }
            }
        });


        if (preferences.getString("telegram", "0").equals("1")) {
            telegram.setVisibility(View.VISIBLE);
            telegramBlock.setVisibility(View.VISIBLE);

            telegramDetails.setText(getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("telegram_details", ""));

            telegramDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("telegram_details", "");

                    Uri uri = Uri.parse(url);
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(sendIntent);
                }
            });

        }

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getSharedPreferences(constant.prefs, MODE_PRIVATE).getString("telegram_details", "");

                Uri uri = Uri.parse(url);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(sendIntent);
            }
        });

//        depositHeader = findViewById(R.id.deposit_header);
//        withdrawHeader = findViewById(R.id.withdraw_header);
        whatsappFooterText = findViewById(R.id.whatsapp_footer_text);
        whatsappFooterText = findViewById(R.id.whatsapp_footer_text);
        whatsappBox = findViewById(R.id.whatsapp_box);
        callBox = findViewById(R.id.call_box);
        callFooterText = findViewById(R.id.call_footer_text);
    }

    public void onBackPressed() {
        if (drawer2.isDrawerOpen(GravityCompat.START)) {
            drawer2.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

}
