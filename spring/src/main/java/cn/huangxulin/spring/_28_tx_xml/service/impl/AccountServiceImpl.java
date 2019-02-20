package cn.huangxulin.spring._28_tx_xml.service.impl;

import cn.huangxulin.spring._28_tx_xml.dao.IAccountDAO;
import cn.huangxulin.spring._28_tx_xml.domain.Account;
import cn.huangxulin.spring._28_tx_xml.service.IAccountService;

import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDAO dao;

    public void setDao(IAccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public void trans(Long outId, Long inId, int money) {
        dao.transOut(outId, money);
        int i = 1 / 0;  // 模拟抛出异常
        dao.transIn(inId, money);
    }

    @Override
    public List<Account> listAll() {
        return dao.listAll();
    }
}
