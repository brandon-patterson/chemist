package com.github.brandon_patterson.chemist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button unitAnalysisButton = findViewById(R.id.main_unit_analysis_button);
        Button modelsButton = findViewById(R.id.main_models_button);
        Button balanceEquationsButton = findViewById(R.id.main_balance_equations_button);
        Button stoichiometryButton = findViewById(R.id.main_stoichiometry_button);
        Button referencesButton = findViewById(R.id.main_references_button);

        unitAnalysisButton.setOnClickListener(onClickGoTo(NotImplementedActivity.class));
        modelsButton.setOnClickListener(onClickGoTo(NotImplementedActivity.class));
        balanceEquationsButton.setOnClickListener(onClickGoTo(NotImplementedActivity.class));
        stoichiometryButton.setOnClickListener(onClickGoTo(NotImplementedActivity.class));
        referencesButton.setOnClickListener(onClickGoTo(NotImplementedActivity.class));
    }

    private View.OnClickListener onClickGoTo(final Class<?> activity)
    {
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, activity));
            }
        };
    }
}
