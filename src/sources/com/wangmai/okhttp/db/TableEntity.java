package com.wangmai.okhttp.db;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TableEntity {
    public List<ColumnEntity> list = new ArrayList();
    public String tableName;

    public TableEntity(String str) {
        this.tableName = str;
    }

    public TableEntity addColumn(ColumnEntity columnEntity) {
        this.list.add(columnEntity);
        return this;
    }

    public String buildTableString() {
        StringBuilder sb2 = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb2.append(this.tableName);
        sb2.append('(');
        for (ColumnEntity columnEntity : this.list) {
            if (columnEntity.compositePrimaryKey != null) {
                sb2.append("PRIMARY KEY (");
                for (String str : columnEntity.compositePrimaryKey) {
                    sb2.append(str);
                    sb2.append(",");
                }
                sb2.deleteCharAt(sb2.length() - 1);
                sb2.append(")");
            } else {
                sb2.append(columnEntity.columnName);
                sb2.append(" ");
                sb2.append(columnEntity.columnType);
                if (columnEntity.isNotNull) {
                    sb2.append(" NOT NULL");
                }
                if (columnEntity.isPrimary) {
                    sb2.append(" PRIMARY KEY");
                }
                if (columnEntity.isAutoincrement) {
                    sb2.append(" AUTOINCREMENT");
                }
                sb2.append(",");
            }
        }
        if (sb2.toString().endsWith(",")) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append(')');
        return sb2.toString();
    }

    public int getColumnCount() {
        return this.list.size();
    }

    public int getColumnIndex(String str) {
        int columnCount = getColumnCount();
        for (int i10 = 0; i10 < columnCount; i10++) {
            if (this.list.get(i10).columnName.equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    public String getColumnName(int i10) {
        return this.list.get(i10).columnName;
    }
}
