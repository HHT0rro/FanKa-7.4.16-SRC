package com.cupidapp.live.club.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum RedPacketStatus {
    UnOpened(0),
    Opened(1),
    Expired(2);


    @NotNull
    public static final a Companion = new a(null);
    private final int status;

    /* compiled from: ClubTotalModelFile.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final RedPacketStatus a(@Nullable Integer num) {
            RedPacketStatus redPacketStatus = RedPacketStatus.UnOpened;
            int status = redPacketStatus.getStatus();
            if (num != null && num.intValue() == status) {
                return redPacketStatus;
            }
            RedPacketStatus redPacketStatus2 = RedPacketStatus.Opened;
            int status2 = redPacketStatus2.getStatus();
            if (num != null && num.intValue() == status2) {
                return redPacketStatus2;
            }
            RedPacketStatus redPacketStatus3 = RedPacketStatus.Expired;
            int status3 = redPacketStatus3.getStatus();
            if (num != null && num.intValue() == status3) {
                return redPacketStatus3;
            }
            return null;
        }
    }

    RedPacketStatus(int i10) {
        this.status = i10;
    }

    public final int getStatus() {
        return this.status;
    }
}
