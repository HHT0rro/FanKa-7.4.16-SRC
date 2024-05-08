package com.cupidapp.live.maskparty.model;

import android.content.Context;
import android.os.CountDownTimer;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ImageSizeConstants;
import com.cupidapp.live.maskparty.activity.ChatLookImageData;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.Arrays;
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

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatMessageModel implements Serializable {

    @NotNull
    private MessageActionType actionType;

    @Nullable
    private Integer countdownLeftSeconds;

    @Nullable
    private final Integer countdownSeconds;
    private final long createTimeMillis;

    @Nullable
    private final MaskPartyChatDiceModel diceModel;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final ImageModel imageLarge;

    @Nullable
    private final String imagePath;

    @Nullable
    private final ImageModel imageThumb;
    private boolean isShow;

    @Nullable
    private String itemId;

    @Nullable
    private CountDownTimer mTimer;
    private boolean mask;

    @Nullable
    private MaskPartyChatMessageSendState messageSendState;
    private final boolean mine;

    @Nullable
    private MaskPartyChatNotifyMessageModel notice;

    @Nullable
    private String password;

    @Nullable
    private Function1<? super Float, p> progressCallback;

    @Nullable
    private final String reportData;

    @Nullable
    private String roomId;

    @Nullable
    private final User sender;

    @Nullable
    private final String text;

    @NotNull
    private final String type;

    /* compiled from: MaskPartyChatMessageModel.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f16369a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaskPartyChatMessageModel f16370b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref$LongRef f16371c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f16372d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, long j11, MaskPartyChatMessageModel maskPartyChatMessageModel, Ref$LongRef ref$LongRef, long j12) {
            super(j10, j11);
            this.f16369a = j11;
            this.f16370b = maskPartyChatMessageModel;
            this.f16371c = ref$LongRef;
            this.f16372d = j12;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f16370b.setCountdownLeftSeconds(0);
            Function1<Float, p> progressCallback = this.f16370b.getProgressCallback();
            if (progressCallback != null) {
                progressCallback.invoke(Float.valueOf(0.0f));
            }
            EventBus.c().o(new SnapMessageDestroyEvent());
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            Ref$LongRef ref$LongRef = this.f16371c;
            long j11 = ref$LongRef.element + this.f16369a;
            ref$LongRef.element = j11;
            if (j11 % 1000 == 0) {
                MaskPartyChatMessageModel maskPartyChatMessageModel = this.f16370b;
                s.f(maskPartyChatMessageModel.getCountdownLeftSeconds());
                maskPartyChatMessageModel.setCountdownLeftSeconds(Integer.valueOf(r1.intValue() - 1));
            }
            Function1<Float, p> progressCallback = this.f16370b.getProgressCallback();
            if (progressCallback != null) {
                progressCallback.invoke(Float.valueOf(((float) j10) / ((float) this.f16372d)));
            }
        }
    }

    public MaskPartyChatMessageModel(@Nullable String str, @Nullable String str2, @NotNull String type, boolean z10, @Nullable User user, long j10, @Nullable MaskPartyChatMessageSendState maskPartyChatMessageSendState, boolean z11, @Nullable String str3, @NotNull MessageActionType actionType, @Nullable String str4, @Nullable ImageModel imageModel, @Nullable String str5, @Nullable String str6, @Nullable Integer num, @Nullable Integer num2, @Nullable CountDownTimer countDownTimer, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel, @Nullable MaskPartyChatDiceModel maskPartyChatDiceModel, boolean z12) {
        s.i(type, "type");
        s.i(actionType, "actionType");
        this.roomId = str;
        this.itemId = str2;
        this.type = type;
        this.mine = z10;
        this.sender = user;
        this.createTimeMillis = j10;
        this.messageSendState = maskPartyChatMessageSendState;
        this.mask = z11;
        this.reportData = str3;
        this.actionType = actionType;
        this.text = str4;
        this.image = imageModel;
        this.imagePath = str5;
        this.password = str6;
        this.countdownLeftSeconds = num;
        this.countdownSeconds = num2;
        this.mTimer = countDownTimer;
        this.imageThumb = imageModel2;
        this.imageLarge = imageModel3;
        this.notice = maskPartyChatNotifyMessageModel;
        this.diceModel = maskPartyChatDiceModel;
        this.isShow = z12;
    }

    private final CountDownTimer component17() {
        return this.mTimer;
    }

    private final ImageModel component18() {
        return this.imageThumb;
    }

    private final ImageModel component19() {
        return this.imageLarge;
    }

    @NotNull
    public final ChatLookImageData assembleChatLookImageData() {
        return new ChatLookImageData(this.image, this.imagePath, s.d(this.type, MaskPartyChatMessageType.InboxMessageSnapImage.getValue()) ? getSnapImageLargeUrl() : null);
    }

    @Nullable
    public final String component1() {
        return this.roomId;
    }

    @NotNull
    public final MessageActionType component10() {
        return this.actionType;
    }

    @Nullable
    public final String component11() {
        return this.text;
    }

    @Nullable
    public final ImageModel component12() {
        return this.image;
    }

    @Nullable
    public final String component13() {
        return this.imagePath;
    }

    @Nullable
    public final String component14() {
        return this.password;
    }

    @Nullable
    public final Integer component15() {
        return this.countdownLeftSeconds;
    }

    @Nullable
    public final Integer component16() {
        return this.countdownSeconds;
    }

    @Nullable
    public final String component2() {
        return this.itemId;
    }

    @Nullable
    public final MaskPartyChatNotifyMessageModel component20() {
        return this.notice;
    }

    @Nullable
    public final MaskPartyChatDiceModel component21() {
        return this.diceModel;
    }

    public final boolean component22() {
        return this.isShow;
    }

    @NotNull
    public final String component3() {
        return this.type;
    }

    public final boolean component4() {
        return this.mine;
    }

    @Nullable
    public final User component5() {
        return this.sender;
    }

    public final long component6() {
        return this.createTimeMillis;
    }

    @Nullable
    public final MaskPartyChatMessageSendState component7() {
        return this.messageSendState;
    }

    public final boolean component8() {
        return this.mask;
    }

    @Nullable
    public final String component9() {
        return this.reportData;
    }

    @NotNull
    public final MaskPartyChatMessageModel copy(@Nullable String str, @Nullable String str2, @NotNull String type, boolean z10, @Nullable User user, long j10, @Nullable MaskPartyChatMessageSendState maskPartyChatMessageSendState, boolean z11, @Nullable String str3, @NotNull MessageActionType actionType, @Nullable String str4, @Nullable ImageModel imageModel, @Nullable String str5, @Nullable String str6, @Nullable Integer num, @Nullable Integer num2, @Nullable CountDownTimer countDownTimer, @Nullable ImageModel imageModel2, @Nullable ImageModel imageModel3, @Nullable MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel, @Nullable MaskPartyChatDiceModel maskPartyChatDiceModel, boolean z12) {
        s.i(type, "type");
        s.i(actionType, "actionType");
        return new MaskPartyChatMessageModel(str, str2, type, z10, user, j10, maskPartyChatMessageSendState, z11, str3, actionType, str4, imageModel, str5, str6, num, num2, countDownTimer, imageModel2, imageModel3, maskPartyChatNotifyMessageModel, maskPartyChatDiceModel, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyChatMessageModel)) {
            return false;
        }
        MaskPartyChatMessageModel maskPartyChatMessageModel = (MaskPartyChatMessageModel) obj;
        return s.d(this.roomId, maskPartyChatMessageModel.roomId) && s.d(this.itemId, maskPartyChatMessageModel.itemId) && s.d(this.type, maskPartyChatMessageModel.type) && this.mine == maskPartyChatMessageModel.mine && s.d(this.sender, maskPartyChatMessageModel.sender) && this.createTimeMillis == maskPartyChatMessageModel.createTimeMillis && this.messageSendState == maskPartyChatMessageModel.messageSendState && this.mask == maskPartyChatMessageModel.mask && s.d(this.reportData, maskPartyChatMessageModel.reportData) && this.actionType == maskPartyChatMessageModel.actionType && s.d(this.text, maskPartyChatMessageModel.text) && s.d(this.image, maskPartyChatMessageModel.image) && s.d(this.imagePath, maskPartyChatMessageModel.imagePath) && s.d(this.password, maskPartyChatMessageModel.password) && s.d(this.countdownLeftSeconds, maskPartyChatMessageModel.countdownLeftSeconds) && s.d(this.countdownSeconds, maskPartyChatMessageModel.countdownSeconds) && s.d(this.mTimer, maskPartyChatMessageModel.mTimer) && s.d(this.imageThumb, maskPartyChatMessageModel.imageThumb) && s.d(this.imageLarge, maskPartyChatMessageModel.imageLarge) && s.d(this.notice, maskPartyChatMessageModel.notice) && s.d(this.diceModel, maskPartyChatMessageModel.diceModel) && this.isShow == maskPartyChatMessageModel.isShow;
    }

    @NotNull
    public final MessageActionType getActionType() {
        return this.actionType;
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
    public final MaskPartyChatDiceModel getDiceModel() {
        return this.diceModel;
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

    public final boolean getMask() {
        return this.mask;
    }

    @Nullable
    public final MaskPartyChatMessageSendState getMessageSendState() {
        return this.messageSendState;
    }

    public final boolean getMine() {
        return this.mine;
    }

    @Nullable
    public final MaskPartyChatNotifyMessageModel getNotice() {
        return this.notice;
    }

    @Nullable
    public final String getPassword() {
        return this.password;
    }

    @Nullable
    public final Function1<Float, p> getProgressCallback() {
        return this.progressCallback;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final String getRoomId() {
        return this.roomId;
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
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.roomId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.itemId;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.type.hashCode()) * 31;
        boolean z10 = this.mine;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        User user = this.sender;
        int hashCode3 = (((i11 + (user == null ? 0 : user.hashCode())) * 31) + b2.a.a(this.createTimeMillis)) * 31;
        MaskPartyChatMessageSendState maskPartyChatMessageSendState = this.messageSendState;
        int hashCode4 = (hashCode3 + (maskPartyChatMessageSendState == null ? 0 : maskPartyChatMessageSendState.hashCode())) * 31;
        boolean z11 = this.mask;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (hashCode4 + i12) * 31;
        String str3 = this.reportData;
        int hashCode5 = (((i13 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.actionType.hashCode()) * 31;
        String str4 = this.text;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ImageModel imageModel = this.image;
        int hashCode7 = (hashCode6 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str5 = this.imagePath;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.password;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.countdownLeftSeconds;
        int hashCode10 = (hashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.countdownSeconds;
        int hashCode11 = (hashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        CountDownTimer countDownTimer = this.mTimer;
        int hashCode12 = (hashCode11 + (countDownTimer == null ? 0 : countDownTimer.hashCode())) * 31;
        ImageModel imageModel2 = this.imageThumb;
        int hashCode13 = (hashCode12 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        ImageModel imageModel3 = this.imageLarge;
        int hashCode14 = (hashCode13 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel = this.notice;
        int hashCode15 = (hashCode14 + (maskPartyChatNotifyMessageModel == null ? 0 : maskPartyChatNotifyMessageModel.hashCode())) * 31;
        MaskPartyChatDiceModel maskPartyChatDiceModel = this.diceModel;
        int hashCode16 = (hashCode15 + (maskPartyChatDiceModel != null ? maskPartyChatDiceModel.hashCode() : 0)) * 31;
        boolean z12 = this.isShow;
        return hashCode16 + (z12 ? 1 : z12 ? 1 : 0);
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final boolean less2Min() {
        return System.currentTimeMillis() - this.createTimeMillis < 120000;
    }

    public final boolean passwordIsNullOrEmpty() {
        String str = this.password;
        return str == null || str.length() == 0;
    }

    public final void setActionType(@NotNull MessageActionType messageActionType) {
        s.i(messageActionType, "<set-?>");
        this.actionType = messageActionType;
    }

    public final void setCountdownLeftSeconds(@Nullable Integer num) {
        this.countdownLeftSeconds = num;
    }

    public final void setItemId(@Nullable String str) {
        this.itemId = str;
    }

    public final void setMask(boolean z10) {
        this.mask = z10;
    }

    public final void setMessageSendState(@Nullable MaskPartyChatMessageSendState maskPartyChatMessageSendState) {
        this.messageSendState = maskPartyChatMessageSendState;
    }

    public final void setNotice(@Nullable MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel) {
        this.notice = maskPartyChatNotifyMessageModel;
    }

    public final void setPassword(@Nullable String str) {
        this.password = str;
    }

    public final void setProgressCallback(@Nullable Function1<? super Float, p> function1) {
        this.progressCallback = function1;
    }

    public final void setRoomId(@Nullable String str) {
        this.roomId = str;
    }

    public final void setShow(boolean z10) {
        this.isShow = z10;
    }

    public final boolean snapImageModel() {
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

    public final void stopSnapCountDown() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mTimer = null;
    }

    @NotNull
    public String toString() {
        String str = this.roomId;
        String str2 = this.itemId;
        String str3 = this.type;
        boolean z10 = this.mine;
        User user = this.sender;
        long j10 = this.createTimeMillis;
        MaskPartyChatMessageSendState maskPartyChatMessageSendState = this.messageSendState;
        boolean z11 = this.mask;
        String str4 = this.reportData;
        MessageActionType messageActionType = this.actionType;
        String str5 = this.text;
        ImageModel imageModel = this.image;
        String str6 = this.imagePath;
        String str7 = this.password;
        Integer num = this.countdownLeftSeconds;
        Integer num2 = this.countdownSeconds;
        CountDownTimer countDownTimer = this.mTimer;
        ImageModel imageModel2 = this.imageThumb;
        ImageModel imageModel3 = this.imageLarge;
        MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel = this.notice;
        MaskPartyChatDiceModel maskPartyChatDiceModel = this.diceModel;
        return "MaskPartyChatMessageModel(roomId=" + str + ", itemId=" + str2 + ", type=" + str3 + ", mine=" + z10 + ", sender=" + ((Object) user) + ", createTimeMillis=" + j10 + ", messageSendState=" + ((Object) maskPartyChatMessageSendState) + ", mask=" + z11 + ", reportData=" + str4 + ", actionType=" + ((Object) messageActionType) + ", text=" + str5 + ", image=" + ((Object) imageModel) + ", imagePath=" + str6 + ", password=" + str7 + ", countdownLeftSeconds=" + ((Object) num) + ", countdownSeconds=" + ((Object) num2) + ", mTimer=" + ((Object) countDownTimer) + ", imageThumb=" + ((Object) imageModel2) + ", imageLarge=" + ((Object) imageModel3) + ", notice=" + ((Object) maskPartyChatNotifyMessageModel) + ", diceModel=" + ((Object) maskPartyChatDiceModel) + ", isShow=" + this.isShow + ")";
    }

    public /* synthetic */ MaskPartyChatMessageModel(String str, String str2, String str3, boolean z10, User user, long j10, MaskPartyChatMessageSendState maskPartyChatMessageSendState, boolean z11, String str4, MessageActionType messageActionType, String str5, ImageModel imageModel, String str6, String str7, Integer num, Integer num2, CountDownTimer countDownTimer, ImageModel imageModel2, ImageModel imageModel3, MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel, MaskPartyChatDiceModel maskPartyChatDiceModel, boolean z12, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, str3, z10, (i10 & 16) != 0 ? null : user, j10, (i10 & 64) != 0 ? null : maskPartyChatMessageSendState, (i10 & 128) != 0 ? false : z11, (i10 & 256) != 0 ? null : str4, (i10 & 512) != 0 ? MessageActionType.Ordinary : messageActionType, (i10 & 1024) != 0 ? null : str5, (i10 & 2048) != 0 ? null : imageModel, (i10 & 4096) != 0 ? null : str6, (i10 & 8192) != 0 ? null : str7, (i10 & 16384) != 0 ? null : num, (32768 & i10) != 0 ? null : num2, (65536 & i10) != 0 ? null : countDownTimer, (131072 & i10) != 0 ? null : imageModel2, (262144 & i10) != 0 ? null : imageModel3, (524288 & i10) != 0 ? null : maskPartyChatNotifyMessageModel, (1048576 & i10) != 0 ? null : maskPartyChatDiceModel, (i10 & 2097152) != 0 ? true : z12);
    }
}
