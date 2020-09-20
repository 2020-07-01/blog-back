package admin.entity;

import java.util.Date;

/**
 * @ClassName : RoleInfo
 * @Author : yq
 * @Date: 2020-09-20
 * @Description : 角色和权限列表
 */
public class RoleInfo {

    private Integer id;

    private String roleName;

    private String roleAuth;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleAuth() {
        return roleAuth;
    }

    public void setRoleAuth(String roleAuth) {
        this.roleAuth = roleAuth == null ? null : roleAuth.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
