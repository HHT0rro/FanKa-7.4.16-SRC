package o4;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: MetadataBackendRegistry.java */
@Singleton
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class i implements d {

    /* renamed from: a, reason: collision with root package name */
    public final a f52280a;

    /* renamed from: b, reason: collision with root package name */
    public final g f52281b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, k> f52282c;

    /* compiled from: MetadataBackendRegistry.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Context f52283a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f52284b = null;

        public a(Context context) {
            this.f52283a = context;
        }

        public static Bundle d(Context context) {
            ServiceInfo serviceInfo;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128)) == null) {
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        public final Map<String, String> a(Context context) {
            Bundle d10 = d(context);
            if (d10 == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : d10.keySet()) {
                Object obj = d10.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String trim = str2.trim();
                        if (!trim.isEmpty()) {
                            hashMap.put(trim, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        @Nullable
        public c b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (c) Class.forName(str2).asSubclass(c.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                String.format("Class %s is not found.", str2);
                return null;
            } catch (IllegalAccessException unused2) {
                String.format("Could not instantiate %s.", str2);
                return null;
            } catch (InstantiationException unused3) {
                String.format("Could not instantiate %s.", str2);
                return null;
            } catch (NoSuchMethodException unused4) {
                String.format("Could not instantiate %s", str2);
                return null;
            } catch (InvocationTargetException unused5) {
                String.format("Could not instantiate %s", str2);
                return null;
            }
        }

        public final Map<String, String> c() {
            if (this.f52284b == null) {
                this.f52284b = a(this.f52283a);
            }
            return this.f52284b;
        }
    }

    @Inject
    public i(Context context, g gVar) {
        this(new a(context), gVar);
    }

    @Override // o4.d
    @Nullable
    public synchronized k get(String str) {
        if (this.f52282c.containsKey(str)) {
            return this.f52282c.get(str);
        }
        c b4 = this.f52280a.b(str);
        if (b4 == null) {
            return null;
        }
        k create = b4.create(this.f52281b.a(str));
        this.f52282c.put(str, create);
        return create;
    }

    public i(a aVar, g gVar) {
        this.f52282c = new HashMap();
        this.f52280a = aVar;
        this.f52281b = gVar;
    }
}
