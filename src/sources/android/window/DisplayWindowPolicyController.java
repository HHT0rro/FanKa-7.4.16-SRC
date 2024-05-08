package android.window;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.ArraySet;
import com.alipay.sdk.util.i;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class DisplayWindowPolicyController {
    private final Set<Integer> mSupportedWindowingModes;
    private int mSystemWindowFlags;
    private int mWindowFlags;

    public abstract boolean canActivityBeLaunched(ActivityInfo activityInfo, Intent intent, int i10, int i11, boolean z10);

    public abstract boolean canContainActivities(List<ActivityInfo> list, int i10);

    public abstract boolean canShowTasksInHostDeviceRecents();

    public abstract boolean keepActivityOnWindowFlagsChanged(ActivityInfo activityInfo, int i10, int i11);

    public DisplayWindowPolicyController() {
        ArraySet arraySet = new ArraySet();
        this.mSupportedWindowingModes = arraySet;
        synchronized (arraySet) {
            arraySet.add(1);
        }
    }

    public final boolean isInterestedWindowFlags(int windowFlags, int systemWindowFlags) {
        return ((this.mWindowFlags & windowFlags) == 0 && (this.mSystemWindowFlags & systemWindowFlags) == 0) ? false : true;
    }

    public final void setInterestedWindowFlags(int windowFlags, int systemWindowFlags) {
        this.mWindowFlags = windowFlags;
        this.mSystemWindowFlags = systemWindowFlags;
    }

    public final boolean isWindowingModeSupported(int windowingMode) {
        boolean contains;
        synchronized (this.mSupportedWindowingModes) {
            contains = this.mSupportedWindowingModes.contains(Integer.valueOf(windowingMode));
        }
        return contains;
    }

    public final void setSupportedWindowingModes(Set<Integer> supportedWindowingModes) {
        synchronized (this.mSupportedWindowingModes) {
            this.mSupportedWindowingModes.clear();
            this.mSupportedWindowingModes.addAll(supportedWindowingModes);
        }
    }

    public void onTopActivityChanged(ComponentName topActivity, int uid, int userId) {
    }

    public void onRunningAppsChanged(ArraySet<Integer> runningUids) {
    }

    public boolean isEnteringPipAllowed(int uid) {
        return isWindowingModeSupported(2);
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + "DisplayWindowPolicyController{" + super.toString() + i.f4738d);
        pw.println(prefix + "  mWindowFlags=" + this.mWindowFlags);
        pw.println(prefix + "  mSystemWindowFlags=" + this.mSystemWindowFlags);
    }
}
