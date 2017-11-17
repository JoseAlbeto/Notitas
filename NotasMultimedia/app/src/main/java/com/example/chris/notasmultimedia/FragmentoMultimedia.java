package com.example.chris.notasmultimedia;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by chris on 27/10/2017.
 */

public class FragmentoMultimedia extends Fragment {
    Button btnC,btnV,btnAgregIma,btnAgregVid;
    private final int REQUEST_ACCESS_OK=1;
    private Intent camP,camV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.multimedia,container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnC = view.findViewById(R.id.btnCamara);
        btnV=view.findViewById(R.id.btnVideo);
        btnAgregIma=view.findViewById(R.id.btnAbrirGaleria);
        btnAgregVid=view.findViewById(R.id.btnAgreVid);


        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(getView().getContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(view.getContext(), "YA EXISTE EL PERMISO", Toast.LENGTH_LONG).show();
                    camP = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(camP);
                } else {
                    ActivityCompat.requestPermissions((Activity) getView().getContext(), new String[]{Manifest.permission.CAMERA},REQUEST_ACCESS_OK);
                    Toast.makeText(getView().getContext(), "Pedimos el permiso con un cuadro de dialogo del sistema", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(getView().getContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(view.getContext(), "YA EXISTE EL PERMISO", Toast.LENGTH_LONG).show();
                    camV = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                    startActivity(camV);
                } else {
                    ActivityCompat.requestPermissions((Activity) getView().getContext(), new String[]{Manifest.permission.CAMERA},REQUEST_ACCESS_OK);
                    Toast.makeText(getView().getContext(), "Pedimos el permiso con un cuadro de dialogo del sistema", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnAgregIma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getView().getContext(),Activity_Imagen.class));
            }
        });

        btnAgregVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getView().getContext(),Activity_video.class));
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_ACCESS_OK) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getView().getContext(), "Permiso Concedido", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getView().getContext(), "Permiso No Concedido", Toast.LENGTH_LONG).show();
            }
        }
    }




}
