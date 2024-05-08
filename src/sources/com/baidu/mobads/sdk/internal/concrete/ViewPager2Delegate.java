package com.baidu.mobads.sdk.internal.concrete;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ViewPager2Delegate extends ViewPager2 implements a {

    /* renamed from: m, reason: collision with root package name */
    private static final String f10094m = "getScrollState";

    /* renamed from: n, reason: collision with root package name */
    private static final String f10095n = "getCurrentItem";

    /* renamed from: o, reason: collision with root package name */
    private static final String f10096o = "setCurrentItem";

    /* renamed from: p, reason: collision with root package name */
    private static final String f10097p = "setOrientation";

    /* renamed from: q, reason: collision with root package name */
    private static final String f10098q = "setAdapter";

    /* renamed from: r, reason: collision with root package name */
    private static final String f10099r = "setOffscreenPageLimit";

    /* renamed from: s, reason: collision with root package name */
    private static final String f10100s = "setUserInputEnabled";

    /* renamed from: t, reason: collision with root package name */
    private final c f10101t;

    public ViewPager2Delegate(IAdInterListener iAdInterListener, Context context) {
        super(context);
        this.f10101t = c.a(iAdInterListener, this);
        setOnOverScrollListener(new ViewPager2.OnOverScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollEnd() {
                ViewPager2Delegate.this.f10101t.a("onOverScrollEnd");
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollStart() {
                ViewPager2Delegate.this.f10101t.a("onOverScrollStart");
            }
        });
        registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                ViewPager2Delegate.this.f10101t.a("onPageScrollStateChanged", Integer.valueOf(i10));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i10, float f10, int i11) {
                ViewPager2Delegate.this.f10101t.a("onPageScrolled", Integer.valueOf(i10), Float.valueOf(f10), Integer.valueOf(i11));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                ViewPager2Delegate.this.f10101t.a("onPageSelected", Integer.valueOf(i10));
            }
        });
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f10101t.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f10101t.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f10101t.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f10101t.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f10101t.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f10101t.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f10094m.equals(str2)) {
            return Integer.valueOf(getScrollState());
        }
        if (f10095n.equals(str2)) {
            return Integer.valueOf(getCurrentItem());
        }
        if (f10096o.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setCurrentItem(((Integer) objArr[0]).intValue());
            return null;
        }
        if (f10097p.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setOrientation(((Integer) objArr[0]).intValue());
            return null;
        }
        if (f10098q.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{RecyclerView.Adapter.class})) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if (f10099r.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setOffscreenPageLimit(((Integer) objArr[0]).intValue());
            return null;
        }
        if (!f10100s.equals(str2) || !c.a(objArr, (Class<?>[]) new Class[]{Boolean.class})) {
            return null;
        }
        setUserInputEnabled(((Boolean) objArr[0]).booleanValue());
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f10101t.setTarget(obj);
    }
}
