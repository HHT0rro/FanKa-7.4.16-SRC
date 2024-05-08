package com.wangmai.common.utils;

import android.os.Handler;
import android.os.Message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HandlerUtil {
    public static final String TAG = "HandlerUtil";
    public static volatile HandlerUtil handlerUtil;
    public ITick iTick;
    public long interval;
    public final int MSG_WHAT = 1;
    public boolean isRemove = false;
    public Handler handler = new Handler(new Handler.Callback() { // from class: com.wangmai.common.utils.HandlerUtil.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            if (HandlerUtil.this.isRemove) {
                DebugLog.W(HandlerUtil.TAG, "isRemove true");
                HandlerUtil.this.handler.removeCallbacksAndMessages(null);
                return false;
            }
            if (HandlerUtil.this.iTick != null) {
                HandlerUtil.this.iTick.onTick();
            }
            HandlerUtil.this.handler.sendEmptyMessageDelayed(1, HandlerUtil.this.interval);
            return false;
        }
    });

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ITick {
        void onTick();
    }

    public static HandlerUtil getInstance() {
        if (handlerUtil == null) {
            synchronized (HandlerUtil.class) {
                if (handlerUtil == null) {
                    handlerUtil = new HandlerUtil();
                }
            }
        }
        return handlerUtil;
    }

    public void removeMessage() {
        Handler handler = this.handler;
        if (handler != null) {
            this.isRemove = true;
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void sendMessage(long j10, ITick iTick) {
        this.iTick = iTick;
        this.interval = j10;
        this.isRemove = false;
        this.handler.sendEmptyMessage(1);
    }
}
