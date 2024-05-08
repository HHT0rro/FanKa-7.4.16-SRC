package android.webkit;

import android.content.Context;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class LegacyErrorStrings {
    private static final String LOGTAG = "Http";

    private LegacyErrorStrings() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getString(int errorCode, Context context) {
        return context.getText(getResource(errorCode)).toString();
    }

    private static int getResource(int errorCode) {
        switch (errorCode) {
            case -15:
                return 17040499;
            case -14:
                return 17040492;
            case -13:
                return 17040491;
            case -12:
                return 17039367;
            case -11:
                return 17040490;
            case -10:
                return 17039368;
            case -9:
                return 17040497;
            case -8:
                return 17040498;
            case -7:
                return 17040493;
            case -6:
                return 17040489;
            case -5:
                return 17040496;
            case -4:
                return 17040488;
            case -3:
                return 17040500;
            case -2:
                return 17040494;
            case -1:
                return 17040487;
            case 0:
                return 17040495;
            default:
                Log.w(LOGTAG, "Using generic message for unknown error code: " + errorCode);
                return 17040487;
        }
    }
}
