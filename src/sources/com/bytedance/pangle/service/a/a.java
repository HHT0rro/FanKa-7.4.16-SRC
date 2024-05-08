package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a extends d.a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f10944b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<ComponentName, IBinder> f10946c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<ComponentName, b> f10947d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final C0125a<Intent> f10948e = new C0125a<>();

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> f10949f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final HashSet<ComponentName> f10950g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    private final HashSet<ComponentName> f10951h = new HashSet<>();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f10945a = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.service.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class C0125a<T> extends HashMap<f, T> {
        public C0125a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            Iterator<f> iterator2 = h().iterator2();
            while (iterator2.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (iterator2.next().a() == ((f) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            f fVar;
            T t2 = (T) super.remove(obj);
            if (t2 != null) {
                return t2;
            }
            Iterator<f> iterator2 = h().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = iterator2.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (fVar.a() == ((f) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(fVar);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b extends HashSet<f> {
        public b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            Iterator<f> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (iterator2.next().a() == ((f) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            f fVar = null;
            Iterator<f> iterator2 = iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                f next = iterator2.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (next.a() == ((f) obj).a()) {
                    fVar = next;
                    break;
                }
            }
            return super.remove(fVar);
        }
    }

    private a() {
    }

    public static a b() {
        if (f10944b == null) {
            synchronized (a.class) {
                if (f10944b == null) {
                    f10944b = new a();
                }
            }
        }
        return f10944b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName c(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f10949f.containsKey(component)) {
            com.bytedance.pangle.service.a d10 = d(intent, str);
            if (d10 == null) {
                return component;
            }
            this.f10949f.put(component, d10);
            this.f10950g.add(component);
        }
        com.bytedance.pangle.service.a aVar = this.f10949f.get(component);
        if (aVar != null) {
            aVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a e2 = e(intent, str);
        if (e2 != null) {
            e2.onCreate();
        }
        return e2;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean z10;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z10 = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin);
                return aVar;
            } catch (Exception e2) {
                e = e2;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z10)), e);
                throw new RuntimeException(e);
            }
        } catch (Exception e10) {
            e = e10;
            z10 = false;
        }
    }

    @Override // com.bytedance.pangle.d.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.d
    public final ComponentName a(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return c(intent, str);
        }
        this.f10945a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.c(intent, str);
            }
        });
        return intent.getComponent();
    }

    @Override // com.bytedance.pangle.d
    public final boolean b(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.f10945a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }

    public final synchronized boolean a(ComponentName componentName) {
        if (!this.f10949f.containsKey(componentName)) {
            return false;
        }
        this.f10951h.add(componentName);
        return b(componentName);
    }

    private boolean b(ComponentName componentName) {
        if (!this.f10950g.contains(componentName)) {
            if (this.f10947d.get(componentName) != null) {
                return false;
            }
            c(componentName);
            return true;
        }
        if (!this.f10951h.contains(componentName) || this.f10947d.containsKey(componentName)) {
            return false;
        }
        c(componentName);
        return true;
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a remove = this.f10949f.remove(componentName);
        this.f10951h.remove(componentName);
        this.f10946c.remove(componentName);
        this.f10950g.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.d
    public final boolean a(final Intent intent, final f fVar, final int i10, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return a(intent, fVar, str);
        }
        this.f10945a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, fVar, str);
                } catch (RemoteException e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e2);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(Intent intent, f fVar, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f10949f.containsKey(component)) {
            com.bytedance.pangle.service.a d10 = d(intent, str);
            if (d10 == null) {
                return false;
            }
            this.f10949f.put(component, d10);
        }
        com.bytedance.pangle.service.a aVar = this.f10949f.get(component);
        if (!this.f10946c.containsKey(component)) {
            this.f10946c.put(component, aVar.onBind(intent));
        }
        IBinder iBinder = this.f10946c.get(component);
        if (iBinder != null) {
            if (this.f10947d.containsKey(component)) {
                if (!this.f10947d.get(component).contains(fVar)) {
                    this.f10947d.get(component).add(fVar);
                    this.f10948e.put(fVar, intent);
                    fVar.a(component, iBinder);
                }
            } else {
                b bVar = new b();
                bVar.add(fVar);
                this.f10947d.put(component, bVar);
                this.f10948e.put(fVar, intent);
                fVar.a(component, iBinder);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(f fVar) {
        for (ComponentName componentName : this.f10947d.h()) {
            b bVar = this.f10947d.get(componentName);
            if (bVar.contains(fVar)) {
                bVar.remove(fVar);
                Intent remove = this.f10948e.remove(fVar);
                if (bVar.size() == 0) {
                    this.f10947d.remove(componentName);
                    com.bytedance.pangle.service.a aVar = this.f10949f.get(componentName);
                    if (aVar != null) {
                        aVar.onUnbind(remove);
                    }
                }
                b(componentName);
                return;
            }
        }
    }

    @Override // com.bytedance.pangle.d
    public final void a(final f fVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(fVar);
        } else {
            this.f10945a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(fVar);
                }
            });
        }
    }
}
