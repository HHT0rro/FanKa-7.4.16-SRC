package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveHornLinkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum FKHornType {
    SmallHornType(0, "SMALL_HORN"),
    BigHornType(1, "BIG_HORN");


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final String hornName;
    private final int hornType;

    /* compiled from: FKLiveHornLinkModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKHornType a(int i10) {
            FKHornType fKHornType = FKHornType.SmallHornType;
            if (i10 == fKHornType.getHornType()) {
                return fKHornType;
            }
            FKHornType fKHornType2 = FKHornType.BigHornType;
            if (i10 == fKHornType2.getHornType()) {
                return fKHornType2;
            }
            return null;
        }
    }

    FKHornType(int i10, String str) {
        this.hornType = i10;
        this.hornName = str;
    }

    @NotNull
    public final String getHornName() {
        return this.hornName;
    }

    public final int getHornType() {
        return this.hornType;
    }
}
