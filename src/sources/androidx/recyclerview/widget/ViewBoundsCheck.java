package androidx.recyclerview.widget;

import android.view.KeyEvent;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ViewBoundsCheck {
    public static final int CVE_PVE_POS = 12;
    public static final int CVE_PVS_POS = 8;
    public static final int CVS_PVE_POS = 4;
    public static final int CVS_PVS_POS = 0;
    public static final int EQ = 2;
    public static final int FLAG_CVE_EQ_PVE = 8192;
    public static final int FLAG_CVE_EQ_PVS = 512;
    public static final int FLAG_CVE_GT_PVE = 4096;
    public static final int FLAG_CVE_GT_PVS = 256;
    public static final int FLAG_CVE_LT_PVE = 16384;
    public static final int FLAG_CVE_LT_PVS = 1024;
    public static final int FLAG_CVS_EQ_PVE = 32;
    public static final int FLAG_CVS_EQ_PVS = 2;
    public static final int FLAG_CVS_GT_PVE = 16;
    public static final int FLAG_CVS_GT_PVS = 1;
    public static final int FLAG_CVS_LT_PVE = 64;
    public static final int FLAG_CVS_LT_PVS = 4;
    public static final int GT = 1;
    public static final int LT = 4;
    public static final int MASK = 7;
    public BoundFlags mBoundFlags = new BoundFlags();
    public final Callback mCallback;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class BoundFlags {
        public int mBoundFlags = 0;
        public int mChildEnd;
        public int mChildStart;
        public int mRvEnd;
        public int mRvStart;

        public void addFlags(int i10) {
            this.mBoundFlags = i10 | this.mBoundFlags;
        }

        public boolean boundsMatch() {
            int i10 = this.mBoundFlags;
            if ((i10 & 7) != 0 && (i10 & (compare(this.mChildStart, this.mRvStart) << 0)) == 0) {
                return false;
            }
            int i11 = this.mBoundFlags;
            if ((i11 & 112) != 0 && (i11 & (compare(this.mChildStart, this.mRvEnd) << 4)) == 0) {
                return false;
            }
            int i12 = this.mBoundFlags;
            if ((i12 & 1792) != 0 && (i12 & (compare(this.mChildEnd, this.mRvStart) << 8)) == 0) {
                return false;
            }
            int i13 = this.mBoundFlags;
            return (i13 & KeyEvent.META_CTRL_MASK) == 0 || (i13 & (compare(this.mChildEnd, this.mRvEnd) << 12)) != 0;
        }

        public int compare(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        public void resetFlags() {
            this.mBoundFlags = 0;
        }

        public void setBounds(int i10, int i11, int i12, int i13) {
            this.mRvStart = i10;
            this.mRvEnd = i11;
            this.mChildStart = i12;
            this.mChildEnd = i13;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Callback {
        View getChildAt(int i10);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public @interface ViewBounds {
    }

    public ViewBoundsCheck(Callback callback) {
        this.mCallback = callback;
    }

    public View findOneViewWithinBoundFlags(int i10, int i11, int i12, int i13) {
        int parentStart = this.mCallback.getParentStart();
        int parentEnd = this.mCallback.getParentEnd();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View childAt = this.mCallback.getChildAt(i10);
            this.mBoundFlags.setBounds(parentStart, parentEnd, this.mCallback.getChildStart(childAt), this.mCallback.getChildEnd(childAt));
            if (i12 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i12);
                if (this.mBoundFlags.boundsMatch()) {
                    return childAt;
                }
            }
            if (i13 != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i13);
                if (this.mBoundFlags.boundsMatch()) {
                    view = childAt;
                }
            }
            i10 += i14;
        }
        return view;
    }

    public boolean isViewWithinBoundFlags(View view, int i10) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view), this.mCallback.getChildEnd(view));
        if (i10 == 0) {
            return false;
        }
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(i10);
        return this.mBoundFlags.boundsMatch();
    }
}
