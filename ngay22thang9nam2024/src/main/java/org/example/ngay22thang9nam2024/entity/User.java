package org.example.ngay22thang9nam2024.entity;

import java.time.LocalDateTime;

public class User {
    private String username ;
    private String password ;
    private int status ;
    private LocalDateTime createdDate ;

    public User() {
    }

    public User(String username, String password, int status, LocalDateTime createdDate) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.createdDate = createdDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createdDate=" + createdDate +
                '}';
    }
}
