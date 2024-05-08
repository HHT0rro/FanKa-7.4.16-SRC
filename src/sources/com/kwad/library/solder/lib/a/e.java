package com.kwad.library.solder.lib.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.library.solder.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class e<P extends a> {
    public String aiR;
    public int ajA;
    public String ajC;
    public String ajD;
    public boolean ajE;
    public P ajF;
    public com.kwad.library.solder.lib.ext.b ajG;
    public Throwable ajH;
    public String ajI;
    public boolean ajJ;
    public long ajK;
    public String ajL;
    public List<com.kwad.library.solder.lib.c.a> ajM;
    public com.kwad.library.solder.lib.c.b ajN;
    public d ajh;
    public String mDownloadUrl;
    public String mVersion;
    public int mState = -1;
    public int ajz = 0;
    private final byte[] ajw = new byte[0];
    public StringBuffer ajB = new StringBuffer(String.valueOf(-1));

    public e(com.kwad.library.solder.lib.c.b bVar) {
        this.ajN = bVar;
        this.aiR = bVar.akf;
        this.mVersion = bVar.version;
        this.ajL = bVar.aki;
        this.ajJ = bVar.ajJ;
        this.ajI = bVar.ajI;
        this.ajK = bVar.akh;
        this.mDownloadUrl = bVar.akg;
    }

    private List<com.kwad.library.solder.lib.c.a> b(String str, String str2, String str3) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.ajh.xb().bF(str));
            if (file.exists() && (list = file.list()) != null && list.length != 0) {
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        if (this.ajh.xb().a(str, str4, str3)) {
                            com.kwad.library.solder.lib.c.a aVar = new com.kwad.library.solder.lib.c.a();
                            aVar.akf = str;
                            aVar.version = str4;
                            aVar.qs = true;
                            arrayList.add(aVar);
                        } else {
                            this.ajh.xb().D(str, str4);
                        }
                    } else {
                        this.ajh.xb().D(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public final e a(d dVar) {
        this.ajh = dVar;
        return this;
    }

    public final void bI(String str) {
        this.mVersion = str;
    }

    public final e bL(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.ajB;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }

    public final void bM(String str) {
        this.ajC = str;
    }

    public final void bN(String str) {
        this.ajD = str;
    }

    public abstract P bO(String str);

    public final e bO(int i10) {
        synchronized (this.ajw) {
            this.mState = i10;
        }
        return bL(String.valueOf(i10));
    }

    public final void bP(int i10) {
        if (i10 > 0) {
            this.ajA = i10;
        }
    }

    public final void c(P p10) {
        this.ajF = p10;
    }

    public final void cancel() {
        synchronized (this.ajw) {
            bO(0);
        }
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final int getState() {
        int i10;
        synchronized (this.ajw) {
            i10 = this.mState;
        }
        return i10;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        return this.mState == 0;
    }

    public final e j(@NonNull Throwable th) {
        this.ajH = th;
        return bL(th.getLocalizedMessage());
    }

    @NonNull
    public String toString() {
        return "PluginRequest{mId='" + this.aiR + "'}";
    }

    public final d xl() {
        return this.ajh;
    }

    public final String xm() {
        return this.ajB.toString();
    }

    @Nullable
    public final Throwable xn() {
        return this.ajH;
    }

    public final boolean xo() {
        bO(-1);
        this.ajM = null;
        int i10 = this.ajz + 1;
        this.ajz = i10;
        return i10 <= this.ajA;
    }

    @Nullable
    public final String xp() {
        return this.aiR;
    }

    public final boolean xq() {
        return this.ajE;
    }

    public final int xr() {
        return this.ajz;
    }

    @Nullable
    public final String xs() {
        if (!TextUtils.isEmpty(this.ajC)) {
            return this.ajC;
        }
        return this.ajD;
    }

    @Nullable
    public final com.kwad.library.solder.lib.ext.b xt() {
        return this.ajG;
    }

    public final boolean xu() {
        return this.ajJ;
    }

    public final String xv() {
        return this.ajI;
    }

    public final String xw() {
        return this.ajL;
    }

    public final com.kwad.library.solder.lib.c.b xx() {
        return this.ajN;
    }

    public final List<com.kwad.library.solder.lib.c.a> xy() {
        String xp = xp();
        if (!TextUtils.isEmpty(xp) && this.ajM == null) {
            this.ajM = b(xp, getVersion(), xw());
        }
        return this.ajM;
    }

    public final void a(com.kwad.library.solder.lib.ext.b bVar) {
        this.ajG = bVar;
    }
}
