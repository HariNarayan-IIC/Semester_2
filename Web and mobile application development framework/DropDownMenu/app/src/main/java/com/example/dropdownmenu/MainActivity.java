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

        Spinner mySpinner = findViewById(R.id.mySpinner);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] semester= getResources().getStringArray(R.array.Bachelors_sem_list);
                String selectedItem= parent.getItemAtPosition(position).toString();
                if (selectedItem.equals(semester[0])){
                    printUponSelection(R.array.BSc_sem1_subjects, R.array.Sem1_marks, R.string.BSc_sem1_SGPA);
                }
                else if (selectedItem.equals(semester[1])){
                    printUponSelection(R.array.BSc_sem2_subjects, R.array.Sem2_marks, R.string.BSc_sem2_SGPA);
                }
                else if (selectedItem.equals(semester[2])){
                    printUponSelection(R.array.BSc_sem3_subjects, R.array.Sem3_marks, R.string.BSc_sem3_SGPA);
                }
                else if (selectedItem.equals(semester[3])){
                    printUponSelection(R.array.BSc_sem4_subjects, R.array.Sem4_marks, R.string.BSc_sem4_SGPA);
                }
                else if (selectedItem.equals(semester[4])){
                    printUponSelection(R.array.BSc_sem5_subjects, R.array.Sem5_marks, R.string.BSc_sem5_SGPA);
                }
                else{
                    printUponSelection(R.array.BSc_sem6_subjects, R.array.Sem6_marks, R.string.BSc_sem6_SGPA);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Bachelors_sem_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
    }

    private void printUponSelection(int subjectID, int marksID, int sgpaID){

        String[] subjects = getResources().getStringArray(subjectID);

        TextView textView = findViewById(R.id.Sub1);
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