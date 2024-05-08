package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKliveConnectResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum LiveConnectType {
    VoiceConnect("voice"),
    VideoConnect("video");


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final String type;

    /* compiled from: FKliveConnectResult.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable String str) {
            return s.d(str, LiveConnectType.VoiceConnect.getType());
        }
    }

    LiveConnectType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
