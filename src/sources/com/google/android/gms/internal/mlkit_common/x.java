package com.google.android.gms.internal.mlkit_common;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.datatransport.Priority;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x extends z {

    /* renamed from: a, reason: collision with root package name */
    public final String f24206a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f24207b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f24208c;

    /* renamed from: d, reason: collision with root package name */
    public final Priority f24209d;

    /* renamed from: e, reason: collision with root package name */
    public final int f24210e;

    public /* synthetic */ x(String str, boolean z10, boolean z11, Priority priority, int i10, v vVar) {
        this.f24206a = str;
        this.f24207b = z10;
        this.f24208c = z11;
        this.f24209d = priority;
        this.f24210e = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_common.z
    public final String a() {
        return this.f24206a;
    }

    @Override // com.google.android.gms.internal.mlkit_common.z
    public final boolean b() {
        return this.f24207b;
    }

    @Override // com.google.android.gms.internal.mlkit_common.z
    public final boolean c() {
        return this.f24208c;
    }

    @Override // com.google.android.gms.internal.mlkit_common.z
    public final Priority d() {
        return this.f24209d;
    }

    @Override // com.google.android.gms.internal.mlkit_common.z
    public final int e() {
        return this.f24210e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.f24206a.equals(zVar.a()) && this.f24207b == zVar.b() && this.f24208c == zVar.c() && this.f24209d.equals(zVar.d()) && this.f24210e == zVar.e()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f24206a.hashCode() ^ 1000003) * 1000003;
        boolean z10 = this.f24207b;
        int i10 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
        int i11 = (hashCode ^ (true != z10 ? MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT : MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP)) * 1000003;
        if (true == this.f24208c) {
            i10 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
        }
        return ((((i11 ^ i10) * 1000003) ^ this.f24209d.hashCode()) * 1000003) ^ this.f24210e;
    }

    public final String toString() {
        String str = this.f24206a;
        boolean z10 = this.f24207b;
        boolean z11 = this.f24208c;
        String valueOf = String.valueOf(this.f24209d);
        int i10 = this.f24210e;
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
