package com.team_soop.soop.dto;

import com.team_soop.soop.entity.FeedComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveFeedCommentReqDto {
    private int feedId;
    private int commentUserId;
    private String commentContent;


    public FeedComment toFeedComment () {
        return FeedComment.builder()
                .feedId(feedId)
                .feedCommentUserId(commentUserId)
                .feedCommentContent(commentContent)
                .build();
    }
}
