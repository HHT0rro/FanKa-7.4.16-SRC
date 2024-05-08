package com.cupidapp.live.chat.model;

import b2.a;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.chat.service.VisitorInfoModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InboxSessionModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class InboxSessionModel {

    @Nullable
    private final Boolean chatStatusDot;

    @Nullable
    private Integer countdown;
    private boolean exposure;

    @Nullable
    private final ImageModel groupAvatar;

    @Nullable
    private final String groupName;

    @NotNull
    private final String itemId;

    @Nullable
    private final String lastMessage;

    @Nullable
    private final Long lastMessageTimeMillis;

    @Nullable
    private String liveShowId;
    private final boolean marketingDot;

    @Nullable
    private final String marketingUrl;

    @Nullable
    private Integer maskRemainSec;
    private final boolean notDisturb;

    @Nullable
    private final ImageModel officialAccountIcon;
    private final boolean redDot;
    private long refreshSessionLiveStatusTime;

    @Nullable
    private final User sender;

    @Nullable
    private final String sourceDesc;

    @Nullable
    private Boolean stealthMessage;

    @Nullable
    private final Boolean temp;

    @Nullable
    private final String templateMsgId;

    @Nullable
    private final String trackName;

    @NotNull
    private final String type;
    private int unread;

    @Nullable
    private final Long updateTimeMillis;

    @Nullable
    private final String url;

    @Nullable
    private final VisitorInfoModel visitorInfo;

    public InboxSessionModel(@NotNull String itemId, @Nullable Long l10, @Nullable Integer num, int i10, @Nullable User user, @Nullable Boolean bool, @Nullable Long l11, @Nullable String str, @NotNull String type, @Nullable String str2, boolean z10, @Nullable VisitorInfoModel visitorInfoModel, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z11, @Nullable String str6, @Nullable ImageModel imageModel, boolean z12, boolean z13, long j10, @Nullable String str7, @Nullable String str8, @Nullable ImageModel imageModel2) {
        s.i(itemId, "itemId");
        s.i(type, "type");
        this.itemId = itemId;
        this.updateTimeMillis = l10;
        this.countdown = num;
        this.unread = i10;
        this.sender = user;
        this.temp = bool;
        this.lastMessageTimeMillis = l11;
        this.lastMessage = str;
        this.type = type;
        this.url = str2;
        this.exposure = z10;
        this.visitorInfo = visitorInfoModel;
        this.stealthMessage = bool2;
        this.chatStatusDot = bool3;
        this.maskRemainSec = num2;
        this.liveShowId = str3;
        this.marketingUrl = str4;
        this.trackName = str5;
        this.marketingDot = z11;
        this.groupName = str6;
        this.groupAvatar = imageModel;
        this.redDot = z12;
        this.notDisturb = z13;
        this.refreshSessionLiveStatusTime = j10;
        this.sourceDesc = str7;
        this.templateMsgId = str8;
        this.officialAccountIcon = imageModel2;
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @Nullable
    public final String component10() {
        return this.url;
    }

    public final boolean component11() {
        return this.exposure;
    }

    @Nullable
    public final VisitorInfoModel component12() {
        return this.visitorInfo;
    }

    @Nullable
    public final Boolean component13() {
        return this.stealthMessage;
    }

    @Nullable
    public final Boolean component14() {
        return this.chatStatusDot;
    }

    @Nullable
    public final Integer component15() {
        return this.maskRemainSec;
    }

    @Nullable
    public final String component16() {
        return this.liveShowId;
    }

    @Nullable
    public final String component17() {
        return this.marketingUrl;
    }

    @Nullable
    public final String component18() {
        return this.trackName;
    }

    public final boolean component19() {
        return this.marketingDot;
    }

    @Nullable
    public final Long component2() {
        return this.updateTimeMillis;
    }

    @Nullable
    public final String component20() {
        return this.groupName;
    }

    @Nullable
    public final ImageModel component21() {
        return this.groupAvatar;
    }

    public final boolean component22() {
        return this.redDot;
    }

    public final boolean component23() {
        return this.notDisturb;
    }

    public final long component24() {
        return this.refreshSessionLiveStatusTime;
    }

    @Nullable
    public final String component25() {
        return this.sourceDesc;
    }

    @Nullable
    public final String component26() {
        return this.templateMsgId;
    }

    @Nullable
    public final ImageModel component27() {
        return this.officialAccountIcon;
    }

    @Nullable
    public final Integer component3() {
        return this.countdown;
    }

    public final int component4() {
        return this.unread;
    }

    @Nullable
    public final User component5() {
        return this.sender;
    }

    @Nullable
    public final Boolean component6() {
        return this.temp;
    }

    @Nullable
    public final Long component7() {
        return this.lastMessageTimeMillis;
    }

    @Nullable
    public final String component8() {
        return this.lastMessage;
    }

    @NotNull
    public final String component9() {
        return this.type;
    }

    @NotNull
    public final InboxSessionModel copy(@NotNull String itemId, @Nullable Long l10, @Nullable Integer num, int i10, @Nullable User user, @Nullable Boolean bool, @Nullable Long l11, @Nullable String str, @NotNull String type, @Nullable String str2, boolean z10, @Nullable VisitorInfoModel visitorInfoModel, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Integer num2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z11, @Nullable String str6, @Nullable ImageModel imageModel, boolean z12, boolean z13, long j10, @Nullable String str7, @Nullable String str8, @Nullable ImageModel imageModel2) {
        s.i(itemId, "itemId");
        s.i(type, "type");
        return new InboxSessionModel(itemId, l10, num, i10, user, bool, l11, str, type, str2, z10, visitorInfoModel, bool2, bool3, num2, str3, str4, str5, z11, str6, imageModel, z12, z13, j10, str7, str8, imageModel2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InboxSessionModel)) {
            return false;
        }
        InboxSessionModel inboxSessionModel = (InboxSessionModel) obj;
        return s.d(this.itemId, inboxSessionModel.itemId) && s.d(this.updateTimeMillis, inboxSessionModel.updateTimeMillis) && s.d(this.countdown, inboxSessionModel.countdown) && this.unread == inboxSessionModel.unread && s.d(this.sender, inboxSessionModel.sender) && s.d(this.temp, inboxSessionModel.temp) && s.d(this.lastMessageTimeMillis, inboxSessionModel.lastMessageTimeMillis) && s.d(this.lastMessage, inboxSessionModel.lastMessage) && s.d(this.type, inboxSessionModel.type) && s.d(this.url, inboxSessionModel.url) && this.exposure == inboxSessionModel.exposure && s.d(this.visitorInfo, inboxSessionModel.visitorInfo) && s.d(this.stealthMessage, inboxSessionModel.stealthMessage) && s.d(this.chatStatusDot, inboxSessionModel.chatStatusDot) && s.d(this.maskRemainSec, inboxSessionModel.maskRemainSec) && s.d(this.liveShowId, inboxSessionModel.liveShowId) && s.d(this.marketingUrl, inboxSessionModel.marketingUrl) && s.d(this.trackName, inboxSessionModel.trackName) && this.marketingDot == inboxSessionModel.marketingDot && s.d(this.groupName, inboxSessionModel.groupName) && s.d(this.groupAvatar, inboxSessionModel.groupAvatar) && this.redDot == inboxSessionModel.redDot && this.notDisturb == inboxSessionModel.notDisturb && this.refreshSessionLiveStatusTime == inboxSessionModel.refreshSessionLiveStatusTime && s.d(this.sourceDesc, inboxSessionModel.sourceDesc) && s.d(this.templateMsgId, inboxSessionModel.templateMsgId) && s.d(this.officialAccountIcon, inboxSessionModel.officialAccountIcon);
    }

    @Nullable
    public final Boolean getChatStatusDot() {
        return this.chatStatusDot;
    }

    @Nullable
    public final Integer getCountdown() {
        return this.countdown;
    }

    public final boolean getExposure() {
        return this.exposure;
    }

    @Nullable
    public final ImageModel getGroupAvatar() {
        return this.groupAvatar;
    }

    @Nullable
    public final String getGroupName() {
        return this.groupName;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getLastMessage() {
        return this.lastMessage;
    }

    @Nullable
    public final Long getLastMessageTimeMillis() {
        return this.lastMessageTimeMillis;
    }

    @Nullable
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public final boolean getMarketingDot() {
        return this.marketingDot;
    }

    @Nullable
    public final String getMarketingUrl() {
        return this.marketingUrl;
    }

    @Nullable
    public final Integer getMaskRemainSec() {
        return this.maskRemainSec;
    }

    public final boolean getNotDisturb() {
        return this.notDisturb;
    }

    @Nullable
    public final ImageModel getOfficialAccountIcon() {
        return this.officialAccountIcon;
    }

    public final boolean getRedDot() {
        return this.redDot;
    }

    public final long getRefreshSessionLiveStatusTime() {
        return this.refreshSessionLiveStatusTime;
    }

    @Nullable
    public final User getSender() {
        return this.sender;
    }

    @Nullable
    public final String getSourceDesc() {
        return this.sourceDesc;
    }

    @Nullable
    public final Boolean getStealthMessage() {
        return this.stealthMessage;
    }

    @Nullable
    public final Boolean getTemp() {
        return this.temp;
    }

    @Nullable
    public final String getTemplateMsgId() {
        return this.templateMsgId;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final int getUnread() {
        return this.unread;
    }

    @Nullable
    public final Long getUpdateTimeMillis() {
        return this.updateTimeMillis;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final VisitorInfoModel getVisitorInfo() {
        return this.visitorInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.itemId.hashCode() * 31;
        Long l10 = this.updateTimeMillis;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num = this.countdown;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.unread) * 31;
        User user = this.sender;
        int hashCode4 = (hashCode3 + (user == null ? 0 : user.hashCode())) * 31;
        Boolean bool = this.temp;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l11 = this.lastMessageTimeMillis;
        int hashCode6 = (hashCode5 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.lastMessage;
        int hashCode7 = (((hashCode6 + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31;
        String str2 = this.url;
        int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z10 = this.exposure;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode8 + i10) * 31;
        VisitorInfoModel visitorInfoModel = this.visitorInfo;
        int hashCode9 = (i11 + (visitorInfoModel == null ? 0 : visitorInfoModel.hashCode())) * 31;
        Boolean bool2 = this.stealthMessage;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.chatStatusDot;
        int hashCode11 = (hashCode10 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num2 = this.maskRemainSec;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.liveShowId;
        int hashCode13 = (hashCode12 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.marketingUrl;
        int hashCode14 = (hashCode13 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.trackName;
        int hashCode15 = (hashCode14 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z11 = this.marketingDot;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (hashCode15 + i12) * 31;
        String str6 = this.groupName;
        int hashCode16 = (i13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ImageModel imageModel = this.groupAvatar;
        int hashCode17 = (hashCode16 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        boolean z12 = this.redDot;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (hashCode17 + i14) * 31;
        boolean z13 = this.notDisturb;
        int a10 = (((i15 + (z13 ? 1 : z13 ? 1 : 0)) * 31) + a.a(this.refreshSessionLiveStatusTime)) * 31;
        String str7 = this.sourceDesc;
        int hashCode18 = (a10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.templateMsgId;
        int hashCode19 = (hashCode18 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ImageModel imageModel2 = this.officialAccountIcon;
        return hashCode19 + (imageModel2 != null ? imageModel2.hashCode() : 0);
    }

    public final boolean inLiveShow() {
        String str = this.liveShowId;
        return !(str == null || str.length() == 0);
    }

    public final boolean isLimitSendMsg() {
        Integer num = this.countdown;
        return (num != null ? num.intValue() : 0) > 0;
    }

    public final void setCountdown(@Nullable Integer num) {
        this.countdown = num;
    }

    public final void setExposure(boolean z10) {
        this.exposure = z10;
    }

    public final void setLiveShowId(@Nullable String str) {
        this.liveShowId = str;
    }

    public final void setMaskRemainSec(@Nullable Integer num) {
        this.maskRemainSec = num;
    }

    public final void setRefreshSessionLiveStatusTime(long j10) {
        this.refreshSessionLiveStatusTime = j10;
    }

    public final void setStealthMessage(@Nullable Boolean bool) {
        this.stealthMessage = bool;
    }

    public final void setUnread(int i10) {
        this.unread = i10;
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        Long l10 = this.updateTimeMillis;
        Integer num = this.countdown;
        int i10 = this.unread;
        User user = this.sender;
        Boolean bool = this.temp;
        Long l11 = this.lastMessageTimeMillis;
        String str2 = this.lastMessage;
        String str3 = this.type;
        String str4 = this.url;
        boolean z10 = this.exposure;
        VisitorInfoModel visitorInfoModel = this.visitorInfo;
        Boolean bool2 = this.stealthMessage;
        Boolean bool3 = this.chatStatusDot;
        Integer num2 = this.maskRemainSec;
        String str5 = this.liveShowId;
        String str6 = this.marketingUrl;
        String str7 = this.trackName;
        boolean z11 = this.marketingDot;
        String str8 = this.groupName;
        ImageModel imageModel = this.groupAvatar;
        return "InboxSessionModel(itemId=" + str + ", updateTimeMillis=" + ((Object) l10) + ", countdown=" + ((Object) num) + ", unread=" + i10 + ", sender=" + ((Object) user) + ", temp=" + ((Object) bool) + ", lastMessageTimeMillis=" + ((Object) l11) + ", lastMessage=" + str2 + ", type=" + str3 + ", url=" + str4 + ", exposure=" + z10 + ", visitorInfo=" + ((Object) visitorInfoModel) + ", stealthMessage=" + ((Object) bool2) + ", chatStatusDot=" + ((Object) bool3) + ", maskRemainSec=" + ((Object) num2) + ", liveShowId=" + str5 + ", marketingUrl=" + str6 + ", trackName=" + str7 + ", marketingDot=" + z11 + ", groupName=" + str8 + ", groupAvatar=" + ((Object) imageModel) + ", redDot=" + this.redDot + ", notDisturb=" + this.notDisturb + ", refreshSessionLiveStatusTime=" + this.refreshSessionLiveStatusTime + ", sourceDesc=" + this.sourceDesc + ", templateMsgId=" + this.templateMsgId + ", officialAccountIcon=" + ((Object) this.officialAccountIcon) + ")";
    }

    public /* synthetic */ InboxSessionModel(String str, Long l10, Integer num, int i10, User user, Boolean bool, Long l11, String str2, String str3, String str4, boolean z10, VisitorInfoModel visitorInfoModel, Boolean bool2, Boolean bool3, Integer num2, String str5, String str6, String str7, boolean z11, String str8, ImageModel imageModel, boolean z12, boolean z13, long j10, String str9, String str10, ImageModel imageModel2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l10, num, (i11 & 8) != 0 ? 0 : i10, user, (i11 & 32) != 0 ? null : bool, (i11 & 64) != 0 ? null : l11, (i11 & 128) != 0 ? null : str2, str3, (i11 & 512) != 0 ? null : str4, (i11 & 1024) != 0 ? false : z10, (i11 & 2048) != 0 ? null : visitorInfoModel, (i11 & 4096) != 0 ? null : bool2, (i11 & 8192) != 0 ? null : bool3, (i11 & 16384) != 0 ? null : num2, (32768 & i11) != 0 ? null : str5, (65536 & i11) != 0 ? null : str6, (131072 & i11) != 0 ? null : str7, (262144 & i11) != 0 ? false : z11, str8, imageModel, z12, z13, (i11 & 8388608) != 0 ? 0L : j10, str9, str10, imageModel2);
    }
}
