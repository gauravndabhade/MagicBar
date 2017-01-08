package com.gaurav.magicbar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class SeekBarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener{
    private EditText edittext;
    private FragmentCommunicationnListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.seekbar_fragment,
                container, false);

        edittext = (EditText) view.findViewById(R.id.editText1);
        final SeekBar seekbar = (SeekBar) view.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCommunicationnListener) {
            mListener = (FragmentCommunicationnListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentCommunicationnListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            mListener.onButtonClick(progress,edittext.getText().toString());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if(edittext.getText().toString().equals("")){
            Toast.makeText(getContext(),"Please Enter Your Name.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public interface FragmentCommunicationnListener {
        void onButtonClick(int position, String text);
    }
}
