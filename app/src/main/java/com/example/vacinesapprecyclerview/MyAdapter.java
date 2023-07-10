package com.example.vacinesapprecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //5- click event handler

    public ItemClickListener cLickListener;
// 1- data source
    private VaccineModel[] listData;

    public MyAdapter(VaccineModel[] listData){
        this.listData = listData;
    }

    public void setcLickListener(ItemClickListener cLickListener) {
        this.cLickListener = cLickListener;
    }

    //2- create the view holder
   public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        public ImageView imageView;
        public TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        if(cLickListener != null){
            cLickListener.onCLick(view, getAdapterPosition());
        }

        }
    }

    //3- implements methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem =  inflater.inflate(R.layout.recycler_view_item,parent , false );
        MyViewHolder viewHolder =  new MyViewHolder(listItem);
        return  viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
final VaccineModel myListData = listData[position];
holder.textView.setText(listData[position].getTitle());
holder.imageView.setImageResource(listData[position].getImage());
    }
    @Override
    public int getItemCount() {
        return listData.length;
    }

}
