package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.aw;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a auh;

    /* renamed from: com.kwad.sdk.core.diskcache.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0521a {
        public static final a aui = new a(0);
    }

    private a() {
    }

    public /* synthetic */ a(byte b4) {
        this();
    }

    public static a Dc() {
        return C0521a.aui;
    }

    private boolean Dd() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        return this.auh == null;
    }

    @Nullable
    private File ds(String str) {
        if (Dd() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.auh, str);
    }

    private synchronized void init(Context context) {
        if (this.auh != null || context == null) {
            return;
        }
        try {
            this.auh = com.kwad.sdk.core.diskcache.a.a.a(aw.cK(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public final boolean a(String str, a.C0527a c0527a) {
        File ds;
        if (!Dd() && !TextUtils.isEmpty(str)) {
            String dt = c.dt(str);
            if (b.a(this.auh, str, dt, c0527a) && (ds = ds(dt)) != null && ds.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, @NonNull String str2, a.C0527a c0527a) {
        File ds;
        if (!Dd() && !TextUtils.isEmpty(str)) {
            String dt = c.dt(str2);
            if (b.a(this.auh, str, dt, c0527a) && (ds = ds(dt)) != null && ds.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File bV(String str) {
        if (Dd() || TextUtils.isEmpty(str)) {
            return null;
        }
        return ds(c.dt(str));
    }

    public final void delete() {
        if (Dd()) {
            return;
        }
        try {
            this.auh.delete();
        } catch (IOException unused) {
        }
    }

    public final void dr(String str) {
        if (Dd() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.auh, str, c.dt(str));
    }

    public final boolean remove(String str) {
        if (Dd()) {
            return false;
        }
        try {
            ap.ax(str, "cacheKey is not allowed empty");
            return this.auh.remove(c.dt(str));
        } catch (IOException unused) {
            return false;
        }
    }
}
