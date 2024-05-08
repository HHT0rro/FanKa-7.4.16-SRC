package yb;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.actions.SearchIntents;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tekartik.sqflite.operation.MethodCallOperation;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import sun.security.util.SecurityConstants;

/* compiled from: SqflitePlugin.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c0 implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: i, reason: collision with root package name */
    public static String f54721i;

    /* renamed from: m, reason: collision with root package name */
    public static o f54725m;

    /* renamed from: b, reason: collision with root package name */
    public Context f54726b;

    /* renamed from: c, reason: collision with root package name */
    public MethodChannel f54727c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, Integer> f54716d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final Map<Integer, i> f54717e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public static final Object f54718f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static final Object f54719g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static int f54720h = 0;

    /* renamed from: j, reason: collision with root package name */
    public static int f54722j = 0;

    /* renamed from: k, reason: collision with root package name */
    public static int f54723k = 1;

    /* renamed from: l, reason: collision with root package name */
    public static int f54724l = 0;

    /* compiled from: SqflitePlugin.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f54728b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f54729c;

        public a(i iVar, MethodChannel.Result result) {
            this.f54728b = iVar;
            this.f54729c = result;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c0.f54719g) {
                c0.this.l(this.f54728b);
            }
            this.f54729c.success(null);
        }
    }

    /* compiled from: SqflitePlugin.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f54731b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f54732c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f54733d;

        public b(i iVar, String str, MethodChannel.Result result) {
            this.f54731b = iVar;
            this.f54732c = str;
            this.f54733d = result;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c0.f54719g) {
                i iVar = this.f54731b;
                if (iVar != null) {
                    c0.this.l(iVar);
                }
                try {
                    if (r.c(c0.f54720h)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("delete database ");
                        sb2.append(this.f54732c);
                    }
                    i.o(this.f54732c);
                } catch (Exception e2) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("error ");
                    sb3.append((Object) e2);
                    sb3.append(" while closing database ");
                    sb3.append(c0.f54724l);
                }
            }
            this.f54733d.success(null);
        }
    }

    public static boolean o(String str) {
        return str == null || str.equals(":memory:");
    }

    public static /* synthetic */ void q(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        iVar.v(new MethodCallOperation(methodCall, result));
    }

    public static /* synthetic */ void r(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        iVar.E(new MethodCallOperation(methodCall, result));
    }

    public static /* synthetic */ void s(boolean z10, String str, MethodChannel.Result result, Boolean bool, i iVar, MethodCall methodCall, boolean z11, int i10) {
        synchronized (f54719g) {
            if (!z10) {
                try {
                    File file = new File(new File(str).getParent());
                    if (!file.exists() && !file.mkdirs() && !file.exists()) {
                        result.error("sqlite_error", "open_failed " + str, null);
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                if (Boolean.TRUE.equals(bool)) {
                    iVar.N();
                } else {
                    iVar.M();
                }
                synchronized (f54718f) {
                    if (z11) {
                        f54716d.put(str, Integer.valueOf(i10));
                    }
                    f54717e.put(Integer.valueOf(i10), iVar);
                }
                if (r.b(iVar.f54751d)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iVar.A());
                    sb2.append("opened ");
                    sb2.append(i10);
                    sb2.append(" ");
                    sb2.append(str);
                }
                result.success(x(i10, false, false));
            } catch (Exception e2) {
                iVar.D(e2, new MethodCallOperation(methodCall, result));
            }
        }
    }

    public static /* synthetic */ void t(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        iVar.O(new MethodCallOperation(methodCall, result));
    }

    public static /* synthetic */ void u(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        iVar.P(new MethodCallOperation(methodCall, result));
    }

    public static /* synthetic */ void v(MethodCall methodCall, i iVar, MethodChannel.Result result) {
        try {
            iVar.f54756i.setLocale(e0.d((String) methodCall.argument("locale")));
            result.success(null);
        } catch (Exception e2) {
            result.error("sqlite_error", "Error calling setLocale: " + e2.getMessage(), null);
        }
    }

    public static /* synthetic */ void w(MethodCall methodCall, MethodChannel.Result result, i iVar) {
        iVar.R(new MethodCallOperation(methodCall, result));
    }

    public static Map x(int i10, boolean z10, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i10));
        if (z10) {
            hashMap.put("recovered", Boolean.TRUE);
        }
        if (z11) {
            hashMap.put("recoveredInTransaction", Boolean.TRUE);
        }
        return hashMap;
    }

    public final void A(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        i n10 = n(methodCall, result);
        if (n10 == null) {
            return;
        }
        if (r.b(n10.f54751d)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(n10.A());
            sb2.append("closing ");
            sb2.append(intValue);
            sb2.append(" ");
            sb2.append(n10.f54749b);
        }
        String str = n10.f54749b;
        synchronized (f54718f) {
            f54717e.remove(Integer.valueOf(intValue));
            if (n10.f54748a) {
                f54716d.remove(str);
            }
        }
        f54725m.c(n10, new a(n10, result));
    }

    public final void B(MethodCall methodCall, MethodChannel.Result result) {
        result.success(Boolean.valueOf(i.x((String) methodCall.argument("path"))));
    }

    public final void C(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("cmd");
        HashMap hashMap = new HashMap();
        if (MonitorConstants.CONNECT_TYPE_GET.equals(str)) {
            int i10 = f54720h;
            if (i10 > 0) {
                hashMap.put("logLevel", Integer.valueOf(i10));
            }
            Map<Integer, i> map = f54717e;
            if (!map.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry<Integer, i> entry : map.entrySet()) {
                    i value = entry.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", value.f54749b);
                    hashMap3.put("singleInstance", Boolean.valueOf(value.f54748a));
                    int i11 = value.f54751d;
                    if (i11 > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(i11));
                    }
                    hashMap2.put(entry.getKey().toString(), hashMap3);
                }
                hashMap.put("databases", hashMap2);
            }
        }
        result.success(hashMap);
    }

    public final void D(MethodCall methodCall, MethodChannel.Result result) {
        zb.a.f55046a = Boolean.TRUE.equals(methodCall.arguments());
        zb.a.f55048c = zb.a.f55047b && zb.a.f55046a;
        if (zb.a.f55046a) {
            if (zb.a.f55048c) {
                f54720h = 2;
            } else if (zb.a.f55046a) {
                f54720h = 1;
            }
        } else {
            f54720h = 0;
        }
        result.success(null);
    }

    public final void E(MethodCall methodCall, MethodChannel.Result result) {
        i iVar;
        Map<Integer, i> map;
        String str = (String) methodCall.argument("path");
        synchronized (f54718f) {
            if (r.c(f54720h)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Look for ");
                sb2.append(str);
                sb2.append(" in ");
                sb2.append((Object) f54716d.h());
            }
            Map<String, Integer> map2 = f54716d;
            Integer num = map2.get(str);
            if (num == null || (iVar = (map = f54717e).get(num)) == null || !iVar.f54756i.isOpen()) {
                iVar = null;
            } else {
                if (r.c(f54720h)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(iVar.A());
                    sb3.append("found single instance ");
                    sb3.append(iVar.F() ? "(in transaction) " : "");
                    sb3.append((Object) num);
                    sb3.append(" ");
                    sb3.append(str);
                }
                map.remove(num);
                map2.remove(str);
            }
        }
        b bVar = new b(iVar, str, result);
        o oVar = f54725m;
        if (oVar != null) {
            oVar.c(iVar, bVar);
        } else {
            bVar.run();
        }
    }

    public final void F(final MethodCall methodCall, final MethodChannel.Result result) {
        final i n10 = n(methodCall, result);
        if (n10 == null) {
            return;
        }
        f54725m.c(n10, new Runnable() { // from class: yb.x
            @Override // java.lang.Runnable
            public final void run() {
                c0.q(MethodCall.this, result, n10);
            }
        });
    }

    public void G(MethodCall methodCall, MethodChannel.Result result) {
        if (f54721i == null) {
            f54721i = this.f54726b.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        result.success(f54721i);
    }

    public final void H(final MethodCall methodCall, final MethodChannel.Result result) {
        final i n10 = n(methodCall, result);
        if (n10 == null) {
            return;
        }
        f54725m.c(n10, new Runnable() { // from class: yb.v
            @Override // java.lang.Runnable
            public final void run() {
                c0.r(MethodCall.this, result, n10);
            }
        });
    }

    public final void I(final MethodCall methodCall, final MethodChannel.Result result) {
        final int i10;
        i iVar;
        final String str = (String) methodCall.argument("path");
        final Boolean bool = (Boolean) methodCall.argument("readOnly");
        final boolean o10 = o(str);
        boolean z10 = (Boolean.FALSE.equals(methodCall.argument("singleInstance")) || o10) ? false : true;
        if (z10) {
            synchronized (f54718f) {
                if (r.c(f54720h)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Look for ");
                    sb2.append(str);
                    sb2.append(" in ");
                    sb2.append((Object) f54716d.h());
                }
                Integer num = f54716d.get(str);
                if (num != null && (iVar = f54717e.get(num)) != null) {
                    if (!iVar.f54756i.isOpen()) {
                        if (r.c(f54720h)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(iVar.A());
                            sb3.append("single instance database of ");
                            sb3.append(str);
                            sb3.append(" not opened");
                        }
                    } else {
                        if (r.c(f54720h)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(iVar.A());
                            sb4.append("re-opened single instance ");
                            sb4.append(iVar.F() ? "(in transaction) " : "");
                            sb4.append((Object) num);
                            sb4.append(" ");
                            sb4.append(str);
                        }
                        result.success(x(num.intValue(), true, iVar.F()));
                        return;
                    }
                }
            }
        }
        Object obj = f54718f;
        synchronized (obj) {
            i10 = f54724l + 1;
            f54724l = i10;
        }
        final i iVar2 = new i(this.f54726b, str, i10, z10, f54720h);
        synchronized (obj) {
            if (f54725m == null) {
                o b4 = n.b("Sqflite", f54723k, f54722j);
                f54725m = b4;
                b4.start();
                if (r.b(iVar2.f54751d)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(iVar2.A());
                    sb5.append("starting worker pool with priority ");
                    sb5.append(f54722j);
                }
            }
            iVar2.f54755h = f54725m;
            if (r.b(iVar2.f54751d)) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(iVar2.A());
                sb6.append("opened ");
                sb6.append(i10);
                sb6.append(" ");
                sb6.append(str);
            }
            final boolean z11 = z10;
            f54725m.c(iVar2, new Runnable() { // from class: yb.b0
                @Override // java.lang.Runnable
                public final void run() {
                    c0.s(o10, str, result, bool, iVar2, methodCall, z11, i10);
                }
            });
        }
    }

    public void J(MethodCall methodCall, MethodChannel.Result result) {
        Object argument = methodCall.argument("androidThreadPriority");
        if (argument != null) {
            f54722j = ((Integer) argument).intValue();
        }
        Object argument2 = methodCall.argument("androidThreadCount");
        if (argument2 != null && !argument2.equals(Integer.valueOf(f54723k))) {
            f54723k = ((Integer) argument2).intValue();
            o oVar = f54725m;
            if (oVar != null) {
                oVar.b();
                f54725m = null;
            }
        }
        Integer a10 = r.a(methodCall);
        if (a10 != null) {
            f54720h = a10.intValue();
        }
        result.success(null);
    }

    public final void K(final MethodCall methodCall, final MethodChannel.Result result) {
        final i n10 = n(methodCall, result);
        if (n10 == null) {
            return;
        }
        f54725m.c(n10, new Runnable() { // from class: yb.u
            @Override // java.lang.Runnable
            public final void run() {
                c0.t(MethodCall.this, result, n10);
            }
        });
    }

    public final void L(final MethodCall methodCall, final MethodChannel.Result result) {
        final i n10 = n(methodCall, result);
        if (n10 == null) {
            return;
        }
        f54725m.c(n10, new Runnable() { // from class: yb.y
            @Override // java.lang.Runnable
            public final void run() {
                c0.u(MethodCall.this, result, n10);
            }
        });
    }

    public final void M(final MethodCall methodCall, final MethodChannel.Result result) {
        final i n10 = n(methodCall, result);
        if (n10 == null) {
            return;
        }
        f54725m.c(n10, new Runnable() { // from class: yb.z
            @Override // java.lang.Runnable
            public final void run() {
                c0.v(MethodCall.this, n10, result);
            }
        });
    }

    public final void N(final MethodCall methodCall, final MethodChannel.Result result) {
        final i n10 = n(methodCall, result);
        if (n10 == null) {
            return;
        }
        f54725m.c(n10, new Runnable() { // from class: yb.w
            @Override // java.lang.Runnable
            public final void run() {
                c0.w(MethodCall.this, result, n10);
            }
        });
    }

    public final void l(i iVar) {
        try {
            if (r.b(iVar.f54751d)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(iVar.A());
                sb2.append("closing database ");
            }
            iVar.k();
        } catch (Exception e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("error ");
            sb3.append((Object) e2);
            sb3.append(" while closing database ");
            sb3.append(f54724l);
        }
        synchronized (f54718f) {
            if (f54717e.isEmpty() && f54725m != null) {
                if (r.b(iVar.f54751d)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(iVar.A());
                    sb4.append("stopping thread");
                }
                f54725m.b();
                f54725m = null;
            }
        }
    }

    public final i m(int i10) {
        return f54717e.get(Integer.valueOf(i10));
    }

    public final i n(MethodCall methodCall, MethodChannel.Result result) {
        int intValue = ((Integer) methodCall.argument("id")).intValue();
        i m10 = m(intValue);
        if (m10 != null) {
            return m10;
        }
        result.error("sqlite_error", "database_closed " + intValue, null);
        return null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        y(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f54726b = null;
        this.f54727c.setMethodCallHandler(null);
        this.f54727c = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1319569547:
                if (str.equals(SecurityConstants.FILE_EXECUTE_ACTION)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1253581933:
                if (str.equals("closeDatabase")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1249474914:
                if (str.equals(QuickCardBean.Field.OPTIONS)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    c4 = 3;
                    break;
                }
                break;
            case -838846263:
                if (str.equals("update")) {
                    c4 = 4;
                    break;
                }
                break;
            case -396289107:
                if (str.equals("androidSetLocale")) {
                    c4 = 5;
                    break;
                }
                break;
            case -263511994:
                if (str.equals("deleteDatabase")) {
                    c4 = 6;
                    break;
                }
                break;
            case -198450538:
                if (str.equals("debugMode")) {
                    c4 = 7;
                    break;
                }
                break;
            case -17190427:
                if (str.equals("openDatabase")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 93509434:
                if (str.equals("batch")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 95458899:
                if (str.equals("debug")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 107944136:
                if (str.equals(SearchIntents.EXTRA_QUERY)) {
                    c4 = 11;
                    break;
                }
                break;
            case 956410295:
                if (str.equals("databaseExists")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 1193546321:
                if (str.equals("queryCursorNext")) {
                    c4 = CharUtils.CR;
                    break;
                }
                break;
            case 1385449135:
                if (str.equals("getPlatformVersion")) {
                    c4 = 14;
                    break;
                }
                break;
            case 1863829223:
                if (str.equals("getDatabasesPath")) {
                    c4 = 15;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                F(methodCall, result);
                return;
            case 1:
                A(methodCall, result);
                return;
            case 2:
                J(methodCall, result);
                return;
            case 3:
                H(methodCall, result);
                return;
            case 4:
                N(methodCall, result);
                return;
            case 5:
                M(methodCall, result);
                return;
            case 6:
                E(methodCall, result);
                return;
            case 7:
                D(methodCall, result);
                return;
            case '\b':
                I(methodCall, result);
                return;
            case '\t':
                z(methodCall, result);
                return;
            case '\n':
                C(methodCall, result);
                return;
            case 11:
                K(methodCall, result);
                return;
            case '\f':
                B(methodCall, result);
                return;
            case '\r':
                L(methodCall, result);
                return;
            case 14:
                result.success("Android " + Build.VERSION.RELEASE);
                return;
            case 15:
                G(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    public final void y(Context context, BinaryMessenger binaryMessenger) {
        this.f54726b = context;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.tekartik.sqflite", StandardMethodCodec.INSTANCE, binaryMessenger.makeBackgroundTaskQueue());
        this.f54727c = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public final void z(final MethodCall methodCall, final MethodChannel.Result result) {
        final i n10 = n(methodCall, result);
        if (n10 == null) {
            return;
        }
        f54725m.c(n10, new Runnable() { // from class: yb.a0
            @Override // java.lang.Runnable
            public final void run() {
                i.this.h(methodCall, result);
            }
        });
    }
}
