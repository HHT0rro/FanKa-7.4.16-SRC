package android.view;

import android.os.Parcel;
import android.view.ViewGroup;
import com.oplus.view.OplusLayoutParams;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OplusBaseLayoutParams extends ViewGroup.LayoutParams {
    public static final int BACK_GESTURE_EXCLUSION_NO_RESTRICTION = 1;
    public static final int BACK_GESTURE_RESTRICTION_DEFAULT = 0;
    public static final int BACK_SWITCH_APP_GESTURE_DISABLED = 2;
    public static final int DEFAULT_STATUS_BAR = 0;
    public static final int DISABLE_STATUS_BAR = 1;
    public static final int ENABLE_STATUS_BAR = 2;
    public static final int FLAG_AMEND_DROP_CUSTOM_ANIMATION = 2048;
    public static final int FLAG_DISABLE_STATUS_BAR = 1048576;
    public static final int FLAG_ENABLE_STATUS_BAR = 2097152;
    public static final int FLAG_FLEXIBLE_ACTIVITY = 2;
    public static final int FLAG_FORCE_OVERRIDE_ORIENTATION_ON_SUB_DISPLAY = 8;
    public static final int FLAG_FORCE_SHOW_ON_SUB_DISPLAY = 4;
    public static final int FLAG_IGNORE_HOME_KEY = 33554432;
    public static final int FLAG_IGNORE_HOME_MENU = 16777216;
    public static final int FLAG_IMENU_KEY = 67108864;
    public static final int IGNORE_HOME_KEY = 2;
    public static final int IGNORE_HOME_MENU_KEY = 1;
    public static final int IGNORE_MENU_KEY = 3;
    public static final int OPLUS_FLAG_WINDOW_DEFAULT = 0;
    public static final int OPLUS_FLAG_WINDOW_USER_DEFINED_TOAST = 1;
    public static final int PRIVATE_FLAG_BOTTOM_ALERT_DIALOG = 16777216;
    public static final int PRIVATE_FLAG_NAVIGATION_BAR_LIGHT = Integer.MIN_VALUE;
    public static final int TYPE_DRAG_SCREEN_BACKGROUND = 2301;
    public static final int TYPE_DRAG_SCREEN_FOREGROUND = 2302;
    public static final int TYPE_SYSTEM_BLACKSCREEN_OVERLAY = 2099;
    public static final int TYPE_SYSTEM_DRAGDROP_OVERLAY = 2098;
    public static final int UNSET_ANY_KEY = 0;
    public int backGestureRestriction;
    public int ignoreHomeMenuKey;
    public int isDisableStatusBar;
    public final OplusLayoutParams mOplusLayoutParams;
    public int navigationBarColor;
    public int navigationBarVisibility;
    public int oplusFlags;

    public OplusBaseLayoutParams() {
        this.ignoreHomeMenuKey = 0;
        this.isDisableStatusBar = 0;
        this.navigationBarVisibility = 0;
        this.navigationBarColor = 0;
        this.oplusFlags = 0;
        this.backGestureRestriction = 0;
        this.mOplusLayoutParams = new OplusLayoutParams();
    }

    public OplusBaseLayoutParams(int w3, int h10) {
        super(w3, h10);
        this.ignoreHomeMenuKey = 0;
        this.isDisableStatusBar = 0;
        this.navigationBarVisibility = 0;
        this.navigationBarColor = 0;
        this.oplusFlags = 0;
        this.backGestureRestriction = 0;
        this.mOplusLayoutParams = new OplusLayoutParams();
    }

    public void writeToParcel(Parcel out, int parcelableFlags) {
        out.writeInt(this.ignoreHomeMenuKey);
        out.writeInt(this.isDisableStatusBar);
        this.mOplusLayoutParams.writeToParcel(out, parcelableFlags);
        out.writeInt(this.oplusFlags);
        out.writeInt(this.backGestureRestriction);
    }

    public void readFromParcel(Parcel in) {
        this.ignoreHomeMenuKey = in.readInt();
        this.isDisableStatusBar = in.readInt();
        this.mOplusLayoutParams.readFromParcel(in);
        this.oplusFlags = in.readInt();
        this.backGestureRestriction = in.readInt();
    }

    public final int copyFrom(OplusBaseLayoutParams o10) {
        int changes = 0;
        int i10 = this.ignoreHomeMenuKey;
        int i11 = o10.ignoreHomeMenuKey;
        if (i10 != i11) {
            this.ignoreHomeMenuKey = i11;
        }
        int i12 = this.isDisableStatusBar;
        int i13 = o10.isDisableStatusBar;
        if (i12 != i13) {
            this.isDisableStatusBar = i13;
        }
        if (!this.mOplusLayoutParams.equals(o10.mOplusLayoutParams)) {
            this.mOplusLayoutParams.set(o10.mOplusLayoutParams);
            changes = 0 | 16384;
        }
        int i14 = this.oplusFlags;
        int i15 = o10.oplusFlags;
        if (i14 != i15) {
            this.oplusFlags = i15;
        }
        int i16 = this.backGestureRestriction;
        int i17 = o10.backGestureRestriction;
        if (i16 != i17) {
            this.backGestureRestriction = i17;
        }
        return changes;
    }

    public String toString(String prefix) {
        StringBuilder sb2 = new StringBuilder(128);
        if (this.isDisableStatusBar != 0) {
            sb2.append(" isDisableStatusBar=");
            sb2.append(this.isDisableStatusBar);
        }
        sb2.append((Object) this.mOplusLayoutParams);
        if (this.oplusFlags != 0) {
            sb2.append(" oplusFlags=");
            sb2.append(this.oplusFlags);
        }
        if (this.backGestureRestriction != 0) {
            sb2.append(" backGestureRestriction=");
            sb2.append(this.backGestureRestriction);
        }
        return sb2.toString();
    }
}
