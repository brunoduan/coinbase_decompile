package com.coinbase.android.transfers;

import rx.functions.Action1;

final /* synthetic */ class SendPresenter$$Lambda$7 implements Action1 {
    private final SendPresenter arg$1;

    private SendPresenter$$Lambda$7(SendPresenter sendPresenter) {
        this.arg$1 = sendPresenter;
    }

    public static Action1 lambdaFactory$(SendPresenter sendPresenter) {
        return new SendPresenter$$Lambda$7(sendPresenter);
    }

    public void call(Object obj) {
        this.arg$1.mLogger.error("Error subscribing to NumericKeypadConnector.KeypadType.LEFT for getButtonClickedSubject()");
    }
}
