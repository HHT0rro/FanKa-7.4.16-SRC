package com.kwad.sdk.n;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class i {
    private static final String CLAZZ_NAME = "com.kwad.sdk.n.i";
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean aTn = new AtomicBoolean(false);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private WeakReference<Context> aiJ;
        private int aiK;
        private StackTraceElement[] aiL;
        private int aiM;
        private long aiN;

        private a() {
            this.aiJ = new WeakReference<>(null);
            this.aiK = 0;
            this.aiL = null;
            this.aiM = 0;
        }

        public static /* synthetic */ int c(a aVar) {
            int i10 = aVar.aiK;
            aVar.aiK = i10 + 1;
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

        public static /* synthetic */ int g(a aVar) {
            int i10 = aVar.aiM;
            aVar.aiM = i10 + 1;
            return i10;
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    public static boolean NY() {
        return aTn.get();
    }

    private static void a(final Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            com.kwad.sdk.core.c.b.DD();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.n.i.1
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityDestroyed */
                public final void b(@NonNull Activity activity) {
                    if (activity == context) {
                        com.kwad.sdk.core.c.b.DD();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        i.onDestroy(context);
                    }
                }
            });
        }
    }

    public static void cj(boolean z10) {
        aTn.set(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static Context dk(Context context) {
        boolean z10 = context instanceof com.kwad.sdk.n.a;
        Context context2 = context;
        if (z10) {
            context2 = ((com.kwad.sdk.n.a) context).getDelegatedContext();
        }
        if (l.ds(context2)) {
            return context2;
        }
        RuntimeException runtimeException = null;
        int i10 = 0;
        Context context3 = context2;
        while (i10 < 10) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context3.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            boolean ar2 = j.ar(context3);
            ?? r52 = context3;
            if (ar2) {
                r52 = j.aq(context3);
            }
            boolean z11 = r52 instanceof com.kwad.sdk.n.a;
            Context context4 = r52;
            if (z11) {
                context4 = ((com.kwad.sdk.n.a) r52).getDelegatedContext();
            }
            if (l.ds(context4)) {
                return context4;
            }
            i10++;
            context3 = context4;
        }
        return context3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static Context dl(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context applicationContext = dk(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        int i10 = 0;
        Context context2 = applicationContext;
        while (i10 < 10) {
            Context applicationContext2 = context2.getApplicationContext();
            if (applicationContext2 instanceof Application) {
                return applicationContext2;
            }
            if (applicationContext2 instanceof com.kwad.sdk.n.a) {
                applicationContext2 = ((com.kwad.sdk.n.a) applicationContext2).getDelegatedContext();
            }
            i10++;
            context2 = applicationContext2;
        }
        return context2;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = e.NV().getClassLoader();
        return classLoader2 != null ? classLoader2 : classLoader;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i10) {
        Resources resources = e.NV().getResources();
        if (resources == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i10, true);
        return newTheme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        byte b4 = 0;
        if (aVar != null) {
            if (aVar.aiJ.get() == context && Math.abs(System.currentTimeMillis() - aVar.aiN) < 150) {
                a.c(aVar);
                if (aVar.aiK >= (context instanceof Application ? 15 : 5) && a(context, aVar)) {
                    aVar.clear();
                    return true;
                }
            } else {
                aVar.clear();
                aVar.aiJ = new WeakReference(context);
                aVar.aiN = System.currentTimeMillis();
            }
        } else {
            threadLocal.set(new a(b4));
        }
        return false;
    }

    public static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        }
        if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp() || (context instanceof com.kwad.sdk.n.a)) {
            return context;
        }
        if (j.ar(context)) {
            context = j.unwrapContextIfNeed(context);
            if (j.ar(context)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                return context;
            }
        }
        Context context3 = sResContextCache.get(context);
        if (context3 instanceof com.kwad.sdk.n.a) {
            return context3;
        }
        if (k.dm(context)) {
            return context;
        }
        if (returnUnWrappedContext(context)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context.getClass().getName()));
            return context;
        }
        if (context instanceof Application) {
            try {
                f fVar = new f((Application) context, new g(context, e.NV()));
                l.a(fVar);
                context2 = fVar;
            } catch (Throwable unused) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("wrapper Application fail --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).ys()));
                return context;
            }
        } else if (context instanceof ContextThemeWrapper) {
            context2 = new b((ContextThemeWrapper) context);
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            context2 = new c((androidx.appcompat.view.ContextThemeWrapper) context);
        } else if (context instanceof ContextWrapper) {
            context2 = new d(context);
        } else {
            context2 = new d(context);
        }
        a(context, context2);
        return context2;
    }

    private static boolean a(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, aVar.aiL)) {
            a.g(aVar);
            aVar.aiL = stackTrace;
            return aVar.aiM >= 5;
        }
        if (aVar.aiL == null) {
            aVar.aiL = stackTrace;
            int i10 = 0;
            int i11 = 0;
            while (i10 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                String className = stackTraceElement.getClassName();
                for (String str : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str) && className.contains(str)) {
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
        aVar.clear();
        return false;
    }
}
