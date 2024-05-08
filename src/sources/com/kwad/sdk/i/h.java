package com.kwad.sdk.i;

import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kwad.sdk.i.e;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {
    private static final float anQ = new Random().nextFloat();
    private final AtomicBoolean JB;
    private final AtomicBoolean aJf;
    private d aJg;
    private g aJh;
    private List<i> aJi;
    private f aJj;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        private static final h aJm = new h(0);
    }

    public /* synthetic */ h(byte b4) {
        this();
    }

    public static h Jc() {
        return a.aJm;
    }

    private void Jj() {
        List<i> list = this.aJi;
        if (list == null) {
            return;
        }
        Iterator<i> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            b(iterator2.next());
        }
        this.aJi.clear();
        this.aJi = null;
    }

    private void b(final i iVar) {
        d dVar = this.aJg;
        if (dVar == null || j.I(dVar.aIS) || this.aJh == null || this.aJj == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.i.h.1
            @Override // com.kwad.sdk.i.n
            public final void doTask() {
                h hVar = h.this;
                e a10 = hVar.a(hVar.aJg, iVar);
                if (a10 == null) {
                    return;
                }
                iVar.n(a10.aor);
                m.a(iVar, a10.aIT == 2);
            }
        });
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.aEZ;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (TextUtils.equals(this.aJh.getSdkVersion(), iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean d(e.b bVar) {
        String androidId = this.aJh.getAndroidId();
        String deviceId = this.aJh.getDeviceId();
        String imei = this.aJh.getImei();
        String oaid = this.aJh.getOaid();
        List<String> list = bVar.aJb;
        if (j.I(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(str, androidId) || TextUtils.equals(str, deviceId) || TextUtils.equals(str, imei) || TextUtils.equals(str, oaid)) {
                return true;
            }
        }
        return false;
    }

    private static d fU(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Throwable unused) {
            j.Jm();
            return null;
        }
    }

    public final void Jd() {
        if (!this.JB.get() || this.aJg == null) {
            return;
        }
        j.Jn();
        m.Jp();
    }

    public final synchronized void Je() {
        this.aJf.set(true);
    }

    public final synchronized void Jf() {
        this.aJf.set(false);
    }

    public final g Jg() {
        return this.aJh;
    }

    public final f Jh() {
        return this.aJj;
    }

    public final long Ji() {
        return this.aJg.IV();
    }

    public final void f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.aJf.get()) {
                    j.Jn();
                    return;
                }
                i fX = i.Jl().fV(str).fW(str2).fX(str3);
                if (this.JB.get()) {
                    b(fX);
                } else {
                    j.Jn();
                    a(fX);
                }
            }
        } catch (Throwable unused) {
            j.Jm();
        }
    }

    private h() {
        this.JB = new AtomicBoolean(false);
        this.aJf = new AtomicBoolean(false);
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.aEY;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (TextUtils.equals(this.aJh.getAppId(), iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.JB.get()) {
            return;
        }
        try {
            j.Jn();
            this.aJh = gVar;
            this.aJj = fVar;
            this.aJg = fU(str);
            this.JB.set(true);
            Jj();
        } catch (Throwable unused) {
            j.Jm();
        }
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.aIY;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (str.contains(iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(e.a aVar, String str) {
        List<String> list = aVar.aIX;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (TextUtils.equals(str, iterator2.next())) {
                return true;
            }
        }
        return false;
    }

    private void a(i iVar) {
        if (this.aJi == null) {
            this.aJi = new CopyOnWriteArrayList();
        }
        this.aJi.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(d dVar, i iVar) {
        List<e> list = dVar.aIS;
        if (j.I(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.aIU) && a(eVar.aIV, iVar)) {
                double d10 = eVar.aor;
                if (d10 > ShadowDrawableWrapper.COS_45 && anQ <= d10) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.aJc != e.b.aIZ) {
            return bVar.IW();
        }
        bVar.bD(b(bVar) && c(bVar) && d(bVar));
        return bVar.IW();
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.aJn) && b(aVar, iVar.aJo) && c(aVar, iVar.aJp);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.aIW;
        if (j.I(list)) {
            return true;
        }
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            if (TextUtils.equals(str, iterator2.next())) {
                return true;
            }
        }
        return false;
    }
}
