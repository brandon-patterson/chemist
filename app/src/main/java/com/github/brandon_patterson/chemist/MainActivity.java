package com.github.brandon_patterson.chemist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button unitAnalysisButton = (Button) findViewById(R.id.main_unit_analysis_button);
        Button modelsButton = (Button) findViewById(R.id.main_models_button);
        Button balanceEquationsButton = (Button) findViewById(R.id.main_balance_equations_button);
        Button stoichiometryButton = (Button) findViewById(R.id.main_stoichiometry_button);
        Button referencesButton = (Button) findViewById(R.id.main_references_button);

        unitAnalysisButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, NotImplemented.class));
            }
        });

        modelsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, NotImplemented.class));
            }
        });

        balanceEquationsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, NotImplemented.class));
            }
        });

        stoichiometryButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, NotImplemented.class));
            }
        });

        referencesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, NotImplemented.class));
            }
        });
    }
}
