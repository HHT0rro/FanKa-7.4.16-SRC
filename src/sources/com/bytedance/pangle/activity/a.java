package com.bytedance.pangle.activity;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f10624a;

    /* renamed from: b, reason: collision with root package name */
    private final String f10625b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10626c;

    /* renamed from: d, reason: collision with root package name */
    private Method f10627d;

    public a(@NonNull Activity activity, int i10, @NonNull String str) {
        this.f10624a = activity;
        this.f10625b = str;
        this.f10626c = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(@NonNull View view) {
        if (this.f10627d == null) {
            try {
                Method method = this.f10624a.getClass().getMethod(this.f10625b, View.class);
                if (method != null) {
                    this.f10627d = method;
                }
            } catch (NoSuchMethodException unused) {
            }
            throw new IllegalStateException("Could not find method " + this.f10625b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f10626c);
        }
        try {
            this.f10627d.invoke(this.f10624a, view);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
        } catch (InvocationTargetException e10) {
            throw new IllegalStateException("Could not execute method for android:onClick", e10);
        }
    }
}
