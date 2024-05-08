package com.huawei.uikit.hwviewpager.widget;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class HwFragmentStatePagerAdapter extends HwPagerAdapter {

    /* renamed from: c, reason: collision with root package name */
    public static final String f35291c = "HwFragmentStatePagerAdapt";

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f35292d = false;

    /* renamed from: e, reason: collision with root package name */
    public static final int f35293e = -1;

    /* renamed from: f, reason: collision with root package name */
    public final FragmentManager f35294f;

    /* renamed from: g, reason: collision with root package name */
    public FragmentTransaction f35295g = null;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<Fragment.SavedState> f35296h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<Fragment> f35297i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public Fragment f35298j = null;

    public HwFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f35294f = fragmentManager;
    }

    private void a(Parcelable[] parcelableArr) {
        for (int i10 = 0; i10 < parcelableArr.length; i10++) {
            if (parcelableArr[i10] instanceof Fragment.SavedState) {
                this.f35296h.add((Fragment.SavedState) parcelableArr[i10]);
            }
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f35295g == null) {
            this.f35295g = this.f35294f.beginTransaction();
        }
        while (this.f35296h.size() <= i10) {
            this.f35296h.add(null);
        }
        this.f35296h.set(i10, fragment.isAdded() ? this.f35294f.saveFragmentInstanceState(fragment) : null);
        this.f35297i.set(i10, null);
        this.f35295g.remove(fragment);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f35295g;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitNowAllowingStateLoss();
            this.f35295g = null;
        }
    }

    public abstract Fragment getItem(int i10);

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i10) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f35297i.size() > i10 && (fragment = this.f35297i.get(i10)) != null) {
            return fragment;
        }
        if (this.f35295g == null) {
            this.f35295g = this.f35294f.beginTransaction();
        }
        Fragment item = getItem(i10);
        if (this.f35296h.size() > i10 && (savedState = this.f35296h.get(i10)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f35297i.size() <= i10) {
            this.f35297i.add(null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.f35297i.set(i10, item);
        this.f35295g.add(viewGroup.getId(), item);
        return item;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Parcelable[] parcelableArr;
        int i10;
        if (parcelable != null && (parcelable instanceof Bundle)) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Set<String> set = null;
            try {
                parcelableArr = bundle.getParcelableArray("states");
            } catch (BadParcelableException unused) {
                parcelableArr = null;
            }
            this.f35296h.clear();
            this.f35297i.clear();
            if (parcelableArr != null) {
                a(parcelableArr);
            }
            try {
                set = bundle.keySet();
            } catch (BadParcelableException unused2) {
            }
            if (set == null) {
                return;
            }
            for (String str : set) {
                if (str.startsWith("f")) {
                    try {
                        i10 = Integer.parseInt(str.substring(1));
                    } catch (NumberFormatException unused3) {
                        i10 = -1;
                    }
                    if (i10 != -1) {
                        a(str, i10, this.f35294f.getFragment(bundle, str));
                    }
                }
            }
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f35296h.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f35296h.size()];
            this.f35296h.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i10 = 0; i10 < this.f35297i.size(); i10++) {
            Fragment fragment = this.f35297i.get(i10);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f35294f.putFragment(bundle, "f" + i10, fragment);
            }
        }
        return bundle;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f35298j;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f35298j.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.f35298j = fragment;
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + ((Object) this) + " requires a view id");
    }

    private void a(String str, int i10, Fragment fragment) {
        if (fragment != null) {
            while (this.f35297i.size() <= i10) {
                this.f35297i.add(null);
            }
            fragment.setMenuVisibility(false);
            this.f35297i.set(i10, fragment);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bad fragment at key ");
        sb2.append(str);
    }
}
