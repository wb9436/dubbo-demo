package com.wb.dao;

import com.wb.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoDao {

    UserInfoDto getUserById(@Param("userId") int userId);

}
