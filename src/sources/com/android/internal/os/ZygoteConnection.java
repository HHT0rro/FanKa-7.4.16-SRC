package com.android.internal.os;

import android.content.pm.ApplicationInfo;
import android.net.Credentials;
import android.net.LocalSocket;
import android.os.Process;
import android.os.Trace;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import dalvik.system.VMRuntime;
import java.io.DataOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ZygoteConnection {
    private static final String TAG = "Zygote";
    private final String abiList;
    private boolean isEof;
    private final LocalSocket mSocket;
    private final DataOutputStream mSocketOutStream;
    private final IZygoteConnectionExt mZygoteConnectionExt = (IZygoteConnectionExt) ZygoteConnectionExtPlugin.constructor.newInstance();
    private final Credentials peer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZygoteConnection(LocalSocket socket, String abiList) throws IOException {
        this.mSocket = socket;
        this.abiList = abiList;
        this.mSocketOutStream = new DataOutputStream(socket.getOutputStream());
        socket.setSoTimeout(1000);
        try {
            this.peer = socket.getPeerCredentials();
            this.isEof = false;
        } catch (IOException ex) {
            Log.e(TAG, "Cannot read peer credentials", ex);
            throw ex;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileDescriptor getFileDescriptor() {
        return this.mSocket.getFileDescriptor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x020b, code lost:
    
        libcore.io.IoUtils.closeQuietly((java.io.FileDescriptor) null);
        libcore.io.IoUtils.closeQuietly(r34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0211, code lost:
    
        r32.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0215, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0218, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0219, code lost:
    
        r7 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0216, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0223, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0227, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x025b, code lost:
    
        throw new com.android.internal.os.ZygoteSecurityException("Client may not specify capabilities: permitted=0x" + java.lang.Long.toHexString(r0.mPermittedCapabilities) + ", effective=0x" + java.lang.Long.toHexString(r0.mEffectiveCapabilities));
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x026b, code lost:
    
        r32.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0270, code lost:
    
        if (r0.mUsapPoolStatusSpecified == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x027a, code lost:
    
        return r2.handleUsapPoolStatusChange(r37, r0.mUsapPoolEnabled);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x027f, code lost:
    
        if (r0.mApiDenylistExemptions == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0287, code lost:
    
        return r2.handleApiDenylistExemptions(r37, r0.mApiDenylistExemptions);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x028a, code lost:
    
        if (r0.mHiddenApiAccessLogSampleRate != (-1)) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x028e, code lost:
    
        if (r0.mHiddenApiAccessStatslogSampleRate == (-1)) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0298, code lost:
    
        throw new java.lang.AssertionError((java.lang.Object) "Shouldn't get here");
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x02a1, code lost:
    
        return r2.handleHiddenApiAccessLogSampleRate(r37, r0.mHiddenApiAccessLogSampleRate, r0.mHiddenApiAccessStatslogSampleRate);
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0268, code lost:
    
        r2 = r36;
        r32 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x019a, code lost:
    
        r32 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x019c, code lost:
    
        r3 = r0.mAppDataDir;
        r33 = r6;
        r6 = r0.mIsTopApp;
        r34 = r7;
        r7 = r0.mPkgDataInfoList;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01a6, code lost:
    
        r0 = com.android.internal.os.Zygote.forkAndSpecialize(r11, r12, r13, r14, r8, r0, r15, r5, r9, r29, r10, r2, r3, r6, r7, r0.mAllowlistedDataInfoList, r0.mBindMountAppDataDirs, r0.mBindMountAppStorageDirs);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01cc, code lost:
    
        if (r0 != 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01d0, code lost:
    
        r36.mZygoteConnectionExt.afterForkAndSpecializeInChild(r0, r0.mZygoteArgumentsExt);
        r37.setForkChild();
        r37.closeServerSocket();
        libcore.io.IoUtils.closeQuietly(r34);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e0, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e5, code lost:
    
        r0 = handleChildProc(r0, r33, r0.mStartChildZygote);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e9, code lost:
    
        libcore.io.IoUtils.closeQuietly(r33);
        libcore.io.IoUtils.closeQuietly((java.io.FileDescriptor) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ef, code lost:
    
        r32.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01f2, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01f3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f4, code lost:
    
        r6 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x021b, code lost:
    
        libcore.io.IoUtils.closeQuietly(r6);
        libcore.io.IoUtils.closeQuietly(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0222, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01f7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01f8, code lost:
    
        r6 = r33;
        r7 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01fd, code lost:
    
        r6 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0201, code lost:
    
        libcore.io.IoUtils.closeQuietly((java.io.FileDescriptor) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0207, code lost:
    
        handleParentProc(r0, r34);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileDescriptor] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Runnable processCommand(com.android.internal.os.ZygoteServer r37, boolean r38) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.ZygoteConnection.processCommand(com.android.internal.os.ZygoteServer, boolean):java.lang.Runnable");
    }

    private void handleAbiListQuery() {
        try {
            byte[] abiListBytes = this.abiList.getBytes(StandardCharsets.US_ASCII);
            this.mSocketOutStream.writeInt(abiListBytes.length);
            this.mSocketOutStream.write(abiListBytes);
        } catch (IOException ioe) {
            throw new IllegalStateException("Error writing to command socket", ioe);
        }
    }

    private void handlePidQuery() {
        try {
            String pidString = String.valueOf(Process.myPid());
            byte[] pidStringBytes = pidString.getBytes(StandardCharsets.US_ASCII);
            this.mSocketOutStream.writeInt(pidStringBytes.length);
            this.mSocketOutStream.write(pidStringBytes);
        } catch (IOException ioe) {
            throw new IllegalStateException("Error writing to command socket", ioe);
        }
    }

    private void handleBootCompleted() {
        try {
            this.mSocketOutStream.writeInt(0);
            VMRuntime.bootCompleted();
        } catch (IOException ioe) {
            throw new IllegalStateException("Error writing to command socket", ioe);
        }
    }

    private void handlePreload() {
        try {
            if (isPreloadComplete()) {
                this.mSocketOutStream.writeInt(1);
            } else {
                preload();
                this.mSocketOutStream.writeInt(0);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Error writing to command socket", ioe);
        }
    }

    private Runnable stateChangeWithUsapPoolReset(ZygoteServer zygoteServer, Runnable stateChangeCode) {
        try {
            if (zygoteServer.isUsapPoolEnabled()) {
                Log.i(TAG, "Emptying USAP Pool due to state change.");
                Zygote.emptyUsapPool();
            }
            stateChangeCode.run();
            if (zygoteServer.isUsapPoolEnabled()) {
                Runnable fpResult = zygoteServer.fillUsapPool(new int[]{this.mSocket.getFileDescriptor().getInt$()}, false);
                if (fpResult != null) {
                    zygoteServer.setForkChild();
                    return fpResult;
                }
                Log.i(TAG, "Finished refilling USAP Pool after state change.");
            }
            this.mSocketOutStream.writeInt(0);
            return null;
        } catch (IOException ioe) {
            throw new IllegalStateException("Error writing to command socket", ioe);
        }
    }

    private Runnable handleApiDenylistExemptions(ZygoteServer zygoteServer, final String[] exemptions) {
        return stateChangeWithUsapPoolReset(zygoteServer, new Runnable() { // from class: com.android.internal.os.ZygoteConnection$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ZygoteInit.setApiDenylistExemptions(exemptions);
            }
        });
    }

    private Runnable handleUsapPoolStatusChange(ZygoteServer zygoteServer, boolean newStatus) {
        try {
            Runnable fpResult = zygoteServer.setUsapPoolStatus(newStatus, this.mSocket);
            if (fpResult == null) {
                this.mSocketOutStream.writeInt(0);
            } else {
                zygoteServer.setForkChild();
            }
            return fpResult;
        } catch (IOException ioe) {
            throw new IllegalStateException("Error writing to command socket", ioe);
        }
    }

    private Runnable handleHiddenApiAccessLogSampleRate(ZygoteServer zygoteServer, final int samplingRate, final int statsdSamplingRate) {
        return stateChangeWithUsapPoolReset(zygoteServer, new Runnable() { // from class: com.android.internal.os.ZygoteConnection$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ZygoteConnection.lambda$handleHiddenApiAccessLogSampleRate$1(samplingRate, statsdSamplingRate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$handleHiddenApiAccessLogSampleRate$1(int samplingRate, int statsdSamplingRate) {
        int maxSamplingRate = Math.max(samplingRate, statsdSamplingRate);
        ZygoteInit.setHiddenApiAccessLogSampleRate(maxSamplingRate);
        StatsdHiddenApiUsageLogger.setHiddenApiAccessLogSampleRates(samplingRate, statsdSamplingRate);
        ZygoteInit.setHiddenApiUsageLogger(StatsdHiddenApiUsageLogger.getInstance());
    }

    protected void preload() {
        ZygoteInit.lazyPreload();
    }

    protected boolean isPreloadComplete() {
        return ZygoteInit.isPreloadComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DataOutputStream getSocketOutputStream() {
        return this.mSocketOutStream;
    }

    protected void handlePreloadPackage(String packagePath, String libsPath, String libFileName, String cacheKey) {
        throw new RuntimeException("Zygote does not support package preloading");
    }

    protected boolean canPreloadApp() {
        return false;
    }

    protected void handlePreloadApp(ApplicationInfo aInfo) {
        throw new RuntimeException("Zygote does not support app preloading");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeSocket() {
        try {
            this.mSocket.close();
        } catch (IOException ex) {
            Log.e(TAG, "Exception while closing command socket in parent", ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isClosedByPeer() {
        return this.isEof;
    }

    private Runnable handleChildProc(ZygoteArguments parsedArgs, FileDescriptor pipeFd, boolean isZygote) {
        closeSocket();
        Zygote.setAppProcessName(parsedArgs, TAG);
        Trace.traceEnd(64L);
        if (parsedArgs.mInvokeWith != null) {
            WrapperInit.execApplication(parsedArgs.mInvokeWith, parsedArgs.mNiceName, parsedArgs.mTargetSdkVersion, VMRuntime.getCurrentInstructionSet(), pipeFd, parsedArgs.mRemainingArgs);
            throw new IllegalStateException("WrapperInit.execApplication unexpectedly returned");
        }
        if (!isZygote) {
            return ZygoteInit.zygoteInit(parsedArgs.mTargetSdkVersion, parsedArgs.mDisabledCompatChanges, parsedArgs.mRemainingArgs, null);
        }
        return ZygoteInit.childZygoteInit(parsedArgs.mRemainingArgs);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handleParentProc(int r22, java.io.FileDescriptor r23) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.ZygoteConnection.handleParentProc(int, java.io.FileDescriptor):void");
    }

    private void setChildPgid(int pid) {
        try {
            Os.setpgid(pid, Os.getpgid(this.peer.getPid()));
        } catch (ErrnoException e2) {
            Log.i(TAG, "Zygote: setpgid failed. This is normal if peer is not in our session");
        }
    }
}
