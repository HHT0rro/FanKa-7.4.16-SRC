package android.view.inputmethod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TextBoundsInfoResult {
    public static final int CODE_CANCELLED = 3;
    public static final int CODE_FAILED = 2;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_UNSUPPORTED = 0;
    private final int mResultCode;
    private final TextBoundsInfo mTextBoundsInfo;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface ResultCode {
    }

    public TextBoundsInfoResult(int resultCode) {
        this(resultCode, null);
    }

    public TextBoundsInfoResult(int resultCode, TextBoundsInfo textBoundsInfo) {
        if (resultCode == 1 && textBoundsInfo == null) {
            throw new IllegalStateException("TextBoundsInfo must be provided when the resultCode is CODE_SUCCESS.");
        }
        this.mResultCode = resultCode;
        this.mTextBoundsInfo = textBoundsInfo;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public TextBoundsInfo getTextBoundsInfo() {
        return this.mTextBoundsInfo;
    }
}
