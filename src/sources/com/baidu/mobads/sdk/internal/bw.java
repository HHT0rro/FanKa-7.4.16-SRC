package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bw implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9969a = "MD5";

    /* renamed from: b, reason: collision with root package name */
    public static final Parcelable.Creator<bw> f9970b = new bx();

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f9971c;

    /* renamed from: d, reason: collision with root package name */
    private double f9972d;

    /* renamed from: e, reason: collision with root package name */
    private String f9973e;

    /* renamed from: f, reason: collision with root package name */
    private String f9974f;

    /* renamed from: g, reason: collision with root package name */
    private String f9975g;

    /* renamed from: h, reason: collision with root package name */
    private int f9976h;

    /* renamed from: i, reason: collision with root package name */
    private int f9977i;

    public /* synthetic */ bw(Parcel parcel, bx bxVar) {
        this(parcel);
    }

    public Boolean a() {
        return Boolean.valueOf(this.f9977i == 1);
    }

    public double b() {
        return this.f9972d;
    }

    public String c() {
        return cp.a().c(this.f9973e);
    }

    public String d() {
        return this.f9974f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f9975g;
    }

    public Boolean f() {
        return Boolean.valueOf(this.f9976h == 1);
    }

    public String toString() {
        return this.f9971c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9974f);
        parcel.writeInt(this.f9977i);
        parcel.writeString(this.f9973e);
        parcel.writeDouble(this.f9972d);
        parcel.writeString(this.f9975g);
        parcel.writeInt(this.f9976h);
    }

    public bw(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f9971c = jSONObject;
            this.f9972d = jSONObject.getDouble("version");
            this.f9973e = this.f9971c.getString("url");
            this.f9974f = this.f9971c.getString(CardUriUtils.PARAM_SIGN);
            this.f9977i = 1;
            this.f9975g = "";
            this.f9976h = 0;
        } catch (JSONException unused) {
            this.f9977i = 0;
        }
        this.f9977i = c() == null ? 0 : 1;
    }

    public bw(bw bwVar, String str, Boolean bool) {
        this.f9972d = bwVar.b();
        this.f9973e = bwVar.c();
        this.f9974f = bwVar.d();
        this.f9977i = bwVar.a().booleanValue() ? 1 : 0;
        this.f9975g = str;
        this.f9976h = bool.booleanValue() ? 1 : 0;
    }

    private bw(Parcel parcel) {
        this.f9974f = parcel.readString();
        this.f9977i = parcel.readInt();
        this.f9973e = parcel.readString();
        this.f9972d = parcel.readDouble();
        this.f9975g = parcel.readString();
        this.f9976h = parcel.readInt();
    }
}
