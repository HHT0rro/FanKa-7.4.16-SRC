package com.huawei.uikit.hwviewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class HwPagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;

    /* renamed from: a, reason: collision with root package name */
    public final DataSetObservable f35300a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    public DataSetObserver f35301b;

    public void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f35301b = dataSetObserver;
        }
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
    }

    public void finishUpdate(@NonNull ViewGroup viewGroup) {
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object obj) {
        return -1;
    }

    public float getPageHeight(int i10) {
        return 1.0f;
    }

    @Nullable
    public CharSequence getPageTitle(int i10) {
        return null;
    }

    public float getPageWidth(int i10) {
        return 1.0f;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i10) {
        return null;
    }

    public abstract boolean isViewFromObject(@NonNull View view, @NonNull Object obj);

    public void notifyDataSetChanged() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.f35301b;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.f35300a.notifyChanged();
    }

    public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.f35300a.registerObserver(dataSetObserver);
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.f35300a.unregisterObserver(dataSetObserver);
    }
}
