package z7;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f54990a;

    /* renamed from: b, reason: collision with root package name */
    public final c<T> f54991b;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b implements c<Context> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<? extends Service> f54992a;

        public final Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f54992a), 128);
                if (serviceInfo == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((Object) this.f54992a);
                    sb2.append(" has no service info.");
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        @Override // z7.e.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a(Context context) {
            Bundle b4 = b(context);
            if (b4 == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b4.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b4.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        public b(Class<? extends Service> cls) {
            this.f54992a = cls;
        }
    }

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface c<T> {
        List<String> a(T t2);
    }

    @VisibleForTesting
    public e(T t2, c<T> cVar) {
        this.f54990a = t2;
        this.f54991b = cVar;
    }

    public static e<Context> b(Context context, Class<? extends Service> cls) {
        return new e<>(context, new b(cls));
    }

    public static List<g> c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                Class<?> cls = Class.forName(str);
                if (!g.class.isAssignableFrom(cls)) {
                    String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar");
                } else {
                    arrayList.add((g) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException unused) {
                String.format("Class %s is not an found.", str);
            } catch (IllegalAccessException unused2) {
                String.format("Could not instantiate %s.", str);
            } catch (InstantiationException unused3) {
                String.format("Could not instantiate %s.", str);
            } catch (NoSuchMethodException unused4) {
                String.format("Could not instantiate %s", str);
            } catch (InvocationTargetException unused5) {
                String.format("Could not instantiate %s", str);
            }
        }
        return arrayList;
    }

    public List<g> a() {
        return c(this.f54991b.a(this.f54990a));
    }
}
