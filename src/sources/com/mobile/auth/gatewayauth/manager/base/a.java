package com.mobile.auth.gatewayauth.manager.base;

import android.util.SparseArray;
import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a<T> extends SparseArray<T> {
    public a(int i10) {
        super(i10);
    }

    @Override // android.util.SparseArray
    public synchronized void append(int i10, T t2) {
        try {
            super.append(i10, t2);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // android.util.SparseArray
    public synchronized void clear() {
        try {
            super.clear();
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // android.util.SparseArray
    public synchronized void delete(int i10) {
        try {
            super.delete(i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // android.util.SparseArray
    public synchronized T get(int i10) {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return (T) super.get(i10);
    }

    @Override // android.util.SparseArray
    public synchronized T get(int i10, T t2) {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return (T) super.get(i10, t2);
    }

    @Override // android.util.SparseArray
    public synchronized int indexOfKey(int i10) {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
        return super.indexOfKey(i10);
    }

    @Override // android.util.SparseArray
    public synchronized int indexOfValue(T t2) {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
        return super.indexOfValue(t2);
    }

    @Override // android.util.SparseArray
    public synchronized int keyAt(int i10) {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
        return super.keyAt(i10);
    }

    @Override // android.util.SparseArray
    public synchronized void put(int i10, T t2) {
        try {
            super.put(i10, t2);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // android.util.SparseArray
    public synchronized void remove(int i10) {
        try {
            super.remove(i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // android.util.SparseArray
    public synchronized void removeAt(int i10) {
        try {
            super.removeAt(i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // android.util.SparseArray
    public synchronized void removeAtRange(int i10, int i11) {
        try {
            super.removeAtRange(i10, i11);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // android.util.SparseArray
    public synchronized void setValueAt(int i10, T t2) {
        try {
            super.setValueAt(i10, t2);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // android.util.SparseArray
    public synchronized int size() {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
        return super.size();
    }

    @Override // android.util.SparseArray
    public synchronized T valueAt(int i10) {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return (T) super.valueAt(i10);
    }
}
