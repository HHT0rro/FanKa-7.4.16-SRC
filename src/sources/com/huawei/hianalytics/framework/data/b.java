package com.huawei.hianalytics.framework.data;

import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.core.crypto.RsaCipher;
import com.huawei.hianalytics.core.log.HiLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static b f28782b = new b();

    /* renamed from: a, reason: collision with root package name */
    public a f28783a = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f28784a;

        /* renamed from: b, reason: collision with root package name */
        public String f28785b;

        /* renamed from: c, reason: collision with root package name */
        public long f28786c = 0;

        public a() {
        }

        public void a(String str) {
            b.this.f28783a.f28785b = str;
        }

        public void b(String str) {
            b.this.f28783a.f28784a = str;
        }

        public void a(long j10) {
            b.this.f28783a.f28786c = j10;
        }
    }

    public static b b() {
        return f28782b;
    }

    public long c() {
        return this.f28783a.f28786c;
    }

    public String d() {
        return this.f28783a.f28784a;
    }

    private void a(String str, String str2, long j10) {
        this.f28783a.a(str);
        this.f28783a.b(str2);
        this.f28783a.a(j10);
    }

    public synchronized void b(String str, String str2) {
        long c4 = c();
        String a10 = a(str, str2);
        if (a10 != null && !a10.isEmpty()) {
            if (c4 == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                String initRandomKey = HexUtil.initRandomKey(16);
                a(RsaCipher.encrypt(a10, initRandomKey), initRandomKey, currentTimeMillis);
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 - c4 > 43200000) {
                    String initRandomKey2 = HexUtil.initRandomKey(16);
                    a(RsaCipher.encrypt(a10, initRandomKey2), initRandomKey2, currentTimeMillis2);
                }
            }
            return;
        }
        HiLog.sw("WorkKeyHandler", "get rsa pubkey config error");
    }

    private String a(String str, String str2) {
        return ConfigManager.getInstance().getParameters().getRsaPublicKeyFromNetWork(str, str2);
    }

    public String a() {
        return this.f28783a.f28785b;
    }
}
