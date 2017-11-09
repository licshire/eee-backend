package club.zenyuca.eee.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zenyuca.eee.beans.User;
import club.zenyuca.eee.mapper.UserMapper;
import club.zenyuca.eee.service.UserService;

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

}