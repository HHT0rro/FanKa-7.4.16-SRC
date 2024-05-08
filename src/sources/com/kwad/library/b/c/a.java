package com.kwad.library.b.c;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    private static final ThreadLocal<C0505a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* renamed from: com.kwad.library.b.c.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0505a {
        private WeakReference<Context> aiJ;
        private int aiK;
        private StackTraceElement[] aiL;
        private int aiM;
        private long aiN;

        private C0505a() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
        }

        public static /* synthetic */ int c(C0505a c0505a) {
            int i10 = c0505a.aiK;
            c0505a.aiK = i10 + 1;
            return i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
            this.aiN = 0L;
        }

        public static /* synthetic */ int g(C0505a c0505a) {
            int i10 = c0505a.aiM;
            c0505a.aiM = i10 + 1;
            return i10;
        }

        public /* synthetic */ C0505a(byte b4) {
            this();
        }
    }

    @Nullable
    private static Context a(String str, Context context) {
        WeakReference<Context> weakReference = sResContextCache.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context aq(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static boolean ar(Context context) {
        return context instanceof b;
    }

    private static boolean b(String str, Context context) {
        ThreadLocal<C0505a> threadLocal = sAutoUnWrapModelTL;
        C0505a c0505a = threadLocal.get();
        byte b4 = 0;
        if (c0505a != null) {
            if (c0505a.aiJ.get() == context && Math.abs(System.currentTimeMillis() - c0505a.aiN) < 150) {
                C0505a.c(c0505a);
                if (c0505a.aiK >= (context instanceof Application ? 15 : 5) && a(str, context, c0505a)) {
                    c0505a.clear();
                    return true;
                }
            } else {
                c0505a.clear();
                c0505a.aiJ = new WeakReference(context);
                c0505a.aiN = System.currentTimeMillis();
            }
        } else {
            threadLocal.set(new C0505a(b4));
        }
        return false;
    }

    private static com.kwad.library.b.a bD(String str) {
        return com.kwad.library.solder.a.a.i(null, str);
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object callMethod = s.callMethod(context, "getThemeResId", new Object[0]);
            if (callMethod != null) {
                return ((Integer) callMethod).intValue();
            }
            return 0;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }

    @NonNull
    public static Context h(Context context, String str) {
        Context eVar;
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a bD = bD(str);
        if (bD == null || !bD.isLoaded() || (context instanceof b) || b(str, context)) {
            return context;
        }
        Context a10 = a(str, context);
        if (a10 != null) {
            return a10;
        }
        if (context instanceof ContextThemeWrapper) {
            eVar = new c((ContextThemeWrapper) context, str);
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            eVar = new d((androidx.appcompat.view.ContextThemeWrapper) context, str);
        } else if (context instanceof ContextWrapper) {
            eVar = new e(context, str);
        } else {
            eVar = new e(context, str);
        }
        a(str, context, eVar);
        return eVar;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (ar(context)) {
            context = aq(context);
        }
        if (!ar(context)) {
            return context;
        }
        for (int i10 = 0; i10 < 10; i10++) {
            context = aq(context);
            if (!ar(context)) {
                return context;
            }
        }
        return context;
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean a(String str, Context context, C0505a c0505a) {
        Context a10 = a(str, context);
        String name = a10 != null ? a10.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, c0505a.aiL)) {
            C0505a.g(c0505a);
            c0505a.aiL = stackTrace;
            return c0505a.aiM >= 5;
        }
        if (c0505a.aiL == null) {
            c0505a.aiL = stackTrace;
            int i10 = 0;
            int i11 = 0;
            while (i10 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                String className = stackTraceElement.getClassName();
                Iterator<String> iterator2 = getAutoUnWrapStackList().iterator2();
                while (iterator2.hasNext()) {
                    if (className.contains(iterator2.next())) {
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i10++;
                if (i10 < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i10];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i11 = i11 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        c0505a.clear();
        return false;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a bD = bD(str);
        if (bD == null || !bD.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context h10 = h(context, str);
        return h10 instanceof b ? layoutInflater.cloneInContext(h10) : layoutInflater;
    }

    public static Resources a(Resources resources, String str) {
        com.kwad.library.b.a bD = bD(str);
        if (bD != null && bD.isLoaded()) {
            Resources resources2 = bD.getResources();
            Objects.toString(resources2);
            return resources2 != null ? resources2 : resources;
        }
        Objects.toString(bD);
        return resources;
    }

    public static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i10, String str) {
        Resources resources;
        com.kwad.library.b.a bD = bD(str);
        if (bD == null || !bD.isLoaded() || (resources = bD.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i10, true);
        return newTheme;
    }

    public static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b wU;
        com.kwad.library.b.a bD = bD(str);
        return (bD == null || !bD.isLoaded() || (wU = bD.wU()) == null) ? classLoader : wU;
    }
}
