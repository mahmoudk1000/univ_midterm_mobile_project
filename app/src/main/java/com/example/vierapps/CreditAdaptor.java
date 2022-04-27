package com.example.vierapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CreditAdaptor extends RecyclerView.Adapter<CreditAdaptor.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
        }
    }

    private Context context;
    private List<Post> posts;

    public CreditAdaptor(Context c, List<Post> postList) {
        this.context = c;
        posts = postList;

    }

    @NonNull
    @Override
    public CreditAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditAdaptor.ViewHolder holder, int position) {
        Post p = posts.get(position);
        holder.name.setText(p.getName());
        holder.desc.setText(p.getDesc());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
