package com.studentGrade.mapper;

import com.studentGrade.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where id=#{id}")
    public Admin queryStudentById(Admin student);

    @Update("update admin set password=#{password} where id=#{id}")
    public void updateStudentPassword(Admin admin);

    @Select("select * from admin where id=#{id}")
    public Admin queryStudentInfo(Integer id);
}
