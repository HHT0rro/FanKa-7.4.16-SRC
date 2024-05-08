package io.microshow.rxffmpeg;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RxFFmpegInvoke {
    public static final String TAG = "RxFFmpegInvoke";
    private static volatile RxFFmpegInvoke instance;
    private IFFmpegListener ffmpegListener;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface IFFmpegListener {
        void onCancel();

        void onError(String str);

        void onFinish();

        void onProgress(int i10, long j10);
    }

    static {
        System.loadLibrary("rxffmpeg-core");
        System.loadLibrary("rxffmpeg-invoke");
    }

    private RxFFmpegInvoke() {
    }

    public static RxFFmpegInvoke getInstance() {
        if (instance == null) {
            synchronized (RxFFmpegInvoke.class) {
                if (instance == null) {
                    instance = new RxFFmpegInvoke();
                }
            }
        }
        return instance;
    }

    public native void exit();

    public IFFmpegListener getFFmpegListener() {
        return this.ffmpegListener;
    }

    public native String getMediaInfo(String str);

    public void onCancel() {
        IFFmpegListener iFFmpegListener = this.ffmpegListener;
        if (iFFmpegListener != null) {
            iFFmpegListener.onCancel();
        }
    }

    public void onClean() {
        if (this.ffmpegListener != null) {
            this.ffmpegListener = null;
        }
    }

    public void onDestroy() {
        if (this.ffmpegListener != null) {
            this.ffmpegListener = null;
        }
        if (instance != null) {
            instance = null;
        }
    }

    public void onError(String str) {
        IFFmpegListener iFFmpegListener = this.ffmpegListener;
        if (iFFmpegListener != null) {
            iFFmpegListener.onError(str);
        }
    }

    public void onFinish() {
        IFFmpegListener iFFmpegListener = this.ffmpegListener;
        if (iFFmpegListener != null) {
            iFFmpegListener.onFinish();
        }
    }

    public void onProgress(int i10, long j10) {
        IFFmpegListener iFFmpegListener = this.ffmpegListener;
        if (iFFmpegListener != null) {
            iFFmpegListener.onProgress(i10, j10);
        }
    }

    public int runCommand(String[] strArr, IFFmpegListener iFFmpegListener) {
        int runFFmpegCmd;
        setFFmpegListener(iFFmpegListener);
        synchronized (RxFFmpegInvoke.class) {
            runFFmpegCmd = runFFmpegCmd(strArr);
            onClean();
        }
        return runFFmpegCmd;
    }

    public void runCommandAsync(final String[] strArr, IFFmpegListener iFFmpegListener) {
        setFFmpegListener(iFFmpegListener);
        synchronized (RxFFmpegInvoke.class) {
            new Thread(new Runnable() { // from class: io.microshow.rxffmpeg.RxFFmpegInvoke.1
                @Override // java.lang.Runnable
                public void run() {
                    RxFFmpegInvoke.this.runFFmpegCmd(strArr);
                    RxFFmpegInvoke.this.onClean();
                }
            }).start();
        }
    }

    public Flowable<RxFFmpegProgress> runCommandRxJava(final String[] strArr) {
        return Flowable.create(new FlowableOnSubscribe<RxFFmpegProgress>() { // from class: io.microshow.rxffmpeg.RxFFmpegInvoke.2
            @Override // io.reactivex.FlowableOnSubscribe
            public void subscribe(final FlowableEmitter<RxFFmpegProgress> flowableEmitter) {
                RxFFmpegInvoke.this.setFFmpegListener(new IFFmpegListener() { // from class: io.microshow.rxffmpeg.RxFFmpegInvoke.2.1
                    @Override // io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
                    public void onCancel() {
                        flowableEmitter.onNext(new RxFFmpegProgress(RxFFmpegSubscriber.STATE_CANCEL));
                    }

                    @Override // io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
                    public void onError(String str) {
                        flowableEmitter.onError(new Throwable(str));
                    }

                    @Override // io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
                    public void onFinish() {
                        flowableEmitter.onComplete();
                    }

                    @Override // io.microshow.rxffmpeg.RxFFmpegInvoke.IFFmpegListener
                    public void onProgress(int i10, long j10) {
                        flowableEmitter.onNext(new RxFFmpegProgress(RxFFmpegSubscriber.STATE_PROGRESS, i10, j10));
                    }
                });
                RxFFmpegInvoke.this.runFFmpegCmd(strArr);
                RxFFmpegInvoke.this.onClean();
            }
        }, BackpressureStrategy.BUFFER).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public native int runFFmpegCmd(String[] strArr);

    public native void setDebug(boolean z10);

    public void setFFmpegListener(IFFmpegListener iFFmpegListener) {
        this.ffmpegListener = iFFmpegListener;
    }
}
