package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserVipType.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum UserVipType {
    NotVip(0),
    Vip(1),
    SVip(2),
    SSVip(3),
    VipAnnual(4),
    SVipAnnual(5),
    SSVipAnnual(6);


    @NotNull
    public static final a Companion = new a(null);
    private final int value;

    /* compiled from: UserVipType.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int i10) {
            return i10 > UserVipType.NotVip.getValue();
        }
    }

    UserVipType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
