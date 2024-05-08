package com.nirvana.tools.logger.cache.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import com.nirvana.tools.logger.model.ACMMonitorRecord;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMMonitorDatabase extends AbstractDatabase<ACMMonitorRecord> {
    private static final String MONITOR_DATABASE_NAME = "monitor.db";
    private static final String TAG = "ALICOM_MonitorDao";

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ACMMonitorDatabase(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            com.nirvana.tools.logger.cache.db.DBHelper r8 = new com.nirvana.tools.logger.cache.db.DBHelper
            if (r12 != 0) goto L7
            java.lang.String r12 = "monitor.db"
            goto L18
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            java.lang.String r12 = "_monitor.db"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
        L18:
            r2 = r12
            r3 = 0
            r4 = 3
            java.lang.String r5 = com.nirvana.tools.logger.cache.db.DBHelpTool.getCreateMonitorTableSql(r11)
            java.lang.String r6 = com.nirvana.tools.logger.cache.db.DBHelpTool.getDropTableSql(r11)
            java.lang.String r7 = com.nirvana.tools.logger.cache.db.DBHelpTool.getCreateMonitorIndexSql(r11)
            r0 = r8
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r9.<init>(r11, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nirvana.tools.logger.cache.db.ACMMonitorDatabase.<init>(android.content.Context, java.lang.String, java.lang.String):void");
    }

    @Override // com.nirvana.tools.logger.cache.db.AbstractDatabase
    public ContentValues getContentValuesByRecord(ACMMonitorRecord aCMMonitorRecord) {
        if (aCMMonitorRecord == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("strategy", Integer.valueOf(aCMMonitorRecord.getStrategy()));
        contentValues.put("timestamp", Long.valueOf(aCMMonitorRecord.getTimestamp()));
        contentValues.put("content", aCMMonitorRecord.getContent());
        contentValues.put("urgency", Integer.valueOf(aCMMonitorRecord.getUrgency()));
        contentValues.put(DBHelpTool.RecordEntry.COLUMN_UPLOAD_FLAG, Integer.valueOf(aCMMonitorRecord.getUploadFlag()));
        contentValues.put(DBHelpTool.RecordEntry.COLUMN_UPLOAD_COUNT, Integer.valueOf(aCMMonitorRecord.getUploadCount()));
        return contentValues;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nirvana.tools.logger.cache.db.AbstractDatabase
    public ACMMonitorRecord parseDataFromCursor(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ACMMonitorRecord aCMMonitorRecord = new ACMMonitorRecord();
        aCMMonitorRecord.setId(cursor.getLong(cursor.getColumnIndex("_id")));
        aCMMonitorRecord.setStrategy(cursor.getInt(cursor.getColumnIndex("strategy")));
        aCMMonitorRecord.setContent(cursor.getString(cursor.getColumnIndex("content")));
        aCMMonitorRecord.setUploadFlag(cursor.getInt(cursor.getColumnIndex(DBHelpTool.RecordEntry.COLUMN_UPLOAD_FLAG)));
        aCMMonitorRecord.setUploadCount(cursor.getInt(cursor.getColumnIndex(DBHelpTool.RecordEntry.COLUMN_UPLOAD_COUNT)));
        aCMMonitorRecord.setTimestamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
        aCMMonitorRecord.setUrgency(cursor.getInt(cursor.getColumnIndex("urgency")));
        return aCMMonitorRecord;
    }
}
