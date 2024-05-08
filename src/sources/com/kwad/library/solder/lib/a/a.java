package com.kwad.library.solder.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.i;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a {
    public File ajs;
    public String ajt;
    public String aju;
    private final String ajx;
    public com.kwad.library.solder.lib.c.b ajy;
    public String mVersion;
    private final byte[] ajw = new byte[0];
    private boolean ajv = false;
    public com.kwad.library.solder.lib.ext.c aiX = i.xe().wY();

    public a(String str) {
        this.ajx = str;
        this.ajt = str;
    }

    private void xi() {
        if (this.ajv) {
            return;
        }
        synchronized (this.ajw) {
            this.ajv = true;
        }
    }

    public final a a(@NonNull com.kwad.library.solder.lib.c.b bVar) {
        this.ajy = bVar;
        return this;
    }

    public final void bI(String str) {
        this.mVersion = str;
    }

    public final void bJ(String str) {
        this.aju = str;
    }

    public final void bK(String str) {
        this.ajt = str;
    }

    public abstract void g(Context context, String str);

    public final String getId() {
        return this.aju;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isLoaded() {
        boolean z10;
        if (this.ajv) {
            return true;
        }
        synchronized (this.ajw) {
            z10 = this.ajv;
        }
        return z10;
    }

    public final void l(Context context, String str) {
        g(context, str);
        xi();
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.ajx + "'}";
    }

    public final String xj() {
        return this.ajx;
    }

    public final String xk() {
        com.kwad.library.solder.lib.c.b bVar = this.ajy;
        if (bVar != null) {
            return bVar.aki;
        }
        return null;
    }
}
