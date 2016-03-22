/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eugene.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import eugene.task.adapters.ImageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setBackButton();
        recyclerViewInit();
    }

    /**
     * Close an activity when was clicked back button
     *
     * @param item which invoke this event
     * @return boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Set back button to the activity.
     */
    private void setBackButton() {

        // set back button to action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Recycler view initialization.
     */
    private void recyclerViewInit() {

        // images for recycler view:
        String[] dataSet = {
                "http://i.imgur.com/inFG3BO.jpg",
                "http://i.imgur.com/BBvx83n.jpg",
                "http://i.imgur.com/wubgH7J.jpg",
                "http://i.imgur.com/8ijnak0.jpg"};

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.HORIZONTAL, false);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvPhotos);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ImageAdapter(dataSet, this));
    }

    /**
     * Click listener for any element on the screen,
     * to show a toast.
     */
    public void onShowToast(View view) {

        String caption = view.getClass().getSimpleName();

        Toast.makeText(this, caption, Toast.LENGTH_SHORT).show();
    }
}
