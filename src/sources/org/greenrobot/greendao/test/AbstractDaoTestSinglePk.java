package org.greenrobot.greendao.test;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.test.AndroidTestCase;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.InternalUnitTestDaoAccess;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractDaoTestSinglePk<D extends AbstractDao<T, K>, T, K> extends AbstractDaoTest<D, T, K> {
    private Property pkColumn;
    public Set<K> usedPks;

    public AbstractDaoTestSinglePk(Class<D> cls) {
        super(cls);
        this.usedPks = new HashSet();
    }

    public boolean checkKeyIsNullable() {
        if (createEntity(null) != null) {
            return true;
        }
        DaoLog.d("Test is not available for entities with non-null keys");
        return false;
    }

    public abstract T createEntity(K k10);

    public T createEntityWithRandomPk() {
        return createEntity(nextPk());
    }

    public abstract K createRandomPk();

    public K nextPk() {
        for (int i10 = 0; i10 < 100000; i10++) {
            K createRandomPk = createRandomPk();
            if (this.usedPks.add(createRandomPk)) {
                return createRandomPk;
            }
        }
        throw new IllegalStateException("Could not find a new PK");
    }

    public Cursor queryWithDummyColumnsInFront(int i10, String str, K k10) {
        StringBuilder sb2 = new StringBuilder("SELECT ");
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(str);
            sb2.append(",");
        }
        SqlUtils.appendColumns(sb2, ExifInterface.GPS_DIRECTION_TRUE, this.dao.getAllColumns()).append(" FROM ");
        sb2.append('\"');
        sb2.append(this.dao.getTablename());
        sb2.append('\"');
        sb2.append(" T");
        if (k10 != null) {
            sb2.append(" WHERE ");
            AndroidTestCase.assertEquals(1, this.dao.getPkColumns().length);
            sb2.append(this.dao.getPkColumns()[0]);
            sb2.append("=");
            DatabaseUtils.appendValueToSql(sb2, k10);
        }
        Cursor rawQuery = this.f52443db.rawQuery(sb2.toString(), null);
        AndroidTestCase.assertTrue(rawQuery.moveToFirst());
        for (int i12 = 0; i12 < i10; i12++) {
            try {
                AndroidTestCase.assertEquals(str, rawQuery.getString(i12));
            } catch (RuntimeException e2) {
                rawQuery.close();
                throw e2;
            }
        }
        if (k10 != null) {
            AndroidTestCase.assertEquals(1, rawQuery.getCount());
        }
        return rawQuery;
    }

    public void runLoadPkTest(int i10) {
        K nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(i10, "42", nextPk);
        try {
            AndroidTestCase.assertEquals(nextPk, this.daoAccess.readKey(queryWithDummyColumnsInFront, i10));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    @Override // org.greenrobot.greendao.test.AbstractDaoTest, org.greenrobot.greendao.test.DbTest
    public void setUp() throws Exception {
        super.setUp();
        for (Property property : this.daoAccess.getProperties()) {
            if (property.primaryKey) {
                if (this.pkColumn == null) {
                    this.pkColumn = property;
                } else {
                    throw new RuntimeException("Test does not work with multiple PK columns");
                }
            }
        }
        if (this.pkColumn == null) {
            throw new RuntimeException("Test does not work without a PK column");
        }
    }

    public void testCount() {
        this.dao.deleteAll();
        AndroidTestCase.assertEquals(0L, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        AndroidTestCase.assertEquals(1L, this.dao.count());
        this.dao.insert(createEntityWithRandomPk());
        AndroidTestCase.assertEquals(2L, this.dao.count());
    }

    public void testDelete() {
        K nextPk = nextPk();
        this.dao.deleteByKey(nextPk);
        this.dao.insert(createEntity(nextPk));
        AndroidTestCase.assertNotNull(this.dao.load(nextPk));
        this.dao.deleteByKey(nextPk);
        AndroidTestCase.assertNull(this.dao.load(nextPk));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void testDeleteAll() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 10; i10++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        this.dao.deleteAll();
        AndroidTestCase.assertEquals(0L, this.dao.count());
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            Object key = this.daoAccess.getKey(iterator2.next());
            AndroidTestCase.assertNotNull(key);
            AndroidTestCase.assertNull(this.dao.load(key));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void testDeleteByKeyInTx() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 10; i10++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(((InternalUnitTestDaoAccess<T, K>) this.daoAccess).getKey(arrayList.get(0)));
        arrayList2.add(((InternalUnitTestDaoAccess<T, K>) this.daoAccess).getKey(arrayList.get(3)));
        arrayList2.add(((InternalUnitTestDaoAccess<T, K>) this.daoAccess).getKey(arrayList.get(4)));
        arrayList2.add(((InternalUnitTestDaoAccess<T, K>) this.daoAccess).getKey(arrayList.get(8)));
        this.dao.deleteByKeyInTx(arrayList2);
        AndroidTestCase.assertEquals(arrayList.size() - arrayList2.size(), this.dao.count());
        for (Object obj : arrayList2) {
            AndroidTestCase.assertNotNull(obj);
            AndroidTestCase.assertNull(this.dao.load(obj));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void testDeleteInTx() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 10; i10++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(arrayList.get(0));
        arrayList2.add(arrayList.get(3));
        arrayList2.add(arrayList.get(4));
        arrayList2.add(arrayList.get(8));
        this.dao.deleteInTx(arrayList2);
        AndroidTestCase.assertEquals(arrayList.size() - arrayList2.size(), this.dao.count());
        Iterator<E> iterator2 = arrayList2.iterator2();
        while (iterator2.hasNext()) {
            Object key = this.daoAccess.getKey(iterator2.next());
            AndroidTestCase.assertNotNull(key);
            AndroidTestCase.assertNull(this.dao.load(key));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void testInsertAndLoad() {
        K nextPk = nextPk();
        T createEntity = createEntity(nextPk);
        this.dao.insert(createEntity);
        AndroidTestCase.assertEquals(nextPk, this.daoAccess.getKey(createEntity));
        Object load = this.dao.load(nextPk);
        AndroidTestCase.assertNotNull(load);
        AndroidTestCase.assertEquals(this.daoAccess.getKey(createEntity), this.daoAccess.getKey(load));
    }

    public void testInsertInTx() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 20; i10++) {
            arrayList.add(createEntityWithRandomPk());
        }
        this.dao.insertInTx(arrayList);
        AndroidTestCase.assertEquals(arrayList.size(), this.dao.count());
    }

    public void testInsertOrReplaceInTx() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < 20; i10++) {
            T createEntityWithRandomPk = createEntityWithRandomPk();
            if (i10 % 2 == 0) {
                arrayList.add(createEntityWithRandomPk);
            }
            arrayList2.add(createEntityWithRandomPk);
        }
        this.dao.insertOrReplaceInTx(arrayList);
        this.dao.insertOrReplaceInTx(arrayList2);
        AndroidTestCase.assertEquals(arrayList2.size(), this.dao.count());
    }

    public void testInsertOrReplaceTwice() {
        T createEntityWithRandomPk = createEntityWithRandomPk();
        long insert = this.dao.insert(createEntityWithRandomPk);
        long insertOrReplace = this.dao.insertOrReplace(createEntityWithRandomPk);
        if (this.dao.getPkProperty().type == Long.class) {
            AndroidTestCase.assertEquals(insert, insertOrReplace);
        }
    }

    public void testInsertTwice() {
        T createEntity = createEntity(nextPk());
        this.dao.insert(createEntity);
        try {
            this.dao.insert(createEntity);
            AndroidTestCase.fail("Inserting twice should not work");
        } catch (SQLException unused) {
        }
    }

    public void testLoadAll() {
        this.dao.deleteAll();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 15; i10++) {
            arrayList.add(createEntity(nextPk()));
        }
        this.dao.insertInTx(arrayList);
        AndroidTestCase.assertEquals(arrayList.size(), this.dao.loadAll().size());
    }

    public void testLoadPk() {
        runLoadPkTest(0);
    }

    public void testLoadPkWithOffset() {
        runLoadPkTest(10);
    }

    public void testQuery() {
        this.dao.insert(createEntityWithRandomPk());
        K nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        this.dao.insert(createEntityWithRandomPk());
        List<T> queryRaw = this.dao.queryRaw("WHERE " + this.dao.getPkColumns()[0] + "=?", nextPk.toString());
        AndroidTestCase.assertEquals(1, queryRaw.size());
        AndroidTestCase.assertEquals(nextPk, this.daoAccess.getKey(queryRaw.get(0)));
    }

    public void testReadWithOffset() {
        K nextPk = nextPk();
        this.dao.insert(createEntity(nextPk));
        Cursor queryWithDummyColumnsInFront = queryWithDummyColumnsInFront(5, "42", nextPk);
        try {
            AndroidTestCase.assertEquals(nextPk, this.daoAccess.getKey(this.daoAccess.readEntity(queryWithDummyColumnsInFront, 5)));
        } finally {
            queryWithDummyColumnsInFront.close();
        }
    }

    public void testRowId() {
        AndroidTestCase.assertTrue(this.dao.insert(createEntityWithRandomPk()) != this.dao.insert(createEntityWithRandomPk()));
    }

    public void testSave() {
        if (checkKeyIsNullable()) {
            this.dao.deleteAll();
            T createEntity = createEntity(null);
            if (createEntity != null) {
                this.dao.save(createEntity);
                this.dao.save(createEntity);
                AndroidTestCase.assertEquals(1L, this.dao.count());
            }
        }
    }

    public void testSaveInTx() {
        if (checkKeyIsNullable()) {
            this.dao.deleteAll();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < 20; i10++) {
                T createEntity = createEntity(null);
                if (i10 % 2 == 0) {
                    arrayList.add(createEntity);
                }
                arrayList2.add(createEntity);
            }
            this.dao.saveInTx(arrayList);
            this.dao.saveInTx(arrayList2);
            AndroidTestCase.assertEquals(arrayList2.size(), this.dao.count());
        }
    }

    public void testUpdate() {
        this.dao.deleteAll();
        T createEntityWithRandomPk = createEntityWithRandomPk();
        this.dao.insert(createEntityWithRandomPk);
        this.dao.update(createEntityWithRandomPk);
        AndroidTestCase.assertEquals(1L, this.dao.count());
    }
}
