package au.com.owenwalsh.capabilityconnect.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import au.com.owenwalsh.capabilityconnect.R;

public class AddStudentFragment extends Fragment {
    private EditText input_firstName;
    private EditText input_lastName;
    private EditText input_email;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_student, container, false);
        input_firstName = (EditText) v.findViewById(R.id.input_first_name);
        input_lastName = (EditText) v.findViewById(R.id.input_last_name);
        input_email = (EditText) v.findViewById(R.id.input_email);

        return v;
    }

}