/*
 * Copyright (c) 2015. Antonio Cappiello
 * www.antoniocappiello.com
 */

package antoniocappiello.com.viewpagerwithcustomscroller;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemoPageFragment extends Fragment {

    public static final String POSITION = "POSITION";
    private int position;

    public DemoPageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.demo_page_fragment, container, false);
        TextView pagePositionTextView = (TextView) view.findViewById(R.id.page_position);
        pagePositionTextView.setText("" + position);
        return view;

    }
}
