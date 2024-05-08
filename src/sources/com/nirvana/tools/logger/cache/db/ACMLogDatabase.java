package com.nirvana.tools.logger.cache.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.nirvana.tools.logger.model.ACMLoggerRecord;
import com.nirvana.tools.logger.utils.ConsoleLogUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMLogDatabase extends AbstractDatabase<ACMLoggerRecord> {
    private static final String LOG_DATABASE_NAME = "logger.db";
    private static final String TAG = "ALICOM_LoggerDao";

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ACMLogDatabase(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            com.nirvana.tools.logger.cache.db.DBHelper r8 = new com.nirvana.tools.logger.cache.db.DBHelper
            if (r12 != 0) goto L7
            java.lang.String r12 = "logger.db"
            goto L18
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            java.lang.String r12 = "_logger.db"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
        L18:
            r2 = r12
            r3 = 0
            r4 = 3
            java.lang.String r5 = com.nirvana.tools.logger.cache.db.DBHelpTool.getCreateLogTableSql(r11)
            java.lang.String r6 = com.nirvana.tools.logger.cache.db.DBHelpTool.getDropTableSql(r11)
            java.lang.String r7 = com.nirvana.tools.logger.cache.db.DBHelpTool.getCreateLogIndexSql(r11)
            r0 = r8
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r9.<init>(r11, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nirvana.tools.logger.cache.db.ACMLogDatabase.<init>(android.content.Context, java.lang.String, java.lang.String):void");
    }

    @Override // com.nirvana.tools.logger.cache.db.AbstractDatabase
    public ContentValues getContentValuesByRecord(ACMLoggerRecord aCMLoggerRecord) {
        if (aCMLoggerRecord == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("strategy", Integer.valueOf(aCMLoggerRecord.getStrategy()));
        contentValues.put("timestamp", Long.valueOf(aCMLoggerRecord.getTimestamp()));
        contentValues.put("content", aCMLoggerRecord.getContent());
        contentValues.put(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, Integer.valueOf(aCMLoggerRecord.getLevel()));
        contentValues.put(DBHelpTool.RecordEntry.COLUMN_UPLOAD_FLAG, Integer.valueOf(aCMLoggerRecord.getUploadFlag()));
        contentValues.put(DBHelpTool.RecordEntry.COLUMN_UPLOAD_COUNT, Integer.valueOf(aCMLoggerRecord.getUploadCount()));
        return contentValues;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nirvana.tools.logger.cache.db.AbstractDatabase
    public ACMLoggerRecord parseDataFromCursor(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ACMLoggerRecord aCMLoggerRecord = new ACMLoggerRecord();
        aCMLoggerRecord.setId(cursor.getLong(cursor.getColumnIndex("_id")));
        aCMLoggerRecord.setLevel(cursor.getInt(cursor.getColumnIndex(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL)));
        aCMLoggerRecord.setStrategy(cursor.getInt(cursor.getColumnIndex("strategy")));
        aCMLoggerRecord.setContent(cursor.getString(cursor.getColumnIndex("content")));
        aCMLoggerRecord.setUploadFlag(cursor.getInt(cursor.getColumnIndex(DBHelpTool.RecordEntry.COLUMN_UPLOAD_FLAG)));
        aCMLoggerRecord.setUploadCount(cursor.getInt(cursor.getColumnIndex(DBHelpTool.RecordEntry.COLUMN_UPLOAD_COUNT)));
        aCMLoggerRecord.setTimestamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
        return aCMLoggerRecord;
    }

    public synchronized List<ACMLoggerRecord> queryLog(long j10, long j11, int i10, int i11, int i12) {
        ArrayList arrayList;
        try {
            ArrayList arrayList2 = new ArrayList();
            StringBuilder sb2 = new StringBuilder();
            arrayList2.add(String.valueOf(i12));
            sb2.append("level=?");
            if (j10 > 0) {
                arrayList2.add(String.valueOf(j10));
                sb2.append(" and timestamp");
                sb2.append(">=?");
            }
            if (j11 > 0) {
                arrayList2.add(String.valueOf(j11));
                sb2.append(" and timestamp<=?");
            }
            if (i11 >= 0) {
                arrayList2.add(String.valueOf(i11));
                sb2.append(" and upload_flag=?");
            }
            String valueOf = i10 > 0 ? String.valueOf(i10) : "";
            String[] strArr = new String[arrayList2.size()];
            arrayList2.toArray(strArr);
            ConsoleLogUtils.logcatV(TAG, "query: selection=" + ((Object) sb2));
            arrayList = new ArrayList();
            Cursor query = getReadDatabase().query(this.mTableName, null, sb2.toString(), strArr, null, null, null, valueOf);
            while (query.moveToNext()) {
                ACMLoggerRecord parseDataFromCursor = parseDataFromCursor(query);
                if (parseDataFromCursor != null) {
                    arrayList.add(parseDataFromCursor);
                }
            }
            query.close();
            ConsoleLogUtils.logcatV(TAG, "query: result=" + ((Object) arrayList) + ", size=" + arrayList.size());
            close();
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                close();
                return null;
            } catch (Throwable th2) {
                close();
                throw th2;
            }
        }
        return arrayList;
    }
}
