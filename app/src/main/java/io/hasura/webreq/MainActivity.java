package io.hasura.webreq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView mac, textView2;
    EditText reg;
    Button get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mac = (TextView) findViewById(R.id.mac_addr);
        textView2 = (TextView) findViewById(R.id.textView2);
        reg = (EditText) findViewById(R.id.reg_no);
        get = (Button) findViewById(R.id.get);

        mac.setText(getResources().getString(R.string.mac));

        setTitle("WebRequests");
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AuthApiManager(MainActivity.this).getApiInterface().send("https://android-club-project.herokuapp.com/upload_details?" + "reg_no=" + reg.getText().toString().trim() + "&mac=17:2s:3r:54:55").enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if(response.isSuccessful())
                            textView2.setText(response.body());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.i("failed", t.getMessage());

                    }

                });
            }
        });
    }
}