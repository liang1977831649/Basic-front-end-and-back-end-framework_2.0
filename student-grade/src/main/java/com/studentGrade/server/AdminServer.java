package com.studentGrade.server;

import com.studentGrade.entity.Admin;

public interface AdminServer {
    public Admin queryAdminById(Admin admin);
    public void  updatePasswordByAdminId(Admin admin);

    public Admin getAdminInfo(Integer id);
}
