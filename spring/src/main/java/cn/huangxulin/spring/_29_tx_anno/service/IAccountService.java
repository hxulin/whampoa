package cn.huangxulin.spring._29_tx_anno.service;

import cn.huangxulin.spring._29_tx_anno.domain.Account;

import java.util.List;

public interface IAccountService {

    /**
     * 从指定账户转出指定金额给另一个账户
     */
    void trans(Long outId, Long inId, int money);

    /**
     * 查询所有账户信息
     */
    List<Account> listAll();
}
