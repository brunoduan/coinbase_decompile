package com.coinbase.android.accounts;

import com.coinbase.android.ControllerScope;

@ControllerScope
public interface AccountTransactionsControllerSubcomponent {
    void inject(AccountTransactionsController accountTransactionsController);
}
