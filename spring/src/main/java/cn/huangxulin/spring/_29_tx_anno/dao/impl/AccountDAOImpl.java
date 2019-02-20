package cn.huangxulin.spring._29_tx_anno.dao.impl;

import cn.huangxulin.spring._29_tx_anno.dao.IAccountDAO;
import cn.huangxulin.spring._29_tx_anno.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
@Repository
public class AccountDAOImpl implements IAccountDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void transOut(Long outId, int money) {
        jdbcTemplate.update("UPDATE account SET balance = balance - ? WHERE id = ?", money, outId);
    }

    @Override
    public void transIn(Long inId, int money) {
        jdbcTemplate.update("UPDATE account SET balance = balance + ? WHERE id = ?", money, inId);
    }

    @Override
    public List<Account> listAll() {
        return jdbcTemplate.query("SELECT `id`, `balance` FROM account", new Object[]{}, (rs, i) -> {
            Account account = new Account();
            account.setId(rs.getLong("id"));
            account.setBalance(rs.getInt("balance"));
            return account;
        });
    }
}
