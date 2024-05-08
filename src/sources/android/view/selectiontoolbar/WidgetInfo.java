package android.view.selectiontoolbar;

import android.annotation.NonNull;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.SurfaceControlViewHost;
import com.android.internal.util.AnnotationValidations;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WidgetInfo implements Parcelable {
    public static final Parcelable.Creator<WidgetInfo> CREATOR = new Parcelable.Creator<WidgetInfo>() { // from class: android.view.selectiontoolbar.WidgetInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WidgetInfo[] newArray(int size) {
            return new WidgetInfo[size];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WidgetInfo createFromParcel(Parcel in) {
            return new WidgetInfo(in);
        }
    };
    private final Rect mContentRect;
    private final SurfaceControlViewHost.SurfacePackage mSurfacePackage;
    private final long mWidgetToken;

    public WidgetInfo(long widgetToken, Rect contentRect, SurfaceControlViewHost.SurfacePackage surfacePackage) {
        this.mWidgetToken = widgetToken;
        this.mContentRect = contentRect;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, contentRect);
        this.mSurfacePackage = surfacePackage;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, surfacePackage);
    }

    public long getWidgetToken() {
        return this.mWidgetToken;
    }

    public Rect getContentRect() {
        return this.mContentRect;
    }

    public SurfaceControlViewHost.SurfacePackage getSurfacePackage() {
        return this.mSurfacePackage;
    }

    public String toString() {
        return "WidgetInfo { widgetToken = " + this.mWidgetToken + ", contentRect = " + ((Object) this.mContentRect) + ", surfacePackage = " + ((Object) this.mSurfacePackage) + " }";
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        WidgetInfo that = (WidgetInfo) o10;
        if (this.mWidgetToken == that.mWidgetToken && Objects.equals(this.mContentRect, that.mContentRect) && Objects.equals(this.mSurfacePackage, that.mSurfacePackage)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Long.hashCode(this.mWidgetToken);
        return (((_hash * 31) + Objects.hashCode(this.mContentRect)) * 31) + Objects.hashCode(this.mSurfacePackage);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.mWidgetToken);
        dest.writeTypedObject(this.mContentRect, flags);
        dest.writeTypedObject(this.mSurfacePackage, flags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    WidgetInfo(Parcel in) {
        long widgetToken = in.readLong();
        Rect contentRect = (Rect) in.readTypedObject(Rect.CREATOR);
        SurfaceControlViewHost.SurfacePackage surfacePackage = (SurfaceControlViewHost.SurfacePackage) in.readTypedObject(SurfaceControlViewHost.SurfacePackage.CREATOR);
        this.mWidgetToken = widgetToken;
        this.mContentRect = contentRect;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, contentRect);
        this.mSurfacePackage = surfacePackage;
        AnnotationValidations.validate(NonNull.class, (NonNull) null, surfacePackage);
    }

    @Deprecated
    private void __metadata() {
    }
}
