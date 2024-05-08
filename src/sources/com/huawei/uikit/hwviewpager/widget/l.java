package com.huawei.uikit.hwviewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l implements Parcelable.ClassLoaderCreator<HwViewPager.RtlSavedState> {
    @Override // android.os.Parcelable.Creator
    public HwViewPager.RtlSavedState[] newArray(int i10) {
        return new HwViewPager.RtlSavedState[i10];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public HwViewPager.RtlSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new HwViewPager.RtlSavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public HwViewPager.RtlSavedState createFromParcel(Parcel parcel) {
        return new HwViewPager.RtlSavedState(parcel, null);
    }
}
