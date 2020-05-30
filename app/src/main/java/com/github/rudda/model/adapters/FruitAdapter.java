package com.github.rudda.model.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rudda.R;
import com.github.rudda.model.Fruit;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder> {

    private Fruit data;

    public FruitAdapter(Fruit data) {
        this.data = data;
    }

    @NonNull
    @Override
    public FruitAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_fruta_item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.MyViewHolder holder, int position) {
            holder.tv.setText(this.data.getFruits().get(position).getWord());
    }

    @Override
    public int getItemCount() {
        return this.data.getFruits().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView im;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.text);
            im = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
