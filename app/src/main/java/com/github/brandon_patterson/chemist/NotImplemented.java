package com.gitub.brandon_patterson.chemist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotImplemented extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_implemented);

        Button homeButton = (Button) findViewById(R.id.not_implemented_home_button);
        homeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(NotImplemented.this, MainActivity.class));
            }
        });
    }
}
