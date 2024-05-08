package com.ss.android.socialbase.downloader.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SqlUtils {
    public static StringBuilder appendColumn(StringBuilder sb2, String str) {
        sb2.append('\"');
        sb2.append(str);
        sb2.append('\"');
        return sb2;
    }

    public static StringBuilder appendColumns(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append('\"');
            sb2.append(strArr[i10]);
            sb2.append('\"');
            if (i10 < length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder sb2, String str, String[] strArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            appendColumn(sb2, str, strArr[i10]).append("=?");
            if (i10 < strArr.length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder sb2, String[] strArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            appendColumn(sb2, strArr[i10]).append("=?");
            if (i10 < strArr.length - 1) {
                sb2.append(',');
            }
        }
        return sb2;
    }

    public static StringBuilder appendPlaceholders(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 < i10 - 1) {
                sb2.append("?,");
            } else {
                sb2.append('?');
            }
        }
        return sb2;
    }

    public static String createSqlDelete(String str, String[] strArr) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb2 = new StringBuilder("DELETE FROM ");
        sb2.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb2.append(" WHERE ");
            appendColumnsEqValue(sb2, str2, strArr);
        }
        return sb2.toString();
    }

    public static String createSqlInsert(String str, String str2, String[] strArr) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('\"');
        sb2.append(str2);
        sb2.append('\"');
        sb2.append(" (");
        appendColumns(sb2, strArr);
        sb2.append(") VALUES (");
        appendPlaceholders(sb2, strArr.length);
        sb2.append(')');
        return sb2.toString();
    }

    public static String createSqlInsertOrReplace(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb2 = new StringBuilder("INSERT OR REPLACE INTO ");
        sb2.append('\"' + str + '\"');
        sb2.append(" (");
        appendColumns(sb2, strArr);
        sb2.append(") VALUES (");
        appendPlaceholders(sb2, strArr.length);
        sb2.append(')');
        return sb2.toString();
    }

    public static String createSqlUpdate(String str, String[] strArr, String[] strArr2) {
        String str2 = '\"' + str + '\"';
        StringBuilder sb2 = new StringBuilder("UPDATE ");
        sb2.append(str2);
        sb2.append(" SET ");
        appendColumnsEqualPlaceholders(sb2, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb2.append(" WHERE ");
            appendColumnsEqValue(sb2, str2, strArr2);
        }
        return sb2.toString();
    }

    public static StringBuilder appendColumn(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(".\"");
        sb2.append(str2);
        sb2.append('\"');
        return sb2;
    }
}
