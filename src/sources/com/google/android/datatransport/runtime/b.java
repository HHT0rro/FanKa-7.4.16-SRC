package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: AutoValue_TransportContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends TransportContext {

    /* renamed from: a, reason: collision with root package name */
    public final String f19380a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f19381b;

    /* renamed from: c, reason: collision with root package name */
    public final Priority f19382c;

    /* compiled from: AutoValue_TransportContext.java */
    /* renamed from: com.google.android.datatransport.runtime.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0182b extends TransportContext.a {

        /* renamed from: a, reason: collision with root package name */
        public String f19383a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f19384b;

        /* renamed from: c, reason: collision with root package name */
        public Priority f19385c;

        @Override // com.google.android.datatransport.runtime.TransportContext.a
        public TransportContext a() {
            String str = "";
            if (this.f19383a == null) {
                str = " backendName";
            }
            if (this.f19385c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new b(this.f19383a, this.f19384b, this.f19385c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.a
        public TransportContext.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.f19383a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.a
        public TransportContext.a c(@Nullable byte[] bArr) {
            this.f19384b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportContext.a
        public TransportContext.a d(Priority priority) {
            Objects.requireNonNull(priority, "Null priority");
            this.f19385c = priority;
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    public String b() {
        return this.f19380a;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    @Nullable
    public byte[] c() {
        return this.f19381b;
    }

    @Override // com.google.android.datatransport.runtime.TransportContext
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Priority d() {
        return this.f19382c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f19380a.equals(transportContext.b())) {
            if (Arrays.equals(this.f19381b, transportContext instanceof b ? ((b) transportContext).f19381b : transportContext.c()) && this.f19382c.equals(transportContext.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f19380a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19381b)) * 1000003) ^ this.f19382c.hashCode();
    }

    public b(String str, @Nullable byte[] bArr, Priority priority) {
        this.f19380a = str;
        this.f19381b = bArr;
        this.f19382c = priority;
    }
}
