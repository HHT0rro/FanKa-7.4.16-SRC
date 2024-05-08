package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.j;
import java.util.List;

/* compiled from: AutoValue_LogRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f extends j {

    /* renamed from: a, reason: collision with root package name */
    public final long f19349a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19350b;

    /* renamed from: c, reason: collision with root package name */
    public final ClientInfo f19351c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f19352d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19353e;

    /* renamed from: f, reason: collision with root package name */
    public final List<LogEvent> f19354f;

    /* renamed from: g, reason: collision with root package name */
    public final QosTier f19355g;

    /* compiled from: AutoValue_LogRequest.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends j.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f19356a;

        /* renamed from: b, reason: collision with root package name */
        public Long f19357b;

        /* renamed from: c, reason: collision with root package name */
        public ClientInfo f19358c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f19359d;

        /* renamed from: e, reason: collision with root package name */
        public String f19360e;

        /* renamed from: f, reason: collision with root package name */
        public List<LogEvent> f19361f;

        /* renamed from: g, reason: collision with root package name */
        public QosTier f19362g;

        @Override // com.google.android.datatransport.cct.internal.j.a
        public j a() {
            String str = "";
            if (this.f19356a == null) {
                str = " requestTimeMs";
            }
            if (this.f19357b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new f(this.f19356a.longValue(), this.f19357b.longValue(), this.f19358c, this.f19359d, this.f19360e, this.f19361f, this.f19362g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.j.a
        public j.a b(@Nullable ClientInfo clientInfo) {
            this.f19358c = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.j.a
        public j.a c(@Nullable List<LogEvent> list) {
            this.f19361f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.j.a
        public j.a d(@Nullable Integer num) {
            this.f19359d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.j.a
        public j.a e(@Nullable String str) {
            this.f19360e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.j.a
        public j.a f(@Nullable QosTier qosTier) {
            this.f19362g = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.j.a
        public j.a g(long j10) {
            this.f19356a = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.j.a
        public j.a h(long j10) {
            this.f19357b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.j
    @Nullable
    public ClientInfo b() {
        return this.f19351c;
    }

    @Override // com.google.android.datatransport.cct.internal.j
    @Nullable
    public List<LogEvent> c() {
        return this.f19354f;
    }

    @Override // com.google.android.datatransport.cct.internal.j
    @Nullable
    public Integer d() {
        return this.f19352d;
    }

    @Override // com.google.android.datatransport.cct.internal.j
    @Nullable
    public String e() {
        return this.f19353e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f19349a == jVar.g() && this.f19350b == jVar.h() && ((clientInfo = this.f19351c) != null ? clientInfo.equals(jVar.b()) : jVar.b() == null) && ((num = this.f19352d) != null ? num.equals(jVar.d()) : jVar.d() == null) && ((str = this.f19353e) != null ? str.equals(jVar.e()) : jVar.e() == null) && ((list = this.f19354f) != null ? list.equals(jVar.c()) : jVar.c() == null)) {
            QosTier qosTier = this.f19355g;
            if (qosTier == null) {
                if (jVar.f() == null) {
                    return true;
                }
            } else if (qosTier.equals(jVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.j
    @Nullable
    public QosTier f() {
        return this.f19355g;
    }

    @Override // com.google.android.datatransport.cct.internal.j
    public long g() {
        return this.f19349a;
    }

    @Override // com.google.android.datatransport.cct.internal.j
    public long h() {
        return this.f19350b;
    }

    public int hashCode() {
        long j10 = this.f19349a;
        long j11 = this.f19350b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        ClientInfo clientInfo = this.f19351c;
        int hashCode = (i10 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f19352d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f19353e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<LogEvent> list = this.f19354f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f19355g;
        return hashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f19349a + ", requestUptimeMs=" + this.f19350b + ", clientInfo=" + ((Object) this.f19351c) + ", logSource=" + ((Object) this.f19352d) + ", logSourceName=" + this.f19353e + ", logEvents=" + ((Object) this.f19354f) + ", qosTier=" + ((Object) this.f19355g) + com.alipay.sdk.util.i.f4738d;
    }

    public f(long j10, long j11, @Nullable ClientInfo clientInfo, @Nullable Integer num, @Nullable String str, @Nullable List<LogEvent> list, @Nullable QosTier qosTier) {
        this.f19349a = j10;
        this.f19350b = j11;
        this.f19351c = clientInfo;
        this.f19352d = num;
        this.f19353e = str;
        this.f19354f = list;
        this.f19355g = qosTier;
    }
}
