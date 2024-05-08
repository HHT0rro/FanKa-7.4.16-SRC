package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Business implements Parcelable {
    public static final Parcelable.Creator<Business> CREATOR = new Parcelable.Creator<Business>() { // from class: com.amap.api.services.poisearch.Business.1
        private static Business a(Parcel parcel) {
            return new Business(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Business createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Business[] newArray(int i10) {
            return a(i10);
        }

        private static Business[] a(int i10) {
            return new Business[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8605a;

    /* renamed from: b, reason: collision with root package name */
    private String f8606b;

    /* renamed from: c, reason: collision with root package name */
    private String f8607c;

    /* renamed from: d, reason: collision with root package name */
    private String f8608d;

    /* renamed from: e, reason: collision with root package name */
    private String f8609e;

    /* renamed from: f, reason: collision with root package name */
    private String f8610f;

    /* renamed from: g, reason: collision with root package name */
    private String f8611g;

    /* renamed from: h, reason: collision with root package name */
    private String f8612h;

    /* renamed from: i, reason: collision with root package name */
    private String f8613i;

    /* renamed from: j, reason: collision with root package name */
    private String f8614j;

    public Business(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f8605a = str;
        this.f8606b = str2;
        this.f8607c = str3;
        this.f8608d = str4;
        this.f8609e = str5;
        this.f8610f = str6;
        this.f8611g = str7;
        this.f8612h = str8;
        this.f8613i = str9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlias() {
        return this.f8613i;
    }

    public String getBusinessArea() {
        return this.f8605a;
    }

    public String getCPID() {
        return this.f8614j;
    }

    public String getCost() {
        return this.f8611g;
    }

    public String getOpentimeToday() {
        return this.f8606b;
    }

    public String getOpentimeWeek() {
        return this.f8607c;
    }

    public String getParkingType() {
        return this.f8612h;
    }

    public String getTag() {
        return this.f8609e;
    }

    public String getTel() {
        return this.f8608d;
    }

    public String getmRating() {
        return this.f8610f;
    }

    public void setCPID(String str) {
        this.f8614j = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8605a);
        parcel.writeString(this.f8606b);
        parcel.writeString(this.f8607c);
        parcel.writeString(this.f8608d);
        parcel.writeString(this.f8609e);
        parcel.writeString(this.f8610f);
        parcel.writeString(this.f8611g);
        parcel.writeString(this.f8612h);
        parcel.writeString(this.f8613i);
        parcel.writeString(this.f8614j);
    }

    public Business(Parcel parcel) {
        this.f8605a = parcel.readString();
        this.f8606b = parcel.readString();
        this.f8607c = parcel.readString();
        this.f8608d = parcel.readString();
        this.f8609e = parcel.readString();
        this.f8610f = parcel.readString();
        this.f8611g = parcel.readString();
        this.f8612h = parcel.readString();
        this.f8613i = parcel.readString();
        this.f8614j = parcel.readString();
    }
}
