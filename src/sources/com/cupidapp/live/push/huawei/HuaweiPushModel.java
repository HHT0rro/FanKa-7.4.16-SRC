package com.cupidapp.live.push.huawei;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: HuaweiPushServices.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HuaweiPushModel {

    @Nullable
    private final String from;
    private final int isClassify;
    private final int lockDisplay;

    @Nullable
    private final MsgContentBean msgContent;
    private final int msgType;

    @Nullable
    private final String picSize;
    private final int priority;

    @Nullable
    private final String sendTime;

    @Nullable
    private final String ttl;

    @Nullable
    public final String getFrom() {
        return this.from;
    }

    public final int getLockDisplay() {
        return this.lockDisplay;
    }

    @Nullable
    public final MsgContentBean getMsgContent() {
        return this.msgContent;
    }

    public final int getMsgType() {
        return this.msgType;
    }

    @Nullable
    public final String getPicSize() {
        return this.picSize;
    }

    public final int getPriority() {
        return this.priority;
    }

    @Nullable
    public final String getSendTime() {
        return this.sendTime;
    }

    @Nullable
    public final String getTtl() {
        return this.ttl;
    }

    public final int isClassify() {
        return this.isClassify;
    }
}
