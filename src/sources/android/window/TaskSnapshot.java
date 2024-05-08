package android.window;

import android.content.ComponentName;
import android.graphics.ColorSpace;
import android.graphics.GraphicBuffer;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Slog;
import com.android.internal.protolog.ProtoLogGroup;
import sun.util.locale.LanguageTag;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class TaskSnapshot implements Parcelable {
    public static final Parcelable.Creator<TaskSnapshot> CREATOR = new Parcelable.Creator<TaskSnapshot>() { // from class: android.window.TaskSnapshot.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskSnapshot createFromParcel(Parcel source) {
            return new TaskSnapshot(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskSnapshot[] newArray(int size) {
            return new TaskSnapshot[size];
        }
    };
    private static final String TAG = "TaskSnapshot";
    private final int mAppearance;
    private final long mCaptureTime;
    private final ColorSpace mColorSpace;
    private final Rect mContentInsets;
    private final boolean mHasImeSurface;
    private final long mId;
    private final boolean mIsLowResolution;
    private final boolean mIsRealSnapshot;
    private final boolean mIsTranslucent;
    private final Rect mLetterboxInsets;
    private final int mOrientation;
    private final int mRotation;
    private final HardwareBuffer mSnapshot;
    private final Point mTaskSize;
    private final ComponentName mTopActivityComponent;
    private final int mWindowingMode;

    public TaskSnapshot(long id2, long captureTime, ComponentName topActivityComponent, HardwareBuffer snapshot, ColorSpace colorSpace, int orientation, int rotation, Point taskSize, Rect contentInsets, Rect letterboxInsets, boolean isLowResolution, boolean isRealSnapshot, int windowingMode, int appearance, boolean isTranslucent, boolean hasImeSurface) {
        this.mId = id2;
        this.mCaptureTime = captureTime;
        this.mTopActivityComponent = topActivityComponent;
        this.mSnapshot = snapshot;
        this.mColorSpace = colorSpace.getId() < 0 ? ColorSpace.get(ColorSpace.Named.SRGB) : colorSpace;
        this.mOrientation = orientation;
        this.mRotation = rotation;
        this.mTaskSize = new Point(taskSize);
        this.mContentInsets = new Rect(contentInsets);
        this.mLetterboxInsets = new Rect(letterboxInsets);
        this.mIsLowResolution = isLowResolution;
        this.mIsRealSnapshot = isRealSnapshot;
        this.mWindowingMode = windowingMode;
        this.mAppearance = appearance;
        this.mIsTranslucent = isTranslucent;
        this.mHasImeSurface = hasImeSurface;
    }

    private TaskSnapshot(Parcel source) {
        ColorSpace colorSpace;
        this.mId = source.readLong();
        this.mCaptureTime = SystemClock.elapsedRealtimeNanos();
        this.mTopActivityComponent = ComponentName.readFromParcel(source);
        this.mSnapshot = (HardwareBuffer) source.readTypedObject(HardwareBuffer.CREATOR);
        int colorSpaceId = source.readInt();
        if (colorSpaceId >= 0 && colorSpaceId < ColorSpace.Named.values().length) {
            colorSpace = ColorSpace.get(ColorSpace.Named.values()[colorSpaceId]);
        } else {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        this.mColorSpace = colorSpace;
        this.mOrientation = source.readInt();
        this.mRotation = source.readInt();
        this.mTaskSize = (Point) source.readTypedObject(Point.CREATOR);
        this.mContentInsets = (Rect) source.readTypedObject(Rect.CREATOR);
        this.mLetterboxInsets = (Rect) source.readTypedObject(Rect.CREATOR);
        this.mIsLowResolution = source.readBoolean();
        this.mIsRealSnapshot = source.readBoolean();
        this.mWindowingMode = source.readInt();
        this.mAppearance = source.readInt();
        this.mIsTranslucent = source.readBoolean();
        this.mHasImeSurface = source.readBoolean();
    }

    public long getId() {
        return this.mId;
    }

    public long getCaptureTime() {
        return this.mCaptureTime;
    }

    public ComponentName getTopActivityComponent() {
        return this.mTopActivityComponent;
    }

    public GraphicBuffer getSnapshot() {
        return GraphicBuffer.createFromHardwareBuffer(this.mSnapshot);
    }

    public HardwareBuffer getHardwareBuffer() {
        return this.mSnapshot;
    }

    public ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public Point getTaskSize() {
        return this.mTaskSize;
    }

    public Rect getContentInsets() {
        return this.mContentInsets;
    }

    public Rect getLetterboxInsets() {
        return this.mLetterboxInsets;
    }

    public boolean isLowResolution() {
        return this.mIsLowResolution;
    }

    public boolean isRealSnapshot() {
        return this.mIsRealSnapshot;
    }

    public boolean isTranslucent() {
        return this.mIsTranslucent;
    }

    public boolean hasImeSurface() {
        return this.mHasImeSurface;
    }

    public int getWindowingMode() {
        return this.mWindowingMode;
    }

    public int getAppearance() {
        return this.mAppearance;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.mId);
        ComponentName.writeToParcel(this.mTopActivityComponent, dest);
        HardwareBuffer hardwareBuffer = this.mSnapshot;
        dest.writeTypedObject((hardwareBuffer == null || hardwareBuffer.isClosed()) ? null : this.mSnapshot, 0);
        dest.writeInt(this.mColorSpace.getId());
        dest.writeInt(this.mOrientation);
        dest.writeInt(this.mRotation);
        dest.writeTypedObject(this.mTaskSize, 0);
        dest.writeTypedObject(this.mContentInsets, 0);
        dest.writeTypedObject(this.mLetterboxInsets, 0);
        dest.writeBoolean(this.mIsLowResolution);
        dest.writeBoolean(this.mIsRealSnapshot);
        dest.writeInt(this.mWindowingMode);
        dest.writeInt(this.mAppearance);
        dest.writeBoolean(this.mIsTranslucent);
        dest.writeBoolean(this.mHasImeSurface);
    }

    public String toString() {
        HardwareBuffer hardwareBuffer = this.mSnapshot;
        int height = 0;
        int width = (hardwareBuffer == null || hardwareBuffer.isClosed()) ? 0 : this.mSnapshot.getWidth();
        HardwareBuffer hardwareBuffer2 = this.mSnapshot;
        if (hardwareBuffer2 != null && !hardwareBuffer2.isClosed()) {
            height = this.mSnapshot.getHeight();
        }
        return "TaskSnapshot{ mId=" + this.mId + " mCaptureTime=" + this.mCaptureTime + " mTopActivityComponent=" + this.mTopActivityComponent.flattenToShortString() + " mSnapshot=" + ((Object) this.mSnapshot) + " (" + width + LanguageTag.PRIVATEUSE + height + ") mColorSpace=" + this.mColorSpace.toString() + " mOrientation=" + this.mOrientation + " mRotation=" + this.mRotation + " mTaskSize=" + this.mTaskSize.toString() + " mContentInsets=" + this.mContentInsets.toShortString() + " mLetterboxInsets=" + this.mLetterboxInsets.toShortString() + " mIsLowResolution=" + this.mIsLowResolution + " mIsRealSnapshot=" + this.mIsRealSnapshot + " mWindowingMode=" + this.mWindowingMode + " mAppearance=" + this.mAppearance + " mIsTranslucent=" + this.mIsTranslucent + " mHasImeSurface=" + this.mHasImeSurface;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder {
        private int mAppearance;
        private long mCaptureTime;
        private ColorSpace mColorSpace;
        private Rect mContentInsets;
        private boolean mHasImeSurface;
        private long mId;
        private boolean mIsRealSnapshot;
        private boolean mIsTranslucent;
        private Rect mLetterboxInsets;
        private int mOrientation;
        private int mPixelFormat;
        private int mRotation;
        private HardwareBuffer mSnapshot;
        private Point mTaskSize;
        private ComponentName mTopActivity;
        private int mWindowingMode;

        public Builder setId(long id2) {
            this.mId = id2;
            return this;
        }

        public Builder setCaptureTime(long captureTime) {
            this.mCaptureTime = captureTime;
            return this;
        }

        public Builder setTopActivityComponent(ComponentName name) {
            this.mTopActivity = name;
            return this;
        }

        public Builder setSnapshot(HardwareBuffer buffer) {
            this.mSnapshot = buffer;
            return this;
        }

        public Builder setColorSpace(ColorSpace colorSpace) {
            this.mColorSpace = colorSpace;
            return this;
        }

        public Builder setOrientation(int orientation) {
            this.mOrientation = orientation;
            return this;
        }

        public Builder setRotation(int rotation) {
            this.mRotation = rotation;
            return this;
        }

        public Builder setTaskSize(Point size) {
            this.mTaskSize = size;
            return this;
        }

        public Builder setContentInsets(Rect contentInsets) {
            this.mContentInsets = contentInsets;
            return this;
        }

        public Builder setLetterboxInsets(Rect letterboxInsets) {
            this.mLetterboxInsets = letterboxInsets;
            return this;
        }

        public Builder setIsRealSnapshot(boolean realSnapshot) {
            this.mIsRealSnapshot = realSnapshot;
            return this;
        }

        public Builder setWindowingMode(int windowingMode) {
            this.mWindowingMode = windowingMode;
            return this;
        }

        public Builder setAppearance(int appearance) {
            this.mAppearance = appearance;
            return this;
        }

        public Builder setIsTranslucent(boolean isTranslucent) {
            this.mIsTranslucent = isTranslucent;
            return this;
        }

        public Builder setHasImeSurface(boolean hasImeSurface) {
            if (ProtoLogGroup.WM_DEBUG_ADD_REMOVE.isLogToLogcat()) {
                StringBuilder append = new StringBuilder().append("setHasImeSurface mHasImeSurface:").append(hasImeSurface).append(" ");
                ComponentName componentName = this.mTopActivity;
                Slog.i(TaskSnapshot.TAG, append.append(componentName != null ? componentName.getPackageName() : null).toString());
            }
            this.mHasImeSurface = hasImeSurface;
            return this;
        }

        public int getPixelFormat() {
            return this.mPixelFormat;
        }

        public Builder setPixelFormat(int pixelFormat) {
            this.mPixelFormat = pixelFormat;
            return this;
        }

        public TaskSnapshot build() {
            return new TaskSnapshot(this.mId, this.mCaptureTime, this.mTopActivity, this.mSnapshot, this.mColorSpace, this.mOrientation, this.mRotation, this.mTaskSize, this.mContentInsets, this.mLetterboxInsets, false, this.mIsRealSnapshot, this.mWindowingMode, this.mAppearance, this.mIsTranslucent, this.mHasImeSurface);
        }
    }
}
