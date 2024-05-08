package com.android.internal.app;

import com.android.internal.logging.InstanceId;
import com.android.internal.logging.UiEventLogger;
import com.android.internal.logging.nano.MetricsProto;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ChooserActivityLogger {
    InstanceId getInstanceId();

    void log(UiEventLogger.UiEventEnum uiEventEnum, InstanceId instanceId);

    void logShareStarted(int i10, String str, String str2, int i11, int i12, boolean z10, int i13, String str3);

    void logShareTargetSelected(int i10, String str, int i11, boolean z10);

    default void logSharesheetTriggered() {
        log(SharesheetStandardEvent.SHARESHEET_TRIGGERED, getInstanceId());
    }

    default void logSharesheetAppLoadComplete() {
        log(SharesheetStandardEvent.SHARESHEET_APP_LOAD_COMPLETE, getInstanceId());
    }

    default void logSharesheetDirectLoadComplete() {
        log(SharesheetStandardEvent.SHARESHEET_DIRECT_LOAD_COMPLETE, getInstanceId());
    }

    default void logSharesheetDirectLoadTimeout() {
        log(SharesheetStandardEvent.SHARESHEET_DIRECT_LOAD_TIMEOUT, getInstanceId());
    }

    default void logShareheetProfileChanged() {
        log(SharesheetStandardEvent.SHARESHEET_PROFILE_CHANGED, getInstanceId());
    }

    default void logSharesheetExpansionChanged(boolean isCollapsed) {
        log(isCollapsed ? SharesheetStandardEvent.SHARESHEET_COLLAPSED : SharesheetStandardEvent.SHARESHEET_EXPANDED, getInstanceId());
    }

    default void logSharesheetAppShareRankingTimeout() {
        log(SharesheetStandardEvent.SHARESHEET_APP_SHARE_RANKING_TIMEOUT, getInstanceId());
    }

    default void logSharesheetEmptyDirectShareRow() {
        log(SharesheetStandardEvent.SHARESHEET_EMPTY_DIRECT_SHARE_ROW, getInstanceId());
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum SharesheetStartedEvent implements UiEventLogger.UiEventEnum {
        SHARE_STARTED(228);

        private final int mId;

        SharesheetStartedEvent(int id2) {
            this.mId = id2;
        }

        @Override // com.android.internal.logging.UiEventLogger.UiEventEnum
        public int getId() {
            return this.mId;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum SharesheetTargetSelectedEvent implements UiEventLogger.UiEventEnum {
        INVALID(0),
        SHARESHEET_SERVICE_TARGET_SELECTED(232),
        SHARESHEET_APP_TARGET_SELECTED(233),
        SHARESHEET_STANDARD_TARGET_SELECTED(234),
        SHARESHEET_COPY_TARGET_SELECTED(235),
        SHARESHEET_NEARBY_TARGET_SELECTED(MetricsProto.MetricsEvent.PROVISIONING_COPY_ACCOUNT_STATUS),
        SHARESHEET_EDIT_TARGET_SELECTED(MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_RECORD_AUDIO);

        private final int mId;

        SharesheetTargetSelectedEvent(int id2) {
            this.mId = id2;
        }

        @Override // com.android.internal.logging.UiEventLogger.UiEventEnum
        public int getId() {
            return this.mId;
        }

        public static SharesheetTargetSelectedEvent fromTargetType(int targetType) {
            switch (targetType) {
                case 1:
                    return SHARESHEET_SERVICE_TARGET_SELECTED;
                case 2:
                    return SHARESHEET_APP_TARGET_SELECTED;
                case 3:
                    return SHARESHEET_STANDARD_TARGET_SELECTED;
                case 4:
                    return SHARESHEET_COPY_TARGET_SELECTED;
                case 5:
                    return SHARESHEET_NEARBY_TARGET_SELECTED;
                case 6:
                    return SHARESHEET_EDIT_TARGET_SELECTED;
                default:
                    return INVALID;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum SharesheetStandardEvent implements UiEventLogger.UiEventEnum {
        INVALID(0),
        SHARESHEET_TRIGGERED(227),
        SHARESHEET_PROFILE_CHANGED(229),
        SHARESHEET_EXPANDED(230),
        SHARESHEET_COLLAPSED(231),
        SHARESHEET_APP_LOAD_COMPLETE(322),
        SHARESHEET_DIRECT_LOAD_COMPLETE(323),
        SHARESHEET_DIRECT_LOAD_TIMEOUT(324),
        SHARESHEET_APP_SHARE_RANKING_TIMEOUT(MetricsProto.MetricsEvent.NOTIFICATION_SNOOZED),
        SHARESHEET_EMPTY_DIRECT_SHARE_ROW(MetricsProto.MetricsEvent.CARRIER_DEMO_MODE_PASSWORD);

        private final int mId;

        SharesheetStandardEvent(int id2) {
            this.mId = id2;
        }

        @Override // com.android.internal.logging.UiEventLogger.UiEventEnum
        public int getId() {
            return this.mId;
        }
    }

    default int typeFromPreviewInt(int previewType) {
        switch (previewType) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    default int typeFromIntentString(String intent) {
        char c4;
        if (intent == null) {
            return 0;
        }
        switch (intent.hashCode()) {
            case -1960745709:
                if (intent.equals("android.media.action.IMAGE_CAPTURE")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case -1173683121:
                if (intent.equals("android.intent.action.EDIT")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -1173447682:
                if (intent.equals("android.intent.action.MAIN")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case -1173264947:
                if (intent.equals("android.intent.action.SEND")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -1173171990:
                if (intent.equals("android.intent.action.VIEW")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -58484670:
                if (intent.equals("android.intent.action.SEND_MULTIPLE")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 2068787464:
                if (intent.equals("android.intent.action.SENDTO")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                return 0;
        }
    }
}
