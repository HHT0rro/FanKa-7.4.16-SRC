package java.sql;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BatchUpdateException extends SQLException {
    private static final long serialVersionUID = 5977529877145521757L;
    private final int[] updateCounts;

    public BatchUpdateException(String reason, String SQLState, int vendorCode, int[] updateCounts) {
        super(reason, SQLState, vendorCode);
        this.updateCounts = updateCounts == null ? null : Arrays.copyOf(updateCounts, updateCounts.length);
    }

    public BatchUpdateException(String reason, String SQLState, int[] updateCounts) {
        this(reason, SQLState, 0, updateCounts);
    }

    public BatchUpdateException(String reason, int[] updateCounts) {
        this(reason, (String) null, 0, updateCounts);
    }

    public BatchUpdateException(int[] updateCounts) {
        this((String) null, (String) null, 0, updateCounts);
    }

    public BatchUpdateException() {
        this((String) null, (String) null, 0, (int[]) null);
    }

    public BatchUpdateException(Throwable cause) {
        this(cause == null ? null : cause.toString(), null, 0, null, cause);
    }

    public BatchUpdateException(int[] updateCounts, Throwable cause) {
        this(cause == null ? null : cause.toString(), null, 0, updateCounts, cause);
    }

    public BatchUpdateException(String reason, int[] updateCounts, Throwable cause) {
        this(reason, null, 0, updateCounts, cause);
    }

    public BatchUpdateException(String reason, String SQLState, int[] updateCounts, Throwable cause) {
        this(reason, SQLState, 0, updateCounts, cause);
    }

    public BatchUpdateException(String reason, String SQLState, int vendorCode, int[] updateCounts, Throwable cause) {
        super(reason, SQLState, vendorCode, cause);
        this.updateCounts = updateCounts == null ? null : Arrays.copyOf(updateCounts, updateCounts.length);
    }

    public int[] getUpdateCounts() {
        int[] iArr = this.updateCounts;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }
}
