package android.view;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemProperties;
import android.util.Log;
import android.view.WindowManager;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WindowLayout {
    private static final boolean DEBUG = false;
    static final int MAX_X = 100000;
    static final int MAX_Y = 100000;
    static final int MIN_X = -100000;
    static final int MIN_Y = -100000;
    public static final int UNSPECIFIED_LENGTH = -1;
    private static final String TAG = WindowLayout.class.getSimpleName();
    private static final boolean PANIC_DEBUG = SystemProperties.getBoolean("persist.sys.assert.panic", false);
    private final Rect mTempDisplayCutoutSafeExceptMaybeBarsRect = new Rect();
    private final Rect mTempRect = new Rect();
    public IWindowLayoutExt mExt = (IWindowLayoutExt) ExtLoader.type(IWindowLayoutExt.class).base(this).create();

    /* JADX WARN: Code restructure failed: missing block: B:103:0x02c9, code lost:
    
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02ce, code lost:
    
        if (r45.type == 1) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02d0, code lost:
    
        if (r10 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02d3, code lost:
    
        r12 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void computeFrames(android.view.WindowManager.LayoutParams r45, android.view.InsetsState r46, android.graphics.Rect r47, android.graphics.Rect r48, int r49, int r50, int r51, int r52, float r53, android.window.ClientWindowFrames r54) {
        /*
            Method dump skipped, instructions count: 789
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.WindowLayout.computeFrames(android.view.WindowManager$LayoutParams, android.view.InsetsState, android.graphics.Rect, android.graphics.Rect, int, int, int, int, float, android.window.ClientWindowFrames):void");
    }

    public static void extendFrameByCutout(Rect displayCutoutSafe, Rect displayFrame, Rect inOutFrame, Rect tempRect) {
        if (displayCutoutSafe.contains(inOutFrame)) {
            return;
        }
        tempRect.set(inOutFrame);
        Gravity.applyDisplay(0, displayCutoutSafe, tempRect);
        if (tempRect.intersect(displayFrame)) {
            inOutFrame.union(tempRect);
        }
    }

    public static void computeSurfaceSize(WindowManager.LayoutParams attrs, Rect maxBounds, int requestedWidth, int requestedHeight, Rect winFrame, boolean dragResizing, Point outSurfaceSize) {
        int width;
        int height;
        if ((attrs.flags & 16384) != 0) {
            Log.d(TAG, "computeSurfaceSize, for a scaled surface, we always want the requested size");
            width = requestedWidth;
            height = requestedHeight;
        } else if (dragResizing) {
            width = maxBounds.width();
            height = maxBounds.height();
        } else {
            width = winFrame.width();
            height = winFrame.height();
        }
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        Rect surfaceInsets = attrs.surfaceInsets;
        outSurfaceSize.set(width + surfaceInsets.left + surfaceInsets.right, height + surfaceInsets.top + surfaceInsets.bottom);
    }
}
