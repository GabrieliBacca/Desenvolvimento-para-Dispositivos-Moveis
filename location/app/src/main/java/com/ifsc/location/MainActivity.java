package com.ifsc.location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.*;
import com.google.android.gms.location.FusedLocationProviderClient;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MainActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private FusedLocationProviderClient fusedLocationClient;
    private TextView txtCoordenadas;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;

    private MapView map;
    private boolean track = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration.getInstance().setUserAgentValue(this.getPackageName());

        Button home = findViewById(R.id.viewHome);

        home.setOnClickListener(v->{
            track = true;
        });

        map = findViewById(R.id.map);

        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                track = false;
                return false;
            }
        });
        map.getController().setZoom(18);

        txtCoordenadas = findViewById(R.id.txtCoordenadas);
        Button btnGetLocation = findViewById(R.id.btnGetLocation);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //configura a solicitação de localização
        locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000)
                .setWaitForAccurateLocation(true)

                .build();

        //configura o callback para receber as atualizações de localização  ou objeto LocationResult
        // VERSÃO ÚNICA
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                Location location = locationResult.getLastLocation();
                if (location != null) {
                    txtCoordenadas.setText("Latitude: " + location.getLatitude() + "\nLongitude: " + location.getLongitude());
                } else {
                    txtCoordenadas.setText("Localização não disponível");
                }
            }
        };

        //configra o botão para obter a localização
        btnGetLocation.setOnClickListener(v -> getLocation());
    }

    public void getLocation() {
        //checa se a permissão de localização foi concedida usando o ActivityCompat do AndroidX
        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) || (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    LOCATION_PERMISSION_REQUEST_CODE);
            return;
        }

        fusedLocationClient.requestLocationUpdates(locationRequest, locationListener, Looper.getMainLooper());

    }

    public final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            double latitude = location.getLatitude(), longitude = location.getLongitude();
            txtCoordenadas.setText("Latitude: " + latitude + "\nLongitude: " + longitude);
            showLocalizacao(latitude, longitude);
        }
    };

    public void showLocalizacao(double latitutde, double longitude){
        map.getOverlays().clear();
        GeoPoint userLocation = new GeoPoint(latitutde, longitude);
        Marker marker = new Marker(map);
        marker.setTitle("Usuário");
        marker.setPosition(userLocation);
        if ( track ) {
            map.getController().setCenter(userLocation);
        }
        map.getOverlays().add(marker);
        map.invalidate();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                Toast.makeText(this, "Permissão de localização negada", Toast.LENGTH_SHORT).show();
            }
        }
    }
}