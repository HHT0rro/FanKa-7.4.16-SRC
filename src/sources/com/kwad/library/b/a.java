package com.kwad.library.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.kwad.library.b.a.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.h;
import com.kwad.sdk.utils.q;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends h {
    private b aiA;
    private Resources aiB;

    public a(String str) {
        super(str);
    }

    private b a(File file, File file2) {
        if (Build.VERSION.SDK_INT < 26) {
            if (!file.canRead()) {
                file.setReadable(true);
            }
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            if (!file.canRead() || !file.canWrite()) {
                file = null;
            }
        }
        File file3 = file;
        com.kwad.library.b.a.a aVar = new com.kwad.library.b.a.a((BaseDexClassLoader) a.class.getClassLoader());
        String absolutePath = file2.getAbsolutePath();
        String absolutePath2 = this.ajs.getAbsolutePath();
        com.kwad.library.solder.lib.c.b bVar = this.ajy;
        return new b(aVar, absolutePath, file3, absolutePath2, bVar.akn, bVar.akm);
    }

    private File d(File file) {
        File file2 = new File(file.getParentFile(), this.aiX.xB());
        q.X(file2);
        return file2;
    }

    @Override // com.kwad.library.solder.lib.h, com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public final void g(Context context, String str) {
        super.g(context, str);
        File file = new File(str);
        try {
            this.aiA = a(d(file), file);
            try {
                this.aiB = com.kwad.library.b.b.a.a(context, context.getResources(), str);
                Objects.toString(this.aiA);
                Objects.toString(this.aiB);
            } catch (Exception e2) {
                Log.getStackTraceString(e2);
                throw new PluginError.LoadError(e2, 4006);
            }
        } catch (IOException e10) {
            throw new PluginError.LoadError(e10, 4002);
        }
    }

    public final Resources getResources() {
        return this.aiB;
    }

    public final b wU() {
        return this.aiA;
    }
}
