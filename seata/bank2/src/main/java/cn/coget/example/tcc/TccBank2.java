package cn.coget.example.tcc;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface TccBank2 {
    
    @TwoPhaseBusinessAction(name = "TccBank1#transfer", commitMethod = "commit", rollbackMethod = "rollback")
    String transfer(BusinessActionContext context,
                    @BusinessActionContextParameter("accountNo") String accountNo,
                    @BusinessActionContextParameter("amount") Double amount);
    
    Boolean commit(BusinessActionContext context);

    Boolean rollback(BusinessActionContext context);
}
