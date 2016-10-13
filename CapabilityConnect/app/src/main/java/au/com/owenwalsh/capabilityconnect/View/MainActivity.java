package au.com.owenwalsh.capabilityconnect.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import au.com.owenwalsh.capabilityconnect.Database.StudentLogic;
import au.com.owenwalsh.capabilityconnect.Database.TutorialLogic;
import au.com.owenwalsh.capabilityconnect.Database.TutorialWeekStudentLogic;
import au.com.owenwalsh.capabilityconnect.Model.Student;
import au.com.owenwalsh.capabilityconnect.Model.Tutorial;
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
                //test database
                /*Tutorial tutorial = new Tutorial("Friday", "10:00");
                TutorialLogic tut = new TutorialLogic(getApplicationContext());
                tut.addTutorial(tutorial);*/

                Log.d("Class Button Clicked: ", "moving to class activity");
                Intent intent = new Intent(getApplicationContext(), TutorialActivity.class);
                startActivity(intent);
            }
        });
        studentButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //test database

                /*TutorialWeekStudentLogic classtLogic = new TutorialWeekStudentLogic(getApplicationContext());
                classtLogic.addStudentToClass("z123456789", 1);*/

                /*StudentLogic sLogic = new StudentLogic(getApplicationContext());
                Student student = new Student("z123456789", "Silvia", "Mereu", "z123456@unsw.edu.au", "very Lovely", "Very Sweet");
                sLogic.insertStudent(student);*/

               /* StudentLogic sLogic = new StudentLogic(getApplicationContext());
                sLogic.findStudentByClassId(1);*/

                Log.d("Student Clicked: ", "Student to class activity");
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(intent);
            }
        });
        weeksButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("Weeks Button Clicked: ", "Student to class activity");
                Intent intent = new Intent(getApplicationContext(), WeeksActivity.class);
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
