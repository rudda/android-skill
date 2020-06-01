package com.github.rudda.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.github.rudda.R;
import com.github.rudda.model.Fruit;
import com.github.rudda.model.Word;
import com.github.rudda.model.adapters.FruitAdapter;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView mRecyclerViewList;
    private SearchView mSearchView;
    private RecyclerView.LayoutManager lm;
    private FruitAdapter mAdapter;
    private Fruit mFruitList = new Fruit();
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
       // mRecyclerViewList.setHasFixedSize(true);

        // use a linear layout manager
        lm = new LinearLayoutManager(this);
        mRecyclerViewList.setLayoutManager(lm);

        // specify an adapter (see also next example)
        mAdapter = new FruitAdapter(mFruitList);
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
        Fruit f = new Fruit();
        f.getFruits().clear();

//        for (int i = 0; i < this.mFruitList.getFruits().size(); i++) {
        for (int i = 0; i < 10; i++) {
        Word w = this.mFruitList.getFruits().get(i);
            int result_1= 0;
            boolean result_2 = false;
             if(  w.getWord().length() == query.length()){
                 result_1 = w.jumbledLetters(query, w.getWord().length());
             } else {
                 result_2 = w.isTypo(w.getWord(), query);

             }

            if( result_1 > 1 && !result_2) {
                Log.i("Im", "a jumbled "+w.getWord());
                f.getFruits().add(w);
            } else if( result_2 && !(result_1 >1)) {
                Log.i("Im", "a typo "+w.getWord());
                f.getFruits().add(w);
            }

        }

        //this.mFruitList = f;
        this.mAdapter = new FruitAdapter(f);
        this.mRecyclerViewList.setAdapter(this.mAdapter);
        Log.i("onQueryTextSubmit", mFruitList.getFruits().size() + "---" + f.getFruits().size());
        this.mAdapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

//       // for (int i = 0; i < this.mFruitList.getFruits().size(); i++) {
//            Word w = this.mFruitList.getFruits().get(0);
//
//            Log.i("onQueryTextChange", "--> "+w.jumbledLetters("yuo", w.getWord().length()));
////            if(  w.jumbledLetters(newText, w.getWord().length()) > 1){
////                Log.i("onQueryTextChange", "maior q 1");
////            }
//
////        }
//        Log.i("onQueryTextChange", newText);
        return false;
    }
}