package com.example.studyactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnBatDau;
    TextView txtMess,txtText;
    final int RESULT_LOGIN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Khai báo:
        init();

        btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                startActivityForResult(intent,RESULT_LOGIN);
            }
        });

        /*
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "url", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Xử lí trả về
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Xử lí thông báo ra lỗi
                    }
                }
        );
        //chạy
        requestQueue.add(jsonObjectRequest);
        */

    }

    private void init() {
        btnBatDau = findViewById(R.id.btnBatDau);
        txtMess = findViewById(R.id.txtMessage);
        txtText = findViewById(R.id.txtText);
    }

    //Nhận thông tin trả về:

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==RESULT_LOGIN && resultCode==RESULT_OK){
            String mess = data.getStringExtra("mess");
            txtMess.setText(mess);
            txtText.setVisibility(View.INVISIBLE);
            btnBatDau.setText("Kết Thúc!");
        } else {
            Toast.makeText(MainActivity.this,"Lỗi!",Toast.LENGTH_LONG).show();
        }
    }

    private class ReadJSON extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            //Code chạy lấy về từ string
            String urlStr = strings[0]; //Đường dẫn truyền vào
            StringBuilder strReturn = new StringBuilder();
            try {
                URL url = new URL(urlStr);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                //Đọc dòng dữ liệu nhận được
                String line = "";
                while ((line=bufferedReader.readLine())!=null){
                    strReturn.append(line);
                }
                bufferedReader.close();
                inputStreamReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return strReturn.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            //Code xử lí sau khi nhận được json
            try {
                JSONObject jsonObject = new JSONObject(s);
                String str = jsonObject.getString("<key>");
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i<jsonArray.length();i++){
                    JSONObject object = jsonArray.getJSONObject(i);
                    String data = object.getString("<key>");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(s);
        }
    }
}
