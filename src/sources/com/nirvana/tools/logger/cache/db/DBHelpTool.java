package com.nirvana.tools.logger.cache.db;

import android.provider.BaseColumns;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DBHelpTool {
    public static final String TABLE_NAME_LOGGER = "alitx_logger";
    public static final String TABLE_NAME_MONITOR = "alitx_monitor";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class RecordEntry implements BaseColumns {
        public static final String COLUMN_NAME_CONTENT = "content";
        public static final String COLUMN_NAME_LEVEL = "level";
        public static final String COLUMN_NAME_STRATEGY = "strategy";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
        public static final String COLUMN_NAME_URGENCY = "urgency";
        public static final String COLUMN_UPLOAD_COUNT = "upload_count";
        public static final String COLUMN_UPLOAD_FLAG = "upload_flag";

        public RecordEntry() {
        }
    }

    public static String getCreateLogIndexSql(String str) {
        return "CREATE INDEX log_index ON " + str + " (timestamp,level,upload_flag,strategy)";
    }

    public static String getCreateLogTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,timestamp NUMERIC,level INTEGER,strategy INTEGER,upload_flag INTEGER,upload_count INTEGER,content TEXT)";
    }

    public static String getCreateMonitorIndexSql(String str) {
        return "CREATE INDEX log_index ON " + str + " (urgency,upload_flag,strategy)";
    }

    public static String getCreateMonitorTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,timestamp NUMERIC,urgency INTEGER,strategy INTEGER,upload_flag INTEGER,upload_count INTEGER,content TEXT)";
    }

    public static String getDropTableSql(String str) {
        return "DROP TABLE IF EXISTS " + str;
    }
}
