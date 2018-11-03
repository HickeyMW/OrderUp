package com.wickeddevs.orderup.ui.role;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.wickeddevs.orderup.R;

import java.util.Arrays;
import java.util.List;

public class RoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        setTitle("Role Activity");

        findViewById(R.id.btnWaiter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed Waiter", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btnKitchen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed Kitchen", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btnBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pressed Bar", Toast.LENGTH_SHORT).show();
            }
        });

        List<AuthUI.IdpConfig> providers = Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build());
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(), 22);


    }
}
