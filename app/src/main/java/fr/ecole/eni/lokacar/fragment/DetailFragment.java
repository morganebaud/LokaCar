package fr.ecole.eni.lokacar.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Model;

public class DetailFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        return  view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public void chargeDetail(Model detail) {

        if(detail != null){

            TextView design = view.findViewById(R.id.tvDesignation);
            TextView carrosserie = view.findViewById(R.id.tvCarrosserie);
            TextView carburant = view.findViewById(R.id.tvCarburant);
            TextView puissance = view.findViewById(R.id.tvPuissance);
            TextView consEU = view.findViewById(R.id.tvConsEU);
            TextView consU = view.findViewById(R.id.tvConsU);
            TextView consM = view.findViewById(R.id.tvConsM);

            design.setText(detail.getDesignation());
            carrosserie.setText(detail.getCarrosserie());
            carburant.setText(detail.getCarburant());
            puissance.setText(String.valueOf(detail.getPuissanceAdministrative()));
            consEU.setText(String.format("%.2f", detail.getConsommationExtraUrbaine()));
            consU.setText(String.format("%.2f", detail.getConsommationUrbaine()));
            consM.setText(String.format("%.2f", detail.getConsommationMixte()));

        }
    }

}
