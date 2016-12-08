package com.zerotech.zeroapp.rxjava2test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zerotech.zeroapp.rxjava2test.ui.RXAdapter;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> dataList;
    private RXAdapter rxAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        setAction();



    }

    public void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        RXAdapter rxAdapter = new RXAdapter(MainActivity.this,dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(rxAdapter);
    }

    public void initData(){
        dataList = new ArrayList<>();
        dataList.add("create");
        dataList.add("from");
        dataList.add("just");
    }

    public void setAction(){
        rxAdapter.setOnItemClickLitener(new RXAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,dataList.get(position),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }
        });
    }
}
