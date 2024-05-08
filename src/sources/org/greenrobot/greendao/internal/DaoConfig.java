package org.greenrobot.greendao.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.identityscope.IdentityScopeObject;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DaoConfig implements Cloneable {
    public final String[] allColumns;

    /* renamed from: db, reason: collision with root package name */
    public final Database f52441db;
    private IdentityScope<?, ?> identityScope;
    public final boolean keyIsNumeric;
    public final String[] nonPkColumns;
    public final String[] pkColumns;
    public final Property pkProperty;
    public final Property[] properties;
    public final TableStatements statements;
    public final String tablename;

    public DaoConfig(Database database, Class<? extends AbstractDao<?, ?>> cls) {
        this.f52441db = database;
        try {
            this.tablename = (String) cls.getField("TABLENAME").get(null);
            Property[] reflectProperties = reflectProperties(cls);
            this.properties = reflectProperties;
            this.allColumns = new String[reflectProperties.length];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Property property = null;
            for (int i10 = 0; i10 < reflectProperties.length; i10++) {
                Property property2 = reflectProperties[i10];
                String str = property2.columnName;
                this.allColumns[i10] = str;
                if (property2.primaryKey) {
                    arrayList.add(str);
                    property = property2;
                } else {
                    arrayList2.add(str);
                }
            }
            this.nonPkColumns = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            this.pkColumns = strArr;
            Property property3 = strArr.length == 1 ? property : null;
            this.pkProperty = property3;
            this.statements = new TableStatements(database, this.tablename, this.allColumns, strArr);
            if (property3 != null) {
                Class<?> cls2 = property3.type;
                this.keyIsNumeric = cls2.equals(Long.TYPE) || cls2.equals(Long.class) || cls2.equals(Integer.TYPE) || cls2.equals(Integer.class) || cls2.equals(Short.TYPE) || cls2.equals(Short.class) || cls2.equals(Byte.TYPE) || cls2.equals(Byte.class);
            } else {
                this.keyIsNumeric = false;
            }
        } catch (Exception e2) {
            throw new DaoException("Could not init DAOConfig", e2);
        }
    }

    private static Property[] reflectProperties(Class<? extends AbstractDao<?, ?>> cls) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        Field[] declaredFields = Class.forName(cls.getName() + "$Properties").getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 9) == 9) {
                Object obj = field.get(null);
                if (obj instanceof Property) {
                    arrayList.add((Property) obj);
                }
            }
        }
        Property[] propertyArr = new Property[arrayList.size()];
        Iterator iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            Property property = (Property) iterator2.next();
            int i10 = property.ordinal;
            if (propertyArr[i10] == null) {
                propertyArr[i10] = property;
            } else {
                throw new DaoException("Duplicate property ordinals");
            }
        }
        return propertyArr;
    }

    public void clearIdentityScope() {
        IdentityScope<?, ?> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public IdentityScope<?, ?> getIdentityScope() {
        return this.identityScope;
    }

    public void initIdentityScope(IdentityScopeType identityScopeType) {
        if (identityScopeType == IdentityScopeType.None) {
            this.identityScope = null;
            return;
        }
        if (identityScopeType == IdentityScopeType.Session) {
            if (this.keyIsNumeric) {
                this.identityScope = new IdentityScopeLong();
                return;
            } else {
                this.identityScope = new IdentityScopeObject();
                return;
            }
        }
        throw new IllegalArgumentException("Unsupported type: " + ((Object) identityScopeType));
    }

    public void setIdentityScope(IdentityScope<?, ?> identityScope) {
        this.identityScope = identityScope;
    }

    public DaoConfig clone() {
        return new DaoConfig(this);
    }

    public DaoConfig(DaoConfig daoConfig) {
        this.f52441db = daoConfig.f52441db;
        this.tablename = daoConfig.tablename;
        this.properties = daoConfig.properties;
        this.allColumns = daoConfig.allColumns;
        this.pkColumns = daoConfig.pkColumns;
        this.nonPkColumns = daoConfig.nonPkColumns;
        this.pkProperty = daoConfig.pkProperty;
        this.statements = daoConfig.statements;
        this.keyIsNumeric = daoConfig.keyIsNumeric;
    }
}
