package com.cupidapp.live.club.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ClubUserRoleType {
    COMMON(0),
    OWNER(1),
    MANAGER(2);


    @NotNull
    public static final a Companion = new a(null);
    private final int value;

    /* compiled from: ClubTotalModelFile.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ClubUserRoleType a(@Nullable Integer num) {
            ClubUserRoleType clubUserRoleType = ClubUserRoleType.COMMON;
            int value = clubUserRoleType.getValue();
            if (num != null && num.intValue() == value) {
                return clubUserRoleType;
            }
            ClubUserRoleType clubUserRoleType2 = ClubUserRoleType.OWNER;
            int value2 = clubUserRoleType2.getValue();
            if (num == null || num.intValue() != value2) {
                clubUserRoleType2 = ClubUserRoleType.MANAGER;
                int value3 = clubUserRoleType2.getValue();
                if (num == null || num.intValue() != value3) {
                    return clubUserRoleType;
                }
            }
            return clubUserRoleType2;
        }

        public final boolean b(@Nullable Integer num) {
            if (num != null) {
                if (num.intValue() != ClubUserRoleType.OWNER.getValue()) {
                    if (num.intValue() == ClubUserRoleType.MANAGER.getValue()) {
                    }
                }
                return true;
            }
            return false;
        }
    }

    ClubUserRoleType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
