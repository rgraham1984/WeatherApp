package com.example.rgraham.weatherapp;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;


/**
 * Created by rgraham on 1/28/15.
 */
public class GetCurrentLocation extends Activity {


    static final String latLonBaseUrl = "http://api.openweathermap.org/data/2.5/find?";

    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    private static Criteria searchProviderCriteria = new Criteria();

    static {
        searchProviderCriteria.setPowerRequirement(Criteria.POWER_LOW);
        searchProviderCriteria.setAccuracy(Criteria.ACCURACY_FINE);
    }

    String provider = locationManager.getBestProvider(searchProviderCriteria, true);
    Location loc = locationManager.getLastKnownLocation(provider);
    String lastKnownLoc = loc.toString();
    int timeOut = 30;
    double SystemUpTime = SystemClock.elapsedRealtime();


    // This code is not working. I have to figure out why. The idea is to have the app pull in the users current location
    // and then query the backend. Commenting it out until I fix this bit

   /* if(loc==null||(SystemUpTime-loc.getTime)>timeOut)

    {
        locationManager.requestSingleUpdate(provider, locListener, null);
    }

    else

    {
        new Read().execute(lastKnownLoc);
    }

    */

    LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            String sLat = "" + location.getLatitude();
            String sLon = "" + location.getLongitude();

            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.removeUpdates(locListener);

            StringBuilder URL = new StringBuilder(latLonBaseUrl);
            URL.append(sLat + sLon + "&APPID=7294c49c972a84832b19e0225dd8cb44&mode=xml");
            String fullLatLonUrl = URL.toString();
            // new Read().execute(fullLatLonUrl);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
}
