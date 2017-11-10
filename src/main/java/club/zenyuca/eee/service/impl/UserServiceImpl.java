package club.zenyuca.eee.service.impl;

import club.zenyuca.core.beans.Result;
import club.zenyuca.core.enums.ResultEnum;
import club.zenyuca.core.exception.EeeException;
import club.zenyuca.core.util.ResultUtil;
import club.zenyuca.eee.beans.User;
import club.zenyuca.eee.mapper.UserMapper;
import club.zenyuca.eee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insert(User model) {
        model.setCreateTime(new Date());
        return this.userMapper.insert(model);
    }

    @Override
    public boolean delete(Integer modelPK) {
        return this.userMapper.delete(modelPK) == 1;
    }

    @Override
    public User load(User model) {
        return this.userMapper.load(model);
    }

    @Override
    public boolean update(User model) {
        return this.userMapper.update(model) == 1;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public List<User> findAll(User model) {
        return this.userMapper.findAll(model);
    }

    @Override
    public List<User> listPage(User model) {
        return this.userMapper.listPage(model);
    }

    @Override
    public User loadByPK(Integer modelPK) {
        return this.userMapper.loadByPK(modelPK);
    }

    @Override
    public boolean insertORupdate(User model) {
        User dbBean = this.loadByPK(model.getId());
        if (dbBean == null) {
            return this.insert(model) == 1;
        } else {
            return this.update(model);
        }
    }

    @Override
    public Result login(User user) {
        User dbUser = null;
        User param = new User();
        param.setName(user.getName());
        param.setPwd(user.getPwd());
        dbUser = this.load(param);
        if (dbUser == null) {
            throw new EeeException(ResultEnum.用户名或密码错误);
        }
        Date now = new Date();
        dbUser.setLoginTime(now);
        dbUser.setUpdateTime(now);
        dbUser.setLoginIP(user.getLoginIP());
        this.update(dbUser);
        return ResultUtil.success(dbUser);
    }
}