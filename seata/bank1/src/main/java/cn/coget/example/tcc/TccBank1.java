package cn.coget.example.tcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface TccBank1 {
    
    @TwoPhaseBusinessAction(name = "TccBank1#transfer", commitMethod = "commit", rollbackMethod = "rollback")
    String transfer(@BusinessActionContextParameter("accountNo") String accountNo,
                    @BusinessActionContextParameter("amount") Double amount);

    Boolean commit(BusinessActionContext context);

    Boolean rollback(BusinessActionContext context);
}
