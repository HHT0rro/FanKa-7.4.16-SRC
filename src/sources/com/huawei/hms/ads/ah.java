package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ah {
    private static final String Code = "JsbCmdManager";
    private static final byte[] I = new byte[0];
    private static ah V;
    private final List<String> B;
    private final Map<String, Class<? extends ac>> C;
    private final Map<String, ac> Z = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a<T> implements Runnable {
        private ac B;
        private final Context Code;
        private final String I;
        private final String V;
        private final RemoteCallResultCallback<String> Z;

        public a(Context context, ac acVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.Code = context;
            this.V = str;
            this.I = str2;
            this.Z = remoteCallResultCallback;
            this.B = acVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ah.V(this.Code, this.B, this.V, this.I, this.Z);
        }
    }

    private ah() {
        ArrayList arrayList = new ArrayList();
        this.B = arrayList;
        HashMap hashMap = new HashMap();
        this.C = hashMap;
        hashMap.put(ai.V, com.huawei.openalliance.ad.utils.an.Code(com.huawei.openalliance.ad.constant.u.bu));
        hashMap.put(ai.I, com.huawei.openalliance.ad.utils.an.Code("com.huawei.openalliance.ad.jsb.JsbRewardProxy"));
        hashMap.put(ai.Z, com.huawei.openalliance.ad.utils.an.Code("com.huawei.openalliance.ad.jsb.JsbInterstitialProxy"));
        hashMap.put(ai.B, com.huawei.openalliance.ad.utils.an.Code(com.huawei.openalliance.ad.constant.u.bz));
        hashMap.put(ai.C, ad.class);
        hashMap.put(ai.f29026b, ay.class);
        hashMap.put(ai.f29027c, az.class);
        hashMap.put(ai.S, bd.class);
        hashMap.put(ai.D, bb.class);
        hashMap.put(ai.F, bc.class);
        hashMap.put(ai.L, ax.class);
        hashMap.put(ai.f29025a, ar.class);
        hashMap.put(ai.f29028d, aw.class);
        hashMap.put(ai.f29031g, av.class);
        hashMap.put(ai.f29030f, at.class);
        hashMap.put(ai.f29032h, com.huawei.openalliance.ad.utils.an.Code("com.huawei.openalliance.ad.jsb.JsbRewardProxy"));
        hashMap.put(ai.f29033i, com.huawei.openalliance.ad.utils.an.Code("com.huawei.openalliance.ad.jsb.JsbInterstitialProxy"));
        hashMap.put(ai.f29035k, bn.class);
        hashMap.put(ai.f29034j, bm.class);
        hashMap.put(ai.f29037m, bh.class);
        hashMap.put(ai.f29036l, bg.class);
        hashMap.put(ai.f29038n, bl.class);
        hashMap.put(ai.f29039o, bj.class);
        hashMap.put(ai.f29040p, bk.class);
        hashMap.put(ai.f29041q, bi.class);
        hashMap.put(ai.f29041q, bi.class);
        hashMap.put(ai.Code, al.class);
        hashMap.put(ai.f29042r, ak.class);
        hashMap.put(ai.f29046v, ba.class);
        hashMap.put(ai.f29047w, be.class);
        hashMap.put(ai.f29029e, as.class);
        if (com.huawei.openalliance.ad.utils.an.Code(com.huawei.openalliance.ad.constant.u.bA) != null) {
            hashMap.put(ai.f29043s, an.class);
            hashMap.put(ai.f29044t, ap.class);
            hashMap.put(ai.f29045u, ao.class);
        }
        hashMap.put(ai.f29048x, am.class);
        hashMap.put(ai.f29049y, aj.class);
        arrayList.add(ai.C);
        arrayList.add(ai.f29032h);
        arrayList.add(ai.f29033i);
    }

    public static ah Code() {
        ah ahVar;
        synchronized (I) {
            if (V == null) {
                V = new ah();
            }
            ahVar = V;
        }
        return ahVar;
    }

    public static String V(String str) {
        return new JSONObject(str).optString(com.huawei.openalliance.ad.constant.as.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, ac acVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (acVar == null) {
            String str3 = "api for " + str + " is not found";
            gl.V(Code, "call " + str3);
            af.Code(remoteCallResultCallback, str, -1, str3, true);
            return;
        }
        gl.V(Code, "call method: " + str);
        if (gl.Code()) {
            gl.Code(Code, "param: %s", com.huawei.openalliance.ad.utils.bc.Code(str2));
        }
        try {
            acVar.execute(context, str2, remoteCallResultCallback);
        } catch (Throwable th) {
            gl.I(Code, "call method %s, ex: %s", str, th.getClass().getSimpleName());
            af.Code(remoteCallResultCallback, str, -1, th.getClass().getSimpleName() + com.huawei.openalliance.ad.constant.u.bD + th.getMessage(), true);
            gl.Code(3, th);
        }
    }

    public ac Code(String str) {
        StringBuilder sb2;
        String str2;
        String sb3;
        if (!TextUtils.isEmpty(str)) {
            ac acVar = this.Z.get(str);
            if (acVar == null) {
                gl.Code(Code, "create command %s", str);
                Class<? extends ac> cls = this.C.get(str);
                if (cls == null) {
                    sb2 = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        acVar = cls.newInstance();
                    } catch (InstantiationException unused) {
                        gl.I(Code, "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        gl.I(Code, "get cmd %s: %s", str, th.getClass().getSimpleName());
                    }
                    if (acVar == null) {
                        sb2 = new StringBuilder();
                        str2 = "no instance created for cmd: ";
                    } else {
                        this.Z.put(str, acVar);
                    }
                }
                sb2.append(str2);
                sb2.append(str);
                sb3 = sb2.toString();
            }
            return acVar;
        }
        sb3 = "get cmd, method is empty";
        gl.I(Code, sb3);
        return null;
    }

    public boolean Code(String str, Context context) {
        return (context instanceof Activity) && this.B.contains(str);
    }

    public void V() {
        this.Z.clear();
    }
}
