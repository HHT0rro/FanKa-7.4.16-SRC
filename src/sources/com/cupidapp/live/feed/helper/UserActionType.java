package com.cupidapp.live.feed.helper;

/* compiled from: FeedExposureReportHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum UserActionType {
    Read(0),
    Click(1),
    Praise(2),
    Comment(3),
    Share(4),
    CancelPraise(5),
    DeleteComment(6);

    private final int value;

    UserActionType(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }
}
