package com.autonavi.aps.amapapi.restruct;

import com.amap.api.maps.model.MyLocationStyle;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: HistoryLocation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f9472a = 0;

    /* renamed from: b, reason: collision with root package name */
    public double f9473b = ShadowDrawableWrapper.COS_45;

    /* renamed from: c, reason: collision with root package name */
    public double f9474c = ShadowDrawableWrapper.COS_45;

    /* renamed from: d, reason: collision with root package name */
    public long f9475d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f9476e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f9477f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f9478g = 63;

    /* renamed from: h, reason: collision with root package name */
    public int f9479h = 0;

    public final String a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("time", this.f9475d);
            jSONObject.put("lon", this.f9474c);
            jSONObject.put("lat", this.f9473b);
            jSONObject.put("radius", this.f9476e);
            jSONObject.put(MyLocationStyle.LOCATION_TYPE, this.f9472a);
            jSONObject.put("reType", this.f9478g);
            jSONObject.put("reSubType", this.f9479h);
        } catch (Throwable unused) {
            jSONObject = null;
        }
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f9472a == fVar.f9472a && Double.compare(fVar.f9473b, this.f9473b) == 0 && Double.compare(fVar.f9474c, this.f9474c) == 0 && this.f9475d == fVar.f9475d && this.f9476e == fVar.f9476e && this.f9477f == fVar.f9477f && this.f9478g == fVar.f9478g && this.f9479h == fVar.f9479h) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f9472a), Double.valueOf(this.f9473b), Double.valueOf(this.f9474c), Long.valueOf(this.f9475d), Integer.valueOf(this.f9476e), Integer.valueOf(this.f9477f), Integer.valueOf(this.f9478g), Integer.valueOf(this.f9479h));
    }

    public final void a(JSONObject jSONObject) {
        try {
            this.f9473b = jSONObject.optDouble("lat", this.f9473b);
            this.f9474c = jSONObject.optDouble("lon", this.f9474c);
            this.f9472a = jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, this.f9472a);
            this.f9478g = jSONObject.optInt("reType", this.f9478g);
            this.f9479h = jSONObject.optInt("reSubType", this.f9479h);
            this.f9476e = jSONObject.optInt("radius", this.f9476e);
            this.f9475d = jSONObject.optLong("time", this.f9475d);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CoreUtil", "transformLocation");
        }
    }
}
