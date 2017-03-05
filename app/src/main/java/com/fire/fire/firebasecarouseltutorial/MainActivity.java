package com.fire.fire.firebasecarouseltutorial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fire.fire.firebasecarouseltutorial.adapters.SectionAdapter;
import com.fire.fire.firebasecarouseltutorial.models.Item;
import com.fire.fire.firebasecarouseltutorial.utils.FirebaseUtils;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseRecyclerAdapter<Item, ItemViewHolder> mItemAdapter;

    //First things first. Let's create the UI
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        RecyclerView mainRecyclerView = (RecyclerView) findViewById(R.id.main_reycler);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainRecyclerView.setHasFixedSize(true);
        setupAdapter();
        mainRecyclerView.setAdapter(mItemAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item();
                item.setTitle("Some title");
                item.setItems(createDummyData());

                FirebaseUtils.getItemsRef().push().setValue(item);
            }
        });
    }

    private void setupAdapter() {
        mItemAdapter = new FirebaseRecyclerAdapter<Item, ItemViewHolder>(Item.class, R.layout
                .row_items, ItemViewHolder.class, FirebaseUtils.getItemsRef()) {
            @Override
            protected void populateViewHolder(ItemViewHolder viewHolder, Item model, int position) {
                viewHolder.title.setText(model.getTitle());

                viewHolder.itemRecycler.setLayoutManager(new LinearLayoutManager(MainActivity
                        .this, LinearLayoutManager.HORIZONTAL, false));

                viewHolder.itemRecycler.setHasFixedSize(true);

                SectionAdapter sectionAdapter = new SectionAdapter(model.getItems());

                viewHolder.itemRecycler.setAdapter(sectionAdapter);
                sectionAdapter.notifyDataSetChanged();
            }
        };
    }

    private ArrayList<String> createDummyData() {
        ArrayList<String> dummyData = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            dummyData.add(String.valueOf(i));
        }
        return dummyData;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView itemRecycler;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            itemRecycler = (RecyclerView) itemView.findViewById(R.id.items_recyclerview);
        }
    }
}
