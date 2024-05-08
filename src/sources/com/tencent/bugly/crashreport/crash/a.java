package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements Comparable<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f39186a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f39187b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f39188c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39189d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39190e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f39191f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        a aVar2 = aVar;
        if (aVar2 == null) {
            return 1;
        }
        long j10 = this.f39187b - aVar2.f39187b;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }
}
