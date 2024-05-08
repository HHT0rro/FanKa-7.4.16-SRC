package com.google.android.gms.internal.mlkit_common;

import com.google.android.datatransport.Priority;
import java.util.Objects;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w extends y {

    /* renamed from: a, reason: collision with root package name */
    public String f24201a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f24202b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f24203c;

    /* renamed from: d, reason: collision with root package name */
    public Priority f24204d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f24205e;

    @Override // com.google.android.gms.internal.mlkit_common.y
    public final y a(boolean z10) {
        this.f24202b = Boolean.valueOf(z10);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.y
    public final y b(boolean z10) {
        this.f24203c = Boolean.TRUE;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.y
    public final y c(Priority priority) {
        Objects.requireNonNull(priority, "Null firelogEventPriority");
        this.f24204d = priority;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.y
    public final y d(int i10) {
        this.f24205e = 0;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.y
    public final z e() {
        String str = this.f24201a == null ? " libraryName" : "";
        if (this.f24202b == null) {
            str = str.concat(" enableClearcut");
        }
        if (this.f24203c == null) {
            str = String.valueOf(str).concat(" enableFirelog");
        }
        if (this.f24204d == null) {
            str = String.valueOf(str).concat(" firelogEventPriority");
        }
        if (this.f24205e == null) {
            str = String.valueOf(str).concat(" firelogEventType");
        }
        if (str.isEmpty()) {
            return new x(this.f24201a, this.f24202b.booleanValue(), this.f24203c.booleanValue(), this.f24204d, this.f24205e.intValue(), null);
        }
        throw new IllegalStateException(str.length() != 0 ? "Missing required properties:".concat(str) : new String("Missing required properties:"));
    }

    public final y f(String str) {
        this.f24201a = "common";
        return this;
    }
}
