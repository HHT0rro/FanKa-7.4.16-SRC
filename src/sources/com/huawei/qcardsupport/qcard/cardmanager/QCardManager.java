package com.huawei.qcardsupport.qcard.cardmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.parser.cardmanager.CardInfo;
import com.huawei.qcardsupport.qcard.cardmanager.impl.LayoutLoader;
import com.huawei.qcardsupport.qcard.cardmanager.impl.e;
import com.huawei.qcardsupport.qcard.cardmanager.impl.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QCardManager {

    /* renamed from: d, reason: collision with root package name */
    private static final String f33179d = "QCardManager";

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f33180e = Executors.newFixedThreadPool(2);

    /* renamed from: f, reason: collision with root package name */
    private static volatile QCardManager f33181f;

    /* renamed from: a, reason: collision with root package name */
    private final LayoutLoader f33182a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, com.huawei.qcardsupport.qcard.cardmanager.impl.d> f33183b;

    /* renamed from: c, reason: collision with root package name */
    private final f f33184c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface LoadReceiver {
        @MainThread
        void onLoaded(@NonNull String str, int i10, CardInfo cardInfo);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends f {
        public a(Context context) {
            super(context);
        }

        @Override // com.huawei.qcardsupport.qcard.cardmanager.impl.f
        public void a() {
            QCardManager.this.a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33186a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoadReceiver f33187b;

        public b(String str, LoadReceiver loadReceiver) {
            this.f33186a = str;
            this.f33187b = loadReceiver;
        }

        @Override // java.lang.Runnable
        public void run() {
            QCardManager.this.a(this.f33186a, this.f33187b);
        }
    }

    public QCardManager(Context context) {
        e.a(FLEngine.getInstance(context));
        this.f33182a = new LayoutLoader(context);
        this.f33183b = new HashMap();
        this.f33184c = new a(context);
    }

    public static QCardManager getInstance(Context context) {
        if (f33181f == null) {
            synchronized (QCardManager.class) {
                if (f33181f == null) {
                    f33181f = new QCardManager(context.getApplicationContext());
                }
            }
        }
        return f33181f;
    }

    public void asyncLoadCard(@NonNull String str, @Nullable LoadReceiver loadReceiver) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new b(str, loadReceiver));
        } else {
            this.f33184c.b();
            a(str, loadReceiver);
        }
    }

    @MainThread
    public void onCompleted(String str) {
        this.f33183b.remove(str);
        if (this.f33183b.isEmpty()) {
            this.f33184c.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(@NonNull String str, @Nullable LoadReceiver loadReceiver) {
        LayoutLoader.Result a10 = this.f33182a.a(str, true);
        CardInfo cardInfo = a10.info;
        if (cardInfo != null && !cardInfo.isCombo()) {
            if (loadReceiver != null) {
                loadReceiver.onLoaded(str, a10.error, cardInfo);
            }
        } else {
            com.huawei.qcardsupport.qcard.cardmanager.impl.d dVar = this.f33183b.get(str);
            if (dVar == null) {
                dVar = new com.huawei.qcardsupport.qcard.cardmanager.impl.d(this, this.f33182a, str);
                this.f33183b.put(str, dVar);
            }
            dVar.a(loadReceiver);
            dVar.a(f33180e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a() {
        Iterator<com.huawei.qcardsupport.qcard.cardmanager.impl.d> iterator2 = this.f33183b.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(f33180e);
        }
    }
}
