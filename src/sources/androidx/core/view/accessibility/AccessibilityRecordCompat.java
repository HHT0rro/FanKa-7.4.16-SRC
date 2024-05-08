package androidx.core.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    @RequiresApi(15)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        @DoNotInline
        public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        @DoNotInline
        public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i10) {
            accessibilityRecord.setMaxScrollX(i10);
        }

        @DoNotInline
        public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i10) {
            accessibilityRecord.setMaxScrollY(i10);
        }
    }

    @RequiresApi(16)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static void setSource(AccessibilityRecord accessibilityRecord, View view, int i10) {
            accessibilityRecord.setSource(view, i10);
        }
    }

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.mRecord = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.mRecord));
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.mRecord;
        if (accessibilityRecord == null) {
            return accessibilityRecordCompat.mRecord == null;
        }
        return accessibilityRecord.equals(accessibilityRecordCompat.mRecord);
    }

    @Deprecated
    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.mRecord;
    }

    @Deprecated
    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.mRecord);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.mRecord);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.mRecord.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.mRecord;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.mRecord.recycle();
    }

    @Deprecated
    public void setAddedCount(int i10) {
        this.mRecord.setAddedCount(i10);
    }

    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        this.mRecord.setBeforeText(charSequence);
    }

    @Deprecated
    public void setChecked(boolean z10) {
        this.mRecord.setChecked(z10);
    }

    @Deprecated
    public void setClassName(CharSequence charSequence) {
        this.mRecord.setClassName(charSequence);
    }

    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        this.mRecord.setContentDescription(charSequence);
    }

    @Deprecated
    public void setCurrentItemIndex(int i10) {
        this.mRecord.setCurrentItemIndex(i10);
    }

    @Deprecated
    public void setEnabled(boolean z10) {
        this.mRecord.setEnabled(z10);
    }

    @Deprecated
    public void setFromIndex(int i10) {
        this.mRecord.setFromIndex(i10);
    }

    @Deprecated
    public void setFullScreen(boolean z10) {
        this.mRecord.setFullScreen(z10);
    }

    @Deprecated
    public void setItemCount(int i10) {
        this.mRecord.setItemCount(i10);
    }

    @Deprecated
    public void setMaxScrollX(int i10) {
        setMaxScrollX(this.mRecord, i10);
    }

    @Deprecated
    public void setMaxScrollY(int i10) {
        setMaxScrollY(this.mRecord, i10);
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        this.mRecord.setParcelableData(parcelable);
    }

    @Deprecated
    public void setPassword(boolean z10) {
        this.mRecord.setPassword(z10);
    }

    @Deprecated
    public void setRemovedCount(int i10) {
        this.mRecord.setRemovedCount(i10);
    }

    @Deprecated
    public void setScrollX(int i10) {
        this.mRecord.setScrollX(i10);
    }

    @Deprecated
    public void setScrollY(int i10) {
        this.mRecord.setScrollY(i10);
    }

    @Deprecated
    public void setScrollable(boolean z10) {
        this.mRecord.setScrollable(z10);
    }

    @Deprecated
    public void setSource(View view) {
        this.mRecord.setSource(view);
    }

    @Deprecated
    public void setToIndex(int i10) {
        this.mRecord.setToIndex(i10);
    }

    public static int getMaxScrollX(@NonNull AccessibilityRecord accessibilityRecord) {
        return Api15Impl.getMaxScrollX(accessibilityRecord);
    }

    public static int getMaxScrollY(@NonNull AccessibilityRecord accessibilityRecord) {
        return Api15Impl.getMaxScrollY(accessibilityRecord);
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public static void setMaxScrollX(@NonNull AccessibilityRecord accessibilityRecord, int i10) {
        Api15Impl.setMaxScrollX(accessibilityRecord, i10);
    }

    public static void setMaxScrollY(@NonNull AccessibilityRecord accessibilityRecord, int i10) {
        Api15Impl.setMaxScrollY(accessibilityRecord, i10);
    }

    @Deprecated
    public void setSource(View view, int i10) {
        setSource(this.mRecord, view, i10);
    }

    public static void setSource(@NonNull AccessibilityRecord accessibilityRecord, @Nullable View view, int i10) {
        Api16Impl.setSource(accessibilityRecord, view, i10);
    }
}
