package antoniocappiello.com.viewpagerwithcustomscroller;/*
 * Created by a.cappiello on 23-10-2015 - 16:26.
 * Copyright (c) 2015. Coolblue. All rights reserved.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DemoPageFragment extends Fragment {

    private final int position;

    public DemoPageFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.demo_page_fragment, container, false);
        TextView pagePositionTextView = (TextView) view.findViewById(R.id.page_position);
        pagePositionTextView.setText("PAGE " + position);
        return view;

    }
}
