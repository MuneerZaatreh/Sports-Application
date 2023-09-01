package co.il.customlistview2023a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SportsAdapter extends ArrayAdapter<Sports> {
    private Context context;
    private ArrayList<Sports> list;

    public SportsAdapter(@NonNull Context context,  @NonNull ArrayList<Sports> list) {
        super(context, R.layout.custom_layout, list);
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //inflate xml into object
        LayoutInflater layoutInflater = ((AppCompatActivity)context).getLayoutInflater();
        //create view Object
        View view = layoutInflater.inflate(R.layout.custom_layout,parent,false);
        //get arefrence to a sport Object
        Sports sport = this.list.get(position);
        //customLayout view
        TextView tvCustom = view.findViewById(R.id.tvCustomLayout);
        ImageView ivCustom = view.findViewById(R.id.ivCustomLayout);

        tvCustom.setText(sport.getName());
        ivCustom.setImageResource(sport.getImageResourceId());


        return view;
    }
}
