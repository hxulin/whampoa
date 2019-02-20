package cn.huangxulin.spring._29_tx_anno.service.impl;

import cn.huangxulin.spring._29_tx_anno.dao.IAccountDAO;
import cn.huangxulin.spring._29_tx_anno.domain.Account;
import cn.huangxulin.spring._29_tx_anno.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDAO dao;

    @Override
    public void trans(Long outId, Long inId, int money) {
        dao.transOut(outId, money);
        int i = 1 / 0;  // 模拟抛出异常
        dao.transIn(inId, money);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Account> listAll() {
        return dao.listAll();
    }
}
