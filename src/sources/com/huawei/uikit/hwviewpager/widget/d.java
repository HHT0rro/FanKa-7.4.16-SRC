package com.huawei.uikit.hwviewpager.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d extends HwPagerAdapter {

    /* renamed from: c, reason: collision with root package name */
    public static final int f35446c = 4;

    /* renamed from: d, reason: collision with root package name */
    public static final int f35447d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f35448e = 1;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final HwPagerAdapter f35449f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f35450g;

    /* renamed from: h, reason: collision with root package name */
    public int f35451h = 4;

    /* renamed from: i, reason: collision with root package name */
    public int f35452i = 2;

    /* renamed from: j, reason: collision with root package name */
    public SparseArray<a> f35453j = new SparseArray<>();

    /* renamed from: k, reason: collision with root package name */
    public boolean f35454k;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup f35455a;

        /* renamed from: b, reason: collision with root package name */
        public int f35456b;

        /* renamed from: c, reason: collision with root package name */
        public Object f35457c;

        public a(ViewGroup viewGroup, int i10, Object obj) {
            this.f35455a = viewGroup;
            this.f35456b = i10;
            this.f35457c = obj;
        }
    }

    public d(@NonNull HwPagerAdapter hwPagerAdapter, boolean z10) {
        this.f35449f = hwPagerAdapter;
        this.f35450g = z10;
    }

    private int d() {
        return this.f35452i;
    }

    private int e() {
        return (c() + d()) - 1;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void a(DataSetObserver dataSetObserver) {
        this.f35449f.a(dataSetObserver);
    }

    public int b(int i10) {
        return i10 + this.f35452i;
    }

    public int c(int i10) {
        int c4 = c();
        if (c4 == 0) {
            return 0;
        }
        int i11 = (i10 - this.f35452i) % c4;
        return i11 < 0 ? i11 + c4 : i11;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        int d10 = d();
        int e2 = e();
        int c4 = this.f35450g ? c(i10) : i10;
        if (this.f35454k && (i10 == d10 || i10 == e2)) {
            this.f35453j.put(i10, new a(viewGroup, c4, obj));
        } else {
            this.f35449f.destroyItem(viewGroup, c4, obj);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        this.f35449f.finishUpdate(viewGroup);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getCount() {
        return this.f35450g ? this.f35449f.getCount() + this.f35451h : this.f35449f.getCount();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return this.f35449f.getItemPosition(obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public CharSequence getPageTitle(int i10) {
        if (this.f35450g) {
            i10 = c(i10);
        }
        return this.f35449f.getPageTitle(i10);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public float getPageWidth(int i10) {
        if (this.f35450g) {
            i10 = c(i10);
        }
        return this.f35449f.getPageWidth(i10);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i10) {
        a aVar;
        int c4 = this.f35450g ? c(i10) : i10;
        if (this.f35454k && (aVar = this.f35453j.get(i10)) != null) {
            this.f35453j.remove(i10);
            return aVar.f35457c;
        }
        return this.f35449f.instantiateItem(viewGroup, c4);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return this.f35449f.isViewFromObject(view, obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void notifyDataSetChanged() {
        this.f35453j = new SparseArray<>();
        this.f35449f.notifyDataSetChanged();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.f35449f.registerDataSetObserver(dataSetObserver);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.f35449f.restoreState(parcelable, classLoader);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public Parcelable saveState() {
        return this.f35449f.saveState();
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i10, @NonNull Object obj) {
        if (this.f35450g) {
            i10 = c(i10);
        }
        this.f35449f.setPrimaryItem(viewGroup, i10, obj);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        this.f35449f.startUpdate(viewGroup);
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerAdapter
    public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        this.f35449f.unregisterDataSetObserver(dataSetObserver);
    }

    public void a(boolean z10) {
        this.f35454k = z10;
    }

    public HwPagerAdapter b() {
        return this.f35449f;
    }

    public void a(int i10) {
        int i11 = i10 - 1;
        this.f35452i = i11;
        this.f35451h = i10 + i11;
    }

    public int c() {
        return this.f35449f.getCount();
    }

    public int a() {
        return this.f35451h;
    }
}
