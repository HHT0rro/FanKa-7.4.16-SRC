package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.datatransport.Priority;
import java.util.Objects;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g6 extends i6 {

    /* renamed from: a, reason: collision with root package name */
    public String f24338a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f24339b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f24340c;

    /* renamed from: d, reason: collision with root package name */
    public Priority f24341d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f24342e;

    @Override // com.google.android.gms.internal.mlkit_vision_common.i6
    public final i6 a(boolean z10) {
        this.f24339b = Boolean.valueOf(z10);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.i6
    public final i6 b(boolean z10) {
        this.f24340c = Boolean.TRUE;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.i6
    public final i6 c(Priority priority) {
        Objects.requireNonNull(priority, "Null firelogEventPriority");
        this.f24341d = priority;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.i6
    public final i6 d(int i10) {
        this.f24342e = 0;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.i6
    public final j6 e() {
        String str = this.f24338a == null ? " libraryName" : "";
        if (this.f24339b == null) {
            str = str.concat(" enableClearcut");
        }
        if (this.f24340c == null) {
            str = String.valueOf(str).concat(" enableFirelog");
        }
        if (this.f24341d == null) {
            str = String.valueOf(str).concat(" firelogEventPriority");
        }
        if (this.f24342e == null) {
            str = String.valueOf(str).concat(" firelogEventType");
        }
        if (str.isEmpty()) {
            return new h6(this.f24338a, this.f24339b.booleanValue(), this.f24340c.booleanValue(), this.f24341d, this.f24342e.intValue(), null);
        }
        throw new IllegalStateException(str.length() != 0 ? "Missing required properties:".concat(str) : new String("Missing required properties:"));
    }

    public final i6 f(String str) {
        this.f24338a = "vision-common";
        return this;
    }
}
