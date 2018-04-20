package fr.ecole.eni.lokacar.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.controller.LocationActivity;
import fr.ecole.eni.lokacar.controller.VehiculesActivity;
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mModele.setText(mVehicules.get(position).getMarque());

        holder.mItem = mVehicules.get(position);

        if (!mVehicules.get(position).isDispo()) {
            holder.mCardView.setCardBackgroundColor(Color.parseColor("#B71C1C"));
            holder.mBtnAction.setText("Retour");

            holder.mBtnAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), LocationActivity.class);
                    intent.putExtra("idVehicule", mVehicules.get(position).getId());
                    v.getContext().startActivity(intent);
                }
            });
        } else {
            holder.mCardView.setCardBackgroundColor(Color.parseColor("#8BC34A"));
            holder.mBtnAction.setText("Louer");

            holder.mBtnAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), LocationActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
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
        public final CardView mCardView;
        public final ImageView mImageView;
        public final TextView mModele;
        public final TextView mDesignation;
        public final TextView mPrix;
        public final Button mBtnAction;
        public Vehicule mItem;

        public ViewHolder(View v) {
            super(v);

            mView = v;
            mCardView = (CardView) v.findViewById(R.id.fragmentVehiculesItems_cardview);
            mImageView = (ImageView) v.findViewById(R.id.fragmentVehiculesItem_photo);
            mModele = (TextView) v.findViewById(R.id.fragmentVehiculesItem_modele);
            mDesignation = (TextView) v.findViewById(R.id.fragmentVehiculesItem_designation);
            mPrix = (TextView) v.findViewById(R.id.fragmentVehiculesItem_prix);
            mBtnAction = (Button) v.findViewById(R.id.fragmentVehiculesItem_btnAction);
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
