package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

  class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyView> {
Context context;
ArrayList<User>userArrayList;
public MyAdapter(Context context,ArrayList<User>userArrayList){
this.context=context;
this.userArrayList=userArrayList;
}
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view = LayoutInflater.from(context).inflate(R.layout.card,parent,false);
return new  MyView(view);
}

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        User user=userArrayList.get(position);
        holder.name.setText(user.getName());
holder.phone.setText(user.getPhone());
        holder.address.setText(user.getPhone());

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class MyView extends RecyclerView.ViewHolder{
    TextView name,phone,address;
    public MyView(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name1);
        phone=itemView.findViewById(R.id.phone1);
        address=itemView.findViewById(R.id.address1);

    }
}
}
