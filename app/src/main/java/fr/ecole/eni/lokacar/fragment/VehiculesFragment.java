package fr.ecole.eni.lokacar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.adapter.VehiculesRecyclerViewAdapter;
import fr.ecole.eni.lokacar.bean.Vehicule;

public class VehiculesFragment extends Fragment {

    private RecyclerView recyclerView;
    private OnListFragmentInteractionListener mListener;

    public VehiculesFragment() {
    }

    public static VehiculesFragment newInstance(int columnCount) {
        VehiculesFragment fragment = new VehiculesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicules, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            // Pas d'adapter ici car la liste n'est pas encore créée
        }
        return view;
    }

    /**
     * Charge l'adapter du recycler view
     * @param adapter
     */
    public void setAdapter(VehiculesRecyclerViewAdapter adapter){
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Vehicule item);
    }
}
