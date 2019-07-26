package com.chingkwok.service.Impl;

import com.chingkwok.bean.dto.UserDTO;
import com.chingkwok.bean.dto.UserDeleteDTO;
import com.chingkwok.bean.dto.UserSearchDTO;
import com.chingkwok.bean.entity.User;
import com.chingkwok.bean.vo.UserVO;
import com.chingkwok.exception.AutoGeneratorException;
import com.chingkwok.exception.eum.AutoGeneratorExceptionEnum;
import com.chingkwok.service.UserService;
import com.chingkwok.utils.PagedResult;
import com.common.service.Impl.BaseServerImpl;
import org.springframework.stereotype.Service;

/**
 * Created by guojingye on 2019/7/17
 */
@Service
public class UserServiceImpl extends BaseServerImpl<User> implements UserService {


    @Override
    public UserVO getUser(Long userId) {
        User user = selectByPrimaryKey(userId);
        if (user != null) {
            return convert(user, UserVO.class);
        } else {
            throw new AutoGeneratorException(AutoGeneratorExceptionEnum.RECORD_NOT_EXISTS);
        }
    }

    @Override
    public UserVO insertUser(UserDTO userDTO) {
        User user = convert(userDTO, User.class);
        int result = insertSelective(user, User::setUserId);
        if (result > 0) {
            return convert(user, UserVO.class);
        }
        throw new AutoGeneratorException(AutoGeneratorExceptionEnum.ADD_FAILURE);
    }

    @Override
    public UserVO updateUser(UserDTO userDTO) {
        User user = convert(userDTO, User.class);
        int result = updateByPrimaryKeySelective(user);
        if (result > 0) {
            return convert(user, UserVO.class);
        }
        throw new AutoGeneratorException(AutoGeneratorExceptionEnum.UPDATE_FAILURE);
    }

    @Override
    public int deleteUser(UserDeleteDTO userDeleteDTO) {
        int result = deleteByPrimaryKey(userDeleteDTO.getUserId());
        if (result > 0) {
            return result;
        }
        throw new AutoGeneratorException(AutoGeneratorExceptionEnum.DELETE_FAILURE);
    }

    @Override
    public PagedResult<UserVO> searchUser(UserSearchDTO userSearchDTO) {
        return null;
    }
}
