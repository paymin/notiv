package com.metamorfive.app.notiv;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FProfile extends Fragment {

    IListener mListener;

    public FProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_profile_view, container, false);
        view.findViewById(R.id.btnPost)
                .setOnClickListener(new View.OnClickListener(){
                    @Override
                    public  void onClick(View v){
                        mListener.toPostsPage();
                    }
                });
        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof FProfile.IListener){
            mListener = (FProfile.IListener) context;
        }
        else {
            throw new RuntimeException(context.toString()
                    + " must implement View2Fragment.IListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mListener = null;
    }

    interface IListener{
        void toPostsPage();
    }

}
