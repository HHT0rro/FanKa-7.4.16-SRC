package com.cupidapp.live.club.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ActivityStatus {
    Registering(0, "报名中"),
    Expired(1, "已截止"),
    InProgress(2, "进行中"),
    Ended(3, "已结束");


    @NotNull
    public static final a Companion = new a(null);
    private final int status;

    @NotNull
    private final String statusName;

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
        public final ActivityStatus a(@Nullable Integer num) {
            ActivityStatus activityStatus = ActivityStatus.Registering;
            int status = activityStatus.getStatus();
            if (num != null && num.intValue() == status) {
                return activityStatus;
            }
            ActivityStatus activityStatus2 = ActivityStatus.Expired;
            int status2 = activityStatus2.getStatus();
            if (num != null && num.intValue() == status2) {
                return activityStatus2;
            }
            ActivityStatus activityStatus3 = ActivityStatus.InProgress;
            int status3 = activityStatus3.getStatus();
            if (num != null && num.intValue() == status3) {
                return activityStatus3;
            }
            ActivityStatus activityStatus4 = ActivityStatus.Ended;
            int status4 = activityStatus4.getStatus();
            if (num != null && num.intValue() == status4) {
                return activityStatus4;
            }
            return null;
        }

        public final int b(@Nullable Integer num) {
            int status = ActivityStatus.Registering.getStatus();
            if (num != null && num.intValue() == status) {
                return -4091286;
            }
            int status2 = ActivityStatus.Expired.getStatus();
            if (num != null && num.intValue() == status2) {
                return -8891597;
            }
            int status3 = ActivityStatus.InProgress.getStatus();
            if (num != null && num.intValue() == status3) {
                return -134939;
            }
            return (num != null && num.intValue() == ActivityStatus.Ended.getStatus()) ? -6250336 : 0;
        }
    }

    ActivityStatus(int i10, String str) {
        this.status = i10;
        this.statusName = str;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getStatusName() {
        return this.statusName;
    }
}
