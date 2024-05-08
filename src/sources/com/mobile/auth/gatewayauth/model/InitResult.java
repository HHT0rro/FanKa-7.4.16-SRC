package com.mobile.auth.gatewayauth.model;

import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class InitResult {
    public static final int NO_READ_PHONE_STATE_PERMISSION = -2;
    public static final int READ_SUCCESS = 0;
    public static final int SIM_NO_DATA = -1;
    private boolean can4GAuth;
    private String simPhoneNumber;
    private int simPhoneNumberRetCode;

    public String getSimPhoneNumber() {
        try {
            return this.simPhoneNumber;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public int getSimPhoneNumberRetCode() {
        try {
            return this.simPhoneNumberRetCode;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
    }

    public boolean isCan4GAuth() {
        try {
            return this.can4GAuth;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void setCan4GAuth(boolean z10) {
        try {
            this.can4GAuth = z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setSimPhoneNumber(String str) {
        try {
            this.simPhoneNumber = str;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setSimPhoneNumberRetCode(int i10) {
        try {
            this.simPhoneNumberRetCode = i10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public String toString() {
        try {
            return "InitResult{, simPhoneNumber='" + this.simPhoneNumber + "', simPhoneNumberRetCode='" + this.simPhoneNumberRetCode + "', can4GAuth='" + this.can4GAuth + "'}";
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }
}
