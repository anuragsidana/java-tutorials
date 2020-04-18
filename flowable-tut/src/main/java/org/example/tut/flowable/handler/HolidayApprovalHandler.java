package org.example.tut.flowable.handler;

import lombok.Data;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

@Data
public class HolidayApprovalHandler implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {

        System.out.println("Approved, sending an email");
    }
}
