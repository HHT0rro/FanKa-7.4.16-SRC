package com.kwad.sdk.n;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ay;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {
    private static final AtomicBoolean JB = new AtomicBoolean(false);
    private static a aTo;

    @KsJson
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> aTq;
        public List<C0543a> aTr;

        @KsJson
        /* renamed from: com.kwad.sdk.n.k$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class C0543a extends com.kwad.sdk.core.response.a.a {
            public String aTs;
            public String aTt;
        }
    }

    public static void NZ() {
        if (JB.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.sdk.n.k.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                a unused = k.aTo = new a();
                try {
                    k.aTo.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.n.k.1.1
                        private static JSONObject o(JSONObject jSONObject) {
                            if (jSONObject == null) {
                                return null;
                            }
                            jSONObject.optJSONObject("wrapperBlackConfig");
                            return null;
                        }

                        @Override // com.kwad.sdk.g.b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return o(jSONObject);
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }

    public static boolean dm(Context context) {
        a aVar = aTo;
        if (aVar == null || ah.I(aVar.aTq) || ah.I(aTo.aTr) || !a(context, aTo)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, aTo)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        Iterator<E> iterator2 = new CopyOnWriteArrayList(aVar.aTq).iterator2();
        while (iterator2.hasNext()) {
            if (ah.a((String) iterator2.next(), name)) {
                com.kwad.sdk.core.e.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (a.C0543a c0543a : new CopyOnWriteArrayList(aVar.aTr)) {
            String str = c0543a.aTs;
            String str2 = c0543a.aTt;
            if (ah.a(str, className) && ah.a(str2, methodName)) {
                com.kwad.sdk.core.e.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }
}
