package org.greenrobot.greendao.query;

import android.database.sqlite.SQLiteDatabase;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.rx.RxQuery;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class QueryBuilder<T> {
    public static boolean LOG_SQL;
    public static boolean LOG_VALUES;
    private final AbstractDao<T, ?> dao;
    private boolean distinct;
    private final List<Join<T, ?>> joins;
    private Integer limit;
    private Integer offset;
    private StringBuilder orderBuilder;
    private String stringOrderCollation;
    private final String tablePrefix;
    private final List<Object> values;
    private final WhereCollector<T> whereCollector;

    public QueryBuilder(AbstractDao<T, ?> abstractDao) {
        this(abstractDao, ExifInterface.GPS_DIRECTION_TRUE);
    }

    private <J> Join<T, J> addJoin(String str, Property property, AbstractDao<J, ?> abstractDao, Property property2) {
        Join<T, J> join = new Join<>(str, property, abstractDao, property2, ContentClassification.AD_CONTENT_CLASSIFICATION_J + (this.joins.size() + 1));
        this.joins.add(join);
        return join;
    }

    private void appendJoinsAndWheres(StringBuilder sb2, String str) {
        this.values.clear();
        for (Join<T, ?> join : this.joins) {
            sb2.append(" JOIN ");
            sb2.append('\"');
            sb2.append(join.daoDestination.getTablename());
            sb2.append('\"');
            sb2.append(' ');
            sb2.append(join.tablePrefix);
            sb2.append(" ON ");
            SqlUtils.appendProperty(sb2, join.sourceTablePrefix, join.joinPropertySource).append('=');
            SqlUtils.appendProperty(sb2, join.tablePrefix, join.joinPropertyDestination);
        }
        boolean z10 = !this.whereCollector.isEmpty();
        if (z10) {
            sb2.append(" WHERE ");
            this.whereCollector.appendWhereClause(sb2, str, this.values);
        }
        for (Join<T, ?> join2 : this.joins) {
            if (!join2.whereCollector.isEmpty()) {
                if (!z10) {
                    sb2.append(" WHERE ");
                    z10 = true;
                } else {
                    sb2.append(" AND ");
                }
                join2.whereCollector.appendWhereClause(sb2, join2.tablePrefix, this.values);
            }
        }
    }

    private int checkAddLimit(StringBuilder sb2) {
        if (this.limit == null) {
            return -1;
        }
        sb2.append(" LIMIT ?");
        this.values.add(this.limit);
        return this.values.size() - 1;
    }

    private int checkAddOffset(StringBuilder sb2) {
        if (this.offset == null) {
            return -1;
        }
        if (this.limit != null) {
            sb2.append(" OFFSET ?");
            this.values.add(this.offset);
            return this.values.size() - 1;
        }
        throw new IllegalStateException("Offset cannot be set without limit");
    }

    private void checkLog(String str) {
        if (LOG_SQL) {
            DaoLog.d("Built SQL for query: " + str);
        }
        if (LOG_VALUES) {
            DaoLog.d("Values for query: " + ((Object) this.values));
        }
    }

    private void checkOrderBuilder() {
        StringBuilder sb2 = this.orderBuilder;
        if (sb2 == null) {
            this.orderBuilder = new StringBuilder();
        } else if (sb2.length() > 0) {
            this.orderBuilder.append(",");
        }
    }

    private StringBuilder createSelectBuilder() {
        StringBuilder sb2 = new StringBuilder(SqlUtils.createSqlSelect(this.dao.getTablename(), this.tablePrefix, this.dao.getAllColumns(), this.distinct));
        appendJoinsAndWheres(sb2, this.tablePrefix);
        StringBuilder sb3 = this.orderBuilder;
        if (sb3 != null && sb3.length() > 0) {
            sb2.append(" ORDER BY ");
            sb2.append((CharSequence) this.orderBuilder);
        }
        return sb2;
    }

    public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> abstractDao) {
        return new QueryBuilder<>(abstractDao);
    }

    private void orderAscOrDesc(String str, Property... propertyArr) {
        String str2;
        for (Property property : propertyArr) {
            checkOrderBuilder();
            append(this.orderBuilder, property);
            if (String.class.equals(property.type) && (str2 = this.stringOrderCollation) != null) {
                this.orderBuilder.append(str2);
            }
            this.orderBuilder.append(str);
        }
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.whereCollector.combineWhereConditions(" AND ", whereCondition, whereCondition2, whereConditionArr);
    }

    public StringBuilder append(StringBuilder sb2, Property property) {
        this.whereCollector.checkProperty(property);
        sb2.append(this.tablePrefix);
        sb2.append('.');
        sb2.append('\'');
        sb2.append(property.columnName);
        sb2.append('\'');
        return sb2;
    }

    public Query<T> build() {
        StringBuilder createSelectBuilder = createSelectBuilder();
        int checkAddLimit = checkAddLimit(createSelectBuilder);
        int checkAddOffset = checkAddOffset(createSelectBuilder);
        String sb2 = createSelectBuilder.toString();
        checkLog(sb2);
        return Query.create(this.dao, sb2, this.values.toArray(), checkAddLimit, checkAddOffset);
    }

    public CountQuery<T> buildCount() {
        StringBuilder sb2 = new StringBuilder(SqlUtils.createSqlSelectCountStar(this.dao.getTablename(), this.tablePrefix));
        appendJoinsAndWheres(sb2, this.tablePrefix);
        String sb3 = sb2.toString();
        checkLog(sb3);
        return CountQuery.create(this.dao, sb3, this.values.toArray());
    }

    public CursorQuery buildCursor() {
        StringBuilder createSelectBuilder = createSelectBuilder();
        int checkAddLimit = checkAddLimit(createSelectBuilder);
        int checkAddOffset = checkAddOffset(createSelectBuilder);
        String sb2 = createSelectBuilder.toString();
        checkLog(sb2);
        return CursorQuery.create(this.dao, sb2, this.values.toArray(), checkAddLimit, checkAddOffset);
    }

    public DeleteQuery<T> buildDelete() {
        if (this.joins.isEmpty()) {
            String tablename = this.dao.getTablename();
            StringBuilder sb2 = new StringBuilder(SqlUtils.createSqlDelete(tablename, null));
            appendJoinsAndWheres(sb2, this.tablePrefix);
            String replace = sb2.toString().replace(this.tablePrefix + ".\"", '\"' + tablename + "\".\"");
            checkLog(replace);
            return DeleteQuery.create(this.dao, replace, this.values.toArray());
        }
        throw new DaoException("JOINs are not supported for DELETE queries");
    }

    public long count() {
        return buildCount().count();
    }

    public QueryBuilder<T> distinct() {
        this.distinct = true;
        return this;
    }

    public <J> Join<T, J> join(Class<J> cls, Property property) {
        return join(this.dao.getPkProperty(), cls, property);
    }

    public QueryBuilder<T> limit(int i10) {
        this.limit = Integer.valueOf(i10);
        return this;
    }

    public List<T> list() {
        return build().list();
    }

    public CloseableListIterator<T> listIterator() {
        return build().listIterator();
    }

    public LazyList<T> listLazy() {
        return build().listLazy();
    }

    public LazyList<T> listLazyUncached() {
        return build().listLazyUncached();
    }

    public QueryBuilder<T> offset(int i10) {
        this.offset = Integer.valueOf(i10);
        return this;
    }

    public WhereCondition or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.whereCollector.combineWhereConditions(" OR ", whereCondition, whereCondition2, whereConditionArr);
    }

    public QueryBuilder<T> orderAsc(Property... propertyArr) {
        orderAscOrDesc(" ASC", propertyArr);
        return this;
    }

    public QueryBuilder<T> orderCustom(Property property, String str) {
        checkOrderBuilder();
        append(this.orderBuilder, property).append(' ');
        this.orderBuilder.append(str);
        return this;
    }

    public QueryBuilder<T> orderDesc(Property... propertyArr) {
        orderAscOrDesc(" DESC", propertyArr);
        return this;
    }

    public QueryBuilder<T> orderRaw(String str) {
        checkOrderBuilder();
        this.orderBuilder.append(str);
        return this;
    }

    public QueryBuilder<T> preferLocalizedStringOrder() {
        if (this.dao.getDatabase().getRawDatabase() instanceof SQLiteDatabase) {
            this.stringOrderCollation = " COLLATE LOCALIZED";
        }
        return this;
    }

    @Experimental
    public RxQuery<T> rx() {
        return build().__InternalRx();
    }

    @Experimental
    public RxQuery<T> rxPlain() {
        return build().__internalRxPlain();
    }

    public QueryBuilder<T> stringOrderCollation(String str) {
        if (str != null && !str.startsWith(" ")) {
            str = " " + str;
        }
        this.stringOrderCollation = str;
        return this;
    }

    public T unique() {
        return build().unique();
    }

    public T uniqueOrThrow() {
        return build().uniqueOrThrow();
    }

    public QueryBuilder<T> where(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        this.whereCollector.add(whereCondition, whereConditionArr);
        return this;
    }

    public QueryBuilder<T> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        this.whereCollector.add(or(whereCondition, whereCondition2, whereConditionArr), new WhereCondition[0]);
        return this;
    }

    public QueryBuilder(AbstractDao<T, ?> abstractDao, String str) {
        this.dao = abstractDao;
        this.tablePrefix = str;
        this.values = new ArrayList();
        this.joins = new ArrayList();
        this.whereCollector = new WhereCollector<>(abstractDao, str);
        this.stringOrderCollation = " COLLATE NOCASE";
    }

    public <J> Join<T, J> join(Property property, Class<J> cls) {
        AbstractDao<?, ?> dao = this.dao.getSession().getDao(cls);
        return addJoin(this.tablePrefix, property, dao, dao.getPkProperty());
    }

    public <J> Join<T, J> join(Property property, Class<J> cls, Property property2) {
        return addJoin(this.tablePrefix, property, this.dao.getSession().getDao(cls), property2);
    }

    public <J> Join<T, J> join(Join<?, T> join, Property property, Class<J> cls, Property property2) {
        return addJoin(join.tablePrefix, property, this.dao.getSession().getDao(cls), property2);
    }
}
