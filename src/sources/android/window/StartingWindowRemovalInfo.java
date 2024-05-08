package android.window;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.SurfaceControl;
import com.alipay.sdk.util.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class StartingWindowRemovalInfo implements Parcelable {
    public static final Parcelable.Creator<StartingWindowRemovalInfo> CREATOR = new Parcelable.Creator<StartingWindowRemovalInfo>() { // from class: android.window.StartingWindowRemovalInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartingWindowRemovalInfo createFromParcel(Parcel source) {
            return new StartingWindowRemovalInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StartingWindowRemovalInfo[] newArray(int size) {
            return new StartingWindowRemovalInfo[size];
        }
    };
    public static final int DEFER_MODE_NONE = 0;
    public static final int DEFER_MODE_NORMAL = 1;
    public static final int DEFER_MODE_ROTATION = 2;
    public int deferRemoveForImeMode;
    public Rect mainFrame;
    public boolean playRevealAnimation;
    public boolean removeImmediately;
    public float roundedCornerRadius;
    public int taskId;
    public SurfaceControl windowAnimationLeash;
    public boolean windowlessSurface;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface DeferMode {
    }

    public StartingWindowRemovalInfo() {
    }

    private StartingWindowRemovalInfo(Parcel source) {
        readFromParcel(source);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    void readFromParcel(Parcel source) {
        this.taskId = source.readInt();
        this.windowAnimationLeash = (SurfaceControl) source.readTypedObject(SurfaceControl.CREATOR);
        this.mainFrame = (Rect) source.readTypedObject(Rect.CREATOR);
        this.playRevealAnimation = source.readBoolean();
        this.deferRemoveForImeMode = source.readInt();
        this.roundedCornerRadius = source.readFloat();
        this.windowlessSurface = source.readBoolean();
        this.removeImmediately = source.readBoolean();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.taskId);
        dest.writeTypedObject(this.windowAnimationLeash, flags);
        dest.writeTypedObject(this.mainFrame, flags);
        dest.writeBoolean(this.playRevealAnimation);
        dest.writeInt(this.deferRemoveForImeMode);
        dest.writeFloat(this.roundedCornerRadius);
        dest.writeBoolean(this.windowlessSurface);
        dest.writeBoolean(this.removeImmediately);
    }

    public String toString() {
        return "StartingWindowRemovalInfo{taskId=" + this.taskId + " frame=" + ((Object) this.mainFrame) + " playRevealAnimation=" + this.playRevealAnimation + " roundedCornerRadius=" + this.roundedCornerRadius + " deferRemoveForImeMode=" + this.deferRemoveForImeMode + " windowlessSurface=" + this.windowlessSurface + " removeImmediately=" + this.removeImmediately + i.f4738d;
    }
}
