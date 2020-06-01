package org.meicode.callbacks;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private TextView txtName;
    private EditText edtTxtName;
    private Button btnSend;

    private SendNameInterface sendNameInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        txtName = view.findViewById(R.id.txtName);
        edtTxtName = view.findViewById(R.id.edtTxtName);
        btnSend = view.findViewById(R.id.btnSend);

        try {
            sendNameInterface = (SendNameInterface) getActivity();
        }catch (ClassCastException e) {
            sendNameInterface = null;
            e.printStackTrace();
        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != sendNameInterface) {
                    sendNameInterface.sendNameResult(edtTxtName.getText().toString());
                }
            }
        });

        Bundle bundle = getArguments();
        if (null != bundle) {
            String name = bundle.getString("name");
            if (null != name) {
                txtName.setText(name);
            }
        }
        return view;
    }
}
