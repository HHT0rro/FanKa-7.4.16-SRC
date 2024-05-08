package com.jd.ad.sdk.dl.baseinfo;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_bo.jad_bo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class JADLocation {
    private double lat;
    private double lon;
    private double radius;

    public JADLocation() {
        this.lat = -1.0d;
        this.lon = -1.0d;
        this.radius = -1.0d;
    }

    public static JADLocation parseJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JADLocation();
        }
        JADLocation jADLocation = new JADLocation();
        jADLocation.setLatitude(jSONObject.optDouble("lat"));
        jADLocation.setLongitude(jSONObject.optDouble("lon"));
        jADLocation.setRadius(jSONObject.optDouble("radius"));
        return jADLocation;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public double getRadius() {
        return this.radius;
    }

    public boolean isValid() {
        return (Double.compare(this.lat, -1.0d) == 0 && Double.compare(this.lon, -1.0d) == 0 && Double.compare(this.radius, -1.0d) == 0) ? false : true;
    }

    public void setLatitude(double d10) {
        this.lat = d10;
    }

    public void setLongitude(double d10) {
        this.lon = d10;
    }

    public void setRadius(double d10) {
        this.radius = d10;
    }

    @NonNull
    public double[] toDoubleArray() {
        return new double[]{this.lat, this.lon, this.radius};
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lat", Double.valueOf(this.lat));
            jSONObject.putOpt("lon", Double.valueOf(this.lon));
            jSONObject.putOpt("radius", Double.valueOf(this.radius));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder jad_an = jad_bo.jad_an("JADLocation{lat=");
        jad_an.append(this.lat);
        jad_an.append(", lon=");
        jad_an.append(this.lon);
        jad_an.append(", radius=");
        jad_an.append(this.radius);
        jad_an.append('}');
        return jad_an.toString();
    }

    public JADLocation(double d10, double d11, double d12) {
        this.lat = d10;
        this.lon = d11;
        this.radius = d12;
    }
}
