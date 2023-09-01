package co.il.customlistview2023a;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
String[] sportTypes =
        {"Football","BasketBall", "Boxing",
        "Baseball", "Badminton", "pinPong",
        "Tennis", "Vollyball", "Rugby", "Material Arts"};

int[] imageRessourceArray =
        { R.drawable.soccer,R.drawable.basketball,R.drawable.boxing,
                R.drawable.baseball,R.drawable.badminton,R.drawable.pingpong,
                R.drawable.tennis,R.drawable.volleyball,R.drawable.rugby,
                R.drawable.martialarts};

    private ArrayList<Sports> list;
    private ListView listView;
    private  SportsAdapter adapter;
    private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    public  void initView(){
        btnShow = findViewById(R.id.btnCustom);
        listView = findViewById(R.id.lvCustom);

        //this is the Data from Database
        list = new ArrayList<>();
        for (int i = 0; i < sportTypes.length;i++)
        {
            list.add(new Sports(sportTypes[i],imageRessourceArray[i]));
        }
        btnShow.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    public  void showListView(){
        adapter = new SportsAdapter(this,list);
        listView.setAdapter(adapter);


    }
    @Override
    public void onClick(View v) {
        showListView();
    }



    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Sports sport = adapter.getItem(position);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Alert Dialog Title");
        alertDialog.setMessage("Are you sure want to delete");
        alertDialog.setIcon(R.drawable.ic_launcher_background);
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("Yes",(dialog, which) -> {
            adapter.remove(adapter.getItem(position));
            adapter.notifyDataSetChanged();
            dialog.dismiss();});
        alertDialog.setNegativeButton("No",((dialog, which) -> {dialog.dismiss();}));
        AlertDialog dialog = alertDialog.create();
        dialog.show();
        return true;
    }
}