package com.cupidapp.live.club.model;

import b2.a;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.chat2.model.ChatNoticeBtnType;
import com.cupidapp.live.chat2.model.MessageSendState;
import com.cupidapp.live.maskparty.activity.ChatLookImageData;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubChatMsgModel {

    @Nullable
    private final Boolean addList;

    @Nullable
    private final ImageModel bgImage;

    @Nullable
    private final String bottomMsg;

    @Nullable
    private final String cancelMsgText;
    private final long createTimeMillis;

    @Nullable
    private final String desc;

    @Nullable
    private final ImageModel giftIcon;

    @Nullable
    private final ImageModel image;

    @Nullable
    private String imagePath;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final ImageModel medalIcon;

    @Nullable
    private final ImageModel medalLevel;

    @Nullable
    private String messageId;

    @Nullable
    private MessageSendState messageSendState;
    private final boolean mine;

    @Nullable
    private final ChatNoticeBtnType noticeBtnType;

    @Nullable
    private final QuoteInfoModel quoteInfo;

    @Nullable
    private final String redPacketId;

    @Nullable
    private final String reportData;

    @Nullable
    private User sender;

    @Nullable
    private Integer status;

    @Nullable
    private final String text;

    @Nullable
    private final String title;

    @NotNull
    private final String type;

    public ClubChatMsgModel(@Nullable String str, @NotNull String type, boolean z10, @Nullable User user, long j10, @Nullable MessageSendState messageSendState, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable String str4, @Nullable String str5, @Nullable ChatNoticeBtnType chatNoticeBtnType, @Nullable String str6, @Nullable Integer num, @Nullable ImageModel imageModel2, @Nullable String str7, @Nullable String str8, @Nullable ImageModel imageModel3, @Nullable String str9, @Nullable String str10, @Nullable QuoteInfoModel quoteInfoModel, @Nullable ImageModel imageModel4, @Nullable ImageModel imageModel5) {
        s.i(type, "type");
        this.messageId = str;
        this.type = type;
        this.mine = z10;
        this.sender = user;
        this.createTimeMillis = j10;
        this.messageSendState = messageSendState;
        this.reportData = str2;
        this.addList = bool;
        this.text = str3;
        this.image = imageModel;
        this.imagePath = str4;
        this.cancelMsgText = str5;
        this.noticeBtnType = chatNoticeBtnType;
        this.title = str6;
        this.status = num;
        this.giftIcon = imageModel2;
        this.bottomMsg = str7;
        this.redPacketId = str8;
        this.bgImage = imageModel3;
        this.desc = str9;
        this.jumpUrl = str10;
        this.quoteInfo = quoteInfoModel;
        this.medalIcon = imageModel4;
        this.medalLevel = imageModel5;
    }

    @NotNull
    public final ChatLookImageData assembleChatLookImageData() {
        return new ChatLookImageData(this.image, this.imagePath, null);
    }

    @Nullable
    public final String component1() {
        return this.messageId;
    }

    @Nullable
    public final ImageModel component10() {
        return this.image;
    }

    @Nullable
    public final String component11() {
        return this.imagePath;
    }

    @Nullable
    public final String component12() {
        return this.cancelMsgText;
    }

    @Nullable
    public final ChatNoticeBtnType component13() {
        return this.noticeBtnType;
    }

    @Nullable
    public final String component14() {
        return this.title;
    }

    @Nullable
    public final Integer component15() {
        return this.status;
    }

    @Nullable
    public final ImageModel component16() {
        return this.giftIcon;
    }

    @Nullable
    public final String component17() {
        return this.bottomMsg;
    }

    @Nullable
    public final String component18() {
        return this.redPacketId;
    }

    @Nullable
    public final ImageModel component19() {
        return this.bgImage;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final String component20() {
        return this.desc;
    }

    @Nullable
    public final String component21() {
        return this.jumpUrl;
    }

    @Nullable
    public final QuoteInfoModel component22() {
        return this.quoteInfo;
    }

    @Nullable
    public final ImageModel component23() {
        return this.medalIcon;
    }

    @Nullable
    public final ImageModel component24() {
        return this.medalLevel;
    }

    public final boolean component3() {
        return this.mine;
    }

    @Nullable
    public final User component4() {
        return this.sender;
    }

    public final long component5() {
        return this.createTimeMillis;
    }

    @Nullable
    public final MessageSendState component6() {
        return this.messageSendState;
    }

    @Nullable
    public final String component7() {
        return this.reportData;
    }

    @Nullable
    public final Boolean component8() {
        return this.addList;
    }

    @Nullable
    public final String component9() {
        return this.text;
    }

    @NotNull
    public final ClubChatMsgModel copy(@Nullable String str, @NotNull String type, boolean z10, @Nullable User user, long j10, @Nullable MessageSendState messageSendState, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable ImageModel imageModel, @Nullable String str4, @Nullable String str5, @Nullable ChatNoticeBtnType chatNoticeBtnType, @Nullable String str6, @Nullable Integer num, @Nullable ImageModel imageModel2, @Nullable String str7, @Nullable String str8, @Nullable ImageModel imageModel3, @Nullable String str9, @Nullable String str10, @Nullable QuoteInfoModel quoteInfoModel, @Nullable ImageModel imageModel4, @Nullable ImageModel imageModel5) {
        s.i(type, "type");
        return new ClubChatMsgModel(str, type, z10, user, j10, messageSendState, str2, bool, str3, imageModel, str4, str5, chatNoticeBtnType, str6, num, imageModel2, str7, str8, imageModel3, str9, str10, quoteInfoModel, imageModel4, imageModel5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubChatMsgModel)) {
            return false;
        }
        ClubChatMsgModel clubChatMsgModel = (ClubChatMsgModel) obj;
        return s.d(this.messageId, clubChatMsgModel.messageId) && s.d(this.type, clubChatMsgModel.type) && this.mine == clubChatMsgModel.mine && s.d(this.sender, clubChatMsgModel.sender) && this.createTimeMillis == clubChatMsgModel.createTimeMillis && this.messageSendState == clubChatMsgModel.messageSendState && s.d(this.reportData, clubChatMsgModel.reportData) && s.d(this.addList, clubChatMsgModel.addList) && s.d(this.text, clubChatMsgModel.text) && s.d(this.image, clubChatMsgModel.image) && s.d(this.imagePath, clubChatMsgModel.imagePath) && s.d(this.cancelMsgText, clubChatMsgModel.cancelMsgText) && this.noticeBtnType == clubChatMsgModel.noticeBtnType && s.d(this.title, clubChatMsgModel.title) && s.d(this.status, clubChatMsgModel.status) && s.d(this.giftIcon, clubChatMsgModel.giftIcon) && s.d(this.bottomMsg, clubChatMsgModel.bottomMsg) && s.d(this.redPacketId, clubChatMsgModel.redPacketId) && s.d(this.bgImage, clubChatMsgModel.bgImage) && s.d(this.desc, clubChatMsgModel.desc) && s.d(this.jumpUrl, clubChatMsgModel.jumpUrl) && s.d(this.quoteInfo, clubChatMsgModel.quoteInfo) && s.d(this.medalIcon, clubChatMsgModel.medalIcon) && s.d(this.medalLevel, clubChatMsgModel.medalLevel);
    }

    @Nullable
    public final Boolean getAddList() {
        return this.addList;
    }

    @Nullable
    public final ImageModel getBgImage() {
        return this.bgImage;
    }

    @Nullable
    public final String getBottomMsg() {
        return this.bottomMsg;
    }

    @Nullable
    public final String getCancelMsgText() {
        return this.cancelMsgText;
    }

    public final long getCreateTimeMillis() {
        return this.createTimeMillis;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getEditInputQuoteText() {
        String str;
        String str2 = this.type;
        if (s.d(str2, ClubChatMessageType.InboxMessageText.getValue())) {
            str = this.text;
        } else if (s.d(str2, ClubChatMessageType.InboxMessageImage.getValue())) {
            str = "[图片消息]";
        } else {
            if (!s.d(str2, ClubChatMessageType.InboxMessageActivity.getValue())) {
                return "";
            }
            String str3 = this.desc;
            if (str3 == null || str3.length() == 0) {
                str = "[活动消息]";
            } else {
                str = "[" + this.desc + "]";
            }
        }
        User user = this.sender;
        return (user != null ? user.getName() : null) + "：" + str;
    }

    @Nullable
    public final ImageModel getGiftIcon() {
        return this.giftIcon;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getImagePath() {
        return this.imagePath;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final ImageModel getMedalIcon() {
        return this.medalIcon;
    }

    @Nullable
    public final ImageModel getMedalLevel() {
        return this.medalLevel;
    }

    @Nullable
    public final String getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final MessageSendState getMessageSendState() {
        return this.messageSendState;
    }

    public final boolean getMine() {
        return this.mine;
    }

    @Nullable
    public final String getMsgListQuoteText() {
        String str = this.type;
        if (s.d(str, ClubChatMessageType.InboxMessageText.getValue())) {
            return this.text;
        }
        if (!s.d(str, ClubChatMessageType.InboxMessageActivity.getValue())) {
            return null;
        }
        String str2 = this.desc;
        if (str2 == null || str2.length() == 0) {
            return "[活动消息]";
        }
        return "[" + this.desc + "]";
    }

    @Nullable
    public final ChatNoticeBtnType getNoticeBtnType() {
        return this.noticeBtnType;
    }

    @Nullable
    public final QuoteInfoModel getQuoteInfo() {
        return this.quoteInfo;
    }

    @Nullable
    public final String getRedPacketId() {
        return this.redPacketId;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final User getSender() {
        return this.sender;
    }

    @Nullable
    public final Integer getStatus() {
        return this.status;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final boolean hasSender() {
        return this.sender != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.messageId;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.type.hashCode()) * 31;
        boolean z10 = this.mine;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        User user = this.sender;
        int hashCode2 = (((i11 + (user == null ? 0 : user.hashCode())) * 31) + a.a(this.createTimeMillis)) * 31;
        MessageSendState messageSendState = this.messageSendState;
        int hashCode3 = (hashCode2 + (messageSendState == null ? 0 : messageSendState.hashCode())) * 31;
        String str2 = this.reportData;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.addList;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.text;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ImageModel imageModel = this.image;
        int hashCode7 = (hashCode6 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str4 = this.imagePath;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cancelMsgText;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ChatNoticeBtnType chatNoticeBtnType = this.noticeBtnType;
        int hashCode10 = (hashCode9 + (chatNoticeBtnType == null ? 0 : chatNoticeBtnType.hashCode())) * 31;
        String str6 = this.title;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.status;
        int hashCode12 = (hashCode11 + (num == null ? 0 : num.hashCode())) * 31;
        ImageModel imageModel2 = this.giftIcon;
        int hashCode13 = (hashCode12 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str7 = this.bottomMsg;
        int hashCode14 = (hashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.redPacketId;
        int hashCode15 = (hashCode14 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ImageModel imageModel3 = this.bgImage;
        int hashCode16 = (hashCode15 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        String str9 = this.desc;
        int hashCode17 = (hashCode16 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.jumpUrl;
        int hashCode18 = (hashCode17 + (str10 == null ? 0 : str10.hashCode())) * 31;
        QuoteInfoModel quoteInfoModel = this.quoteInfo;
        int hashCode19 = (hashCode18 + (quoteInfoModel == null ? 0 : quoteInfoModel.hashCode())) * 31;
        ImageModel imageModel4 = this.medalIcon;
        int hashCode20 = (hashCode19 + (imageModel4 == null ? 0 : imageModel4.hashCode())) * 31;
        ImageModel imageModel5 = this.medalLevel;
        return hashCode20 + (imageModel5 != null ? imageModel5.hashCode() : 0);
    }

    public final boolean less2Min() {
        return System.currentTimeMillis() - this.createTimeMillis < 120000;
    }

    public final void setImagePath(@Nullable String str) {
        this.imagePath = str;
    }

    public final void setMessageId(@Nullable String str) {
        this.messageId = str;
    }

    public final void setMessageSendState(@Nullable MessageSendState messageSendState) {
        this.messageSendState = messageSendState;
    }

    public final void setSender(@Nullable User user) {
        this.sender = user;
    }

    public final void setStatus(@Nullable Integer num) {
        this.status = num;
    }

    @NotNull
    public String toString() {
        String str = this.messageId;
        String str2 = this.type;
        boolean z10 = this.mine;
        User user = this.sender;
        long j10 = this.createTimeMillis;
        MessageSendState messageSendState = this.messageSendState;
        String str3 = this.reportData;
        Boolean bool = this.addList;
        String str4 = this.text;
        ImageModel imageModel = this.image;
        String str5 = this.imagePath;
        String str6 = this.cancelMsgText;
        ChatNoticeBtnType chatNoticeBtnType = this.noticeBtnType;
        String str7 = this.title;
        Integer num = this.status;
        ImageModel imageModel2 = this.giftIcon;
        String str8 = this.bottomMsg;
        String str9 = this.redPacketId;
        ImageModel imageModel3 = this.bgImage;
        return "ClubChatMsgModel(messageId=" + str + ", type=" + str2 + ", mine=" + z10 + ", sender=" + ((Object) user) + ", createTimeMillis=" + j10 + ", messageSendState=" + ((Object) messageSendState) + ", reportData=" + str3 + ", addList=" + ((Object) bool) + ", text=" + str4 + ", image=" + ((Object) imageModel) + ", imagePath=" + str5 + ", cancelMsgText=" + str6 + ", noticeBtnType=" + ((Object) chatNoticeBtnType) + ", title=" + str7 + ", status=" + ((Object) num) + ", giftIcon=" + ((Object) imageModel2) + ", bottomMsg=" + str8 + ", redPacketId=" + str9 + ", bgImage=" + ((Object) imageModel3) + ", desc=" + this.desc + ", jumpUrl=" + this.jumpUrl + ", quoteInfo=" + ((Object) this.quoteInfo) + ", medalIcon=" + ((Object) this.medalIcon) + ", medalLevel=" + ((Object) this.medalLevel) + ")";
    }

    public /* synthetic */ ClubChatMsgModel(String str, String str2, boolean z10, User user, long j10, MessageSendState messageSendState, String str3, Boolean bool, String str4, ImageModel imageModel, String str5, String str6, ChatNoticeBtnType chatNoticeBtnType, String str7, Integer num, ImageModel imageModel2, String str8, String str9, ImageModel imageModel3, String str10, String str11, QuoteInfoModel quoteInfoModel, ImageModel imageModel4, ImageModel imageModel5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, str2, z10, (i10 & 8) != 0 ? null : user, j10, (i10 & 32) != 0 ? null : messageSendState, (i10 & 64) != 0 ? null : str3, (i10 & 128) != 0 ? null : bool, (i10 & 256) != 0 ? null : str4, (i10 & 512) != 0 ? null : imageModel, (i10 & 1024) != 0 ? null : str5, (i10 & 2048) != 0 ? null : str6, (i10 & 4096) != 0 ? null : chatNoticeBtnType, (i10 & 8192) != 0 ? null : str7, (i10 & 16384) != 0 ? null : num, (32768 & i10) != 0 ? null : imageModel2, (65536 & i10) != 0 ? null : str8, (131072 & i10) != 0 ? null : str9, (262144 & i10) != 0 ? null : imageModel3, (524288 & i10) != 0 ? null : str10, (1048576 & i10) != 0 ? null : str11, (2097152 & i10) != 0 ? null : quoteInfoModel, (4194304 & i10) != 0 ? null : imageModel4, (i10 & 8388608) != 0 ? null : imageModel5);
    }
}
