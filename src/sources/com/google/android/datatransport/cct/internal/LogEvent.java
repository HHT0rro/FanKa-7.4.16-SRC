package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class LogEvent {

    @AutoValue.Builder
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class Builder {
        @NonNull
        public abstract LogEvent a();

        @NonNull
        public abstract Builder b(@Nullable Integer num);

        @NonNull
        public abstract Builder c(long j10);

        @NonNull
        public abstract Builder d(long j10);

        @NonNull
        public abstract Builder e(@Nullable NetworkConnectionInfo networkConnectionInfo);

        @NonNull
        public abstract Builder f(@Nullable byte[] bArr);

        @NonNull
        public abstract Builder g(@Nullable String str);

        @NonNull
        public abstract Builder h(long j10);
    }

    private static Builder builder() {
        return new AutoValue_LogEvent.a();
    }

    @NonNull
    public static Builder jsonBuilder(@NonNull String str) {
        return builder().g(str);
    }

    @NonNull
    public static Builder protoBuilder(@NonNull byte[] bArr) {
        return builder().f(bArr);
    }

    @Nullable
    public abstract Integer getEventCode();

    public abstract long getEventTimeMs();

    public abstract long getEventUptimeMs();

    @Nullable
    public abstract NetworkConnectionInfo getNetworkConnectionInfo();

    @Nullable
    public abstract byte[] getSourceExtension();

    @Nullable
    public abstract String getSourceExtensionJsonProto3();

    public abstract long getTimezoneOffsetSeconds();
}
