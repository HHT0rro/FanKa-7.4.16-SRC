package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.log.RPLogging;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CancelUploadApi.java */
@aw(a = "cancelUpload")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class as extends aq {
    private static final String ao = "cancelSuccess";
    private static final String ap = "cancelFailure";
    private static final String aq = "";

    private void c(String str) {
        dg dgVar = (dg) bb.a().a(str);
        if (RPLogging.isEnable()) {
            RPLogging.i(aq.f3100a, "CancelUploadApi cancelTaskCallBack: ".concat(String.valueOf(dgVar)));
        }
        bf bfVar = new bf();
        if (dgVar != null) {
            dgVar.a();
            bfVar.a(aq.f3119o, str);
            bfVar.a("errorMsg", ao);
            bfVar.f3165a = 1;
            this.ak.b(bfVar);
            bb.a().b(str);
            a(bfVar, true);
            return;
        }
        bfVar.a(aq.f3119o, str);
        bfVar.a("errorMsg", ap);
        this.ak.a(bfVar);
        a(bfVar, false);
    }

    private void d() {
        if (RPLogging.isEnable()) {
            RPLogging.i(aq.f3100a, "CancelUploadApi cancelAllTaskCallBack");
        }
        bf bfVar = new bf();
        Iterator<Map.Entry<String, Object>> iterator2 = bb.a().b().iterator2();
        while (iterator2.hasNext()) {
            Object value = iterator2.next().getValue();
            if (value instanceof dg) {
                ((dg) value).a();
            }
            if (value instanceof Future) {
                ((Future) value).cancel(true);
            }
        }
        bb a10 = bb.a();
        synchronized (a10.f3149a) {
            a10.f3149a.clear();
        }
        bfVar.f3165a = 1;
        bfVar.a("errorMsg", ao);
        this.ak.b(bfVar);
        a(bfVar, true);
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "cancelUpload";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, ay ayVar) {
        try {
            String string = new JSONObject(str).getString(aq.f3119o);
            if ("".equals(string)) {
                d();
            } else {
                dg dgVar = (dg) bb.a().a(string);
                if (RPLogging.isEnable()) {
                    RPLogging.i(aq.f3100a, "CancelUploadApi cancelTaskCallBack: ".concat(String.valueOf(dgVar)));
                }
                bf bfVar = new bf();
                if (dgVar != null) {
                    dgVar.a();
                    bfVar.a(aq.f3119o, string);
                    bfVar.a("errorMsg", ao);
                    bfVar.f3165a = 1;
                    this.ak.b(bfVar);
                    bb.a().b(string);
                    a(bfVar, true);
                } else {
                    bfVar.a(aq.f3119o, string);
                    bfVar.a("errorMsg", ap);
                    this.ak.a(bfVar);
                    a(bfVar, false);
                }
            }
            return true;
        } catch (JSONException e2) {
            if (RPLogging.isEnable()) {
                RPLogging.e(aq.f3100a, "CancelUploadApi params error", e2);
            }
            aq.a("CancelUploadApi params error", e2);
            aq.a(ayVar);
            return false;
        }
    }
}
