package nyc.c4q.artsy4android.artistpage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.artsy4android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class About_Fragment extends Fragment {


    public About_Fragment() {
        // Required empty public constructor
    }

    //TODO: 1) Create call for single artist via ID

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

}
