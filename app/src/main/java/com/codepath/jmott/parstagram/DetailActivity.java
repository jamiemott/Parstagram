package com.codepath.jmott.parstagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.parceler.Parcels;

import com.bumptech.glide.Glide;
import com.codepath.jmott.parstagram.Post;
import com.codepath.jmott.parstagram.R;
import com.parse.ParseFile;

public class DetailActivity extends AppCompatActivity {

    ImageView ivPostImage;
    TextView tvDescription;
    TextView tvTimeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ivPostImage = findViewById(R.id.ivPostImage);
        tvDescription = findViewById(R.id.tvDescription);
        tvTimeStamp = findViewById(R.id.tvTimeStamp);

        Post post = Parcels.unwrap(getIntent().getParcelableExtra("post"));
        tvDescription.setText(post.getDescription());
        ParseFile image = post.getImage();
        if (image != null) {
            Glide.with(getApplicationContext()).load(post.getImage().getUrl()).into(ivPostImage);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuLogout) {
            Intent i = new Intent(this, LogOutActivity.class);
            startActivity(i);
        }
        if(item.getItemId() ==android.R.id.home){
            onBackPressed();
        }
        return true;
    }
}
