package com.example.hitma;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InecDashboards.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InecDashboards#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InecDashboards extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    boolean chapter1Completed = false;
    boolean chapter2Completed = false;
    boolean chapter3Completed = false;

    private OnFragmentInteractionListener mListener;

    public InecDashboards() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InecDashboards.
     */
    // TODO: Rename and change types and number of parameters
    public static InecDashboards newInstance(String param1, String param2) {
        InecDashboards fragment = new InecDashboards();
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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_inec_dashboards, container, false);

        final String status = "false";
        final String courseName = "";


        //chapter 1
        RelativeLayout chapter1 = v.findViewById(R.id.rt1);
        chapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), InecCourseOne.class);
                i.putExtra("stats", status);
                i.putExtra("chapter_name", "chapter one");
                i.putExtra("courseName", courseName);
                startActivity(i);
            }
        });
        RelativeLayout rellay2 = v.findViewById(R.id.rt11);
        rellay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), InecCourseOne.class);
                i.putExtra("stats", status);
                i.putExtra("chapter_name", "chapter one");
                i.putExtra("courseName", courseName);
                startActivity(i);
            }
        });
        TextView txt2 = v.findViewById(R.id.txt_course1);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), InecCourseOne.class);
                i.putExtra("stats", status);
                i.putExtra("chapter_name", "chapter one");
                i.putExtra("courseName", courseName);
                startActivity(i);
            }
        });



        //chapter 2
        RelativeLayout chapter2 = v.findViewById(R.id.rt2);
        chapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 1 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter one

                if (chapter1Completed == false){
                    //stay and pop up window
                }else{
                    Intent j = new Intent(getActivity(), InecCourseTwo.class);
                    startActivity(j);
                }


            }
        });
        RelativeLayout rellay22 = v.findViewById(R.id.rt22);
        rellay22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 1 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter one

                if (chapter1Completed == false){
                    //stay and pop up window
                }else{
                    Intent j = new Intent(getActivity(), InecCourseTwo.class);
                    startActivity(j);
                }
            }
        });
        TextView txt3 = v.findViewById(R.id.txt_course2);
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 1 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter one

                if (chapter1Completed == false){
                    //stay and pop up window
                }else{
                    Intent j = new Intent(getActivity(), InecCourseTwo.class);
                    startActivity(j);
                }
            }
        });




        //chapter 3
        RelativeLayout chapter3 = v.findViewById(R.id.rt3);
        chapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 2 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter two

                if (chapter2Completed == false){
                    //stay and pop up window
                }else{
                    Intent k = new Intent(getActivity(), InecCourseThree.class);
                    startActivity(k);
                }
            }
        });
        RelativeLayout rellay33 = v.findViewById(R.id.rt33);
        rellay33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 2 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter two

                if (chapter2Completed == false){
                    //stay and pop up window
                }else{
                    Intent k = new Intent(getActivity(), InecCourseThree.class);
                    startActivity(k);
                }
            }
        });
        TextView txt4 = v.findViewById(R.id.txt_course3);
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 2 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter two

                if (chapter2Completed == false){
                    //stay and pop up window
                }else{
                    Intent k = new Intent(getActivity(), InecCourseThree.class);
                    startActivity(k);
                }
            }
        });




        //chapter 4
        RelativeLayout chapter4 = v.findViewById(R.id.rt4);
        chapter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 3 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter three

                if (chapter3Completed == false){
                    //stay and pop up window
                }else{
                    Intent l = new Intent(getActivity(), InecCourseFour.class);
                    startActivity(l);
                }
            }
        });
        RelativeLayout rellay44 = v.findViewById(R.id.rt44);
        rellay44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 3 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter three

                if (chapter3Completed == false){
                    //stay and pop up window
                }else{
                    Intent l = new Intent(getActivity(), InecCourseFour.class);
                    startActivity(l);
                }


            }
        });
        TextView txt5 = v.findViewById(R.id.txt_course4);
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if chapter 3 is complete. If it is, move to next chapter
                //else pop up the message to complete chapter three

                if (chapter3Completed == false){
                    //stay and pop up window
                }else{
                    Intent l = new Intent(getActivity(), InecCourseFour.class);
                    startActivity(l);
                }
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
