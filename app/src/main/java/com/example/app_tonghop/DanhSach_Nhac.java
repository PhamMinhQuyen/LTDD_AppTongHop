package com.example.app_tonghop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DanhSach_Nhac extends AppCompatActivity {
    ListView listView;
    Button bt_profile,back;
    String tieude[]={"Hoa Hải Đường","Bỏ Lỡ Một Người","Ai Mang Cô Đơn Đi","Mãi Mãi Không Phải Anh","Gánh Mẹ"};
    String tieudephu[]={"Jack "," Lê Bảo Bình "," K-ICM,APJ"," Thanh Bình "," Quach Been"};
    int image[]={R.drawable.jack,R.drawable.blmn,R.drawable.amcdd,R.drawable.mmkpa,R.drawable.ganhme};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsach_nhac);

        listView =findViewById(R.id.listView);
        bt_profile=(Button)findViewById(R.id.bt_profile);
        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(DanhSach_Nhac.this,Profile.class);
                startActivity(it);
            }
        });
        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(DanhSach_Nhac.this,Login.class);
                startActivity(it);
            }
        });

        MyAdapter myAdapter = new MyAdapter(this,tieude,tieudephu,image);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(DanhSach_Nhac.this, "Jack", Toast.LENGTH_SHORT).show();
                }  if (position==0){
                    Toast.makeText(DanhSach_Nhac.this, "  Lê Bảo Bình ", Toast.LENGTH_SHORT).show();
                }
                if (position==0){
                    Toast.makeText(DanhSach_Nhac.this, " K-ICM,APJ", Toast.LENGTH_SHORT).show();
                }
                if (position==0){
                    Toast.makeText(DanhSach_Nhac.this, "Thanh Bình", Toast.LENGTH_SHORT).show();
                }
                if (position==0){
                    Toast.makeText(DanhSach_Nhac.this, " Quach Been", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rtieude[];
        String rtieudephu[];
        int anh[];
        MyAdapter(Context c,String tieude[] ,String tieudephu[],int anh[]){
            super(c,R.layout.row_nhac,R.id.textview1,tieude);
            this.context=c;
            this.rtieude=tieude;
            this.rtieudephu=tieudephu;
            this.anh=anh;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row =layoutInflater.inflate(R.layout.row_nhac,parent,false);
            ImageView image =row.findViewById(R.id.image);
            TextView tieude =row.findViewById(R.id.textview1);
            TextView tieudephu =row.findViewById(R.id.textview2);

            image.setImageResource(anh[position]);
            tieude.setText(rtieude[position]);
            tieudephu.setText(rtieudephu[position]);


            return row;
        }
    }
}
