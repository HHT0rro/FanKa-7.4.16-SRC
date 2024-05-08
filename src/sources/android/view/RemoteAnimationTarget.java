package android.view;

import android.app.ActivityManager;
import android.app.WindowConfiguration;
import android.graphics.GraphicsProtos;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.proto.ProtoOutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RemoteAnimationTarget implements Parcelable {
    public static final Parcelable.Creator<RemoteAnimationTarget> CREATOR = new Parcelable.Creator<RemoteAnimationTarget>() { // from class: android.view.RemoteAnimationTarget.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteAnimationTarget createFromParcel(Parcel in) {
            return new RemoteAnimationTarget(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteAnimationTarget[] newArray(int size) {
            return new RemoteAnimationTarget[size];
        }
    };
    public static final int MODE_CHANGING = 2;
    public static final int MODE_CLOSING = 1;
    public static final int MODE_OPENING = 0;
    public boolean allowEnterPip;
    public int backgroundColor;
    public final Rect clipRect;
    public final Rect contentInsets;
    public boolean hasAnimatingParent;
    public boolean isNotInRecents;
    public final boolean isTranslucent;
    public final SurfaceControl leash;
    public final Rect localBounds;
    public IRemoteAnimationTargetExt mExt;
    public final int mode;

    @Deprecated
    public final Point position;

    @Deprecated
    public final int prefixOrderIndex;
    public int rotationChange;
    public final Rect screenSpaceBounds;
    public boolean showBackdrop;

    @Deprecated
    public final Rect sourceContainerBounds;
    public final Rect startBounds;
    public final SurfaceControl startLeash;
    public final int taskId;
    public ActivityManager.RunningTaskInfo taskInfo;
    public boolean willShowImeOnTarget;
    public final WindowConfiguration windowConfiguration;
    public final int windowType;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Mode {
    }

    public RemoteAnimationTarget(int taskId, int mode, SurfaceControl leash, boolean isTranslucent, Rect clipRect, Rect contentInsets, int prefixOrderIndex, Point position, Rect localBounds, Rect screenSpaceBounds, WindowConfiguration windowConfig, boolean isNotInRecents, SurfaceControl startLeash, Rect startBounds, ActivityManager.RunningTaskInfo taskInfo, boolean allowEnterPip) {
        this(taskId, mode, leash, isTranslucent, clipRect, contentInsets, prefixOrderIndex, position, localBounds, screenSpaceBounds, windowConfig, isNotInRecents, startLeash, startBounds, taskInfo, allowEnterPip, -1);
    }

    public RemoteAnimationTarget(int taskId, int mode, SurfaceControl leash, boolean isTranslucent, Rect clipRect, Rect contentInsets, int prefixOrderIndex, Point position, Rect localBounds, Rect screenSpaceBounds, WindowConfiguration windowConfig, boolean isNotInRecents, SurfaceControl startLeash, Rect startBounds, ActivityManager.RunningTaskInfo taskInfo, boolean allowEnterPip, int windowType) {
        Rect rect;
        this.mExt = (IRemoteAnimationTargetExt) ExtLoader.type(IRemoteAnimationTargetExt.class).base(this).create();
        this.mode = mode;
        this.taskId = taskId;
        this.leash = leash;
        this.isTranslucent = isTranslucent;
        this.clipRect = new Rect(clipRect);
        this.contentInsets = new Rect(contentInsets);
        this.prefixOrderIndex = prefixOrderIndex;
        this.position = position == null ? new Point() : new Point(position);
        this.localBounds = new Rect(localBounds);
        this.sourceContainerBounds = new Rect(screenSpaceBounds);
        this.screenSpaceBounds = new Rect(screenSpaceBounds);
        this.windowConfiguration = windowConfig;
        this.isNotInRecents = isNotInRecents;
        this.startLeash = startLeash;
        this.taskInfo = taskInfo;
        this.allowEnterPip = allowEnterPip;
        this.windowType = windowType;
        if (startBounds == null) {
            rect = new Rect(screenSpaceBounds);
        } else {
            rect = new Rect(startBounds);
        }
        this.startBounds = rect;
    }

    public RemoteAnimationTarget(Parcel in) {
        this.mExt = (IRemoteAnimationTargetExt) ExtLoader.type(IRemoteAnimationTargetExt.class).base(this).create();
        this.taskId = in.readInt();
        this.mode = in.readInt();
        SurfaceControl surfaceControl = (SurfaceControl) in.readTypedObject(SurfaceControl.CREATOR);
        this.leash = surfaceControl;
        if (surfaceControl != null) {
            surfaceControl.setUnreleasedWarningCallSite("RemoteAnimationTarget[leash]");
        }
        this.isTranslucent = in.readBoolean();
        this.clipRect = (Rect) in.readTypedObject(Rect.CREATOR);
        this.contentInsets = (Rect) in.readTypedObject(Rect.CREATOR);
        this.prefixOrderIndex = in.readInt();
        this.position = (Point) in.readTypedObject(Point.CREATOR);
        this.localBounds = (Rect) in.readTypedObject(Rect.CREATOR);
        this.sourceContainerBounds = (Rect) in.readTypedObject(Rect.CREATOR);
        this.screenSpaceBounds = (Rect) in.readTypedObject(Rect.CREATOR);
        this.windowConfiguration = (WindowConfiguration) in.readTypedObject(WindowConfiguration.CREATOR);
        this.isNotInRecents = in.readBoolean();
        SurfaceControl surfaceControl2 = (SurfaceControl) in.readTypedObject(SurfaceControl.CREATOR);
        this.startLeash = surfaceControl2;
        if (surfaceControl2 != null) {
            surfaceControl2.setUnreleasedWarningCallSite("RemoteAnimationTarget[startLeash]");
        }
        this.startBounds = (Rect) in.readTypedObject(Rect.CREATOR);
        this.taskInfo = (ActivityManager.RunningTaskInfo) in.readTypedObject(ActivityManager.RunningTaskInfo.CREATOR);
        this.allowEnterPip = in.readBoolean();
        this.windowType = in.readInt();
        this.hasAnimatingParent = in.readBoolean();
        this.backgroundColor = in.readInt();
        this.showBackdrop = in.readBoolean();
        this.willShowImeOnTarget = in.readBoolean();
        this.rotationChange = in.readInt();
        this.mExt.readFromParcel(in);
    }

    public void setShowBackdrop(boolean shouldShowBackdrop) {
        this.showBackdrop = shouldShowBackdrop;
    }

    public void setWillShowImeOnTarget(boolean showImeOnTarget) {
        this.willShowImeOnTarget = showImeOnTarget;
    }

    public boolean willShowImeOnTarget() {
        return this.willShowImeOnTarget;
    }

    public void setRotationChange(int rotationChange) {
        this.rotationChange = rotationChange;
    }

    public int getRotationChange() {
        return this.rotationChange;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.taskId);
        dest.writeInt(this.mode);
        dest.writeTypedObject(this.leash, 0);
        dest.writeBoolean(this.isTranslucent);
        dest.writeTypedObject(this.clipRect, 0);
        dest.writeTypedObject(this.contentInsets, 0);
        dest.writeInt(this.prefixOrderIndex);
        dest.writeTypedObject(this.position, 0);
        dest.writeTypedObject(this.localBounds, 0);
        dest.writeTypedObject(this.sourceContainerBounds, 0);
        dest.writeTypedObject(this.screenSpaceBounds, 0);
        dest.writeTypedObject(this.windowConfiguration, 0);
        dest.writeBoolean(this.isNotInRecents);
        dest.writeTypedObject(this.startLeash, 0);
        dest.writeTypedObject(this.startBounds, 0);
        dest.writeTypedObject(this.taskInfo, 0);
        dest.writeBoolean(this.allowEnterPip);
        dest.writeInt(this.windowType);
        dest.writeBoolean(this.hasAnimatingParent);
        dest.writeInt(this.backgroundColor);
        dest.writeBoolean(this.showBackdrop);
        dest.writeBoolean(this.willShowImeOnTarget);
        dest.writeInt(this.rotationChange);
        this.mExt.writeToParcel(dest, flags);
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mode=");
        pw.print(this.mode);
        pw.print(" taskId=");
        pw.print(this.taskId);
        pw.print(" isTranslucent=");
        pw.print(this.isTranslucent);
        pw.print(" clipRect=");
        this.clipRect.printShortString(pw);
        pw.print(" contentInsets=");
        this.contentInsets.printShortString(pw);
        pw.print(" prefixOrderIndex=");
        pw.print(this.prefixOrderIndex);
        pw.print(" position=");
        printPoint(this.position, pw);
        pw.print(" sourceContainerBounds=");
        this.sourceContainerBounds.printShortString(pw);
        pw.print(" screenSpaceBounds=");
        this.screenSpaceBounds.printShortString(pw);
        pw.print(" localBounds=");
        this.localBounds.printShortString(pw);
        pw.println();
        pw.print(prefix);
        pw.print("windowConfiguration=");
        pw.println(this.windowConfiguration);
        pw.print(prefix);
        pw.print("leash=");
        pw.println(this.leash);
        pw.print(prefix);
        pw.print("taskInfo=");
        pw.println(this.taskInfo);
        pw.print(prefix);
        pw.print("allowEnterPip=");
        pw.println(this.allowEnterPip);
        pw.print(prefix);
        pw.print("windowType=");
        pw.println(this.windowType);
        pw.print(prefix);
        pw.print("hasAnimatingParent=");
        pw.println(this.hasAnimatingParent);
        pw.print(prefix);
        pw.print("backgroundColor=");
        pw.println(this.backgroundColor);
        pw.print(prefix);
        pw.print("showBackdrop=");
        pw.println(this.showBackdrop);
        pw.print(prefix);
        pw.print("willShowImeOnTarget=");
        pw.println(this.willShowImeOnTarget);
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, this.taskId);
        proto.write(1120986464258L, this.mode);
        this.leash.dumpDebug(proto, 1146756268035L);
        proto.write(1133871366148L, this.isTranslucent);
        this.clipRect.dumpDebug(proto, 1146756268037L);
        this.contentInsets.dumpDebug(proto, 1146756268038L);
        proto.write(1120986464263L, this.prefixOrderIndex);
        GraphicsProtos.dumpPointProto(this.position, proto, 1146756268040L);
        this.sourceContainerBounds.dumpDebug(proto, 1146756268041L);
        this.screenSpaceBounds.dumpDebug(proto, RemoteAnimationTargetProto.SCREEN_SPACE_BOUNDS);
        this.localBounds.dumpDebug(proto, RemoteAnimationTargetProto.LOCAL_BOUNDS);
        this.windowConfiguration.dumpDebug(proto, 1146756268042L);
        SurfaceControl surfaceControl = this.startLeash;
        if (surfaceControl != null) {
            surfaceControl.dumpDebug(proto, 1146756268043L);
        }
        this.startBounds.dumpDebug(proto, RemoteAnimationTargetProto.START_BOUNDS);
        proto.end(token);
    }

    private static void printPoint(Point p10, PrintWriter pw) {
        pw.print("[");
        pw.print(p10.x);
        pw.print(",");
        pw.print(p10.y);
        pw.print("]");
    }
}
