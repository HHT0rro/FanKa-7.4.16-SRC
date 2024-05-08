package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i10, boolean z10) {
        return this.mWrapped.getBoolean(i10, z10);
    }

    @RequiresApi(21)
    public int getChangingConfigurations() {
        return this.mWrapped.getChangingConfigurations();
    }

    public int getColor(int i10, int i11) {
        return this.mWrapped.getColor(i10, i11);
    }

    public ColorStateList getColorStateList(int i10) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.mWrapped.hasValue(i10) || (resourceId = this.mWrapped.getResourceId(i10, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.mWrapped.getColorStateList(i10) : colorStateList;
    }

    public float getDimension(int i10, float f10) {
        return this.mWrapped.getDimension(i10, f10);
    }

    public int getDimensionPixelOffset(int i10, int i11) {
        return this.mWrapped.getDimensionPixelOffset(i10, i11);
    }

    public int getDimensionPixelSize(int i10, int i11) {
        return this.mWrapped.getDimensionPixelSize(i10, i11);
    }

    public Drawable getDrawable(int i10) {
        int resourceId;
        if (this.mWrapped.hasValue(i10) && (resourceId = this.mWrapped.getResourceId(i10, 0)) != 0) {
            return AppCompatResources.getDrawable(this.mContext, resourceId);
        }
        return this.mWrapped.getDrawable(i10);
    }

    public Drawable getDrawableIfKnown(int i10) {
        int resourceId;
        if (!this.mWrapped.hasValue(i10) || (resourceId = this.mWrapped.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
    }

    public float getFloat(int i10, float f10) {
        return this.mWrapped.getFloat(i10, f10);
    }

    @Nullable
    public Typeface getFont(@StyleableRes int i10, int i11, @Nullable ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i11, fontCallback);
    }

    public float getFraction(int i10, int i11, int i12, float f10) {
        return this.mWrapped.getFraction(i10, i11, i12, f10);
    }

    public int getIndex(int i10) {
        return this.mWrapped.getIndex(i10);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i10, int i11) {
        return this.mWrapped.getInt(i10, i11);
    }

    public int getInteger(int i10, int i11) {
        return this.mWrapped.getInteger(i10, i11);
    }

    public int getLayoutDimension(int i10, String str) {
        return this.mWrapped.getLayoutDimension(i10, str);
    }

    public String getNonResourceString(int i10) {
        return this.mWrapped.getNonResourceString(i10);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i10, int i11) {
        return this.mWrapped.getResourceId(i10, i11);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int i10) {
        return this.mWrapped.getString(i10);
    }

    public CharSequence getText(int i10) {
        return this.mWrapped.getText(i10);
    }

    public CharSequence[] getTextArray(int i10) {
        return this.mWrapped.getTextArray(i10);
    }

    public int getType(int i10) {
        return this.mWrapped.getType(i10);
    }

    public boolean getValue(int i10, TypedValue typedValue) {
        return this.mWrapped.getValue(i10, typedValue);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i10) {
        return this.mWrapped.hasValue(i10);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public TypedValue peekValue(int i10) {
        return this.mWrapped.peekValue(i10);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public int getLayoutDimension(int i10, int i11) {
        return this.mWrapped.getLayoutDimension(i10, i11);
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i10, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i10, iArr));
    }
}
