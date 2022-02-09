package com.example.hitma;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProgressReport.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProgressReport#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProgressReport extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProgressReport() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProgressReport.
     */
    // TODO: Rename and change types and number of parameters
    public static ProgressReport newInstance(String param1, String param2) {
        ProgressReport fragment = new ProgressReport();
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
        View v = inflater.inflate(R.layout.fragment_progress_report, container, false);

        final TextView course_completed_weekly = v.findViewById(R.id.courses_completed_this_week);
        final TextView total_course_completed = v.findViewById(R.id.total_courses_completed);
        final TextView total_course_completed_percentage = v.findViewById(R.id.total_courses_completed_percentage);
        final TextView test_completed_weekly = v.findViewById(R.id.test_completed_this_week);
        final TextView total_test_completed = v.findViewById(R.id.total_test_completed);
        final TextView total_test_completed_percentage = v.findViewById(R.id.total_test_completed_percentage);
        final TextView weekly_ranks = v.findViewById(R.id.weekly_ranking);
        final TextView overall_ranks = v.findViewById(R.id.overall_ranking);

        final String RANKING_URL = "http://54.71.22.155/hitma/mobile/user_rank";
        final ProgressDialog progressDialog = new ProgressDialog(getActivity().getApplicationContext());

        //using shared preference to get the email address passed
        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        final String mai = pref.getString("email", "");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, RANKING_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //progressDialog.dismiss();

                        try{

                            // get JSONObject from JSON file
                            JSONObject jsonObject = new JSONObject(response);
                            String overall_course_completed = jsonObject.getString("overall_course_completed");
                            String overall_course_percentage = jsonObject.getString("overall_course_percent");
                            String overall_rank = jsonObject.getString("overall_rank");
                            String overall_tests_completed = jsonObject.getString("overall_test_completed");
                            String overall_no_of_attempts = jsonObject.getString("overall_no_of_attempts");
                            String weekly_rank = jsonObject.getString("weekly_rank");
                            String weekly_course_completed = jsonObject.getString("weekly_course_completed");
                            String weekly_test_completed = jsonObject.getString("weekly_test_completed");
                            String weekly_no_of_attempts = jsonObject.getString("weekly_no_of_attempts");

                            overall_ranks.setText(overall_rank);
                            weekly_ranks.setText(weekly_rank);
                            total_test_completed.setText(overall_tests_completed);
                            test_completed_weekly.setText(weekly_test_completed);
                            course_completed_weekly.setText(weekly_course_completed);
                            total_course_completed.setText(overall_course_completed);
                            total_course_completed_percentage.setText(overall_course_percentage);
                            total_test_completed_percentage.setText(overall_no_of_attempts);



                        }catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(getActivity().getApplicationContext(), "Problem loading ranks"+e.getMessage(), Toast.LENGTH_LONG).show();
                            System.out.print("JSONException error = "+e.getMessage());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        //progressDialog.dismiss();

                        Toast.makeText(getActivity().getApplicationContext(), "Problem loading ranks "+error.getMessage(), Toast.LENGTH_LONG).show();
                        System.out.print("On response error = "+error.getMessage());
                    }
                }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", mai);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(stringRequest);



        LinearLayout editProfile = v.findViewById(R.id.editProfile);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ItmaEditProfile.class);
                startActivity(i);
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
