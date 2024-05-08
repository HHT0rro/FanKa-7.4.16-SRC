package com.huawei.serverrequest;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.log.Log;
import java.io.File;
import java.io.IOException;

/* compiled from: CacheProvider.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
class b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f34794b = "CacheProvider";

    /* renamed from: c, reason: collision with root package name */
    public static final String f34795c = "com.huawei.serverrequest.cache";

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final Context f34796a;

    public b(@NonNull Context context) {
        this.f34796a = context;
    }

    public void a(@NonNull d dVar, @Nullable String str) {
        String a10;
        if (str == null || dVar.a().getCacheExpireTime() <= 0 || (a10 = a(dVar.a().getCacheId())) == null) {
            return;
        }
        h.a(a10, str);
    }

    @Nullable
    public String b() {
        String path;
        Context context = this.f34796a;
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            path = cacheDir.getPath();
        } else {
            path = context.getFilesDir().getPath();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(path);
        String str = File.separator;
        sb2.append(str);
        sb2.append(f34795c);
        sb2.append(str);
        File file = new File(sb2.toString());
        if (!file.exists() && !file.mkdir()) {
            Log.e(f34794b, "cacheRoot mkdir failed");
            return null;
        }
        try {
            return file.getCanonicalPath() + str;
        } catch (IOException unused) {
            Log.e(f34794b, "getCanonicalPath failed");
            return null;
        }
    }

    @Nullable
    public String a(@NonNull d dVar) {
        String a10 = a(dVar.a().getCacheId());
        if (a10 == null) {
            return null;
        }
        long b4 = h.b(a10);
        if (b4 == 0) {
            return null;
        }
        if (a(b4, dVar.a().getCacheExpireTime())) {
            h.a(a10);
            return null;
        }
        return h.c(a10);
    }

    public static boolean a(long j10, long j11) {
        return j10 + j11 <= System.currentTimeMillis();
    }

    @Nullable
    public String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String a10 = g.a(str);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        String b4 = b();
        if (TextUtils.isEmpty(b4)) {
            return null;
        }
        return b4 + a10;
    }

    public void a() {
        String b4 = b();
        if (TextUtils.isEmpty(b4)) {
            return;
        }
        h.a(b4);
    }
}
