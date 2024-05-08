package com.mobile.auth.gatewayauth.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f37364a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f37365b;

    /* renamed from: c, reason: collision with root package name */
    private AbstractPnsViewDelegate f37366c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f37367d;

    public a(Context context, int i10, AbstractPnsViewDelegate abstractPnsViewDelegate) {
        this(LayoutInflater.from(context).inflate(i10, (ViewGroup) new FrameLayout(context), false), abstractPnsViewDelegate);
    }

    public a(View view, AbstractPnsViewDelegate abstractPnsViewDelegate) {
        this.f37367d = true;
        this.f37366c = abstractPnsViewDelegate;
        this.f37364a = view;
        this.f37365b = new WeakReference<>(view.getContext());
        AbstractPnsViewDelegate abstractPnsViewDelegate2 = this.f37366c;
        if (abstractPnsViewDelegate2 != null) {
            abstractPnsViewDelegate2.setPnsView(this);
            this.f37366c.onViewCreated(this.f37364a);
        }
    }

    public Context a() {
        Context context;
        try {
            WeakReference<Context> weakReference = this.f37365b;
            return (weakReference == null || (context = weakReference.get()) == null) ? this.f37364a.getContext() : context;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public View a(int i10) {
        try {
            return this.f37364a.findViewById(i10);
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }

    public View b() {
        try {
            return this.f37364a;
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return null;
        }
    }
}
