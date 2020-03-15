package com.royaldreams.coronavirustracker;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeocodingLocation {

    private static final String TAG = "GeocodingLocation";
    public static String getAddressFromLocation(final String locationAddress,
                                                final Context context) {

        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        String result = "20.5937\n78.9629";
        List addressList = null;
        try {
            addressList = geocoder.getFromLocationName(locationAddress, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addressList != null && addressList.size() > 0) {
                Address address = (Address) addressList.get(0);
                StringBuilder sb = new StringBuilder();
                sb.append(address.getLatitude()).append("\n");
                sb.append(address.getLongitude());
                result = sb.toString();

    /*
        Thread thread = new Thread() {
            @Override
            public void run() {

                    }
                } catch (IOException e) {
                    Log.e(TAG, "Unable to connect to Geocoder", e);
                } finally {

                }
            }
        };
        thread.start();
        return result;*/

    }
        return result;
}
}
