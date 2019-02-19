package cn.huangxulin.spring._28_tx_xml.dao.impl;

import cn.huangxulin.spring._28_tx_xml.dao.IAccountDAO;
import cn.huangxulin.spring._28_tx_xml.domain.Account;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * 功能描述:
 *
 * @author hxulin
 */
public class AccountDAOImpl implements IAccountDAO {

    private JdbcTemplate jdbcTemplate;

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
