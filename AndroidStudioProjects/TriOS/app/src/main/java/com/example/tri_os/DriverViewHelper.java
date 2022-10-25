package com.example.tri_os;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class DriverViewHelper extends RecyclerView.ViewHolder
{
    public TextView nickname,licenseNum;
    public DriverViewHelper(@NonNull View itemView)
    {
        super(itemView);
        nickname = itemView.findViewById(R.id.nickname);
        licenseNum = itemView.findViewById(R.id.licenseNum);
    }
}