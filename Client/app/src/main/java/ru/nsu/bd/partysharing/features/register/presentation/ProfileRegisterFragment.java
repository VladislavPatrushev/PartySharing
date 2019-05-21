package ru.nsu.bd.partysharing.features.register.presentation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import ru.nsu.bd.partysharing.R;
import ru.nsu.bd.partysharing.util.Converter;
import ru.nsu.bd.partysharing.util.TextChecker;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileRegisterFragment extends Fragment {

    public static final int PICK_IMAGE = 1;

    private EditText nameField;
    private EditText lastnameField;
    private EditText ageField;
    private EditText cityField;

    private ImageButton imageButton;

    private TextView errorView;

    private Button registerButton;
    private RegisterActivity activity;
    private RegisterPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initViews(view);
        initListeners();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (RegisterActivity)getActivity();
        presenter = activity.accessPresenter();
    }

    private void initViews(View rootView) {
        imageButton = rootView.findViewById(R.id.image_button);
        nameField = rootView.findViewById(R.id.name_reg);
        lastnameField = rootView.findViewById(R.id.lastname_reg);
        ageField = rootView.findViewById(R.id.age_reg);
        cityField = rootView.findViewById(R.id.city_reg);
        registerButton = rootView.findViewById(R.id.register_butt);
        errorView = rootView.findViewById(R.id.register_error);
    }

    private void initListeners() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextChecker.isEmpty(nameField) && !TextChecker.isEmpty(lastnameField) &&
                        !TextChecker.isEmpty(ageField) && !TextChecker.isEmpty(cityField)) {
                    presenter.setName(nameField.getText().toString());
                    presenter.setLastname(lastnameField.getText().toString());
                    presenter.setAge(Integer.valueOf(ageField.getText().toString()));
                    presenter.setLocation(cityField.getText().toString());
                    presenter.register(activity);
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE) {
            if (data == null) {
                return;
            }
            try {
                InputStream inputStream = activity.getContentResolver().openInputStream(data.getData());
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageButton.setImageBitmap(bitmap);
                presenter.setImage(Converter.bitmapToBase64(bitmap));
            } catch (FileNotFoundException e) {
                //pass
            }
        }
    }

    public void showError(String error) {
        errorView.setText(error);
        errorView.setVisibility(View.VISIBLE);
    }

}
