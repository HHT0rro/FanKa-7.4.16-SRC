package com.huawei.hms.scankit;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.k1;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.v6;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeThread.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f30594a;

    /* renamed from: b, reason: collision with root package name */
    private final j0 f30595b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<l1, Object> f30596c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f30597d;

    /* renamed from: e, reason: collision with root package name */
    private a f30598e;

    /* renamed from: g, reason: collision with root package name */
    private Rect f30600g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f30601h = true;

    /* renamed from: f, reason: collision with root package name */
    private final CountDownLatch f30599f = new CountDownLatch(1);

    public d(Context context, j0 j0Var, a aVar, Collection<BarcodeFormat> collection, Map<l1, ?> map, String str, v6 v6Var) {
        this.f30594a = context;
        this.f30598e = aVar;
        this.f30595b = j0Var;
        EnumMap enumMap = new EnumMap(l1.class);
        this.f30596c = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(k1.f31198a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(k1.f31200c);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(k1.f31201d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(k1.f31203f);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(k1.f31202e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(k1.f31204g);
            }
        }
        enumMap.put((EnumMap) l1.POSSIBLE_FORMATS, (l1) collection);
        if (str != null) {
            enumMap.put((EnumMap) l1.CHARACTER_SET, (l1) str);
        }
        enumMap.put((EnumMap) l1.NEED_RESULT_POINT_CALLBACK, (l1) v6Var);
        o4.d("DecodeThread", "Hints: " + ((Object) enumMap));
    }

    public void a(Rect rect) {
        this.f30600g = rect;
    }

    public void b() {
        this.f30594a = null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f30597d = new c(this.f30594a, this.f30595b, this.f30598e, this.f30596c, this.f30600g, this.f30601h);
        this.f30599f.countDown();
        Looper.loop();
    }

    public Handler a() {
        try {
            this.f30599f.await();
        } catch (InterruptedException unused) {
            o4.b("exception", "InterruptedException");
        }
        return this.f30597d;
    }

    public void a(boolean z10) {
        this.f30601h = z10;
    }
}
