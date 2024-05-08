package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.AsyncTask;
import com.alibaba.security.realidentity.RPEventListener;
import java.lang.ref.WeakReference;

/* compiled from: AbsDynamicAsyncTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class z<T> extends AsyncTask<String, Void, T> {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f4020a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4021b;

    /* renamed from: c, reason: collision with root package name */
    public final RPEventListener f4022c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f4023d;

    /* renamed from: e, reason: collision with root package name */
    public final gx f4024e;

    public z(Context context, String str, RPEventListener rPEventListener, Runnable runnable, gx gxVar) {
        this.f4020a = new WeakReference<>(context);
        this.f4021b = str;
        this.f4022c = rPEventListener;
        this.f4023d = runnable;
        this.f4024e = gxVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T doInBackground(String... strArr) {
        return null;
    }

    public abstract void a(T t2);

    @Override // android.os.AsyncTask
    public void onPostExecute(T t2) {
        super.onPostExecute(t2);
        a((z<T>) t2);
    }
}
