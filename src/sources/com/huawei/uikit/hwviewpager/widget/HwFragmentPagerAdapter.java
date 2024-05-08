package com.huawei.uikit.hwviewpager.widget;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.huawei.openalliance.ad.constant.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class HwFragmentPagerAdapter extends HwPagerAdapter {

    /* renamed from: c, reason: collision with root package name */
    public static final String f35286c = "HwFragmentPagerAdapter";

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f35287d = false;

    /* renamed from: e, reason: collision with root package name */
    public final FragmentManager f35288e;

    /* renamed from: f, reason: collision with root package name */
    public FragmentTransaction f35289f = null;

    /* renamed from: g, reason: collision with root package name */
    public Fragment f35290g = null;

    public HwFragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f35288e = fragmentManager;
    }

    public static String a(int i10, long j10) {
        return "android:switcher:" + i10 + u.bD + j10;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        if (this.f35289f == null) {
            this.f35289f = this.f35288e.beginTransaction();
        }
        this.f35289f.detach((Fragment) obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f35289f;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitNowAllowingStateLoss();
            this.f35289f = null;
        }
    }

    public abstract Fragment getItem(int i10);

    public long getItemId(int i10) {
        return i10;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i10) {
        if (this.f35289f == null) {
            this.f35289f = this.f35288e.beginTransaction();
        }
        long itemId = getItemId(i10);
        Fragment findFragmentByTag = this.f35288e.findFragmentByTag(a(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            this.f35289f.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i10);
            this.f35289f.add(viewGroup.getId(), findFragmentByTag, a(viewGroup.getId(), itemId));
        }
        if (findFragmentByTag != this.f35290g) {
            findFragmentByTag.setMenuVisibility(false);
            findFragmentByTag.setUserVisibleHint(false);
        }
        return findFragmentByTag;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f35290g;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f35290g.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.f35290g = fragment;
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + ((Object) this) + " requires a view id");
    }
}
