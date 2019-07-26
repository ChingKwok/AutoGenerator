package com.chingkwok.service;


import com.chingkwok.bean.dto.UserDTO;
import com.chingkwok.bean.dto.UserDeleteDTO;
import com.chingkwok.bean.dto.UserSearchDTO;
import com.chingkwok.bean.entity.User;
import com.chingkwok.bean.vo.UserVO;
import com.chingkwok.utils.PagedResult;
import com.common.service.BaseService;

public interface UserService extends BaseService<User> {
    /**
    * 获取
    * @param UserDTO
    * @return UserVO
    */
    UserVO getUser(Long userId);

    /**
    * 新增
    * @param UserDTO UserDTO
    * @return UserVO
    */
    UserVO insertUser(UserDTO userDTO);

    /**
    * 更新
    * @param UserDTO UserDTO
    * @return UserVO
    */
    UserVO updateUser(UserDTO userDTO);

    /**
    * 删除
    * @param UserDeleteDTO UserDeleteDTO
    * @return int
    */
    int deleteUser(UserDeleteDTO userDeleteDTO);

    /**
    * 查询列表
    * @param map
    * @return PageResult<UserVO>
    */
    PagedResult<UserVO> searchUser(UserSearchDTO userSearchDTO);
}