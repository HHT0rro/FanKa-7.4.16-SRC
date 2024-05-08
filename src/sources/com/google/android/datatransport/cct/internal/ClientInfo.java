package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.e;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class ClientInfo {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int i10) {
            this.value = i10;
        }
    }

    @AutoValue.Builder
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class a {
        @NonNull
        public abstract ClientInfo a();

        @NonNull
        public abstract a b(@Nullable com.google.android.datatransport.cct.internal.a aVar);

        @NonNull
        public abstract a c(@Nullable ClientType clientType);
    }

    @NonNull
    public static a a() {
        return new e.b();
    }

    @Nullable
    public abstract com.google.android.datatransport.cct.internal.a b();

    @Nullable
    public abstract ClientType c();
}
