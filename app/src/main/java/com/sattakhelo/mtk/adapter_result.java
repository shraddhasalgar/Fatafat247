package com.sattakhelo.mtk;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.iwgang.countdownview.CountdownView;

class adapter_result extends RecyclerView.Adapter<adapter_result.ViewHolder> {

    Context context;
    ArrayList<String> name18 = new ArrayList<>();
    ArrayList<String> result = new ArrayList<>();

    ArrayList<String> is_open = new ArrayList<>();
    ArrayList<String> open_time = new ArrayList<>();
    ArrayList<String> close_time = new ArrayList<>();
    private ArrayList<String> open_av = new ArrayList<>();
//    private ArrayList<String> market_type = new ArrayList<>();

    public adapter_result(Context context, ArrayList<String> name18, ArrayList<String> result, ArrayList<String> is_open, ArrayList<String> open_time, ArrayList<String> close_time, ArrayList<String> open_av) {
        this.context = context;
        this.name18 = name18;
        this.result = result;
        this.is_open = is_open;
        this.open_time = open_time;
        this.close_time = close_time;
        this.open_av = open_av;
//        this.market_type = market_type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_layout, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.name18.setText(name18.get(position).toUpperCase());
        holder.result.setText(result.get(position).toUpperCase());

        holder.open_time.setText(open_time.get(position));
        holder.close_time.setText(close_time.get(position));

        if (context.getSharedPreferences(constant.prefs,Context.MODE_PRIVATE).getString("verify","0").equals("1")){
            holder.play_game.setVisibility(View.VISIBLE);
        } else {
            holder.play_game.setVisibility(View.GONE);
        }
        holder.chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name18.get(position).equals("MILAN MORNING")) {
                    String url = "https://dpbosspe.net/milan-morning-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name18.get(position).equals("MADHUR MORNING")) {
                    String url = "https://dpbosspe.net/madhur-morning-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name18.get(position).equals("SRIDEVI DAY")) {
                    String url = "https://dpbosspe.net/sridevi-day-penal-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
//                } else if (name18.get(position).equals("TIME BAZAR")) {
//                    String url = "https://dpbosspe.net/time-bazar-penal.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
                } else if (name18.get(position).equals("MADHUR DAY")) {
                    String url = "https://dpbosspe.net/madhur-day-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name18.get(position).equals("MILAN DAY")) {
                    String url = "https://dpbosspe.net/milan-day-penal.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name18.get(position).equals("RAJDHANI DAY")) {
                    String url = "https://dpbosspe.net/rajdhani-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
//                } else if (name18.get(position).equals("KALYAN")) {
//                    String url = "https://dpbosspe.net/kalyan-penal-chart.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
                } else if (name18.get(position).equals("MADHUR NIGHT")) {
                    String url = "https://dpbosspe.net/madhur-night-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
//                } else if (name18.get(position).equals("KALYAN NIGHT")) {
//                    String url = "https://dpbosspe.net/kalyan-night-penal.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
//                } else if (name18.get(position).equals("RAJDHANI NIGHT")) {
//                    String url = "https://dpbosspe.net/rajdhani-night-penal.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
//                } else if (name18.get(position).equals("MAIN BAZAR")) {
//                    String url = "https://dpbosspe.net/main-bazar-panel-chart.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
                } else if (name18.get(position).equals("SUPREME NIGHT")) {
                    String url = "https://dpbosspe.net/supreme-night-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name18.get(position).equals("SUPREME DAY")) {
                    String url = "https://dpbosspe.net/supreme-day-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
//                }else if (name18.get(position).equals("SRIDEVI NIGHT")) {
//                    String url = "https://dpbosspe.net/sridevi-night-panel-chart.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
                }else if (name18.get(position).equals("MILAN NIGHT")) {
                    String url = "https://dpbosspe.net/milan-night-penal.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("KALYAN MORNING")) {
                    String url = "https://dpbosspe.net/Kalyan-Morning-Penal-Chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }


//                New Games



                else if (name18.get(position).equals("AMBANI MORNING")) {
                String url = "https://www.dpbossking.com/ambani-morning-panel-chart.php";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
                }
                else if (name18.get(position).equals("LABH LAKSHMI DAY")) {
                    String url = "https://dpbossking.com/labh-lakshmi-day-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }  else if (name18.get(position).equals("SRIDEVI")) {
                    String url = "https://dpbossking.com/sridevi-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("KING MORNING")) {
                    String url = "https://dpbossking.com/king-morning-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("MATKA BOSS")) {
                    String url = "https://dpbossking.com/matka-boss-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("TIME BAZAR")) {
                    String url = "https://dpbossking.com/time-bazar-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("AMBANI DAY")) {
                    String url = "https://dpbossking.com/ambani-day-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("BOSS DAY")) {
                    String url = "https://dpbossking.com/boss-day-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("JETWIN")) {
                    String url = "https://dpbossking.com/jeetwin-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("KALYAN")) {
                    String url = "https://dpbossking.com/kalyan-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("KING NIGHT")) {
                    String url = "https://dpbossking.com/king-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("SRIDEVI NIGHT")) {
                    String url = "https://dpbossking.com/sridevi-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("BOSS NIGHT")) {
                    String url = "https://dpbossking.com/boss-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("AMBANI NIGHT")) {
                    String url = "https://dpbossking.com/ambani-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("LABH LAKSHMI NIGHT")) {
                    String url = "https://dpbossking.com/labh-lakshmi-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("RAJDHANI NIGHT")) {
                    String url = "https://dpbossking.com/rajdhani-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("MAIN BAZAR")) {
                    String url = "https://dpbossking.com/main-bazar-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name18.get(position).equals("KALYAN NIGHT")) {
                    String url = "https://dpbossking.com/kalyan-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
            }
        });


        Log.d("open_avv",""+open_av);
        Log.d("is_openn",""+is_open);

        if (open_av.get(position).equals("1") || is_open.get(position).equals("1")) {
            holder.status.setText("Running");
            holder.status.setTextColor(context.getResources().getColor(R.color.md_green_800));
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context,games.class)
                            .putExtra("market",name18.get(position))
                            .putExtra("is_open",is_open.get(position))
                            .putExtra("is_close",open_av.get(position))
                            .putExtra("timing",open_time.get(position)+"-"+close_time.get(position))
                    );
                }
            });

            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String formattedDate = df.format(c);
            String givenDateString = formattedDate+" "+close_time.get(position);

            System.out.println(name18.get(position));
            System.out.println(givenDateString);

