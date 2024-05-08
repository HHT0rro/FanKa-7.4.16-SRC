package com.huawei.uikit.hwviewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class m implements Parcelable.ClassLoaderCreator<HwViewPager.SavedState> {
    @Override // android.os.Parcelable.Creator
    public HwViewPager.SavedState[] newArray(int i10) {
        return new HwViewPager.SavedState[i10];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.ClassLoaderCreator
    public HwViewPager.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new HwViewPager.SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable.Creator
    public HwViewPager.SavedState createFromParcel(Parcel parcel) {
        return new HwViewPager.SavedState(parcel, null);
    }
}
