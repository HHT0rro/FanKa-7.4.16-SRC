package com.google.android.gms.internal.mlkit_vision_face;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.datatransport.Priority;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m8 extends o8 {

    /* renamed from: a, reason: collision with root package name */
    public final String f25079a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f25080b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f25081c;

    /* renamed from: d, reason: collision with root package name */
    public final Priority f25082d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25083e;

    public /* synthetic */ m8(String str, boolean z10, boolean z11, Priority priority, int i10, k8 k8Var) {
        this.f25079a = str;
        this.f25080b = z10;
        this.f25081c = z11;
        this.f25082d = priority;
        this.f25083e = i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.o8
    public final String a() {
        return this.f25079a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.o8
    public final boolean b() {
        return this.f25080b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.o8
    public final boolean c() {
        return this.f25081c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.o8
    public final Priority d() {
        return this.f25082d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.o8
    public final int e() {
        return this.f25083e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o8) {
            o8 o8Var = (o8) obj;
            if (this.f25079a.equals(o8Var.a()) && this.f25080b == o8Var.b() && this.f25081c == o8Var.c() && this.f25082d.equals(o8Var.d()) && this.f25083e == o8Var.e()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f25079a.hashCode() ^ 1000003) * 1000003;
        boolean z10 = this.f25080b;
        int i10 = MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
        int i11 = (hashCode ^ (true != z10 ? MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT : MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP)) * 1000003;
        if (true == this.f25081c) {
            i10 = MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP;
        }
        return ((((i11 ^ i10) * 1000003) ^ this.f25082d.hashCode()) * 1000003) ^ this.f25083e;
    }

    public final String toString() {
        String str = this.f25079a;
        boolean z10 = this.f25080b;
        boolean z11 = this.f25081c;
        String valueOf = String.valueOf(this.f25082d);
        int i10 = this.f25083e;
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