//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
//            try {
//                Date mDate = sdf.parse(givenDateString);
//                long timeInMilliseconds = mDate.getTime();
//                //System.out.println(timeInMilliseconds);
//                holder.timer.start(timeInMilliseconds-System.currentTimeMillis());
//                //System.out.println("started");
//                holder.timer.setOnCountdownIntervalListener(1, new CountdownView.OnCountdownIntervalListener() {
//                    @Override
//                    public void onInterval(CountdownView cv, long remainTime) {
//
//                        //System.out.println(name.get(position)+" - "+cv.getRemainTime());
//                    }
//                });
//                // System.out.println(timeInMilliseconds-System.currentTimeMillis());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            Glide.with(context).load(R.drawable.market_open).into(holder.market_icon);
            // timer.start((Long.parseLong(jsonObject1.getString("end_time")) * 1000) - System.currentTimeMillis());
            //


        } else {
            Glide.with(context).load(R.drawable.market_close).into(holder.market_icon);
            holder.status.setText("Closed");
            // holder.status.setText("CLOSED");
            holder.status.setTextColor(context.getResources().getColor(R.color.md_red_600));

            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new androidx.appcompat.app.AlertDialog.Builder(context)
                            .setTitle("Market Close")
                            .setMessage("Betting is already closed for this market")
                            .setNegativeButton(android.R.string.no, null)
                            .show();
                }
            });
        }

        if(open_time.get(position).equals("HOLIDAY")){
            holder.status.setText("Holiday");
            holder.status.setTextColor(context.getResources().getColor(R.color.md_red_600));
        }


    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name18,result,open_time,close_time,status;
        ImageView chart,market_icon;
        //        LinearLayout play_game;
        LinearLayout layout;
        RelativeLayout play_game;
        CountdownView timer9;

        public ViewHolder(View view) {
            super(view);
            name18 = view.findViewById(R.id.name18);
            result = view.findViewById(R.id.result);
            open_time = view.findViewById(R.id.open_time);
            close_time = view.findViewById(R.id.close_time);
            play_game = view.findViewById(R.id.play_game);
            market_icon = view.findViewById(R.id.market_icon);
            layout = view.findViewById(R.id.layout);
            status = view.findViewById(R.id.status);
            timer9 = view.findViewById(R.id.timer9);
            chart = view.findViewById(R.id.chart);
        }
    }



}


