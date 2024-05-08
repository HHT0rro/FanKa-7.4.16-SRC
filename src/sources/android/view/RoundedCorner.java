package android.view;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class RoundedCorner implements Parcelable {
    public static final Parcelable.Creator<RoundedCorner> CREATOR = new Parcelable.Creator<RoundedCorner>() { // from class: android.view.RoundedCorner.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoundedCorner createFromParcel(Parcel in) {
            return new RoundedCorner(in.readInt(), in.readInt(), in.readInt(), in.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RoundedCorner[] newArray(int size) {
            return new RoundedCorner[size];
        }
    };
    public static final int POSITION_BOTTOM_LEFT = 3;
    public static final int POSITION_BOTTOM_RIGHT = 2;
    public static final int POSITION_TOP_LEFT = 0;
    public static final int POSITION_TOP_RIGHT = 1;
    private final Point mCenter;
    private final int mPosition;
    private final int mRadius;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Position {
    }

    public RoundedCorner(int position) {
        this.mPosition = position;
        this.mRadius = 0;
        this.mCenter = new Point(0, 0);
    }

    public RoundedCorner(int position, int radius, int centerX, int centerY) {
        this.mPosition = position;
        this.mRadius = radius;
        this.mCenter = new Point(centerX, centerY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundedCorner(RoundedCorner rc2) {
        this.mPosition = rc2.getPosition();
        this.mRadius = rc2.getRadius();
        this.mCenter = new Point(rc2.getCenter());
    }

    public int getPosition() {
        return this.mPosition;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public Point getCenter() {
        return new Point(this.mCenter);
    }

    public boolean isEmpty() {
        return this.mRadius == 0 || this.mCenter.x <= 0 || this.mCenter.y <= 0;
    }

    private String getPositionString(int position) {
        switch (position) {
            case 0:
                return "TopLeft";
            case 1:
                return "TopRight";
            case 2:
                return "BottomRight";
            case 3:
                return "BottomLeft";
            default:
                return "Invalid";
        }
    }

    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof RoundedCorner)) {
            return false;
        }
        RoundedCorner r10 = (RoundedCorner) o10;
        return this.mPosition == r10.mPosition && this.mRadius == r10.mRadius && this.mCenter.equals(r10.mCenter);
    }

    public int hashCode() {
        int result = (0 * 31) + this.mPosition;
        return (((result * 31) + this.mRadius) * 31) + this.mCenter.hashCode();
    }

    public String toString() {
        return "RoundedCorner{position=" + getPositionString(this.mPosition) + ", radius=" + this.mRadius + ", center=" + ((Object) this.mCenter) + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.mPosition);
        out.writeInt(this.mRadius);
        out.writeInt(this.mCenter.x);
        out.writeInt(this.mCenter.y);
    }
}
