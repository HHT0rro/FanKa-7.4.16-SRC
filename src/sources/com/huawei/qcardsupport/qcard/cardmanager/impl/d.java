package com.huawei.qcardsupport.qcard.cardmanager.impl;

import android.os.AsyncTask;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;
import com.huawei.qcardsupport.qcard.cardmanager.QCardManager;
import com.huawei.qcardsupport.qcard.cardmanager.impl.LayoutLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* compiled from: LoadCardTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {

    /* renamed from: g, reason: collision with root package name */
    private static final String f33215g = "LoadCardTask";

    /* renamed from: a, reason: collision with root package name */
    private final QCardManager f33216a;

    /* renamed from: b, reason: collision with root package name */
    private final LayoutLoader f33217b;

    /* renamed from: c, reason: collision with root package name */
    private final String f33218c;

    /* renamed from: e, reason: collision with root package name */
    private AsyncTask<?, ?, ?> f33220e;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<WeakReference<QCardManager.LoadReceiver>> f33219d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private int f33221f = 111;

    /* compiled from: LoadCardTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends AsyncTask<Void, Void, LayoutLoader.Result> {
        private b() {
        }

        @Override // android.os.AsyncTask
        @WorkerThread
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LayoutLoader.Result doInBackground(Void... voidArr) {
            return d.this.a(new Void[0]);
        }

        @Override // android.os.AsyncTask
        @MainThread
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(LayoutLoader.Result result) {
            d.this.a(result);
        }
    }

    public d(QCardManager qCardManager, LayoutLoader layoutLoader, String str) {
        this.f33216a = qCardManager;
        this.f33217b = layoutLoader;
        this.f33218c = str;
    }

    @MainThread
    public void a(QCardManager.LoadReceiver loadReceiver) {
        if (loadReceiver != null) {
            for (int i10 = 0; i10 < this.f33219d.size(); i10++) {
                if (loadReceiver == this.f33219d.get(i10).get()) {
                    return;
                }
            }
            this.f33219d.add(new WeakReference<>(loadReceiver));
        }
    }

    @MainThread
    public void a(Executor executor) {
        if (this.f33220e == null || (a() && LayoutLoader.Result.isRetry(this.f33221f))) {
            this.f33220e = new b().executeOnExecutor(executor, new Void[0]);
        }
    }

    @MainThread
    private boolean a() {
        AsyncTask<?, ?, ?> asyncTask = this.f33220e;
        return asyncTask != null && asyncTask.getStatus() == AsyncTask.Status.FINISHED;
    }

    @WorkerThread
    public LayoutLoader.Result a(Void... voidArr) {
        return this.f33217b.a(this.f33218c, false);
    }

    @MainThread
    public void a(LayoutLoader.Result result) {
        this.f33221f = result.error;
        CardInfo cardInfo = result.info;
        if (cardInfo == null) {
            Log.e(f33215g, "Failed to load the card-layout, cardUri: " + this.f33218c + ", resultCode: " + this.f33221f + ".");
        }
        for (int i10 = 0; i10 < this.f33219d.size(); i10++) {
            QCardManager.LoadReceiver loadReceiver = this.f33219d.get(i10).get();
            if (loadReceiver != null) {
                loadReceiver.onLoaded(this.f33218c, this.f33221f, cardInfo);
            }
        }
        if (cardInfo == null && LayoutLoader.Result.isRetry(this.f33221f)) {
            return;
        }
        this.f33219d.clear();
        this.f33216a.onCompleted(this.f33218c);
    }
}
