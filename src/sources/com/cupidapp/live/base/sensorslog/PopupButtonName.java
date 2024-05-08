package com.cupidapp.live.base.sensorslog;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogPopup.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PopupButtonName {
    UploadAvatar("上传头像"),
    SaveBirthday("保存生日"),
    Close("CLOSE"),
    Download("下载"),
    ChangePayTerm("切换支付方式"),
    Subscribe("订阅"),
    OpenPush("打开通知"),
    UpdateImmediately("立即更新"),
    NotYetUpdate("暂不更新"),
    JoinFanClub("加入粉丝团"),
    AutoLightUp("自动点亮"),
    ToUpload("去上传"),
    Upload("升级"),
    GotoOpen("去开启"),
    SuperLikeAndSendMessage("私信并超级喜欢"),
    OnlySuperLike("仅超级喜欢"),
    AgreeAndContinue("同意并继续"),
    ToSet("去设置"),
    NoNeed("不用了"),
    ToManage("去管理"),
    I_KNOW("知道了"),
    Leave("LEAVE"),
    Rematch("REMATCH"),
    Continue("CONTINUE"),
    ConfirmExit("CONFIRM_EXIT"),
    TRY("TRY"),
    NO_REMIND("NO_REMIND"),
    Agree("AGREE"),
    DisAgree("DISAGREE"),
    LOG_THIS_ACCOUNT("LOG_THIS_ACCOUNT"),
    OTHERS_WAY_CLICK("OTHERS_WAY_CLICK"),
    NotFill("NOT_FILL"),
    Confirm("CONFIRM"),
    Stop("STOP"),
    Cancel("CANCEL"),
    AllowConnect("ALLOW_CONNECT"),
    StopConnectApply("STOP_CONNECT_APPLY"),
    UPLOAD_AVATAR("UPLOAD_AVATAR"),
    GET("GET"),
    NOT("NOT"),
    SUBMIT("SUBMIT"),
    ANONYMOUS_SUBMIT("ANONYMOUS_SUBMIT"),
    OTHER_NUMBER("OTHER_NUMBER"),
    Send("SEND"),
    CONTINUE("CONTINUE"),
    UNLOCK_CHAT("UNLOCK_CHAT"),
    Recharge("RECHARGE"),
    ConnectConsult("CONNECT_CONSULT"),
    OneToOne("ONE_TO_ONE"),
    Open("OPEN"),
    Connect("CONNECT");


    @NotNull
    private final String value;

    PopupButtonName(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
