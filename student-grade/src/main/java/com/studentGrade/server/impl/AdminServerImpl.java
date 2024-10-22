package com.studentGrade.server.impl;

import com.studentGrade.entity.Admin;
import com.studentGrade.mapper.AdminMapper;
import com.studentGrade.server.AdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServerImpl implements AdminServer {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin queryAdminById(Admin admin) {
        return adminMapper.queryStudentById(admin);
    }

    @Override
    public void updatePasswordByAdminId(Admin admin) {
        adminMapper.updateStudentPassword(admin);
    }

    @Override
    public Admin getAdminInfo(Integer id) {
        return adminMapper.queryStudentInfo(id);
    }
}
