package android.view.displayhash;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface DisplayHashResultCallback {
    public static final int DISPLAY_HASH_ERROR_INVALID_BOUNDS = -2;
    public static final int DISPLAY_HASH_ERROR_INVALID_HASH_ALGORITHM = -5;
    public static final int DISPLAY_HASH_ERROR_MISSING_WINDOW = -3;
    public static final int DISPLAY_HASH_ERROR_NOT_VISIBLE_ON_SCREEN = -4;
    public static final int DISPLAY_HASH_ERROR_TOO_MANY_REQUESTS = -6;
    public static final int DISPLAY_HASH_ERROR_UNKNOWN = -1;
    public static final String EXTRA_DISPLAY_HASH = "DISPLAY_HASH";
    public static final String EXTRA_DISPLAY_HASH_ERROR_CODE = "DISPLAY_HASH_ERROR_CODE";

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface DisplayHashErrorCode {
    }

    void onDisplayHashError(int i10);

    void onDisplayHashResult(DisplayHash displayHash);
}
