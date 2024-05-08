package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.alipay.sdk.util.i;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;
import java.util.Objects;

/* compiled from: AutoValue_EventInternal.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a extends EventInternal {

    /* renamed from: a, reason: collision with root package name */
    public final String f19368a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f19369b;

    /* renamed from: c, reason: collision with root package name */
    public final n4.d f19370c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19371d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19372e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, String> f19373f;

    /* compiled from: AutoValue_EventInternal.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends EventInternal.a {

        /* renamed from: a, reason: collision with root package name */
        public String f19374a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f19375b;

        /* renamed from: c, reason: collision with root package name */
        public n4.d f19376c;

        /* renamed from: d, reason: collision with root package name */
        public Long f19377d;

        /* renamed from: e, reason: collision with root package name */
        public Long f19378e;

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f19379f;

        @Override // com.google.android.datatransport.runtime.EventInternal.a
        public EventInternal d() {
            String str = "";
            if (this.f19374a == null) {
                str = " transportName";
            }
            if (this.f19376c == null) {
                str = str + " encodedPayload";
            }
            if (this.f19377d == null) {
                str = str + " eventMillis";
            }
            if (this.f19378e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f19379f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new a(this.f19374a, this.f19375b, this.f19376c, this.f19377d.longValue(), this.f19378e.longValue(), this.f19379f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.a
        public Map<String, String> e() {
            Map<String, String> map = this.f19379f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.a
        public EventInternal.a f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f19379f = map;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.a
        public EventInternal.a g(Integer num) {
            this.f19375b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.a
        public EventInternal.a h(n4.d dVar) {
            Objects.requireNonNull(dVar, "Null encodedPayload");
            this.f19376c = dVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.a
        public EventInternal.a i(long j10) {
            this.f19377d = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.a
        public EventInternal.a j(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f19374a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.a
        public EventInternal.a k(long j10) {
            this.f19378e = Long.valueOf(j10);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public Map<String, String> c() {
        return this.f19373f;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    @Nullable
    public Integer d() {
        return this.f19369b;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public n4.d e() {
        return this.f19370c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        return this.f19368a.equals(eventInternal.j()) && ((num = this.f19369b) != null ? num.equals(eventInternal.d()) : eventInternal.d() == null) && this.f19370c.equals(eventInternal.e()) && this.f19371d == eventInternal.f() && this.f19372e == eventInternal.k() && this.f19373f.equals(eventInternal.c());
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long f() {
        return this.f19371d;
    }

    public int hashCode() {
        int hashCode = (this.f19368a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f19369b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f19370c.hashCode()) * 1000003;
        long j10 = this.f19371d;
        int i10 = (hashCode2 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f19372e;
        return ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f19373f.hashCode();
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public String j() {
        return this.f19368a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long k() {
        return this.f19372e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f19368a + ", code=" + ((Object) this.f19369b) + ", encodedPayload=" + ((Object) this.f19370c) + ", eventMillis=" + this.f19371d + ", uptimeMillis=" + this.f19372e + ", autoMetadata=" + ((Object) this.f19373f) + i.f4738d;
    }

    public a(String str, @Nullable Integer num, n4.d dVar, long j10, long j11, Map<String, String> map) {
        this.f19368a = str;
        this.f19369b = num;
        this.f19370c = dVar;
        this.f19371d = j10;
        this.f19372e = j11;
        this.f19373f = map;
    }
}
