package com.tencent.turingface.sdk.mfa;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class G1g37 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f45590a = TimeUnit.HOURS.toMillis(32);

    /* renamed from: b, reason: collision with root package name */
    public static final G1g37 f45591b = new G1g37();

    /* renamed from: c, reason: collision with root package name */
    public volatile QjsR0 f45592c = null;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f45593d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public final ReentrantReadWriteLock f45594e = new ReentrantReadWriteLock();

    public final String a(Context context, String str) {
        Map<String, String> map;
        QjsR0 b4 = b(context);
        if (b4 == null || (map = b4.f45680k) == null) {
            return null;
        }
        return map.get(str);
    }

    public final QjsR0 b(Context context) {
        QjsR0 qjsR0;
        this.f45594e.readLock().lock();
        try {
            if (this.f45593d.get()) {
                return this.f45592c;
            }
            synchronized (this.f45593d) {
                if (this.f45593d.get()) {
                    return this.f45592c;
                }
                try {
                    qjsR0 = new QjsR0();
                    qjsR0.a(new nyvKz(com.tencent.turingcam.oqKCa.e(c(context))));
                } catch (Throwable unused) {
                    qjsR0 = null;
                }
                this.f45592c = qjsR0;
                this.f45593d.set(true);
                return this.f45592c;
            }
        } finally {
            this.f45594e.readLock().unlock();
        }
    }

    public final String c(Context context) {
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dir.getAbsolutePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        File file = new File(sb2.toString());
        if (!file.exists() && !file.mkdirs()) {
            return "";
        }
        return file.getAbsolutePath() + str + com.tencent.turingcam.oqKCa.f45455a + "_mfa_1";
    }

    public final long a(Context context, String str, long j10, long j11) {
        String a10 = a(context, str);
        if (a10 == null) {
            return j10;
        }
        try {
            return Long.parseLong(a10) * j11;
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public final boolean a(Context context, String str, boolean z10) {
        String a10 = a(context, str);
        if (a10 == null) {
            return z10;
        }
        try {
            return Integer.parseInt(a10) > 0;
        } catch (NumberFormatException unused) {
            return z10;
        }
    }

    public final String a(Context context) {
        String a10 = a(context, "a_f_ok_c");
        String a11 = a(context, "a_f_ok_s");
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(a10)) {
            for (String str : a10.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
        }
        if (!TextUtils.isEmpty(a11) && context.checkPermission(g.f36123i, Process.myPid(), Process.myUid()) == 0) {
            for (String str2 : a11.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        if (hashSet.size() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator iterator2 = hashSet.iterator2();
        while (iterator2.hasNext()) {
            String str3 = (String) iterator2.next();
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }
}
