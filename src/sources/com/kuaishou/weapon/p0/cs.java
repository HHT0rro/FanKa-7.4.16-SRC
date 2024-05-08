package com.kuaishou.weapon.p0;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class cs {

    /* renamed from: a, reason: collision with root package name */
    private ct f35989a = new ct();

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            ct ctVar = new ct();
            int a10 = ctVar.a(TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("0", a10);
            }
            int a11 = ctVar.a(TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a11 > 0) {
                jSONObject.put("1", a11);
            }
            int a12 = ctVar.a(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a12 > 0) {
                jSONObject.put("2", a12);
            }
            int a13 = ctVar.a(Location.class, "getLatitude", new Object[0]);
            if (a13 > 0) {
                jSONObject.put("3", a13);
            }
            int a14 = ctVar.a(Location.class, "getLongitude", new Object[0]);
            if (a14 > 0) {
                jSONObject.put("4", a14);
            }
            int a15 = ctVar.a(WifiInfo.class, "getMacAddress", new Object[0]);
            if (a15 > 0) {
                jSONObject.put("6", a15);
            }
            int a16 = ctVar.a(WifiInfo.class, "getBSSID", new Object[0]);
            if (a16 > 0) {
                jSONObject.put("7", a16);
            }
            int a17 = ctVar.a(WifiInfo.class, "getRssi", new Object[0]);
            if (a17 > 0) {
                jSONObject.put("8", a17);
            }
            int a18 = ctVar.a(JSONObject.class, "toString", new Object[0]);
            if (a18 > 0) {
                jSONObject.put("9", a18);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            int a10 = this.f35989a.a();
            if (a10 <= 0) {
                return null;
            }
            int a11 = this.f35989a.a(a10, TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a11 > 0) {
                jSONObject.put("0", a11);
            }
            int a12 = this.f35989a.a(a10, TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a12 > 0) {
                jSONObject.put("1", a12);
            }
            int a13 = this.f35989a.a(a10, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a13 > 0) {
                jSONObject.put("2", a13);
            }
            int a14 = this.f35989a.a(a10, Location.class, "getLatitude", new Object[0]);
            if (a14 > 0) {
                jSONObject.put("3", a14);
            }
            int a15 = this.f35989a.a(a10, Location.class, "getLongitude", new Object[0]);
            if (a15 > 0) {
                jSONObject.put("4", a15);
            }
            int a16 = this.f35989a.a(a10, WifiInfo.class, "getMacAddress", new Object[0]);
            if (a16 > 0) {
                jSONObject.put("6", a16);
            }
            int a17 = this.f35989a.a(a10, WifiInfo.class, "getBSSID", new Object[0]);
            if (a17 > 0) {
                jSONObject.put("7", a17);
            }
            int a18 = this.f35989a.a(a10, WifiInfo.class, "getRssi", new Object[0]);
            if (a18 > 0) {
                jSONObject.put("8", a18);
            }
            int a19 = this.f35989a.a(a10, JSONObject.class, "toString", new Object[0]);
            if (a19 > 0) {
                jSONObject.put("9", a19);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
