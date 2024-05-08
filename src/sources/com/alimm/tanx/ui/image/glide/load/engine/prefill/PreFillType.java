package com.alimm.tanx.ui.image.glide.load.engine.prefill;

import android.graphics.Bitmap;
import java.util.Objects;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PreFillType {
    public static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    public final Bitmap.Config config;
    public final int height;
    public final int weight;
    public final int width;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Builder {
        public Bitmap.Config config;
        public final int height;
        public int weight;
        public final int width;

        public Builder(int i10) {
            this(i10, i10);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(Bitmap.Config config) {
            this.config = config;
            return this;
        }

        public Builder setWeight(int i10) {
            if (i10 > 0) {
                this.weight = i10;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i10, int i11) {
            this.weight = 1;
            if (i10 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i11 > 0) {
                this.width = i10;
                this.height = i11;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    public PreFillType(int i10, int i11, Bitmap.Config config, int i12) {
        Objects.requireNonNull(config, "Config must not be null");
        this.width = i10;
        this.height = i11;
        this.config = config;
        this.weight = i12;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        return this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((this.config.hashCode() + (((this.width * 31) + this.height) * 31)) * 31) + this.weight;
    }

    public String toString() {
        StringBuilder a10 = a.a("PreFillSize{width=");
        a10.append(this.width);
        a10.append(", height=");
        a10.append(this.height);
        a10.append(", config=");
        a10.append((Object) this.config);
        a10.append(", weight=");
        a10.append(this.weight);
        a10.append('}');
        return a10.toString();
    }
}
