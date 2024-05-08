package com.koushikdutta.quack;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface QuackPromise {
    @QuackMethodName(name = "catch")
    QuackPromise caught(QuackPromiseReceiver quackPromiseReceiver);

    QuackPromise then(QuackPromiseReceiver quackPromiseReceiver);
}
