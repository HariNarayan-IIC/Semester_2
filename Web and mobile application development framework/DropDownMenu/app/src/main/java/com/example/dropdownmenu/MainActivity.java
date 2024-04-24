package com.example.dropdownmenu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner courseSpinner = findViewById(R.id.courseSpinner);
        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                onCourseSelection(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case where nothing is selected
            }
        });
    }

    public void onCourseSelection(String courseSelected) {
        Spinner semSpinner = findViewById(R.id.semSpinner);
        String[] courses = getResources().getStringArray(R.array.Courses);
        ArrayAdapter<CharSequence> adapter;

        if (courseSelected.equals(courses[0])) {
            adapter = ArrayAdapter.createFromResource(this, R.array.Bachelors_sem_list, android.R.layout.simple_spinner_item);
        } else if (courseSelected.equals(courses[1])) {
            adapter = ArrayAdapter.createFromResource(this, R.array.Masters_sem_list, android.R.layout.simple_spinner_item);
        } else {
            // Handle the case where no course is selected
            return;
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semSpinner.setAdapter(adapter);
    }


    public void onButtonClick(View view){

        String[] semester= getResources().getStringArray(R.array.Bachelors_sem_list);
        String[] courses = getResources().getStringArray(R.array.Courses);
        Spinner semSpinner = findViewById(R.id.semSpinner);
        Spinner courseSpinner = findViewById(R.id.courseSpinner);
        String selectedSem = semSpinner.getSelectedItem().toString();
        String selectedCourse = courseSpinner.getSelectedItem().toString();

        if (selectedSem.equals(semester[0]) & selectedCourse.equals(courses[0])){
            printUponSelection(R.array.BSc_sem1_subjects, R.array.BSc_sem1_marks, R.string.BSc_sem1_SGPA);
        }
        else if (selectedSem.equals(semester[1]) & selectedCourse.equals(courses[0])){
            printUponSelection(R.array.BSc_sem2_subjects, R.array.BSc_sem2_marks, R.string.BSc_sem2_SGPA);
        }
        else if (selectedSem.equals(semester[2]) & selectedCourse.equals(courses[0])){
            printUponSelection(R.array.BSc_sem3_subjects, R.array.BSc_sem3_marks, R.string.BSc_sem3_SGPA);
        }
        else if (selectedSem.equals(semester[3]) & selectedCourse.equals(courses[0])){
            printUponSelection(R.array.BSc_sem4_subjects, R.array.BSc_sem4_marks, R.string.BSc_sem4_SGPA);
        }
        else if (selectedSem.equals(semester[4]) & selectedCourse.equals(courses[0])){
            printUponSelection(R.array.BSc_sem5_subjects, R.array.BSc_sem5_marks, R.string.BSc_sem5_SGPA);
        }
        else if (selectedSem.equals(semester[5]) & selectedCourse.equals(courses[0])){
            printUponSelection(R.array.BSc_sem5_subjects, R.array.BSc_sem6_marks, R.string.BSc_sem5_SGPA);
        }

        else if (selectedSem.equals(semester[0]) & selectedCourse.equals(courses[1])){
            printUponSelection(R.array.MSc_sem1_subjects, R.array.MSc_sem1_marks, R.string.MSc_sem1_SGPA);
        }
        else if (selectedSem.equals(semester[1]) & selectedCourse.equals(courses[1])){
            printUponSelection(R.array.MSc_sem2_subjects, R.array.MSc_sem2_marks, R.string.MSc_sem2_SGPA);
        }
        else if (selectedSem.equals(semester[2]) & selectedCourse.equals(courses[1])){
            printUponSelection(R.array.MSc_sem3_subjects, R.array.MSc_sem3_marks, R.string.MSc_sem3_SGPA);
        }
        else if (selectedSem.equals(semester[3]) & selectedCourse.equals(courses[1])){
            printUponSelection(R.array.MSc_sem4_subjects, R.array.MSc_sem4_marks, R.string.MSc_sem4_SGPA);
        }

        else{
            return;
        }
    }

    private void printUponSelection(int subjectID, int marksID, int sgpaID){
        TextView textView;
        String[] subjects = getResources().getStringArray(subjectID);

        textView = findViewById(R.id.Col_name_1);
        textView.setText(R.string.Subject);

        textView = findViewById(R.id.Col_name_2);
        textView.setText(R.string.Marks);

        textView = findViewById(R.id.textView4);
        textView.setText(R.string.SGPA);

        textView = findViewById(R.id.Sub1);
        textView.setText(subjects[0]);
        textView = findViewById(R.id.Sub2);
        textView.setText(subjects[1]);
        textView = findViewById(R.id.Sub3);
        textView.setText(subjects[2]);
        textView = findViewById(R.id.Sub4);
        textView.setText(subjects[3]);
        textView = findViewById(R.id.Sub5);
        textView.setText(subjects[4]);

        String[] marks = getResources().getStringArray(marksID);

        textView = findViewById(R.id.Mark1);
        textView.setText(marks[0]);
        textView = findViewById(R.id.Mark2);
        textView.setText(marks[1]);
        textView = findViewById(R.id.Mark3);
        textView.setText(marks[2]);
        textView = findViewById(R.id.Mark4);
        textView.setText(marks[3]);
        textView = findViewById(R.id.Mark5);
        textView.setText(marks[4]);

        textView = findViewById(R.id.sgpa);
        textView.setText(getResources().getString(sgpaID));
    }
}