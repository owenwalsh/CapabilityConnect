package au.com.owenwalsh.capabilityconnect.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import au.com.owenwalsh.capabilityconnect.R;

public class MainActivity extends AppCompatActivity {
    private Button classButton;
    private Button studentButton;
    private Button weeksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        classButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("Class Button Clicked: ", "moving to class activity");
                Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
                startActivity(intent);
            }
        });
        studentButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d("Student Clicked: ", "Student to class activity");
                Intent intent = new Intent (getApplicationContext(), StudentActivity.class);
                startActivity(intent);
            }
        });
        weeksButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d("Weeks Button Clicked: ", "Student to class activity");
                Intent intent = new Intent (getApplicationContext(), WeeksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        classButton = (Button) findViewById(R.id.classButton);
        studentButton = (Button) findViewById(R.id.studentButton);
        weeksButton = (Button) findViewById(R.id.weeksButton);
    }
}
