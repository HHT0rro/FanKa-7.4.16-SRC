package org.greenrobot.greendao;

import java.util.Collection;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Property {
    public final String columnName;
    public final String name;
    public final int ordinal;
    public final boolean primaryKey;
    public final Class<?> type;

    public Property(int i10, Class<?> cls, String str, boolean z10, String str2) {
        this.ordinal = i10;
        this.type = cls;
        this.name = str;
        this.primaryKey = z10;
        this.columnName = str2;
    }

    public WhereCondition between(Object obj, Object obj2) {
        return new WhereCondition.PropertyCondition(this, " BETWEEN ? AND ?", new Object[]{obj, obj2});
    }

    public WhereCondition eq(Object obj) {
        return new WhereCondition.PropertyCondition(this, "=?", obj);
    }

    public WhereCondition ge(Object obj) {
        return new WhereCondition.PropertyCondition(this, ">=?", obj);
    }

    public WhereCondition gt(Object obj) {
        return new WhereCondition.PropertyCondition(this, ">?", obj);
    }

    public WhereCondition in(Object... objArr) {
        StringBuilder sb2 = new StringBuilder(" IN (");
        SqlUtils.appendPlaceholders(sb2, objArr.length).append(')');
        return new WhereCondition.PropertyCondition(this, sb2.toString(), objArr);
    }

    public WhereCondition isNotNull() {
        return new WhereCondition.PropertyCondition(this, " IS NOT NULL");
    }

    public WhereCondition isNull() {
        return new WhereCondition.PropertyCondition(this, " IS NULL");
    }

    public WhereCondition le(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<=?", obj);
    }

    public WhereCondition like(String str) {
        return new WhereCondition.PropertyCondition(this, " LIKE ?", str);
    }

    public WhereCondition lt(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<?", obj);
    }

    public WhereCondition notEq(Object obj) {
        return new WhereCondition.PropertyCondition(this, "<>?", obj);
    }

    public WhereCondition notIn(Object... objArr) {
        StringBuilder sb2 = new StringBuilder(" NOT IN (");
        SqlUtils.appendPlaceholders(sb2, objArr.length).append(')');
        return new WhereCondition.PropertyCondition(this, sb2.toString(), objArr);
    }

    public WhereCondition in(Collection<?> collection) {
        return in(collection.toArray());
    }

    public WhereCondition notIn(Collection<?> collection) {
        return notIn(collection.toArray());
    }
}
