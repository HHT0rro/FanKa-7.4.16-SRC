package com.bytedance.pangle.log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f10831a;

    /* renamed from: b, reason: collision with root package name */
    private String f10832b;

    /* renamed from: c, reason: collision with root package name */
    private String f10833c;

    /* renamed from: d, reason: collision with root package name */
    private long f10834d;

    /* renamed from: e, reason: collision with root package name */
    private long f10835e;

    private a(String str, String str2, String str3) {
        this.f10831a = str;
        this.f10832b = str2;
        this.f10833c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f10835e = currentTimeMillis;
        this.f10834d = currentTimeMillis;
        ZeusLogger.i(this.f10831a, this.f10832b + String.format(" watcher[%s]-start", str3));
    }

    public static a a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    public final long a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f10835e;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f10834d;
        ZeusLogger.i(this.f10831a, this.f10832b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f10833c, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }

    public final long a() {
        return System.currentTimeMillis() - this.f10834d;
    }
}
