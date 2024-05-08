package android.window;

import android.app.ActivityManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.WindowManager;
import com.alipay.sdk.util.i;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.List;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TransitionInfo implements Parcelable {
    public static final Parcelable.Creator<TransitionInfo> CREATOR = new Parcelable.Creator<TransitionInfo>() { // from class: android.window.TransitionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransitionInfo createFromParcel(Parcel in) {
            return new TransitionInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TransitionInfo[] newArray(int size) {
            return new TransitionInfo[size];
        }
    };
    public static final int FLAGS_IS_NON_APP_WINDOW = 65794;
    public static final int FLAG_BACK_GESTURE_ANIMATED = 131072;
    public static final int FLAG_CROSS_PROFILE_OWNER_THUMBNAIL = 4096;
    public static final int FLAG_CROSS_PROFILE_WORK_THUMBNAIL = 8192;
    public static final int FLAG_DISPLAY_HAS_ALERT_WINDOWS = 128;
    public static final int FLAG_FILLS_TASK = 1024;
    public static final int FLAG_FIRST_CUSTOM = 4194304;
    public static final int FLAG_IN_TASK_WITH_EMBEDDED_ACTIVITY = 512;
    public static final int FLAG_IS_BEHIND_STARTING_WINDOW = 16384;
    public static final int FLAG_IS_DISPLAY = 32;
    public static final int FLAG_IS_INPUT_METHOD = 256;
    public static final int FLAG_IS_OCCLUDED = 32768;
    public static final int FLAG_IS_SYSTEM_WINDOW = 65536;
    public static final int FLAG_IS_VOICE_INTERACTION = 16;
    public static final int FLAG_IS_WALLPAPER = 2;
    public static final int FLAG_MOVED_TO_TOP = 1048576;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_NO_ANIMATION = 262144;
    public static final int FLAG_SHOW_WALLPAPER = 1;
    public static final int FLAG_STARTING_WINDOW_TRANSFER_RECIPIENT = 8;
    public static final int FLAG_SYNC = 2097152;
    public static final int FLAG_TASK_LAUNCHING_BEHIND = 524288;
    public static final int FLAG_TRANSLUCENT = 4;
    public static final int FLAG_WILL_IME_SHOWN = 2048;
    private static final String TAG = "TransitionInfo";
    private final ArrayList<Change> mChanges;
    private int mDebugId;
    public ITransitionInfoExt mExt;
    private int mFlags;
    private AnimationOptions mOptions;
    private final ArrayList<Root> mRoots;
    private int mTrack;
    private final int mType;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface ChangeFlags {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface TransitionMode {
    }

    public TransitionInfo(int type, int flags) {
        this.mTrack = 0;
        this.mChanges = new ArrayList<>();
        this.mRoots = new ArrayList<>();
        this.mDebugId = -1;
        ITransitionInfoExt iTransitionInfoExt = (ITransitionInfoExt) ExtLoader.type(ITransitionInfoExt.class).base(this).create();
        this.mExt = iTransitionInfoExt;
        this.mType = type;
        this.mFlags = flags;
        iTransitionInfoExt.setExtendedInfo(new OplusTransitionExtendedInfo());
    }

    private TransitionInfo(Parcel in) {
        this.mTrack = 0;
        ArrayList<Change> arrayList = new ArrayList<>();
        this.mChanges = arrayList;
        ArrayList<Root> arrayList2 = new ArrayList<>();
        this.mRoots = arrayList2;
        this.mDebugId = -1;
        this.mExt = (ITransitionInfoExt) ExtLoader.type(ITransitionInfoExt.class).base(this).create();
        this.mType = in.readInt();
        this.mFlags = in.readInt();
        in.readTypedList(arrayList, Change.CREATOR);
        in.readTypedList(arrayList2, Root.CREATOR);
        this.mOptions = (AnimationOptions) in.readTypedObject(AnimationOptions.CREATOR);
        this.mDebugId = in.readInt();
        this.mTrack = in.readInt();
        this.mExt.readFromParcel(in);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mType);
        dest.writeInt(this.mFlags);
        dest.writeTypedList(this.mChanges);
        dest.writeTypedList(this.mRoots, flags);
        dest.writeTypedObject(this.mOptions, flags);
        dest.writeInt(this.mDebugId);
        dest.writeInt(this.mTrack);
        this.mExt.writeToParcel(dest, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void addRootLeash(int displayId, SurfaceControl leash, int offsetLeft, int offsetTop) {
        this.mRoots.add(new Root(displayId, leash, offsetLeft, offsetTop));
    }

    public void addRoot(Root other) {
        this.mRoots.add(other);
    }

    public void setAnimationOptions(AnimationOptions options) {
        this.mOptions = options;
    }

    public int getType() {
        return this.mType;
    }

    public void setFlags(int flags) {
        this.mFlags = flags;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public int getRootCount() {
        return this.mRoots.size();
    }

    public Root getRoot(int idx) {
        return this.mRoots.get(idx);
    }

    public int findRootIndex(int displayId) {
        for (int i10 = 0; i10 < this.mRoots.size(); i10++) {
            if (this.mRoots.get(i10).mDisplayId == displayId) {
                return i10;
            }
        }
        return -1;
    }

    @Deprecated
    public SurfaceControl getRootLeash() {
        if (this.mRoots.isEmpty()) {
            throw new IllegalStateException("Trying to get a root leash from a no-op transition.");
        }
        if (this.mRoots.size() > 1) {
            Log.e(TAG, "Assuming one animation root when there are more.", new Throwable());
        }
        return this.mRoots.get(0).mLeash;
    }

    public AnimationOptions getAnimationOptions() {
        return this.mOptions;
    }

    public List<Change> getChanges() {
        return this.mChanges;
    }

    public Change getChange(WindowContainerToken token) {
        for (int i10 = this.mChanges.size() - 1; i10 >= 0; i10--) {
            if (token.equals(this.mChanges.get(i10).mContainer)) {
                return this.mChanges.get(i10);
            }
        }
        return null;
    }

    public void addChange(Change change) {
        this.mChanges.add(change);
    }

    public boolean isKeyguardGoingAway() {
        return (this.mFlags & 256) != 0;
    }

    public int getTrack() {
        return this.mTrack;
    }

    public void setTrack(int track) {
        this.mTrack = track;
    }

    public void setDebugId(int id2) {
        this.mDebugId = id2;
    }

    public int getDebugId() {
        return this.mDebugId;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{id=").append(this.mDebugId).append(" t=").append(WindowManager.transitTypeToString(this.mType)).append(" f=0x").append(Integer.toHexString(this.mFlags)).append(" trk=").append(this.mTrack).append(" r=[");
        for (int i10 = 0; i10 < this.mRoots.size(); i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            sb2.append(this.mRoots.get(i10).mDisplayId).append("@").append((Object) this.mRoots.get(i10).mOffset);
        }
        sb2.append("] c=[");
        for (int i11 = 0; i11 < this.mChanges.size(); i11++) {
            if (i11 > 0) {
                sb2.append(',');
            }
            sb2.append((Object) this.mChanges.get(i11));
        }
        sb2.append("]}");
        return sb2.toString();
    }

    public static String modeToString(int mode) {
        switch (mode) {
            case 0:
                return "NONE";
            case 1:
                return "OPEN";
            case 2:
                return "CLOSE";
            case 3:
                return "TO_FRONT";
            case 4:
                return "TO_BACK";
            case 5:
            default:
                return "<unknown:" + mode + ">";
            case 6:
                return "CHANGE";
        }
    }

    public static String flagsToString(int flags) {
        if (flags == 0) {
            return "NONE";
        }
        StringBuilder sb2 = new StringBuilder();
        if ((flags & 1) != 0) {
            sb2.append("SHOW_WALLPAPER");
        }
        if ((flags & 2) != 0) {
            sb2.append("IS_WALLPAPER");
        }
        if ((flags & 256) != 0) {
            sb2.append("IS_INPUT_METHOD");
        }
        if ((flags & 4) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("TRANSLUCENT");
        }
        if ((flags & 8) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("STARTING_WINDOW_TRANSFER");
        }
        if ((flags & 16) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("IS_VOICE_INTERACTION");
        }
        if ((flags & 32) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("IS_DISPLAY");
        }
        if ((flags & 128) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("DISPLAY_HAS_ALERT_WINDOWS");
        }
        if ((flags & 512) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("IN_TASK_WITH_EMBEDDED_ACTIVITY");
        }
        if ((flags & 1024) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("FILLS_TASK");
        }
        if ((flags & 16384) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("IS_BEHIND_STARTING_WINDOW");
        }
        if ((32768 & flags) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("IS_OCCLUDED");
        }
        if ((65536 & flags) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("FLAG_IS_SYSTEM_WINDOW");
        }
        if ((131072 & flags) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("FLAG_BACK_GESTURE_ANIMATED");
        }
        if ((262144 & flags) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("NO_ANIMATION");
        }
        if ((524288 & flags) != 0) {
            sb2.append((sb2.length() == 0 ? "" : "|") + "TASK_LAUNCHING_BEHIND");
        }
        if ((2097152 & flags) != 0) {
            sb2.append((sb2.length() == 0 ? "" : "|") + "SYNC");
        }
        if ((4194304 & flags) != 0) {
            sb2.append(sb2.length() == 0 ? "" : "|").append("FIRST_CUSTOM");
        }
        if ((1048576 & flags) != 0) {
            sb2.append(sb2.length() != 0 ? "|" : "").append("MOVE_TO_TOP");
        }
        return sb2.toString();
    }

    public static boolean isIndependent(Change change, TransitionInfo info) {
        if (change.getParent() == null) {
            return true;
        }
        if (change.getMode() == 6) {
            return false;
        }
        Change parentChg = info.getChange(change.getParent());
        while (parentChg != null && parentChg.getMode() == 6) {
            if (parentChg.getParent() == null) {
                return true;
            }
            parentChg = info.getChange(parentChg.getParent());
        }
        return false;
    }

    public void releaseAnimSurfaces() {
        for (int i10 = this.mChanges.size() - 1; i10 >= 0; i10--) {
            Change c4 = this.mChanges.get(i10);
            if (c4.mSnapshot != null) {
                c4.mSnapshot.release();
                c4.mSnapshot = null;
            }
        }
        for (int i11 = 0; i11 < this.mRoots.size(); i11++) {
            this.mRoots.get(i11).mLeash.release();
        }
    }

    public void releaseAllSurfaces() {
        releaseAnimSurfaces();
        for (int i10 = this.mChanges.size() - 1; i10 >= 0; i10--) {
            this.mChanges.get(i10).getLeash().release();
        }
    }

    public void setUnreleasedWarningCallSiteForAllSurfaces(String callsite) {
        for (int i10 = this.mChanges.size() - 1; i10 >= 0; i10--) {
            this.mChanges.get(i10).getLeash().setUnreleasedWarningCallSite(callsite);
        }
    }

    public TransitionInfo localRemoteCopy() {
        TransitionInfo out = new TransitionInfo(this.mType, this.mFlags);
        out.mTrack = this.mTrack;
        out.mDebugId = this.mDebugId;
        for (int i10 = 0; i10 < this.mChanges.size(); i10++) {
            out.mChanges.add(this.mChanges.get(i10).localRemoteCopy());
        }
        for (int i11 = 0; i11 < this.mRoots.size(); i11++) {
            out.mRoots.add(this.mRoots.get(i11).localRemoteCopy());
        }
        out.mOptions = this.mOptions;
        return out;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Change implements Parcelable {
        public static final Parcelable.Creator<Change> CREATOR = new Parcelable.Creator<Change>() { // from class: android.window.TransitionInfo.Change.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Change createFromParcel(Parcel in) {
                return new Change(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Change[] newArray(int size) {
                return new Change[size];
            }
        };
        private boolean mAllowEnterPip;
        private int mBackgroundColor;
        private final WindowContainerToken mContainer;
        private final Rect mEndAbsBounds;
        private int mEndDisplayId;
        private int mEndFixedRotation;
        private final Point mEndRelOffset;
        private int mEndRotation;
        private int mFlags;
        private WindowContainerToken mLastParent;
        private final SurfaceControl mLeash;
        private int mMode;
        private WindowContainerToken mParent;
        public Bundle mPriBundle;
        private int mRotationAnimation;
        private SurfaceControl mSnapshot;
        private float mSnapshotLuma;
        private final Rect mStartAbsBounds;
        private int mStartDisplayId;
        private int mStartRotation;
        public Bundle mSubScenarioBundle;
        private ActivityManager.RunningTaskInfo mTaskInfo;

        public Change(WindowContainerToken container, SurfaceControl leash) {
            this.mPriBundle = new Bundle();
            this.mSubScenarioBundle = new Bundle();
            this.mMode = 0;
            this.mFlags = 0;
            this.mStartAbsBounds = new Rect();
            this.mEndAbsBounds = new Rect();
            this.mEndRelOffset = new Point();
            this.mTaskInfo = null;
            this.mStartDisplayId = -1;
            this.mEndDisplayId = -1;
            this.mStartRotation = -1;
            this.mEndRotation = -1;
            this.mEndFixedRotation = -1;
            this.mRotationAnimation = -1;
            this.mSnapshot = null;
            this.mContainer = container;
            this.mLeash = leash;
        }

        private Change(Parcel in) {
            this.mPriBundle = new Bundle();
            this.mSubScenarioBundle = new Bundle();
            this.mMode = 0;
            this.mFlags = 0;
            Rect rect = new Rect();
            this.mStartAbsBounds = rect;
            Rect rect2 = new Rect();
            this.mEndAbsBounds = rect2;
            Point point = new Point();
            this.mEndRelOffset = point;
            this.mTaskInfo = null;
            this.mStartDisplayId = -1;
            this.mEndDisplayId = -1;
            this.mStartRotation = -1;
            this.mEndRotation = -1;
            this.mEndFixedRotation = -1;
            this.mRotationAnimation = -1;
            this.mSnapshot = null;
            this.mContainer = (WindowContainerToken) in.readTypedObject(WindowContainerToken.CREATOR);
            this.mParent = (WindowContainerToken) in.readTypedObject(WindowContainerToken.CREATOR);
            this.mLastParent = (WindowContainerToken) in.readTypedObject(WindowContainerToken.CREATOR);
            SurfaceControl surfaceControl = new SurfaceControl();
            this.mLeash = surfaceControl;
            surfaceControl.readFromParcel(in);
            this.mMode = in.readInt();
            this.mFlags = in.readInt();
            rect.readFromParcel(in);
            rect2.readFromParcel(in);
            point.readFromParcel(in);
            this.mTaskInfo = (ActivityManager.RunningTaskInfo) in.readTypedObject(ActivityManager.RunningTaskInfo.CREATOR);
            this.mAllowEnterPip = in.readBoolean();
            this.mStartDisplayId = in.readInt();
            this.mEndDisplayId = in.readInt();
            this.mStartRotation = in.readInt();
            this.mEndRotation = in.readInt();
            this.mEndFixedRotation = in.readInt();
            this.mRotationAnimation = in.readInt();
            this.mBackgroundColor = in.readInt();
            this.mSnapshot = (SurfaceControl) in.readTypedObject(SurfaceControl.CREATOR);
            this.mSnapshotLuma = in.readFloat();
            this.mPriBundle = in.readBundle();
            this.mSubScenarioBundle = in.readBundle();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Change localRemoteCopy() {
            Change out = new Change(this.mContainer, new SurfaceControl(this.mLeash, "localRemote"));
            out.mParent = this.mParent;
            out.mLastParent = this.mLastParent;
            out.mMode = this.mMode;
            out.mFlags = this.mFlags;
            out.mStartAbsBounds.set(this.mStartAbsBounds);
            out.mEndAbsBounds.set(this.mEndAbsBounds);
            out.mEndRelOffset.set(this.mEndRelOffset);
            out.mTaskInfo = this.mTaskInfo;
            out.mAllowEnterPip = this.mAllowEnterPip;
            out.mStartDisplayId = this.mStartDisplayId;
            out.mEndDisplayId = this.mEndDisplayId;
            out.mStartRotation = this.mStartRotation;
            out.mEndRotation = this.mEndRotation;
            out.mEndFixedRotation = this.mEndFixedRotation;
            out.mRotationAnimation = this.mRotationAnimation;
            out.mBackgroundColor = this.mBackgroundColor;
            out.mSnapshot = this.mSnapshot != null ? new SurfaceControl(this.mSnapshot, "localRemote") : null;
            out.mSnapshotLuma = this.mSnapshotLuma;
            out.mPriBundle = this.mPriBundle;
            out.mSubScenarioBundle = this.mSubScenarioBundle;
            return out;
        }

        public void setParent(WindowContainerToken parent) {
            this.mParent = parent;
        }

        public void setLastParent(WindowContainerToken lastParent) {
            this.mLastParent = lastParent;
        }

        public void setMode(int mode) {
            this.mMode = mode;
        }

        public void setFlags(int flags) {
            this.mFlags = flags;
        }

        public void setStartAbsBounds(Rect rect) {
            this.mStartAbsBounds.set(rect);
        }

        public void setEndAbsBounds(Rect rect) {
            this.mEndAbsBounds.set(rect);
        }

        public void setEndRelOffset(int left, int top) {
            this.mEndRelOffset.set(left, top);
        }

        public void setTaskInfo(ActivityManager.RunningTaskInfo taskInfo) {
            this.mTaskInfo = taskInfo;
        }

        public void setAllowEnterPip(boolean allowEnterPip) {
            this.mAllowEnterPip = allowEnterPip;
        }

        public void setDisplayId(int start, int end) {
            this.mStartDisplayId = start;
            this.mEndDisplayId = end;
        }

        public void setRotation(int start, int end) {
            this.mStartRotation = start;
            this.mEndRotation = end;
        }

        public void setEndFixedRotation(int endFixedRotation) {
            this.mEndFixedRotation = endFixedRotation;
        }

        public void setRotationAnimation(int anim) {
            this.mRotationAnimation = anim;
        }

        public void setBackgroundColor(int backgroundColor) {
            this.mBackgroundColor = backgroundColor;
        }

        public void setSnapshot(SurfaceControl snapshot, float luma) {
            this.mSnapshot = snapshot;
            this.mSnapshotLuma = luma;
        }

        public WindowContainerToken getContainer() {
            return this.mContainer;
        }

        public WindowContainerToken getParent() {
            return this.mParent;
        }

        public WindowContainerToken getLastParent() {
            return this.mLastParent;
        }

        public int getMode() {
            return this.mMode;
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean hasFlags(int flags) {
            return (this.mFlags & flags) != 0;
        }

        public boolean hasAllFlags(int flags) {
            return (this.mFlags & flags) == flags;
        }

        public Rect getStartAbsBounds() {
            return this.mStartAbsBounds;
        }

        public Rect getEndAbsBounds() {
            return this.mEndAbsBounds;
        }

        public Point getEndRelOffset() {
            return this.mEndRelOffset;
        }

        public SurfaceControl getLeash() {
            return this.mLeash;
        }

        public ActivityManager.RunningTaskInfo getTaskInfo() {
            return this.mTaskInfo;
        }

        public boolean getAllowEnterPip() {
            return this.mAllowEnterPip;
        }

        public int getStartDisplayId() {
            return this.mStartDisplayId;
        }

        public int getEndDisplayId() {
            return this.mEndDisplayId;
        }

        public int getStartRotation() {
            return this.mStartRotation;
        }

        public int getEndRotation() {
            return this.mEndRotation;
        }

        public int getEndFixedRotation() {
            return this.mEndFixedRotation;
        }

        public int getRotationAnimation() {
            return this.mRotationAnimation;
        }

        public int getBackgroundColor() {
            return this.mBackgroundColor;
        }

        public SurfaceControl getSnapshot() {
            return this.mSnapshot;
        }

        public float getSnapshotLuma() {
            return this.mSnapshotLuma;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeTypedObject(this.mContainer, flags);
            dest.writeTypedObject(this.mParent, flags);
            dest.writeTypedObject(this.mLastParent, flags);
            this.mLeash.writeToParcel(dest, flags);
            dest.writeInt(this.mMode);
            dest.writeInt(this.mFlags);
            this.mStartAbsBounds.writeToParcel(dest, flags);
            this.mEndAbsBounds.writeToParcel(dest, flags);
            this.mEndRelOffset.writeToParcel(dest, flags);
            dest.writeTypedObject(this.mTaskInfo, flags);
            dest.writeBoolean(this.mAllowEnterPip);
            dest.writeInt(this.mStartDisplayId);
            dest.writeInt(this.mEndDisplayId);
            dest.writeInt(this.mStartRotation);
            dest.writeInt(this.mEndRotation);
            dest.writeInt(this.mEndFixedRotation);
            dest.writeInt(this.mRotationAnimation);
            dest.writeInt(this.mBackgroundColor);
            dest.writeTypedObject(this.mSnapshot, flags);
            dest.writeFloat(this.mSnapshotLuma);
            dest.writeBundle(this.mPriBundle);
            dest.writeBundle(this.mSubScenarioBundle);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('{');
            sb2.append((Object) this.mContainer);
            sb2.append(" m=");
            sb2.append(TransitionInfo.modeToString(this.mMode));
            sb2.append(" f=");
            sb2.append(TransitionInfo.flagsToString(this.mFlags));
            if (this.mParent != null) {
                sb2.append(" p=");
                sb2.append((Object) this.mParent);
            }
            if (this.mLeash != null) {
                sb2.append(" leash=");
                sb2.append((Object) this.mLeash);
            }
            sb2.append(" sb=");
            sb2.append((Object) this.mStartAbsBounds);
            sb2.append(" eb=");
            sb2.append((Object) this.mEndAbsBounds);
            if (this.mEndRelOffset.x != 0 || this.mEndRelOffset.y != 0) {
                sb2.append(" eo=");
                sb2.append((Object) this.mEndRelOffset);
            }
            sb2.append(" d=");
            int i10 = this.mStartDisplayId;
            if (i10 != this.mEndDisplayId) {
                sb2.append(i10).append("->");
            }
            sb2.append(this.mEndDisplayId);
            if (this.mStartRotation != this.mEndRotation) {
                sb2.append(" r=");
                sb2.append(this.mStartRotation);
                sb2.append("->");
                sb2.append(this.mEndRotation);
                sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
                sb2.append(this.mRotationAnimation);
            }
            if (this.mEndFixedRotation != -1) {
                sb2.append(" endFixedRotation=");
                sb2.append(this.mEndFixedRotation);
            }
            if (this.mSnapshot != null) {
                sb2.append(" snapshot=");
                sb2.append((Object) this.mSnapshot);
            }
            if (this.mLastParent != null) {
                sb2.append(" lastParent=");
                sb2.append((Object) this.mLastParent);
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class AnimationOptions implements Parcelable {
        public static final Parcelable.Creator<AnimationOptions> CREATOR = new Parcelable.Creator<AnimationOptions>() { // from class: android.window.TransitionInfo.AnimationOptions.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AnimationOptions createFromParcel(Parcel in) {
                return new AnimationOptions(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AnimationOptions[] newArray(int size) {
                return new AnimationOptions[size];
            }
        };
        private int mAnimations;
        private int mBackgroundColor;
        private CustomActivityTransition mCustomActivityCloseTransition;
        private CustomActivityTransition mCustomActivityOpenTransition;
        private int mEnterResId;
        private int mExitResId;
        private boolean mOverrideTaskTransition;
        private String mPackageName;
        private HardwareBuffer mThumbnail;
        private final Rect mTransitionBounds;
        private int mType;

        private AnimationOptions(int type) {
            this.mTransitionBounds = new Rect();
            this.mType = type;
        }

        public AnimationOptions(Parcel in) {
            Rect rect = new Rect();
            this.mTransitionBounds = rect;
            this.mType = in.readInt();
            this.mEnterResId = in.readInt();
            this.mExitResId = in.readInt();
            this.mBackgroundColor = in.readInt();
            this.mOverrideTaskTransition = in.readBoolean();
            this.mPackageName = in.readString();
            rect.readFromParcel(in);
            this.mThumbnail = (HardwareBuffer) in.readTypedObject(HardwareBuffer.CREATOR);
            this.mAnimations = in.readInt();
            this.mCustomActivityOpenTransition = (CustomActivityTransition) in.readTypedObject(CustomActivityTransition.CREATOR);
            this.mCustomActivityCloseTransition = (CustomActivityTransition) in.readTypedObject(CustomActivityTransition.CREATOR);
        }

        public static AnimationOptions makeCommonAnimOptions(String packageName) {
            AnimationOptions options = new AnimationOptions(14);
            options.mPackageName = packageName;
            return options;
        }

        public static AnimationOptions makeAnimOptionsFromLayoutParameters(WindowManager.LayoutParams lp) {
            AnimationOptions options = new AnimationOptions(14);
            options.mPackageName = lp.packageName;
            options.mAnimations = lp.windowAnimations;
            return options;
        }

        public void addOptionsFromLayoutParameters(WindowManager.LayoutParams lp) {
            this.mAnimations = lp.windowAnimations;
        }

        public void addCustomActivityTransition(boolean isOpen, int enterResId, int exitResId, int backgroundColor) {
            CustomActivityTransition customTransition = isOpen ? this.mCustomActivityOpenTransition : this.mCustomActivityCloseTransition;
            if (customTransition == null) {
                customTransition = new CustomActivityTransition();
                if (isOpen) {
                    this.mCustomActivityOpenTransition = customTransition;
                } else {
                    this.mCustomActivityCloseTransition = customTransition;
                }
            }
            customTransition.addCustomActivityTransition(enterResId, exitResId, backgroundColor);
        }

        public static AnimationOptions makeCustomAnimOptions(String packageName, int enterResId, int exitResId, int backgroundColor, boolean overrideTaskTransition) {
            AnimationOptions options = new AnimationOptions(1);
            options.mPackageName = packageName;
            options.mEnterResId = enterResId;
            options.mExitResId = exitResId;
            options.mBackgroundColor = backgroundColor;
            options.mOverrideTaskTransition = overrideTaskTransition;
            return options;
        }

        public static AnimationOptions makeClipRevealAnimOptions(int startX, int startY, int width, int height) {
            AnimationOptions options = new AnimationOptions(11);
            options.mTransitionBounds.set(startX, startY, startX + width, startY + height);
            return options;
        }

        public static AnimationOptions makeScaleUpAnimOptions(int startX, int startY, int width, int height) {
            AnimationOptions options = new AnimationOptions(2);
            options.mTransitionBounds.set(startX, startY, startX + width, startY + height);
            return options;
        }

        public static AnimationOptions makeThumbnailAnimOptions(HardwareBuffer srcThumb, int startX, int startY, boolean scaleUp) {
            AnimationOptions options = new AnimationOptions(scaleUp ? 3 : 4);
            options.mTransitionBounds.set(startX, startY, startX, startY);
            options.mThumbnail = srcThumb;
            return options;
        }

        public static AnimationOptions makeCrossProfileAnimOptions() {
            AnimationOptions options = new AnimationOptions(12);
            return options;
        }

        public static AnimationOptions makeSceneTransitionAnimOptions() {
            AnimationOptions options = new AnimationOptions(5);
            return options;
        }

        public int getType() {
            return this.mType;
        }

        public int getEnterResId() {
            return this.mEnterResId;
        }

        public int getExitResId() {
            return this.mExitResId;
        }

        public int getBackgroundColor() {
            return this.mBackgroundColor;
        }

        public boolean getOverrideTaskTransition() {
            return this.mOverrideTaskTransition;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public Rect getTransitionBounds() {
            return this.mTransitionBounds;
        }

        public HardwareBuffer getThumbnail() {
            return this.mThumbnail;
        }

        public int getAnimations() {
            return this.mAnimations;
        }

        public CustomActivityTransition getCustomActivityTransition(boolean open) {
            return open ? this.mCustomActivityOpenTransition : this.mCustomActivityCloseTransition;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mType);
            dest.writeInt(this.mEnterResId);
            dest.writeInt(this.mExitResId);
            dest.writeInt(this.mBackgroundColor);
            dest.writeBoolean(this.mOverrideTaskTransition);
            dest.writeString(this.mPackageName);
            this.mTransitionBounds.writeToParcel(dest, flags);
            dest.writeTypedObject(this.mThumbnail, flags);
            dest.writeInt(this.mAnimations);
            dest.writeTypedObject(this.mCustomActivityOpenTransition, flags);
            dest.writeTypedObject(this.mCustomActivityCloseTransition, flags);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private static String typeToString(int mode) {
            switch (mode) {
                case 1:
                    return "ANIM_CUSTOM";
                case 2:
                    return "ANIM_SCALE_UP";
                case 3:
                    return "ANIM_THUMBNAIL_SCALE_UP";
                case 4:
                    return "ANIM_THUMBNAIL_SCALE_DOWN";
                case 11:
                    return "ANIM_CLIP_REVEAL";
                case 12:
                    return "ANIM_OPEN_CROSS_PROFILE_APPS";
                default:
                    return "<unknown:" + mode + ">";
            }
        }

        public String toString() {
            return "{ AnimationOptions type= " + typeToString(this.mType) + " package=" + this.mPackageName + " override=" + this.mOverrideTaskTransition + " b=" + ((Object) this.mTransitionBounds) + i.f4738d;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public static class CustomActivityTransition implements Parcelable {
            public static final Parcelable.Creator<CustomActivityTransition> CREATOR = new Parcelable.Creator<CustomActivityTransition>() { // from class: android.window.TransitionInfo.AnimationOptions.CustomActivityTransition.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public CustomActivityTransition createFromParcel(Parcel in) {
                    return new CustomActivityTransition(in);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public CustomActivityTransition[] newArray(int size) {
                    return new CustomActivityTransition[size];
                }
            };
            private int mCustomBackgroundColor;
            private int mCustomEnterResId;
            private int mCustomExitResId;

            public int getCustomEnterResId() {
                return this.mCustomEnterResId;
            }

            public int getCustomExitResId() {
                return this.mCustomExitResId;
            }

            public int getCustomBackgroundColor() {
                return this.mCustomBackgroundColor;
            }

            CustomActivityTransition() {
            }

            CustomActivityTransition(Parcel in) {
                this.mCustomEnterResId = in.readInt();
                this.mCustomExitResId = in.readInt();
                this.mCustomBackgroundColor = in.readInt();
            }

            public void addCustomActivityTransition(int enterResId, int exitResId, int backgroundColor) {
                this.mCustomEnterResId = enterResId;
                this.mCustomExitResId = exitResId;
                this.mCustomBackgroundColor = backgroundColor;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.mCustomEnterResId);
                dest.writeInt(this.mCustomExitResId);
                dest.writeInt(this.mCustomBackgroundColor);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Root implements Parcelable {
        public static final Parcelable.Creator<Root> CREATOR = new Parcelable.Creator<Root>() { // from class: android.window.TransitionInfo.Root.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Root createFromParcel(Parcel in) {
                return new Root(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Root[] newArray(int size) {
                return new Root[size];
            }
        };
        private final int mDisplayId;
        private final SurfaceControl mLeash;
        private final Point mOffset;

        public Root(int displayId, SurfaceControl leash, int offsetLeft, int offsetTop) {
            Point point = new Point();
            this.mOffset = point;
            this.mDisplayId = displayId;
            this.mLeash = leash;
            point.set(offsetLeft, offsetTop);
        }

        private Root(Parcel in) {
            Point point = new Point();
            this.mOffset = point;
            this.mDisplayId = in.readInt();
            SurfaceControl surfaceControl = new SurfaceControl();
            this.mLeash = surfaceControl;
            surfaceControl.readFromParcel(in);
            surfaceControl.setUnreleasedWarningCallSite("TransitionInfo.Root");
            point.readFromParcel(in);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Root localRemoteCopy() {
            return new Root(this.mDisplayId, new SurfaceControl(this.mLeash, "localRemote"), this.mOffset.x, this.mOffset.y);
        }

        public int getDisplayId() {
            return this.mDisplayId;
        }

        public SurfaceControl getLeash() {
            return this.mLeash;
        }

        public Point getOffset() {
            return this.mOffset;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mDisplayId);
            this.mLeash.writeToParcel(dest, flags);
            this.mOffset.writeToParcel(dest, flags);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return this.mDisplayId + "@" + ((Object) this.mOffset) + u.bD + ((Object) this.mLeash);
        }
    }
}
