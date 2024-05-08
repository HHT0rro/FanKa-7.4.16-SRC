package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngjException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PngBadCharsetException extends PngjException {
    private static final long serialVersionUID = 1;

    public PngBadCharsetException(String str, Throwable th) {
        super(str, th);
    }

    public PngBadCharsetException(String str) {
        super(str);
    }

    public PngBadCharsetException(Throwable th) {
        super(th);
    }
}
