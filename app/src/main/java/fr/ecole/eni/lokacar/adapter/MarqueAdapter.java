package fr.ecole.eni.lokacar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Marque;

public class MarqueAdapter  extends ArrayAdapter<Marque> {
    private int res;

    public MarqueAdapter(Context context, int resource, List<Marque> objects) {
        super(context,resource,objects);
        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MarqueAdapter.ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){

            convertView = inflater.inflate(res, parent, false);

            holder = new MarqueAdapter.ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.agence_item_tv_nom);
            convertView.setTag(holder);
        }
        else{
            holder = (MarqueAdapter.ViewHolder) convertView.getTag();
        }

        Marque marque = (Marque) getItem(position);

        holder.text.setText(marque.getNom());

        return convertView;
    }

    static class ViewHolder{
        TextView text;
    }
}
