package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class e implements a {

    /* renamed from: a, reason: collision with root package name */
    private c f9738a;

    public void a(IAdInterListener iAdInterListener) {
        if (iAdInterListener != null) {
            this.f9738a = c.a(iAdInterListener, this);
        }
    }

    public void b(@Nullable Bundle bundle) {
        this.f9738a.a("onActivityCreated", bundle);
    }

    public void c() {
        this.f9738a.a("onPause");
    }

    public void d() {
        this.f9738a.a("onStop");
    }

    public void e() {
        this.f9738a.a("onDestroyView");
    }

    public void f() {
        this.f9738a.a("onDestroy");
    }

    public void g() {
        this.f9738a.a("onDetach");
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f9738a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f9738a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f9738a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f9738a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f9738a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f9738a.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f9738a.setTarget(obj);
    }

    public void a(Context context) {
        this.f9738a.a("onAttach", context);
    }

    public void b() {
        this.f9738a.a("onResume");
    }

    public void a(@Nullable Bundle bundle) {
        this.f9738a.a("onCreate", bundle);
    }

    @Nullable
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        Object a10 = this.f9738a.a("onCreateView", layoutInflater, viewGroup, bundle);
        if (a10 instanceof View) {
            return (View) a10;
        }
        return null;
    }

    public void a() {
        this.f9738a.a("onStart");
    }
}
