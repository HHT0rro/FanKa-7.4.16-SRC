package org.greenrobot.greendao.query;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Join<SRC, DST> {
    public final AbstractDao<DST, ?> daoDestination;
    public final Property joinPropertyDestination;
    public final Property joinPropertySource;
    public final String sourceTablePrefix;
    public final String tablePrefix;
    public final WhereCollector<DST> whereCollector;

    public Join(String str, Property property, AbstractDao<DST, ?> abstractDao, Property property2, String str2) {
        this.sourceTablePrefix = str;
        this.joinPropertySource = property;
        this.daoDestination = abstractDao;
        this.joinPropertyDestination = property2;
        this.tablePrefix = str2;
        this.whereCollector = new WhereCollector<>(abstractDao, str2);
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.whereCollector.combineWhereConditions(" AND ", whereCondition, whereCondition2, whereConditionArr);
    }

    public String getTablePrefix() {
        return this.tablePrefix;
    }

    public WhereCondition or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.whereCollector.combineWhereConditions(" OR ", whereCondition, whereCondition2, whereConditionArr);
    }

    public Join<SRC, DST> where(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        this.whereCollector.add(whereCondition, whereConditionArr);
        return this;
    }

    public Join<SRC, DST> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        this.whereCollector.add(or(whereCondition, whereCondition2, whereConditionArr), new WhereCondition[0]);
        return this;
    }
}
