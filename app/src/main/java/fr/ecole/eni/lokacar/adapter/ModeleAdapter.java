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
import fr.ecole.eni.lokacar.bean.Model;

public class ModeleAdapter extends ArrayAdapter<Model>{
    private int res;

    public ModeleAdapter(Context context, int resource, List<Model> objects) {
        super(context,resource,objects);
        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ModeleAdapter.ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){

            convertView = inflater.inflate(res, parent, false);

            holder = new ModeleAdapter.ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.modele_item_tv_designation);
            convertView.setTag(holder);
        }
        else{
            holder = (ModeleAdapter.ViewHolder) convertView.getTag();
        }

        Model modele = (Model) getItem(position);

        holder.text.setText(modele.getDesignation());

        return convertView;
    }

    static class ViewHolder{
        TextView text;
    }
}
