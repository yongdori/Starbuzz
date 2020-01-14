package com.hfad.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;


public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Drink.drinks
        );
    ListView listDrinks = (ListView) findViewById(R.id.list_drinks);
    listDrinks.setAdapter(listAdapter);

    //create the listener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long id) {
                        //Pass the drink the user clicks on to DrinkActivity
                        Intent intent = new Intent (DrinkCategoryActivity.this, DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKID, (int) id);
                        startActivity(intent);

                    }
                };
        //Assign the listener to the list view
        listDrinks.setOnItemClickListener(itemClickListener);
    }
}
