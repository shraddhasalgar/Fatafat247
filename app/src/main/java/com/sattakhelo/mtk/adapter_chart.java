package com.sattakhelo.mtk;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class adapter_chart extends RecyclerView.Adapter<adapter_chart.ViewHolder> {

    Context context;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> result = new ArrayList<>();
    private String selectedValue;

    public adapter_chart(Context context, ArrayList<String> name, ArrayList<String> result) {
        this.context = context;
        this.name = name;
        this.result = result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_layout, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.name.setText(name.get(position));
        Log.d("nameee",""+name.get(position));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.get(position).equals("MILAN MORNING")) {
                    String url = "https://dpbosspe.net/milan-morning-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name.get(position).equals("MADHUR MORNING")) {
                    String url = "https://dpbosspe.net/madhur-morning-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name.get(position).equals("SRIDEVI DAY")) {
                    String url = "https://dpbosspe.net/sridevi-day-penal-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
//                } else if (name.get(position).equals("TIME BAZAR")) {
//                    String url = "https://dpbosspe.net/time-bazar-penal.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
                } else if (name.get(position).equals("MADHUR DAY")) {
                    String url = "https://dpbosspe.net/madhur-day-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name.get(position).equals("MILAN DAY")) {
                    String url = "https://dpbosspe.net/milan-day-penal.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name.get(position).equals("RAJDHANI DAY")) {
                    String url = "https://dpbosspe.net/rajdhani-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
//                } else if (name.get(position).equals("KALYAN")) {
//                    String url = "https://dpbosspe.net/kalyan-penal-chart.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
                } else if (name.get(position).equals("MADHUR NIGHT")) {
                    String url = "https://dpbosspe.net/madhur-night-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
//                } else if (name.get(position).equals("KALYAN NIGHT")) {
//                    String url = "https://dpbosspe.net/kalyan-night-penal.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
//                } else if (name.get(position).equals("RAJDHANI NIGHT")) {
//                    String url = "https://dpbosspe.net/rajdhani-night-penal.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
//                } else if (name.get(position).equals("MAIN BAZAR")) {
//                    String url = "https://dpbosspe.net/main-bazar-panel-chart.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
                } else if (name.get(position).equals("SUPREME NIGHT")) {
                    String url = "https://dpbosspe.net/supreme-night-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                } else if (name.get(position).equals("SUPREME DAY")) {
                    String url = "https://dpbosspe.net/supreme-day-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
//                }else if (name.get(position).equals("SRIDEVI NIGHT")) {
//                    String url = "https://dpbosspe.net/sridevi-night-panel-chart.php";
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse(url));
//                    context.startActivity(i);
                }else if (name.get(position).equals("MILAN NIGHT")) {
                    String url = "https://dpbosspe.net/milan-night-penal.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("KALYAN MORNING")) {
                    String url = "https://dpbosspe.net/Kalyan-Morning-Penal-Chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }


//                New Games



                else if (name.get(position).equals("AMBANI MORNING")) {
                    String url = "https://www.dpbossking.com/ambani-morning-panel-chart.php";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("LABH LAKSHMI DAY")) {
                    String url = "https://dpbossking.com/labh-lakshmi-day-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }  else if (name.get(position).equals("SRIDEVI")) {
                    String url = "https://dpbossking.com/sridevi-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("KING MORNING")) {
                    String url = "https://dpbossking.com/king-morning-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("MATKA BOSS")) {
                    String url = "https://dpbossking.com/matka-boss-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("TIME BAZAR")) {
                    String url = "https://dpbossking.com/time-bazar-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("AMBANI DAY")) {
                    String url = "https://dpbossking.com/ambani-day-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("BOSS DAY")) {
                    String url = "https://dpbossking.com/boss-day-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("JETWIN")) {
                    String url = "https://dpbossking.com/jeetwin-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("KALYAN")) {
                    String url = "https://dpbossking.com/kalyan-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("KING NIGHT")) {
                    String url = "https://dpbossking.com/king-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("SRIDEVI NIGHT")) {
                    String url = "https://dpbossking.com/sridevi-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("BOSS NIGHT")) {
                    String url = "https://dpbossking.com/boss-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("AMBANI NIGHT")) {
                    String url = "https://dpbossking.com/ambani-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("LABH LAKSHMI NIGHT")) {
                    String url = "https://dpbossking.com/labh-lakshmi-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("RAJDHANI NIGHT")) {
                    String url = "https://dpbossking.com/rajdhani-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("MAIN BAZAR")) {
                    String url = "https://dpbossking.com/main-bazar-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                else if (name.get(position).equals("KALYAN NIGHT")) {
                    String url = "https://dpbossking.com/kalyan-night-panel-chart";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        RelativeLayout layout;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            layout = view.findViewById(R.id.layout);


        }
    }



}
