package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Path implements Parcelable {
    public static final Parcelable.Creator<Path> CREATOR = new Parcelable.Creator<Path>() { // from class: com.amap.api.services.route.Path.1
        private static Path a(Parcel parcel) {
            return new Path(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Path createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Path[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8833a;

    /* renamed from: b, reason: collision with root package name */
    private long f8834b;

    /* renamed from: c, reason: collision with root package name */
    private List<LatLonPoint> f8835c;

    public Path(Parcel parcel) {
        this.f8835c = new ArrayList();
        this.f8833a = parcel.readFloat();
        this.f8834b = parcel.readLong();
        this.f8835c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f8833a;
    }

    public long getDuration() {
        return this.f8834b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f8835c;
    }

    public void setDistance(float f10) {
        this.f8833a = f10;
    }

    public void setDuration(long j10) {
        this.f8834b = j10;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f8835c = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f8833a);
        parcel.writeLong(this.f8834b);
        parcel.writeTypedList(this.f8835c);
    }

    public Path() {
        this.f8835c = new ArrayList();
    }
}
