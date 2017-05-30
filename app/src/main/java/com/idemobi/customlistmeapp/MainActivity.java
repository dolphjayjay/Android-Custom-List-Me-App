package com.idemobi.customlistmeapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView _ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _ListView = (ListView) findViewById(R.id.listView);

        List<People> tPeople = randomPeople();
        PeopleAdapter tAdapter = new PeopleAdapter(this, tPeople);
        _ListView.setAdapter(tAdapter);
    }

    private List<People> randomPeople() {
        List<People> tPeople = new ArrayList<>();
        tPeople.add(new People(Color.BLACK, "Florent", "Mon premier message !"));
        tPeople.add(new People(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tPeople.add(new People(Color.GREEN, "Logan", "Que c'est beau..."));
        tPeople.add(new People(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tPeople.add(new People(Color.GRAY, "Willy", "On y est presque"));

        return tPeople;
    }
}
