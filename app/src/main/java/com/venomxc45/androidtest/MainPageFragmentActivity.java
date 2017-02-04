package com.venomxc45.androidtest;

import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

    /**
     * Fragment that demonstrates how to use CardView.
     */
    public class MainPageFragmentActivity extends Fragment {

        private static final String TAG = MainPageFragmentActivity.class.getSimpleName();

        /** The CardView widget. */
        //@VisibleForTesting
        CardView mCardView;

        /**
         * SeekBar that changes the cornerRadius attribute for the {@link #mCardView} widget.
         */
        //@VisibleForTesting
        SeekBar mRadiusSeekBar;

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment NotificationFragment.
         */
        public static MainPageFragmentActivity newInstance() {
            MainPageFragmentActivity fragment = new MainPageFragmentActivity();
            fragment.setRetainInstance(true);
            return fragment;
        }

        public MainPageFragmentActivity() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.activity_main_page_fragment, container, false);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            mCardView = (CardView) view.findViewById(R.id.cardview);
            mRadiusSeekBar = (SeekBar) view.findViewById(R.id.cardview_radius_seekbar);
            mRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    Log.d(TAG, String.format("SeekBar Radius progress : %d", progress));
                    mCardView.setRadius(progress);
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    //Do nothing
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    //Do nothing
                }
            });


        }
    }