package com.cupidapp.live.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.base.network.gson.GsonUtil;
import java.io.Serializable;
import java.net.URLDecoder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPushModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKPushMessageModel implements Serializable {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private String channel;

    @NotNull
    private final String content;

    @Nullable
    private final String data;
    private boolean localSound;

    @Nullable
    private Integer platform;

    @NotNull
    private String pushId;

    @NotNull
    private String pushMessageType;

    @NotNull
    private String ringRaw;
    private long sendTime;

    @Nullable
    private String senderId;

    @Nullable
    private final Boolean sensorRecord;
    private boolean soundEnable;

    @Nullable
    private Integer subtaskType;

    @Nullable
    private Integer taskType;

    @Nullable
    private Integer textId;

    @NotNull
    private final String title;

    @NotNull
    private FKPushTunnel tunnel;

    @Nullable
    private String url;

    @NotNull
    private final String userId;
    private boolean vibrate;

    /* compiled from: FKPushModel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void d(Companion companion, Context context, String str, String str2, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str2 = "mipushscheme";
            }
            companion.c(context, str, str2);
        }

        @Nullable
        public final FKPushMessageModel a(@Nullable Uri uri) {
            String queryParameter = uri != null ? uri.getQueryParameter("pushModel") : null;
            if (uri == null) {
                return null;
            }
            return b(queryParameter);
        }

        @Nullable
        public final FKPushMessageModel b(@Nullable String str) {
            if (str == null) {
                return null;
            }
            try {
                return (FKPushMessageModel) GsonUtil.f12000a.b().fromJson(URLDecoder.decode(str, "UTF-8"), FKPushMessageModel.class);
            } catch (Exception unused) {
                return (FKPushMessageModel) GsonUtil.f12000a.b().fromJson(URLDecoder.decode(p.A(str, "%", "", false, 4, null), "UTF-8"), FKPushMessageModel.class);
            }
        }

        public final void c(@Nullable Context context, @Nullable String str, @Nullable String str2) {
            if (context != null) {
                if (str == null || str.length() == 0) {
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) MainActivity.class);
                intent.addFlags(268435456);
                intent.setData(Uri.parse(str2 + "://push?pushModel=" + str));
                context.startActivity(intent);
            }
        }
    }

    public FKPushMessageModel(@NotNull String userId, @NotNull String title, @NotNull String content, boolean z10, @NotNull String ringRaw, boolean z11, boolean z12, @NotNull FKPushTunnel tunnel, long j10, @Nullable String str, @NotNull String pushId, @Nullable String str2, @NotNull String pushMessageType, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4) {
        s.i(userId, "userId");
        s.i(title, "title");
        s.i(content, "content");
        s.i(ringRaw, "ringRaw");
        s.i(tunnel, "tunnel");
        s.i(pushId, "pushId");
        s.i(pushMessageType, "pushMessageType");
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.vibrate = z10;
        this.ringRaw = ringRaw;
        this.localSound = z11;
        this.soundEnable = z12;
        this.tunnel = tunnel;
        this.sendTime = j10;
        this.senderId = str;
        this.pushId = pushId;
        this.url = str2;
        this.pushMessageType = pushMessageType;
        this.platform = num;
        this.taskType = num2;
        this.subtaskType = num3;
        this.textId = num4;
        this.sensorRecord = bool;
        this.data = str3;
        this.channel = str4;
    }

    @Nullable
    public final String getChannel() {
        return this.channel;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    public final boolean getLocalSound() {
        return this.localSound;
    }

    public final int getNotifyId() {
        return getPushType().notifyId();
    }

    @Nullable
    public final Integer getPlatform() {
        return this.platform;
    }

    @NotNull
    public final String getPushId() {
        return this.pushId;
    }

    @NotNull
    public final String getPushMessageType() {
        return this.pushMessageType;
    }

    @NotNull
    public final FKPushType getPushType() {
        return FKPushType.valueOf(this.pushMessageType);
    }

    @NotNull
    public final String getRingRaw() {
        return this.ringRaw;
    }

    public final long getSendTime() {
        return this.sendTime;
    }

    @Nullable
    public final String getSenderId() {
        return this.senderId;
    }

    @Nullable
    public final Boolean getSensorRecord() {
        return this.sensorRecord;
    }

    public final boolean getSoundEnable() {
        return this.soundEnable;
    }

    @Nullable
    public final Integer getSubtaskType() {
        return this.subtaskType;
    }

    @Nullable
    public final Integer getTaskType() {
        return this.taskType;
    }

    @Nullable
    public final Integer getTextId() {
        return this.textId;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final FKPushTunnel getTunnel() {
        return this.tunnel;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public final boolean getVibrate() {
        return this.vibrate;
    }

    public final void setChannel(@Nullable String str) {
        this.channel = str;
    }

    public final void setLocalSound(boolean z10) {
        this.localSound = z10;
    }

    public final void setPlatform(@Nullable Integer num) {
        this.platform = num;
    }

    public final void setPushId(@NotNull String str) {
        s.i(str, "<set-?>");
        this.pushId = str;
    }

    public final void setPushMessageType(@NotNull String str) {
        s.i(str, "<set-?>");
        this.pushMessageType = str;
    }

    public final void setRingRaw(@NotNull String str) {
        s.i(str, "<set-?>");
        this.ringRaw = str;
    }

    public final void setSendTime(long j10) {
        this.sendTime = j10;
    }

    public final void setSenderId(@Nullable String str) {
        this.senderId = str;
    }

    public final void setSoundEnable(boolean z10) {
        this.soundEnable = z10;
    }

    public final void setSubtaskType(@Nullable Integer num) {
        this.subtaskType = num;
    }

    public final void setTaskType(@Nullable Integer num) {
        this.taskType = num;
    }

    public final void setTextId(@Nullable Integer num) {
        this.textId = num;
    }

    public final void setTunnel(@NotNull FKPushTunnel fKPushTunnel) {
        s.i(fKPushTunnel, "<set-?>");
        this.tunnel = fKPushTunnel;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    public final void setVibrate(boolean z10) {
        this.vibrate = z10;
    }

    public /* synthetic */ FKPushMessageModel(String str, String str2, String str3, boolean z10, String str4, boolean z11, boolean z12, FKPushTunnel fKPushTunnel, long j10, String str5, String str6, String str7, String str8, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, String str9, String str10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i10 & 8) != 0 ? false : z10, str4, (i10 & 32) != 0 ? false : z11, (i10 & 64) != 0 ? false : z12, (i10 & 128) != 0 ? FKPushTunnel.GRPC : fKPushTunnel, j10, (i10 & 512) != 0 ? null : str5, str6, (i10 & 2048) != 0 ? null : str7, str8, (i10 & 8192) != 0 ? null : num, (i10 & 16384) != 0 ? null : num2, (32768 & i10) != 0 ? null : num3, (65536 & i10) != 0 ? null : num4, (131072 & i10) != 0 ? Boolean.FALSE : bool, (262144 & i10) != 0 ? null : str9, (i10 & 524288) != 0 ? null : str10);
    }
}
