package com.bytedance.pangle.res;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.j;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PluginResources extends Resources {
    public String pluginPkg;

    public PluginResources(Resources resources, String str) {
        super(appendHostRes(resources), resources.getDisplayMetrics(), Zeus.getAppApplication().getResources().getConfiguration());
        this.pluginPkg = str;
    }

    public static AssetManager appendHostRes(Resources resources) {
        String a10 = g.a(Zeus.getAppApplication());
        String b4 = g.b(Zeus.getAppApplication());
        List<String> b10 = j.b();
        a aVar = new a();
        AssetManager assets = resources.getAssets();
        AssetManager assets2 = Zeus.getAppApplication().getAssets();
        HashSet hashSet = new HashSet(j.a(assets));
        List<String> a11 = j.a(assets2);
        for (String str : b10) {
            if (!hashSet.contains(str)) {
                assets = aVar.a(assets, str, true);
            }
        }
        for (String str2 : a11) {
            if (!isOtherPlugin(str2, a10, b4) && !hashSet.contains(str2) && !b10.contains(str2)) {
                assets = aVar.a(assets, str2, false);
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_RESOURCES, "pluginAssets = " + j.b(assets));
        return assets;
    }

    private Resources.NotFoundException handleException(Resources.NotFoundException notFoundException) {
        return new Resources.NotFoundException(("Resources#Assets: " + j.b(getAssets())) + "," + notFoundException.getMessage());
    }

    private static boolean isOtherPlugin(String str, String str2, String str3) {
        String packageResourcePath = Zeus.getAppApplication().getPackageResourcePath();
        if (!TextUtils.isEmpty(str3)) {
            packageResourcePath = packageResourcePath.replaceFirst(str2, str3);
            str = str.replaceFirst(str2, str3);
        }
        ZeusLogger.d(ZeusLogger.TAG_RESOURCES, str + " " + packageResourcePath + " " + str2 + " " + str3);
        if (TextUtils.equals(str, packageResourcePath) || str.contains("/tinker/patch-")) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || !str.contains(str2)) {
            return !TextUtils.isEmpty(str3) && str.contains(str3);
        }
        return true;
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getAnimation(int i10) {
        try {
            return super.getAnimation(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i10) {
        try {
            return super.getBoolean(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i10) {
        try {
            return super.getColor(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i10) {
        try {
            return super.getColorStateList(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public float getDimension(int i10) {
        try {
            return super.getDimension(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i10) {
        try {
            return super.getDimensionPixelOffset(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i10) {
        try {
            return super.getDimensionPixelSize(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) {
        try {
            return super.getDrawable(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i10, int i11) {
        try {
            return super.getDrawableForDensity(i10, i11);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public float getFloat(int i10) {
        try {
            return super.getFloat(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public Typeface getFont(int i10) {
        try {
            return super.getFont(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public float getFraction(int i10, int i11, int i12) {
        try {
            return super.getFraction(i10, i11, i12);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public int[] getIntArray(int i10) {
        try {
            return super.getIntArray(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getInteger(int i10) {
        try {
            return super.getInteger(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getLayout(int i10) {
        try {
            return super.getLayout(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i10) {
        try {
            return super.getMovie(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i10, int i11, Object... objArr) {
        try {
            return super.getQuantityString(i10, i11, objArr);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getQuantityText(int i10, int i11) {
        try {
            return super.getQuantityText(i10, i11);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i10) {
        try {
            return super.getResourceEntryName(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i10) {
        try {
            return super.getResourceName(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i10) {
        try {
            return super.getResourcePackageName(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i10) {
        try {
            return super.getResourceTypeName(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i10) {
        try {
            return super.getString(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String[] getStringArray(int i10) {
        try {
            return super.getStringArray(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence getText(int i10) {
        try {
            return super.getText(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public CharSequence[] getTextArray(int i10) {
        try {
            return super.getTextArray(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i10, TypedValue typedValue, boolean z10) {
        try {
            super.getValue(i10, typedValue, z10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i10, int i11, TypedValue typedValue, boolean z10) {
        try {
            super.getValueForDensity(i10, i11, typedValue, z10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public XmlResourceParser getXml(int i10) {
        try {
            return super.getXml(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public TypedArray obtainTypedArray(int i10) {
        try {
            return super.obtainTypedArray(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i10) {
        try {
            return super.openRawResource(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i10) {
        try {
            return super.openRawResourceFd(i10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public int getColor(int i10, @Nullable Resources.Theme theme) {
        try {
            return super.getColor(i10, theme);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public ColorStateList getColorStateList(int i10, @Nullable Resources.Theme theme) {
        try {
            return super.getColorStateList(i10, theme);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawable(i10, theme);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @Nullable
    public Drawable getDrawableForDensity(int i10, int i11, @Nullable Resources.Theme theme) {
        try {
            return super.getDrawableForDensity(i10, i11, theme);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getQuantityString(int i10, int i11) {
        try {
            return super.getQuantityString(i10, i11);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public String getString(int i10, Object... objArr) {
        try {
            return super.getString(i10, objArr);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i10, CharSequence charSequence) {
        try {
            return super.getText(i10, charSequence);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z10) {
        try {
            super.getValue(str, typedValue, z10);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }

    @Override // android.content.res.Resources
    @NonNull
    public InputStream openRawResource(int i10, TypedValue typedValue) {
        try {
            return super.openRawResource(i10, typedValue);
        } catch (Resources.NotFoundException e2) {
            throw handleException(e2);
        }
    }
}
