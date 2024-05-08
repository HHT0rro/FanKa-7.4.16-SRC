package com.kwad.sdk.n;

import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.huawei.quickcard.base.Attributes;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h extends Resources {
    private final Resources aTd;

    public h(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.aTd = resources2;
    }

    private static boolean aA(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("ksad_") || !"com.kwad.dy.sdk".equals(str2);
    }

    private static boolean eq(int i10) {
        StringBuilder sb2 = new StringBuilder("0x");
        sb2.append(Integer.toHexString(i10));
        return !sb2.toString().startsWith("0x60");
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getAnimation(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getAnimation id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getAnimation(i10);
        }
        return super.getAnimation(i10);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getBoolean id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getBoolean(i10);
        }
        return super.getBoolean(i10);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getColor id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getColor(i10);
        }
        return super.getColor(i10);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimension id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getDimension(i10);
        }
        return super.getDimension(i10);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimensionPixelOffset id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getDimensionPixelOffset(i10);
        }
        return super.getDimensionPixelOffset(i10);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDimensionPixelSize id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getDimensionPixelSize(i10);
        }
        return super.getDimensionPixelSize(i10);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getDrawable(i10);
        }
        return super.getDrawable(i10);
    }

    @Override // android.content.res.Resources
    @Nullable
    @Deprecated
    public final Drawable getDrawableForDensity(int i10, int i11) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawableForDensity id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getDrawableForDensity(i10, i11);
        }
        return super.getDrawableForDensity(i10, i11);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 29)
    public final float getFloat(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFloat id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getFloat(i10);
        }
        return super.getFloat(i10);
    }

    @Override // android.content.res.Resources
    @NonNull
    @RequiresApi(api = 26)
    public final Typeface getFont(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFont id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getFont(i10);
        }
        return super.getFont(i10);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i10, int i11, int i12) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getFraction id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getFraction(i10, i11, i12);
        }
        return super.getFraction(i10, i11, i12);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        if (aA(str, str3)) {
            return this.aTd.getIdentifier(str, str2, str3);
        }
        return super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final int[] getIntArray(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getIntArray id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getIntArray(i10);
        }
        return super.getIntArray(i10);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getInteger id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getInteger(i10);
        }
        return super.getInteger(i10);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getLayout(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getLayout id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getLayout(i10);
        }
        return super.getLayout(i10);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getMovie(i10);
        }
        return super.getMovie(i10);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i10, int i11) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getQuantityString(i10, i11);
        }
        return super.getQuantityString(i10, i11);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getQuantityText(int i10, int i11) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityText id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getQuantityText(i10, i11);
        }
        return super.getQuantityText(i10, i11);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceEntryName id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getResourceEntryName(i10);
        }
        return super.getResourceEntryName(i10);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceName id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getResourceName(i10);
        }
        return super.getResourceName(i10);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourcePackageName id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getResourcePackageName(i10);
        }
        return super.getResourcePackageName(i10);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getResourceTypeName id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getResourceTypeName(i10);
        }
        return super.getResourceTypeName(i10);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getString(i10);
        }
        return super.getString(i10);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String[] getStringArray(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getStringArray id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getStringArray(i10);
        }
        return super.getStringArray(i10);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence getText(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getText(i10);
        }
        return super.getText(i10);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final CharSequence[] getTextArray(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getTextArray id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getTextArray(i10);
        }
        return super.getTextArray(i10);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i10, TypedValue typedValue, boolean z10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            this.aTd.getValue(i10, typedValue, z10);
        } else {
            super.getValue(i10, typedValue, z10);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i10, int i11, TypedValue typedValue, boolean z10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValueForDensity id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            this.aTd.getValueForDensity(i10, i11, typedValue, z10);
        } else {
            super.getValueForDensity(i10, i11, typedValue, z10);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final XmlResourceParser getXml(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getXml id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getXml(i10);
        }
        return super.getXml(i10);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final TypedArray obtainTypedArray(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "obtainTypedArray id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.obtainTypedArray(i10);
        }
        return super.obtainTypedArray(i10);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.openRawResource(i10);
        }
        return super.openRawResource(i10);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i10) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResourceFd id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.openRawResourceFd(i10);
        }
        return super.openRawResourceFd(i10);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    @RequiresApi(api = 23)
    public final int getColor(int i10, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getMovie id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getColor(i10, theme);
        }
        return super.getColor(i10, theme);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i10, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getDrawable(i10);
        }
        return super.getDrawable(i10, theme);
    }

    @Override // android.content.res.Resources
    @Nullable
    @RequiresApi(api = 21)
    public final Drawable getDrawableForDensity(int i10, int i11, @Nullable Resources.Theme theme) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getDrawable id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getDrawableForDensity(i10, i11, theme);
        }
        return super.getDrawableForDensity(i10, i11, theme);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getQuantityString(int i10, int i11, Object... objArr) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getQuantityString id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getQuantityString(i10, i11, objArr);
        }
        return super.getQuantityString(i10, i11, objArr);
    }

    @Override // android.content.res.Resources
    @NonNull
    public final String getString(int i10, Object... objArr) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getString id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getString(i10, objArr);
        }
        return super.getString(i10, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i10, CharSequence charSequence) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getText id: #0x" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.getText(i10, charSequence);
        }
        return super.getText(i10, charSequence);
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z10) {
        int identifier = getIdentifier(str, Attributes.TextOverflow.STRING, null);
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "getValue id: 0x#" + Integer.toHexString(identifier));
        if (eq(identifier)) {
            this.aTd.getValue(str, typedValue, z10);
        } else {
            super.getValue(str, typedValue, z10);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public final InputStream openRawResource(int i10, TypedValue typedValue) {
        com.kwad.sdk.core.e.c.d("KSDY/KSResource", "openRawResource id: 0x#" + Integer.toHexString(i10));
        if (eq(i10)) {
            return this.aTd.openRawResource(i10, typedValue);
        }
        return super.openRawResource(i10, typedValue);
    }
}
