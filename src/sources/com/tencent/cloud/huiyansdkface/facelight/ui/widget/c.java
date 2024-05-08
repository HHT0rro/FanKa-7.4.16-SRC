package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private Context f41190a;

    /* renamed from: b, reason: collision with root package name */
    private IntentFilter f41191b = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");

    /* renamed from: c, reason: collision with root package name */
    private b f41192c;

    /* renamed from: d, reason: collision with root package name */
    private a f41193d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final String f41194a = "reason";

        /* renamed from: b, reason: collision with root package name */
        public final String f41195b = "globalactions";

        /* renamed from: c, reason: collision with root package name */
        public final String f41196c = "recentapps";

        /* renamed from: d, reason: collision with root package name */
        public final String f41197d = "homekey";

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            String action = intent.getAction();
            if (!action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null) {
                return;
            }
            WLogger.i("HomeWatcher", "action: " + action + ",reason: " + stringExtra);
            if (c.this.f41192c != null) {
                if (stringExtra.equals("homekey")) {
                    c.this.f41192c.a();
                } else if (stringExtra.equals("recentapps")) {
                    c.this.f41192c.b();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        void a();

        void b();
    }

    public c(Context context) {
        this.f41190a = context;
    }

    public void a() {
        a aVar = this.f41193d;
        if (aVar != null) {
            this.f41190a.registerReceiver(aVar, this.f41191b, null, null);
        }
    }

    public void a(b bVar) {
        this.f41192c = bVar;
        this.f41193d = new a();
    }

    public void b() {
        a aVar = this.f41193d;
        if (aVar != null) {
            this.f41190a.unregisterReceiver(aVar);
        }
    }
}
