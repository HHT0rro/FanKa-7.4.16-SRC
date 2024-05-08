package com.tencent.liteav.base.util;

import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Size {
    public int height;
    public int width;

    public Size() {
        this.width = 0;
        this.height = 0;
    }

    public double aspectRatio() {
        return (this.width * 1.0d) / this.height;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return size.width == this.width && size.height == this.height;
    }

    public int getArea() {
        if (isValid()) {
            return this.width * this.height;
        }
        return 0;
    }

    @CalledByNative
    public int getHeight() {
        return this.height;
    }

    @CalledByNative
    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public boolean isValid() {
        return this.width > 0 && this.height > 0;
    }

    public void set(Size size) {
        if (size != null) {
            this.width = size.width;
            this.height = size.height;
        } else {
            this.width = 0;
            this.height = 0;
        }
    }

    public void swap() {
        int i10 = this.width;
        this.width = this.height;
        this.height = i10;
    }

    public String toString() {
        return "Size(" + this.width + ", " + this.height + ")";
    }

    @CalledByNative
    public Size(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public void set(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public Size(Size size) {
        this.width = 0;
        this.height = 0;
        set(size);
    }
}
