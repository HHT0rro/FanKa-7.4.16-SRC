package com.huawei.hms.ml.scan;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HmsScanFrameOptions {
    private boolean multiMode;
    private boolean parseResult;
    private boolean photoMode;
    private int type;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Creator {
        private int type = 0;
        private boolean multiMode = false;
        private boolean photoMode = false;
        private boolean parseResult = true;

        public HmsScanFrameOptions create() {
            return new HmsScanFrameOptions(this.type, this.photoMode, this.multiMode, this.parseResult);
        }

        public Creator setHmsScanTypes(int i10, int... iArr) {
            this.type = i10;
            if (iArr != null && iArr.length > 0) {
                for (int i11 : iArr) {
                    this.type = i11 | this.type;
                }
            }
            return this;
        }

        public Creator setMultiMode(boolean z10) {
            this.multiMode = z10;
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
    }

    public int getType() {
        return this.type;
    }

    public boolean isMultiMode() {
        return this.multiMode;
    }

    public boolean isParseResult() {
        return this.parseResult;
    }

    public boolean isPhotoMode() {
        return this.photoMode;
    }

    private HmsScanFrameOptions(int i10, boolean z10, boolean z11, boolean z12) {
        this.type = i10;
        this.photoMode = z10;
        this.multiMode = z11;
        this.parseResult = z12;
    }
}
