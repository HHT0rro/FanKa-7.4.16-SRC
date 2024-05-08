package t8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import com.huawei.openalliance.ad.constant.bg;
import com.mcs.aidl.IMcsSdkService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import w8.d;
import x8.c;
import y8.e;
import y8.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f53772i = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f53773j = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};

    /* renamed from: k, reason: collision with root package name */
    public static int f53774k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static String f53775l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f53776m;

    /* renamed from: a, reason: collision with root package name */
    public final Object f53777a;

    /* renamed from: b, reason: collision with root package name */
    public Context f53778b;

    /* renamed from: c, reason: collision with root package name */
    public List<c> f53779c;

    /* renamed from: d, reason: collision with root package name */
    public List<d> f53780d;

    /* renamed from: e, reason: collision with root package name */
    public String f53781e;

    /* renamed from: f, reason: collision with root package name */
    public String f53782f;

    /* renamed from: g, reason: collision with root package name */
    public String f53783g;

    /* renamed from: h, reason: collision with root package name */
    public ICallBackResultService f53784h;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements ServiceConnection {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f53785b;

        public a(Intent intent) {
            this.f53785b = intent;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Bundle bundle = new Bundle();
            bundle.putAll(this.f53785b.getExtras());
            try {
                IMcsSdkService.Stub.asInterface(iBinder).process(bundle);
            } catch (Exception e2) {
                y8.c.a("bindMcsService exception:" + ((Object) e2));
            }
            b.this.f53778b.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: t8.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0825b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f53787a = new b(null);
    }

    public b() {
        this.f53777a = new Object();
        this.f53779c = new ArrayList();
        this.f53780d = new ArrayList();
        this.f53783g = null;
        synchronized (b.class) {
            int i10 = f53774k;
            if (i10 > 0) {
                throw new RuntimeException("PushService can't create again!");
            }
            f53774k = i10 + 1;
        }
        p(new w8.b());
        p(new w8.a());
        q(new x8.b());
        q(new x8.a());
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b C() {
        return C0825b.f53787a;
    }

    public static String K() {
        return "2.1.0";
    }

    public static void g(Context context, MessageStat messageStat) {
        e.a(context, messageStat);
    }

    public static void i(Context context, List<MessageStat> list) {
        e.b(context, list);
    }

    public void A(JSONObject jSONObject) {
        if (P()) {
            t(12300, jSONObject);
        } else {
            y8.c.c("mcssdk---", "please call the register first!");
        }
    }

    public void B() {
        if (N()) {
            s(12313);
        } else {
            y8.c.c("mcssdk---", "please call the register first!");
        }
    }

    public String D() {
        boolean z10;
        if (f53775l == null) {
            String c4 = c(this.f53778b);
            if (c4 == null) {
                f53775l = g.b(f53772i);
                z10 = false;
            } else {
                f53775l = c4;
                z10 = true;
            }
            f53776m = z10;
        }
        return f53775l;
    }

    public String E() {
        if (f53775l == null) {
            c(this.f53778b);
        }
        return f53776m ? "com.mcs.action.RECEIVE_SDK_MESSAGE" : g.b(f53773j);
    }

    public boolean F() {
        String D = D();
        return g.c(this.f53778b, D) && g.e(this.f53778b, D) >= 1019 && g.d(this.f53778b, D, "supportOpenPush");
    }

    public List<d> G() {
        return this.f53780d;
    }

    public List<c> H() {
        return this.f53779c;
    }

    public ICallBackResultService I() {
        return this.f53784h;
    }

    public void J() {
        if (P()) {
            t(12306, null);
        } else if (I() != null) {
            I().onGetPushStatus(-2, 0);
        }
    }

    public String L() {
        return N() ? g.f(this.f53778b, D()) : "";
    }

    public int M() {
        if (N()) {
            return g.e(this.f53778b, D());
        }
        return 0;
    }

    public final boolean N() {
        return this.f53778b != null;
    }

    public final boolean O() {
        return this.f53783g != null;
    }

    public final boolean P() {
        return N() && O();
    }

    public String b() {
        return this.f53783g;
    }

    public final String c(Context context) {
        boolean z10;
        boolean z11;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.mcs.action.RECEIVE_SDK_MESSAGE"), 8192);
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        Iterator<ResolveInfo> iterator2 = queryIntentServices.iterator2();
        while (iterator2.hasNext()) {
            String str = iterator2.next().serviceInfo.packageName;
            try {
                z10 = (context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1;
                z11 = context.getPackageManager().getPackageUid(str, 0) == context.getPackageManager().getPackageUid("android", 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (z10 || z11) {
                return str;
            }
        }
        return null;
    }

    public b d(Context context, boolean z10) {
        this.f53778b = context.getApplicationContext();
        new u8.a().a(this.f53778b);
        y8.c.d(z10);
        return this;
    }

    public final void e(int i10, String str, JSONObject jSONObject) {
        synchronized (this.f53777a) {
            this.f53778b.startService(r(i10, str, jSONObject));
        }
    }

    public void f(int i10, JSONObject jSONObject) {
        if (!P()) {
            y8.c.c("mcssdk---", "please call the register first!");
            return;
        }
        e(12307, i10 + "", jSONObject);
    }

    public void h(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        if (context == null) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
                return;
            }
            return;
        }
        g(context, new MessageStat(context.getPackageName(), "push_register", null));
        if (!F()) {
            if (iCallBackResultService != null) {
                iCallBackResultService.onRegister(-2, null);
            }
        } else {
            this.f53781e = str;
            this.f53782f = str2;
            this.f53778b = context.getApplicationContext();
            this.f53784h = iCallBackResultService;
            t(12289, jSONObject);
        }
    }

    public void j(ICallBackResultService iCallBackResultService) {
        this.f53784h = iCallBackResultService;
    }

    public void k(DataMessage dataMessage, String str, int i10) {
        try {
            Intent intent = new Intent();
            intent.setAction(E());
            intent.setPackage(D());
            intent.putExtra("type", 12291);
            intent.putExtra("taskID", dataMessage.getTaskID());
            intent.putExtra("appPackage", dataMessage.getAppPackage());
            intent.putExtra("messageID", dataMessage.getMessageID());
            intent.putExtra("messageType", i10);
            intent.putExtra("eventID", str);
            this.f53778b.startService(intent);
        } catch (Exception e2) {
            y8.c.b("statisticMessage--Exception" + e2.getMessage());
        }
    }

    public void l(String str) {
        this.f53783g = str;
    }

    public void m(String str, String str2) {
        this.f53781e = str;
        this.f53782f = str2;
    }

    public void n(List<Integer> list, int i10, int i11, int i12, int i13, JSONObject jSONObject) {
        if (!P()) {
            if (I() != null) {
                I().onSetPushTime(-2, "please call the register first!");
                return;
            }
            return;
        }
        if (list == null || list.size() <= 0 || i10 < 0 || i11 < 0 || i12 < i10 || i12 > 23 || i13 < i11 || i13 > 59) {
            throw new IllegalArgumentException("params are not all right,please check params");
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("weekDays", v8.a.a(list));
            jSONObject2.put("startHour", i10);
            jSONObject2.put("startMin", i11);
            jSONObject2.put("endHour", i12);
            jSONObject2.put("endMin", i13);
            e(12298, jSONObject2.toString(), jSONObject);
        } catch (JSONException e2) {
            y8.c.c("mcssdk---", e2.getLocalizedMessage());
        }
    }

    public void o(JSONObject jSONObject) {
        if (N()) {
            t(12289, jSONObject);
        } else if (I() != null) {
            I().onRegister(-2, null);
        }
    }

    public final synchronized void p(d dVar) {
        if (dVar != null) {
            this.f53780d.add(dVar);
        }
    }

    public final synchronized void q(c cVar) {
        if (cVar != null) {
            this.f53779c.add(cVar);
        }
    }

    public final Intent r(int i10, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(E());
        intent.setPackage(D());
        intent.putExtra("type", i10);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.f53778b;
            jSONObject2.putOpt(TTDownloadField.TT_VERSION_NAME, g.f(context, context.getPackageName()));
            Context context2 = this.f53778b;
            jSONObject2.putOpt("versionCode", Integer.valueOf(g.e(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra("params", str);
        intent.putExtra("appPackage", this.f53778b.getPackageName());
        intent.putExtra("appKey", this.f53781e);
        intent.putExtra("appSecret", this.f53782f);
        intent.putExtra("registerID", this.f53783g);
        intent.putExtra(bg.e.Code, K());
        return intent;
    }

    public void s(int i10) {
        Intent r10 = r(i10, "", null);
        this.f53778b.bindService(r10, new a(r10), 1);
    }

    public final void t(int i10, JSONObject jSONObject) {
        e(i10, "", jSONObject);
    }

    public void u(Context context, String str, String str2, JSONObject jSONObject, ICallBackResultService iCallBackResultService) {
        this.f53781e = str;
        this.f53782f = str2;
        this.f53778b = context.getApplicationContext();
        this.f53784h = iCallBackResultService;
        v(jSONObject);
    }

    public void v(JSONObject jSONObject) {
        if (N()) {
            t(12290, jSONObject);
        } else if (I() != null) {
            I().onUnRegister(-2);
        }
    }

    public void w(JSONObject jSONObject) {
        if (P()) {
            t(12309, jSONObject);
        } else if (I() != null) {
            I().onGetNotificationStatus(-2, 0);
        }
    }

    public void x(JSONObject jSONObject) {
        if (P()) {
            t(12308, jSONObject);
        } else {
            y8.c.c("mcssdk---", "please call the register first!");
        }
    }

    public void y(JSONObject jSONObject) {
        if (P()) {
            t(12310, jSONObject);
        } else {
            y8.c.c("mcssdk---", "please call the register first!");
        }
    }

    public void z(JSONObject jSONObject) {
        if (P()) {
            t(12299, jSONObject);
        } else {
            y8.c.c("mcssdk---", "please call the register first!");
        }
    }
}
