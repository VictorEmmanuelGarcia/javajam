package com.example.tri_os;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<Driver> driverList = new ArrayList<>();
    public RecyclerViewAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Driver> drv)
    {
        driverList.addAll(drv);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_drivers,parent,false);
        return new DriverViewHelper(view);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        DriverViewHelper driverViewHelper = (DriverViewHelper) holder;
        Driver drv = driverList.get(position);
        driverViewHelper.nickname.setText(drv.getNickname());
        driverViewHelper.licenseNum.setText(drv.getLicenseNum());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,displayDriverDetails.class);
                intent.putExtra("selectedDriver",driverViewHelper.nickname.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return driverList.size();
    }
}
