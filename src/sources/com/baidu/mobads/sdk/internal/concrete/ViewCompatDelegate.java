package com.baidu.mobads.sdk.internal.concrete;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.bk;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ViewCompatDelegate implements a {

    /* renamed from: c, reason: collision with root package name */
    private final c f10093c;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f10091b = new AtomicInteger(100000);

    /* renamed from: a, reason: collision with root package name */
    private static final String f10090a = "generateViewId";

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f10092d = as.a((Class<?>) ViewCompat.class, f10090a, (Class<?>[]) new Class[0]);

    public ViewCompatDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f10093c = c.a(iAdInterListener, this);
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i10;
        int i11;
        if (f10092d) {
            return ViewCompat.generateViewId();
        }
        if (bk.a((Context) null).a() >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f10091b;
            i10 = atomicInteger.get();
            i11 = i10 + 1;
            if (i11 > 16777215) {
                i11 = 1;
            }
        } while (!atomicInteger.compareAndSet(i10, i11));
        return i10;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f10093c.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f10093c.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f10093c.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f10093c.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f10093c.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f10093c.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f10090a.equals(str2)) {
            return Integer.valueOf(generateViewId());
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f10093c.setTarget(obj);
    }
}
