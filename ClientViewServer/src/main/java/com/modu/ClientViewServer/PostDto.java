package com.modu.ClientViewServer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private String username;
    private LocalDateTime updatedAt;
}
