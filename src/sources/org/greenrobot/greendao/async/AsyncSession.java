package org.greenrobot.greendao.async;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.query.Query;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class AsyncSession {
    private final AbstractDaoSession daoSession;
    private final AsyncOperationExecutor executor = new AsyncOperationExecutor();
    private int sessionFlags;

    public AsyncSession(AbstractDaoSession abstractDaoSession) {
        this.daoSession = abstractDaoSession;
    }

    private <E> AsyncOperation enqueEntityOperation(AsyncOperation.OperationType operationType, Class<E> cls, Object obj, int i10) {
        AsyncOperation asyncOperation = new AsyncOperation(operationType, this.daoSession.getDao(cls), null, obj, i10 | this.sessionFlags);
        this.executor.enqueue(asyncOperation);
        return asyncOperation;
    }

    private AsyncOperation enqueueDatabaseOperation(AsyncOperation.OperationType operationType, Object obj, int i10) {
        AsyncOperation asyncOperation = new AsyncOperation(operationType, null, this.daoSession.getDatabase(), obj, i10 | this.sessionFlags);
        this.executor.enqueue(asyncOperation);
        return asyncOperation;
    }

    private AsyncOperation enqueueEntityOperation(AsyncOperation.OperationType operationType, Object obj, int i10) {
        return enqueEntityOperation(operationType, obj.getClass(), obj, i10);
    }

    public AsyncOperation callInTx(Callable<?> callable) {
        return callInTx(callable, 0);
    }

    public AsyncOperation count(Class<?> cls) {
        return count(cls, 0);
    }

    public AsyncOperation delete(Object obj) {
        return delete(obj, 0);
    }

    public <E> AsyncOperation deleteAll(Class<E> cls) {
        return deleteAll(cls, 0);
    }

    public AsyncOperation deleteByKey(Object obj) {
        return deleteByKey(obj, 0);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, E... eArr) {
        return deleteInTx(cls, 0, eArr);
    }

    public AsyncOperationListener getListener() {
        return this.executor.getListener();
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.executor.getListenerMainThread();
    }

    public int getMaxOperationCountToMerge() {
        return this.executor.getMaxOperationCountToMerge();
    }

    public int getSessionFlags() {
        return this.sessionFlags;
    }

    public int getWaitForMergeMillis() {
        return this.executor.getWaitForMergeMillis();
    }

    public AsyncOperation insert(Object obj) {
        return insert(obj, 0);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, E... eArr) {
        return insertInTx(cls, 0, eArr);
    }

    public AsyncOperation insertOrReplace(Object obj) {
        return insertOrReplace(obj, 0);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, E... eArr) {
        return insertOrReplaceInTx(cls, 0, eArr);
    }

    public boolean isCompleted() {
        return this.executor.isCompleted();
    }

    public AsyncOperation load(Class<?> cls, Object obj) {
        return load(cls, obj, 0);
    }

    public AsyncOperation loadAll(Class<?> cls) {
        return loadAll(cls, 0);
    }

    public AsyncOperation queryList(Query<?> query) {
        return queryList(query, 0);
    }

    public AsyncOperation queryUnique(Query<?> query) {
        return queryUnique(query, 0);
    }

    public AsyncOperation refresh(Object obj) {
        return refresh(obj, 0);
    }

    public AsyncOperation runInTx(Runnable runnable) {
        return runInTx(runnable, 0);
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.executor.setListener(asyncOperationListener);
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.executor.setListenerMainThread(asyncOperationListener);
    }

    public void setMaxOperationCountToMerge(int i10) {
        this.executor.setMaxOperationCountToMerge(i10);
    }

    public void setSessionFlags(int i10) {
        this.sessionFlags = i10;
    }

    public void setWaitForMergeMillis(int i10) {
        this.executor.setWaitForMergeMillis(i10);
    }

    public AsyncOperation update(Object obj) {
        return update(obj, 0);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, E... eArr) {
        return updateInTx(cls, 0, eArr);
    }

    public void waitForCompletion() {
        this.executor.waitForCompletion();
    }

    public AsyncOperation callInTx(Callable<?> callable, int i10) {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionCallable, callable, i10);
    }

    public AsyncOperation count(Class<?> cls, int i10) {
        return enqueEntityOperation(AsyncOperation.OperationType.Count, cls, null, i10);
    }

    public AsyncOperation delete(Object obj, int i10) {
        return enqueueEntityOperation(AsyncOperation.OperationType.Delete, obj, i10);
    }

    public <E> AsyncOperation deleteAll(Class<E> cls, int i10) {
        return enqueEntityOperation(AsyncOperation.OperationType.DeleteAll, cls, null, i10);
    }

    public AsyncOperation deleteByKey(Object obj, int i10) {
        return enqueueEntityOperation(AsyncOperation.OperationType.DeleteByKey, obj, i10);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, int i10, E... eArr) {
        return enqueEntityOperation(AsyncOperation.OperationType.DeleteInTxArray, cls, eArr, i10);
    }

    public AsyncOperation insert(Object obj, int i10) {
        return enqueueEntityOperation(AsyncOperation.OperationType.Insert, obj, i10);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, int i10, E... eArr) {
        return enqueEntityOperation(AsyncOperation.OperationType.InsertInTxArray, cls, eArr, i10);
    }

    public AsyncOperation insertOrReplace(Object obj, int i10) {
        return enqueueEntityOperation(AsyncOperation.OperationType.InsertOrReplace, obj, i10);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, int i10, E... eArr) {
        return enqueEntityOperation(AsyncOperation.OperationType.InsertOrReplaceInTxArray, cls, eArr, i10);
    }

    public AsyncOperation load(Class<?> cls, Object obj, int i10) {
        return enqueEntityOperation(AsyncOperation.OperationType.Load, cls, obj, i10);
    }

    public AsyncOperation loadAll(Class<?> cls, int i10) {
        return enqueEntityOperation(AsyncOperation.OperationType.LoadAll, cls, null, i10);
    }

    public AsyncOperation queryList(Query<?> query, int i10) {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.QueryList, query, i10);
    }

    public AsyncOperation queryUnique(Query<?> query, int i10) {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.QueryUnique, query, i10);
    }

    public AsyncOperation refresh(Object obj, int i10) {
        return enqueueEntityOperation(AsyncOperation.OperationType.Refresh, obj, i10);
    }

    public AsyncOperation runInTx(Runnable runnable, int i10) {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionRunnable, runnable, i10);
    }

    public AsyncOperation update(Object obj, int i10) {
        return enqueueEntityOperation(AsyncOperation.OperationType.Update, obj, i10);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, int i10, E... eArr) {
        return enqueEntityOperation(AsyncOperation.OperationType.UpdateInTxArray, cls, eArr, i10);
    }

    public boolean waitForCompletion(int i10) {
        return this.executor.waitForCompletion(i10);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, Iterable<E> iterable) {
        return deleteInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, Iterable<E> iterable) {
        return insertInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, Iterable<E> iterable) {
        return insertOrReplaceInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, Iterable<E> iterable) {
        return updateInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, Iterable<E> iterable, int i10) {
        return enqueEntityOperation(AsyncOperation.OperationType.DeleteInTxIterable, cls, iterable, i10);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, Iterable<E> iterable, int i10) {
        return enqueEntityOperation(AsyncOperation.OperationType.InsertInTxIterable, cls, iterable, i10);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, Iterable<E> iterable, int i10) {
        return enqueEntityOperation(AsyncOperation.OperationType.InsertOrReplaceInTxIterable, cls, iterable, i10);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, Iterable<E> iterable, int i10) {
        return enqueEntityOperation(AsyncOperation.OperationType.UpdateInTxIterable, cls, iterable, i10);
    }
}
