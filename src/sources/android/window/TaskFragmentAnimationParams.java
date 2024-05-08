package android.window;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TaskFragmentAnimationParams implements Parcelable {
    public static final int DEFAULT_ANIMATION_BACKGROUND_COLOR = 0;
    private final int mAnimationBackgroundColor;
    public static final TaskFragmentAnimationParams DEFAULT = new Builder().build();
    public static final Parcelable.Creator<TaskFragmentAnimationParams> CREATOR = new Parcelable.Creator<TaskFragmentAnimationParams>() { // from class: android.window.TaskFragmentAnimationParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskFragmentAnimationParams createFromParcel(Parcel in) {
            return new TaskFragmentAnimationParams(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TaskFragmentAnimationParams[] newArray(int size) {
            return new TaskFragmentAnimationParams[size];
        }
    };

    private TaskFragmentAnimationParams(int animationBackgroundColor) {
        this.mAnimationBackgroundColor = animationBackgroundColor;
    }

    public int getAnimationBackgroundColor() {
        return this.mAnimationBackgroundColor;
    }

    private TaskFragmentAnimationParams(Parcel in) {
        this.mAnimationBackgroundColor = in.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mAnimationBackgroundColor);
    }

    public String toString() {
        return "TaskFragmentAnimationParams{ animationBgColor=" + Integer.toHexString(this.mAnimationBackgroundColor) + i.f4738d;
    }

    public int hashCode() {
        return this.mAnimationBackgroundColor;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TaskFragmentAnimationParams)) {
            return false;
        }
        TaskFragmentAnimationParams other = (TaskFragmentAnimationParams) obj;
        return this.mAnimationBackgroundColor == other.mAnimationBackgroundColor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class Builder {
        private int mAnimationBackgroundColor = 0;

        public Builder setAnimationBackgroundColor(int color) {
            this.mAnimationBackgroundColor = color;
            return this;
        }

        public TaskFragmentAnimationParams build() {
            return new TaskFragmentAnimationParams(this.mAnimationBackgroundColor);
        }
    }
}
