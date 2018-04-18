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
import fr.ecole.eni.lokacar.fragment.VehiculesFragment;

public class VehiculesRecyclerViewAdapter extends Adapter<VehiculesRecyclerViewAdapter.ViewHolder> {
    private List<Voiture> mVoitures;
    private VehiculesFragment.OnListFragmentInteractionListener mListener;

    // Provide a suitable constructor (depends on the kind of dataset)
    public VehiculesRecyclerViewAdapter(List<Voiture> items, VehiculesFragment.OnListFragmentInteractionListener listener) {
        mVoitures = items;
        mListener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public VehiculesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_vehicules_item,parent,false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mModele.setText(mVoitures.get(position).getMarque());

        holder.mItem = mVoitures.get(position);
        if (mVoitures.get(position).getModel() != null) {
            holder.mModele.setText(mVoitures.get(position).getModel().getModeleCommercial());
            holder.mDesignation.setText(mVoitures.get(position).getModel().getDesignation());
        }
        holder.mPrix.setText(Float.valueOf(mVoitures.get(position).getPrix()).toString());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mModele;
        public final TextView mDesignation;
        public final TextView mPrix;
        public Voiture mItem;

        public ViewHolder(View v) {
            super(v);

            mView = v;
            mImageView = (ImageView) v.findViewById(R.id.fragmentVehiculesItem_photo);
            mModele = (TextView) v.findViewById(R.id.fragmentVehiculesItem_modele);
            mDesignation = (TextView) v.findViewById(R.id.fragmentVehiculesItem_designation);
            mPrix = (TextView) v.findViewById(R.id.fragmentVehiculesItem_prix);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mVoitures.size();
    }
}
