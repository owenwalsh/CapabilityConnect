package au.com.owenwalsh.capabilityconnect.View;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import au.com.owenwalsh.capabilityconnect.R;

public class TutorialActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        initViews();
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.contentView);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                refreshItems();
            }
        });
    }

    /**
     * This method refreshes the items in the class list
     */
    void refreshItems() {
        loadClasses();
    }

    /**
     * this method toasts the user to let them know the list has been refreshed
     */
    void onItemsLoadComplete() {
        Toast.makeText(getApplicationContext(), "Refreshed", Toast.LENGTH_SHORT).show();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    /**
     *
     */
    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.activity_tutorial_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadClasses();


    }

    /**
     *
     */
    private void loadClasses() {
        showProgressDialog();
        //do all my work here
        hideProgressDialog();
    }


    /**
     * This method is a reusable progress dialog to alert the users that we are waitinf for data
     */
    private void showProgressDialog() {
        if (progress == null) {
            progress = ProgressDialog.show(this, "loading...","wont be long!", true);
        }
    }
    /**
     * This method hides the progress dialog and resets it to null
     */
    private void hideProgressDialog() {
        if (progress != null && progress.isShowing()) {
            progress.hide();
            progress = null;
        }
    }


}

