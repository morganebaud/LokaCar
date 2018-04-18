package fr.ecole.eni.lokacar.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Voiture;

public class AgenceAdapter extends ArrayAdapter<Agence> {
private List<Agence> agences;
    private int res;

    public AgenceAdapter(Context context, int resource, List<Agence> objects) {
        super(context,resource,objects);
        res = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){

            convertView = inflater.inflate(res, parent, false);

            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.agence_item_tv_nom);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        Agence agence = (Agence) getItem(position);

        holder.text.setText(agence.getNom());

        return convertView;
    }

    static class ViewHolder{
        TextView text;
    }

}
