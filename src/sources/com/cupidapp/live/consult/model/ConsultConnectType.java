package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ConsultConnectType {
    NORMAL("c2g", "COMMON"),
    ONE_ON_ONE("c2c", "ONE_TO_ONE");


    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private final String typeName;

    @NotNull
    private final String value;

    /* compiled from: ConsultLiveModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ConsultConnectType a(@Nullable String str) {
            ConsultConnectType consultConnectType = ConsultConnectType.NORMAL;
            if (s.d(str, consultConnectType.getValue())) {
                return consultConnectType;
            }
            ConsultConnectType consultConnectType2 = ConsultConnectType.ONE_ON_ONE;
            if (s.d(str, consultConnectType2.getValue())) {
                return consultConnectType2;
            }
            return null;
        }
    }

    ConsultConnectType(String str, String str2) {
        this.value = str;
        this.typeName = str2;
    }

    @NotNull
    public final String getTypeName() {
        return this.typeName;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
