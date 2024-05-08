package cn.shuzilm.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DUService extends Service {
    public static WakeListener callback;

    /* renamed from: a, reason: collision with root package name */
    private Context f1704a;

    /* renamed from: b, reason: collision with root package name */
    private v f1705b = new v(this);

    /* renamed from: c, reason: collision with root package name */
    private String f1706c;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.f1704a == null) {
            this.f1704a = getApplicationContext();
        }
        this.f1706c = intent.getStringExtra("apikey");
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (Looper.myLooper() != null) {
            DUHelper.init(this.f1704a, this.f1706c);
        }
        return this.f1705b;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.f1704a == null) {
            this.f1704a = getApplicationContext();
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        super.onStart(intent, i10);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        try {
            DUHelper.loadLibrary();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String str = null;
        try {
            str = intent.getStringExtra(com.kuaishou.weapon.p0.t.f36222g);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (str == null) {
            return 1;
        }
        try {
            String replace = UUID.randomUUID().toString().replace("-", "");
            DUHelper.onIEvent(getApplicationContext(), str + "," + replace);
            callback.handleWakeup(replace);
            return 1;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 1;
        }
    }
}
