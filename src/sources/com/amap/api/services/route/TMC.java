package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new Parcelable.Creator<TMC>() { // from class: com.amap.api.services.route.TMC.1
        private static TMC a(Parcel parcel) {
            return new TMC(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TMC createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TMC[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private int f9005a;

    /* renamed from: b, reason: collision with root package name */
    private String f9006b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f9007c;

    public TMC(Parcel parcel) {
        this.f9007c = new ArrayList();
        this.f9005a = parcel.readInt();
        this.f9006b = parcel.readString();
        this.f9007c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistance() {
        return this.f9005a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9007c;
    }

    public String getStatus() {
        return this.f9006b;
    }

    public void setDistance(int i10) {
        this.f9005a = i10;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9007c = list;
    }

    public void setStatus(String str) {
        this.f9006b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f9005a);
        parcel.writeString(this.f9006b);
        parcel.writeTypedList(this.f9007c);
    }

    public TMC() {
        this.f9007c = new ArrayList();
    }
}
