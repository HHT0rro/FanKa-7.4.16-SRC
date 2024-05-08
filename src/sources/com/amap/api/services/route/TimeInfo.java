package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new Parcelable.Creator<TimeInfo>() { // from class: com.amap.api.services.route.TimeInfo.1
        private static TimeInfo a(Parcel parcel) {
            return new TimeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfo[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private long f9022a;

    /* renamed from: b, reason: collision with root package name */
    private List<TimeInfosElement> f9023b;

    public TimeInfo(Parcel parcel) {
        this.f9023b = new ArrayList();
        this.f9022a = parcel.readInt();
        this.f9023b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TimeInfosElement> getElements() {
        return this.f9023b;
    }

    public long getStartTime() {
        return this.f9022a;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.f9023b = list;
    }

    public void setStartTime(long j10) {
        this.f9022a = j10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f9022a);
        parcel.writeTypedList(this.f9023b);
    }

    public TimeInfo() {
        this.f9023b = new ArrayList();
    }
}
