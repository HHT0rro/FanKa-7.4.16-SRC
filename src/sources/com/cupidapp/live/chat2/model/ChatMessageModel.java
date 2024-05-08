package com.cupidapp.live.chat2.model;

import android.content.Context;
import android.os.CountDownTimer;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ImageSizeConstants;
import com.cupidapp.live.base.network.model.LinkDictModel;
import com.cupidapp.live.chat.model.MessagePostModel;
import com.cupidapp.live.feed.model.PostLimitDetailModel;
import com.cupidapp.live.maskparty.activity.ChatLookImageData;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatMessageModel implements Serializable {

    @Nullable
    private final String angleText;

    @Nullable
    private Integer countdownLeftSeconds;

    @Nullable
    private final Integer countdownSeconds;
    private final long createTimeMillis;

    @Nullable
    private final String description;

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final ImageModel imageLarge;

    @Nullable
    private String imagePath;

    @Nullable
    private final ImageModel imageThumb;

    @Nullable
    private final String itemId;

    @Nullable
    private Function1<? super Float, p> mProgressCallback;

    @Nullable
    private CountDownTimer mTimer;

    @Nullable
    private final LinkDictModel marketingLinkDict;

    @Nullable
    private MessageSendState messageSendState;
    private final boolean mine;

    @Nullable
    private final List<MiniTitleModel> miniTitleList;

    @Nullable
    private final String notice;

    @Nullable
    private final ChatNoticeBtnType noticeBtnType;

    @Nullable
    private String password;

    @Nullable
    private final MessagePostModel post;

    @Nullable
    private final PostLimitDetailModel postLimit;

    @Nullable
    private Boolean receiverUnread;

    @Nullable
    private final String reportData;

    @Nullable
    private final User sender;

    @Nullable
    private final String templateType;

    @Nullable
    private final String text;

    @Nullable
    private final Integer textType;

    @Nullable
    private final String title;

    @NotNull
    private final String type;

    @Nullable
    private Boolean unread;

    @Nullable
    private final String url;

    @Nullable
    private final User user;

    /* compiled from: ChatMessageModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f13409a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatMessageModel f13410b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref$LongRef f13411c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f13412d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, long j11, ChatMessageModel chatMessageModel, Ref$LongRef ref$LongRef, long j12) {
            super(j10, j11);
            this.f13409a = j11;
            this.f13410b = chatMessageModel;
            this.f13411c = ref$LongRef;
            this.f13412d = j12;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f13410b.setCountdownLeftSeconds(0);
            Function1<Float, p> mProgressCallback = this.f13410b.getMProgressCallback();
            if (mProgressCallback != null) {
                mProgressCallback.invoke(Float.valueOf(0.0f));
            }
            EventBus.c().o(new ChatSnapImgMessageDestroyEvent());
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            Ref$LongRef ref$LongRef = this.f13411c;
            long j11 = ref$LongRef.element + this.f13409a;
            ref$LongRef.element = j11;
            if (j11 % 1000 == 0) {
                ChatMessageModel chatMessageModel = this.f13410b;
                s.f(chatMessageModel.getCountdownLeftSeconds());
                chatMessageModel.setCountdownLeftSeconds(Integer.valueOf(r1.intValue() - 1));
            }
            Function1<Float, p> mProgressCallback = this.f13410b.getMProgressCallback();
            if (mProgressCallback != null) {
                mProgressCallback.invoke(Float.valueOf(((float) j10) / ((float) this.f13412d)));
            }
        }
    }

    public ChatMessageModel(@Nullable String str, @NotNull String type, @Nullable Boolean bool, boolean z10, @Nullable User user, @Nullable User user2, long j10, @Nullable Boolean bool2, @Nullable MessageSendState messageSendState, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str4, @Nullable String str5, @Nullable Integer num2, @Nullable Integer num3, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable String str6, @Nullable ChatNoticeBtnType chatNoticeBtnType, @Nullable MessagePostModel messagePostModel, @Nullable String str7, @Nullable ImageModel imageModel4, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable List<MiniTitleModel> list, @Nullable PostLimitDetailModel postLimitDetailModel, @Nullable LinkDictModel linkDictModel) {
        s.i(type, "type");
        this.itemId = str;
        this.type = type;
        this.unread = bool;
        this.mine = z10;
        this.sender = user;
        this.user = user2;
        this.createTimeMillis = j10;
        this.receiverUnread = bool2;
        this.messageSendState = messageSendState;
        this.reportData = str2;
        this.text = str3;
        this.textType = num;
        this.image = imageModel;
        this.imagePath = str4;
        this.password = str5;
        this.countdownLeftSeconds = num2;
        this.countdownSeconds = num3;
        this.imageThumb = imageModel2;
        this.imageLarge = imageModel3;
        this.notice = str6;
        this.noticeBtnType = chatNoticeBtnType;
        this.post = messagePostModel;
        this.title = str7;
        this.icon = imageModel4;
        this.description = str8;
        this.url = str9;
        this.angleText = str10;
        this.templateType = str11;
        this.miniTitleList = list;
        this.postLimit = postLimitDetailModel;
        this.marketingLinkDict = linkDictModel;
    }

    private final ImageModel component18() {
        return this.imageThumb;
    }

    private final ImageModel component19() {
        return this.imageLarge;
    }

    @NotNull
    public final ChatLookImageData assembleChatLookImageData() {
        return new ChatLookImageData(this.image, this.imagePath, s.d(this.type, ChatMessageType.InboxMessageSnapImage.getValue()) ? getSnapImageLargeUrl() : null);
    }

    @Nullable
    public final String component1() {
        return this.itemId;
    }

    @Nullable
    public final String component10() {
        return this.reportData;
    }

    @Nullable
    public final String component11() {
        return this.text;
    }

    @Nullable
    public final Integer component12() {
        return this.textType;
    }

    @Nullable
    public final ImageModel component13() {
        return this.image;
    }

    @Nullable
    public final String component14() {
        return this.imagePath;
    }

    @Nullable
    public final String component15() {
        return this.password;
    }

    @Nullable
    public final Integer component16() {
        return this.countdownLeftSeconds;
    }

    @Nullable
    public final Integer component17() {
        return this.countdownSeconds;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @Nullable
    public final String component20() {
        return this.notice;
    }

    @Nullable
    public final ChatNoticeBtnType component21() {
        return this.noticeBtnType;
    }

    @Nullable
    public final MessagePostModel component22() {
        return this.post;
    }

    @Nullable
    public final String component23() {
        return this.title;
    }

    @Nullable
    public final ImageModel component24() {
        return this.icon;
    }

    @Nullable
    public final String component25() {
        return this.description;
    }

    @Nullable
    public final String component26() {
        return this.url;
    }

    @Nullable
    public final String component27() {
        return this.angleText;
    }

    @Nullable
    public final String component28() {
        return this.templateType;
    }

    @Nullable
    public final List<MiniTitleModel> component29() {
        return this.miniTitleList;
    }

    @Nullable
    public final Boolean component3() {
        return this.unread;
    }

    @Nullable
    public final PostLimitDetailModel component30() {
        return this.postLimit;
    }

    @Nullable
    public final LinkDictModel component31() {
        return this.marketingLinkDict;
    }

    public final boolean component4() {
        return this.mine;
    }

    @Nullable
    public final User component5() {
        return this.sender;
    }

    @Nullable
    public final User component6() {
        return this.user;
    }

    public final long component7() {
        return this.createTimeMillis;
    }

    @Nullable
    public final Boolean component8() {
        return this.receiverUnread;
    }

    @Nullable
    public final MessageSendState component9() {
        return this.messageSendState;
    }

    @NotNull
    public final ChatMessageModel copy(@Nullable String str, @NotNull String type, @Nullable Boolean bool, boolean z10, @Nullable User user, @Nullable User user2, long j10, @Nullable Boolean bool2, @Nullable MessageSendState messageSendState, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str4, @Nullable String str5, @Nullable Integer num2, @Nullable Integer num3, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable String str6, @Nullable ChatNoticeBtnType chatNoticeBtnType, @Nullable MessagePostModel messagePostModel, @Nullable String str7, @Nullable ImageModel imageModel4, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable List<MiniTitleModel> list, @Nullable PostLimitDetailModel postLimitDetailModel, @Nullable LinkDictModel linkDictModel) {
        s.i(type, "type");
        return new ChatMessageModel(str, type, bool, z10, user, user2, j10, bool2, messageSendState, str2, str3, num, imageModel, str4, str5, num2, num3, imageModel2, imageModel3, str6, chatNoticeBtnType, messagePostModel, str7, imageModel4, str8, str9, str10, str11, list, postLimitDetailModel, linkDictModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessageModel)) {
            return false;
        }
        ChatMessageModel chatMessageModel = (ChatMessageModel) obj;
        return s.d(this.itemId, chatMessageModel.itemId) && s.d(this.type, chatMessageModel.type) && s.d(this.unread, chatMessageModel.unread) && this.mine == chatMessageModel.mine && s.d(this.sender, chatMessageModel.sender) && s.d(this.user, chatMessageModel.user) && this.createTimeMillis == chatMessageModel.createTimeMillis && s.d(this.receiverUnread, chatMessageModel.receiverUnread) && this.messageSendState == chatMessageModel.messageSendState && s.d(this.reportData, chatMessageModel.reportData) && s.d(this.text, chatMessageModel.text) && s.d(this.textType, chatMessageModel.textType) && s.d(this.image, chatMessageModel.image) && s.d(this.imagePath, chatMessageModel.imagePath) && s.d(this.password, chatMessageModel.password) && s.d(this.countdownLeftSeconds, chatMessageModel.countdownLeftSeconds) && s.d(this.countdownSeconds, chatMessageModel.countdownSeconds) && s.d(this.imageThumb, chatMessageModel.imageThumb) && s.d(this.imageLarge, chatMessageModel.imageLarge) && s.d(this.notice, chatMessageModel.notice) && this.noticeBtnType == chatMessageModel.noticeBtnType && s.d(this.post, chatMessageModel.post) && s.d(this.title, chatMessageModel.title) && s.d(this.icon, chatMessageModel.icon) && s.d(this.description, chatMessageModel.description) && s.d(this.url, chatMessageModel.url) && s.d(this.angleText, chatMessageModel.angleText) && s.d(this.templateType, chatMessageModel.templateType) && s.d(this.miniTitleList, chatMessageModel.miniTitleList) && s.d(this.postLimit, chatMessageModel.postLimit) && s.d(this.marketingLinkDict, chatMessageModel.marketingLinkDict);
    }

    @Nullable
    public final String getAngleText() {
        return this.angleText;
    }

    @Nullable
    public final String getCompletePassword(@NotNull Context context) {
        s.i(context, "context");
        String str = this.password;
        if (str == null || str.length() == 0) {
            return null;
        }
        String string = context.getString(R$string.lalala);
        String str2 = this.password;
        s.f(str2);
        String substring = str2.substring(8);
        s.h(substring, "this as java.lang.String).substring(startIndex)");
        return string + substring;
    }

    @Nullable
    public final Integer getCountdownLeftSeconds() {
        return this.countdownLeftSeconds;
    }

    @Nullable
    public final Integer getCountdownSeconds() {
        return this.countdownSeconds;
    }

    public final long getCreateTimeMillis() {
        return this.createTimeMillis;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
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
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final Function1<Float, p> getMProgressCallback() {
        return this.mProgressCallback;
    }

    @Nullable
    public final LinkDictModel getMarketingLinkDict() {
        return this.marketingLinkDict;
    }

    @Nullable
    public final MessageSendState getMessageSendState() {
        return this.messageSendState;
    }

    public final boolean getMine() {
        return this.mine;
    }

    @Nullable
    public final List<MiniTitleModel> getMiniTitleList() {
        return this.miniTitleList;
    }

    @Nullable
    public final String getNotice() {
        return this.notice;
    }

    @Nullable
    public final ChatNoticeBtnType getNoticeBtnType() {
        return this.noticeBtnType;
    }

    @Nullable
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    public final MessagePostModel getPost() {
        return this.post;
    }

    @Nullable
    public final PostLimitDetailModel getPostLimit() {
        return this.postLimit;
    }

    @Nullable
    public final Boolean getReceiverUnread() {
        return this.receiverUnread;
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
    public final String getSnapImageLargeUrl() {
        ImageModel imageModel = this.imageLarge;
        if (imageModel == null) {
            return null;
        }
        return imageModel.getUrlPatternWidth();
    }

    @Nullable
    public final String getSnapImageThumbUrl() {
        ImageModel imageModel = this.imageThumb;
        if (imageModel == null) {
            return null;
        }
        ImageSizeConstants imageSizeConstants = ImageSizeConstants.SQUARE_TINNY_SIZE;
        String urlPatternWidth = imageModel.getUrlPatternWidth();
        if (urlPatternWidth == null || urlPatternWidth.length() == 0) {
            return "https://api.finka.cn/v1/file/image?id=" + this.imageThumb.getImageId() + "&width=" + imageSizeConstants.getWidth();
        }
        int scaleHeightByWidth = this.imageThumb.getScaleHeightByWidth(imageSizeConstants.getWidth());
        String A = kotlin.text.p.A(urlPatternWidth, "%@", "%s", false, 4, null);
        y yVar = y.f51038a;
        String format = String.format(A, Arrays.copyOf(new Object[]{Integer.valueOf(imageSizeConstants.getWidth()), Integer.valueOf(scaleHeightByWidth)}, 2));
        s.h(format, "format(format, *args)");
        return format;
    }

    @Nullable
    public final String getTemplateType() {
        return this.templateType;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final Integer getTextType() {
        return this.textType;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Boolean getUnread() {
        return this.unread;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.itemId;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.type.hashCode()) * 31;
        Boolean bool = this.unread;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        boolean z10 = this.mine;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        User user = this.sender;
        int hashCode3 = (i11 + (user == null ? 0 : user.hashCode())) * 31;
        User user2 = this.user;
        int hashCode4 = (((hashCode3 + (user2 == null ? 0 : user2.hashCode())) * 31) + b2.a.a(this.createTimeMillis)) * 31;
        Boolean bool2 = this.receiverUnread;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        MessageSendState messageSendState = this.messageSendState;
        int hashCode6 = (hashCode5 + (messageSendState == null ? 0 : messageSendState.hashCode())) * 31;
        String str2 = this.reportData;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.text;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.textType;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        ImageModel imageModel = this.image;
        int hashCode10 = (hashCode9 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str4 = this.imagePath;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.password;
        int hashCode12 = (hashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.countdownLeftSeconds;
        int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.countdownSeconds;
        int hashCode14 = (hashCode13 + (num3 == null ? 0 : num3.hashCode())) * 31;
        ImageModel imageModel2 = this.imageThumb;
        int hashCode15 = (hashCode14 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        ImageModel imageModel3 = this.imageLarge;
        int hashCode16 = (hashCode15 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        String str6 = this.notice;
        int hashCode17 = (hashCode16 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ChatNoticeBtnType chatNoticeBtnType = this.noticeBtnType;
        int hashCode18 = (hashCode17 + (chatNoticeBtnType == null ? 0 : chatNoticeBtnType.hashCode())) * 31;
        MessagePostModel messagePostModel = this.post;
        int hashCode19 = (hashCode18 + (messagePostModel == null ? 0 : messagePostModel.hashCode())) * 31;
        String str7 = this.title;
        int hashCode20 = (hashCode19 + (str7 == null ? 0 : str7.hashCode())) * 31;
        ImageModel imageModel4 = this.icon;
        int hashCode21 = (hashCode20 + (imageModel4 == null ? 0 : imageModel4.hashCode())) * 31;
        String str8 = this.description;
        int hashCode22 = (hashCode21 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.url;
        int hashCode23 = (hashCode22 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.angleText;
        int hashCode24 = (hashCode23 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.templateType;
        int hashCode25 = (hashCode24 + (str11 == null ? 0 : str11.hashCode())) * 31;
        List<MiniTitleModel> list = this.miniTitleList;
        int hashCode26 = (hashCode25 + (list == null ? 0 : list.hashCode())) * 31;
        PostLimitDetailModel postLimitDetailModel = this.postLimit;
        int hashCode27 = (hashCode26 + (postLimitDetailModel == null ? 0 : postLimitDetailModel.hashCode())) * 31;
        LinkDictModel linkDictModel = this.marketingLinkDict;
        return hashCode27 + (linkDictModel != null ? linkDictModel.hashCode() : 0);
    }

    public final boolean isMineMsgShowSvga(boolean z10) {
        return s.d(this.type, ChatMessageType.InboxMessageText.getValue()) && this.mine && z10;
    }

    public final boolean isOtherMsgShowSvga() {
        return s.d(this.type, ChatMessageType.InboxMessageText.getValue()) && !this.mine && s.d(this.unread, Boolean.TRUE);
    }

    public final boolean isSnapMessage() {
        return s.d(this.type, ChatMessageType.InboxMessageSnapImage.getValue()) || s.d(this.type, ChatMessageType.InboxMessageSnapText.getValue());
    }

    public final boolean less2Min() {
        return System.currentTimeMillis() - this.createTimeMillis < 120000;
    }

    public final boolean passwordIsNullOrEmpty() {
        String str = this.password;
        return str == null || str.length() == 0;
    }

    public final void setCountdownLeftSeconds(@Nullable Integer num) {
        this.countdownLeftSeconds = num;
    }

    public final void setImagePath(@Nullable String str) {
        this.imagePath = str;
    }

    public final void setMProgressCallback(@Nullable Function1<? super Float, p> function1) {
        this.mProgressCallback = function1;
    }

    public final void setMessageSendState(@Nullable MessageSendState messageSendState) {
        this.messageSendState = messageSendState;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
    }

    public final void setReceiverUnread(@Nullable Boolean bool) {
        this.receiverUnread = bool;
    }

    public final void setUnread(@Nullable Boolean bool) {
        this.unread = bool;
    }

    public final boolean snapImgCountDownIsPause() {
        Integer num = this.countdownLeftSeconds;
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        Integer num2 = this.countdownSeconds;
        if (num2 != null) {
            return (1 <= intValue && intValue < num2.intValue()) && this.mTimer == null;
        }
        return false;
    }

    public final boolean snapImgCountDownIsRunning() {
        Integer num = this.countdownLeftSeconds;
        return num != null && (num == null || num.intValue() != 0) && this.mTimer != null;
    }

    public final void startSnapCountDown() {
        int intValue;
        Integer num = this.countdownLeftSeconds;
        if (this.mTimer != null || num == null || num.intValue() <= 0) {
            return;
        }
        long intValue2 = num.intValue() * 1000;
        Integer num2 = this.countdownSeconds;
        if (num2 != null && num2.intValue() >= num.intValue()) {
            intValue = this.countdownSeconds.intValue();
        } else {
            intValue = num.intValue();
        }
        this.mTimer = new a(intValue2, 50L, this, new Ref$LongRef(), intValue * 1000).start();
    }

    public final void stopSnapImgCountDown() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mTimer = null;
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        String str2 = this.type;
        Boolean bool = this.unread;
        boolean z10 = this.mine;
        User user = this.sender;
        User user2 = this.user;
        long j10 = this.createTimeMillis;
        Boolean bool2 = this.receiverUnread;
        MessageSendState messageSendState = this.messageSendState;
        String str3 = this.reportData;
        String str4 = this.text;
        Integer num = this.textType;
        ImageModel imageModel = this.image;
        String str5 = this.imagePath;
        String str6 = this.password;
        Integer num2 = this.countdownLeftSeconds;
        Integer num3 = this.countdownSeconds;
        ImageModel imageModel2 = this.imageThumb;
        ImageModel imageModel3 = this.imageLarge;
        String str7 = this.notice;
        ChatNoticeBtnType chatNoticeBtnType = this.noticeBtnType;
        MessagePostModel messagePostModel = this.post;
        String str8 = this.title;
        ImageModel imageModel4 = this.icon;
        return "ChatMessageModel(itemId=" + str + ", type=" + str2 + ", unread=" + ((Object) bool) + ", mine=" + z10 + ", sender=" + ((Object) user) + ", user=" + ((Object) user2) + ", createTimeMillis=" + j10 + ", receiverUnread=" + ((Object) bool2) + ", messageSendState=" + ((Object) messageSendState) + ", reportData=" + str3 + ", text=" + str4 + ", textType=" + ((Object) num) + ", image=" + ((Object) imageModel) + ", imagePath=" + str5 + ", password=" + str6 + ", countdownLeftSeconds=" + ((Object) num2) + ", countdownSeconds=" + ((Object) num3) + ", imageThumb=" + ((Object) imageModel2) + ", imageLarge=" + ((Object) imageModel3) + ", notice=" + str7 + ", noticeBtnType=" + ((Object) chatNoticeBtnType) + ", post=" + ((Object) messagePostModel) + ", title=" + str8 + ", icon=" + ((Object) imageModel4) + ", description=" + this.description + ", url=" + this.url + ", angleText=" + this.angleText + ", templateType=" + this.templateType + ", miniTitleList=" + ((Object) this.miniTitleList) + ", postLimit=" + ((Object) this.postLimit) + ", marketingLinkDict=" + ((Object) this.marketingLinkDict) + ")";
    }

    public /* synthetic */ ChatMessageModel(String str, String str2, Boolean bool, boolean z10, User user, User user2, long j10, Boolean bool2, MessageSendState messageSendState, String str3, String str4, Integer num, ImageModel imageModel, String str5, String str6, Integer num2, Integer num3, ImageModel imageModel2, ImageModel imageModel3, String str7, ChatNoticeBtnType chatNoticeBtnType, MessagePostModel messagePostModel, String str8, ImageModel imageModel4, String str9, String str10, String str11, String str12, List list, PostLimitDetailModel postLimitDetailModel, LinkDictModel linkDictModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, str2, (i10 & 4) != 0 ? null : bool, z10, (i10 & 16) != 0 ? null : user, (i10 & 32) != 0 ? null : user2, j10, (i10 & 128) != 0 ? null : bool2, (i10 & 256) != 0 ? null : messageSendState, (i10 & 512) != 0 ? null : str3, (i10 & 1024) != 0 ? null : str4, (i10 & 2048) != 0 ? null : num, (i10 & 4096) != 0 ? null : imageModel, (i10 & 8192) != 0 ? null : str5, (i10 & 16384) != 0 ? null : str6, (32768 & i10) != 0 ? null : num2, (65536 & i10) != 0 ? null : num3, (131072 & i10) != 0 ? null : imageModel2, (262144 & i10) != 0 ? null : imageModel3, (524288 & i10) != 0 ? null : str7, (1048576 & i10) != 0 ? null : chatNoticeBtnType, (2097152 & i10) != 0 ? null : messagePostModel, (4194304 & i10) != 0 ? null : str8, (8388608 & i10) != 0 ? null : imageModel4, (16777216 & i10) != 0 ? null : str9, (33554432 & i10) != 0 ? null : str10, (67108864 & i10) != 0 ? null : str11, (134217728 & i10) != 0 ? null : str12, (268435456 & i10) != 0 ? null : list, (536870912 & i10) != 0 ? null : postLimitDetailModel, (i10 & 1073741824) != 0 ? null : linkDictModel);
    }
}
