package com.project.graduation.graduationproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.graduation.graduationproject.adapter.RecyclerAdapter;
import com.project.graduation.graduationproject.vo.Poster;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lecyclerView;
    // firebase storage create
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // firebase storage create
        mStorageRef = FirebaseStorage.getInstance().getReference();

        // recyclerView layout, increate data
        initLayout();
        initData();
    }

    private void initLayout() {
        lecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initData() {
        List<Poster> posterList = new ArrayList<Poster>();

        for (int i=0; i<10; i++){
            // vo (Poster) 객체 생성
            Poster poster = new Poster();
            poster.setPosterTitle("수업");
            poster.setPosterImage(R.drawable.poster_class);
            posterList.add(poster);
        }
        lecyclerView.setAdapter(new RecyclerAdapter(posterList, R.layout.row));
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        lecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        lecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
