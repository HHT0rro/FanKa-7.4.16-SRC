package java.sql;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SQLException extends Exception implements Iterable<Throwable> {
    private static final AtomicReferenceFieldUpdater<SQLException, SQLException> nextUpdater = AtomicReferenceFieldUpdater.newUpdater(SQLException.class, SQLException.class, "next");
    private static final long serialVersionUID = 2135244094396331484L;
    private String SQLState;
    private volatile SQLException next;
    private int vendorCode;

    public SQLException(String reason, String SQLState, int vendorCode) {
        super(reason);
        this.SQLState = SQLState;
        this.vendorCode = vendorCode;
        if (!(this instanceof SQLWarning) && DriverManager.getLogWriter() != null) {
            DriverManager.println("SQLState(" + SQLState + ") vendor code(" + vendorCode + ")");
            printStackTrace(DriverManager.getLogWriter());
        }
    }

    public SQLException(String reason, String SQLState) {
        super(reason);
        this.SQLState = SQLState;
        this.vendorCode = 0;
        if (!(this instanceof SQLWarning) && DriverManager.getLogWriter() != null) {
            printStackTrace(DriverManager.getLogWriter());
            DriverManager.println("SQLException: SQLState(" + SQLState + ")");
        }
    }

    public SQLException(String reason) {
        super(reason);
        this.SQLState = null;
        this.vendorCode = 0;
        if (!(this instanceof SQLWarning) && DriverManager.getLogWriter() != null) {
            printStackTrace(DriverManager.getLogWriter());
        }
    }

    public SQLException() {
        this.SQLState = null;
        this.vendorCode = 0;
        if (!(this instanceof SQLWarning) && DriverManager.getLogWriter() != null) {
            printStackTrace(DriverManager.getLogWriter());
        }
    }

    public SQLException(Throwable cause) {
        super(cause);
        if (!(this instanceof SQLWarning) && DriverManager.getLogWriter() != null) {
            printStackTrace(DriverManager.getLogWriter());
        }
    }

    public SQLException(String reason, Throwable cause) {
        super(reason, cause);
        if (!(this instanceof SQLWarning) && DriverManager.getLogWriter() != null) {
            printStackTrace(DriverManager.getLogWriter());
        }
    }

    public SQLException(String reason, String sqlState, Throwable cause) {
        super(reason, cause);
        this.SQLState = sqlState;
        this.vendorCode = 0;
        if (!(this instanceof SQLWarning) && DriverManager.getLogWriter() != null) {
            printStackTrace(DriverManager.getLogWriter());
            DriverManager.println("SQLState(" + this.SQLState + ")");
        }
    }

    public SQLException(String reason, String sqlState, int vendorCode, Throwable cause) {
        super(reason, cause);
        this.SQLState = sqlState;
        this.vendorCode = vendorCode;
        if (!(this instanceof SQLWarning) && DriverManager.getLogWriter() != null) {
            DriverManager.println("SQLState(" + this.SQLState + ") vendor code(" + vendorCode + ")");
            printStackTrace(DriverManager.getLogWriter());
        }
    }

    public String getSQLState() {
        return this.SQLState;
    }

    public int getErrorCode() {
        return this.vendorCode;
    }

    public SQLException getNextException() {
        return this.next;
    }

    public void setNextException(SQLException ex) {
        SQLException current = this;
        while (true) {
            SQLException next = current.next;
            if (next != null) {
                current = next;
            } else if (nextUpdater.compareAndSet(current, null, ex)) {
                return;
            } else {
                current = current.next;
            }
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Throwable> iterator2() {
        return new Iterator<Throwable>() { // from class: java.sql.SQLException.1
            Throwable cause;
            SQLException firstException;
            SQLException nextException;

            {
                this.firstException = SQLException.this;
                this.nextException = SQLException.this.getNextException();
                this.cause = this.firstException.getCause();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.firstException != null || this.nextException != null || this.cause != null) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public Throwable next() {
                if (this.firstException != null) {
                    Throwable throwable = this.firstException;
                    this.firstException = null;
                    return throwable;
                }
                Throwable th = this.cause;
                if (th != null) {
                    Throwable throwable2 = this.cause;
                    this.cause = th.getCause();
                    return throwable2;
                }
                SQLException sQLException = this.nextException;
                if (sQLException != null) {
                    Throwable throwable3 = this.nextException;
                    this.cause = sQLException.getCause();
                    this.nextException = this.nextException.getNextException();
                    return throwable3;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
