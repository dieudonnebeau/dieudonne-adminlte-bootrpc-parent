package com.dieudonne.adminlte.bootrpc.system.consumer.common.shiro.tag;

/**
 * <p>Equivalent to {@link org.apache.shiro.web.tags.LacksRoleTag}</p>
 */
public class LacksRoleTag extends RoleTag {
    protected boolean showTagBody(String roleName) {
        boolean hasRole = getSubject() != null && getSubject().hasRole(roleName);
        return !hasRole;
    }
}
