package com.kwai.adclient.kscommerciallogger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a aTv;
    private com.kwai.adclient.kscommerciallogger.a.b aTw;
    private JSONObject aTx;
    private boolean aTy;
    private boolean isDebug;

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0550a {
        private static a aTz;

        public static a Oe() {
            if (aTz == null) {
                aTz = new a((byte) 0);
            }
            return aTz;
        }
    }

    public /* synthetic */ a(byte b4) {
        this();
    }

    public static a Oe() {
        return C0550a.Oe();
    }

    private void b(@NonNull c cVar) {
        if (this.aTv != null) {
            if (cVar.Oi() != null) {
                String str = cVar.Oi().value;
            }
            if (cVar.Oj() != null) {
                cVar.Oj().getValue();
            }
            cVar.Om();
            b.z(cVar.Ok());
            b.z(cVar.Ol());
        }
    }

    public final JSONObject Of() {
        return this.aTx;
    }

    public final boolean Og() {
        return this.aTy;
    }

    public final void a(@NonNull com.kwai.adclient.kscommerciallogger.a.a aVar, @NonNull com.kwai.adclient.kscommerciallogger.a.b bVar, @Nullable JSONObject jSONObject, boolean z10, boolean z11) {
        this.aTv = aVar;
        this.aTw = bVar;
        this.aTx = jSONObject;
        this.isDebug = z10;
        this.aTy = z11;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    private a() {
        this.isDebug = false;
        this.aTy = false;
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.aTw;
        if (bVar != null) {
            bVar.L(cVar.Oh(), cVar.toString());
        }
    }
}
