package com.huawei.hms.common.size;

import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.hms.common.internal.Objects;
import sun.util.locale.LanguageTag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Size {

    /* renamed from: a, reason: collision with root package name */
    private final int f29751a;

    /* renamed from: b, reason: collision with root package name */
    private final int f29752b;

    public Size(int i10, int i11) {
        this.f29751a = i10;
        this.f29752b = i11;
    }

    public static Size parseSize(String str) {
        try {
            int indexOf = str.indexOf(LanguageTag.PRIVATEUSE);
            if (indexOf < 0) {
                indexOf = str.indexOf(StringUtils.NO_PRINT_CODE);
            }
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f29751a == size.f29751a && this.f29752b == size.f29752b;
    }

    public final int getHeight() {
        return this.f29752b;
    }

    public final int getWidth() {
        return this.f29751a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        return "Width is " + this.f29751a + " Height is " + this.f29752b;
    }
}
