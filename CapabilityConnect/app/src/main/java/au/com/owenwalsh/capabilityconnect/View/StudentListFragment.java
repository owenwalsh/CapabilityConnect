package au.com.owenwalsh.capabilityconnect.View;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.support.v4.app.FragmentTransaction;


import au.com.owenwalsh.capabilityconnect.R;


public class StudentListFragment extends Fragment implements View.OnClickListener  {
    private RecyclerView recyclerView;
    private ProgressDialog progress;
    private Boolean isFabOpen = false;
    private FloatingActionButton addActionBar;
    private FloatingActionButton addStudentActionBar;
    private Animation actionbar_open,actionbar_close,rotate_forward,rotate_backward;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student_list,container,false);

        addActionBar = (FloatingActionButton) v.findViewById(R.id.fab);
        addStudentActionBar = (FloatingActionButton) v.findViewById(R.id.fab1);
        actionbar_open = AnimationUtils.loadAnimation(getActivity(), R.anim.actionbar_open);
        actionbar_close = AnimationUtils.loadAnimation(getActivity(),R.anim.actionbar_close);
        rotate_forward = AnimationUtils.loadAnimation(getActivity(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getActivity(),R.anim.rotate_backward);
        addActionBar.setOnClickListener(this);
        addStudentActionBar.setOnClickListener(this);
        recyclerView = (RecyclerView) v.findViewById(R.id.fragment_student_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        loadStudents();
        return v;
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab1:
              //move to add student fragment
                Fragment fragment = new AddStudentFragment();
                FragmentManager fragmentManager = getChildFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.student_list_frame, fragment)

                .commit();
                Log.d("Raj", "Fab 1");
                hideFloatingActionBar();
                break;
        }
    }

    public void animateFAB(){

        if(isFabOpen){

            addActionBar.startAnimation(rotate_backward);
            addStudentActionBar.startAnimation(actionbar_close);
            addStudentActionBar.setClickable(false);
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            addActionBar.startAnimation(rotate_forward);
            addStudentActionBar.startAnimation(actionbar_open);
            addStudentActionBar.setClickable(true);
            isFabOpen = true;
            Log.d("Raj","open");

        }

    }

    /**
     *
     */


    /**
     *
     */
    private void loadStudents() {
        showProgressDialog();
        //do all my work here
        hideProgressDialog();
    }

    /**
     * This method is a reusable progress dialog to alert the users that we are waitinf for data
     */
    private void showProgressDialog() {
        if (progress == null) {
            progress = ProgressDialog.show(getContext(), "loading...","wont be long!", true);
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
    public void hideFloatingActionBar(){
        addStudentActionBar.hide();
        addActionBar.hide();
    }

}
