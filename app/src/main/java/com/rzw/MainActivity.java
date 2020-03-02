 package com.rzw;

 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.Button;
 import android.widget.Toast;


 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_op = findViewById(R.id.bt_op);
        bt_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpManager.shareNews(MainActivity.this, new ShareListener() {
                    @Override
                    public void onOperations() {
                        super.onOperations();
                        Toast.makeText(MainActivity.this, "onOperations", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete() {
                        super.onDelete();
                        Toast.makeText(MainActivity.this, "onDelete", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
