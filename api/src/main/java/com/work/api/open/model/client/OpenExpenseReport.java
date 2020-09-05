package com.work.api.open.model.client;

import com.http.network.model.ClientModel;

import java.util.List;

/**
 * Created by Administrator on 2019/4/19
 * Description
 */

public class OpenExpenseReport extends ClientModel {

    /**
     * payable : 0.00
     * paid : 0.00
     * uncollected : 560.00
     * name : 订单收入
     * received : 0.00
     * receivable : 560.00
     * unpaid : 0.00
     * profit : 560.00
     */

    private String payable;
    private String paid;
    private String uncollected;
    private String name;
    private String received;
    private String receivable;
    private String unpaid;
    private String profit;

    private List<String> expenseTypes;
    private List<String> expenseAmounts;

    public List<String> getExpenseTypes() {
        return expenseTypes;
    }

    public void setExpenseTypes(List<String> expenseTypes) {
        this.expenseTypes = expenseTypes;
    }

    public List<String> getExpenseAmounts() {
        return expenseAmounts;
    }

    public void setExpenseAmounts(List<String> expenseAmounts) {
        this.expenseAmounts = expenseAmounts;
    }

    public String getPayable() {
        return payable;
    }

    public void setPayable(String payable) {
        this.payable = payable;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getUncollected() {
        return uncollected;
    }

    public void setUncollected(String uncollected) {
        this.uncollected = uncollected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getReceivable() {
        return receivable;
    }

    public void setReceivable(String receivable) {
        this.receivable = receivable;
    }

    public String getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(String unpaid) {
        this.unpaid = unpaid;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }
}
