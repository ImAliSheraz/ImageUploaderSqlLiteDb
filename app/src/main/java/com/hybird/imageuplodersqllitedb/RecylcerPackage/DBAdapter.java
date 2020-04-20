package com.hybird.imageuplodersqllitedb.RecylcerPackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hybird.imageuplodersqllitedb.R;

import java.util.ArrayList;

;

public class DBAdapter extends RecyclerView.Adapter<DBAdapter.DBViewHolder> {


    ArrayList<DBModelClass> objDbModelClassArrayList;
    public DBAdapter(ArrayList<DBModelClass> objDbModelClasses) {
        this.objDbModelClassArrayList = objDbModelClasses;
    }
    @NonNull
    @Override
    public DBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View signleRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row,parent,false);
        return new DBViewHolder(signleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull DBViewHolder holder, int position) {
        DBModelClass objDbModelClass = objDbModelClassArrayList.get(position);
        holder.imageDesTV.setText(objDbModelClass.getImageDes());
        holder.ourImageIV.setImageBitmap(objDbModelClass.getOurImage());
    }

    @Override
    public int getItemCount() {
        return objDbModelClassArrayList.size();
    }

    public static class DBViewHolder extends RecyclerView.ViewHolder {

        TextView imageDesTV; ImageView ourImageIV;
        public DBViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDesTV = itemView.findViewById((R.id.sr_ImageDes));
            ourImageIV = itemView.findViewById((R.id.sr_image));
        }
    }
}
