package fr.ecole.eni.lokacar.adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.fragment.VehiculesFragment;

public class VehiculesRecyclerViewAdapter extends Adapter<VehiculesRecyclerViewAdapter.ViewHolder> {
    private List<Vehicule> mVehicules;
    private VehiculesFragment.OnListFragmentInteractionListener mListener;

    /**
     * Constructor
     *
     * @param items
     * @param listener
     */
    public VehiculesRecyclerViewAdapter(List<Vehicule> items, VehiculesFragment.OnListFragmentInteractionListener listener) {
        mVehicules = items;
        mListener = listener;
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    @Override
    public VehiculesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_vehicules_item,parent,false);

        return new ViewHolder(view);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mModele.setText(mVehicules.get(position).getMarque());

        holder.mItem = mVehicules.get(position);

        if (!mVehicules.get(position).isDispo()) {
            holder.mCardView.setCardBackgroundColor(Color.parseColor("#B71C1C"));
        } else {
            holder.mCardView.setCardBackgroundColor(Color.parseColor("#8BC34A"));
        }

        if (mVehicules.get(position).getModel() != null) {
            holder.mModele.setText(mVehicules.get(position).getModel().getModeleCommercial());
            holder.mDesignation.setText(mVehicules.get(position).getModel().getDesignation());
        }
        holder.mPrix.setText(Float.valueOf(mVehicules.get(position).getPrix()).toString());

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
        public final CardView mCardView;
        public Vehicule mItem;

        public ViewHolder(View v) {
            super(v);

            mView = v;
            mImageView = (ImageView) v.findViewById(R.id.fragmentVehiculesItem_photo);
            mModele = (TextView) v.findViewById(R.id.fragmentVehiculesItem_modele);
            mDesignation = (TextView) v.findViewById(R.id.fragmentVehiculesItem_designation);
            mPrix = (TextView) v.findViewById(R.id.fragmentVehiculesItem_prix);
            mCardView = (CardView) v.findViewById(R.id.fragmentVehiculesItems_cardview);
        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mVehicules.size();
    }
}
