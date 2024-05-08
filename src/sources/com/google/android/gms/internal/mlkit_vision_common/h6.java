package com.google.android.gms.internal.mlkit_vision_common;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.datatransport.Priority;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h6 extends j6 {

    /* renamed from: a, reason: collision with root package name */
    public final String f24361a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f24362b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f24363c;

    /* renamed from: d, reason: collision with root package name */
    public final Priority f24364d;

    /* renamed from: e, reason: collision with root package name */
    public final int f24365e;

    public /* synthetic */ h6(String str, boolean z10, boolean z11, Priority priority, int i10, f6 f6Var) {
        this.f24361a = str;
        this.f24362b = z10;
        this.f24363c = z11;
        this.f24364d = priority;
        this.f24365e = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.j6
    public final String a() {
        return this.f24361a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.j6
    public final boolean b() {
        return this.f24362b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.j6
    public final boolean c() {
        return this.f24363c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.j6
    public final Priority d() {
        return this.f24364d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.j6
    public final int e() {
        return this.f24365e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j6) {
            j6 j6Var = (j6) obj;
            if (this.f24361a.equals(j6Var.a()) && this.f24362b == j6Var.b() && this.f24363c == j6Var.c() && this.f24364d.equals(j6Var.d()) && this.f24365e == j6Var.e()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f24361a.hashCode() ^ 1000003) * 1000003;
        boolean z10 = this.f24362b;
        int i10 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
        int i11 = (hashCode ^ (true != z10 ? MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT : MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP)) * 1000003;
        if (true == this.f24363c) {
            i10 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
        }
        return ((((i11 ^ i10) * 1000003) ^ this.f24364d.hashCode()) * 1000003) ^ this.f24365e;
    }

    public final String toString() {
        String str = this.f24361a;
        boolean z10 = this.f24362b;
        boolean z11 = this.f24363c;
        String valueOf = String.valueOf(this.f24364d);
        int i10 = this.f24365e;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 129 + valueOf.length());
        sb2.append("MLKitLoggingOptions{libraryName=");
        sb2.append(str);
        sb2.append(", enableClearcut=");
        sb2.append(z10);
        sb2.append(", enableFirelog=");
        sb2.append(z11);
        sb2.append(", firelogEventPriority=");
        sb2.append(valueOf);
        sb2.append(", firelogEventType=");
        sb2.append(i10);
        sb2.append(com.alipay.sdk.util.i.f4738d);
        return sb2.toString();
    }
}
