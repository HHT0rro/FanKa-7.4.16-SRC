package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.datatransport.Priority;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l8 extends n8 {

    /* renamed from: a, reason: collision with root package name */
    public String f25047a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f25048b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f25049c;

    /* renamed from: d, reason: collision with root package name */
    public Priority f25050d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f25051e;

    @Override // com.google.android.gms.internal.mlkit_vision_face.n8
    public final n8 a(boolean z10) {
        this.f25048b = Boolean.valueOf(z10);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n8
    public final n8 b(boolean z10) {
        this.f25049c = Boolean.TRUE;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n8
    public final n8 c(Priority priority) {
        Objects.requireNonNull(priority, "Null firelogEventPriority");
        this.f25050d = priority;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n8
    public final n8 d(int i10) {
        this.f25051e = 0;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.n8
    public final o8 e() {
        String str = this.f25047a == null ? " libraryName" : "";
        if (this.f25048b == null) {
            str = str.concat(" enableClearcut");
        }
        if (this.f25049c == null) {
            str = String.valueOf(str).concat(" enableFirelog");
        }
        if (this.f25050d == null) {
            str = String.valueOf(str).concat(" firelogEventPriority");
        }
        if (this.f25051e == null) {
            str = String.valueOf(str).concat(" firelogEventType");
        }
        if (str.isEmpty()) {
            return new m8(this.f25047a, this.f25048b.booleanValue(), this.f25049c.booleanValue(), this.f25050d, this.f25051e.intValue(), null);
        }
        throw new IllegalStateException(str.length() != 0 ? "Missing required properties:".concat(str) : new String("Missing required properties:"));
    }

    public final n8 f(String str) {
        Objects.requireNonNull(str, "Null libraryName");
        this.f25047a = str;
        return this;
    }
}
