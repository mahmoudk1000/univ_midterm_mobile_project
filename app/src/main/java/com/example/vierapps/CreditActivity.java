package com.example.vierapps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CreditActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CreditAdaptor creditAdaptor;
    private ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_activity);

        recyclerView = findViewById(R.id.recycleview_posts);
        posts = new ArrayList<>();

        posts.add(new Post("Mamm7on", "bny-adam", ""));
        posts.add(new Post("Abu zalah", "bny-adam", ""));
        posts.add(new Post("Markito", "bny-adam", ""));
        posts.add(new Post("3math", "msh bny-adam", ""));


        creditAdaptor = new CreditAdaptor(this, posts);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(creditAdaptor);
    }
}
