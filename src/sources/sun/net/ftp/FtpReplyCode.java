package sun.net.ftp;

import com.android.internal.logging.nano.MetricsProto;
import com.huawei.openalliance.ad.constant.ad;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum FtpReplyCode {
    RESTART_MARKER(110),
    SERVICE_READY_IN(120),
    DATA_CONNECTION_ALREADY_OPEN(125),
    FILE_STATUS_OK(150),
    COMMAND_OK(200),
    NOT_IMPLEMENTED(202),
    SYSTEM_STATUS(211),
    DIRECTORY_STATUS(212),
    FILE_STATUS(213),
    HELP_MESSAGE(214),
    NAME_SYSTEM_TYPE(215),
    SERVICE_READY(220),
    SERVICE_CLOSING(221),
    DATA_CONNECTION_OPEN(225),
    CLOSING_DATA_CONNECTION(226),
    ENTERING_PASSIVE_MODE(227),
    ENTERING_EXT_PASSIVE_MODE(229),
    LOGGED_IN(230),
    SECURELY_LOGGED_IN(232),
    SECURITY_EXCHANGE_OK(234),
    SECURITY_EXCHANGE_COMPLETE(235),
    FILE_ACTION_OK(250),
    PATHNAME_CREATED(257),
    NEED_PASSWORD(331),
    NEED_ACCOUNT(332),
    NEED_ADAT(334),
    NEED_MORE_ADAT(335),
    FILE_ACTION_PENDING(350),
    SERVICE_NOT_AVAILABLE(421),
    CANT_OPEN_DATA_CONNECTION(ad.f32205r),
    CONNECTION_CLOSED(426),
    NEED_SECURITY_RESOURCE(431),
    FILE_ACTION_NOT_TAKEN(450),
    ACTION_ABORTED(MetricsProto.MetricsEvent.ACTION_SHOW_APP_DISAMBIG_APP_FEATURED),
    INSUFFICIENT_STORAGE(MetricsProto.MetricsEvent.ACTION_HIDE_APP_DISAMBIG_APP_FEATURED),
    COMMAND_UNRECOGNIZED(500),
    INVALID_PARAMETER(501),
    BAD_SEQUENCE(503),
    NOT_IMPLEMENTED_FOR_PARAMETER(504),
    NOT_LOGGED_IN(MetricsProto.MetricsEvent.DIALOG_APN_EDITOR_ERROR),
    NEED_ACCOUNT_FOR_STORING(MetricsProto.MetricsEvent.DIALOG_UNIFICATION_CONFIRMATION),
    PROT_LEVEL_DENIED(MetricsProto.MetricsEvent.DIALOG_USER_CREDENTIAL),
    REQUEST_DENIED(MetricsProto.MetricsEvent.DIALOG_REMOVE_USER),
    FAILED_SECURITY_CHECK(MetricsProto.MetricsEvent.DIALOG_CONFIRM_AUTO_SYNC_CHANGE),
    UNSUPPORTED_PROT_LEVEL(MetricsProto.MetricsEvent.DIALOG_RUNNIGN_SERVICE),
    PROT_LEVEL_NOT_SUPPORTED_BY_SECURITY(MetricsProto.MetricsEvent.DIALOG_NO_HOME),
    FILE_UNAVAILABLE(MetricsProto.MetricsEvent.DIALOG_BILLING_BYTE_LIMIT),
    PAGE_TYPE_UNKNOWN(MetricsProto.MetricsEvent.DIALOG_BILLING_CONFIRM_LIMIT),
    EXCEEDED_STORAGE(MetricsProto.MetricsEvent.DIALOG_DISABLE_NOTIFICATION_ACCESS),
    FILE_NAME_NOT_ALLOWED(MetricsProto.MetricsEvent.DIALOG_UNIFY_SOUND_SETTINGS),
    PROTECTED_REPLY(MetricsProto.MetricsEvent.ACTION_PERMISSION_GRANT_UNKNOWN),
    UNKNOWN_ERROR(999);

    private final int value;

    FtpReplyCode(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isPositivePreliminary() {
        int i10 = this.value;
        return i10 >= 100 && i10 < 200;
    }

    public boolean isPositiveCompletion() {
        int i10 = this.value;
        return i10 >= 200 && i10 < 300;
    }

    public boolean isPositiveIntermediate() {
        int i10 = this.value;
        return i10 >= 300 && i10 < 400;
    }

    public boolean isTransientNegative() {
        int i10 = this.value;
        return i10 >= 400 && i10 < 500;
    }

    public boolean isPermanentNegative() {
        int i10 = this.value;
        return i10 >= 500 && i10 < 600;
    }

    public boolean isProtectedReply() {
        int i10 = this.value;
        return i10 >= 600 && i10 < 700;
    }

    public boolean isSyntax() {
        int i10 = this.value;
        return (i10 / 10) - ((i10 / 100) * 10) == 0;
    }

    public boolean isInformation() {
        int i10 = this.value;
        return (i10 / 10) - ((i10 / 100) * 10) == 1;
    }

    public boolean isConnection() {
        int i10 = this.value;
        return (i10 / 10) - ((i10 / 100) * 10) == 2;
    }

    public boolean isAuthentication() {
        int i10 = this.value;
        return (i10 / 10) - ((i10 / 100) * 10) == 3;
    }

    public boolean isUnspecified() {
        int i10 = this.value;
        return (i10 / 10) - ((i10 / 100) * 10) == 4;
    }

    public boolean isFileSystem() {
        int i10 = this.value;
        return (i10 / 10) - ((i10 / 100) * 10) == 5;
    }

    public static FtpReplyCode find(int v2) {
        for (FtpReplyCode code : values()) {
            if (code.getValue() == v2) {
                return code;
            }
        }
        return UNKNOWN_ERROR;
    }
}
