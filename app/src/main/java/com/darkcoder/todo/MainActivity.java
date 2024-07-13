package com.darkcoder.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button add;
    AlertDialog dialog;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.taskAdd);
        layout=findViewById(R.id.spaceView);
        buildDialog();
        add.setOnClickListener(v -> dialog.show());
    }
    public void buildDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.user_input, null);
        final EditText name= view.findViewById(R.id.editView);
        builder.setView(view);
        builder.setTitle("Enter Task")
                .setPositiveButton("Save", (dialog, which) -> addCard(name.getText().toString()))
                .setNegativeButton("Cancel", (dialog, which) -> {
                });
        dialog = builder.create();
    }
    private void addCard(String name){
        final View view = getLayoutInflater().inflate(R.layout.new_task,null);
        TextView nameView = view.findViewById(R.id.nameText);
        Button delete = view.findViewById(R.id.remove);
        nameView.setText(name);
        delete.setOnClickListener(v -> layout.removeView(view));
        layout.addView(view);
    }
}