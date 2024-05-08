package android.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.proto.ProtoOutputStream;
import android.view.WindowInsets;
import com.alipay.sdk.util.i;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.StringJoiner;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InsetsSource implements Parcelable {
    public static final int FLAG_SUPPRESS_SCRIM = 1;
    private int mFlags;
    private final Rect mFrame;
    private final int mId;
    private boolean mInsetsRoundedCornerFrame;
    private final Rect mTmpFrame;
    private final int mType;
    private boolean mVisible;
    private Rect mVisibleFrame;
    public static final int ID_IME = createId(null, 0, WindowInsets.Type.ime());
    public static final Parcelable.Creator<InsetsSource> CREATOR = new Parcelable.Creator<InsetsSource>() { // from class: android.view.InsetsSource.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsetsSource createFromParcel(Parcel in) {
            return new InsetsSource(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InsetsSource[] newArray(int size) {
            return new InsetsSource[size];
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Flags {
    }

    public InsetsSource(int id2, int type) {
        this.mTmpFrame = new Rect();
        this.mId = id2;
        this.mType = type;
        this.mFrame = new Rect();
        this.mVisible = (WindowInsets.Type.defaultVisible() & type) != 0;
    }

    public InsetsSource(InsetsSource other) {
        Rect rect;
        this.mTmpFrame = new Rect();
        this.mId = other.mId;
        this.mType = other.mType;
        this.mFrame = new Rect(other.mFrame);
        this.mVisible = other.mVisible;
        if (other.mVisibleFrame != null) {
            rect = new Rect(other.mVisibleFrame);
        } else {
            rect = null;
        }
        this.mVisibleFrame = rect;
        this.mFlags = other.mFlags;
        this.mInsetsRoundedCornerFrame = other.mInsetsRoundedCornerFrame;
    }

    public void set(InsetsSource other) {
        Rect rect;
        this.mFrame.set(other.mFrame);
        this.mVisible = other.mVisible;
        if (other.mVisibleFrame != null) {
            rect = new Rect(other.mVisibleFrame);
        } else {
            rect = null;
        }
        this.mVisibleFrame = rect;
        this.mFlags = other.mFlags;
        this.mInsetsRoundedCornerFrame = other.mInsetsRoundedCornerFrame;
    }

    public InsetsSource setFrame(int left, int top, int right, int bottom) {
        this.mFrame.set(left, top, right, bottom);
        return this;
    }

    public InsetsSource setFrame(Rect frame) {
        this.mFrame.set(frame);
        return this;
    }

    public InsetsSource setVisibleFrame(Rect visibleFrame) {
        this.mVisibleFrame = visibleFrame != null ? new Rect(visibleFrame) : null;
        return this;
    }

    public InsetsSource setVisible(boolean visible) {
        this.mVisible = visible;
        return this;
    }

    public InsetsSource setFlags(int flags) {
        this.mFlags = flags;
        return this;
    }

    public int getId() {
        return this.mId;
    }

    public int getType() {
        return this.mType;
    }

    public Rect getFrame() {
        return this.mFrame;
    }

    public Rect getVisibleFrame() {
        return this.mVisibleFrame;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public int getFlags() {
        return this.mFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isUserControllable() {
        Rect rect = this.mVisibleFrame;
        return rect == null || !rect.isEmpty();
    }

    public boolean insetsRoundedCornerFrame() {
        return this.mInsetsRoundedCornerFrame;
    }

    public InsetsSource setInsetsRoundedCornerFrame(boolean insetsRoundedCornerFrame) {
        this.mInsetsRoundedCornerFrame = insetsRoundedCornerFrame;
        return this;
    }

    public Insets calculateInsets(Rect relativeFrame, boolean ignoreVisibility) {
        return calculateInsets(relativeFrame, this.mFrame, ignoreVisibility);
    }

    public Insets calculateVisibleInsets(Rect relativeFrame) {
        Rect rect = this.mVisibleFrame;
        if (rect == null) {
            rect = this.mFrame;
        }
        return calculateInsets(relativeFrame, rect, false);
    }

    private Insets calculateInsets(Rect relativeFrame, Rect frame, boolean ignoreVisibility) {
        boolean hasIntersection;
        if (!ignoreVisibility && !this.mVisible) {
            return Insets.NONE;
        }
        if (getType() == WindowInsets.Type.captionBar()) {
            return Insets.of(0, frame.height(), 0, 0);
        }
        if (relativeFrame.isEmpty()) {
            hasIntersection = getIntersection(frame, relativeFrame, this.mTmpFrame);
        } else {
            hasIntersection = this.mTmpFrame.setIntersect(frame, relativeFrame);
        }
        if (!hasIntersection) {
            return Insets.NONE;
        }
        if (getType() == WindowInsets.Type.ime()) {
            return Insets.of(0, 0, 0, this.mTmpFrame.height());
        }
        if (this.mTmpFrame.width() == relativeFrame.width()) {
            if (this.mTmpFrame.top == relativeFrame.top) {
                return Insets.of(0, this.mTmpFrame.height(), 0, 0);
            }
            if (this.mTmpFrame.bottom == relativeFrame.bottom) {
                return Insets.of(0, 0, 0, this.mTmpFrame.height());
            }
            if (this.mTmpFrame.top == 0) {
                return Insets.of(0, this.mTmpFrame.height(), 0, 0);
            }
        } else if (this.mTmpFrame.height() == relativeFrame.height()) {
            if (this.mTmpFrame.left == relativeFrame.left) {
                return Insets.of(this.mTmpFrame.width(), 0, 0, 0);
            }
            if (this.mTmpFrame.right == relativeFrame.right) {
                return Insets.of(0, 0, this.mTmpFrame.width(), 0);
            }
        }
        return Insets.NONE;
    }

    private static boolean getIntersection(Rect a10, Rect b4, Rect out) {
        if (a10.left <= b4.right && b4.left <= a10.right && a10.top <= b4.bottom && b4.top <= a10.bottom) {
            out.left = Math.max(a10.left, b4.left);
            out.top = Math.max(a10.top, b4.top);
            out.right = Math.min(a10.right, b4.right);
            out.bottom = Math.min(a10.bottom, b4.bottom);
            return true;
        }
        out.setEmpty();
        return false;
    }

    public static int createId(Object owner, int index, int type) {
        if (index < 0 || index >= 2048) {
            throw new IllegalArgumentException();
        }
        return ((System.identityHashCode(owner) % 65536) << 16) + (index << 5) + WindowInsets.Type.indexOf(type);
    }

    public static int getIndex(int id2) {
        return (65535 & id2) >> 5;
    }

    public static int getType(int id2) {
        return 1 << (id2 & 31);
    }

    public static String flagsToString(int flags) {
        StringJoiner joiner = new StringJoiner(" ");
        if ((flags & 1) != 0) {
            joiner.add("SUPPRESS_SCRIM");
        }
        return joiner.toString();
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, WindowInsets.Type.toString(this.mType));
        this.mFrame.dumpDebug(proto, 1146756268034L);
        Rect rect = this.mVisibleFrame;
        if (rect != null) {
            rect.dumpDebug(proto, 1146756268035L);
        }
        proto.write(1133871366148L, this.mVisible);
        proto.end(token);
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("InsetsSource id=");
        pw.print(Integer.toHexString(this.mId));
        pw.print(" type=");
        pw.print(WindowInsets.Type.toString(this.mType));
        pw.print(" frame=");
        pw.print(this.mFrame.toShortString());
        if (this.mVisibleFrame != null) {
            pw.print(" visibleFrame=");
            pw.print(this.mVisibleFrame.toShortString());
        }
        pw.print(" visible=");
        pw.print(this.mVisible);
        pw.print(" flags=");
        pw.print(flagsToString(this.mFlags));
        pw.print(" insetsRoundedCornerFrame=");
        pw.print(this.mInsetsRoundedCornerFrame);
        pw.println();
    }

    public boolean equals(Object o10) {
        return equals(o10, false);
    }

    public boolean equals(Object o10, boolean excludeInvisibleImeFrames) {
        int i10;
        boolean z10;
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        InsetsSource that = (InsetsSource) o10;
        if (this.mId != that.mId || (i10 = this.mType) != that.mType || (z10 = this.mVisible) != that.mVisible || this.mFlags != that.mFlags) {
            return false;
        }
        if (excludeInvisibleImeFrames && !z10 && i10 == WindowInsets.Type.ime()) {
            return true;
        }
        if (!Objects.equals(this.mVisibleFrame, that.mVisibleFrame) || this.mInsetsRoundedCornerFrame != that.mInsetsRoundedCornerFrame) {
            return false;
        }
        return this.mFrame.equals(that.mFrame);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mId), Integer.valueOf(this.mType), this.mFrame, this.mVisibleFrame, Boolean.valueOf(this.mVisible), Integer.valueOf(this.mFlags), Boolean.valueOf(this.mInsetsRoundedCornerFrame));
    }

    public InsetsSource(Parcel in) {
        this.mTmpFrame = new Rect();
        this.mId = in.readInt();
        this.mType = in.readInt();
        this.mFrame = (Rect) Rect.CREATOR.createFromParcel(in);
        if (in.readInt() != 0) {
            this.mVisibleFrame = (Rect) Rect.CREATOR.createFromParcel(in);
        } else {
            this.mVisibleFrame = null;
        }
        this.mVisible = in.readBoolean();
        this.mFlags = in.readInt();
        this.mInsetsRoundedCornerFrame = in.readBoolean();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeInt(this.mType);
        this.mFrame.writeToParcel(dest, 0);
        Rect vf = this.mVisibleFrame;
        if (vf != null) {
            dest.writeInt(1);
            vf.writeToParcel(dest, 0);
        } else {
            dest.writeInt(0);
        }
        dest.writeBoolean(this.mVisible);
        dest.writeInt(this.mFlags);
        dest.writeBoolean(this.mInsetsRoundedCornerFrame);
    }

    public String toString() {
        return "InsetsSource: {" + Integer.toHexString(this.mId) + " mType=" + WindowInsets.Type.toString(this.mType) + " mFrame=" + this.mFrame.toShortString() + " mVisible=" + this.mVisible + " mFlags=[" + flagsToString(this.mFlags) + "]" + (this.mInsetsRoundedCornerFrame ? " insetsRoundedCornerFrame" : "") + i.f4738d;
    }
}
