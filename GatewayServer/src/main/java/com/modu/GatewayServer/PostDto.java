package com.modu.GatewayServer;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private String username;
    private LocalDateTime updatedAt;

    public PostDto(String title, String content, String username, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.username = username;
        this.updatedAt = updatedAt;
    }
}
