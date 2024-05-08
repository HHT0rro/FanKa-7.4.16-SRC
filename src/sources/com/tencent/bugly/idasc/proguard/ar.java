package com.tencent.bugly.idasc.proguard;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ar implements Comparable<ar> {

    /* renamed from: a, reason: collision with root package name */
    public long f39610a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f39611b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f39612c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39613d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39614e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f39615f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(ar arVar) {
        ar arVar2 = arVar;
        if (arVar2 == null) {
            return 1;
        }
        long j10 = this.f39611b - arVar2.f39611b;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }
}
