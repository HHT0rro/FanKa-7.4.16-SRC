package android.view.translation;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IRemoteCallback;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SynchronousResultReceiver;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Log;
import android.util.Pair;
import android.view.translation.TranslationManager;
import android.view.translation.Translator;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.FunctionalUtils;
import com.android.internal.util.SyncResultReceiver;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class TranslationManager {
    public static final String EXTRA_CAPABILITIES = "translation_capabilities";
    public static final int STATUS_SYNC_CALL_FAIL = 2;
    public static final int STATUS_SYNC_CALL_SUCCESS = 1;
    static final int SYNC_CALLS_TIMEOUT_MS = 60000;
    private static final String TAG = "TranslationManager";
    private final Context mContext;
    private final ITranslationManager mService;
    private static final SecureRandom ID_GENERATOR = new SecureRandom();
    private static final AtomicInteger sAvailableRequestId = new AtomicInteger(1);
    private final ArrayMap<Pair<Integer, Integer>, ArrayList<PendingIntent>> mTranslationCapabilityUpdateListeners = new ArrayMap<>();
    private final Map<Consumer<TranslationCapability>, IRemoteCallback> mCapabilityCallbacks = new ArrayMap();
    private final Object mLock = new Object();
    private final IntArray mTranslatorIds = new IntArray();
    private final Handler mHandler = Handler.createAsync(Looper.getMainLooper());

    public TranslationManager(Context context, ITranslationManager service) {
        this.mContext = (Context) Objects.requireNonNull(context, "context cannot be null");
        this.mService = service;
    }

    public void createOnDeviceTranslator(TranslationContext translationContext, final Executor executor, final Consumer<Translator> callback) {
        Objects.requireNonNull(translationContext, "translationContext cannot be null");
        Objects.requireNonNull(executor, "executor cannot be null");
        Objects.requireNonNull(callback, "callback cannot be null");
        synchronized (this.mLock) {
            while (true) {
                final int translatorId = Math.abs(ID_GENERATOR.nextInt());
                if (translatorId != 0 && this.mTranslatorIds.indexOf(translatorId) < 0) {
                    new Translator(this.mContext, translationContext, translatorId, this, this.mHandler, this.mService, new Consumer() { // from class: android.view.translation.TranslationManager$$ExternalSyntheticLambda3
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            TranslationManager.this.lambda$createOnDeviceTranslator$4(executor, callback, translatorId, (Translator) obj);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createOnDeviceTranslator$4(final Executor executor, final Consumer callback, int tId, final Translator translator) {
        if (translator == null) {
            Binder.withCleanCallingIdentity(new FunctionalUtils.ThrowingRunnable() { // from class: android.view.translation.TranslationManager$$ExternalSyntheticLambda0
                public final void runOrThrow() {
                    Executor.this.execute(new Runnable() { // from class: android.view.translation.TranslationManager$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Consumer.this.accept(null);
                        }
                    });
                }
            });
            return;
        }
        synchronized (this.mLock) {
            this.mTranslatorIds.add(tId);
        }
        Binder.withCleanCallingIdentity(new FunctionalUtils.ThrowingRunnable() { // from class: android.view.translation.TranslationManager$$ExternalSyntheticLambda1
            public final void runOrThrow() {
                Executor.this.execute(new Runnable() { // from class: android.view.translation.TranslationManager$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        Consumer.this.accept(r2);
                    }
                });
            }
        });
    }

    @Deprecated
    public Translator createOnDeviceTranslator(TranslationContext translationContext) {
        int translatorId;
        Objects.requireNonNull(translationContext, "translationContext cannot be null");
        synchronized (this.mLock) {
            while (true) {
                translatorId = Math.abs(ID_GENERATOR.nextInt());
                if (translatorId != 0 && this.mTranslatorIds.indexOf(translatorId) < 0) {
                    break;
                }
            }
            Translator newTranslator = new Translator(this.mContext, translationContext, translatorId, this, this.mHandler, this.mService);
            newTranslator.start();
            try {
                if (!newTranslator.isSessionCreated()) {
                    return null;
                }
                this.mTranslatorIds.add(translatorId);
                return newTranslator;
            } catch (Translator.ServiceBinderReceiver.TimeoutException e2) {
                Log.e(TAG, "Timed out getting create session: " + ((Object) e2));
                return null;
            }
        }
    }

    @Deprecated
    public Translator createTranslator(TranslationContext translationContext) {
        return createOnDeviceTranslator(translationContext);
    }

    public Set<TranslationCapability> getOnDeviceTranslationCapabilities(int sourceFormat, int targetFormat) {
        try {
            ResultReceiver synchronousResultReceiver = new SynchronousResultReceiver();
            this.mService.onTranslationCapabilitiesRequest(sourceFormat, targetFormat, synchronousResultReceiver, this.mContext.getUserId());
            SynchronousResultReceiver.Result result = synchronousResultReceiver.awaitResult(60000L);
            if (result.resultCode != 1) {
                return Collections.emptySet();
            }
            ParceledListSlice<TranslationCapability> listSlice = (ParceledListSlice) result.bundle.getParcelable(EXTRA_CAPABILITIES, ParceledListSlice.class);
            ArraySet<TranslationCapability> capabilities = new ArraySet<>(listSlice == null ? null : listSlice.getList());
            return capabilities;
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        } catch (TimeoutException e10) {
            Log.e(TAG, "Timed out getting supported translation capabilities: " + ((Object) e10));
            return Collections.emptySet();
        }
    }

    @Deprecated
    public Set<TranslationCapability> getTranslationCapabilities(int sourceFormat, int targetFormat) {
        return getOnDeviceTranslationCapabilities(sourceFormat, targetFormat);
    }

    public void addOnDeviceTranslationCapabilityUpdateListener(Executor executor, Consumer<TranslationCapability> capabilityListener) {
        Objects.requireNonNull(executor, "executor should not be null");
        Objects.requireNonNull(capabilityListener, "capability listener should not be null");
        synchronized (this.mLock) {
            if (this.mCapabilityCallbacks.containsKey(capabilityListener)) {
                Log.w(TAG, "addOnDeviceTranslationCapabilityUpdateListener: the listener for " + ((Object) capabilityListener) + " already registered; ignoring.");
                return;
            }
            IRemoteCallback remoteCallback = new TranslationCapabilityRemoteCallback(executor, capabilityListener);
            try {
                this.mService.registerTranslationCapabilityCallback(remoteCallback, this.mContext.getUserId());
                this.mCapabilityCallbacks.put(capabilityListener, remoteCallback);
            } catch (RemoteException e2) {
                throw e2.rethrowFromSystemServer();
            }
        }
    }

    @Deprecated
    public void addOnDeviceTranslationCapabilityUpdateListener(int sourceFormat, int targetFormat, PendingIntent pendingIntent) {
        Objects.requireNonNull(pendingIntent, "pending intent should not be null");
        synchronized (this.mLock) {
            Pair<Integer, Integer> formatPair = new Pair<>(Integer.valueOf(sourceFormat), Integer.valueOf(targetFormat));
            ((ArrayList) this.mTranslationCapabilityUpdateListeners.computeIfAbsent(formatPair, new Function() { // from class: android.view.translation.TranslationManager$$ExternalSyntheticLambda5
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return TranslationManager.lambda$addOnDeviceTranslationCapabilityUpdateListener$5((Pair) obj);
                }
            })).add(pendingIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ArrayList lambda$addOnDeviceTranslationCapabilityUpdateListener$5(Pair formats) {
        return new ArrayList();
    }

    @Deprecated
    public void addTranslationCapabilityUpdateListener(int sourceFormat, int targetFormat, PendingIntent pendingIntent) {
        addOnDeviceTranslationCapabilityUpdateListener(sourceFormat, targetFormat, pendingIntent);
    }

    public void removeOnDeviceTranslationCapabilityUpdateListener(Consumer<TranslationCapability> capabilityListener) {
        Objects.requireNonNull(capabilityListener, "capability callback should not be null");
        synchronized (this.mLock) {
            IRemoteCallback remoteCallback = this.mCapabilityCallbacks.get(capabilityListener);
            if (remoteCallback == null) {
                Log.w(TAG, "removeOnDeviceTranslationCapabilityUpdateListener: the capability listener not found; ignoring.");
                return;
            }
            try {
                this.mService.unregisterTranslationCapabilityCallback(remoteCallback, this.mContext.getUserId());
                this.mCapabilityCallbacks.remove(capabilityListener);
            } catch (RemoteException e2) {
                throw e2.rethrowFromSystemServer();
            }
        }
    }

    @Deprecated
    public void removeOnDeviceTranslationCapabilityUpdateListener(int sourceFormat, int targetFormat, PendingIntent pendingIntent) {
        Objects.requireNonNull(pendingIntent, "pending intent should not be null");
        synchronized (this.mLock) {
            Pair<Integer, Integer> formatPair = new Pair<>(Integer.valueOf(sourceFormat), Integer.valueOf(targetFormat));
            if (this.mTranslationCapabilityUpdateListeners.containsKey(formatPair)) {
                ArrayList<PendingIntent> intents = this.mTranslationCapabilityUpdateListeners.get(formatPair);
                if (intents.contains(pendingIntent)) {
                    intents.remove(pendingIntent);
                } else {
                    Log.w(TAG, "pending intent=" + ((Object) pendingIntent) + " does not exist in mTranslationCapabilityUpdateListeners");
                }
            } else {
                Log.w(TAG, "format pair=" + ((Object) formatPair) + " does not exist in mTranslationCapabilityUpdateListeners");
            }
        }
    }

    @Deprecated
    public void removeTranslationCapabilityUpdateListener(int sourceFormat, int targetFormat, PendingIntent pendingIntent) {
        removeOnDeviceTranslationCapabilityUpdateListener(sourceFormat, targetFormat, pendingIntent);
    }

    public PendingIntent getOnDeviceTranslationSettingsActivityIntent() {
        IResultReceiver syncResultReceiver = new SyncResultReceiver(60000);
        try {
            this.mService.getServiceSettingsActivity(syncResultReceiver, this.mContext.getUserId());
            try {
                return (PendingIntent) syncResultReceiver.getParcelableResult();
            } catch (SyncResultReceiver.TimeoutException e2) {
                Log.e(TAG, "Fail to get translation service settings activity.");
                return null;
            }
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    @Deprecated
    public PendingIntent getTranslationSettingsActivityIntent() {
        return getOnDeviceTranslationSettingsActivityIntent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeTranslator(int id2) {
        synchronized (this.mLock) {
            int index = this.mTranslatorIds.indexOf(id2);
            if (index >= 0) {
                this.mTranslatorIds.remove(index);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicInteger getAvailableRequestId() {
        AtomicInteger atomicInteger;
        synchronized (this.mLock) {
            atomicInteger = sAvailableRequestId;
        }
        return atomicInteger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class TranslationCapabilityRemoteCallback extends IRemoteCallback.Stub {
        private final Executor mExecutor;
        private final Consumer<TranslationCapability> mListener;

        TranslationCapabilityRemoteCallback(Executor executor, Consumer<TranslationCapability> listener) {
            this.mExecutor = executor;
            this.mListener = listener;
        }

        public void sendResult(final Bundle bundle) {
            Binder.withCleanCallingIdentity(new FunctionalUtils.ThrowingRunnable() { // from class: android.view.translation.TranslationManager$TranslationCapabilityRemoteCallback$$ExternalSyntheticLambda1
                public final void runOrThrow() {
                    TranslationManager.TranslationCapabilityRemoteCallback.this.lambda$sendResult$1(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendResult$1(final Bundle bundle) throws Exception {
            this.mExecutor.execute(new Runnable() { // from class: android.view.translation.TranslationManager$TranslationCapabilityRemoteCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TranslationManager.TranslationCapabilityRemoteCallback.this.lambda$sendResult$0(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: onTranslationCapabilityUpdate, reason: merged with bridge method [inline-methods] */
        public void lambda$sendResult$0(Bundle bundle) {
            TranslationCapability capability = (TranslationCapability) bundle.getParcelable(TranslationManager.EXTRA_CAPABILITIES, TranslationCapability.class);
            this.mListener.accept(capability);
        }
    }
}
