package main;

import models.bike.BikeModel;
import models.bookkeeping.AccountModel;
import models.bookkeeping.LedgerModel;
import models.bookkeeping.TransactionModel;
import models.user.UserModel;

public interface ModelsInterface {

    void setUserModel(UserModel userModel);

    void setBikeModel(BikeModel bikeModel);

    void setAccountModel(AccountModel accountModel);

    void setTransactionModel(TransactionModel transactionModel);

    void setLedgerModel(LedgerModel ledgerModel);
}
