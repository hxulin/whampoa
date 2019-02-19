package cn.huangxulin.spring._28_tx_xml.dao;

import cn.huangxulin.spring._28_tx_xml.domain.Account;

import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public interface IAccountDAO {

    /**
     * 从指定账户转出多少钱
     */
    void transOut(Long outId, int money);

    /**
     * 从指定账户转入多少钱
     */
    void transIn(Long inId, int money);

    /**
     * 查询所有账户信息
     */
    List<Account> listAll();
}
