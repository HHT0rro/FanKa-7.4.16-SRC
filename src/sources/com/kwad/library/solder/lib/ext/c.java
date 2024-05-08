package com.kwad.library.solder.lib.ext;

import android.os.Build;
import androidx.annotation.NonNull;
import com.android.internal.content.NativeLibraryHelper;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private final int ajA;
    private final String ajO;
    private final String ajP;
    private final String ajQ;
    private final String ajR;
    private final String ajS;
    private final String ajT;
    private final String ajU;
    private final boolean ajV;
    private final boolean ajW;
    private final boolean ajX;
    private ExecutorService ajY;
    private String ajZ;
    private byte[] aka;
    private boolean akb;
    private int akc;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {
        private static final String akd;
        private String ajU;
        private boolean ajX;
        private ExecutorService ajY;
        private String ajZ;
        private byte[] aka;
        private boolean akb;
        private int ake;
        private int ajA = 3;
        private String ajO = "sodler";
        private String ajP = "code-cache";
        private String ajQ = NativeLibraryHelper.LIB_DIR_NAME;
        private String ajR = "temp";
        private String ajT = akd;
        private String ajS = ".tmp";
        private boolean ajW = false;
        private boolean ajV = false;

        static {
            akd = Build.VERSION.SDK_INT == 30 ? "base-1_apk" : "base-1.apk";
        }

        public final a a(ExecutorService executorService) {
            this.ajY = executorService;
            return this;
        }

        public final a bP(@NonNull String str) {
            this.ajO = str;
            return this;
        }

        public final a bQ(int i10) {
            if (i10 > 0) {
                this.ajA = i10;
            }
            return this;
        }

        public final a bR(int i10) {
            this.ake = i10;
            return this;
        }

        public final a bh(boolean z10) {
            this.akb = false;
            return this;
        }

        public final a bi(boolean z10) {
            this.ajX = z10;
            return this;
        }

        public final c xJ() {
            return new c(this.ajV, this.ajW, this.ajU, this.ajO, this.ajP, this.ajQ, this.ajR, this.ajS, this.ajT, this.ajA, this.ajZ, this.aka, this.akb, this.ajX, this.ajY, this.ake, (byte) 0);
        }
    }

    public /* synthetic */ c(boolean z10, boolean z11, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, String str8, byte[] bArr, boolean z12, boolean z13, ExecutorService executorService, int i11, byte b4) {
        this(z10, z11, str, str2, str3, str4, str5, str6, str7, i10, str8, bArr, z12, z13, executorService, i11);
    }

    public final int getRetryCount() {
        return this.ajA;
    }

    public final String xA() {
        return this.ajO;
    }

    public final String xB() {
        return this.ajP;
    }

    public final String xC() {
        return this.ajQ;
    }

    public final String xD() {
        return this.ajR;
    }

    public final String xE() {
        return this.ajS;
    }

    public final String xF() {
        return this.ajT;
    }

    public final boolean xG() {
        return this.ajW;
    }

    public final boolean xH() {
        return this.ajX;
    }

    public final ExecutorService xI() {
        return this.ajY;
    }

    public final int xz() {
        return this.akc;
    }

    private c(boolean z10, boolean z11, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, String str8, byte[] bArr, boolean z12, boolean z13, ExecutorService executorService, int i11) {
        this.ajA = i10;
        this.ajO = str2;
        this.ajP = str3;
        this.ajQ = str4;
        this.ajR = str5;
        this.ajS = str6;
        this.ajT = str7;
        this.ajU = str;
        this.ajV = z10;
        this.ajW = z11;
        this.ajZ = str8;
        this.aka = bArr;
        this.akb = z12;
        this.ajX = z13;
        this.ajY = executorService;
        this.akc = i11;
    }
}
