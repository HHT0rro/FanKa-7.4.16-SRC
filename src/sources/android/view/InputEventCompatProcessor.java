package android.view;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InputEventCompatProcessor {
    protected Context mContext;
    private List<InputEvent> mProcessedEvents = new ArrayList();
    protected int mTargetSdkVersion;

    public InputEventCompatProcessor(Context context) {
        this.mContext = context;
        this.mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
    }

    public List<InputEvent> processInputEventForCompatibility(InputEvent e2) {
        if (this.mTargetSdkVersion < 23 && (e2 instanceof MotionEvent)) {
            this.mProcessedEvents.clear();
            MotionEvent motion = (MotionEvent) e2;
            int buttonState = motion.getButtonState();
            int compatButtonState = (buttonState & 96) >> 4;
            if (compatButtonState != 0) {
                motion.setButtonState(buttonState | compatButtonState);
            }
            this.mProcessedEvents.add(motion);
            return this.mProcessedEvents;
        }
        return null;
    }

    public InputEvent processInputEventBeforeFinish(InputEvent e2) {
        return e2;
    }
}
