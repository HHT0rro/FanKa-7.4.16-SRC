package java.util.regex;

import com.android.internal.logging.nano.MetricsProto;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class ASCII {
    static final int ALNUM = 1792;
    static final int ALPHA = 768;
    static final int ASCII = 65280;
    static final int BLANK = 16384;
    static final int CNTRL = 8192;
    static final int DIGIT = 1024;
    static final int GRAPH = 5888;
    static final int HEX = 32768;
    static final int LOWER = 512;
    static final int PUNCT = 4096;
    static final int SPACE = 2048;
    static final int UNDER = 65536;
    static final int UPPER = 256;
    static final int WORD = 67328;
    static final int XDIGIT = 32768;
    private static final int[] ctype = {8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 26624, 10240, 10240, 10240, 10240, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 8192, 18432, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 33792, 33793, 33794, 33795, 33796, 33797, 33798, 33799, 33800, 33801, 4096, 4096, 4096, 4096, 4096, 4096, 4096, 33034, 33035, 33036, 33037, 33038, 33039, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 4096, 4096, 4096, 4096, 69632, 4096, 33290, 33291, 33292, 33293, 33294, 33295, MetricsProto.MetricsEvent.DIALOG_FRP, MetricsProto.MetricsEvent.DIALOG_CUSTOM_LIST_CONFIRMATION, MetricsProto.MetricsEvent.DIALOG_APN_EDITOR_ERROR, MetricsProto.MetricsEvent.DIALOG_OWNER_INFO_SETTINGS, MetricsProto.MetricsEvent.DIALOG_UNIFICATION_CONFIRMATION, MetricsProto.MetricsEvent.DIALOG_USER_CREDENTIAL, MetricsProto.MetricsEvent.DIALOG_REMOVE_USER, MetricsProto.MetricsEvent.DIALOG_CONFIRM_AUTO_SYNC_CHANGE, MetricsProto.MetricsEvent.DIALOG_RUNNIGN_SERVICE, MetricsProto.MetricsEvent.DIALOG_NO_HOME, MetricsProto.MetricsEvent.DIALOG_BLUETOOTH_RENAME, MetricsProto.MetricsEvent.DIALOG_BLUETOOTH_PAIRED_DEVICE_PROFILE, 540, MetricsProto.MetricsEvent.DIALOG_KEYBOARD_LAYOUT, MetricsProto.MetricsEvent.DIALOG_WPS_SETUP, MetricsProto.MetricsEvent.DIALOG_WIFI_SCAN_MODE, MetricsProto.MetricsEvent.DIALOG_WIFI_SKIP, MetricsProto.MetricsEvent.DIALOG_LEGACY_VPN_CONFIG, MetricsProto.MetricsEvent.DIALOG_VPN_APP_CONFIG, MetricsProto.MetricsEvent.DIALOG_VPN_CANNOT_CONNECT, 4096, 4096, 4096, 4096, 8192};

    ASCII() {
    }

    static int getType(int ch) {
        if ((ch & (-128)) == 0) {
            return ctype[ch];
        }
        return 0;
    }

    static boolean isType(int ch, int type) {
        return (getType(ch) & type) != 0;
    }

    static boolean isAscii(int ch) {
        return (ch & (-128)) == 0;
    }

    static boolean isAlpha(int ch) {
        return isType(ch, 768);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isDigit(int ch) {
        return ((ch + (-48)) | (57 - ch)) >= 0;
    }

    static boolean isAlnum(int ch) {
        return isType(ch, ALNUM);
    }

    static boolean isGraph(int ch) {
        return isType(ch, GRAPH);
    }

    static boolean isPrint(int ch) {
        return ((ch + (-32)) | (126 - ch)) >= 0;
    }

    static boolean isPunct(int ch) {
        return isType(ch, 4096);
    }

    static boolean isSpace(int ch) {
        return isType(ch, 2048);
    }

    static boolean isHexDigit(int ch) {
        return isType(ch, 32768);
    }

    static boolean isOctDigit(int ch) {
        return ((ch + (-48)) | (55 - ch)) >= 0;
    }

    static boolean isCntrl(int ch) {
        return isType(ch, 8192);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLower(int ch) {
        return ((ch + (-97)) | (122 - ch)) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isUpper(int ch) {
        return ((ch + (-65)) | (90 - ch)) >= 0;
    }

    static boolean isWord(int ch) {
        return isType(ch, WORD);
    }

    static int toDigit(int ch) {
        return ctype[ch & 127] & 63;
    }

    static int toLower(int ch) {
        return isUpper(ch) ? ch + 32 : ch;
    }

    static int toUpper(int ch) {
        return isLower(ch) ? ch - 32 : ch;
    }
}
