package com.github.rudda.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.github.rudda.R;
import com.github.rudda.model.Fruit;
import com.github.rudda.model.adapters.FruitAdapter;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView mRecyclerViewList;
    private SearchView mSearchView;
    private RecyclerView.LayoutManager lm;
    private FruitAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerViewList = (RecyclerView) findViewById(R.id.reclicerView);
        mSearchView = (SearchView) findViewById(R.id.serachView);
        mSearchView.setOnQueryTextListener(this);
    }

    private void init(){
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewList.setHasFixedSize(true);

        // use a linear layout manager
        lm = new LinearLayoutManager(this);
        mRecyclerViewList.setLayoutManager(lm);

        // specify an adapter (see also next example)
        mAdapter = new FruitAdapter(new Fruit());
        mRecyclerViewList.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.i("onQueryTextSubmit", query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("onQueryTextChange", newText);
        return false;
    }
}