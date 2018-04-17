package fr.ecole.eni.lokacar.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Voiture;

public class RecycledListAdapter extends Adapter<RecycledListAdapter.ViewHolder> {
    private List<Voiture> mVoitures;

    // Provide a suitable constructor (depends on the kind of dataset)
    public RecycledListAdapter(List<Voiture> items) {
        mVoitures = items;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecycledListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.mImageView = mVoitures.get(position).;
        holder.mModele.setText(mVoitures.get(position).getNom());

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mModele;

        public ViewHolder(View v) {
            super(v);

            mView = v;
            mImageView = (ImageView) v.findViewById(R.id.itemList_photo);
            mModele = (TextView) v.findViewById(R.id.itemList_modele);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mVoitures.size();
    }
}
