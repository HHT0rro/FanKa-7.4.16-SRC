package com.huawei.hms.ml.scan;

import com.huawei.hms.scankit.p.w7;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HmsScanAnalyzerOptions {
    public final boolean errorCheck;
    public final int mode;
    public final boolean parseResult;
    public final boolean photoMode;
    public final boolean showGuide;
    public final int viewType;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Creator {
        private int type = 0;
        private boolean photoMode = false;
        private int viewType = 0;
        private boolean errorCheck = false;
        private boolean parseResult = true;
        private boolean showGuide = false;

        public HmsScanAnalyzerOptions create() {
            return new HmsScanAnalyzerOptions(this.type, this.photoMode, this.viewType, this.errorCheck, this.parseResult, this.showGuide);
        }

        public Creator setErrorCheck(boolean z10) {
            this.errorCheck = z10;
            return this;
        }

        public Creator setHmsScanTypes(int i10, int... iArr) {
            int a10 = w7.a(i10);
            this.type = a10;
            if (iArr != null && iArr.length > 0) {
                this.type = w7.b(a10);
                for (int i11 : iArr) {
                    this.type = w7.b(i11) | this.type;
                }
            }
            return this;
        }

        public Creator setParseResult(boolean z10) {
            this.parseResult = z10;
            return this;
        }

        public Creator setPhotoMode(boolean z10) {
            this.photoMode = z10;
            return this;
        }

        public Creator setShowGuide(boolean z10) {
            this.showGuide = z10;
            return this;
        }

        public Creator setViewType(int i10) {
            this.viewType = i10;
            return this;
        }
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return super.hashCode();
    }

    private HmsScanAnalyzerOptions(int i10, boolean z10, int i11, boolean z11, boolean z12, boolean z13) {
        this.mode = i10;
        this.photoMode = z10;
        this.viewType = i11;
        this.errorCheck = z11;
        this.parseResult = z12;
        this.showGuide = z13;
    }
}
