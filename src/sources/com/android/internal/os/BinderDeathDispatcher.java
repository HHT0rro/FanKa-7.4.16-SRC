package com.android.internal.os;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BinderDeathDispatcher<T extends IInterface> {
    private static final String TAG = "BinderDeathDispatcher";
    private final Object mLock = new Object();
    private final ArrayMap<IBinder, BinderDeathDispatcher<T>.RecipientsInfo> mTargets = new ArrayMap<>();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    class RecipientsInfo implements IBinder.DeathRecipient {
        ArraySet<IBinder.DeathRecipient> mRecipients;
        final IBinder mTarget;

        private RecipientsInfo(IBinder target) {
            this.mRecipients = new ArraySet<>();
            this.mTarget = target;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            ArraySet<IBinder.DeathRecipient> copy;
            synchronized (BinderDeathDispatcher.this.mLock) {
                copy = this.mRecipients;
                this.mRecipients = null;
                BinderDeathDispatcher.this.mTargets.remove(this.mTarget);
            }
            if (copy == null) {
                return;
            }
            int size = copy.size();
            for (int i10 = 0; i10 < size; i10++) {
                copy.valueAt(i10).binderDied();
            }
        }
    }

    public int linkToDeath(T target, IBinder.DeathRecipient recipient) {
        int size;
        IBinder ib2 = target.asBinder();
        synchronized (this.mLock) {
            BinderDeathDispatcher<T>.RecipientsInfo info = this.mTargets.get(ib2);
            if (info == null) {
                info = new RecipientsInfo(ib2);
                try {
                    ib2.linkToDeath(info, 0);
                    this.mTargets.put(ib2, info);
                } catch (RemoteException e2) {
                    return -1;
                }
            }
            info.mRecipients.add(recipient);
            size = info.mRecipients.size();
        }
        return size;
    }

    public void unlinkToDeath(T target, IBinder.DeathRecipient recipient) {
        IBinder ib2 = target.asBinder();
        synchronized (this.mLock) {
            BinderDeathDispatcher<T>.RecipientsInfo info = this.mTargets.get(ib2);
            if (info == null) {
                return;
            }
            if (info.mRecipients.remove(recipient) && info.mRecipients.size() == 0) {
                info.mTarget.unlinkToDeath(info, 0);
                this.mTargets.remove(info.mTarget);
            }
        }
    }

    public void dump(IndentingPrintWriter pw) {
        synchronized (this.mLock) {
            pw.print("# of watched binders: ");
            pw.println(this.mTargets.size());
            pw.print("# of death recipients: ");
            int n10 = 0;
            for (BinderDeathDispatcher<T>.RecipientsInfo info : this.mTargets.values()) {
                n10 += info.mRecipients.size();
            }
            pw.println(n10);
        }
    }

    public ArrayMap<IBinder, BinderDeathDispatcher<T>.RecipientsInfo> getTargetsForTest() {
        return this.mTargets;
    }
}
