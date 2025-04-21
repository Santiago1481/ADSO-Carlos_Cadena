package com.Proyect.ModelSecurity.DTO;

public class AssignRolRequest {
    private Long userId;
    private Long rolId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }
}
