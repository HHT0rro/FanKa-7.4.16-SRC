package androidx.transition;

import android.os.IBinder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class WindowIdApi14 implements WindowIdImpl {
    private final IBinder mToken;

    public WindowIdApi14(IBinder iBinder) {
        this.mToken = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi14) && ((WindowIdApi14) obj).mToken.equals(this.mToken);
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}
