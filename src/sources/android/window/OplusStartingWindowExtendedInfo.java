package android.window;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OplusStartingWindowExtendedInfo implements Parcelable {
    public static final Parcelable.Creator<OplusStartingWindowExtendedInfo> CREATOR = new Parcelable.Creator<OplusStartingWindowExtendedInfo>() { // from class: android.window.OplusStartingWindowExtendedInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusStartingWindowExtendedInfo createFromParcel(Parcel in) {
            return new OplusStartingWindowExtendedInfo(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusStartingWindowExtendedInfo[] newArray(int size) {
            return new OplusStartingWindowExtendedInfo[size];
        }
    };
    private IBinder mAppToken;
    private boolean mForceSolidColorSplash;
    private boolean mIsExceptionListApp;
    private boolean mIsSystemApp;
    private Bitmap mPreviewBitmap;
    private boolean mShouldDrawBackground;
    private boolean mSupportSplashScreenPreview;

    public OplusStartingWindowExtendedInfo() {
    }

    protected OplusStartingWindowExtendedInfo(Parcel in) {
        this.mAppToken = in.readStrongBinder();
        this.mSupportSplashScreenPreview = in.readBoolean();
        this.mIsSystemApp = in.readBoolean();
        this.mPreviewBitmap = (Bitmap) in.readParcelable(Bitmap.class.getClassLoader());
        this.mIsExceptionListApp = in.readBoolean();
        this.mShouldDrawBackground = in.readBoolean();
        this.mForceSolidColorSplash = in.readBoolean();
    }

    public void setPreviewBitmap(Bitmap previewBitmap) {
        this.mPreviewBitmap = previewBitmap;
    }

    public Bitmap getPreviewBitmap() {
        return this.mPreviewBitmap;
    }

    public void setSupportSplashScreenPreview(boolean mSupportSplashScreenPreview) {
        this.mSupportSplashScreenPreview = mSupportSplashScreenPreview;
    }

    public boolean isSupportSplashScreenPreview() {
        return this.mSupportSplashScreenPreview;
    }

    public void setAppToken(IBinder token) {
        this.mAppToken = token;
    }

    public IBinder getAppToken() {
        return this.mAppToken;
    }

    public void setSystemApp(boolean systemApp) {
        this.mIsSystemApp = systemApp;
    }

    public boolean isSystemApp() {
        return this.mIsSystemApp;
    }

    public boolean isExceptionListApp() {
        return this.mIsExceptionListApp;
    }

    public void setExceptionListApp(boolean isExceptionListApp) {
        this.mIsExceptionListApp = isExceptionListApp;
    }

    public boolean shouldDrawBackground() {
        return this.mShouldDrawBackground;
    }

    public void setShouldDrawBackground(boolean shouldDrawBackground) {
        this.mShouldDrawBackground = shouldDrawBackground;
    }

    public boolean isForceSolidColorSplash() {
        return this.mForceSolidColorSplash;
    }

    public void setForceSolidColorSplash(boolean solidColor) {
        this.mForceSolidColorSplash = solidColor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.mAppToken);
        dest.writeBoolean(this.mSupportSplashScreenPreview);
        dest.writeBoolean(this.mIsSystemApp);
        dest.writeParcelable(this.mPreviewBitmap, flags);
        dest.writeBoolean(this.mIsExceptionListApp);
        dest.writeBoolean(this.mShouldDrawBackground);
        dest.writeBoolean(this.mForceSolidColorSplash);
    }

    public String toString() {
        return "OplusStartingWindowExtendedInfo{mAppToken=" + ((Object) this.mAppToken) + ", mSupportSplashScreenPreview=" + this.mSupportSplashScreenPreview + ", mIsSystemApp=" + this.mIsSystemApp + ", mIsExceptionListApp=" + this.mIsExceptionListApp + ", mPreviewBitmap=" + ((Object) this.mPreviewBitmap) + ", mShouldDrawBackground=" + this.mShouldDrawBackground + ", mForceSolidColorSplash=" + this.mForceSolidColorSplash + '}';
    }
}
