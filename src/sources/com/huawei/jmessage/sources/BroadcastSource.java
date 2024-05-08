package com.huawei.jmessage.sources;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.Subscriber;
import com.huawei.jmessage.d;
import com.huawei.jmessage.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BroadcastSource extends EventSource {
    public static final String TOPIC = "Broadcast";

    /* renamed from: d, reason: collision with root package name */
    private static final String f32056d = "BroadcastSource";

    /* renamed from: a, reason: collision with root package name */
    private final Context f32057a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, d> f32058b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Object f32059c = new Object();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                BroadcastSource.this.fire(new c(intent, true, null));
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BroadcastSource.this.fire(new c(intent, false, null));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c extends Intent {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f32062a;

        public /* synthetic */ c(Intent intent, boolean z10, a aVar) {
            this(intent, z10);
        }

        private c(Intent intent, boolean z10) {
            super(intent);
            this.f32062a = z10;
        }
    }

    public BroadcastSource(Context context) {
        this.f32057a = context.getApplicationContext();
    }

    @NonNull
    public static e a(Object obj) throws Exception {
        if (obj instanceof String) {
            return new e((String) obj);
        }
        if (obj instanceof FLMap) {
            return new e((FLMap) obj);
        }
        if (obj instanceof Intent) {
            return new e((Intent) obj);
        }
        throw new Exception("This type of subscription parameters is not supported.");
    }

    @NonNull
    public static d b(Object obj) throws Exception {
        if (obj instanceof String) {
            return new d((String) obj);
        }
        if (obj instanceof FLMap) {
            return new d((FLMap) obj);
        }
        if (obj instanceof IntentFilter) {
            return new d((IntentFilter) obj);
        }
        throw new Exception("This type of subscription parameters is not supported.");
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onDispatch(@NonNull Subscriber subscriber, @NonNull EventCallback.Message message) {
        d a10 = a(subscriber.getId());
        if (a10 == null) {
            Log.w(f32056d, "Unreachable, Not found filter by subscriberId: " + subscriber.getId());
            return false;
        }
        Object obj = message.payload;
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f32062a != a10.d()) {
            return false;
        }
        return a(this.f32057a, a10.b(), cVar);
    }

    @Override // com.huawei.jmessage.api.EventSource
    public Object onFire(Object obj) {
        if (obj instanceof c) {
            return super.onFire(obj);
        }
        try {
            a(this.f32057a, a(obj));
            return null;
        } catch (Exception e2) {
            Log.e(f32056d, "Exception onFire payload:", e2);
            return null;
        }
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onInitialize(EventSource.Firer firer) {
        super.onInitialize(firer);
        Log.i(f32056d, "onInitialize, Broadcast");
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onRelease() {
        Log.i(f32056d, "onRelease, Broadcast");
        a();
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onSubscribe(@NonNull Subscriber subscriber) {
        try {
            d b4 = b(subscriber.getParam());
            a(b4.a(), b4).a(subscriber.getId());
            return true;
        } catch (Exception e2) {
            Log.e(f32056d, "Exception when creating IntentFilter from.", e2);
            return false;
        }
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onUnsubscribe(@NonNull Subscriber subscriber) {
        d a10 = a(subscriber.getId());
        if (a10 == null) {
            Log.w(f32056d, "Unreachable, Not found filter by subscriberId: " + subscriber.getId());
            return;
        }
        if (a10.b(subscriber.getId())) {
            a(a10);
        }
    }

    public static boolean a(Context context, IntentFilter intentFilter, Intent intent) {
        return intentFilter.match(intent.getAction(), intent.resolveTypeIfNeeded(context.getContentResolver()), intent.getScheme(), intent.getData(), intent.getCategories(), f32056d) >= 0;
    }

    public d a(String str, d dVar) {
        synchronized (this.f32059c) {
            d dVar2 = this.f32058b.get(str);
            if (dVar2 == null) {
                if (dVar.d()) {
                    dVar.a(new a());
                    a(this.f32057a, dVar.c(), dVar.b());
                } else {
                    dVar.a(new b());
                    LocalBroadcastManager.getInstance(this.f32057a).registerReceiver(dVar.c(), dVar.b());
                }
                this.f32058b.put(str, dVar);
            } else {
                dVar = dVar2;
            }
        }
        return dVar;
    }

    @Nullable
    public d a(int i10) {
        synchronized (this.f32059c) {
            for (d dVar : this.f32058b.values()) {
                if (dVar.c(i10)) {
                    return dVar;
                }
            }
            return null;
        }
    }

    private void a(d dVar) {
        a(this.f32057a, dVar);
        synchronized (this.f32059c) {
            this.f32058b.remove(dVar.a());
        }
    }

    public void a() {
        synchronized (this.f32059c) {
            Iterator<d> iterator2 = this.f32058b.values().iterator2();
            while (iterator2.hasNext()) {
                a(this.f32057a, iterator2.next());
            }
            this.f32058b.clear();
        }
    }

    public static void a(Context context, d dVar) {
        BroadcastReceiver c4 = dVar.c();
        if (c4 != null) {
            if (dVar.d()) {
                a(context, c4);
            } else {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(c4);
            }
        }
    }

    public static void a(Context context, e eVar) {
        if (eVar.b()) {
            context.sendBroadcast(eVar.a());
        } else {
            LocalBroadcastManager.getInstance(context).sendBroadcast(eVar.a());
        }
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            context.registerReceiver(broadcastReceiver, intentFilter);
            return true;
        } catch (Exception e2) {
            Log.e(f32056d, "Exception when calling registerReceiver.", e2);
            return false;
        }
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception unused) {
        }
    }
}
