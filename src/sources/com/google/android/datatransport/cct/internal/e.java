package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ClientInfo;

/* compiled from: AutoValue_ClientInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e extends ClientInfo {

    /* renamed from: a, reason: collision with root package name */
    public final ClientInfo.ClientType f19345a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.datatransport.cct.internal.a f19346b;

    /* compiled from: AutoValue_ClientInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b extends ClientInfo.a {

        /* renamed from: a, reason: collision with root package name */
        public ClientInfo.ClientType f19347a;

        /* renamed from: b, reason: collision with root package name */
        public com.google.android.datatransport.cct.internal.a f19348b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new e(this.f19347a, this.f19348b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a b(@Nullable com.google.android.datatransport.cct.internal.a aVar) {
            this.f19348b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a c(@Nullable ClientInfo.ClientType clientType) {
            this.f19347a = clientType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public com.google.android.datatransport.cct.internal.a b() {
        return this.f19346b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public ClientInfo.ClientType c() {
        return this.f19345a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f19345a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            com.google.android.datatransport.cct.internal.a aVar = this.f19346b;
            if (aVar == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (aVar.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f19345a;
        int hashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        com.google.android.datatransport.cct.internal.a aVar = this.f19346b;
        return hashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + ((Object) this.f19345a) + ", androidClientInfo=" + ((Object) this.f19346b) + com.alipay.sdk.util.i.f4738d;
    }

    public e(@Nullable ClientInfo.ClientType clientType, @Nullable com.google.android.datatransport.cct.internal.a aVar) {
        this.f19345a = clientType;
        this.f19346b = aVar;
    }
}
