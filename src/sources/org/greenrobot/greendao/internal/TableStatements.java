package org.greenrobot.greendao.internal;

import androidx.exifinterface.media.ExifInterface;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TableStatements {
    private final String[] allColumns;
    private DatabaseStatement countStatement;

    /* renamed from: db, reason: collision with root package name */
    private final Database f52442db;
    private DatabaseStatement deleteStatement;
    private DatabaseStatement insertOrReplaceStatement;
    private DatabaseStatement insertStatement;
    private final String[] pkColumns;
    private volatile String selectAll;
    private volatile String selectByKey;
    private volatile String selectByRowId;
    private volatile String selectKeys;
    private final String tablename;
    private DatabaseStatement updateStatement;

    public TableStatements(Database database, String str, String[] strArr, String[] strArr2) {
        this.f52442db = database;
        this.tablename = str;
        this.allColumns = strArr;
        this.pkColumns = strArr2;
    }

    public DatabaseStatement getCountStatement() {
        if (this.countStatement == null) {
            this.countStatement = this.f52442db.compileStatement(SqlUtils.createSqlCount(this.tablename));
        }
        return this.countStatement;
    }

    public DatabaseStatement getDeleteStatement() {
        if (this.deleteStatement == null) {
            DatabaseStatement compileStatement = this.f52442db.compileStatement(SqlUtils.createSqlDelete(this.tablename, this.pkColumns));
            synchronized (this) {
                if (this.deleteStatement == null) {
                    this.deleteStatement = compileStatement;
                }
            }
            if (this.deleteStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.deleteStatement;
    }

    public DatabaseStatement getInsertOrReplaceStatement() {
        if (this.insertOrReplaceStatement == null) {
            DatabaseStatement compileStatement = this.f52442db.compileStatement(SqlUtils.createSqlInsert("INSERT OR REPLACE INTO ", this.tablename, this.allColumns));
            synchronized (this) {
                if (this.insertOrReplaceStatement == null) {
                    this.insertOrReplaceStatement = compileStatement;
                }
            }
            if (this.insertOrReplaceStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.insertOrReplaceStatement;
    }

    public DatabaseStatement getInsertStatement() {
        if (this.insertStatement == null) {
            DatabaseStatement compileStatement = this.f52442db.compileStatement(SqlUtils.createSqlInsert("INSERT INTO ", this.tablename, this.allColumns));
            synchronized (this) {
                if (this.insertStatement == null) {
                    this.insertStatement = compileStatement;
                }
            }
            if (this.insertStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.insertStatement;
    }

    public String getSelectAll() {
        if (this.selectAll == null) {
            this.selectAll = SqlUtils.createSqlSelect(this.tablename, ExifInterface.GPS_DIRECTION_TRUE, this.allColumns, false);
        }
        return this.selectAll;
    }

    public String getSelectByKey() {
        if (this.selectByKey == null) {
            StringBuilder sb2 = new StringBuilder(getSelectAll());
            sb2.append("WHERE ");
            SqlUtils.appendColumnsEqValue(sb2, ExifInterface.GPS_DIRECTION_TRUE, this.pkColumns);
            this.selectByKey = sb2.toString();
        }
        return this.selectByKey;
    }

    public String getSelectByRowId() {
        if (this.selectByRowId == null) {
            this.selectByRowId = getSelectAll() + "WHERE ROWID=?";
        }
        return this.selectByRowId;
    }

    public String getSelectKeys() {
        if (this.selectKeys == null) {
            this.selectKeys = SqlUtils.createSqlSelect(this.tablename, ExifInterface.GPS_DIRECTION_TRUE, this.pkColumns, false);
        }
        return this.selectKeys;
    }

    public DatabaseStatement getUpdateStatement() {
        if (this.updateStatement == null) {
            DatabaseStatement compileStatement = this.f52442db.compileStatement(SqlUtils.createSqlUpdate(this.tablename, this.allColumns, this.pkColumns));
            synchronized (this) {
                if (this.updateStatement == null) {
                    this.updateStatement = compileStatement;
                }
            }
            if (this.updateStatement != compileStatement) {
                compileStatement.close();
            }
        }
        return this.updateStatement;
    }
}
