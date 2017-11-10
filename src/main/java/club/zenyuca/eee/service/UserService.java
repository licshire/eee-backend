package club.zenyuca.eee.service;

import club.zenyuca.core.beans.Result;
import club.zenyuca.core.template.BaseService;
import club.zenyuca.eee.beans.User;

public interface UserService extends BaseService<User, Integer> {
    public Result login(User user);
}