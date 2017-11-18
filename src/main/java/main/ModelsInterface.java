package main;

import models.bikemodel.BikeModel;
import models.bookkeepingmodel.AccountModel;
import models.bookkeepingmodel.LedgerModel;
import models.bookkeepingmodel.TransactionModel;
import models.usermodel.UserModel;

public interface ModelsInterface {

    void setUserModel(UserModel userModel);

    void setBikeModel(BikeModel bikeModel);

    void setAccountModel(AccountModel accountModel);

    void setTransactionModel(TransactionModel transactionModel);

    void setLedgerModel(LedgerModel ledgerModel);
}
